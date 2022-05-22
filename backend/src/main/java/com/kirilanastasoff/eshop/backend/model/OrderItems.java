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
@Table(name = "order_items")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "qty")
	private int qty;

	@Column(name = "image")
	private String image;

	@Column(name = "price")
	private double price;
//
//	@JsonManagedReference
//	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, orphanRemoval = true, cascade = { CascadeType.MERGE,
//			CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE })
//	private List<ProductModel> ProductModel = new ArrayList<>();

	public OrderItems(String name, int qty, String image, double price) {
		super();
		this.name = name;
		this.qty = qty;
		this.image = image;
		this.price = price;
//		ProductModel = productModel;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
