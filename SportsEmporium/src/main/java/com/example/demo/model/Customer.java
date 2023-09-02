package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
  
	@Id
	private Integer customerId;
	private String customerName;
	private String customerMobileNo;
	
	@OneToMany(cascade =  CascadeType.ALL)
	@JoinColumn(name = "fk_product")
	private List<Products> products;
	


	public Customer(List<Products> products) {
		super();
		this.products = products;
	}


	public List<Products> getProducts() {
		return products;
	}


	public void setProducts(List<Products> products) {
		this.products = products;
	}


	public Customer(Integer customerId, String customerName, String customerMobileNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobileNo = customerMobileNo;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerMobileNo() {
		return customerMobileNo;
	}


	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}


	public Customer() {
		super();
	}
	
}
