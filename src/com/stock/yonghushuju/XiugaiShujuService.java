/*
 * TianFang science corporation (c)2012 all rights reserved.
 * Description: XiugaiShujuService 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Li.Hai-Han(**)        Create
 */
package com.stock.yonghushuju;



import java.util.List;


import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.DataSetUtil;

/**
 * XiugaiShujuService.
 * 
 * @author Li.Hai-Han(**)
 */
public class XiugaiShujuService extends BusinessService  {
	
private CommonDao dao = new CommonDao();
	
	
private ParameterSet getConditionParameterSet(XiugaiShujuForm form) {
		ParameterSet set = new ParameterSet();
		if (form.getXx_dizhiHidden() == null || form.getXx_dizhiHidden().equals("")) {
			set.add("xx_dizhi", "@xx_dizhi", form.getXx_dizhiHidden());
		} else {
			set.add("xx_dizhi", "@xx_dizhi", "%" + form.getXx_dizhiHidden() + "%");
		}
		set.add("xx_xiaoqu", "@xx_xiaoqu", form.getXx_xiaoquHidden());
	
		
		if ( form.getXiugaidatesHidden() == null ||  form.getXiugaidatesHidden().equals("")) {
			
		} else {
			set.add("xiugaidates", "@xiugaidates", "%" + form.getXiugaidatesHidden() + "%");
		}
		if (form.getYh_zhuangtaiHidden() == null || form.getYh_zhuangtaiHidden().equals("")) {
			
		} else {
			set.add("yh_zhuangtai", "@yh_zhuangtai", "%" + form.getYh_zhuangtaiHidden() + "%");
		}
		return set;
	}
	public DataSet<DataRow> getResult(XiugaiShujuForm form, int first, int rows)throws Exception {
		return dao.executeQuery("GetShujuXiugaiInfo",getConditionParameterSet(form), first, rows);
	}
	
	public DataSet<DataRow> getResultWeixiuJiaofei(XiugaiShujuForm form, int first, int rows)throws Exception {
		return dao.executeQuery("GetWeixiuJiaofeiLogInfo",getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(XiugaiShujuForm form) throws Exception {
		return dao.executeQueryToCount("GetShujuXiugaiListCount",getConditionParameterSet(form));
	}
	public int getResultCountWeixiuJiaofei(XiugaiShujuForm form) throws Exception {
		return dao.executeQueryToCount("GetWeixiuJiaofeiLogCount",getConditionParameterSet(form));
	}


	public List<CommonModule> getXiaoQuCodeAll() throws Exception {
			return DataSetUtil.toCommonModuleList(dao.executeQuery("getXiaoQuCodeAll",new ParameterSet()));
	}
	public List<CommonModule> getZhuangtaiAllInLog() throws Exception {
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getZhuangtaiAllInLog",new ParameterSet()));
}
		
	public List<CommonModule> getUserCode() throws Exception {
			return DataSetUtil.toCommonModuleList(dao.executeQuery("getXiaoQuCodeAll",new ParameterSet()));
	}
}
