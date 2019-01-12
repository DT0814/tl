package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.ClientDao;
import cn.xdlr.tl.pojo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ClientService {
    @Autowired
    private ClientDao dao;

    public void add(Client client) {
        dao.saveAndFlush(client);
    }

    public Client findById(Integer cid) throws EntityNotFoundException {
        if (dao.existsById(cid)) {
            Client one = dao.getOne(cid);
            return one;
        } else return null;

    }

    public boolean exist(Integer cid) {
        return dao.existsById(cid);
    }
}
