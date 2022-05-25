package com.kirilanastasoff.eshop.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirilanastasoff.eshop.backend.model.OrderModel;
import com.kirilanastasoff.eshop.backend.model.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, Long> {
	List<OrderModel> findByEmail(String email);

	Optional<UserModel> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
