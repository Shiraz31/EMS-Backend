package com.example.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.Entity.Employee;


@Repository
public interface empRepository extends JpaRepository<Employee, Long>
{

}
