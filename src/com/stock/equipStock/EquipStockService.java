package com.stock.equipStock; 

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.DataSetUtil;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 上午09:07:17 
 * 类说明 
 */
public class EquipStockService extends BusinessService{
	
	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(EquipStockForm form){
		ParameterSet set = new ParameterSet();
		set.add("type", "@type", form.getTypeHidden() + "%");
		set.add("state", "@state", form.getStateHidden() );
		set.add("xinghao", "@xinghao", form.getXinghaoHidden() + "%");
		set.add("mac", "@mac", form.getMacHidden() + "%");
		set.add("xianghao", "@xianghao", form.getXianghaoHidden() + "%");
		set.add("chukuplace", "@chukuplace", form.getChukuplaceStringsHidden());
		return set;
	}
	
	public DataSet<DataRow> getResult(EquipStockForm form, int first, int rows)
			throws Exception {
		return dao.executeQuery("GetEquipList",getConditionParameterSet(form), first, rows);
	}
	
	public int getResultCount(EquipStockForm form) throws Exception {
		return dao.executeQueryToCount("GetEquipListCount",getConditionParameterSet(form));
	}
	
	
	
	
	
	public String insert(EquipStockEntiyForm form) throws Exception {
		
		/*String error = validator.insertValidate(form);
		if(error != null){
			return error;
		}
		
		DataRow row = getEmployeeById(form.getEmployeeCode());
		if(row != null){
			return ErrorConstant.EMPLOYEE_CODE_REPEATED;
		}*/
		
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			//model.put("employeeId", form.getEmployeeCode());Common.formatDate(form.getRukudateString(), "yyyy-MM-dd HH:mm:ss")
			model.put("type", form.getTypeString());
			model.put("xianghao",form.getXinghaoString() );
			model.put("rukudate", form.getRukudateString());
			model.put("state","1" );
			model.put("rukuperson",form.getRukupersonString() );
			model.put("xinghao", form.getXinghaoString());
			model.put("mac", form.getMacsString());
			model.put("zhucejifang",form.getZhucejifangString() );
			model.put("TVip",form.gettVipString() );
			model.put("beizhu",form.getBeizhuString() );
			model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			model.put("chukuplace", form.getChukuplaceString());
			dao.insert("equipmentstock",model);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 移库
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String yiku(EquipStockEntiyForm form) throws Exception{
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			set.add("chukuplace", "@chukuplace", form.getChukuplaceString());
			dao.execute("yiku",set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	
	/**
	 * 更新
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String update(EquipStockEntiyForm form) throws Exception {
		/*String error = validator.updateValidate(form);
		if(error != null){
			return error;
		}*/
		try {
			openTransaction();
			
			ParameterSet set = new ParameterSet();
			//set.add("employeeId", "@employeeId", form.getEmployeeCode());
			set.add("type", "@type", form.getTypeString());
			set.add("xinghao", "@xinghao",form.getXinghaoString());
			set.add("xianghao", "@xianghao",form.getXianghaoString());
			set.add("rukuperson", "@rukuperson",form.getRukupersonString());
			set.add("rukudate", "@rukudate",form.getRukudateString());
			set.add("mac", "@mac",form.getMacsString());
			set.add("zhucejifang", "@zhucejifang",form.getZhucejifangString() );
			set.add("tvip", "@tvip",form.gettVipString() );
			set.add("UUID", "@UUID", form.getUUID());
			set.add("beizhu", "@beizhu", form.getBeizhuString());
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			dao.execute("updateEquipById",set);
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
	public String delete(EquipStockEntiyForm form) throws Exception {
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			dao.execute("DeleteEquipById",set);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		} 
		return Constant.SUCCESS;
	}
	/**
	 * 根据UUID查询设备对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getEquipByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("GetEquipById",set);
	}
	
	/**
	 * 查询出所有库存地点
	 * @return
	 * @throws Exception
	 */
	public List<CommonModule> getKucunAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getKucunAll",new ParameterSet()));
	}
	
}

