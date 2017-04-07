package com.stock.ration; 

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.record.formula.functions.Fpos;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.frame.BusinessService;
import com.stock.equipStock.EquipStockEntiyForm;
import com.stock.equipStock.EquipStockForm;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:29:45 
 * 类说明 
 */
public class rationService extends BusinessService{
	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(rationForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", form.getXiaoquHidden()+ "%");
		set.add("usertel", "@usertel", form.getUserTelHidden());
		//set.add("state", "@state", "1");
		set.add("stateDate", "@stateDate", form.getStateDateHidden());
		set.add("endDate", "@endDate", form.getEndDateHidden());
		return set;
	}
	
	public DataSet<DataRow> getResult(rationForm form, int first, int rows)throws Exception {
	return dao.executeQuery("GetPGDList1",getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(rationForm form) throws Exception {
	return dao.executeQueryToCount("GetPGDListCount1",getConditionParameterSet(form));
	}
	
	/**
	 * 根据UUID查询配工单详情
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getPGDByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("GetPGDByUUID",set);
	}
	
	/**
	 * 更新
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String update(rationEntityForm form) throws Exception {
		/*String error = validator.updateValidate(form);
		if(error != null){
			return error;
		}*/
		try {
			openTransaction();
			
			ParameterSet set = new ParameterSet();
			//set.add("employeeId", "@employeeId", form.getEmployeeCode());
			//set.add("type", "@type", form.getTypeString());
			set.add("xiaoquname", "@xiaoquname", form.getXiaoquname());
			set.add("userplace", "@userplace", form.getUserplace());
			set.add("usertel", "@usertel", form.getUsertel());
			set.add("kuandai", "@kuandai",form.getKuadnai() );
			set.add("tv", "@tv",form.getTv());
			set.add("tel", "@tel", form.getTel());
			set.add("useryaoqiu", "@useryaoqiu",form.getUseryaoqiu() );
			set.add("onu", "@onu", form.getOnu());
			set.add("jidinghe", "@jidinghe", form.getJidinghe());
			set.add("beizhu", "@beizhu", form.getBeizhu());
			
			set.add("UUID", "@UUID", form.getUUID());
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			dao.execute("updatePGDById",set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 删除
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String delete(rationEntityForm form) throws Exception {
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			dao.execute("DeletePGDById",set);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		} 
		return Constant.SUCCESS;
	}
	
	
	private ParameterSet getConditionParameterSetEquip(EquipStockForm form){
		ParameterSet set = new ParameterSet();
		set.add("type", "@type", form.getTypeHidden() + "%");
		set.add("state", "@state", form.getStateHidden() + "%");
		set.add("xinghao", "@xinghao", form.getXinghaoHidden() + "%");
		set.add("mac", "@mac", form.getMacHidden() + "%");
		return set;
	}
	
	public DataSet<DataRow> getEquipResult(EquipStockForm form, int first, int rows)
	throws Exception {
		return dao.executeQuery("GetEquipList",getConditionParameterSetEquip(form), first, rows);
    }
	
	public int getResultCount(EquipStockForm form) throws Exception {
		return dao.executeQueryToCount("GetEquipListCount",getConditionParameterSetEquip(form));
	}
}

