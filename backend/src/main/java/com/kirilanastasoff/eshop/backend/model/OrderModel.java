package com.kirilanastasoff.eshop.backend.model;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OrderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private UserModel user;

	private OrderItems[] orderItems;
	private ShippingAddress shippingAddress;
	private String paymentMethod;

	private PaymentResult paymentResult;

	private double taxPrice = 0;

	private double shippingPrice = 0;
	private double totalPrice = 0;
	private Boolean isPaid = false;

	private Date paidAt;
	private Boolean isDelivered = false;
	private Date deliveredAt;

}