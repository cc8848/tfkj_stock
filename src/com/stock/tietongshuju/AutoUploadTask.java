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

import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AutoUploadTask extends TimerTask{
	 private Log log = LogFactory.getLog(this.getClass());	
	 private ImportDataService service = new ImportDataService();
	 @Override
	 public void run() {
	  try {
		  //TODO 铁通上传开发环境注释掉，不让他自动上传
		  service.findTodayDate();
	  } catch (Exception e) {
	   log.info("-------------解析信息发生异常--------------");
	  }
	 }
	}
