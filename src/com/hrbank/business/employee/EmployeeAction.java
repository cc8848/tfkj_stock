package com.hrbank.business.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class EmployeeAction extends BusinessPaginationAction {

	private EmployeeService service = new EmployeeService();

	/**
	 * 放入角色列表
	 * 
	 * @param request
	 * @throws Exception
	 */
	private void savedInRequest(HttpServletRequest request) throws Exception {
		List<CommonModule> roleList = service.getAllRoles();
		request.setAttribute("roleList", roleList);
	}

	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}

	public ActionForward query(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		EmployeeConditionForm f = (EmployeeConditionForm) form;
		f.setHidden();
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}

	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows) throws Exception {
		EmployeeConditionForm f = (EmployeeConditionForm) form;
		List<CommonModule> roleList = service.getAllRoles();
		f.setRoleList(roleList);
		return service.getResult((EmployeeConditionForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		EmployeeConditionForm f = (EmployeeConditionForm) form;
		List<CommonModule> roleList = service.getAllRoles();
		f.setRoleList(roleList);
		return service.getResultCount((EmployeeConditionForm) form);
	}

}
