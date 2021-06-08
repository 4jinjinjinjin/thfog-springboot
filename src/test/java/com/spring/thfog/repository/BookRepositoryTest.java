package com.spring.thfog.repository;

import com.spring.thfog.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Title
 * @ClassName BookRepositoryTest
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/5/5 21:34
 * @Version 1.0
 **/
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Test
    void testSql(){
        List<Book> bookList=bookRepository.findAll();
        int i=0;
    }
}