package com.tcs.eas.event.model;

public class ShippingConfirmation1 {
	private Customer customer;
	private int orderId;
	private String dop;
	private String trackingNumber;
	private Product product;
	private String status;
	
	/**
	 * 
	 * @param customer
	 * @param orderId
	 * @param dop
	 * @param trackingNumber
	 * @param product
	 */
	public ShippingConfirmation1(Customer customer, int orderId, String dop, String trackingNumber, Product product, String status) {
		super();
		this.customer = customer;
		this.orderId = orderId;
		this.dop = dop;
		this.trackingNumber = trackingNumber;
		this.product = product;
		this.status = status;
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
