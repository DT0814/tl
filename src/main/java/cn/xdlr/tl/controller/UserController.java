package cn.xdlr.tl.controller;

import cn.xdlr.tl.pojo.User;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.service.UserService;
import cn.xdlr.tl.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController()
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }

    @GetMapping("register")
    public SimpleResult register(Integer uid, String uinf, String Acode, HttpSession session) {
        String random = (String) session.getAttribute(uid + "");
        if (null == random || random.equals("")) {

            return SimpleResult.getInstance(ResultCode.SUCCESS);
        } else {
            return SimpleResult.getInstance(ResultCode.CONFIRM_NO_PASS_FAIL);
        }
    }

    @GetMapping("update")
    public SimpleResult update(Integer uid, String uinf, String Acode, HttpSession session) {
        String random = (String) session.getAttribute(uid + "");
        if(null == random || random.equals("")) {

            return SimpleResult.getInstance(ResultCode.CONFIRM_NO_PASS_FAIL);
        } else {
            User user = service.findById(uid);
            if (Acode.equals(user.getId())) {
                user.setUinfo(uinf);
                return SimpleResult.getInstance(ResultCode.SUCCESS);
            } else {
                return SimpleResult.getInstance(ResultCode.CONFIRM_NO_PASS_FAIL);
            }
        }
    }

}
