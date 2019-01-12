package cn.xdlr.tl.dao;

import cn.xdlr.tl.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, String> {
}