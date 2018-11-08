package cn.xdlr.tl.service;

import cn.xdlr.tl.dao.ClientAcodeDao;
import cn.xdlr.tl.pojo.ClientAcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClientAcodeService {
    @Autowired
    private ClientAcodeDao dao;

    public void add(Integer cid, String acode, Date date) {
        dao.save(new ClientAcode(cid, acode, date));
    }

    public ClientAcode findById(Integer cid) {
        if (dao.existsById(cid)) {
            ClientAcode one = dao.getOne(cid);
            return one;
        } else return null;

    }

    public boolean out(Integer cid, String acode) {
        ClientAcode one = dao.getOne(cid);
        if (null == one || !one.getAcode().equals(acode)) {
            return false;
        } else {
            dao.delete(one);
            dao.flush();
            return true;
        }

    }
}
