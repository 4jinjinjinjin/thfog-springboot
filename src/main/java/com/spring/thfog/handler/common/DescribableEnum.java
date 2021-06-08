package com.spring.thfog.handler.common;

/**
 * @Title
 * @ClassName DescribableEnum
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/8 23:58
 * @Version 1.0
 **/
public enum DescribableEnum implements Describable {

    SUCCESS(0, "成功"),


    FAIL(1, "失败"),
    ;
    /**
     * 描述编码
     */
    private Integer code;

    /**
     * 描述信息
     */
    private String msg;

    DescribableEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
