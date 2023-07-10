package com.namankhurpia.Kafkademo;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class KafkaService {

    public Properties UnWrapPropertiesFromArray(KafkaProperties kafkaProperties)
    {

        Properties properties = new Properties();
        
        String apiKey = "HB7NVOYJYE5JC2UA";
        String apiSecret = "TCEqc1e6G+K70Zv0U8PTySdMx8DW0vd6N51flyzM33JN9Uj+0X2mQMcez0F8pz13";

        System.out.println("org.apache.kafka.common.security.plain.PlainLoginModule required username=\""+apiKey+"\" password=\""+apiSecret +"\";");

        //properties.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\""+apiKey+"\" password=\""+apiSecret+"\";");

        properties.put("bootstrap.servers", kafkaProperties.getBootstrapserver());

        //key serializer
        if(kafkaProperties.getKeySerializer()!=null && !kafkaProperties.getKeySerializer().isEmpty())
            properties.put("key.serializer", kafkaProperties.getKeySerializer());
        else
            properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //value serializer
        if(kafkaProperties.getValueSerializer()!=null && !kafkaProperties.getValueSerializer().isEmpty())
            properties.put("value.serializer", kafkaProperties.getValueSerializer());
        else
            properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //idempotence
        if(kafkaProperties.getIdempotence()!=null && !kafkaProperties.getIdempotence().isEmpty())
            properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, kafkaProperties.getIdempotence());
        else
            properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "false");


        for(Map.Entry<String,String> map : kafkaProperties.getList().entrySet())
        {
            properties.put(map.getKey(), map.getValue());
        }

        return properties;
    }

    public String callme()
    {
        return "heyman";
    }

    public String establishConnectionService(KafkaProperties kafkaProperties)
    {
        Properties properties = UnWrapPropertiesFromArray(kafkaProperties);
        // Check for partitions
        Producer<String, String> producer = new KafkaProducer<>(properties);

        try {

            List<PartitionInfo> partitions = producer.partitionsFor(kafkaProperties.getTopicName());

            if (partitions != null && !partitions.isEmpty()) {
                System.out.println("Producer is connected to Kafka cluster.");
            } else {
                System.out.println("Producer is not connected to Kafka cluster.");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
        finally {
            producer.close();
            return "Initialized Successfully";
        }








    }




}
