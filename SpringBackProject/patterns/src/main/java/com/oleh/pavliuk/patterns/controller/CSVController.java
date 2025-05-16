package com.oleh.pavliuk.patterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oleh.pavliuk.patterns.service.CSVService;

import lombok.*;

@RestController
@RequestMapping("/api/csv")
@RequiredArgsConstructor
public class CSVController {
    @Autowired
    private final CSVService service;

    @GetMapping("/generate")
    public String generate_csv() {
        service.generate_csv();
        return "Generated";
    }

    @GetMapping("/import")
    public String import_csv() {
        service.import_csv();
        return "Imported";
    }
}
