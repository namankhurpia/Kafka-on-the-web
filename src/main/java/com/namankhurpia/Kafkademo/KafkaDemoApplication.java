package com.namankhurpia.Kafkademo;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.errors.TopicExistsException;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class KafkaDemoApplication {



	public static void main(String[] args) throws ExecutionException, InterruptedException {
		SpringApplication.run(KafkaDemoApplication.class, args);
/*
		String bootstrapServers = "pkc-p11xm.us-east-1.aws.confluent.cloud:9092";
		String apiKey = "HB7NVOYJYE5JC2UA";
		String apiSecret = "TCEqc1e6G+K70Zv0U8PTySdMx8DW0vd6N51flyzM33JN9Uj+0X2mQMcez0F8pz13";



		// Kafka producer properties
		Properties properties = new Properties();
		properties.put("bootstrap.servers", bootstrapServers);
		properties.put("security.protocol", "SASL_SSL");
		properties.put("sasl.mechanism", "PLAIN");
		properties.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\""+apiKey+"\" password=\""+apiSecret+"\";");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		// Create Kafka producer
		Producer<String, String> producer = new KafkaProducer<>(properties);

		// Send a test message to a Kafka topic
		String topic = "first-topic";
		String message = "Hello, Kafka!";
		ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);

		try {
			//producer.send(record);
			//producer.send(record);
			List<PartitionInfo> partitions = producer.partitionsFor(topic);

			if (partitions != null && !partitions.isEmpty()) {
				System.out.println("Producer is connected to Kafka cluster.");
			} else {
				System.out.println("Producer is not connected to Kafka cluster.");
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();

		}

*/
	}
}



