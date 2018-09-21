package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.UserDao;
import cn.xdlr.tl.dao.UserTokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenService {
    @Autowired
    private UserTokenDao dao;
    @Autowired
    private UserDao userDao;

    public void init(Integer uid, Integer value) {

    }
}
