package com.moonce.util.constant;

public interface Code {

    /*返回信息*/
    String NULL_STR = "";
    String REQUEST_SUCC_MSG = "请求成功!";
    String ERROR_MSG = "操作异常！";
    String DELETE_SUCC_MSG = "删除成功！";
    String DELETE_FAIL_MSG = "删除失败！";
    String SAVE_SUCC_MSG = "保存成功！";
    String SAVE_FAIL_MSG = "保存失败！";
    String UPDATE_SUCC_MSG = "更新成功！";
    String UPDATE_FAIL_MSG = "更新失败！";
    String FIND_SUCC_MSG = "查询成功！";
    String FIND_FAIL_MSG = "查询失败！";

    /*时间格式*/
    String YYYY_MM_DD = "yyyy-MM-dd";
    String YYYY_MM_DD_SLASH = "yyyy/MM/dd";
    String YYYY_MM_DD_HH_MM_SLASH = "yyyy/MM/dd HH:mm";
    String YYYYMMDD = "yyyyMMdd";
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    String DD_HH_MM = "HH:mm:ss";

    /** 返回码 */
    Integer SUCCESS = 1;//成功
    Integer FAILED = 0;//失败
    Integer FAILED_OPERATION = 2;//失败,结果取msg
}
