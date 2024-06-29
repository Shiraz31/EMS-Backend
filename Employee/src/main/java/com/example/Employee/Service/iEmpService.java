package com.example.Employee.Service;

import java.util.List;
import java.util.Optional;

import com.example.Employee.Entity.Employee;

public interface iEmpService 
{
	
	List<Employee> getAllEmployees();
	
	Optional<Employee> getEmployeeByempId(Long empId);
	
	Employee createEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeByempId(Long empId);
	
}

