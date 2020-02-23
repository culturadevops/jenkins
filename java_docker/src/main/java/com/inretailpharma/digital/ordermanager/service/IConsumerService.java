package com.inretailpharma.digital.ordermanager.service;

import com.inretailpharma.digital.ordermanager.dto.OrderDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

public interface IConsumerService {

    void receiverOrderCallback(OrderDto orderDto, Acknowledgment acknowledgment);
}
