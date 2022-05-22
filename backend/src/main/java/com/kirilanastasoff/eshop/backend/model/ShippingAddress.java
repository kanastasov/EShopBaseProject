package com.kirilanastasoff.eshop.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_address")
public class ShippingAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_model_id", referencedColumnName = "id")
    private OrderModel orderModel;
    

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "country")
	private String country;

	public ShippingAddress(String address, String city, String postalCode, String country) {
		super();
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
