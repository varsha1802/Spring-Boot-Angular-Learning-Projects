package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Person;

@Repository
//@RepositoryRestResource(collectionResourceRel="persons")
public interface PersonRepo extends MongoRepository<Person, Integer> {

}
