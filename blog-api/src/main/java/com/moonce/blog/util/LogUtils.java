package com.moonce.blog.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Louis(229010812 @ qq.com)
 * @Description: 自定义日志工具
 * @Date 2017-12-14 11:30
 */
public class LogUtils {

    /**
     * @category 获取try-catch中的异常内容
     * @param e Exception
     * @return  异常内容
     * */
    public static String getException(Exception e) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        e.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        try {
            out.close();
        } catch (Exception ex) {

        }
        return ret;
    }
}
