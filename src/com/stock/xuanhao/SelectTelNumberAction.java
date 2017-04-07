package com.stock.xuanhao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.yuyuequery.YuyueForm;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class SelectTelNumberAction extends BusinessPaginationAction{
	
	PaiGongDanService  service = new PaiGongDanService();
	TelNumberService serviceTel = new TelNumberService();
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList",xiaoquList);
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=500;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=500;
		savedInRequest(request);
		TelNumberForm f = (TelNumberForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		TelNumberForm f =  (TelNumberForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return serviceTel.getResult((TelNumberForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		TelNumberForm f =  (TelNumberForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return serviceTel.getResultCount((TelNumberForm) form);
	}
}
