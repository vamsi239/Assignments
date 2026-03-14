package com.lpu.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.orderservice.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
