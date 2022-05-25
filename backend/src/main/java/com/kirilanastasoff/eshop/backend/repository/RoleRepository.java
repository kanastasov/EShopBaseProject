package com.kirilanastasoff.eshop.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirilanastasoff.eshop.backend.model.ERole;
import com.kirilanastasoff.eshop.backend.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);

}
