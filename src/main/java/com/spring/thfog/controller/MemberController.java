package com.spring.thfog.controller;

import com.alibaba.fastjson.JSON;
import com.spring.thfog.entity.Member;
import com.spring.thfog.entity.OrderDetail;
import com.spring.thfog.handler.MemberBiz;
import com.spring.thfog.handler.common.DescribableEnum;
import com.spring.thfog.handler.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title
 * @ClassName MemberController
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/17 23:00
 * @Version 1.0
 **/
@RestController
@RequestMapping("/thefog/member")
public class MemberController {

    @Autowired
    MemberBiz memberBiz;

    @GetMapping("/findAllMember")
    public Object findAllMember(){
        return new JsonResult(DescribableEnum.SUCCESS, memberBiz.findAllMember());
    }

    @GetMapping("/creatMember")
    public Object creatMember(String memberJson){
        Member member= JSON.parseObject(memberJson,Member.class);
        return new JsonResult(DescribableEnum.SUCCESS, memberBiz.creatMember(member));
    }

    @GetMapping("/findTopUpById")
    public Object findTopUpById(Integer memberId){
        return new JsonResult(DescribableEnum.SUCCESS, memberBiz.findTopUpById(memberId));
    }

    @GetMapping("/findPayDetailById")
    public Object findPayDetailById(Integer memberId){
        return new JsonResult(DescribableEnum.SUCCESS, memberBiz.findPayDetailById(memberId));
    }

}
