package com.takucin.aceeci.util;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2004-7-12
 * Time: 11:12:52
 * To change this template use Options | File Templates.
 */

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PropertyReader {
	public static final String readProperty(String baseName, String propertyName) {
		ResourceBundle rb = ResourceBundle.getBundle(baseName);
		return rb.getString(propertyName);
	}

	public static final Map readAllProperties(String baseName) {
		Map propertyMap = new HashMap();
		ResourceBundle rb = ResourceBundle.getBundle(baseName);
		Enumeration enu = rb.getKeys();
		while (enu.hasMoreElements()) {
			String key = (String) enu.nextElement();
			propertyMap.put(key, rb.getString(key));
		}
		return propertyMap;
	}

	public static final String readProperty(String propName) {
		ResourceBundle rb = ResourceBundle.getBundle("jspMessage");
		return rb.getString(propName);
	}
}