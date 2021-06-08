package com.spring.thfog.repository;

import com.spring.thfog.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Title
 * @ClassName UserRepository
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/8 22:59
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select o from User o where o.username =:username ")
    User checkUserLogin(@Param("username") String username);
}
