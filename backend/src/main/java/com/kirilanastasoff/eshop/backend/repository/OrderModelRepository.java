package com.kirilanastasoff.eshop.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirilanastasoff.eshop.backend.model.OrderModel;

public interface OrderModelRepository extends JpaRepository<OrderModel, Long> {
	List<OrderModel> findByPaymentMethod(String paymentMethod);
}
