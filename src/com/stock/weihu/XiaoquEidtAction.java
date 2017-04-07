package com.stock.weihu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessAction;

public class XiaoquEidtAction extends BusinessAction{
	
	WeihuService service = new WeihuService();
	
	/**
	 * 新增时长类型
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		f.setQuyuList(service.getQuYuCodeAll());
		f.setKufangList(service.getKuFangCodeAll());
		f.setSeq("9");
		//request.setAttribute("quyuList", service.getQuYuCodeAll());
		return mapping.findForward(FW_INIT_INSERT);
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		service.editInit(f);
		f.setQuyuList(service.getQuYuCodeAll());
		f.setKufangList(service.getKuFangCodeAll());
		return mapping.findForward("init.edit");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		CommonMessage message = service.delete(f);
		if (saveMessage(message, request)) {
			return mapping.findForward("success1");
		} 
		return mapping.findForward("success1");
	}
	
	public ActionForward inityewuselect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		service.editInit(f);
		return mapping.findForward("init.shichang");
	}
	
	public ActionForward initdianshiselect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		service.editInit(f);
		return mapping.findForward("init.dianshi");
	}

}
