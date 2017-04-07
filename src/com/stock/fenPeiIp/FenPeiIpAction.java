package com.stock.fenPeiIp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.equipStock.EquipStockEntiyForm;
import com.takucin.aceeci.frame.sql.DataRow;

public class FenPeiIpAction extends BusinessAction{
	private FeiPeiIpService service = new FeiPeiIpService();
	
	/**
	 * 跳转到派工单指定Ip页面。
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward PGDipInit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FeiPeiIpForm f  = (FeiPeiIpForm) form;
		DataRow dataRow = service.getPgdOtherByUUID(f.getPgdUUID());
		CommonMessage message = checkFenPeiIp(dataRow);
		if(saveMessage(message, request)){
			return mapping.findForward(FW_SUCCESS);
		}else{
		
		f.setPgdUUID(dataRow.getDataElement("PK_ID").getString());
		
		f.setFenguang(dataRow.getDataElement("fenguang").getString());
		f.setNetIp(dataRow.getDataElement("netip").getString());
		f.setNetValn(dataRow.getDataElement("netvaln").getString());
		f.setTelIp(dataRow.getDataElement("telip").getString());
		f.setTelValn(dataRow.getDataElement("telvaln").getString());
		f.setTvip(dataRow.getDataElement("tvip").getString());
		f.setYeWu(dataRow.getDataElement("yewu").getString());
		
		f.setXiaoquname(dataRow.getDataElement("xiaoquname").getString());
		f.setUserplace(dataRow.getDataElement("userplace").getString());
		f.setKuadnai(dataRow.getDataElement("tfkuandaidaikuan").getString());
		f.setTel(dataRow.getDataElement("dianhua").getString());
		f.setTv(dataRow.getDataElement("tfiptv").getString());
		
		
		
		return mapping.findForward(FW_INIT_EDIT);
		}
	}
	
	/**
	 * 校验现在是否可以分配IP
	 * @param dataRow
	 * @return
	 * @throws Exception
	 */
	public CommonMessage checkFenPeiIp(DataRow dataRow)throws Exception{
		String state = dataRow.getDataElement("state").getString();
		if(!state.equals("2")){//2 已制定 之后才能分配IP
			return new CommonMessage(ErrorConstant.FENPEI_IP_STATE);
		}else{
			return new CommonMessage("SUCCESS");
		}
		
	}
	
	/**
	 * 更新
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String result = service.update((FeiPeiIpForm)form);
		if(saveMessage(result,request)){
			return mapping.findForward(FW_ERROR_EDIT);
		}
		return mapping.findForward(FW_SUCCESS);
	}
}
