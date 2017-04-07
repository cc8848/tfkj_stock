package com.stock.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.stock.util.SoapClient;
import com.stock.weihu.IptvlogEidtForm;
import com.stock.weihu.WeihuService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.Common;

public class NFDFlightDataTimerTask extends TimerTask {
	private static Logger log = Logger.getLogger(NFDFlightDataTimerTask.class);
	private static YonghuDataService serviceData = new YonghuDataService();
	WeihuService iptvlogService = new WeihuService();
	@Override
	public void run() {
		try {
			Calendar calendar = Calendar.getInstance(java.util.Locale.CHINA);
			//ÿ�ν�����ʱ��Ϊǰһ����û�����ͣ������
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)-1);
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
			//����ʱ��
			String invaliDate = s.format(calendar.getTime()); 
			//��ȡ��Щ�����ѹ��ڣ�������ͣ������
			DataSet<DataRow> dataRow = serviceData.getResultTingji(invaliDate);

			/*
			 * ������־��¼
			 */
			if(dataRow!=null&&dataRow.size()>0) {
				for(int i=0;i<dataRow.size();i++) {
					String userId = dataRow.get(i).getDataElement("dianhuaip").getString();//�û�����

					IptvlogEidtForm f1 =  new IptvlogEidtForm();
					f1.setTingjishijian(invaliDate);
					f1.setTingjizhanghao(userId);
					f1.setShifouchenggong("�����˺�");
					f1.setShibaibianhao("");
					f1.setShibaixinxi("");
					f1.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
					f1.setServerip("");
					f1.setInterfaceType("ͣ��");
					f1.setIsweb("��");
					iptvlogService.insertIptvlog(f1);
				}
			}
			if(dataRow!=null&&dataRow.size()>0){
				for(int i=0;i<dataRow.size();i++){
					IptvlogEidtForm ie = new IptvlogEidtForm();
					IptvlogEidtForm ie2 = new IptvlogEidtForm();
					String userId = dataRow.get(i).getDataElement("dianhuaip").getString();//�û�����
					String status = "2";//�û�״̬


					try {
						/*
						 * ͣ���ӿڵ���
						 */
						ie = SoapClient.updateUserStatus(userId, status, invaliDate, "http://10.104.0.6:8500/","��");
						ie2 = SoapClient.updateUserStatus(userId, status, invaliDate, "http://10.103.0.6:8500/","��");

						/*
						 * ���IPTV�ӿ���־
						 */
						IptvlogEidtForm f =  new IptvlogEidtForm();
						f.setTingjishijian(invaliDate);
						f.setTingjizhanghao(userId);
						f.setShifouchenggong(ie.getShifouchenggong());
						f.setShibaibianhao(ie.getShibaibianhao());
						f.setShibaixinxi(ie.getShibaixinxi());
						f.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
						f.setServerip("http://10.104.0.6:8500/");
						f.setInterfaceType("ͣ��");
						f.setIsweb("��");
						iptvlogService.insertIptvlog(f);
						
						IptvlogEidtForm f2 =  new IptvlogEidtForm();
						f2.setTingjishijian(invaliDate);
						f2.setTingjizhanghao(userId);
						f2.setShifouchenggong(ie2.getShifouchenggong());
						f2.setShibaibianhao(ie2.getShibaibianhao());
						f2.setShibaixinxi(ie2.getShibaixinxi());
						f2.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
						f2.setServerip("http://10.103.0.6:8500/");
						f2.setInterfaceType("ͣ��");
						f2.setIsweb("��");
						iptvlogService.insertIptvlog(f2);
					} catch (Exception e) {
						log.info("������Ϣ�����쳣:" + e.toString());
					}
				}
			}
		} catch (Exception e) {
			log.info("��־��¼�����쳣:" + e.toString());
		}
	}
}
