package com.example.SpringAndMockitoProject.controller;

import com.example.SpringAndMockitoProject.model.Employee;
import com.example.SpringAndMockitoProject.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringAndMockitoProject.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;

    }
    @GetMapping("/add")
    public Employee addEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("department") int department, @RequestParam ("salary") int salary) {
        return employeeService.addEmployee(firstName, lastName , department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstName,lastName);
    }

    @GetMapping("/find")
    public Employee searchEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.searchEmployee(firstName,lastName);

    }
    @GetMapping
    public Collection<Employee> showAllEmployeeList () {
        return employeeService.showAllEmployeeList();
    }

}