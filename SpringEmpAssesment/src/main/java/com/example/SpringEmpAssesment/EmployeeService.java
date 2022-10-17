package com.example.SpringEmpAssesment;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {

	@Autowired
	private MyRepo repo;
	public List<Employee> displayDta()
	{
		return repo.findAll();
		
	}
	public void saveEmp(Employee employee)
	{
		repo.save(employee);
	}
	public Employee getEmp(long id)
	{
		return repo.findById(id).get();
	}
	public void delete(long id)
	{
		repo.deleteById(id);
	}

}
