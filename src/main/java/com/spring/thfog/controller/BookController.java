package com.spring.thfog.controller;

import com.spring.thfog.entity.Book;
import com.spring.thfog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title
 * @ClassName BookController
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/5/5 21:40
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/findAllBooks")
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
}
