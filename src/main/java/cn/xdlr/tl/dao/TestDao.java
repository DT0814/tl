package cn.xdlr.tl.dao;

import cn.xdlr.tl.pojo.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<Test, Integer> {
    public Test getById(Integer id);
}
