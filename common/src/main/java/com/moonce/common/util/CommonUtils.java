package com.moonce.common.util;

import com.moonce.common.constant.Code;

import java.security.MessageDigest;
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

    public static String getMD5(String str){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toUpperCase();
    }


}
