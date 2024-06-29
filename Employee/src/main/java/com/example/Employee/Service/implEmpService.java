package com.example.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.empRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class implEmpService implements iEmpService
{
	
	@Autowired
	public empRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeByempId(Long empId) {
		// TODO Auto-generated method stub
		return empRepo.findById(empId);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmployee = empRepo.findById(employee.getEmpID());
		
		if(!optionalEmployee.isPresent())
		{
			throw new EntityNotFoundException("No data in this Id"+ employee.getEmpID());
		}
		
		Employee existingEmployee=optionalEmployee.get();
		existingEmployee.setEmpName(employee.getEmpName());
		existingEmployee.setEmpAddress(employee.getEmpAddress());
		existingEmployee.setEmpSalary(employee.getEmpSalary());
		
		return empRepo.save(employee);
	}

	@Override
	public void deleteEmployeeByempId(Long empId) 
	{
		// TODO Auto-generated method stub
		empRepo.deleteById(empId);
	}

}
