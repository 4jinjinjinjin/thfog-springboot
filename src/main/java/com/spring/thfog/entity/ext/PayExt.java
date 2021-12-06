package com.spring.thfog.entity.ext;

import com.spring.thfog.entity.Pay;

/**
 * @Title
 * @ClassName Pay
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/12/7 1:45
 * @Version 1.0
 **/
public class PayExt extends Pay {
    private String opername;

    public String getOpername() {
        return opername;
    }

    public void setOpername(String opername) {
        this.opername = opername;
    }
}
