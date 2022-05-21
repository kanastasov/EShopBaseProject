package com.kirilanastasoff.eshop.backend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kirilanastasoff.eshop.backend.model.ProductModel;
//import com.kirilanastasoff.eshop.backend.repository.OrderModelRepository;
import com.kirilanastasoff.eshop.backend.repository.ProductModelRepository;
import com.kirilanastasoff.eshop.backend.repository.UserModelRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HomeController {
	
//	@Autowired
//	OrderModelRepository orderModelRepository;
	
	@Autowired
	ProductModelRepository productModelRepository;
	
	@Autowired
	UserModelRepository userModelRepository;
	
//    @GetMapping("/")
//    public String home(){
//        return "Api is running...";
//    }

//    @GetMapping("/products")
//    public String products()throws IOException {
//        File resource = new ClassPathResource("products.js").getFile();
//		String text = new String(Files.readAllBytes(resource.toPath()));
//        return text;
//        
//    }
    
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
	
	
	@PostMapping("/products")
	public ResponseEntity<ProductModel> createTutorial(@RequestBody ProductModel product) {
		try {
			ProductModel _product = productModelRepository
					.save(new ProductModel(product.getName(), product.getBrand(),product.getCategory(), product.getDescription()));
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	https://www.bezkoder.com/spring-boot-postgresql-example/
	
	

//    @GetMapping("/api/products/:id")
//    public String product()throws IOException {
//        File resource = new ClassPathResource("products.js").getFile();
//		String text = new String(Files.readAllBytes(resource.toPath()));
//        
//
//        return text;
//    }
}
