package com.inretailpharma.digital.ordermanager.repository;

import com.inretailpharma.digital.ordermanager.entity.OrderStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, String> {

}
