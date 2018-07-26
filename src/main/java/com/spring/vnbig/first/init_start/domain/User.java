package com.spring.vnbig.first.init_start.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长
    long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    protected User() {// JPA 的规范要求无参构造函数；设为 protected 防止直接使用

    }

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
