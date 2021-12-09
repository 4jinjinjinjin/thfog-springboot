package com.spring.thfog.repository;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Title
 * @ClassName SqlProvider
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/12/8 23:50
 * @Version 1.0
 **/
public class SqlProvider {

    public String findAllGoodsSql(Map<String,Object> para){
        return new SQL(){{
            SELECT("id,goods_name goodsName,goods_price goodsPrice,goods_type goodsType");
            FROM("goods");
            if (null!=para.get("goodsType1")&&-1!=(Integer)para.get("goodsType1")){
                WHERE("goods_type="+(Integer)para.get("goodsType1"));
            }
        }}.toString();
    }
}
