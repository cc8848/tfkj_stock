package com.stock.renewtask.task;

import com.stock.renewtask.manager.RenewTimerManager;
import com.stock.renewtask.service.RenewTaskService;
import com.stock.weihu.WeihuService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class RenewTask extends TimerTask  {
	private static Logger log = Logger.getLogger(RenewTask.class);
	RenewTaskService service=new RenewTaskService();
	@Override
	public void run() {
		try {
			service.approve();
		} catch (Exception e) {
			log.info("日志记录发生异常:" + e.toString());
		}
	}
}
