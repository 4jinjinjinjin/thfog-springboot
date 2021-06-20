package com.spring.thfog.handler;

import com.spring.thfog.entity.Member;
import com.spring.thfog.handler.common.ReturnObject;
import com.spring.thfog.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title
 * @ClassName MemberBiz
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/17 23:01
 * @Version 1.0
 **/
@Component
public class MemberBiz {

    @Autowired
    MemberRepository memberRepository;

    public Object findAllMember() {
        return memberRepository.findAll();
    }

    public Object creatMember(Member member) {
        ReturnObject returnObject=new ReturnObject();
        if (null==member.getId()){
            member.setOpertime(new Date());
            member.setBalance(BigDecimal.ZERO);
        }
        memberRepository.saveAndFlush(member);
        return returnObject;
    }
}
