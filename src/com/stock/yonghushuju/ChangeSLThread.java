package com.stock.yonghushuju;

import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.webService.WebServiceMethods;

public class ChangeSLThread implements Runnable{

	DataSet<DataRow> query = null;
	
	String wangluo = null;
	
	String daikuan = null;
	
	public void run() {
		try {
			Thread.sleep(5*60*1000);
			WebServiceMethods.ChangeSL(query, wangluo, daikuan);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DataSet<DataRow> getQuery() {
		return query;
	}

	public void setQuery(DataSet<DataRow> query) {
		this.query = query;
	}

	public String getWangluo() {
		return wangluo;
	}

	public void setWangluo(String wangluo) {
		this.wangluo = wangluo;
	}

	public String getDaikuan() {
		return daikuan;
	}

	public void setDaikuan(String daikuan) {
		this.daikuan = daikuan;
	}

}
