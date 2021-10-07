package com.tcs.eas.event.model;

import java.io.Serializable;

public class ShippingConfirmation1 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4744486309005466141L;
	private Customer customer;
	private int orderId;
	private String dop;
	private String trackingNumber;
	private Product product;
	private String orderStatus;
	/**
	 * 
	 * @param customer
	 * @param orderId
	 * @param dop
	 * @param trackingNumber
	 * @param product
	 */
	public ShippingConfirmation1(Customer customer, int orderId, String dop, String trackingNumber, Product product, String orderStatus) {
		super();
		this.customer = customer;
		this.orderId = orderId;
		this.dop = dop;
		this.trackingNumber = trackingNumber;
		this.product = product;
		this.orderStatus = orderStatus;
	}


	
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}



	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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


	/**
	 * @return the trackingNumber
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}


	/**
	 * @param trackingNumber the trackingNumber to set
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
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


	public ShippingConfirmation1() {
		
	}
	
}
