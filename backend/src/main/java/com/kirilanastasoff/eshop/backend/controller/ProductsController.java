package com.kirilanastasoff.eshop.backend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductsController {

	@GetMapping("/2")
	public String home() {
		return "Api is running...";
	}

	@GetMapping("/api/products2")
	public String products() throws IOException {
		File resource = new ClassPathResource("products.js").getFile();
		String text = new String(Files.readAllBytes(resource.toPath()));
		return text;

	}

	@GetMapping("/api/products2/:id")
	public String product() throws IOException {
		File resource = new ClassPathResource("products.js").getFile();
		String text = new String(Files.readAllBytes(resource.toPath()));

		return text;
	}
}
