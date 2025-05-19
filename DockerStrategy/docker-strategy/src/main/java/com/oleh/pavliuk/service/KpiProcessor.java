package com.oleh.pavliuk.service;

import com.oleh.pavliuk.model.KpiRecord;
import com.oleh.pavliuk.strategy.OutputStrategy;

import java.util.List;

public class KpiProcessor {
    private OutputStrategy strategy;

    public KpiProcessor(OutputStrategy strategy) {
        this.strategy = strategy;
    }

    public void process(List<KpiRecord> records) {
        strategy.output(records);
    }
}
