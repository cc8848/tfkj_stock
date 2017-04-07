package com.stock.fenPeiIp;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.frame.BusinessService;
import com.stock.equipStock.EquipStockEntiyForm;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class FeiPeiIpService extends BusinessService{
private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	/**
	 * 根据UUID查询派工单ID
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getPgdOtherByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("getPgdOtherByUUID",set);
	}
	
	/**
	 * 更新
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String update(FeiPeiIpForm form) throws Exception {
		/*String error = validator.updateValidate(form);
		if(error != null){
			return error;
		}*/
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			//set.add("employeeId", "@employeeId", form.getEmployeeCode());
			set.add("fenguang", "@fenguang",form.getFenguang());
			set.add("netip", "@netip", form.getNetIp());
			set.add("netvaln", "@netvaln", form.getNetValn());
			set.add("telip", "@telip", form.getTelIp());
			set.add("telvaln", "@telvaln", form.getTelValn());
			set.add("tvip", "@tvip", form.getTvip());
			set.add("yewu", "@yewu", form.getYeWu());
			set.add("xiaoquname", "@xiaoquname", form.getXiaoquname());
			set.add("UUID", "@UUID", form.getPgdUUID());
			set.add("state", "@state", "5");//ip已分配
			
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			dao.execute("updatePGDIPById",set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
}	
