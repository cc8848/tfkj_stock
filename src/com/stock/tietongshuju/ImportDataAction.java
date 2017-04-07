/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: �����ͨ���췿�Ƽ����ϵͳ�Խӷ���
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2013-09-22   Lhh                   Create
 */
package com.stock.tietongshuju; 

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessAction;
import com.stock.yonghushuju.TietongDataForm;
import com.stock.yonghushuju.YonghuDataForm;


/** 
 * deal with excel import.
 * 
 * @author Zhu.Xiao-Lei 
 */
public class ImportDataAction extends BusinessAction {
	List<Map<String, String>> zjlist;
	public static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
	private ImportValidator validator = new ImportValidator();
	private ImportDataService service = new ImportDataService();
	
	/**
	 * ������ͨ����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward importTietong(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TietongDataForm f = (TietongDataForm) form;
		CommonMessage message = service.findTodayDate(f);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * ������ͨ���˱�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward tietongduizhangimport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		YonghuDataForm yf = (YonghuDataForm) form;
		CommonMessage message = service.tietongduizhangimport(yf);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
}

	

