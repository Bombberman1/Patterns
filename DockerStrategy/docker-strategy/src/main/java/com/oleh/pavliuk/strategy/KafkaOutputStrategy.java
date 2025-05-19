package com.oleh.pavliuk.strategy;

import com.oleh.pavliuk.model.KpiRecord;

import org.apache.kafka.clients.producer.*;

import java.util.List;
import java.util.Properties;

public class KafkaOutputStrategy implements OutputStrategy {
    private final Producer<String, String> producer;
    private final String topic = "kpi-topic";

    public KafkaOutputStrategy() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<>(props);
    }

    @Override
    public void output(List<KpiRecord> records) {
        for (KpiRecord record : records) {
            producer.send(new ProducerRecord<>(topic, record.toString()));
        }
        producer.flush();
        producer.close();
        System.out.println("Kpi data sent to Kafka");
    }
}
