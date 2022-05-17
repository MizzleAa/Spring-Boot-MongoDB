package com.sample.repository;

import java.util.Optional;

import com.sample.domain.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
