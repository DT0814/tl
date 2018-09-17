package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.TestDao;
import cn.xdlr.tl.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestDao testDao;

    public Test add(Test test) {
        Test save = testDao.save(test);
        return test;
    }

    public Test delete(Test test) {
        testDao.delete(test);
        return test;
    }

    public Test update(Test test) {
        Test save = testDao.save(test);
        return save;
    }

    public List<Test> findAll() {
        return testDao.findAll();
    }
}
