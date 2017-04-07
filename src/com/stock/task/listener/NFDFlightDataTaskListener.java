package com.stock.task.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.stock.task.manager.TimerManager;
import com.takucin.aceeci.util.PropertyReader;

public class NFDFlightDataTaskListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		//��鿪��ģʽ����ģʽ,����ǿ���ģʽ����ִ��
		String runModel= PropertyReader.readProperty("BaseIp", "runModel");
		if(runModel.equals("develop")){
			System.out.println("����������������������������������ģʽ����ֹ�ϴ�����������������������������������");
			return ;
		}
		try {
			new TimerManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
