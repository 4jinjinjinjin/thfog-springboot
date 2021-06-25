package com.spring.thfog.repository;

import com.spring.thfog.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Title
 * @ClassName PayRepository
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/20 1:23
 * @Version 1.0
 **/
public interface PayRepository extends JpaRepository<Pay,Integer> {

    @Query("select o from Pay o where o.orderId =:orderId and type=1")
    List<Pay> getPayByOrderId(Integer orderId);
}
