package com.shah.learn.consumer;

import com.shah.learn.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaMessageListener {

    @KafkaListener(topics = "test-topic-1",groupId = "test-topic-group-id")
    public void consumeMessage(String message){
       log.info("Consume the message : {}",message);
    }

    @KafkaListener(topics = "customer-topic",groupId = "customer-topic-group-id",containerFactory = "listenerContainerFactory")
    public void consumeCustomerMessage(Customer customer){
        log.info("Consume the customer-message: {}",customer);
    }
}
