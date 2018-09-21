package cn.xdlr.tl.controller;

import cn.xdlr.tl.pojo.UserToken;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.service.UserService;
import cn.xdlr.tl.service.UserTokenService;
import cn.xdlr.tl.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("token")
public class UserTokenController {
    @Autowired
    private UserTokenService service;

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }

    @RequestMapping("/init")
    public SimpleResult init(@RequestParam(name = "id") Integer uid, Integer value) {
        service.init(uid, value);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }
}
