package com.oleh.pavliuk.patterns.service;

import com.oleh.pavliuk.patterns.model.Employee;
import com.oleh.pavliuk.patterns.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void saveSampleEmployee() {
        Employee employee = Employee.builder()
            .name("Іван Петров")
            .position("Junior Developer")
            .startDate(new Date())
            .build();

        employeeRepository.save(employee);
    }
}
