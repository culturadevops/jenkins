package com.inretailpharma.digital.ordermanager.service.impl;

import com.inretailpharma.digital.ordermanager.dto.OrderDto;
import com.inretailpharma.digital.ordermanager.service.IConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service("kafkaConsumerService")
public class KafkaConsumerServiceImpl implements IConsumerService {


    @KafkaListener(topics = "order_callback_topic")
    @Override
    public void receiverOrderCallback(OrderDto orderDto, Acknowledgment acknowledgment) {
        log.info("received dto");
        acknowledgment.acknowledge();
    }
}
