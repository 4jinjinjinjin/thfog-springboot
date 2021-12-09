package com.spring.thfog.repository;

import com.spring.thfog.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * @Title
 * @ClassName GoodsRepositoryExt
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/12/9 18:52
 * @Version 1.0
 **/
@Mapper
public interface GoodsRepositoryExt {
    @SelectProvider(type = SqlProvider.class,method = "findAllGoodsSql")
    List<Goods> findAllGoods(@Param(value = "goodsType1") Integer goodsType1);
}
