/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: kucun data service class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2013-03-18   Li.Hai-Han            Create
 */
package com.stock.kucun;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.DataSetUtil;


public class KucunDataService extends BusinessService {
	private Log log = LogFactory.getLog(this.getClass());	
	private CommonDao dao = new CommonDao();
	
	/**
	 * get user status for query page init.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CommonModule> getStatusCodeAll(String num)throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("EqSta_Type", "@EqSta_Type", num);
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getStatus1CodeAll",set));
	}
	
	public List<CommonModule> getSenListAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getSenListAll",new ParameterSet()));
	}
	
	public List<CommonModule> getUserNameAll() throws Exception {
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getUserNameAll",new ParameterSet()));
	}
	public List<CommonModule> getXiaoquCodeAll() throws Exception {
		return DataSetUtil.toCommonModuleList(dao.executeQuery("GetKuFangList",new ParameterSet()));
	}
	
	public String getQuyuByXiaoqu(String xiaoqu) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", xiaoqu);
		DataSet<DataRow> quyu = dao.executeQuery("getQuyuByXiaoqu",set);
		if(quyu.size()==0) {
			return "4998";
		}
		String quyuString = quyu.get(0).getDataElement("storeID").getString();
		if(quyuString==null) {
			return "4998";
		}
		return quyuString;
	}

	public List<CommonModule> getStatus2CodeAll() throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("EqSta_Type1", "@EqSta_Type1", "2");
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getStatus1CodeAll",set));
	}
	public List<CommonModule> getStatus4CodeAll() throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("EqSta_Type1", "@EqSta_Type1", "4");
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getStatus1CodeAll",set));
	}
	public List<CommonModule> getStatus23CodeAll() throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("EqSta_Type1", "@EqSta_Type1", "2");
		set.add("EqSta_Type2", "@EqSta_Type2", "3");
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getStatus1CodeAll",set));
	}
	public List<CommonModule> getStatus234CodeAll() throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("EqSta_Type1", "@EqSta_Type1", "2");
		set.add("EqSta_Type2", "@EqSta_Type2", "3");
		set.add("EqSta_Type3", "@EqSta_Type3", "4");
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getStatus1CodeAll",set));
	}

	public List<CommonModule> getStatusYichangCodeAll() throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("EqSta_Type1", "@EqSta_Type1", "4");
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getStatus1CodeAll",set));
	}

	public List<CommonModule> getYunweiAll() throws Exception {
		return DataSetUtil.toCommonModuleList(dao.executeQuery("FindYunwei",new ParameterSet()));
	}
	
	public List<CommonModule> getlingqurenID() throws Exception {
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getLingqurenID",new ParameterSet()));
	}

	public List<CommonModule> getStatus24CodeAll() throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("EqSta_Type1", "@EqSta_Type1", "2");
		set.add("EqSta_Type2", "@EqSta_Type2", "4");
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getStatus1CodeAll",set));
	}

	public CommonMessage chukushebeiEdit(KuncunForm f) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
