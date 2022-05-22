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
@Table(name = "payment_result")
public class PaymentResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_model_id", referencedColumnName = "id")
    private OrderModel orderModel;
	

	@Column(name = "status")
	private String status;

	@Column(name = "update_time")
	private String updateTime;

	@Column(name = "email_address")
	private String emailAddress;

	public PaymentResult(String status, String updateTime, String emailAddress) {
		super();
		this.status = status;
		this.updateTime = updateTime;
		this.emailAddress = emailAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
