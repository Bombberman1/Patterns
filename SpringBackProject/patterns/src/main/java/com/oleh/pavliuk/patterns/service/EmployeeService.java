package com.oleh.pavliuk.patterns.service;

import com.oleh.pavliuk.patterns.model.Employee;
import com.oleh.pavliuk.patterns.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public void create(Employee employee) {
        repository.save(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.getReferenceById(id);
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
