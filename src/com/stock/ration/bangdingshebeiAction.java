package com.stock.ration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessAction;

public class bangdingshebeiAction extends BusinessAction{
	private bangdingService service = new bangdingService();
	
	/**
	 * 设备绑定到派工单
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward bangding(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		System.out.println("=============");
		rationSecondForm f = (rationSecondForm) form;
		String [] UUIDS = f.getUUIDS();
		for (String uuid : UUIDS) {
			f.setUUID(uuid);
			String result = service.bangding((rationSecondForm)form);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		return mapping.findForward(FW_SUCCESS);
	}
}
