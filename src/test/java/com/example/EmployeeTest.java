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
    void getEmployeebyIdWhenIdExits(){
        assertThat(employee.getId()).isEqualTo("Dana Scully");
    }

    @Test
    @DisplayName("Check if the salary is correct")
    void checkIfTheSalaryIsCorrect(){
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
        String newId = "Fox Mulder";
        employee.setId(newId);
        assertThat(newId).isEqualTo(employee.getId());
    }

    @Test
    @DisplayName("Change employee salary")
    void changeEmployeeSalary(){
        double newSalary = 55000.0;
        employee.setSalary(newSalary);
        assertThat(employee.getSalary()).isEqualTo(newSalary);
    }

    @Test
    @DisplayName("Change employee paid status")
    void changeEmployeePaidStatus(){
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


    @Test
    @DisplayName("SetId method accepts null value ")
    void setIdMethodAcceptsNullValue(){
        assertThatCode(() -> employee.setId(null))
                .doesNotThrowAnyException();
        assertThat(employee.getId()).isNull();
    }

    // kanke önodig test . Jag har coverage utan den
    @Test
    void toString_HandlesNullIdGracefully() {
        employee.setId(null);
        String result = employee.toString();
        String expectedResult = "Employee [id=null, salary=" + employee.getSalary() + "]";
        assertThat(result).isEqualTo(expectedResult);
    }

}

