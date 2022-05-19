package com.kirilanastasoff.eshop.backend.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private UserModel user;
	private String name;
	private String image;
	private String brand;
	private String category;
	
	private String description;
	private double rating = 0;
	private double numReviews = 0;
	private double price;
	private int countInStock;
	private Reviews []reviews;
	
	
	
}
