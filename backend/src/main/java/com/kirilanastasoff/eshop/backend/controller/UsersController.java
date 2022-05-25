package com.kirilanastasoff.eshop.backend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kirilanastasoff.eshop.backend.model.UserModel;
import com.kirilanastasoff.eshop.backend.repository.OrderModelRepository;
//import com.kirilanastasoff.eshop.backend.repository.OrderModelRepository;
import com.kirilanastasoff.eshop.backend.repository.ProductModelRepository;
import com.kirilanastasoff.eshop.backend.repository.UserModelRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UsersController {

	@Autowired
	OrderModelRepository orderModelRepository;

	@Autowired
	UserModelRepository userModelRepository;

	@GetMapping("/users")
	public ResponseEntity<List<UserModel>> getAllTutorials(@RequestParam(required = false) String email) {
		try {
			List<UserModel> tutorials = new ArrayList<UserModel>();
			if (email == null)
				userModelRepository.findAll().forEach(tutorials::add);
			else
				userModelRepository.findByEmail(email).forEach(tutorials::add);
			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserModel> getTutorialById(@PathVariable("id") long id) {
		Optional<UserModel> productData = userModelRepository.findById(id);
		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<UserModel> createProduct(@RequestBody UserModel product) {
		try {
			UserModel _product = userModelRepository.save(
					new UserModel(product.getName(), product.getEmail(), product.getPassword(), product.getUsername()));
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<UserModel> updateProduct(@PathVariable("id") long id, @RequestBody UserModel product) {
		Optional<UserModel> productData = userModelRepository.findById(id);
		if (productData.isPresent()) {
			UserModel _product = productData.get();
			_product.setName(product.getName());
			_product.setEmail(product.getEmail());
			_product.setPassword(product.getPassword());
			_product.setUsername(product.getUsername());

			return new ResponseEntity<>(userModelRepository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
		try {
			userModelRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/users")
	public ResponseEntity<HttpStatus> deleteAllProducts() {
		try {
			userModelRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
