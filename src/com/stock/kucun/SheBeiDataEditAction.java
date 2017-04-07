/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data edit or update class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 */
package com.stock.kucun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessAction;

/**
 * user data edit or update class.
 * 
 * @author Zhu.Xiao-Lei 
 */
public class SheBeiDataEditAction extends BusinessAction {
	KucunService  service = new KucunService();
	KucunDataService  kcDataService = new KucunDataService();
	

	
	/**
	 * 用于更新kucunform
	 * @param mapping
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public ActionForward update_Product(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KucunService  service = new KucunService();
		service.updateProduct((KuncunForm) form, request);
		KuncunForm f = (KuncunForm) form;
		f.getZhuangtai();
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward update_XiaoquKu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KucunService  service = new KucunService();
		CommonMessage message =  service.updateXiaoquKuSheBei((KuncunForm) form, request);
		if (saveMessage(message, request)) {
			return mapping.findForward("success1");
		}
		return mapping.findForward("success1");
	}
	public ActionForward update_AnzhuangKu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KuncunForm f = (KuncunForm) form;
		String zhuangtai = f.getZhuangtai();
		KucunService  service = new KucunService();
		CommonMessage message = service.updateAnzhuangKuSheBei((KuncunForm) form, request);
		if (saveMessage(message, request)) {
			if (zhuangtai.equals("3")) {
				return mapping.findForward("success3");
			}else {
				return mapping.findForward("success2");
			}
		} 
		if (zhuangtai.equals("3")) {
			return mapping.findForward("success3");
		}
		return mapping.findForward("success2");
	}
	public ActionForward update_YichangKu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KucunService  service = new KucunService();
		service.updateYichangKuSheBei((KuncunForm) form, request);
		return mapping.findForward("success3");
	}

}
