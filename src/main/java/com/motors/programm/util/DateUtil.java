package com.motors.programm.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DateUtil {
    public static final String PATTERN_YYYY_MM_DD = "YYYY-MM-DD";

    /**
     * Get current date
     *
     * @return java.sql.date
     */
    public static Date getDateNow() {
        java.util.Date dateNow = new java.util.Date();
        return new Date(dateNow.getTime());
    }

    /**
     * Convert string value of date to java.sql.date
     *
     * @param dateStr string value of date
     * @param pattern string pattern for converting format
     * @param locale  current locale
     * @return java.sql.date
     */
    public static Date getSqlDateByStrValue(String dateStr, String pattern, Locale locale) {
        Date date;
        SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
        try {
            java.util.Date tDate = format.parse(dateStr);
            date = new Date(tDate.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return date;
    }
}
