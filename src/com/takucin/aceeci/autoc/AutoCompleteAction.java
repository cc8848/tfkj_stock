package com.takucin.aceeci.autoc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.CommonAction;

public class AutoCompleteAction extends CommonAction {
	
	public static final int SRC_TYPE_DEPARTMENTS = 1;		// Department
	public static final int SRC_TYPE_EMPLOYEES = 2;			// Employee
	
	public static final String PARAM_CODE = "code";
	public static final String PARAM_SRC = "src";
	
	
	private AutoCompleteService service = new AutoCompleteService();

	public ActionForward autoCode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String code = request.getParameter(PARAM_CODE);
		int src = Integer.parseInt(request.getParameter(PARAM_SRC));
		
		List<CommonModule> modules = null;
		
		switch(src){
		case SRC_TYPE_DEPARTMENTS:
			modules = service.getDepartments(code);
			break;
		case SRC_TYPE_EMPLOYEES:
			modules = service.getEmployees(code);
			break;
		default:
			
		}
		println(response,service.toJsonObject(modules).toString());
		return null;
	}
}
