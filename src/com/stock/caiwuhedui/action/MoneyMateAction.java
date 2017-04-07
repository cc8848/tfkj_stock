package com.stock.caiwuhedui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import com.stock.caiwuhedui.service.ZhangMuService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class MoneyMateAction extends BusinessPaginationAction{

	ZhangMuService serviceData = new ZhangMuService();
	private String zhuangtai;
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		zhuangtai = request.getParameter("zhuangtai");
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		zhuangtai = request.getParameter("zhuangtai");
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		return serviceData.getResult((ZhangMuForm) form, first, rows , zhuangtai);
	}
	public int getResultCount(ActionForm form) throws Exception {
		//ZhangMuForm f = (ZhangMuForm) form;
		return serviceData.getResultCount((ZhangMuForm) form , zhuangtai);
	}
	
	public ActionForward subAccount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm dataForm = (ZhangMuForm) form;
		DataRow dataRow = serviceData.getZhangmuByUUID(dataForm.getZmUUID());
		String chazhi = dataRow.getDataElement("chazhi").getString();
		
		if (chazhi.equals("0")) {
			String value = serviceData.updateZhangmuState(dataForm.getZmUUID(),"1");
			if (!value.equals("success")) {
				CommonMessage message = new CommonMessage(ErrorConstant.SUBMIT_PIPEI_UPDATE_ERROR);
				saveMessage(message, request);
			}
		} else {
			CommonMessage message = new CommonMessage(ErrorConstant.SUBMIT_PIPEI_STATE);
			saveMessage(message, request);
		}
		
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping,  dataForm , request, response);
	}
	
	public void saveMessageNoCheck(CommonMessage message,HttpServletRequest request){
		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(message.getMessageCode(),message.getParams()));
		saveMessages(request, messages);
	}
	
	public boolean saveMessage(CommonMessage message,HttpServletRequest request){
		if(message.getMessageCode() != Constant.SUCCESS){
			saveMessageNoCheck(message,request);
			return true;
		}
		return false;
	}

}
