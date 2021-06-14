package com.spring.thfog.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title
 * @ClassName Order
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/12 18:56
 * @Version 1.0
 **/
@Entity
@Data
public class RoomOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer roomId;
    /**
     * 0 未结账，1 已结账
     */
    @Column(insertable = false,columnDefinition = "integer default 0")
    private Integer state;
    @Column(insertable = false,columnDefinition = "decimal default 0")
    private BigDecimal amount;
    @Column(insertable = false,columnDefinition = "decimal default 0")
    private BigDecimal realPay;
    private Integer operator;
    private Date opertime;
    private Date payTime;
    private Integer payOperator;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRealPay() {
        return realPay;
    }

    public void setRealPay(BigDecimal realPay) {
        this.realPay = realPay;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getPayOperator() {
        return payOperator;
    }

    public void setPayOperator(Integer payOperator) {
        this.payOperator = payOperator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
