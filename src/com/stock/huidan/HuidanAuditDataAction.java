package com.stock.huidan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
//»Øµ¥¸´²é
public class HuidanAuditDataAction extends BusinessPaginationAction{

	PaiGongDanService  srv = new PaiGongDanService();
	HuidanDataService  service = new HuidanDataService();
	HuidanService service1 = new HuidanService();
	YonghuDataService serviceData = new YonghuDataService();
	
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		//savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		//savedInRequest(request);
		HuidanForm f = (HuidanForm)form;
		f.setHidden();
		return firstPage(mapping, f, request, response);
	}
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		HuidanForm f =  (HuidanForm) form;
		return service1.getResultAudit(f, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		// TODO Auto-generated method stub
		return service1.getResultCountAudit((HuidanForm) form);
	}
	

	public ActionForward heduiBeizhu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		if (f.getUUIDHidden() == null || f.getUUIDHidden().equals("")){
			f.setUUIDHidden(f.getUUID());
			return mapping.findForward("init.edit1");
		} else {
			CommonMessage commonMessage = service1.heduiBeizhuAudit(f);
			if (saveMessage(commonMessage, request)) {
				return mapping.findForward("init1");
			} 
			return mapping.findForward("init1");
		}
		
	}
	
	public ActionForward tijiaoHedui(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		CommonMessage commonMessage = service1.tijiaoHeduiAudit(f);
		if (saveMessage(commonMessage, request)) {
			return mapping.findForward("init1");
		} 
		return mapping.findForward("init1");
	}
}
