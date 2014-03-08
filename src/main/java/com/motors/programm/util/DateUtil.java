package com.motors.programm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateUtil {

    public static final String PATTERN_DD_MM_YYYY = "DDMMYYYY";
    public static final String PATTERN_YYYY = "YYYY";


    public static Calendar parseDate(String dateStr, String pattern) throws ParseException {
        DateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(dateStr));
        return calendar;
    }

    public static Calendar getDateTimeNow() {
        return Calendar.getInstance();
    }


}
