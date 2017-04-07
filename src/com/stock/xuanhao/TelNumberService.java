package com.stock.xuanhao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;

public class TelNumberService extends BusinessService{

private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(TelNumberForm form){
		ParameterSet set = new ParameterSet();
		set.add("quyu", "@quyu", form.getQuyuCodeHidden());
		set.add("telno", "@telno", form.getTelNoCodeHidden());
		set.add("state", "@state", "0");
		return set;
	}
	
	public DataSet<DataRow> getResult(TelNumberForm form, int first, int rows)throws Exception {
		return dao.executeQuery("GetTelList",getConditionParameterSet(form), first, rows);
		}

		public int getResultCount(TelNumberForm form) throws Exception {
		return dao.executeQueryToCount("GetTelListCount",getConditionParameterSet(form));
		}
}
