/*
 * 机能编号：S024
 * 机能名称：欢迎界面
 * 
 * @author aceeci
 * @date 2009-08-25
 */
package com.hrbank.business.main;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.ParameterSet;

/**
 * 欢迎界面服务层实现类.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class MainService extends BusinessService {

	private CommonDao dao = new CommonDao();

	/**
	 * 初始化欢迎界面的相关信息.
	 * 
	 * @return 返回欢迎界面相关信息的表单属性类.
	 * @throws Exception
	 *             如果发生任何错误.
	 */
	public MainForm initMainInfo() throws Exception {
		Employee emp = getUserInfo();
		ParameterSet set = new ParameterSet();
		set.add("employeeId", "@employeeId", emp.getEmployeeCode());
		DataRow row = dao.executeQueryToDataRow("LoadMainInfo", set);
		MainForm mainForm = new MainForm();
		mainForm.setEmployeeCode(row.getDataElement("ID").getString());
		mainForm.setEmployeeName(row.getDataElement("NAME").getString());
		mainForm.setDepartmentCode(row.getDataElement("ROLE_ID").getString());
		mainForm.setDepartmentName(row.getDataElement("ROLE_Name").getString());
		return mainForm;
	}

}
