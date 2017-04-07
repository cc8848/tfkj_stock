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
//工单复查Action
public class HuidanReviewDataAction extends BusinessPaginationAction{

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
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		f.setStatusList(statusList);
		
		return service1.getResultHuidanReview(f, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		// TODO Auto-generated method stub
		return service1.getResultCountHuidanReview((HuidanForm) form);
	}
	

	public ActionForward heduirudang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		CommonMessage commonMessage = service1.heduirudang(f);
		if (saveMessage(commonMessage, request)) {
			return mapping.findForward("init1");
		} 
		return mapping.findForward("init1");
	}
	
	/**
	 * 回单 数据核对编辑
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		f.setUUIDHidden(f.getUUID());
		f.setXiaoquList(srv.getXiaoQuCodeAll());
		service1.getHuidanForm_ByID(f.getUUID(), f);
		return mapping.findForward(FW_INIT_EDIT);

	}
}
