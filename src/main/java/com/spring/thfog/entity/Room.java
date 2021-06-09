package com.spring.thfog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Title
 * @ClassName Room
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/9 21:55
 * @Version 1.0
 **/
@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String remark;
    /**
     * 是否在用 0空房 1在用
     */
    private Integer isuse;
    private Date starttime;
    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsuse() {
        return isuse;
    }

    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
