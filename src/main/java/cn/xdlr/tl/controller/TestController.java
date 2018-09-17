package cn.xdlr.tl.controller;

import cn.xdlr.tl.pojo.Test;
import cn.xdlr.tl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class TestController {
    @Autowired
    private TestService service;

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }

    @GetMapping("/findAll")
    public List<Test> findAll() {
        return service.findAll();
    }

    @RequestMapping("/add")
    public Test add(Test test) {
        System.out.println(test);
        return service.add(test);
    }

    @RequestMapping("/delete")
    public Test delete(Test test) {
        System.out.println(test);
        return service.delete(test);
    }

    @RequestMapping("/update")
    public Test update(Test test) {
        System.out.println(test);
        return service.update(test);
    }
}
