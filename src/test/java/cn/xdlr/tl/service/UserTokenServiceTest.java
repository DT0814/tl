package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.UserDao;
import cn.xdlr.tl.dao.UserTokenDao;
import cn.xdlr.tl.pojo.User;
import cn.xdlr.tl.pojo.UserToken;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.utils.ResultCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTokenServiceTest {

    @Autowired
    private UserTokenDao userTokenDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Test
    public void init() {
        User one = userService.getOneById("1");
        int value = 100;
        one.setValue(value);
        userDao.saveAndFlush(one);
        UserToken userToken = new UserToken(value, "1", "no", "", new Date());
        userTokenDao.saveAndFlush(userToken);
    }

    @Test
    public void tran() {
        String from = "1", to = "2";
        int value = 10;
        String note = "1 to 2 value = 10";
        User toUser = userService.getOneById(to);

        User fromUser = userService.getOneById(from);
        fromUser.setValue(fromUser.getValue() - value);
        userDao.saveAndFlush(fromUser);
        toUser.setValue(toUser.getValue() + value);
        userDao.saveAndFlush(toUser);
        Date date = new Date();
        UserToken fromUserToken = new UserToken(-value, fromUser.getUid(), note, "", date);
        userTokenDao.saveAndFlush(fromUserToken);
        UserToken toUserToken = new UserToken(value, toUser.getUid(), note, "", date);
        userTokenDao.saveAndFlush(toUserToken);

    }
}