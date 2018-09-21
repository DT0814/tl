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

    public User findById(Integer id) {
        Optional<User> obj = dao.findById(id);
        return obj.get();
    }


}
