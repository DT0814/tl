package cn.xdlr.tl.pojo.result;

public class SimpleResult {
    private int retCode;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public SimpleResult(int retCode) {
        this.retCode = retCode;
    }

    public static SimpleResult getInstance(int retCode) {
        return new SimpleResult(retCode);
    }
}
