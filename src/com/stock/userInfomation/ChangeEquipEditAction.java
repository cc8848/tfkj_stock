
package com.stock.userInfomation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessAction;

public class ChangeEquipEditAction extends BusinessAction{

	private ChangeEquipService service = new ChangeEquipService();
	
	/**
	 *更换ONU设备
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward changeOnu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ChangeEquipForm f = (ChangeEquipForm) form;
		//System.out.println(f.getUUID()+"--"+f.getEqpUUID());
		String type = f.getType();
		if(type.equals("ONU")){
			String result = service.changeEquipONU(f);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}else{
			String result = service.changeEquipJidinghe(f);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		
		
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 更换机顶盒
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward changeJidinghe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		
		return mapping.findForward(FW_SUCCESS);
	}
}
