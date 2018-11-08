package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.UserDao;
import cn.xdlr.tl.pojo.User;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.UserTransaction;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public SimpleResult updateUinfo(Integer uid, String uinfo) {
        if (!dao.existsById(uid)) {
            return SimpleResult.getInstance(ResultCode.USER_NOT_FOUND);
        }
        User one = dao.getOne(uid);
        one.setUinfo(uinfo);

        dao.saveAndFlush(one);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    public User getOneById(String uid) {
        ExampleMatcher matcher = ExampleMatcher.matching().
                withIgnorePaths("uinfo", "value", "name", "age", "inTime", "outTime", "state", "imgPath")
                .withMatcher("uid", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<User> example = Example.of(new User(uid), matcher);

        Optional<User> one = dao.findOne(example);
        boolean present = one.isPresent();
        return present ? one.get() : null;
    }

    public SimpleResult update(User user) {

        User one = getOneById(user.getUid());
        if (user.getValue() != null) {
            one.setValue(user.getValue());
        }
        if (user.getAge() != null) {
            one.setAge(user.getAge());
        }
        if (user.getImgPath() != null) {
            one.setImgPath(user.getImgPath());
        }
        if (user.getInTime() != null) {
            one.setInTime(user.getInTime());
        }
        if (user.getOutTime() != null) {
            one.setOutTime(user.getOutTime());
        }
        if (user.getName() != null) {
            one.setName(user.getName());
        }
        if (user.getState() != null) {
            one.setState(user.getState());
        }
        if (user.getUinfo() != null) {
            one.setUinfo(user.getUinfo());
        }
        dao.saveAndFlush(one);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    public boolean exist(String uid) {
        return getOneById(uid) != null;
    }

    public SimpleResult init(String uid, String uinfo) {
        if (exist(uid)) {
            return SimpleResult.getInstance(ResultCode.USER_EXISTS);
        }
        User user = new User(uid, uinfo);
        user.setValue(0);
        System.out.println(user);
        dao.saveAndFlush(user);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    public void parkTimeAward(String uid, Date time) {
        User user = getOneById(uid);
        Date inTime = user.getInTime();
        long l = time.getTime() - inTime.getTime();
        int value = (int) (l * 0.1);
        user.setValue(user.getValue() + value);
        user.setState(2);
        dao.saveAndFlush(user);
    }
}
