package com.telecomService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.xml.ws.Endpoint;

/**
 * 
 * @author Xinhua-Zhao
 * @date： 日期：2015-1-30 时间：下午8:14:06
 */
public class ClientListener implements HttpSessionListener,ServletContextListener {
	
    	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
	    SendResultService sendResultService = new SendOperateResultService();
	    //发布接口
	    Endpoint.publish("http://192.168.60.14/SendResultService", sendResultService);
	    System.out.println("接口开放成功..... ");
	}

	public void sessionCreated(HttpSessionEvent se) {
	}

	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
