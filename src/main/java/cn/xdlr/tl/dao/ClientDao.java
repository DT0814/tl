package cn.xdlr.tl.dao;

import cn.xdlr.tl.pojo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Integer> {
}
