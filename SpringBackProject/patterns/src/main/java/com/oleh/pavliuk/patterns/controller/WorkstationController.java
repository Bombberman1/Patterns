package com.oleh.pavliuk.patterns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oleh.pavliuk.patterns.model.Workstation;
import com.oleh.pavliuk.patterns.service.WorkstationService;

import lombok.*;

@RestController
@RequestMapping("/api/workstation")
@RequiredArgsConstructor
public class WorkstationController {
    @Autowired
    private final WorkstationService service;

    @GetMapping
    public List<Workstation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Workstation get(@PathVariable Long id) {
        return service.getById(id);
    }
}
