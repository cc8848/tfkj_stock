package com.stock.weihu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class DianshiAction extends BusinessPaginationAction{

	
	
	WeihuService shichangService = new WeihuService();
	
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=1000;
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=1000;
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		return shichangService.getResultDianshi((DianshiEidtForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return shichangService.getResultDianshiCount((DianshiEidtForm) form);
	}
	
	
	public ActionForward insertDianshi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DianshiEidtForm f =  (DianshiEidtForm) form;
		CommonMessage message = shichangService.insertDianshi(f);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} 
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DianshiEidtForm f =  (DianshiEidtForm) form;
		CommonMessage message = shichangService.update(f);
		if (saveMessage(message, request)) {
			return mapping.findForward("success1");
		} 
		return mapping.findForward("success1");
	}
}
