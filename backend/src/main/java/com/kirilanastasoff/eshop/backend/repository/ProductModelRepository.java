package com.kirilanastasoff.eshop.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirilanastasoff.eshop.backend.model.OrderModel;
import com.kirilanastasoff.eshop.backend.model.ProductModel;

public interface ProductModelRepository extends JpaRepository<ProductModel, Long> {
	List<OrderModel> findByName(String name);
}
