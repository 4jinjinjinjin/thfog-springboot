package com.spring.thfog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.spring.thfog.handler.GoodsBiz;
import com.spring.thfog.handler.OrderBiz;
import com.spring.thfog.handler.common.DescribableEnum;
import com.spring.thfog.handler.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title
 * @ClassName ReportController
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/12/21 22:44
 * @Version 1.0
 **/
@RestController
@RequestMapping("/thefog/report")
public class ReportController {
    @Autowired
    GoodsBiz goodsBiz;
    @Autowired
    OrderBiz orderBiz;

    @GetMapping("/getGoodsData")
    public Object getGoodsData(String date1,String date2){

        return new JsonResult(DescribableEnum.SUCCESS, goodsBiz.getGoodsData(date1,date2));
    }
    @GetMapping("/getOrderData")
    public Object getOrderData(String date1,String date2){

        return new JsonResult(DescribableEnum.SUCCESS, orderBiz.getOrderData(date1,date2));
    }
    @GetMapping("/findPayDetail")
    public Object findPayDetail(Integer orderId){

        return new JsonResult(DescribableEnum.SUCCESS, orderBiz.findPayDetail(orderId));
    }
    @GetMapping("/findOrderDetail")
    public Object findOrderDetail(Integer orderId){

        return new JsonResult(DescribableEnum.SUCCESS, orderBiz.findOrderDetail(orderId));
    }
}
