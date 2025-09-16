package com.sarv.kafka;

import org.apache.kafka.clients.consumer.*;

import java.util.Collections;
import java.util.Properties;

public class ChatConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "chat-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("chat-topic"));

        while (true) {
            for (ConsumerRecord<String, String> record : consumer.poll(java.time.Duration.ofMillis(100))) {
                System.out.printf("Received: %s from %s%n", record.value(), record.key());
            }
        }
    }
}
