package com.spring.thfog.repository;

import com.spring.thfog.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Title
 * @ClassName OrderDetailRepository
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/14 18:51
 * @Version 1.0
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

    @Query("select o from OrderDetail o where o.orderId =:orderId ")
    List<OrderDetail> getOrderDetailById(Integer orderId);
}
