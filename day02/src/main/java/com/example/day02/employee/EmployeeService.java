package com.example.day02.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public EmployeeResponse get(int id) {
        return new EmployeeResponse(id, "somkiat");
    }
}
