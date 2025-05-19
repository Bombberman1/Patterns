package com.oleh.pavliuk.service;

import com.oleh.pavliuk.model.KpiRecord;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class CsvReader {
    public List<KpiRecord> read(String path) throws IOException {
        return Files.lines(Paths.get(path))
            .skip(1)
            .map(line -> line.split("\",\""))
            .map(this::toKpiRecord)
            .collect(Collectors.toList());
    }

    private KpiRecord toKpiRecord(String[] data) {
        return new KpiRecord(
            data[0].replaceAll("\"", ""),
            data[1],
            data[2],
            data[3],
            data[4],
            data[5],
            data[6],
            data[7].replace("\"", "")
        );
    }
}
