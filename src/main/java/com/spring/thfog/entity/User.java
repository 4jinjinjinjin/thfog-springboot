package com.spring.thfog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Title
 * @ClassName User
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/8 22:58
 * @Version 1.0
 **/

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private Date creattime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}
