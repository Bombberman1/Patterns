package com.oleh.pavliuk.patterns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oleh.pavliuk.patterns.model.ITAdministrator;
import com.oleh.pavliuk.patterns.service.ITAdministratorService;

import lombok.*;

@RestController
@RequestMapping("/api/it-administrator")
@RequiredArgsConstructor
public class ITAdministratorController {
    @Autowired
    private final ITAdministratorService service;

    @GetMapping
    public List<ITAdministrator> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ITAdministrator get(@PathVariable Long id) {
        return service.getById(id);
    }
}
