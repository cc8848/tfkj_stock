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

public class QuyuAction extends BusinessPaginationAction{

	
	
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
		return shichangService.getResultQuyu((XiaoquForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return shichangService.getResultQuyuCount((XiaoquForm) form);
	}
	
	
	public ActionForward insertQuyu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		CommonMessage message = shichangService.insertQuyu(f);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} 
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward updateQuyu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		CommonMessage message = shichangService.updateQuyu(f);
		if (saveMessage(message, request)) {
			return mapping.findForward("success1");
		} 
		return mapping.findForward("success1");
	}
}
