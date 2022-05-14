package com.kirilanastasoff.eshop.backend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "Api is running...";
    }



    /**
     * load the products from the file
     * @return
     */
    @GetMapping("/api/products")
    public String products()throws IOException {
        File resource = new ClassPathResource("products.js").getFile();
		String text = new String(Files.readAllBytes(resource.toPath()));
        return text;
    }

}
