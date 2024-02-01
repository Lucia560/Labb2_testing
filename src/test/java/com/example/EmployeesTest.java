package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeesTest {

    private FakeBankService fakeBankService; // obj of class that implements interface BankService to test upon
    @Mock
    private BankService bankService;
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private Employees employees;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

 @BeforeEach
 void setUp(){
  employee1 = new Employee("Mira Bella", 55000.0);
  employee2 = new Employee("J.O Skinner",150000.0);
  employee3 = new Employee("Tom Spencer",45000.0);
  Mockito.when(employeeRepository.findAll()).thenReturn(List.of(employee1, employee2,employee3));
 }

 @Test
 @DisplayName("Test payment with spy on FakeBankService")
 void testPaymentWithSpy() {
     fakeBankService = new FakeBankService();
     BankService spyBankService = Mockito.spy(fakeBankService);// use spy
     employees = new Employees(employeeRepository, spyBankService); // new obj with spy attached

     employees.payEmployees();

     Mockito.verify(spyBankService).pay(employee1.getId(), employee1.getSalary());
     Mockito.verify(spyBankService).pay(employee2.getId(), employee2.getSalary());
     Mockito.verify(spyBankService).pay(employee3.getId(), employee3.getSalary());
     assertTrue(employee1.isPaid());
     assertTrue(employee2.isPaid());
     assertTrue(employee3.isPaid());
    }



    @Test
  @DisplayName("catch Runtime exception")
  void  catchRuntimeException(){
     Mockito.doThrow(RuntimeException.class).when(bankService).pay(employee1.getId(),employee1.getSalary());
     int payments = employees.payEmployees();

     assertEquals(2,payments);
     Mockito.verify(bankService).pay(employee1.getId(), employee1.getSalary());
     Mockito.verify(bankService).pay(employee2.getId(), employee2.getSalary());
     assertFalse(employee1.isPaid());
     assertTrue(employee2.isPaid());
 }

}