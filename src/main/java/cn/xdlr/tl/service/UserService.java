package cn.xdlr.tl.service;

import cn.xdlr.tl.bcosliteClient.BcosClient;
import cn.xdlr.tl.dao.UserDao;
import cn.xdlr.tl.dto.ExhibitionDTO;
import cn.xdlr.tl.pojo.User;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.utils.GlobalVariable;
import cn.xdlr.tl.utils.ResultCode;
import cn.xdlr.tl.utils.String2LongUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public SimpleResult updateUinfo(String uid, String uinfo) {
        User one = getOneById(uid);
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

    // 更新用户的信息
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
        user.setValue(GlobalVariable.INIT_TOKEN);
        logger.info("user:", user);
        dao.saveAndFlush(user);
//        try {
//            new BcosClient().userInit(String2LongUtil.parse(uid), "");
//        } catch (Exception e) {
//            System.out.println("用户存入区块失败");
//            e.printStackTrace();
//        }
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    public SimpleResult init(String uid, String uinfo, Integer value, String imgPath, Date inTime, Date outTime, Integer state) {
        if (exist(uid)) {
            return SimpleResult.getInstance(ResultCode.USER_EXISTS);
        }
        User user = new User(uid, uinfo, value, inTime, outTime, state, imgPath);
        dao.saveAndFlush(user);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    public void parkTimeAward(String uid, Date time) {
        User user = getOneById(uid);
        Date inTime = user.getInTime();
        if (null != inTime) {
            long stayTime = time.getTime() - inTime.getTime();
            int value = (int) stayTime / 1000 * GlobalVariable.TOKEN_AWARD_PER_MINUTE;
            user.setValue(user.getValue() + value);
        }
        user.setState(2);
        dao.saveAndFlush(user);
    }

    // 展厅数据显示
    public ExhibitionDTO getExhibitionData(Integer pageNum, Integer pageSize) {
        Integer userNumber, userOnline, blockHeight = null;
        List<User> userList = dao.findAll();
        userNumber = userList.size();
        Iterator<User> it = userList.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if (Integer.valueOf(2).equals(user.getState())) {
                it.remove();
            }
        }
        userOnline = userList.size();

        List<User> pageList = null;
        int start = (pageNum - 1) * pageSize, end = pageNum * pageSize;
        if (start <= userOnline && end <= userOnline) {
            pageList = userList.subList(start, end);
        } else if (start <= userOnline) {
            pageList = userList.subList(start, userOnline);
        } else {
            // 超出list长度
            pageList = null;
        }

        try {
            blockHeight = new BcosClient().getBlockHeight();
        } catch (Exception e) {
            logger.info("块高查询失败");
            e.printStackTrace();
        }
        return new ExhibitionDTO(0, userNumber, userOnline, pageList, blockHeight);
    }

}
