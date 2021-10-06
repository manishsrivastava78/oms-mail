package com.tcs.eas.event.engine;

import java.io.IOException;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.tcs.eas.event.constant.Constants;
import com.tcs.eas.event.model.Customer;
import com.tcs.eas.event.model.MailData;
import com.tcs.eas.event.model.OrderConfirmation1;
import com.tcs.eas.event.model.OrderDeliveryConfirmation1;
import com.tcs.eas.event.model.Product;
import com.tcs.eas.event.model.ShippingConfirmation1;
import com.tcs.eas.event.service.MailService;
import com.tcs.eas.event.utility.Utility;

@Service
public class Consumer implements Constants {

	private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	MailService mailService;

	/**
	 * 
	 */
	private String subject;

	@KafkaListener(topics = "${KAFKA_MAIL_TOPIC}", groupId = "${KAFKA_MAIL_TOPIC_CLIENT_GROUP_ID}")
	public void consume(String message) throws IOException {
		LOGGER.info("In mail consumer...");
		ObjectMapper objectMapper = new ObjectMapper();
		MailData mailData = objectMapper.readValue(message, MailData.class);
		mailService.setToAddress(mailData.getCustomer().getEmail());
		mailService.setBody(getMailBody(mailData));
		mailService.setSubject(subject);
		try {
			mailService.sendMail();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @param orderConfirmation
	 * @return
	 */
	private String getOrderConfirmationContent(OrderConfirmation1 orderConfirmation) {
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache m = mf.compile(Utility.getMailTemplateName(ORDER_MAIL_TEMPLATE));
		StringWriter writer = new StringWriter();
		try {
			m.execute(writer, orderConfirmation).flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	/**
	 * 
	 * @param shippingConfirmation
	 * @return
	 */
	private String getShippingConfirmationContent(ShippingConfirmation1 shippingConfirmation) {
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache m = mf.compile(Utility.getMailTemplateName(SHIPMENT_MAIL_TEMPLATE));
		StringWriter writer = new StringWriter();
		try {
			m.execute(writer, shippingConfirmation).flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	/**
	 * 
	 * @param orderDeliveryConfirmation
	 * @return
	 */
	private String getOrderDeliveryConfirmationContent(OrderDeliveryConfirmation1 orderDeliveryConfirmation) {
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache m = mf.compile(Utility.getMailTemplateName(ORDER_DELIVERY_TEMPLATE));
		StringWriter writer = new StringWriter();
		try {
			m.execute(writer, orderDeliveryConfirmation).flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writer.toString();
	}

	/**
	 * 
	 * @param mailData
	 * @return
	 */
	private String getMailBody(MailData mailData) {
		LOGGER.info("In getMailBody");
		Customer customer = mailData.getCustomer();
		Product product = mailData.getProduct();
		switch (mailData.getMailTemplate()) {
		case 1:
			// OrderConfirmation orderConfirmation = new
			// OrderConfirmation(mailData.getOrderId(), customer.getFirstname(),
			// customer.getLastname(), mailData.getDop().toString(), product.getCurrency());
			OrderConfirmation1 orderConfirmation = new OrderConfirmation1(mailData.getOrderId(), product, customer,
					mailData.getDop().toString(),mailData.getStatus());
			this.subject = ORDER_MAIL_SUBJECT;
			return getOrderConfirmationContent(orderConfirmation);
		case 2:
			ShippingConfirmation1 shippingConfirmation = new ShippingConfirmation1(customer, mailData.getOrderId(),
					mailData.getDop().toString(), mailData.getTrackingNumber(), product,"Shipped");
			this.subject = SHIPMENT_MAIL_SUBJECT;
			return getShippingConfirmationContent(shippingConfirmation);
		case 3:
			OrderDeliveryConfirmation1 orderDeliveryConfirmation = new OrderDeliveryConfirmation1(mailData.getOrderId(),
					mailData.getDop().toString(), mailData.getTrackingNumber(), mailData.getDod().toString(), product, customer,mailData.getStatus());
			// (customer.getFirstname(),
			// customer.getLastname(), customer.getStreet(), customer.getCity(),
			// customer.getState(),
			// customer.getPostcode(), mailData.getOrderId(), mailData.getDop().toString(),
			// mailData.getTrackingNumber(), product.getCurrency(),
			// mailData.getDod().toString());
			this.subject = ORDER_DELIVERY_MAIL_SUBJECT;
			return getOrderDeliveryConfirmationContent(orderDeliveryConfirmation);
		default:
			return "Something went wrong!";
		}
	}
}
