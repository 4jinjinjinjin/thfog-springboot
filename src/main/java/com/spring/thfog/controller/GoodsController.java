package com.spring.thfog.controller;

import com.spring.thfog.entity.Goods;
import com.spring.thfog.handler.GoodsBiz;
import com.spring.thfog.handler.MemberBiz;
import com.spring.thfog.handler.common.DescribableEnum;
import com.spring.thfog.handler.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title
 * @ClassName GoodsController
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/12/6 1:19
 * @Version 1.0
 **/
@RestController
@RequestMapping("/thefog/goods")
public class GoodsController {

    @Autowired
    GoodsBiz goodsBiz;

    @GetMapping("/findAllGoods")
    public Object findAllGoods(){
        return new JsonResult(DescribableEnum.SUCCESS, goodsBiz.findAllGoods());
    }

}
