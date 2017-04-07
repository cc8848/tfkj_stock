package com.stock.renewtask.listener;

import com.stock.renewtask.manager.RenewTimerManager;
import com.takucin.aceeci.util.PropertyReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class RenewTaskListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {

		//检查开发模式或部署模式,如果是开发模式，不执行
		String runModel= PropertyReader.readProperty("BaseIp", "runModel");
		if(runModel.equals("develop")){
			System.out.println("《《《《《《《《《《《《《《《开发模式，禁止上传》》》》》》》》》》》》》》》》》");
			return ;
		}


		try {
			new RenewTimerManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
