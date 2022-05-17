package com.sample.payload.request;

import lombok.Data;

@Data
public class CreateUser {
    private String email;
    private String password;
    private String name;
    private int age;
}
