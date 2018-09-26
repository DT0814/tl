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

    @GetMapping("init")
    public SimpleResult init(Integer uid, String uinfo) {
        if (null == uid || uid <= 0 || null == uinfo || uinfo.trim().equals("")) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        return service.init(uid, uinfo);
    }

    @GetMapping("update")
    public SimpleResult update(Integer uid, String uinfo) {
        if (null == uid || uid <= 0 || null == uinfo || uinfo.trim().equals("")) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        return service.update(uid, uinfo);
    }
}
