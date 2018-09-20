package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.ClientDao;
import cn.xdlr.tl.pojo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientDao dao;

    public void add(Client client) {
        dao.save(client);
    }

    public Client findById(Integer cid) {
        Optional<Client> obj = dao.findById(cid);
        return obj.get();
    }
}
