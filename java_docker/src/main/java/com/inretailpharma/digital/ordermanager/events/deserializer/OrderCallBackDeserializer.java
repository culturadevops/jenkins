package com.inretailpharma.digital.ordermanager.events.deserializer;

import com.inretailpharma.digital.ordermanager.dto.OrderDto;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class OrderCallBackDeserializer extends JsonDeserializer<OrderDto> {

    public OrderCallBackDeserializer() {
        super(OrderDto.class);
    }
}
