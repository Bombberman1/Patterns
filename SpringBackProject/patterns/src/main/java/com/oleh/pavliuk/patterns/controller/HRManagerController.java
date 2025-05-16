package com.oleh.pavliuk.patterns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oleh.pavliuk.patterns.model.HRManager;
import com.oleh.pavliuk.patterns.service.HRManagerService;

import lombok.*;

@RestController
@RequestMapping("/api/hr-manager")
@RequiredArgsConstructor
public class HRManagerController {
    @Autowired
    private final HRManagerService service;

    @GetMapping
    public List<HRManager> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HRManager get(@PathVariable Long id) {
        return service.getById(id);
    }
}
