package org.example.myspringboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseDateFromStr(String dateStr){
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("parse str to date fail");
        }
    }

    public static String parseStrFromDate(Date date){
        return simpleDateFormat.format(date);
    }
}
