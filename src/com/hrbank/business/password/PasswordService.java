/*
 * 机能编号：S002
 * 机能名称：密码修改
 * 
 * @author aceeci
 * @date 2009-08-25
 */
package com.hrbank.business.password;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.ParameterSet;

/**
 * 密码修改服务层实现类.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class PasswordService extends BusinessService {

	private Log log = LogFactory.getLog(this.getClass());

	private CommonDao dao = new CommonDao();
	private PasswordValidator validator = new PasswordValidator();

	private boolean isActivePassword(PasswordForm form) throws Exception {
		ParameterSet set = new ParameterSet();
		Employee emp = getUserInfo();
		set.add("employeeId", "@employeeId", emp.getEmployeeCode());
		set.add("employeePassword", "@employeePassword", form.getOldPassword());
		int count = dao.executeQueryToCount("IsActivePassword", set);
		if (count > 0) {
			return true;
		}
		return false;
	}

	public String change(PasswordForm form) throws Exception {

		String error = validator.validate(form);
		if (error != null) {
			return error;
		}

		if (!isActivePassword(form)) {
			return ErrorConstant.OLD_PASSWORD_NOT_MATCH;
		}
		try {
			openTransaction();
			Employee emp = getUserInfo();
			ParameterSet set = new ParameterSet();
			set.add("employeeId", "@employeeId", emp.getEmployeeCode());
			set.add("employeePassword", "@employeePassword", form.getNewPassword());
			dao.execute("ChangePassword", set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

}
