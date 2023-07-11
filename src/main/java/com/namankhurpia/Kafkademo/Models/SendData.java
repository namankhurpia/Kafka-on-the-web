package com.namankhurpia.Kafkademo.Models;

import lombok.Data;

@Data
public class SendData {

    /*
    required
     */
    String data;

    /*
    required
     */
    String topic;
}
