package com.oleh.pavliuk.patterns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oleh.pavliuk.patterns.model.Mentor;
import com.oleh.pavliuk.patterns.service.MentorService;

import lombok.*;

@RestController
@RequestMapping("/api/mentor")
@RequiredArgsConstructor
public class MentorController {
    @Autowired
    private final MentorService service;

    @GetMapping
    public List<Mentor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mentor get(@PathVariable Long id) {
        return service.getById(id);
    }
}
