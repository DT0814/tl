package cn.xdlr.tl.controller;

import cn.xdlr.tl.pojo.Client;
import cn.xdlr.tl.pojo.result.LoginConfirmResult;
import cn.xdlr.tl.pojo.result.LoginRequestResult;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.service.ClientService;
import cn.xdlr.tl.utils.RandomStringUtils;
import cn.xdlr.tl.utils.ResultCode;
import cn.xdlr.tl.utils.SHA256Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("cli")
public class ClientController {
    @Autowired
    private ClientService service;

    @RequestMapping("request")
    public LoginRequestResult request(Integer cid, HttpSession session) {
        String random = RandomStringUtils.generateString(128);
        session.setAttribute(cid + "", random);
        return LoginRequestResult.getInstance(ResultCode.SUCCESS, random);
    }

    @RequestMapping("confirm")
    public LoginConfirmResult confirm(Integer cid, String confirm, HttpSession session) {
        String random = (String) session.getAttribute(cid + "");
        if (null == random || random.equals("")) {
            return null;
        } else {
            Client client = service.findById(cid);
            System.out.println(random);
            System.out.println(SHA256Utils.sha256(client.getPass(), random));
            System.out.println(confirm);
            if (!confirm.equals(SHA256Utils.sha256(client.getPass(), random))) {
                return LoginConfirmResult.getInstance(ResultCode.CONFIRM_NO_PASS_FAIL, "");
            } else {
                session.setAttribute("AuthCode", RandomStringUtils.generateString(128));
                return LoginConfirmResult.getInstance(ResultCode.SUCCESS, RandomStringUtils.generateString(128));
            }
        }
    }

    @RequestMapping("add")
    public SimpleResult add(Client client) {
        service.add(client);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }
}
