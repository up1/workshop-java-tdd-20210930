package com.example.day02.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void get() {
        // Arrange
        Employee employee = new Employee();
        employee.setId(99);
        employee.setName("Mock with unit test");
        when(employeeRepository.findById(99))
                .thenReturn(Optional.of(employee));
        EmployeeService service = new EmployeeService(employeeRepository);
        // Act
        EmployeeResponse result = service.get(99);
        // Assert
        assertEquals(99, result.getId());
        assertEquals("Mock with unit test", result.getName());
    }
}