package com.oleh.pavliuk.patterns.service;

import com.oleh.pavliuk.patterns.model.UserAccount;
import com.oleh.pavliuk.patterns.repository.UserAccountRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository repository;

    public void create(UserAccount account) {
        repository.save(account);
    }

    public List<UserAccount> getAll() {
        return repository.findAll();
    }

    public UserAccount getById(Long id) {
        return repository.getReferenceById(id);
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
