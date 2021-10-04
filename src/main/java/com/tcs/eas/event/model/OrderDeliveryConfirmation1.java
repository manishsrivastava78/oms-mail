package com.tcs.eas.event.model;

public class OrderDeliveryConfirmation1 {

	private int orderId;
	private String dop;
	private String trackingNumber;
	private String dod;

	private Product product;

	private Customer customer;
	
	private String status;

	public OrderDeliveryConfirmation1() {

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
	 * @return the dod
	 */
	public String getDod() {
		return dod;
	}

	/**
	 * @param dod the dod to set
	 */
	public void setDod(String dod) {
		this.dod = dod;
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

	public OrderDeliveryConfirmation1(int orderId, String dop, String trackingNumber, String dod, Product product,
			Customer customer,String status) {
		super();
		this.orderId = orderId;
		this.dop = dop;
		this.trackingNumber = trackingNumber;
		this.dod = dod;
		this.product = product;
		this.customer = customer;
		this.status = status;
	}

	
}
