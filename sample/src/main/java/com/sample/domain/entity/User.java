package com.sample.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;


@Data
@Document(collection="user")
public class User {
    @Id
    private String _id;

    private String email;

    private String password;

    private String name;

    private int age;

    @Builder
    public User(String email, String password, String name, int age){
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public void update(String name, int age){
        this.name = name;
        this.age = age;
    }
}
