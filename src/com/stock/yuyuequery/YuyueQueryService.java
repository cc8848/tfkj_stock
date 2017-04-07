package com.stock.yuyuequery;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class YuyueQueryService extends BusinessService{

private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(YuyueForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu", form.getXiaoqucodeHidden());
		set.add("riqi", "@riqi", form.getRiqicodeHidden());
		set.add("starriqi", "@starriqi",form.getStarriqicodeHidden());
		set.add("endriqi", "@endriqi",form.getEndriqicodeHidden());
		try {
			set.add("now", "@now",  Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
	
	public DataSet<DataRow> getResult(YuyueForm form, int first, int rows)throws Exception {
	return dao.executeQuery("GetPlanList",getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(YuyueForm form) throws Exception {
	return dao.executeQueryToCount("GetPlanListCount",getConditionParameterSet(form));
	}

	
}
