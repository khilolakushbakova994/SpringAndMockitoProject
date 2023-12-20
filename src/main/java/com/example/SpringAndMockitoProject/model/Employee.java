package com.example.SpringAndMockitoProject.model;


import java.util.Objects;

public class  Employee {
    public String firstName;
    public String lastName;
    public int salary;
    public int departmentId;

    public Employee(String firstName, String lastName, int departmentId, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId=departmentId;
        this.salary =salary;
    }

    public Employee(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName= lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName (){
        return firstName + lastName;  }

    public int getSalary() {
        return salary;
    }


    public int getDepartmentId() {
        return departmentId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Работники{" +
                "имя='" + firstName + '\'' +
                ", фамилия='" + lastName + '\'' +
                '}';
    }
}

