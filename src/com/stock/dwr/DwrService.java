package com.stock.dwr;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class DwrService extends BusinessService{

	private CommonDao dao = new CommonDao();
	
	/**
	 * 根据小区名称 和门牌号查询是否已经有记录
	 * @param dwrBean
	 * @return
	 * @throws Exception
	 */
	public String testDwr(DwrBean dwrBean) throws Exception{
//		System.out.println("=============");
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", dwrBean.getXiaoqu());
		set.add("userplace", "@userplace", dwrBean.getDizhi());
		
		DataSet<DataRow> dateRowList = dao.executeQuery("GetPaigongdanDWRList",set);
		//如果有记录则返回第一条记录的派工日期 没有则返回“N”
		if(dateRowList.size()>0){
			String date = Common.formatDate(dateRowList.get(0).getDataElement("paigongriqi").getDate(),
					Common.DATE_FORMAT_DATE);
			return date;
		}else{
			return "N";
		}
		
	}
}
