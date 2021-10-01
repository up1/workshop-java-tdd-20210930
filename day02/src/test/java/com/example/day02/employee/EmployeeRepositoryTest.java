package com.example.day02.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void case01() {
        // Arrange
        Employee demo = new Employee();
        demo.setName("somkiat");
        employeeRepository.save(demo);
        // Act
        Optional<Employee> result = employeeRepository.findById(1);
        // Assert
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("somkiat", result.get().getName());
    }

    @Test
    public void case02() {
        // Act
        Optional<Employee> result = employeeRepository.findById(1);
        // Assert
        assertFalse(result.isPresent());
    }

}