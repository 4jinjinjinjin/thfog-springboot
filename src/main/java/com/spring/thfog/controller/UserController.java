package com.spring.thfog.controller;

import com.spring.thfog.entity.Book;
import com.spring.thfog.handler.UserBiz;
import com.spring.thfog.handler.common.Describable;
import com.spring.thfog.handler.common.DescribableEnum;
import com.spring.thfog.handler.common.JsonResult;
import com.spring.thfog.handler.common.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Title
 * @ClassName UserController
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/8 22:57
 * @Version 1.0
 **/
@RestController
@RequestMapping("/thefog/user")
public class UserController {
    @Autowired
    private UserBiz userBiz;

    @GetMapping("/checkUserLogin")
    public Object checkUserLogin(String username,String password){
        ReturnObject returnObject= userBiz.checkUserLogin(username,password);
        if (returnObject.getIserr()){
            return new JsonResult(DescribableEnum.FAIL, returnObject.getErrmsg());
        }else {
            return new JsonResult(DescribableEnum.SUCCESS, returnObject.getResult());
        }
    }
}
