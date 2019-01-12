package cn.xdlr.tl.controller;

import cn.xdlr.tl.pojo.User;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.service.UserService;
import cn.xdlr.tl.service.UserTokenService;

import cn.xdlr.tl.utils.Base64ImageUtils;
import cn.xdlr.tl.utils.GlobalVariable;
import cn.xdlr.tl.utils.ResultCode;
import cn.xdlr.tl.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController()
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;
    private final static String uploadPath = "images/";
    @Autowired
    private UserTokenService userTokenService;

    @GetMapping("init")
    public SimpleResult init(String uid, String uinfo) {
        System.out.println("==========do it==================");
        if (StringUtil.isEmpty(uid) || StringUtil.isEmpty(uinfo)) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        return service.init(uid, uinfo);
    }

    @GetMapping("update")
    public SimpleResult update(String uid, String uinfo) {
        if (StringUtil.isEmpty(uid) || StringUtil.isEmpty(uinfo)) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        return service.updateUinfo(uid, uinfo);
    }

    @PostMapping("VenderUseToken")
    public SimpleResult venderUseToken(@RequestParam(name = "Uid") String uid,
                                       @RequestParam(name = "Value") Integer value,
                                       @RequestParam(name = "Onumber") String oNumber) {
        if (StringUtil.isEmpty(uid) || null == value || StringUtil.isEmpty(oNumber)) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        return userTokenService.venderUseToken(uid, value, oNumber);
    }

    @PostMapping("PutUserState")
    public SimpleResult PutUserState(@RequestParam(name = "Uid") String uid
            , @RequestParam(name = "Ustate") String state, @RequestParam(name = "Uimage") String base64Img
            , @RequestParam(name = "Utime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date time) {
        User user = new User(uid);
        System.out.println(uid);
        System.out.println(state);
        System.out.println(base64Img.length());
        base64Img = base64Img.replaceAll(" ", "+");
        System.out.println(base64Img);
        switch (state) {
            case "ENTRANCE":
                if (service.exist(user.getUid())) {
                    user.setInTime(time);
                    user.setState(1);
                    service.update(user);
                } else {
                    service.init(user.getUid(),
                            "",
                            GlobalVariable.INIT_TOKEN,
                            Base64ToImg(base64Img, user.getUid()),
                            time,
                            null,
                            1);
                }
                break;
            case "EXPORT":
                if (service.exist(user.getUid())) {
                    service.parkTimeAward(user.getUid(), time);
                } else {
                    service.init(user.getUid(),
                            "",
                            GlobalVariable.INIT_TOKEN,
                            Base64ToImg(base64Img, user.getUid()),
                            null,
                            time,
                            2);
                }
                break;
            case "VENDING_MACHINE":
                if (!service.exist(user.getUid())) {
                    service.init(user.getUid(),
                            "",
                            GlobalVariable.INIT_TOKEN,
                            Base64ToImg(base64Img, user.getUid()),
                            time,
                            null,
                            3);
                }
                // TODO 这里要增加售货机部分的逻辑
                break;
            case "EXTRA_QUERY":
                User sendUser = null;
                if (!service.exist(user.getUid())) {
                    sendUser = new User(user.getUid(),
                            "",GlobalVariable.INIT_TOKEN,
                            time,
                            null,
                            4,
                            Base64ToImg(base64Img, user.getUid()));
                    service.init(user.getUid(),
                            "",
                            GlobalVariable.INIT_TOKEN,
                            Base64ToImg(base64Img, user.getUid()),
                            time,
                            null,
                            4);
                } else {
                    sendUser = service.getOneById(user.getUid());
                    sendUser.setState(4);
                }
                service.update(sendUser);
                String param = sendUser.toString();
                // TODO 展示方http接口
                String url = "";
//                String putData = new HttpsUtils().doPost(param, url);
//                System.out.println(putData);
                break;
            default:
                break;
        }
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    private String Base64ToImg(String base64, String uid) {
        String path = uploadPath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + uid + ".jpg";
        Base64ImageUtils.Base64ToImage(base64, path);
        return path;
    }
}
