package com.tcs.eas.event.model;

import java.io.Serializable;

public class OrderConfirmation1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4610617068793437230L;

	private int orderId;

	private Product product;
	
	private Customer customer;

	private String dop;
	
	private String status;
	
	


	public OrderConfirmation1(int orderId, Product product, Customer customer, String dop, String status) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.customer = customer;
		this.dop = dop;
		this.status = status;
	}

	


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}




	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}




	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}




	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}




	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}




	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}




	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}




	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	/**
	 * @return the dop
	 */
	public String getDop() {
		return dop;
	}




	/**
	 * @param dop the dop to set
	 */
	public void setDop(String dop) {
		this.dop = dop;
	}




	public OrderConfirmation1() {
		
	}
}
