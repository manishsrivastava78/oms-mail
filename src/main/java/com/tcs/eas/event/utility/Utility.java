package com.tcs.eas.event.utility;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author 44745
 *
 */
public class Utility {
	private static Map<Integer, String> mailTemplateMap = new HashMap<Integer, String>();
	
	static {
		mailTemplateMap.put(1, "templates/order-confirmation-email.mustache");
		mailTemplateMap.put(2, "templates/shipping-confirmation-email.mustache");
		mailTemplateMap.put(3, "templates/order-delivered-confirmation-email.mustache");
	}
	
	/**
	 * 
	 * @param templateNumber
	 * @return
	 */
	public static String getMailTemplateName(int templateNumber) {
		return mailTemplateMap.get(templateNumber);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {
		String remoteAddr = "";
		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}
		return remoteAddr;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getRequestHeaderValues(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}
}
