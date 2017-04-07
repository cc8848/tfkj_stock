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
	 * ����С������ �����ƺŲ�ѯ�Ƿ��Ѿ��м�¼
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
		//����м�¼�򷵻ص�һ����¼���ɹ����� û���򷵻ء�N��
		if(dateRowList.size()>0){
			String date = Common.formatDate(dateRowList.get(0).getDataElement("paigongriqi").getDate(),
					Common.DATE_FORMAT_DATE);
			return date;
		}else{
			return "N";
		}
		
	}
}
