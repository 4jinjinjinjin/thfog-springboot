package com.spring.thfog.repository;

import com.spring.thfog.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title
 * @ClassName MemberRepository
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/17 23:02
 * @Version 1.0
 **/
public interface MemberRepository extends JpaRepository<Member,Integer> {
}
