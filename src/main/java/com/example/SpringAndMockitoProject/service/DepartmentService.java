package com.example.SpringAndMockitoProject.service;

import com.example.SpringAndMockitoProject.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    public List<Employee>  returnMaxSalary (int department);
    public List<Employee>  returnMinSalary( int department);
    public List<Employee> returnEmployeeByDepartment (int department);
    public Map<Integer, List <Employee>> returnAllEmployee ();
    public int totalSalaryByDepartment (int department);

}