package com.sample.payload.request;

import lombok.Data;

@Data
public class UpdateUser {
    private String email;
    private String name;
    private int age;
}
