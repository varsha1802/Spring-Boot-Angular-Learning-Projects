package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	List<Employee> findByIdGreaterThan(long aid);

}
