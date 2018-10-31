package com.moonce.common.util;

public class EncryptionPWDUtil {
    private static final String SALT = "502477A371C4DDB462434ABAA92972D5";

    public static String encode(String password) {
        password = password + SALT;
        return  CommonUtils.getMD5( CommonUtils.getMD5(password)+CommonUtils.getMD5(SALT));
    }

    public static void main(String[] args) {
        System.out.println(EncryptionPWDUtil.encode("abel"));


    }

}
