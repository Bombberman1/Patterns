package com.oleh.pavliuk.patterns.utility;

import com.oleh.pavliuk.patterns.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CsvRunner implements CommandLineRunner {

    private final EmployeeService employeeService;

    @Override
    public void run(String... args) {
        employeeService.saveSampleEmployee();
    }
}
