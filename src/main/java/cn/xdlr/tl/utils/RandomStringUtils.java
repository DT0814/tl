package cn.xdlr.tl.utils;

import org.junit.Test;

import java.util.Random;

public class RandomStringUtils {
    private static final String SOURCES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static Random random;

    @Test
    public void test() {
        RandomStringUtils rs = new RandomStringUtils();
        System.out.println(rs.generateString(10));
    }

    public static String generateString(int length) {
        if (null == random) {
            random = new Random();
        }
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = SOURCES.charAt(random.nextInt(SOURCES.length()));
        }
        return new String(text);
    }
}