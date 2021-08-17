package com.example.demo.todo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJpaResource {
	
	@Autowired
	private TodJpaRepository repo;
	
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return repo.findByUsername(username);
	}
	
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,
			@PathVariable String id){
		return repo.findById(id).get();
	}
	
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public Todo updateTodo(
			@PathVariable String username,
			@PathVariable String id, @RequestBody Todo todo){
		Todo todoUpdated = repo.save(todo);
		return todoUpdated;		
	}
	
	@PostMapping("/jpa/users/{username}/todos")
	public Todo createTodo(
			@PathVariable String username,
			@RequestBody Todo todo){
		todo.setUsername(username);
		Todo createdTodo = repo.save(todo);
		return createdTodo;		
	}
	
	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,
			@PathVariable String id ){
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
}
