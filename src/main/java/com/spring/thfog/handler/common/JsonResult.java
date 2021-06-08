package com.spring.thfog.handler.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title
 * @ClassName JsonResult
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/8 23:56
 * @Version 1.0
 **/
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_TYPE = "json";
    private String msg;
    private Integer status;
    private String type = "json";
    private Map<String, Object> body;
    public static final String RESULT_KEY_TYPE = "type";
    public static final String RESULT_KEY_STATUS = "status";
    public static final String RESULT_KEY_MSG = "msg";
    public static final String RESULT_KEY_BODY = "body";
    public static final String RESULT_KEY_DATA = "data";
    public static final String RESULT_KEY_EXCEPTION = "exception";

    public JsonResult(Describable describable) {
        this.msg = describable.getMsg();
        this.status = describable.getCode();
    }

    public JsonResult(Integer status, String msg) {
        this.msg = msg;
        this.status = status;
    }

    public JsonResult(Describable describable, Object data) {
        this.msg = describable.getMsg();
        this.status = describable.getCode();
        Map<String, Object> map = new HashMap();
        map.put("data", data);
        this.body = map;
    }

    public JsonResult(Integer status, String msg, Object data) {
        this.msg = msg;
        this.status = status;
        Map<String, Object> map = new HashMap();
        map.put("data", data);
        this.body = map;
    }

    public JsonResult(Describable describable, Object data, Map<String, Object> other) {
        this.msg = describable.getMsg();
        this.status = describable.getCode();
        Map<String, Object> map = new HashMap();
        map.put("data", data);
        map.putAll(other);
        this.body = map;
    }

    public JsonResult(Integer status, String msg, Object data, Map<String, Object> other) {
        this.msg = msg;
        this.status = status;
        Map<String, Object> map = new HashMap();
        map.put("data", data);
        map.putAll(other);
        this.body = map;
    }

    public JsonResult(Describable describable, Map<String, Object> body, String type) {
        this.msg = describable.getMsg();
        this.status = describable.getCode();
        this.body = body;
        this.type = type;
    }

    public JsonResult(Integer status, String msg, Map<String, Object> body, String type) {
        this.msg = msg;
        this.status = status;
        this.body = body;
        this.type = type;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Map<String, Object> getBody() {
        return this.body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public String toString() {
        return "{status:" + this.status + ",msg:'" + this.msg + "',type:'" + this.type + "'}";
    }
}
