package com.kirilanastasoff.eshop.backend.model;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "reviews")
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "rating")
	private double rating;

	@Column(name = "comment")
	private String comment;
	@CreationTimestamp
	private Timestamp timestamp;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductModel productModelReviews;
//	
	

	public Reviews(String name, double rating, String comment) {
		super();
		this.name = name;
		this.rating = rating;
		this.comment = comment;
	}

}
