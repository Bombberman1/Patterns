package com.oleh.pavliuk.model;

public class KpiRecord {
    private String kpiId, kpiName, value, dataType, period, startDate, endDate, frequency;

    public KpiRecord(String kpiId, String kpiName, String value, String dataType,
                     String period, String startDate, String endDate, String frequency) {
        this.kpiId = kpiId;
        this.kpiName = kpiName;
        this.value = value;
        this.dataType = dataType;
        this.period = period;
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s = %s (%s)", period, kpiId, value, frequency);
    }
}
