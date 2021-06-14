package com.spring.thfog.controller;

import com.alibaba.fastjson.JSON;
import com.spring.thfog.entity.OrderDetail;
import com.spring.thfog.handler.OrderBiz;
import com.spring.thfog.handler.common.DescribableEnum;
import com.spring.thfog.handler.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title
 * @ClassName OrderController
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/14 18:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/thefog/order")
public class OrderController {

    @Autowired
    private OrderBiz orderBiz;

    @GetMapping("/getOrderDetailById")
    public Object getOrderDetailById(Integer orderId){
        return new JsonResult(DescribableEnum.SUCCESS, orderBiz.getOrderDetailById(orderId));
    }
    @GetMapping("/creatOrderDetail")
    public Object creatOrderDetail(String orderDetail){
        OrderDetail orderDetail1= JSON.parseObject(orderDetail,OrderDetail.class);
        return new JsonResult(DescribableEnum.SUCCESS, orderBiz.creatOrderDetail(orderDetail1));
    }

    @GetMapping("/delOrderDetail")
    public Object delOrderDetail(Integer id){
        orderBiz.delOrderDetail(id);
        return new JsonResult(DescribableEnum.SUCCESS);
    }

}
