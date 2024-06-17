package com.siddharth.mvccruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siddharth.mvccruddemo.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	
	//add a method to sort by last name
	public List<Employee>findAllByOrderByLastNameAsc();
}
