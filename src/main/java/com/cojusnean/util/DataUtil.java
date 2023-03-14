package com.cojusnean.util;

import java.time.LocalDateTime;

public final class DataUtil {

    private DataUtil(){}

    public static LocalDateTime getNowTime() {
        return LocalDateTime.now();
    }
}