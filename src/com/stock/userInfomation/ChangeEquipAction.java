package com.stock.userInfomation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class ChangeEquipAction extends BusinessPaginationAction{

	private ChangeEquipService service = new ChangeEquipService();
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ChangeEquipForm f = (ChangeEquipForm) form;
		if(request.getParameter("equtype").equals("1")){
			f.setType("ONU");
		}else {
			f.setType("»ú¶¥ºÐ");
		}
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ChangeEquipForm f = (ChangeEquipForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		ChangeEquipForm f = (ChangeEquipForm) form;
		return service.getResult((ChangeEquipForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return service.getResultCount((ChangeEquipForm) form);
	}
}
