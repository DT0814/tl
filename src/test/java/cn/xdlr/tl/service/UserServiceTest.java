package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.UserDao;
import cn.xdlr.tl.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService service;
    @Test
    public void findId(){
        System.out.println(service.getOneById("1"));
    }

    @Test
    public void update(){
        User user = new User("1","tl0001");
        service.update(user);
    }

}