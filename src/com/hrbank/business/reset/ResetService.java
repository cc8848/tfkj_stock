package com.hrbank.business.reset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.employee.EmployeeService;
import com.hrbank.business.employee.EmployeeValidator;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Encrypt;

public class ResetService extends BusinessService {
	private Log log = LogFactory.getLog(this.getClass());
	private CommonDao dao = new CommonDao();
	private EmployeeService service = new EmployeeService();
	private EmployeeValidator validator = new EmployeeValidator();

	public String update(ResetForm form) throws Exception {
		String error = validator.resetValidate(form);
		if (error != null) {
			return error;
		}
		DataRow row = service.getEmployeeById(form.getEmployeeCode());
		if (row == null) {
			return ErrorConstant.EMPLOYEE_CODE_NOT_EXIST;
		}
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("employeeId", "@employeeId", form.getEmployeeCode());
			set.add("employeePassword", "@employeePassword", Encrypt.getMD5Message("12345"));
			dao.execute("UpdateEmployeePassword", set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	public DataSet<DataRow> getEmployeeById(String code) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("employeeId", "@employeeId", code);
		return dao.executeQuery("GetEmployeeById", set);
	}

}
