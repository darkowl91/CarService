package com.motors.programm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateUtil {

    public static final String PATTERN_DD_MM_YYYY = "DDMMYYYY";
    public static final String PATTERN_YYYY = "YYYY";


    public static long parseDate(String dateStr, String pattern) throws ParseException {
        DateFormat df = new SimpleDateFormat(pattern);
        return df.parse(dateStr).getTime();
    }

    public static Long getDateTimeNow() {
        return Calendar.getInstance().getTimeInMillis();
    }


}
