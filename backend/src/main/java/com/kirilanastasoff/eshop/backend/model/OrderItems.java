package com.kirilanastasoff.eshop.backend.model;

public class OrderItems {

	private String name;
	private int qty;
	private String image;
	private double price;
	private ProductModel product;

	public OrderItems(String name, int qty, String image, double price, ProductModel product) {
		super();
		this.name = name;
		this.qty = qty;
		this.image = image;
		this.price = price;
		this.product = product;
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

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

}