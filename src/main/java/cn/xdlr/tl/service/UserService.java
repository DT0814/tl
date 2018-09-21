package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.UserDao;
import cn.xdlr.tl.pojo.Client;
import cn.xdlr.tl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public void update(Integer uid, String uinf) {
        User one = dao.getOne(uid);
        one.setUinfo(uinf);
        dao.saveAndFlush(one);
    }

    public void init(Integer uid, String uinfo) {
        User user = new User(uid, uinfo);
        dao.saveAndFlush(user);
    }
}
