package com.tcs.eas.event.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tcs.eas.event.constant.Constants;

/**
 * 
 * @author 44745
 *
 */
@Service
public class MailService implements Constants{

	@Value(value = "${SMTP_FROM}")
	private String from;

	@Value(value = "${SMTP_FROM_NAME}")
	private String fromName;

	@Value(value = "${SMTP_USER}")
	private String smtpUser;

	@Value(value = "${SMTP_PASSWORD}")
	private String smtpPassword;

	@Value(value = "${SMTP_HOST}")
	private String smtpHost;

	@Value(value = "${SMTP_PORT}")
	private int port;

	private String toAddress;
	private String subject;
	private String body;

	/**
	 * 
	 */
	public MailService() {

	}

	/**
	 * 
	 * @param to
	 * @param subject
	 * @param body
	 */
	public MailService(String toAddress, String subject, String body) {
		this.toAddress = toAddress;
		this.subject = subject;
		this.body = body;
	}

	/**
	 * Create a Properties object to contain connection configuration information.
	 * 
	 * @return
	 */
	private Properties getProperties() {
		Properties props = System.getProperties();
		props.put(MAIL_TRANSPORT_PROTOCOL, MAIL_TRANSPORT_PROTOCOL_VALUE);
		props.put(MAIL_SMTP_PORT, port);
		props.put(MAIL_SMTP_STARTTLS_ENABLE, TRUE);
		props.put(MAIL_SMTP_AUTH, TRUE);
		return props;
	}

	/**
	 * 
	 * @return
	 */
	private Session getSession() {
		return Session.getDefaultInstance(getProperties());
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void sendMail() throws Exception {
		Session session = getSession();
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from, fromName));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
		msg.setSubject(this.getSubject());
		msg.setContent(body, "text/html");
		// Create a transport.
		Transport transport = session.getTransport();
		// Send the message.
		try {
			// Connect to Amazon SES using the SMTP username and password you specified
			// above.
			transport.connect(smtpHost, smtpUser, smtpPassword);
			// Send the email.
			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Email sent!");
		} catch (Exception ex) {
			System.out.println("The email was not sent.");
			System.out.println("Error message: " + ex.getMessage());
		} finally {
			// Close and terminate the connection.
			transport.close();
		}
	}

	

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the toAddress
	 */
	public String getToAddress() {
		return toAddress;
	}

	/**
	 * @param toAddress the toAddress to set
	 */
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	
}