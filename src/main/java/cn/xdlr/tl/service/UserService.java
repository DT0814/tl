package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.UserDao;
import cn.xdlr.tl.pojo.User;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public SimpleResult update(Integer uid, String uinfo) {
        if (!dao.existsById(uid)) {
            return SimpleResult.getInstance(ResultCode.USER_NOT_FOUND);
        }
        User one = dao.getOne(uid);
        one.setUinfo(uinfo);
        dao.saveAndFlush(one);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    public SimpleResult init(Integer uid, String uinfo) {
        if (dao.existsById(uid)) {
            return SimpleResult.getInstance(ResultCode.USER_EXISTS);
        }
        User user = new User(uid, uinfo);
        user.setValue(0);
        System.out.println(user);
        dao.saveAndFlush(user);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }
}
