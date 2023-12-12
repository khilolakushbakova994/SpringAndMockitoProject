package com.example.SpringAndMockitoProject.controller;

import com.example.SpringAndMockitoProject.service.DepartmentService;
import com.example.SpringAndMockitoProject.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.SpringAndMockitoProject.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping ("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {this.departmentService = departmentService;}

    @GetMapping("/{id}/salary/sum")
    public int showDepartmentTotalSalary (@PathVariable("id")  int department){
        return departmentService.totalSalaryByDepartment (department);
    }

    @GetMapping("/{id}/salary/max")
    public List<Employee> returnMaxSalary
            (@PathVariable ("id")  int departmentID){
        return departmentService.returnMaxSalary(departmentID);
    }
    @GetMapping ("/{id}/salary/min")
    public List<Employee> returnMinSalary
            (@PathVariable("id") int departmentID){
        return departmentService.returnMinSalary(departmentID);
    }
    @GetMapping ("/{id}/employees")
    public List<Employee> returnEmployeeByDepartment (@PathVariable("id") int departmentID){
        return departmentService.returnEmployeeByDepartment(departmentID);
    }
    @GetMapping ("/employees")
    public Map<Integer, List <Employee>> returnAll (){
        return departmentService.returnAllEmployee ();
    }

}
