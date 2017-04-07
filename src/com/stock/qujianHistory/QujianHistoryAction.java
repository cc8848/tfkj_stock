package com.stock.qujianHistory; 

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:29:01 
 */
public class QujianHistoryAction extends BusinessPaginationAction{

	PaiGongDanService  service = new PaiGongDanService();
	
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
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		savedInRequest(request);
		PaiGongDanForm f = (PaiGongDanForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		PaiGongDanForm f =  (PaiGongDanForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResult((PaiGongDanForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		PaiGongDanForm f =  (PaiGongDanForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultCount((PaiGongDanForm) form);
	}
}

