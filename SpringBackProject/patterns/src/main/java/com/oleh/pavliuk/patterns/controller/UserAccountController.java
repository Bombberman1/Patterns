package com.oleh.pavliuk.patterns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oleh.pavliuk.patterns.model.UserAccount;
import com.oleh.pavliuk.patterns.service.UserAccountService;

import lombok.*;

@RestController
@RequestMapping("/api/user-account")
@RequiredArgsConstructor
public class UserAccountController {
    @Autowired
    private final UserAccountService service;

    @GetMapping
    public List<UserAccount> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserAccount get(@PathVariable Long id) {
        return service.getById(id);
    }
}
