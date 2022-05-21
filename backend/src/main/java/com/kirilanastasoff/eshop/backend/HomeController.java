package com.kirilanastasoff.eshop.backend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "Api is running...";
    }

    @GetMapping("/api/products")
    public String products()throws IOException {
        File resource = new ClassPathResource("products.js").getFile();
		String text = new String(Files.readAllBytes(resource.toPath()));
        return text;
        
    }

    @GetMapping("/api/products/:id")
    public String product()throws IOException {
        File resource = new ClassPathResource("products.js").getFile();
		String text = new String(Files.readAllBytes(resource.toPath()));
        

        return text;
    }
}
