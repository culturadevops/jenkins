package com.inretailpharma.digital.ordermanager.events;

import com.inretailpharma.digital.ordermanager.dto.OrderDto;
import com.inretailpharma.digital.ordermanager.service.IConsumerService;
import com.inretailpharma.digital.ordermanager.service.IPublisherService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class KafkaEvent {

    @Qualifier("kafkaPublisherService")
    private IPublisherService iPublisherService;

    private IConsumerService iConsumerService;

    public KafkaEvent(IPublisherService iPublisherService, IConsumerService iConsumerService) {
        this.iPublisherService = iPublisherService;
        this.iConsumerService = iConsumerService;
    }

    public void updateStatusOrder(OrderDto orderDto) {

        iPublisherService.sendOrder(orderDto);

    }

}
