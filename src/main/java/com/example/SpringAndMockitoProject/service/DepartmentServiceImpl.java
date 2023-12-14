package com.example.SpringAndMockitoProject.service;

import com.example.SpringAndMockitoProject.model.Employee;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.Locale.filter;


@Service

public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;


    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> returnMaxSalary(int department) {
        return employeeService.showAllEmployeeList().stream()
                .max(Comparator.comparing(Employee::getSalary)).stream().toList();

    }

    @Override
    public List<Employee>  returnMinSalary (int department) {
        return  employeeService.showAllEmployeeList().stream()
                .min(Comparator.comparing(Employee::getSalary)).stream().toList();
    }

    @Override
    public List<Employee> returnEmployeeByDepartment(int departmentId) {
        return employeeService.showAllEmployeeList().stream()
                .filter(employee -> employee.getDepartmentId()==departmentId)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> returnAllEmployee() {
        return employeeService.showAllEmployeeList()
                .stream().collect(Collectors.groupingBy(Employee::getDepartmentId));

    }

    @Override
    public int totalSalaryByDepartment(int department) {
        return employeeService.showAllEmployeeList().stream()
                .filter(e -> e.getDepartmentId()== department)
                .mapToInt(Employee::getSalary)
                .sum();


    }
}
