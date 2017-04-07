package com.stock.task.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import com.stock.task.NFDFlightDataTimerTask;


public class TimerManager {

	// ʱ����
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000; //24Сʱ
	//private static final long PERIOD_DAY =  120 * 60 * 1000; //1Сʱ
	//private static final long PERIOD_DAY =  6000; //6��

	public TimerManager() {
		Calendar calendar = Calendar.getInstance();

		/*** ����ÿ��ָ��ʱ��ִ�з��� ***/

		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		
	/*	calendar.set(Calendar.HOUR_OF_DAY, 15);
		calendar.set(Calendar.MINUTE, 42);
		calendar.set(Calendar.SECOND, 00);*/

		Date date = calendar.getTime(); // ��һ��ִ�ж�ʱ�����ʱ��

		// �����һ��ִ�ж�ʱ�����ʱ�� С�� ��ǰ��ʱ��
		// ��ʱҪ�� ��һ��ִ�ж�ʱ�����ʱ�� ��һ�죬�Ա���������¸�ʱ���ִ�С��������һ�죬���������ִ�С�
		if (date.before(new Date())) {
			date = this.addDay(date, 1);
			//date = this.addMinute(date, 1);
		}

		Timer timer = new Timer();

		NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();
		// ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
		timer.schedule(task, date, PERIOD_DAY);
	}

	// ���ӻ��������
	public Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}
	
}