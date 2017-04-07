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
			//每次将到期时间为前一天的用户进行停机操作
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)-1);
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
			//过期时间
			String invaliDate = s.format(calendar.getTime()); 
			//获取哪些数据已过期，即满足停机条件
			DataSet<DataRow> dataRow = serviceData.getResultTingji(invaliDate);

			/*
			 * 发送日志记录
			 */
			if(dataRow!=null&&dataRow.size()>0) {
				for(int i=0;i<dataRow.size();i++) {
					String userId = dataRow.get(i).getDataElement("dianhuaip").getString();//用户编码

					IptvlogEidtForm f1 =  new IptvlogEidtForm();
					f1.setTingjishijian(invaliDate);
					f1.setTingjizhanghao(userId);
					f1.setShifouchenggong("待发账号");
					f1.setShibaibianhao("");
					f1.setShibaixinxi("");
					f1.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
					f1.setServerip("");
					f1.setInterfaceType("停机");
					f1.setIsweb("否");
					iptvlogService.insertIptvlog(f1);
				}
			}
			if(dataRow!=null&&dataRow.size()>0){
				for(int i=0;i<dataRow.size();i++){
					IptvlogEidtForm ie = new IptvlogEidtForm();
					IptvlogEidtForm ie2 = new IptvlogEidtForm();
					String userId = dataRow.get(i).getDataElement("dianhuaip").getString();//用户编码
					String status = "2";//用户状态


					try {
						/*
						 * 停机接口调用
						 */
						ie = SoapClient.updateUserStatus(userId, status, invaliDate, "http://10.104.0.6:8500/","否");
						ie2 = SoapClient.updateUserStatus(userId, status, invaliDate, "http://10.103.0.6:8500/","否");

						/*
						 * 添加IPTV接口日志
						 */
						IptvlogEidtForm f =  new IptvlogEidtForm();
						f.setTingjishijian(invaliDate);
						f.setTingjizhanghao(userId);
						f.setShifouchenggong(ie.getShifouchenggong());
						f.setShibaibianhao(ie.getShibaibianhao());
						f.setShibaixinxi(ie.getShibaixinxi());
						f.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
						f.setServerip("http://10.104.0.6:8500/");
						f.setInterfaceType("停机");
						f.setIsweb("否");
						iptvlogService.insertIptvlog(f);
						
						IptvlogEidtForm f2 =  new IptvlogEidtForm();
						f2.setTingjishijian(invaliDate);
						f2.setTingjizhanghao(userId);
						f2.setShifouchenggong(ie2.getShifouchenggong());
						f2.setShibaibianhao(ie2.getShibaibianhao());
						f2.setShibaixinxi(ie2.getShibaixinxi());
						f2.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
						f2.setServerip("http://10.103.0.6:8500/");
						f2.setInterfaceType("停机");
						f2.setIsweb("否");
						iptvlogService.insertIptvlog(f2);
					} catch (Exception e) {
						log.info("解析信息发生异常:" + e.toString());
					}
				}
			}
		} catch (Exception e) {
			log.info("日志记录发生异常:" + e.toString());
		}
	}
}
