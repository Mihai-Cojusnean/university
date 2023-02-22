package com.cojusnean.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DataUtil {

    private DataUtil() {}

    static public String getNowTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(formatter);
    }
}
