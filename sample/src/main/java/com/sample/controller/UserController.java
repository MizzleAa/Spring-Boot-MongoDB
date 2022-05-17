package com.sample.controller;

import com.sample.payload.request.CreateUser;
import com.sample.payload.request.DeleteUser;
import com.sample.payload.request.ReadUser;
import com.sample.payload.request.UpdateUser;
import com.sample.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody CreateUser createUser){
        return userService.create(createUser);
    }

    @GetMapping("")
    public ResponseEntity<?> read(ReadUser readUser){
        return userService.read(readUser);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody UpdateUser updateUser){
        return userService.update(updateUser);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody DeleteUser deleteUser){
        return userService.delete(deleteUser);
    }
}
