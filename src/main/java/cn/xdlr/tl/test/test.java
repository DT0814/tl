package cn.xdlr.tl.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class test {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(3));
        }
    }
}
