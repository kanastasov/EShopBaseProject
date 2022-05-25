package com.kirilanastasoff.eshop.backend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.kirilanastasoff.eshop.backend.model.ProductModel;
import com.kirilanastasoff.eshop.backend.repository.OrderModelRepository;
//import com.kirilanastasoff.eshop.backend.repository.OrderModelRepository;
import com.kirilanastasoff.eshop.backend.repository.ProductModelRepository;
import com.kirilanastasoff.eshop.backend.repository.UserModelRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductsController {
	
	@Autowired
	OrderModelRepository  orderModelRepository;
	
	@Autowired
	ProductModelRepository productModelRepository;
	
	@Autowired
	UserModelRepository userModelRepository;
	
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductModel>> getAllTutorials(@RequestParam(required = false) String name) {
		try {
			List<ProductModel> tutorials = new ArrayList<ProductModel>();
			if (name == null)
				productModelRepository.findAll().forEach(tutorials::add);
			else
				productModelRepository.findByName(name).forEach(tutorials::add);
			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductModel> getTutorialById(@PathVariable("id") long id) {
		Optional<ProductModel> productData = productModelRepository.findById(id);
		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/products")
	public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product) {
		try {
			ProductModel _product = productModelRepository
					.save(new ProductModel(product.getName(), product.getBrand(),product.getCategory(), product.getDescription()));
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/products/{id}")
	public ResponseEntity<ProductModel> updateProduct(@PathVariable("id") long id, @RequestBody ProductModel product) {
		Optional<ProductModel> productData = productModelRepository.findById(id);
		if (productData.isPresent()) {
			ProductModel _product = productData.get();
			_product.setName(product.getName());
			_product.setBrand(product.getBrand());
			_product.setDescription(product.getDescription());
			_product.setCategory(product.getCategory());
			_product.setCountInStock(product.getCountInStock());
			
			return new ResponseEntity<>(productModelRepository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
		try {
			productModelRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/products")
	public ResponseEntity<HttpStatus> deleteAllProducts() {
		try {
			productModelRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	


}
