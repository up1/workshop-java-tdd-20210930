package com.example.day02.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeController2Test {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void getById2() {
        // Arrange
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("Pui");
        when(employeeRepository.findById(100)).thenReturn(Optional.of(employee));
        // Act
        EmployeeResponse result
                = restTemplate.getForObject("/employee/100", EmployeeResponse.class);
        // Assert
        assertEquals(100, result.getId());
        assertEquals("Pui", result.getName());
    }

}