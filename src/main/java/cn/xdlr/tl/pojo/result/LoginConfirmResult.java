package cn.xdlr.tl.pojo.result;

public class LoginConfirmResult {
    private int retCode;
    private String authCode;

    public static LoginConfirmResult getInstance(int retCode, String authCode) {
        return new LoginConfirmResult(retCode, authCode);
    }

    public LoginConfirmResult(int retCode, String authCode) {
        this.retCode = retCode;
        this.authCode = authCode;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRandom() {
        return authCode;
    }

    public void setRandom(String random) {
        this.authCode = random;
    }
}
