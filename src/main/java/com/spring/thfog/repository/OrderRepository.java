package com.spring.thfog.repository;

import com.spring.thfog.entity.RoomOrder;
import com.spring.thfog.entity.RoomOrder;
import com.spring.thfog.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title
 * @ClassName OrderRepository
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/12 21:55
 * @Version 1.0
 **/
public interface OrderRepository extends JpaRepository<RoomOrder,Integer> {

    @Query("select max(o.id) from RoomOrder o ")
    Integer getMaxId();
}
