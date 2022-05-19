package com.kirilanastasoff.eshop.backend.model;

import java.security.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

public class Reviews {

	private String name;
	private double rating;
	private String comment;
	@CreationTimestamp
	private Timestamp timestamp;

	public Reviews(String name, double rating, String comment) {
		super();
		this.name = name;
		this.rating = rating;
		this.comment = comment;
	}

}
