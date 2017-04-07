package com.stock.task.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.stock.task.manager.TimerManager;
import com.takucin.aceeci.util.PropertyReader;

public class NFDFlightDataTaskListener implements ServletContextListener {

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
			new TimerManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
