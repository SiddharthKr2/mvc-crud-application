package com.siddharth.mvccruddemo.service;


import java.util.List;

import com.siddharth.mvccruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
