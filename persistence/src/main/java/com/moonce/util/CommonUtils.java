package com.moonce.util;

import com.moonce.util.constant.Code;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
    /**
     * Date转String
     * @param date
     * @param patten
     * @return
     */
    public static String dateCastToString(Date date, String patten) {
        if(date==null){
            return Code.NULL_STR;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        try {
            String dateStr = sdf.format(date);
            return dateStr;
        } catch (Exception e) {
            return  Code.NULL_STR;
        }
    }
    /**
     * String转Date
     * @param dateStr
     * @param patten
     * @return
     */
    public static Date stringCastToDate(String dateStr, String patten) {
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (Exception e) {
            return null;
        }
    }
}
