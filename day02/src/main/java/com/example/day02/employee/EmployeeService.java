package com.example.day02.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponse get(int id) {
        // TODO :: read data from database
        Optional<Employee> result = employeeRepository.findById(id);
        if(result.isPresent()) {
            return new EmployeeResponse(id, result.get().getName());
        }
        throw new RuntimeException("Employee not found with id=" + id);
    }
}
