package com.spring.thfog.handler;

import com.spring.thfog.repository.GoodsRepository;
import com.spring.thfog.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Title
 * @ClassName GoodsBiz
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/12/6 1:21
 * @Version 1.0
 **/
@Component
public class GoodsBiz {
    @Autowired
    GoodsRepository goodsRepository;

    public Object findAllGoods() {
        return goodsRepository.findAll();
    }
}
