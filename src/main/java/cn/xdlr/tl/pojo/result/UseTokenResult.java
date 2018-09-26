package cn.xdlr.tl.pojo.result;

public class UseTokenResult {
    private Integer retCode;
    private Integer value;

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public UseTokenResult(Integer retCode, Integer value) {
        this.retCode = retCode;
        this.value = value;
    }

    public UseTokenResult() {
    }

    public static UseTokenResult getInstance(Integer retCode, Integer value) {
        return new UseTokenResult(retCode, value);
    }
}
