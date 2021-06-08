package com.spring.thfog.handler.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title
 * @ClassName ReturnObject
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/9 0:00
 * @Version 1.0
 **/
public class ReturnObject <T> implements Serializable {
    private String errmsg;
    private int state = 0;
    private T result;
    private List<T> resultlist;
    private Map<String, Object> resultmap;
    private Exception exception;

    public ReturnObject() {
    }

    public ReturnObject(T obj) {
        this.result = obj;
    }

    public ReturnObject<T> putObj(T obj) {
        this.result = obj;
        return this;
    }

    public static <T> ReturnObject<T> from(T obj) {
        return new ReturnObject(obj);
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Boolean getIserr() {
        return this.state != 0;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<T> getResultlist() {
        return this.resultlist;
    }

    public void setResultlist(List<T> resultlist) {
        this.resultlist = resultlist;
    }

    public Map<String, Object> getResultmap() {
        if (this.resultmap == null) {
            this.resultmap = new HashMap();
        }

        return this.resultmap;
    }

    public void setResultmap(Map<String, Object> resultmap) {
        this.resultmap = resultmap;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }

    public Exception getException() {
        return this.exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public JsonResult toJsonResult() {
        return this.state == 0 ? new JsonResult(DescribableEnum.SUCCESS, this.getResult()) : new JsonResult(DescribableEnum.FAIL, this.getErrmsg());
    }
}
