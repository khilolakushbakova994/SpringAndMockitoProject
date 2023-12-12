package com.example.SpringAndMockitoProject.service;

import com.example.SpringAndMockitoProject.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int department, int salary);
    Employee removeEmployee(String firstName, String lastName);
    Employee searchEmployee(String firstName, String lastName) ;
    List<Employee> showAllEmployeeList();
}