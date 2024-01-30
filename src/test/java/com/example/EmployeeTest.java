package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class EmployeeTest {
    @Test
    @DisplayName("Get employee by id when id exists")
    void get_Employee_by_id_when_id_exits(){
        Employee employee = new Employee("Dana Scully",35000);
        var result = employee.getId();
        assertThat("Dana Scully").isEqualTo(result);
    }

    @Test
    @DisplayName("Check if the salary is correctly .")
    void checkIfTheSalaryIsCorrectly(){
        Employee employee = new Employee("Dana Scully",35000);
        var result = employee.getSalary();
        assertThat(35000.0).isEqualTo(result);
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
        Employee employee = new Employee("Dana Scully",35000);
        String newId = "fox Mulder";
        employee.setId(newId);
        assertThat(newId).isEqualTo(employee.getId());
    }

    @Test
    @DisplayName("Change employee salary")
    void changeEmployeeSalary(){
        Employee employee = new Employee("Dana Scully",35000);
        double newSalary = 55000.0;
        employee.setSalary(newSalary);
        assertThat(employee.getSalary()).isEqualTo(newSalary);
    }

    @Test
    @DisplayName("Change employee paid status")
    void changeEmployeePaidStatus(){
        Employee employee = new Employee("Dana Scully",35000);
        employee.setPaid(true);
        assertThat(employee.isPaid()).isTrue();

    }



}