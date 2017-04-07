package com.stock.userInfomation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;

public class UserInfomactonService extends BusinessService{

private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(UserInfomactonForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", form.getXiaoqunameHidden());
		set.add("yonghu", "@yonghu", form.getYonghuHidden());
		set.add("dizi", "@dizi", form.getDizhiHidden());
	//	set.add("xiaoquname", "@xiaoquname", form.getXiaoquHidden()+ "%");
		return set;
	}
	
	public DataSet<DataRow> getResult(UserInfomactonForm form, int first, int rows)throws Exception {
	return dao.executeQuery("GetUserInfomactonist",getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(UserInfomactonForm form) throws Exception {
	return dao.executeQueryToCount("GetUserInfomactonCount",getConditionParameterSet(form));
	}
}
