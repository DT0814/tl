package cn.xdlr.tl.dao;

import cn.xdlr.tl.pojo.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTokenDao extends JpaRepository<UserToken, Integer> {
}
