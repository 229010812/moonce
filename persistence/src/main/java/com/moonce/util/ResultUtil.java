package com.moonce.util;

import com.moonce.doman.Msg;
import com.moonce.util.constant.Code;

public class ResultUtil {


    /**
     * 请求成功返回
     * @param object
     * @return
     */
    public static Msg success(Object object){
        return getMsg(Code.SUCCESS,Code.REQUEST_SUCC_MSG,object);
    }


    /**
     * 请求成功返回 - 无数据
     * @return
     */
    public static Msg success(){
        return success(Code.NULL_STR);
    }

    /**
     * 错误返回
     * @param code
     * @param resultmsg
     * @return
     */
    public static Msg error(Integer code,String resultmsg){
        return getMsg(code,resultmsg,Code.NULL_STR);
    }

    /**
     * 创建Msg实例
     * @param code
     * @param msgStr
     * @param object
     * @return
     */
    private static Msg getMsg(Integer code,String msgStr,Object object) {
        Msg msg=new Msg();
        msg.setCode(code);
        msg.setMsg(msgStr);
        msg.setData(object);
        return msg;
    }


}
