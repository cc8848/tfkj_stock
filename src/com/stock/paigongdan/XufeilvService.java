package com.stock.paigongdan;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.stock.total.TotalForm;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;

public class XufeilvService extends BusinessService{
	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	public ParameterSet getConditionParameterSet(XufeilvForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", form.getXiaoqutextHidden());
		set.add("kaijis", "@kaijis", form.getKaijisHidden());
		set.add("kaijie", "@kaijie", form.getKaijieHidden());
		return set;
	}
	
	public DataSet<DataRow> getResult(XufeilvForm form)throws Exception {
		if (form.getXiaoqutext() == null || "".equals(form.getXiaoqutextHidden().trim())||form.getKaijis() == null || "".equals(form.getKaijisHidden().trim())||
				form.getKaijie() == null || "".equals(form.getKaijieHidden().trim())) {
			return dao.executeQuery("GetEmptyDataList",this.getConditionParameterSet(form));
		}
		else{
			return dao.executeQuery("GetXufeilv",getConditionParameterSet(form));
		}
	}
	
	private ParameterSet SetXufeilv(XufeilvForm form) {
		ParameterSet set = new ParameterSet();
//		if(form.getYunyingshanghidden()!=null && !"".equals(form.getYunyingshanghidden())){
//			set.add("yunyingshang", "@yunyingshang", form.getYunyingshanghidden());
//		}
		
		return set;
	}
}
