package com.spring.thfog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Title
 * @ClassName Bool
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/5/5 21:29
 * @Version 1.0
 **/
@Entity
@Data
public class Book{
    @Id
    private Integer id;

    private String name;

    private String author;
}
