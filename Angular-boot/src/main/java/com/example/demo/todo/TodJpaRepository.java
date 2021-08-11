package com.example.demo.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodJpaRepository extends MongoRepository<Todo, String>{

	List<Todo> findByUsername(String username);
	
}
