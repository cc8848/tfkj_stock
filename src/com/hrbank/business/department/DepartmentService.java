package com.hrbank.business.department;

import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.SuccessContant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.DataSetUtil;

public class DepartmentService extends BusinessService {

	private Log log = LogFactory.getLog(this.getClass());

	private CommonDao dao = new CommonDao();
	private DepartmentValidator validator = new DepartmentValidator();

	private ParameterSet getConditionParameterSet(DepartmentConditionForm form) {
		ParameterSet set = new ParameterSet();
		set.add("departmentId", "@departmentId", form.getDepartmentCodeHidden() + "%");
		set.add("departmentName", "@departmentName", form.getDepartmentNameHidden() + "%");
		return set;
	}

	public DataSet<DataRow> getResult(DepartmentConditionForm form, int first, int rows) throws Exception {
		return dao.executeQuery("GetDepartmentResult", getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(DepartmentConditionForm form) throws Exception {
		return dao.executeQueryToCount("GetDepartmentResultCount", getConditionParameterSet(form));
	}

	public List<CommonModule> getAllDepartment() throws Exception {
		return DataSetUtil.toCommonModuleList(dao.executeQuery("GetAllDepartments", new ParameterSet()));
	}

	public List<DataRow> getResult(DepartmentForm form) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("departmentName", "@departmentName", form.getDepartmentName());
		return dao.executeQuery("GetDepartmentResult", set);
	}

	public String getNewDepartmentCode() throws Exception {
		String uuid = UUID.randomUUID().toString();
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			model.put("uuid", uuid);
			dao.insert("DepartmentCodeBuilder", model);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		ParameterSet set = new ParameterSet();
		set.add("uuid", "@uuid", uuid);
		DataRow row = dao.executeQueryToDataRow("GetNewDepartmentId", set);
		long id = row.getDataElement("ID").getLong();
		String code = "2002" + new DecimalFormat("000").format(id);
		return code;
	}

	public CommonMessage insert(DepartmentForm form) throws Exception {

		String error = validator.validate(form);
		if (error != null) {
			return new CommonMessage(error);
		}

		if (getResult(form).size() > 0) {
			return new CommonMessage(ErrorConstant.DEPARTMENT_NAME_REPEATED);
		}

		String code = getNewDepartmentCode();
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			model.put("departmentId", code);
			model.put("departmentName", form.getDepartmentName());
			dao.insert("Department", model);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return new CommonMessage(SuccessContant.DEPARTMENT_ADD_SUCCESS, code);
	}

	public String update(DepartmentForm form) throws Exception {

		String error = validator.validate(form);
		if (error != null) {
			return error;
		}

		if (getResult(form).size() > 0) {
			return ErrorConstant.DEPARTMENT_NAME_REPEATED;
		}

		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("departmentId", "@departmentId", form.getDepartmentCode());
			set.add("departmentName", "@departmentName", form.getDepartmentName());
			dao.execute("UpdateDepartment", set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	public int delete(DepartmentForm form) throws Exception {
		int eff = 0;
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("departmentId", "@departmentId", form.getDepartmentCode());
			eff = dao.execute("DeleteDepartmentById", set);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		}
		return eff;
	}

	public DataRow getDepartmentById(String code) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("departmentId", "@departmentId", code);
		return dao.executeQueryToDataRow("GetDepartmentById", set);
	}

}
