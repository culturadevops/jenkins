package com.inretailpharma.digital.ordermanager.factory;

import com.inretailpharma.digital.ordermanager.dto.OrderDto;
import com.inretailpharma.digital.ordermanager.service.IConsumerService;
import com.inretailpharma.digital.ordermanager.service.IPublisherService;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessKakfa extends OrderProcess {

    public OrderProcessKakfa(IPublisherService iPublisherService,
                             IConsumerService iConsumerService) {
        super(iPublisherService, iConsumerService);
    }

    @Override
    public void create() {
        // aca se implementaría lo de kafka
    }

    @Override
    public void send(OrderDto orderDto) {

        iPublisherService.sendOrder(orderDto);
    }

    @Override
    public void receiver(OrderDto orderDto, Acknowledgment acknowledgment) {
        iConsumerService.receiverOrderCallback(orderDto, acknowledgment);
    }


}
