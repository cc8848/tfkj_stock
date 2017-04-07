package com.hrbank.business.department;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.SuccessContant;
import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.frame.sql.DataRow;

public class DepartmentEditAction extends BusinessAction {

	private DepartmentService service = new DepartmentService();

	public ActionForward initInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward(FW_INIT_INSERT);
	}

	public ActionForward initEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		DepartmentForm departmentForm = (DepartmentForm) form;
		DataRow dataRow = service.getDepartmentById(departmentForm.getDepartmentCode());
		departmentForm.setDepartmentName(dataRow.getDataElement("DEPT_NAME").getString());

		return mapping.findForward(FW_INIT_EDIT);
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonMessage message = service.insert((DepartmentForm) form);
		saveMessageNoCheck(message, request);
		if (message.getMessageCode().equals(SuccessContant.DEPARTMENT_ADD_SUCCESS)) {
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_ERROR_INSERT);
	}

	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (saveMessage(service.update((DepartmentForm) form), request)) {
			return mapping.findForward(FW_ERROR_EDIT);
		}
		return mapping.findForward(FW_SUCCESS);
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		service.delete((DepartmentForm) form);
		return mapping.findForward(FW_SUCCESS);
	}
}
