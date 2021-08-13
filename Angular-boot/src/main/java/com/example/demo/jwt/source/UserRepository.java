package com.example.demo.jwt.source;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.jwt.source.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);
}
