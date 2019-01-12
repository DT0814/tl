package cn.xdlr.tl.bcosliteClient;

import org.bcos.channel.client.Service;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.crypto.ECKeyPair;
import org.bcos.web3j.crypto.Keys;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.bcos.web3j.protocol.core.methods.response.EthBlockNumber;
import org.bcos.web3j.protocol.core.methods.response.Log;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class BcosClient {
    static Logger logger = LoggerFactory.getLogger(BcosClient.class);
    private static Web3j web3j;
    private BigInteger gasPrice = new BigInteger("1");
    private BigInteger gasLimit = new BigInteger("30000000");
    private BigInteger initialWeiValue = new BigInteger("0");
    private ECKeyPair keyPair;
    private Credentials credentials;
    public static final String contractAddress = "0x4fa9058be74c19ccd787144e7b5e0a0a67ba7c7c";

    public BcosClient() throws Exception {
        loadConfig();
    }

    private synchronized void loadConfig() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Service service = context.getBean(Service.class);
        service.run();
        // init the client keys
        keyPair = Keys.createEcKeyPair();
        credentials = Credentials.create(keyPair);
        ChannelEthereumService channelEthereumService = new ChannelEthereumService();
        channelEthereumService.setChannelService(service);
        // init webj client base on channelEthereumService
        web3j = Web3j.build(channelEthereumService);
    }

    // TODO  增加一个初始化积分额的参数　int token
    public boolean userInit(Long id, String username) throws Exception {
        // 初始积分
        final int value = 100;
        // 表示增加积分操作
        final int add = 1;

        if (web3j == null) {
            return false;
        }
        logger.info("user init");
        //TransactionReceipt test_user1 = null;
        Integral integral = Integral.load(contractAddress, web3j, credentials, gasPrice, gasLimit);
        Future<TransactionReceipt> user = integral.userInit(new Uint256(id), new Utf8String(username));
        logger.info(username + "'s id is:" + id + " ,This TransactionHash is:" + user.get().getBlockHash());
        TransactionReceipt receipt = user.get();
        List<Integral.TestUserEventResponse> result = integral.getTestUserEvents(receipt);
        if (result.size() == 0) {
            logger.info("user init failed");
            return false;
        }
        // 设置初始用户积分为１００
        tokenUpdate(id, value, new Date().getTime(), add);
        logger.info("test1.size() :" + result.size());
        for (Integral.TestUserEventResponse response : result) {
            logger.info("User's ID is :" + response.ID.getValue() + ",NAME is :" + response.Name.getValue() +
                    ", TotalVaule is :" + response.TokenAllValues.getValue());
        }
        logger.info("user init successful!");
        return true;
    }

    // 积分查询
    public BigInteger tokenQuery(Long id) throws Exception {
        if (web3j == null) {
            return null;
        }
        logger.info("积分查询");
        //TransactionReceipt test_query = null;
        Integral integral = Integral.load(contractAddress, web3j, credentials, gasPrice, gasLimit);
        BigInteger val = integral.tokenQuery(new Uint256(id)).get().getValue();
        logger.info("积分是： " + val);
        return val;
    }

    //积分交换
    public synchronized boolean tokenTran(Long from, Long to, int value, Long time, int reason, String info) throws Exception {
        if (web3j == null || reason < 0 || reason > 1) {
            return false;
        }
        logger.info("---------------------积分交换-------------------------------");
        Integral integral = Integral.load(contractAddress, web3j, credentials, gasPrice, gasLimit);
        Future<TransactionReceipt> token = integral.tokenTran(
                new Uint256(from), new Uint256(to), new Uint256(value),
                new Uint256(time), new Uint8(reason), new Utf8String(info));
        //String transaction = web3.eth.getTransactionFromBlock('0x22',1);
        //EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        //int startBlockNumber  =ethBlockNumber.getBlockNumber().intValue();
        //logger.info("-->Got ethBlockNumber:{}", startBlockNumber);
        TransactionReceipt receipt = token.get();
        List<Integral.TestTokenTranEventResponse> responses = integral.getTestTokenTranEvents(receipt);

        if (responses.size() == 0)
            return false;
        return true;

    }

    //积分历史记录 re:0--up   1--down
    public Boolean tokenHistory(Long id, Long fromtime, Long totime) throws Exception {
        if (web3j == null) {
            return false;
        }
        logger.info("---------------------历史查询-------------------------------");
        //Future<TransactionReceipt> futureSetname = counter.setname(new Utf8String(sval.getValue()));
        Integral integral = Integral.load(contractAddress, web3j, credentials, gasPrice, gasLimit);
        Future<Utf8String> futureUpdate = integral.jsonConcat(new Uint256(id), new Uint256(fromtime), new Uint256(totime));
        ///查询积分
        System.out.println(futureUpdate.get().getValue());
        return true;
    }

    // 积分更新
    public Boolean tokenUpdate(Long id, int value, Long time, int re) throws Exception {
        if (web3j == null || re < 0 || re > 1) {
            return false;
        }
        logger.info("---------------------积分更新-------------------------------");
        //Future<TransactionReceipt> futureSetname = counter.setname(new Utf8String(sval.getValue()));
        Integral integral = Integral.load(contractAddress, web3j, credentials, gasPrice, gasLimit);
        Future<TransactionReceipt> futureUpdate = integral.tokenUpdate(new Uint256(id), new Uint256(value), new Uint256(time), new Uint8(re));
//        TransactionReceipt test_up = futureUpdate.get();
        ///查询积分
        BigInteger val = integral.tokenQuery(new Uint256(id)).get().getValue();
        logger.info(id + " 's vaule is:" + val);
        if (val == null) {
            return false;
        }
        return true;
    }

    public int getBlockHeight() throws Exception {
        EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        return ethBlockNumber.getBlockNumber().intValue();
    }


    public String deployCounter() throws InterruptedException, ExecutionException {
        Future<Counter> futureDeploy = Counter.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue);
        Counter counter = futureDeploy.get();
        String contractAddress = counter.getContractAddress();
        counter.getContractName();
        System.out.println("Deploy contract :" + counter.getContractName() + ",address :" + contractAddress);
        return contractAddress;
    }

    public void testCounter(String contractAddr) throws InterruptedException, ExecutionException {
        Counter counter = Counter.load(contractAddr, web3j, credentials, gasPrice, gasLimit);
        // get current counter value
        BigInteger val = counter.getcount().get().getValue();
        System.out.println("counter value before transaction:" + val);
        Uint256 ival = new Uint256(100);
        Utf8String sval = new Utf8String("MyCounter from:" + val.intValue() + ",inc:" + ival.getValue());
        // send setname and add counter transaction at the same time
        Future<TransactionReceipt> futureSetname = counter.setname(new Utf8String(sval.getValue()));
        Utf8String memo = new Utf8String("when tx done,counter inc " + ival.getValue().intValue());
        Future<TransactionReceipt> futureAddCount = counter.addcount(ival, memo);

        // waiting for new block
        TransactionReceipt receiptSetname = futureSetname.get();
        TransactionReceipt receiptAddAcount = futureAddCount.get();
        // get current name after transation commit
        String curName = counter.getname().get().getValue();

        /* process setname receipt */
        List<Counter.ChangenameEventResponse> lstCN = counter.getChangenameEvents(receiptSetname);
        for (int i = 0; i < lstCN.size(); i++) {
            Counter.ChangenameEventResponse response = lstCN.get(i);
            System.out.println("setname-->oldname:[" + response.oldname.getValue() + "]," + "newname=[" + curName + "]");
        }

        // get current counter after transaction commit
        BigInteger curCounter = counter.getcount().get().getValue();
        System.out.println("Current Counter:" + curCounter);

        /* process addcount transaction receipt */
        List<Log> lstlog = receiptAddAcount.getLogs();
        List<Counter.CountedEventResponse> listresponse = counter.getCountedEvents(receiptAddAcount);
        for (int i = 0; i < listresponse.size(); i++) {
            Counter.CountedEventResponse response = listresponse.get(i);
            System.out.println("addcount-->inc:" + response.c.getValue() + ",before:" + response.oldvalue.getValue()
                    + ",after:" + response.currvalue.getValue() + ",memo=" + response.memo.getValue());
        }
    }

    public static void main(String[] args) {
        try {
            new BcosClient().userInit(1L,"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
