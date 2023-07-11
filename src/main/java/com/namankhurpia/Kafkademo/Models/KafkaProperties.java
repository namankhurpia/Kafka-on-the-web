package com.namankhurpia.Kafkademo.Models;

import lombok.Data;

import java.util.HashMap;

@Data
public class KafkaProperties {

    /*
    required
    topic name
     */
    String topicName;

    /*
    required
    bootstrapserver
     */
    String bootstrapserver;

    /*
    optional
    default is String Serializer
     */
    String keySerializer;

    /*
    optional
    default is String Serializer
     */
    String valueSerializer;

    /*
    optional
    default is false
     */
    String idempotence;


    /*
    optional
    Contains all other properties in form of List
     */
    HashMap<String,String> list;

    public KafkaProperties( ) {

    }

    public KafkaProperties(String topicName, String bootstrapserver, String keySerializer, String valueSerializer, String idempotence, HashMap<String, String> list) {
        this.topicName = topicName;
        this.bootstrapserver = bootstrapserver;
        this.keySerializer = keySerializer;
        this.valueSerializer = valueSerializer;
        this.idempotence = idempotence;
        this.list = list;
    }
}
