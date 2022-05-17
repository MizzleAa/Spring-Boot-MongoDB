package com.sample.service;

import java.util.Optional;

import com.sample.domain.entity.User;
import com.sample.payload.request.CreateUser;
import com.sample.payload.request.DeleteUser;
import com.sample.payload.request.ReadUser;
import com.sample.payload.request.UpdateUser;
import com.sample.repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<?> create(CreateUser createUser){
        User user = User.builder()
                        .email(createUser.getEmail())
                        .password(createUser.getPassword())
                        .name(createUser.getName())
                        .age(createUser.getAge())
                        .build();

        User saveUser = userRepository.save(user);
        return ResponseEntity.ok(saveUser);
    }

    public ResponseEntity<?> read(ReadUser readUser){
        Optional<User> user = userRepository.findByEmail(readUser.getEmail());
        return ResponseEntity.ok(user.get());
    }

    @Transactional
    public ResponseEntity<?> update(UpdateUser updateUser){
        User user = userRepository.findByEmail(updateUser.getEmail()).get();
        user.update(updateUser.getName(), updateUser.getAge());
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @Transactional
    public ResponseEntity<?> delete(DeleteUser deleteUser){
        Optional<User> user = userRepository.findByEmail(deleteUser.getEmail());
        userRepository.delete(user.get());
        return ResponseEntity.ok(true); 
    }
}
