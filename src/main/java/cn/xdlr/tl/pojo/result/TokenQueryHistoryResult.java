package cn.xdlr.tl.pojo.result;

import cn.xdlr.tl.pojo.UserToken;

import java.util.List;

public class TokenQueryHistoryResult {
    private int retCode;
    private List<UserToken> value;

    public static TokenQueryHistoryResult getInstance(int retCode, List<UserToken> value) {
        return new TokenQueryHistoryResult(retCode, value);
    }

    public TokenQueryHistoryResult() {
    }

    public TokenQueryHistoryResult(int retCode, List<UserToken> value) {
        this.retCode = retCode;
        this.value = value;
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
}
