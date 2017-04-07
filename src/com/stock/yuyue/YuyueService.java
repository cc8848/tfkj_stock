package com.stock.yuyue;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.equipStock.EquipStockEntiyForm;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.DataSetUtil;

public class YuyueService extends BusinessService{

private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(YuyueForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu", form.getXiaoqucodeHidden());
		set.add("riqi", "@riqi", form.getRiqicodeHidden());
		set.add("starriqi", "@starriqi",form.getStarriqicodeHidden());
		set.add("endriqi", "@endriqi",form.getEndriqicodeHidden());
		
		return set;
	}
	
	public DataSet<DataRow> getResult(YuyueForm form, int first, int rows)throws Exception {
	return dao.executeQuery("GetPlanList",getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(YuyueForm form) throws Exception {
	return dao.executeQueryToCount("GetPlanListCount",getConditionParameterSet(form));
	}

	
	public String insert(YuyueEidtForm form) throws Exception {
		
		DataRow dataRow = getYuyue(form);
		if(dataRow!=null){
			return ErrorConstant.YUYUEEXIST;
		}
		
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			//model.put("employeeId", form.getEmployeeCode());Common.formatDate(form.getRukudateString(), "yyyy-MM-dd HH:mm:ss")
			model.put("xiaoqu", form.getXiaoqu());
			model.put("riqi", form.getRiqi());
			model.put("shijian", form.getShijian());
			model.put("azjh", form.getAzjh());
			model.put("azsy", 0);
			model.put("qjjh", form.getQjjh());
			model.put("qjsy", 0);
			model.put("yujing", form.getYujing());
			model.put("createby", getUserInfo().getEmployeeName());
			model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			dao.insert("plan",model);
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
	public String update(YuyueEidtForm form) throws Exception {
		/*String error = validator.updateValidate(form);
		if(error != null){
			return error;
		}*/
		try {
			openTransaction();
			
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			if (form.getYujing() == null || form.getYujing().trim().equals("")) {
				set.add("yujing", "@yujing", " ");
			} else {
				set.add("yujing", "@yujing", form.getYujing());
			}
			set.add("azjh", "@azjh", form.getAzjh());
			//set.add("zasy", "@zasy", form.getAzsy());
			set.add("qjjh", "@qjjh", form.getQjjh());
			//set.add("qjsy", "@qjsy", form.getQjsy());
			
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			set.add("updateby", "@updateby", getUserInfo().getEmployeeName());
			dao.execute("updateYuyue",set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	public DataRow getYuyue(YuyueEidtForm form) throws Exception{
		ParameterSet set = new ParameterSet();
		//set.add("UUID", "@UUID", code);
		set.add("xiaoqu", "@xiaoqu", form.getXiaoqu());
		set.add("shijian", "@shijian", form.getShijian());
		set.add("riqi", "@riqi", form.getRiqi());
		return dao.executeQueryToDataRow("getYuyue",set);
	}
	/**
	 * 根据UUID查询设备对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getYuyueByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("getYuyue",set);
	}
	
	/**
	 * 删除
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String delete(YuyueEidtForm form) throws Exception {
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			dao.execute("deleteYuyue",set);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		} 
		return Constant.SUCCESS;
	}
	
	/**
	 * 冻结计划
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String blocking(YuyueEidtForm form) throws Exception{
		DataRow yuyueData = getYuyueByUUID(form.getUUID());
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			
			set.add("UUID", "@UUID", form.getUUID());
			set.add("azsy", "@azsy", yuyueData.getDataElement("azjh").getString());
			set.add("qjsy", "@qjsy", yuyueData.getDataElement("qjjh").getString());
			
			set.add("updateby", "@updateby", getUserInfo().getEmployeeName());
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			dao.execute("updateYuyueJh",set);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		} 
		return Constant.SUCCESS;
	}
	/**
	 * 获取小区列表
	 * @return
	 * @throws Exception
	 */
	public List<CommonModule> getQuYuCodeAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getQuYuCodeAll",new ParameterSet()));
	}
}
