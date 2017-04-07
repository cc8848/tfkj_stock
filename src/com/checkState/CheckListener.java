package com.checkState;

import com.takucin.aceeci.util.PropertyReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CheckListener implements HttpSessionListener, ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void contextInitialized(ServletContextEvent arg0) {

        //检查开发模式或部署模式,如果是开发模式，不执行
        String runModel= PropertyReader.readProperty("BaseIp", "runModel");
        if(runModel.equals("develop")){
            System.out.println("《《《《《《《《《《《《《《《开发模式，禁止上传》》》》》》》》》》》》》》》》》");
            return ;
        }

        //
        CheckThread mt1 = new CheckThread("1");
        Thread th1 = new Thread(mt1);
        th1.start();
        CheckThread mt2 = new CheckThread("2");
        Thread th2 = new Thread(mt2);
        th2.start();
        CheckThread mt3 = new CheckThread("3");
        Thread th3 = new Thread(mt3);
        th3.start();
        CheckThread mt4 = new CheckThread("4");
        Thread th4 = new Thread(mt4);
        th4.start();

    }

    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub

    }

}
