package cn.xdlr.tl.pojo.result;

public class TokenQueryValueResult {
    private int retCode;

    private Integer value;

    public static TokenQueryValueResult getInstance(int retCode, Integer value) {
        return new TokenQueryValueResult(retCode, value);
    }

    public TokenQueryValueResult() {
    }

    public TokenQueryValueResult(int retCode, Integer value) {
        this.retCode = retCode;
        this.value = value;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
