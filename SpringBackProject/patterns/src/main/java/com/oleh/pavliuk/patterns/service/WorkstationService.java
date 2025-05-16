package com.oleh.pavliuk.patterns.service;

import com.oleh.pavliuk.patterns.model.Workstation;
import com.oleh.pavliuk.patterns.repository.WorkstationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkstationService {
    @Autowired
    private WorkstationRepository repository;

    public void create(Workstation workstation) {
        repository.save(workstation);
    }

    public List<Workstation> getAll() {
        return repository.findAll();
    }

    public Workstation getById(Long id) {
        return repository.getReferenceById(id);
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
