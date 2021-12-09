package com.spring.thfog.handler;

import com.spring.thfog.entity.Goods;
import com.spring.thfog.handler.common.ReturnObject;
import com.spring.thfog.repository.GoodsRepository;
import com.spring.thfog.repository.GoodsRepositoryExt;
import com.spring.thfog.repository.MemberRepository;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

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
    @Autowired
    GoodsRepositoryExt goodsRepositoryExt;

    public Object findAllGoods(Integer goodsType) {
        return goodsRepositoryExt.findAllGoods(goodsType);
    }

    public Object creatGoods(Goods goods) {
        ReturnObject returnObject=new ReturnObject();
        goodsRepository.saveAndFlush(goods);
        return returnObject;
    }
}
