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
		//��鿪��ģʽ����ģʽ,����ǿ���ģʽ����ִ��
		String runModel= PropertyReader.readProperty("BaseIp", "runModel");
		if(runModel.equals("develop")){
			System.out.println("����������������������������������ģʽ����ֹ�ϴ�����������������������������������");
			return ;
		}
		new AutoUploadTimeManager();
	}

	public void contextDestroyed(ServletContextEvent event) {

	}
}
