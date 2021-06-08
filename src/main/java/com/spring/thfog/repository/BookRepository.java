package com.spring.thfog.repository;

import com.spring.thfog.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title
 * @ClassName BookRepository
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/5/5 21:33
 * @Version 1.0
 **/
public interface BookRepository extends JpaRepository<Book,Integer> {
}
