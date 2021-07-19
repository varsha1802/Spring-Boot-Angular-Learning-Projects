package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Person;

@Repository
//@RepositoryRestResource(collectionResourceRel="persons")
public interface PersonRepo extends MongoRepository<Person, Integer>
{
	
	List<Person> findByPlace(String plcae);
	
	List<Person> findByAgeGreaterThan(int age);
	
	List<Person> findByNameLikeOrderByAgeAsc(String start);
	
	@Query("{ 'age' : { $gt: ?0, $lt: ?1 } }")
	List<Person> findPersonsByAgeBetween(int ageGT, int ageLT);
	
	//List<Person> findByNameStartingWith(String start);
	
	//List<Person> findByNameEndingWith(String end);

}
