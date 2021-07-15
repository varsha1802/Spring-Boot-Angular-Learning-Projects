package com.example.demo.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public List<Employee> getAllEmployees()
	{		
		return employeeRepo.findAll();
	}
	
	@Override
	public void saveEmployee(Employee employee)
	{
		employeeRepo.save(employee);
	}
	
	@Override
	public Employee getEmployeeById(long id)
	{
		Employee employee = employeeRepo.findById(id).orElse(null);
		return employee;
	}
	
	@Override
	public void deleteEmployeeById(long id)
	{
		employeeRepo.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection)
	{
		Sort sort = sortDirection.equals("asc") ? Sort.by(sortField).ascending() :
								Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return employeeRepo.findAll(pageable);
	}

	@Override
	public List<Employee> findByIdGreater(long aid)
	{
		return employeeRepo.findByIdGreaterThan(aid);
	}	

}
