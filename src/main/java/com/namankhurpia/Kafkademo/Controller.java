package com.namankhurpia.Kafkademo;

import com.namankhurpia.Kafkademo.Models.KafkaProperties;
import com.namankhurpia.Kafkademo.Models.SendData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    KafkaService kafkaService;

    @PostMapping("/check")
    public String establishConnection(@RequestBody KafkaProperties kafkaProperties) {
        return kafkaService.establishConnectionService(kafkaProperties);
    }

    @GetMapping("/send")
    public void sendWithoutAck(@RequestBody SendData data)
    {
        kafkaService.send(data);
    }

}
