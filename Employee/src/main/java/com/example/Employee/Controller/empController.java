package com.example.Employee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Service.iEmpService;


@RequestMapping("/emp")
@RestController
public class empController 
{
	@Autowired
	public iEmpService empService;
	
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}
	
	@GetMapping("/{empId}")
	public Optional<Employee> getEmployeeByEmpId(@PathVariable Long empId)
	{
		return empService.getEmployeeByempId(empId);
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return empService.createEmployee(employee);
	}
	
	@PutMapping("/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long empId, @RequestBody Employee employee)
	{
		if(!empId.equals(employee.getEmpID()))
		{
			return ResponseEntity.badRequest().build();
		}
		Employee forUpdate=empService.updateEmployee(employee);
		if(forUpdate==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(forUpdate);
	}
	
	@DeleteMapping("/{empId}")
	public void deleteEmployee(@PathVariable Long empId)
	{
		empService.deleteEmployeeByempId(empId);
	}
	
	
}
