package cn.xdlr.tl.pojo.result;

public class LoginConfirmResult {
    private int retCode;
    private String AuthCode;

    public LoginConfirmResult() {
    }

    public static LoginConfirmResult getInstance(int retCode, String authCode) {
        return new LoginConfirmResult(retCode, authCode);
    }

    public LoginConfirmResult(int retCode, String authCode) {
        this.retCode = retCode;
        this.AuthCode = authCode;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getAuthCode() {
        return AuthCode;
    }

    public void setAuthCode(String authCode) {
        AuthCode = authCode;
    }
}
