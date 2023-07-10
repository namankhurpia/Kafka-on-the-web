package com.namankhurpia.Kafkademo;

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


}
