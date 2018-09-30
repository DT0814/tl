package cn.xdlr.tl.pojo.result;

import cn.xdlr.tl.pojo.UserToken;
import sun.rmi.runtime.Log;

import java.util.List;

public class TokenQueryHistoryResult {
    private int retCode;
    private List<UserToken> value;
    private Long total;


    public static TokenQueryHistoryResult getInstance(int retCode, List<UserToken> value, Long total) {
        return new TokenQueryHistoryResult(retCode, value, total);
    }

    public TokenQueryHistoryResult() {
    }

    public TokenQueryHistoryResult(int retCode, List<UserToken> value, Long total) {
        this.retCode = retCode;
        this.value = value;
        this.total = total;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public List<UserToken> getValue() {
        return value;
    }

    public void setValue(List<UserToken> value) {
        this.value = value;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
