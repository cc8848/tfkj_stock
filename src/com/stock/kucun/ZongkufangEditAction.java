/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data init and query.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2015-12-15   DaiZhen            Create
 */
package com.stock.kucun;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.common.CommonModule;

public class ZongkufangEditAction extends BusinessAction {
	KucunDataService  kcDataService = new KucunDataService();
	/**
	 * Ìø×ªµ½insert Ò³Ãæ
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initInsert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward(FW_INIT_INSERT);
	}
	public ActionForward initInsert2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		ZongkufangInfoForm f = (ZongkufangInfoForm) form;
		f.setXiaoquList(xiaoquList);
		return mapping.findForward(FW_INIT_INSERT2);
	}
	public ActionForward insert_zongkufang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KucunService  service = new KucunService();
		CommonMessage message =  service.insertZongkufang((ZongkufangInfoForm) form, request);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	public ActionForward insert_zongkufanglog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KucunService  service = new KucunService();
		CommonMessage message =  service.updateZongkufang((ZongkufangInfoForm) form, request);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_SUCCESS);
	}
}
