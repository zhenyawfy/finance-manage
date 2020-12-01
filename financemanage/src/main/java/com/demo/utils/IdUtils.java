package com.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdUtils {
    private static long tempID = 0;
    private static boolean tempIDLocked = false;
    private static SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmssSSS");

    public static long getId() {
        long ltime = 0;
        while(true) {
            if (tempIDLocked == false) {
                tempIDLocked = true;
                ltime = Long.valueOf(df.format(new Date())) * 10000;
                if (tempID < ltime) {
                    tempID = ltime;
                } else {
                    tempID = tempID + 1;
                    ltime = tempID;
                }
                tempIDLocked = false;
                return ltime;
            }
        }
    }
}
