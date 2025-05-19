package com.oleh.pavliuk.strategy;

import com.oleh.pavliuk.model.KpiRecord;

import java.util.List;

public interface OutputStrategy {
    void output(List<KpiRecord> records);
}
