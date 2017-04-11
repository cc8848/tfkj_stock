package com.stock.renewtask.manager;

import com.stock.renewtask.task.RenewTask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class RenewTimerManager {

	// 时间间隔
	private static final long PERIOD = 1 * 60 * 1000; //15分钟


	public RenewTimerManager() {


		Timer timer = new Timer();

		RenewTask task = new RenewTask();
		// 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timer.schedule(task,0, PERIOD);
	}

	// 增加或减少天数
	public Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}
	
}