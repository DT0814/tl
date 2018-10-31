package cn.xdlr.tl.utils;

public class StringUtil {
    /**
     * 验证字符串是否为空
     *
     * @param input
     * @return
     */
    public static boolean isEmpty(String input) {
        return input == null || input.trim().equals("");
    }

}
