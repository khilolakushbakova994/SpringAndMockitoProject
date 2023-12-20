package com.example.SpringAndMockitoProject.service;

import com.example.SpringAndMockitoProject.exeptions.FullStorageException;
import com.example.SpringAndMockitoProject.exeptions.InvalidTextException;
import com.example.SpringAndMockitoProject.exeptions.EmployeeAlreadyAddedException;
import com.example.SpringAndMockitoProject.exeptions.EmployeeNotFoundException;
import com.example.SpringAndMockitoProject.model.Employee;
import org.springframework.stereotype.Service;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;


@Service

public class EmployeeServiceImpl implements EmployeeService {
    public static final Integer MAX = 4;
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        if (!checkName(firstName, lastName) ){
            throw new InvalidTextException();
        }
        if(employees.size()>=MAX){
            throw new FullStorageException();
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("уже есть такой сотрудник");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (!checkName(firstName, lastName) ){
            throw new InvalidTextException();}
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
    }

    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        if (!checkName(firstName, lastName) ){
            throw new InvalidTextException();}
        Employee employee = new Employee(firstName, lastName);

        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
    }

    @Override
    public List<Employee> showAllEmployeeList() {

        return Collections.unmodifiableList(employees.values().stream().toList());
    }

    private boolean checkName(String firstName, String lastName) {
        return  isAlpha(firstName) && isAlpha(lastName);

    }

}
