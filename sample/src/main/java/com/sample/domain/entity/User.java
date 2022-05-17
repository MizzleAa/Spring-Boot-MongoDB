package com.sample.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;


@DynamicUpdate
@Data
@Entity
@Document(collection="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
