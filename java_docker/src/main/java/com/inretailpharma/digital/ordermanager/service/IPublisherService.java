package com.inretailpharma.digital.ordermanager.service;

import com.inretailpharma.digital.ordermanager.dto.OrderDto;

public interface IPublisherService {

    void sendOrder(OrderDto orderDto);

    void sendOrderCallBack(OrderDto orderDto);


}
