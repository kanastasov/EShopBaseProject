package com.kirilanastasoff.eshop.backend.model;

import java.sql.Date;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order_model")
public class OrderModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

//	@JsonManagedReference
//	@OneToMany(mappedBy = "orderModel", fetch = FetchType.EAGER, orphanRemoval = true, cascade = { CascadeType.MERGE,
//			CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE })
//	private List<UserModel> productModel = new ArrayList<>();
	
	

	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	@OneToMany(mappedBy = "orderModel", orphanRemoval = true, cascade = { CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.PERSIST, CascadeType.REMOVE })
	private List<ShippingAddress> shippingAddress = new ArrayList<>();
	

	@Column(name = "order_items")
	private OrderItems[] orderItems;



	@Column(name = "payment_method")
	private String paymentMethod;

	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	@OneToMany(mappedBy = "orderModel", orphanRemoval = true, cascade = { CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.PERSIST, CascadeType.REMOVE })
	private List<PaymentResult> paymentResult = new ArrayList<>();
	
	
	@Column(name = "tax_price")
	private double taxPrice = 0;

	@Column(name = "shipping_price")
	private double shippingPrice = 0;

	@Column(name = "total_price")
	private double totalPrice = 0;

	@Column(name = "is_paid")
	private Boolean isPaid = false;

	@Column(name = "paid_at")
	private Date paidAt;

	@Column(name = "is_delivered")
	private Boolean isDelivered = false;

	@Column(name = "delivered_at")
	private Date deliveredAt;

}
