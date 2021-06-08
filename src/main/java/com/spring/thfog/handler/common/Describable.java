package com.spring.thfog.handler.common;

/**
 * @Title
 * @ClassName Describable
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/8 23:56
 * @Version 1.0
 **/
public interface Describable {
    Integer ENUM_SUCCESS_CODE = 0;
    String ENUM_SUCCESS_MSG = "成功";
    Integer ENUM_FAIL_CODE = 999999;
    String ENUM_FAIL_MSG = "失败";

    Integer getCode();

    String getMsg();
}
