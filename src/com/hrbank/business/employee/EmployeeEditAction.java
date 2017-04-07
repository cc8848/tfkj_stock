package com.hrbank.business.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;

public class EmployeeEditAction extends BusinessAction {

	private EmployeeService service = new EmployeeService();

	private void savedInRequest(HttpServletRequest request) throws Exception {
		List<CommonModule> roleList = service.getAllRoles();
		request.setAttribute("roleList", roleList);
	}

	public ActionForward initInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		savedInRequest(request);
		return mapping.findForward(FW_INIT_INSERT);
	}

	public ActionForward initEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		EmployeeForm employeeForm = (EmployeeForm) form;
		DataRow dataRow = service.getEmployeeById(employeeForm.getEmployeeCode());
		employeeForm.setEmployeeName(dataRow.getDataElement("EMP_NAME").getString());
		employeeForm.setDepartmentCode(dataRow.getDataElement("ROLE_ID").getString());// 用户权限组
		// employeeForm.setDepartmentCode(dataRow.getDataElement("").getString());
		employeeForm.setEmployeeCode(dataRow.getDataElement("PK_ID").getString());
		savedInRequest(request);
		return mapping.findForward(FW_INIT_EDIT);
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = service.insert((EmployeeForm) form);
		if (saveMessage(result, request)) {
			savedInRequest(request);
			return mapping.findForward(FW_ERROR_INSERT);
		}
		return mapping.findForward(FW_SUCCESS);
	}

	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String result = service.update((EmployeeForm) form);
		if (saveMessage(result, request)) {
			savedInRequest(request);
			return mapping.findForward(FW_ERROR_EDIT);
		}
		return mapping.findForward(FW_SUCCESS);
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		service.delete((EmployeeForm) form);
		return mapping.findForward(FW_SUCCESS);
	}

}
