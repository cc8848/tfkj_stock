/*
 * TianFang science corporation (c)2012 all rights reserved.
 * Description:  create TotalShoufeiAction .
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-12-21   Li.Hai-Han(**)        Create
 */
package com.stock.total; 

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.paigongdan.PaiGongDanService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

/**
 * TotalShoufeiAction.
 * 
 * @author Li.Hai-Han(**)
 */
public class TotalShoufeiAction extends BusinessPaginationAction{
	TotalService  service = new TotalService();
	PaiGongDanService  service2 = new PaiGongDanService();
	YonghuDataService serviceData = new YonghuDataService();
	
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);
		request.setAttribute("statusList", statusList);
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows = 100;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		savedInRequest(request);
		TotalForm f = (TotalForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		TotalForm f = (TotalForm) form;
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		f.setStateList(statusList);
		return service.getResultShoufeiTotal((TotalForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		TotalForm f = (TotalForm) form;
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		f.setStateList (statusList);
		return 100;//service.getResultCountNull((TotalForm) form);
	}
}

