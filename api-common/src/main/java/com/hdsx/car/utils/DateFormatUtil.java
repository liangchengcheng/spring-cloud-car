package com.hdsx.car.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期转换工具类
 * @author tan
 *
 */
public class DateFormatUtil {

    public static String dateFormat(String source) {
        String result=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            result = dateFormat.format(dateFormat.parse(source));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String dateFormat(Date source) {
        String result=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            result = dateFormat.format(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}