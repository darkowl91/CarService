package com.motors.programm.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
     * @return java.sql.date
     */
    public static java.sql.Date getSqlDateByStrValue(String dateStr) {
        if (dateStr.isEmpty()) {
            return null;
        }
        java.sql.Date sqlDate = Date.valueOf(dateStr);
        return sqlDate;
    }

    public static java.sql.Date getSqlDateYear(String year) {
        SimpleDateFormat formatYear = new SimpleDateFormat("YYYY");
        java.util.Date yearDate = new java.util.Date();
        try {
            yearDate = formatYear.parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(yearDate.getTime());
    }
}
