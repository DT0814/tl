pragma solidity ^0.4.10;

contract Integral{
    enum reason {reward,punishment}
    struct tokenChange {
        uint ChangeHistoryID; //历史记录id
        uint From;	//转账人ID
        uint To; //收款人ID
	    uint Value; //积分数量
	    uint Time; //时间    换成Ｌｏｎｇ类型
	    reason Reason; //现在暂时不定义一个枚举类型，以后可以在枚举类型中定义所有的reason，不包含在内的将视为不规范
    	string Info; //此为附加信息，可包括url、商品信息等
        uint AllValues;  //总积分 
    }
    struct user { //用户信息暂时就这么简洁，之后有需要可随时增加，其中用户的积分信息因为随时可能变化，只能通过查询获得
        uint ID; //用户id，由外面传进来
        string Name;
        uint TokenAllValues; //用户积分余额
        uint TokenChangeNumber; //积分变化次数
        mapping (uint => tokenChange) TokenChangeList;
    }
    
    mapping(uint => user) User;
    mapping(uint => byte) tran;
    event TestUser(uint ID,string Name,uint TokenAllValues);//事件
    event TestTokenTran(uint From,uint To,uint Value);
    
    //创建用户并初始化 
    function userInit(uint ID,string Name) public returns(uint){
        User[ID] = user(ID,Name,0,1);
    	TestUser(ID,Name,User[ID].TokenAllValues);
    	return 0;
    }
    
	//修改用户信息
    function userInfoChange(uint ID,string newName) public returns(uint){
        User[ID] = user(ID,newName,User[ID].TokenAllValues,User[ID].TokenChangeNumber);
        return 1;
    }
    //查询积分  输入用户id 
    function tokenQuery(uint ID) public constant returns(uint){
        uint myValue = User[ID].TokenAllValues;
		return myValue;
    }

    //积分增加
	function tokenAdd(uint ChangeHistoryID,uint From,uint To,uint Value,uint Time,uint AllValue,reason Reason,string Info) private returns(uint){
        uint ChangeID = ChangeHistoryID;
        User[To].TokenChangeList[ChangeID] = tokenChange(ChangeID,From,To,Value,Time,Reason,Info,AllValue+Value);
		User[To].TokenAllValues += Value;
		User[To].TokenChangeNumber = ChangeID;
        return ChangeID;
    }
    //积分减少
    function tokenSub(uint ChangeHistoryID,uint From,uint To,uint Value,uint Time,uint AllValue,reason Reason,string Info) private returns(uint){
        uint ChangeID = ChangeHistoryID;
        User[From].TokenChangeList[ChangeID] = tokenChange(ChangeID,From,To,Value,Time,Reason,Info,AllValue+Value);
		User[From].TokenAllValues -= Value;
		User[From].TokenChangeNumber = ChangeID;
        return ChangeID;
    }
    //积分交换
    function tokenTran(uint From,uint To,uint Value,uint Time,reason Reason,string Info) public returns(uint){
        uint FromTokenValue = tokenQuery(From);
        uint ToTokenValue = tokenQuery(To);
        uint FromTokenHistoryID = User[From].TokenChangeNumber+1;
        uint ToTokenHistoryID = User[To].TokenChangeNumber+1;
        if(FromTokenValue < Value)
            return 1;
        tokenAdd(FromTokenHistoryID,From,To,Value,Time,FromTokenValue,Reason,Info);
        TestTokenTran(From,To,Value);
        tokenSub(ToTokenHistoryID,From,To,Value,Time,ToTokenValue,Reason,Info);
            return 0;
    }
    //积分更新
    function tokenUpdate(uint ID,uint Value,uint Time,reason Reason) public returns(uint){
        uint TokenValue = tokenQuery(ID);
        uint TokenHistoryID = User[ID].TokenChangeNumber+1;
        if(Reason == reason.reward)
            tokenAdd(TokenHistoryID,0,ID,Value,Time,TokenValue,Reason,"Info");
        else if(Reason == reason.punishment){
            if(TokenValue < Value)
                return 1;
            tokenSub(TokenHistoryID,ID,0,Value,Time,TokenValue,Reason,"Info");
        }
        else
            return 1;
        return 0;
    }
    function strConcat(string _a, string _b) public returns (string){
        bytes memory _ba = bytes(_a);
        bytes memory _bb = bytes(_b);
        string memory ret = new string(_ba.length + _bb.length);
        bytes memory bret = bytes(ret);
        uint k = 0;
        for (uint i = 0; i < _ba.length; i++)bret[k++] = _ba[i];
        for (i = 0; i < _bb.length; i++) bret[k++] = _bb[i];
        return string(ret);
   }  
   //uintTOstr
   

   function uintTOstr(uint m) public returns (string){
       tran[0] = '0';tran[1] = '1';tran[2] = '2';tran[3] = '3';tran[4] = '4';tran[5] = '5';tran[6] = '6';tran[7] = '7';tran[8] = '8';tran[9] = '9';
       uint [] memory e = new uint [](10);
       uint i = 0;
      while(m > 0){
         e[i++] = m % 10;
          m = m/10;
      }
      string memory ret = new string(i);
      bytes memory bret = bytes(ret);
      uint k = 0;
      while(i > 0){
            bret[k++] = tran[e[--i]];
            
      }
        return string(ret);
   }

/*    function uintTOstr1(uint256 x) public returns (bytes b) {
    b = new bytes(32);
    assembly { mstore(add(b, 32), x) }
    //return string(b);
    }
*/
   //json拼接
//积分历史记录查询，改动为while中<后面加了=，测试时可先根据输出看哪里出错
   function jsonConcat(uint ID,uint FromTime,uint ToTime) constant returns (string){
       string memory json = "Value:[";
       string memory j1 = "'Id':'";
       string memory j2 = "'Value':'";
       string memory j3 = "'Reason':'";
       string memory j4 = "'Time':'";
       uint i=1;
       uint k = ID;
       uint number = User[k].TokenChangeNumber;
       while(i <= number && User[k].TokenChangeList[i].Time>=FromTime && User[k].TokenChangeList[i].Time<=ToTime){
            json = strConcat(json,strConcat(strConcat(strConcat("{",j1),uintTOstr(k)),"',"));
            json = strConcat(json,strConcat(strConcat(j2,uintTOstr(User[k].TokenChangeList[i].Value)),"',"));
            json = strConcat(json,strConcat(strConcat(j3,uintTOstr(User[k].TokenChangeList[i].Time)),"',"));
            json = strConcat(json,strConcat(strConcat(j4,uintTOstr(User[k].TokenChangeList[i].Time)),"'},"));
            i++;
       }
       json = jsonsSmplify(json);
        return json;
   }
  //
   function jsonsSmplify(string json) public returns (string){
   bytes memory json1 = bytes(json);
        string memory ret = new string(json1.length - 1);
        bytes memory bret = bytes(ret);
        uint p = 0;
        for (uint q = 0; q < json1.length - 1; q++)bret[p++] = json1[q];
       ret = strConcat(ret,"]");
       return string(ret);
   }
   
}

