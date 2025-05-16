package com.oleh.pavliuk.patterns.service;

import com.oleh.pavliuk.patterns.model.ITAdministrator;
import com.oleh.pavliuk.patterns.repository.ITAdministratorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ITAdministratorService {
    @Autowired
    private ITAdministratorRepository repository;

    public ITAdministrator create(ITAdministrator admin) {
        return repository.save(admin);
    }

    public List<ITAdministrator> getAll() {
        return repository.findAll();
    }

    public ITAdministrator getById(Long id) {
        return repository.getReferenceById(id);
    }

    public Optional<ITAdministrator> findByName(String name) {
        return repository.findByName(name);
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
