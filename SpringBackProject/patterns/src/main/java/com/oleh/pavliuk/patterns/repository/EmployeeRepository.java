package com.oleh.pavliuk.patterns.repository;

import com.oleh.pavliuk.patterns.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
