package com.spring.thfog.handler;

import com.spring.thfog.entity.Member;
import com.spring.thfog.entity.Pay;
import com.spring.thfog.entity.User;
import com.spring.thfog.entity.ext.PayExt;
import com.spring.thfog.handler.common.ReturnObject;
import com.spring.thfog.repository.MemberRepository;
import com.spring.thfog.repository.PayRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
    @Autowired
    PayRepository payRepository;

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

    public Object findTopUpById(Integer memberId) {
        List<Object[]> obj=payRepository.findTopUpById(memberId);
        if (null!=obj&&obj.size()>0){
            List<PayExt> payExts=new ArrayList<>();
            for (Object[] objk:obj){
                PayExt payExt=new PayExt();
                BeanUtils.copyProperties((Pay)objk[0],payExt);
                payExt.setOpername(((User)objk[1]).getUsername());
                payExts.add(payExt);
            }
            return payExts;
        }else {
            return null;
        }
    }

    public Object findPayDetailById(Integer memberId) {
        List<Object[]> obj=payRepository.findPayDetailById(memberId);
        if (null!=obj&&obj.size()>0){
            List<PayExt> payExts=new ArrayList<>();
            for (Object[] objk:obj){
                PayExt payExt=new PayExt();
                BeanUtils.copyProperties((Pay)objk[0],payExt);
                payExt.setOpername(((User)objk[1]).getUsername());
                payExts.add(payExt);
            }
            return payExts;
        }else {
            return null;
        }
    }
}
