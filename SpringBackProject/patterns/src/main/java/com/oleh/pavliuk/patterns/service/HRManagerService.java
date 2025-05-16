package com.oleh.pavliuk.patterns.service;

import com.oleh.pavliuk.patterns.model.HRManager;
import com.oleh.pavliuk.patterns.repository.HRManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HRManagerService {
    @Autowired
    private HRManagerRepository repository;

    public HRManager create(HRManager manager) {
        return repository.save(manager);
    }

    public List<HRManager> getAll() {
        return repository.findAll();
    }

    public HRManager getById(Long id) {
        return repository.getReferenceById(id);
    }

    public Optional<HRManager> findByName(String name) {
        return repository.findByName(name);
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
