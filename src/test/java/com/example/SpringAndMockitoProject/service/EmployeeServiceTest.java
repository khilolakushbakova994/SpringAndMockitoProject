package com.example.SpringAndMockitoProject.service;

import com.example.SpringAndMockitoProject.exeptions.*;
import com.example.SpringAndMockitoProject.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class EmployeeServiceTest {
    private EmployeeServiceImpl out ;
    private final Employee FIRST_EMPLOYEE = new Employee("Ольга", "Владимирова", 1, 200);
    private final Employee SECOND_EMPLOYEE = new Employee("Аиша", "Алиева", 1, 300);
    private final Employee THIRD_EMPLOYEE = new Employee ("Лев", "Толстой", 2, 300);
    @BeforeEach
    public  void  setUp (){
        out= new EmployeeServiceImpl();
    }

    @Test
    void addEmployee() {
       Employee add = out.addEmployee(
               FIRST_EMPLOYEE.getFirstName(),
               FIRST_EMPLOYEE.getLastName(),
               FIRST_EMPLOYEE.getDepartmentId(),
               FIRST_EMPLOYEE.getSalary());
       assertEquals(FIRST_EMPLOYEE, add);
       assertEquals(1, out.showAllEmployeeList().size());

    }
    @Test
    void alreadyAddedException(){
        out.addEmployee(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getDepartmentId(),
                FIRST_EMPLOYEE.getSalary());
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () ->   out.addEmployee(
                        FIRST_EMPLOYEE.getFirstName(),
                        FIRST_EMPLOYEE.getLastName(),
                        FIRST_EMPLOYEE.getDepartmentId(),
                        FIRST_EMPLOYEE.getSalary()));
    }
    @Test
    void fullStorageException(){
        out.addEmployee("Раиса", "Нурутдинова", 1, 500);
        out.addEmployee("Надежда", "Ким", 1, 200);
        out.addEmployee("Ильза", "Цой", 1, 500);
        out.addEmployee("Любовь", "Викторова", 1, 200);

        Assertions.assertThrows(FullStorageException.class,
                () -> out.addEmployee("Тина", "Тернор", 1, 1000));

    }
    @Test
    void badRequestException (){
       Assertions.assertThrows(InvalidTextException.class, () ->
        out.addEmployee("123", "2.3", 1, 500));
    }

    @Test
    void removeEmployee() {
        out.addEmployee("Омар", "Хаям", 2, 2000);
        assertEquals(1, out.showAllEmployeeList().size());
        out.removeEmployee("Омар", "Хаям");
        assertEquals(0,out.showAllEmployeeList().size());
    }
    @Test
    void notFoundException(){
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () ->out.searchEmployee( "Омар", "Хаям"));
    }

    @Test
    void searchEmployee() {
        out.addEmployee(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getDepartmentId(),
                FIRST_EMPLOYEE.getSalary());
        Employee expected = new Employee(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getDepartmentId(),
                FIRST_EMPLOYEE.getSalary());
        Employee result = out.searchEmployee("Ольга", "Владимирова");
        assertEquals(expected, result);
    }

    @Test
    void showAllEmployeeList() {
        out.addEmployee(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getDepartmentId(),
                FIRST_EMPLOYEE.getSalary());
        out.addEmployee(
                THIRD_EMPLOYEE.getFirstName(),
                THIRD_EMPLOYEE.getLastName(),
                THIRD_EMPLOYEE.getDepartmentId(),
                THIRD_EMPLOYEE.getSalary());
        List<Employee> expected  = List.of(
                new Employee(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getDepartmentId(),
                FIRST_EMPLOYEE.getSalary()),
                new Employee(
                        THIRD_EMPLOYEE.getFirstName(),
                        THIRD_EMPLOYEE.getLastName(),
                        THIRD_EMPLOYEE.getDepartmentId(),
                        THIRD_EMPLOYEE.getSalary()));
        List<Employee> result = out.showAllEmployeeList();
        assertEquals(expected.size(), result.size());
    }
}