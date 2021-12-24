package com.spring.thfog.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * @Title
 * @ClassName ReportRepository
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/12/25 0:38
 * @Version 1.0
 **/
@Mapper
public interface ReportRepository {

    @SelectProvider(type = SqlProvider.class,method = "getOrderData")
    List<Map> getOrderData(String date1, String date2);

    @SelectProvider(type = SqlProvider.class,method = "findPayDetail")
    List<Map>  findPayDetail(String orderId);

    @SelectProvider(type = SqlProvider.class,method = "findOrderDetail")
    List<Map>  findOrderDetail(String orderId);
}
