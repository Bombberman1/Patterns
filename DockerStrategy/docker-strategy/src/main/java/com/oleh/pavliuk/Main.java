package com.oleh.pavliuk;

import com.oleh.pavliuk.model.KpiRecord;
import com.oleh.pavliuk.service.*;
import com.oleh.pavliuk.strategy.*;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/application.properties"));

        String outputType = props.getProperty("output.type");
        OutputStrategy strategy;

        switch (outputType) {
            case "kafka":
                strategy = new KafkaOutputStrategy(); break;
            case "redis":
                strategy = new RedisOutputStrategy(); break;
            default:
                strategy = new ConsoleOutputStrategy();
        }

        CsvReader reader = new CsvReader();
        List<KpiRecord> records = reader.read("csv_data/kpi-prifsma.csv");

        new KpiProcessor(strategy).process(records);
    }
}
