package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Alien;

import java.util.List;

@Repository
public interface AlienRepo extends JpaRepository<Alien, Integer>

{	
	List<Alien> findByTech(String tech);
	
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where tech=?1 and zname=?2 order by aname")
	List<Alien> findByTechSorted(String tech, String zname);

}
