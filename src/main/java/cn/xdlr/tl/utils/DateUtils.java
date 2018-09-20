package cn.xdlr.tl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String dateToString(Date date) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        String format = sm.format(date);
        return format;
    }
}
