package com.inretailpharma.digital.ordermanager.factory;

import com.inretailpharma.digital.ordermanager.dto.OrderDto;
import com.inretailpharma.digital.ordermanager.service.IConsumerService;
import com.inretailpharma.digital.ordermanager.service.IPublisherService;
import org.springframework.kafka.support.Acknowledgment;

public abstract class OrderProcess {

    public IPublisherService iPublisherService;
    public IConsumerService iConsumerService;

    public OrderProcess(IPublisherService iPublisherService, IConsumerService iConsumerService) {
        this.iPublisherService = iPublisherService;
        this.iConsumerService = iConsumerService;
    }

    public abstract void create();

    public abstract void send(OrderDto orderDto);

    public abstract void receiver(OrderDto orderDto, Acknowledgment acknowledgment);

}
