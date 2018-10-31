package cn.xdlr.tl.utils;

public class ResultCode {
    //请求操作成功状态码
    public static final int SUCCESS = 0;
    public static final int FAIL = 400;
    //请求参数检验失败
    public static final int PARAMETER_ERROR = 401;
    //接入系统请求认证失败(随机数加密密码错误)
    public static final int CONFIRM_NO_PASS_FAIL = 411;
    //退出系统失败
    public static final int LOGIN_OUT_FAIL = 412;
    //认证找不到客户端编号
    public static final int LOGIN_CONFIRM_NOT_FOUND_CLIENT = 413;
    //
    public static final int LOGIN_CONFIRM_NOT_REQUEST = 414;

    public static final int TOKEN_USER_BALANCE_NOT_ENOUGH = 421;
    public static final int TOKEN_FROM_USER_NOT_FOUND = 422;
    public static final int TOKEN_TO_USER_NOT_FOUND = 423;
    public static final int TOKEN_USER_NOT_FOUND = 424;

    public static final int USER_EXISTS = 431;
    public static final int USER_NOT_FOUND = 432;

    public static final int REQUEST_CLIENT_NOT_FOUND = 441;
}
