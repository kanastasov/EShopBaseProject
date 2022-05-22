package com.kirilanastasoff.eshop.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "product_model")
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonManagedReference
	@OneToMany(mappedBy = "productModel", fetch = FetchType.EAGER, orphanRemoval = true, cascade = { CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE })
	private List<UserModel> productModel = new ArrayList<>();

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;

	@Column(name = "brand")
	private String brand;

	@Column(name = "category")
	private String category;

	@Column(name = "description")
	private String description;
	@Column(name = "rating")
	private double rating = 0;

	@Column(name = "numReviews")
	private double numReviews = 0;

	@Column(name = "price")
	private double price;

	@Column(name = "countInStock")
	private int countInStock;

	@Column(name = "reviews")
	private Reviews[] reviews;

	public ProductModel() {
		super();
	}

	public ProductModel(String name, String brand, String category, String description) {
		super();
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.description = description;
	}

	public ProductModel(UserModel user, String name, String image, String brand, String category, String description,
			double rating, double numReviews, double price, int countInStock, Reviews[] reviews) {
		super();
//		this.user = user;
		this.name = name;
		this.image = image;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.rating = rating;
		this.numReviews = numReviews;
		this.price = price;
		this.countInStock = countInStock;
		this.reviews = reviews;
	}

//	public UserModel getUser() {
//		return user;
//	}
//	public void setUser(UserModel user) {
//		this.user = user;
//	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getNumReviews() {
		return numReviews;
	}

	public void setNumReviews(double numReviews) {
		this.numReviews = numReviews;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCountInStock() {
		return countInStock;
	}

	public void setCountInStock(int countInStock) {
		this.countInStock = countInStock;
	}

	public Reviews[] getReviews() {
		return reviews;
	}

	public void setReviews(Reviews[] reviews) {
		this.reviews = reviews;
	}

}
