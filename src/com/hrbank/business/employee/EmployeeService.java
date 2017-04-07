package com.hrbank.business.employee;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.DataSetUtil;

public class EmployeeService extends BusinessService {

	private Log log = LogFactory.getLog(this.getClass());

	private CommonDao dao = new CommonDao();
	private EmployeeValidator validator = new EmployeeValidator();

	private ParameterSet getConditionParameterSet(EmployeeConditionForm form) {
		ParameterSet set = new ParameterSet();
		set.add("employeeId", "@employeeId", form.getEmployeeCodeHidden() + "%");
		set.add("employeeName", "@employeeName", form.getEmployeeNameHidden() + "%");
		set.add("roleId", "@roleId", form.getDepartmentCodeHidden());// 所属权限组
		// set.add("departmentName", "@departmentName", form.getDepartmentNameHidden() + "%");
		return set;
	}

	public DataSet<DataRow> getResult(EmployeeConditionForm form, int first, int rows) throws Exception {
		return dao.executeQuery("GetEmployeeResult", getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(EmployeeConditionForm form) throws Exception {
		return dao.executeQueryToCount("GetEmployeeResultCount", getConditionParameterSet(form));
	}

	public List<CommonModule> getAllRoles() throws Exception {
		return DataSetUtil.toCommonModuleList(dao.executeQuery("GetAllRoles", new ParameterSet()));
	}

	public String insert(EmployeeForm form) throws Exception {

		String error = validator.insertValidate(form);
		if (error != null) {
			return error;
		}

		DataRow row = getEmployeeById(form.getEmployeeCode());
		if (row != null) {
			return ErrorConstant.EMPLOYEE_CODE_REPEATED;
		}

		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			model.put("employeeId", form.getEmployeeCode());
			model.put("employeeName", form.getEmployeeName());
			model.put("roleId", form.getDepartmentCode());// 用户权限组
			model.put("employeePassword", "12345");
			dao.insert("Employee", model);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	public String update(EmployeeForm form) throws Exception {

		String error = validator.updateValidate(form);
		if (error != null) {
			return error;
		}

		try {
			openTransaction();

			ParameterSet set = new ParameterSet();
			set.add("employeeId", "@employeeId", form.getEmployeeCode());
			set.add("employeeName", "@employeeName", form.getEmployeeName());
			set.add("RoleId", "@RoleId", form.getDepartmentCode());
			dao.execute("UpdateEmployee", set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	public String delete(EmployeeForm form) throws Exception {
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("employeeId", "@employeeId", form.getEmployeeCode());
			dao.execute("DeleteEmployeeById", set);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		}
		return Constant.SUCCESS;
	}

	public DataRow getEmployeeById(String code) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("employeeId", "@employeeId", code);
		return dao.executeQueryToDataRow("GetEmployeeById", set);
	}

}
