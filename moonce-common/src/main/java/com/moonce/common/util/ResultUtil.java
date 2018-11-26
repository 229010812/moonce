package com.moonce.common.util;


import com.moonce.common.vo.Msg;

public class ResultUtil {

    public final static Integer SUCCESS = 1;//成功
    public final static Integer FAILED = 0;//失败
    public final static Integer FAILED_OPERATION = 2;//失败,结果取msg
    public final static String REQUEST_SUCC_MSG = "请求成功!";
    public final static String NULL_STR = "";


    /**
     * 请求成功返回
     * @param object
     * @return
     */
    public static Msg success(Object object){
        return getMsg(SUCCESS,REQUEST_SUCC_MSG,object);
    }


    /**
     * 请求成功返回 - 无数据
     * @return
     */
    public static Msg success(){
        return success(NULL_STR);
    }

    /**
     * 错误返回
     * @param code
     * @param resultmsg
     * @return
     */
    public static Msg error(Integer code,String resultmsg){
        return getMsg(code,resultmsg,NULL_STR);
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
