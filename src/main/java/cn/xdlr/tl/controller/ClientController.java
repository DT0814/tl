package cn.xdlr.tl.controller;

import cn.xdlr.tl.pojo.Client;
import cn.xdlr.tl.pojo.result.LoginConfirmResult;
import cn.xdlr.tl.pojo.result.LoginRequestResult;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.service.ClientAcodeService;
import cn.xdlr.tl.service.ClientService;
import cn.xdlr.tl.utils.RandomStringUtils;
import cn.xdlr.tl.utils.ResultCode;
import cn.xdlr.tl.utils.SHA256Utils;
import cn.xdlr.tl.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("cli")
public class ClientController {
    @Autowired
    private ClientService service;
    @Autowired
    private ClientAcodeService clientAcodeService;

    @RequestMapping("request")
    public LoginRequestResult request(Integer cid, HttpSession session) {
        if (null == cid || cid <= 0) {
            return LoginRequestResult.getInstance(ResultCode.PARAMETER_ERROR, "");
        }
        if (!service.exist(cid)) {
            return LoginRequestResult.getInstance(ResultCode.REQUEST_CLIENT_NOT_FOUND, "");
        }
        String random = RandomStringUtils.generateString(128);
        session.getServletContext().setAttribute("cid=" + cid, random);
        return LoginRequestResult.getInstance(ResultCode.SUCCESS, random);
    }

    @RequestMapping("out")
    public SimpleResult out(Integer cid, String Acode) {
        if (null == cid || cid <= 0 || StringUtil.isEmpty(Acode)) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        boolean b = clientAcodeService.out(cid, Acode);
        if (b) {
            return SimpleResult.getInstance(ResultCode.SUCCESS);
        }
        return SimpleResult.getInstance(ResultCode.LOGIN_OUT_FAIL);
    }

    @RequestMapping("confirm")
    public LoginConfirmResult confirm(Integer cid, String confirm, HttpSession session) {
        if (null == cid || cid <= 0) {
            return LoginConfirmResult.getInstance(ResultCode.PARAMETER_ERROR, "");
        }
        String random = (String) session.getServletContext().getAttribute("cid=" + cid);
        if (StringUtil.isEmpty(random)) {
            return LoginConfirmResult.getInstance(ResultCode.LOGIN_CONFIRM_NOT_REQUEST, "");
        } else {
            Client client = service.findById(cid);
            if (null == client) {
                return LoginConfirmResult.getInstance(ResultCode.LOGIN_CONFIRM_NOT_FOUND_CLIENT, "");
            }
            System.out.println(random);
            System.out.println(SHA256Utils.sha256(client.getPass(), random));
            System.out.println(confirm);
            if (!confirm.equals(SHA256Utils.sha256(client.getPass(), random))) {
                return LoginConfirmResult.getInstance(ResultCode.CONFIRM_NO_PASS_FAIL, "");
            } else {
                String acode = RandomStringUtils.generateString(128);
                clientAcodeService.add(cid, acode, new Date());
                return LoginConfirmResult.getInstance(ResultCode.SUCCESS, acode);
            }
        }
    }

    @RequestMapping("add")
    public SimpleResult add(Client client) {
        service.add(client);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }


}