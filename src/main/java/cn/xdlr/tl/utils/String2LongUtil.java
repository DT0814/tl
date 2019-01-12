package cn.xdlr.tl.utils;

public class String2LongUtil {

    // 可能会有两个不同的String型id解析得到相同Long型用户id， 极小概率 后期修复
    public static Long parse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(Integer.valueOf(str.charAt(i)));
        }
        return Long.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(parse("abcbcd"));
    }

}
