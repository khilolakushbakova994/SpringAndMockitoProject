package com.example.SpringAndMockitoProject.service;

import com.example.SpringAndMockitoProject.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    private static final List<Employee> LIST = List.of(
            new Employee("Ольга", "Владимирова", 1, 200),
            new Employee("Аиша", "Алиева", 1, 300),
            new Employee("Лев", "Толстой", 1, 300)
    );
    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void setUp() {
        when(employeeServiceMock.showAllEmployeeList()).thenReturn(LIST);
    }
    @AfterEach
    void setOut(){
        verify(employeeServiceMock, only()).showAllEmployeeList();

    }


    @Test
    void returnMaxSalary() {
        int expected = 300;
        List<Employee> result = out.returnMaxSalary(1);
        assertEquals(expected, result);


    }

    @Test
    void returnMinSalary() {
        int expected = 200;
        List<Employee> result = out.returnMinSalary(1);
        assertEquals(expected, result);

    }

    @Test
    void returnEmployeeByDepartment() {

        List<Employee> expected = List.of(
                new Employee("Ольга", "Владимирова", 1, 200),
                new Employee("Аиша", "Алиева", 1, 300));
        List<Employee> result = out.returnEmployeeByDepartment(1);
        Assertions.assertEquals(expected.size(), result.size());


    }

    @Test
    void returnAllEmployee() {
        Map<Integer, List<Employee>> result = out.returnAllEmployee();
        List<Employee> res = result.get(1);
        List <Employee> exp = List.of(
                new Employee("Ольга", "Владимирова", 1, 200),
                new Employee("Аиша", "Алиева", 1, 300));
        Assertions.assertEquals(exp.size(), res.size());
        Assertions.assertEquals(exp.get(0), res.get(0));

    }

    @Test
    void totalSalaryByDepartment() {
        int expected = 800;
        int result = out.totalSalaryByDepartment(1);
        assertEquals(expected, result);
    }
}