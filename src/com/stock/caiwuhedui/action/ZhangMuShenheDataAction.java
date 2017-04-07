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

public class ZhangMuShenheDataAction extends BusinessPaginationAction{

	PaiGongDanService  service = new PaiGongDanService();
	AccountsMateService serviceData = new AccountsMateService();
	ZhangMuEditService serviceEdit = new ZhangMuEditService();
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm f = serviceData.getResultZhangmuHeduiXinxi(((ZhangMuForm)form));
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
		return firstPage(mapping, form, request, response);
	}
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		ZhangMuForm f = (ZhangMuForm) form;
		//String uuid = f.getZmUUID();
		//f.setUUIDHidden(uuid);
		//f.setHidden();
		return serviceData.getResultZhangMuData(f, first, rows);
	}
	


	public int getResultCount(ActionForm form) throws Exception {
		return serviceData.getResultCountZhangMuData((ZhangMuForm) form);
	}

}
