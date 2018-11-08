package cn.xdlr.tl.pojo.result;

public class LoginRequestResult {
    private int retCode;
    private String random;

    public LoginRequestResult() {

    }

    public static LoginRequestResult getInstance(int retCode, String random) {
        return new LoginRequestResult(retCode, random);
    }

    public LoginRequestResult(int retCode, String random) {
        this.retCode = retCode;
        this.random = random;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }
}
