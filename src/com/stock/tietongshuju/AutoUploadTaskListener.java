/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: data validator class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2015-4-7     DaiZhen               Create
 */
package com.stock.tietongshuju;

import com.takucin.aceeci.util.PropertyReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AutoUploadTaskListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		//检查开发模式或部署模式,如果是开发模式，不执行
		String runModel= PropertyReader.readProperty("BaseIp", "runModel");
		if(runModel.equals("develop")){
			System.out.println("《《《《《《《《《《《《《《《开发模式，禁止上传》》》》》》》》》》》》》》》》》");
			return ;
		}
		new AutoUploadTimeManager();
	}

	public void contextDestroyed(ServletContextEvent event) {

	}
}
