package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class EmployeeTest {
    private Employee employee;

    @BeforeEach
    void setUp(){
        employee = new Employee("Dana Scully",35000.0);
    }
    @AfterEach
    void tearDown(){
        this.employee = null;
    }
    @Test
    @DisplayName("Get employee by id when id exists")
    void get_Employee_by_id_when_id_exits(){
        //Employee employee = new Employee("Dana Scully",35000);
       // var result = employee.getId();
        //assertThat("Dana Scully").isEqualTo(result);
        assertThat(employee.getId()).isEqualTo("Dana Scully");
    }

    @Test
    @DisplayName("Check if the salary is correctly .")
    void checkIfTheSalaryIsCorrectly(){
        //Employee employee = new Employee("Dana Scully",35000);
        //var result = employee.getSalary();
        //assertThat(35000.0).isEqualTo(result);
        assertThat(employee.getSalary()).isEqualTo(35000.0);
    }

    @Test
    @DisplayName("Check if the salary is paid ")
    void CheckIfTheSalaryIsPaid(){
        Employee employee = new Employee("Dana Scully",35000);
        boolean paidSalary = false;
        assertThat(paidSalary).isEqualTo(employee.isPaid());
    }

    @Test
    @DisplayName("Change id on  employee")
    void ChangeIdOnEmployee(){
       // Employee employee = new Employee("Dana Scully",35000);
        String newId = "Fox Mulder";
        employee.setId(newId);
        assertThat(newId).isEqualTo(employee.getId());
    }

    @Test
    @DisplayName("Change employee salary")
    void changeEmployeeSalary(){
        //Employee employee = new Employee("Dana Scully",35000);
        double newSalary = 55000.0;
        employee.setSalary(newSalary);
        assertThat(employee.getSalary()).isEqualTo(newSalary);
    }

    @Test
    @DisplayName("Change employee paid status")
    void changeEmployeePaidStatus(){
       // Employee employee = new Employee("Dana Scully",35000);
        employee.setPaid(true);
        assertThat(employee.isPaid()).isTrue();

    }

    @Test
    @DisplayName("Check if to string method returns correct form")
    void checkIfToStringMethodReturnsCorrectForm(){
      String correctFormatExpected = "Employee [id=" + employee.getId() + ", salary=" + employee.getSalary() + "]";
      String actuall = employee.toString();
      assertThat(actuall).isEqualTo(correctFormatExpected);
    }
}