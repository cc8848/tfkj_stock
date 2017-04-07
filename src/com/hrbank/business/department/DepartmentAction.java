package com.hrbank.business.department;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class DepartmentAction extends BusinessPaginationAction {

	private DepartmentService service = new DepartmentService();

	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return firstPage(mapping, form, request, response);
	}

	public ActionForward query(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DepartmentConditionForm f = (DepartmentConditionForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}

	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows) throws Exception {
		return service.getResult((DepartmentConditionForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return service.getResultCount((DepartmentConditionForm) form);
	}

}
