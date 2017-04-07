/*
 * ���ܱ�ţ�S024
 * �������ƣ���ӭ����
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
 * ��ӭ��������ʵ����.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class MainService extends BusinessService {

	private CommonDao dao = new CommonDao();

	/**
	 * ��ʼ����ӭ����������Ϣ.
	 * 
	 * @return ���ػ�ӭ���������Ϣ�ı�������.
	 * @throws Exception
	 *             ��������κδ���.
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
