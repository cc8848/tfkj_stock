package com.telecomService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.xml.ws.Endpoint;

/**
 * 
 * @author Xinhua-Zhao
 * @date�� ���ڣ�2015-1-30 ʱ�䣺����8:14:06
 */
public class ClientListener implements HttpSessionListener,ServletContextListener {
	
    	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
	    SendResultService sendResultService = new SendOperateResultService();
	    //�����ӿ�
	    Endpoint.publish("http://192.168.60.14/SendResultService", sendResultService);
	    System.out.println("�ӿڿ��ųɹ�..... ");
	}

	public void sessionCreated(HttpSessionEvent se) {
	}

	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
