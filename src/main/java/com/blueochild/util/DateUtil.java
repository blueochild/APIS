package com.blueochild.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date addDays(Date originDate, int addDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originDate);
        calendar.add(Calendar.DATE, addDays);
        return calendar.getTime();
    }
}
