package com.spring.thfog.controller;

import com.alibaba.fastjson.JSON;
import com.spring.thfog.entity.OrderDetail;
import com.spring.thfog.entity.Pay;
import com.spring.thfog.handler.PayBiz;
import com.spring.thfog.handler.common.DescribableEnum;
import com.spring.thfog.handler.common.JsonResult;
import com.spring.thfog.handler.common.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Title
 * @ClassName PayController
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/20 19:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/thefog/pay")
public class PayController {

    @Autowired
    PayBiz payBiz;


    @GetMapping("/getPayByOrderId")
    public Object getPayByOrderId(Integer orderId){
        return new JsonResult(DescribableEnum.SUCCESS, payBiz.getPayByOrderId(orderId));
    }

    @GetMapping("/creatPay")
    public Object creatPay(String payJSON){
        Pay pay= JSON.parseObject(payJSON,Pay.class);
        return new JsonResult(DescribableEnum.SUCCESS, payBiz.creatPay(pay));
    }

    /**
     * 支付
     * @param flag
     * @param amount
     * @param orderId
     * @param memberId
     * @param remark
     * @param operator
     * @return
     */
    @GetMapping("/doPay")
    public Object doPay(Integer flag, BigDecimal amount,Integer orderId,Integer memberId,String remark,Integer operator){

        ReturnObject returnObject= payBiz.doPay(flag, amount,orderId,memberId,remark,operator);
        if (returnObject.getIserr()){
            return new JsonResult(DescribableEnum.FAIL, returnObject.getErrmsg());
        }else {
            return new JsonResult(DescribableEnum.SUCCESS, returnObject.getResult());
        }
    }@GetMapping("/say886")
    public Object say886(Integer orderId,Integer operator){
        ReturnObject returnObject= payBiz.say886(orderId,operator);
        if (returnObject.getIserr()){
            return new JsonResult(DescribableEnum.FAIL, returnObject.getErrmsg());
        }else {
            return new JsonResult(DescribableEnum.SUCCESS, returnObject.getResult());
        }
    }


    /**
     *
     * @param flag
     * @param amount
     * @param memberId
     * @param remark
     * @param operator
     * @return
     */
    @GetMapping("/addMemBalance")
    public Object addMemBalance(Integer flag, BigDecimal amount,Integer memberId,String remark,Integer operator){

        ReturnObject returnObject= payBiz.addMemBalance(flag, amount,memberId,remark,operator);
        if (returnObject.getIserr()){
            return new JsonResult(DescribableEnum.FAIL, returnObject.getErrmsg());
        }else {
            return new JsonResult(DescribableEnum.SUCCESS, returnObject.getResult());
        }
    }
}
