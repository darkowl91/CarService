package com.motors.programm.util;

import java.sql.Date;

public class DateUtil {

    public static Date getDateNow() {
        java.util.Date dateNow = new java.util.Date();
        return new Date(dateNow.getTime());
    }
}
