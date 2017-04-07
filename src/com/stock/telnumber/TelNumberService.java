package com.stock.telnumber;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.paigongdan.PaiGongDanEntiyForm;
import com.takucin.aceeci.frame.model.ParameterModel;
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
		set.add("state", "@state", form.getStateCodeHidden());
		return set;
	}
	
	public DataSet<DataRow> getResult(TelNumberForm form, int first, int rows)throws Exception {
		return dao.executeQuery("GetTelList",getConditionParameterSet(form), first, rows);
		}

		public int getResultCount(TelNumberForm form) throws Exception {
		return dao.executeQueryToCount("GetTelListCount",getConditionParameterSet(form));
		}
	/**
	 * 删除	
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String delete(TelNumEidtForm form) throws Exception {
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			
			dao.execute("DeleteTel",set);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		} 
		return Constant.SUCCESS;
		}	
	
	/**
	 * 根据UUID查询电话对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getTelByUUID(String code)throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("GetTelByUUID",set);
	}

	public CommonMessage update(String uuid) {
		try {
			//判断区域是否存在
			ParameterModel model = new ParameterModel();
			model.put("state", "0");
			ParameterModel conds = new ParameterModel();
			conds.put("UUID", uuid);
			dao.update("telnumber", model, conds);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "修改失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "修改成功！");
	}
	
	public CommonMessage updateLock(String uuid) {
		try {
			//判断区域是否存在
			ParameterModel model = new ParameterModel();
			model.put("state", "1");
			ParameterModel conds = new ParameterModel();
			conds.put("UUID", uuid);
			dao.update("telnumber", model, conds);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "修改失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "修改成功！");
	}
	
	public CommonMessage updateTel(TelNumEidtForm form) {
		try {
			//判断区域是否存在
			ParameterModel model = new ParameterModel();
			if (form.getDesc() == null) {
				model.put("beizhu", "");
			} else {
				model.put("beizhu", form.getDesc());
			}
			
			ParameterModel conds = new ParameterModel();
			conds.put("UUID", form.getUUID());
			
			dao.update("telnumber", model, conds);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "修改失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "修改成功！");
	}
}
