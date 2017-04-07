package com.stock.renewtask.listener;

import com.stock.renewtask.manager.RenewTimerManager;
import com.takucin.aceeci.util.PropertyReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class RenewTaskListener implements ServletContextListener {

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
			new RenewTimerManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
