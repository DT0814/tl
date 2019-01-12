package cn.xdlr.tl.controller;

import cn.xdlr.tl.pojo.Client;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.service.ClientService;
import cn.xdlr.tl.utils.ResultCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerTest {
    @Autowired
    private ClientService service;

    @Test
    public void add() {
        Client client = new Client("123456","client1");
        service.add(client);
//        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    @Test
    public void request(){



    }

}