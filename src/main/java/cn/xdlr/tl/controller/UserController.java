package cn.xdlr.tl.controller;

import cn.xdlr.tl.pojo.User;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.service.UserService;
import cn.xdlr.tl.service.UserTokenService;
import cn.xdlr.tl.utils.Base64ImageUtils;
import cn.xdlr.tl.utils.ResultCode;
import cn.xdlr.tl.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController()
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;
    private final static String uploadPath = "images/";
    @Autowired
    private UserTokenService userTokenService;

    @GetMapping("init")
    public SimpleResult init(Integer uid, String uinfo) {
        if (null == uid || uid <= 0 || StringUtil.isEmpty(uinfo)) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        return service.init(uid, uinfo);
    }

    @GetMapping("update")
    public SimpleResult update(Integer uid, String uinfo) {
        if (null == uid || uid <= 0 || StringUtil.isEmpty(uinfo)) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        return service.updateUinfo(uid, uinfo);
    }

    @PostMapping("PutUserState")
    public SimpleResult PutUserState(@RequestParam(name = "Uid") String uid
            , @RequestParam(name = "Ustate") String state, @RequestParam(name = "Uimage") String base64Img
            , @RequestParam(name = "Utime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date time) {
        Long t1 = System.currentTimeMillis();
        User user = new User(new Integer(uid));
        switch (state) {
            case "入口":
                if (service.exist(user.getUid())) {
                    user.setInTime(time);
                    user.setState(1);
                    service.update(user);
                } else {
                    service.init(user.getUid(), "");
                    user.setInTime(time);
                    user.setState(1);
                    user.setImgPath(Base64ToImg(base64Img, user.getUid()));
                    service.update(user);
                }
                break;
            case "出口":
                if (service.exist(user.getUid())) {
                    service.parkTimeAward(user.getUid(), time);
                } else {
                    service.init(user.getUid(), "");
                    user.setOutTime(time);
                    user.setState(2);
                    user.setImgPath(Base64ToImg(base64Img, user.getUid()));
                    service.update(user);
                }
                break;
            case "售货机":
                if (!service.exist(user.getUid())) {
                    service.init(user.getUid(), "");
                    user.setImgPath(Base64ToImg(base64Img, user.getUid()));
                    service.update(user);
                }
                break;
        }
        System.out.println(System.currentTimeMillis() - t1);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    private String Base64ToImg(String base64, Integer uid) {
        String path = uploadPath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + uid + ".jpg";
        String aStatic = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        Base64ImageUtils.Base64ToImage(base64, aStatic + "/" + path);
        return path;
    }
}
