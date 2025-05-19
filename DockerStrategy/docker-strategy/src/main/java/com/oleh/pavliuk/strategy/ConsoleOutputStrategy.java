package com.oleh.pavliuk.strategy;

import com.oleh.pavliuk.model.KpiRecord;

import java.util.List;

public class ConsoleOutputStrategy implements OutputStrategy {
    @Override
    public void output(List<KpiRecord> records) {
        records.forEach(System.out::println);
    }
}
