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

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class AutoUploadTimeManager {
	 
	 //ʱ����
	 private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
	  
	 public AutoUploadTimeManager() {
	  Calendar calendar = Calendar.getInstance();
	        
	  /*** ����ÿ��00:20ִ�з��� ***/
	 
	  calendar.set(Calendar.HOUR_OF_DAY, 0);
	  calendar.set(Calendar.MINUTE, 20);
	  calendar.set(Calendar.SECOND, 0);
	   
	  Date date=calendar.getTime(); //��һ��ִ�ж�ʱ�����ʱ��
	   
	  //�����һ��ִ�ж�ʱ�����ʱ��С�ڵ�ǰ��ʱ��
	  //��ʱҪ�ڵ�һ��ִ�ж�ʱ�����ʱ���һ�죬�Ա���������¸�ʱ���ִ�С�
	  //�������һ��,���������ִ��
	  if (date.before(new Date())) {
	      date = this.addDay(date, 1);
	  }
	   
	  Timer timer = new Timer();
	   
	  AutoUploadTask task = new AutoUploadTask();
	  //����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ��
	  timer.schedule(task,date,PERIOD_DAY);
	 }
	 
	 //���ӻ��������
	 public Date addDay(Date date, int num) {
	  Calendar startDT = Calendar.getInstance();
	  startDT.setTime(date);
	  startDT.add(Calendar.DAY_OF_MONTH, num);
	  return startDT.getTime();
	 }
	  
	}