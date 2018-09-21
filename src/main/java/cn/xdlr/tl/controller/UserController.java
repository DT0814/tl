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

    @GetMapping("init")
    public SimpleResult register(Integer uid, String uinfo) {
        service.init(uid, uinfo);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    @GetMapping("update")
    public SimpleResult update(Integer uid, String uinfo) {
        service.update(uid,uinfo);

        return SimpleResult.getInstance(ResultCode.SUCCESS);

    }

}
