package com.oleh.pavliuk.patterns.service;

import com.oleh.pavliuk.patterns.model.Mentor;
import com.oleh.pavliuk.patterns.repository.MentorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService {
    @Autowired
    private MentorRepository repository;

    public void create(Mentor mentor) {
        repository.save(mentor);
    }

    public List<Mentor> getAll() {
        return repository.findAll();
    }

    public Mentor getById(Long id) {
        return repository.getReferenceById(id);
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
