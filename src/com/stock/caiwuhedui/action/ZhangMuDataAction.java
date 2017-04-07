package com.stock.caiwuhedui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import com.stock.caiwuhedui.service.AccountsMateService;
import com.stock.caiwuhedui.service.ZhangMuEditService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.paigongdan.PaiGongDanService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class ZhangMuDataAction extends BusinessPaginationAction{

	PaiGongDanService  service = new PaiGongDanService();
	AccountsMateService serviceData = new AccountsMateService();
	ZhangMuEditService serviceEdit = new ZhangMuEditService();
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm f = serviceData.getResultZhangmuxinxi(((ZhangMuForm)form));
		String uuid = f.getZmUUID();
		f.setUUIDHidden(uuid);
		f.setHidden();
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping,  form , request, response);
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		ZhangMuForm f = (ZhangMuForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		ZhangMuForm f = (ZhangMuForm) form;
		f.setHidden();
		return serviceData.getResultZhangMuData((ZhangMuForm) form, first, rows);
	}
	


	public int getResultCount(ActionForm form) throws Exception {
		return serviceData.getResultCountZhangMuData((ZhangMuForm) form);
	}
	
	public ActionForward yipipeiDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm f =  (ZhangMuForm) form;
		serviceEdit.deleteYipipei(f);
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward zhangmuDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm f =  (ZhangMuForm) form;
		serviceEdit.deleteZhangmu(f);
		return mapping.findForward("success1");
	}
/*	public boolean saveMessage(CommonMessage message,HttpServletRequest request){
		if(message.getMessageCode() != Constant.SUCCESS){
			saveMessageNoCheck(message,request);
			return true;
		}
		return false;
	}
	
	public void saveMessageNoCheck(CommonMessage message,HttpServletRequest request){
		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(message.getMessageCode(),message.getParams()));
		saveMessages(request, messages);
	}*/
}
