package com.stock.yuyuequery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.yuyue.YuyueService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class YuyueQueryAction extends BusinessPaginationAction{

	PaiGongDanService  service = new PaiGongDanService();
	
	YuyueQueryService yuyueService = new YuyueQueryService();
	
	YuyueService yyService = new YuyueService();
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList",xiaoquList);
		List<CommonModule> quyulist = yyService.getQuYuCodeAll();
		request.setAttribute("quyulist",quyulist);
		
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=50;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=50;
		savedInRequest(request);
		YuyueForm f = (YuyueForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		YuyueForm f =  (YuyueForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> quyulist = yyService.getQuYuCodeAll();
		f.setQuyulist(quyulist);
		return yuyueService.getResult((YuyueForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		YuyueForm f =  (YuyueForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> quyulist = yyService.getQuYuCodeAll();
		f.setQuyulist(quyulist);
		return yuyueService.getResultCount((YuyueForm) form);
	}
}
