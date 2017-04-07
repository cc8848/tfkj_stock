package com.takucin.aceeci.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

import com.takucin.aceeci.frame.GlobalInfo;

/**
 * 
 * @author User
 *
 */
public class GlobalServletContextListener extends HttpServlet implements ServletContextListener {
	
	private static final long serialVersionUID = 10200906261424L;
	
	/**
	 * ≥ı ºªØ
	 */
	public void contextInitialized(ServletContextEvent context) {
		GlobalInfo.getInstance(context.getServletContext());
		String prefix = context.getServletContext().getRealPath("/"); 
		PropertyConfigurator.configure(prefix + "WEB-INF/log4j.properties"); 
	}
	
	/**
	 * Destroy
	 */
	public void contextDestroyed(ServletContextEvent context) {
	}
}
