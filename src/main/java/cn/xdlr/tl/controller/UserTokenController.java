package cn.xdlr.tl.controller;

import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.pojo.result.TokenQueryHistoryResult;
import cn.xdlr.tl.pojo.result.TokenQueryValueResult;
import cn.xdlr.tl.pojo.result.UseTokenResult;
import cn.xdlr.tl.service.UserTokenService;
import cn.xdlr.tl.utils.ResultCode;
import cn.xdlr.tl.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("token")
public class UserTokenController {
    @Autowired
    private UserTokenService service;

    @RequestMapping("/init")
    public SimpleResult init(@RequestParam(name = "id") String uid, Integer value, String reason) {
        if (StringUtil.isEmpty(uid) || null == value || StringUtil.isEmpty(reason)) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        service.init(uid, value, reason);
        return SimpleResult.getInstance(ResultCode.SUCCESS);
    }

    @RequestMapping("/tran")
    public SimpleResult tran(String from, String to, Integer value, String note) {
        if (StringUtil.isEmpty(from) || StringUtil.isEmpty(to) || null == value || StringUtil.isEmpty(note)) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        return service.tran(from, to, value, note);
    }

    @RequestMapping("/update")
    public SimpleResult update(@RequestParam(name = "id") String uid, Integer value, String reason, String url) {
        if (StringUtil.isEmpty(uid) || null == value || StringUtil.isEmpty(reason) || StringUtil.isEmpty(url)) {
            return SimpleResult.getInstance(ResultCode.PARAMETER_ERROR);
        }
        return service.update(uid, value, reason, url);
    }

    @RequestMapping("/queryValue")
    public TokenQueryValueResult queryValue(@RequestParam(name = "id") String uid) {
        if (StringUtil.isEmpty(uid)) {
            return TokenQueryValueResult.getInstance(ResultCode.PARAMETER_ERROR, 0);
        }
        return service.queryValue(uid);
    }

    @RequestMapping("/queryHistory")
    public TokenQueryHistoryResult queryHistory(@RequestParam(name = "id") String uid, Integer pageNum, Integer pageSize) {
        if (null == pageNum) {
            pageNum = 0;
        }
        if (null == pageSize) {
            pageSize = 10;
        }
        if ((StringUtil.isEmpty(uid) || pageNum < 1 || pageSize < 1)) {
            return TokenQueryHistoryResult.getInstance(ResultCode.PARAMETER_ERROR, null, 0L);
        }

        return service.queryHistory(uid, pageNum - 1, pageSize);
    }

    @RequestMapping("/useToken")
    public UseTokenResult useToken(Integer orderId, Integer amount, String uid) {
        if ((StringUtil.isEmpty(uid) || orderId < 1 || amount < 1)) {
            return UseTokenResult.getInstance(ResultCode.PARAMETER_ERROR, 0);
        }

        return service.useToken(uid, orderId, amount);
    }
}
