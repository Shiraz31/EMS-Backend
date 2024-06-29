package com.example.Employee.Entity;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "EmployeeData")
@Entity
public class Employee 
{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empID;
	private String empName;
	private String empAddress;
	private BigInteger empSalary;
	
	
	
	public Long getEmpID() {
		return empID;
	}
	public void setEmpID(Long empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public BigInteger getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(BigInteger empSalary) {
		this.empSalary = empSalary;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
