package com.kirilanastasoff.eshop.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirilanastasoff.eshop.backend.model.OrderModel;
import com.kirilanastasoff.eshop.backend.model.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, Long> {
	List<OrderModel> findByEmail(String email);
}
