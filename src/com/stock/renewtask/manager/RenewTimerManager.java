package com.stock.renewtask.manager;

import com.stock.renewtask.task.RenewTask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class RenewTimerManager {

	// ʱ����
	private static final long PERIOD = 1 * 60 * 1000; //15����


	public RenewTimerManager() {


		Timer timer = new Timer();

		RenewTask task = new RenewTask();
		// ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
		timer.schedule(task,0, PERIOD);
	}

	// ���ӻ��������
	public Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}
	
}