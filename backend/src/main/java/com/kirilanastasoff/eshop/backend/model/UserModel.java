package com.kirilanastasoff.eshop.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_model")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	
	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;

	// to do store the token
	@Column(name = "token")
	private String token;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

//	public ProductModel getProductModel() {
//		return productModel;
//	}
//
//	public void setProductModel(ProductModel productModel) {
//		this.productModel = productModel;
//	}
//
//	public OrderModel getOrderModel() {
//		return orderModel;
//	}
//
//	public void setOrderModel(OrderModel orderModel) {
//		this.orderModel = orderModel;
//	}

	@Column(name = "is_admin")
	private Boolean isAdmin = false;

//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "product_id", referencedColumnName = "id")
//	private ProductModel productModel;
//
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "order_model_id", referencedColumnName = "id")
//	private OrderModel orderModel;

	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public UserModel() {
		super();

	}

	public UserModel(String name, String email, String password, String username) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public UserModel(String email, String password, String username) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public UserModel(String name, String email, String password, Boolean isAdmin) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
