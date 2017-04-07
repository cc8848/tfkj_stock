package com.stock.ration; 

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.paigongdan.PaiGongDanService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:29:01 
 * 配给
 */
public class rationAction extends BusinessPaginationAction{

	rationService  service = new rationService();
	PaiGongDanService  service2 = new PaiGongDanService();
	
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
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
		rationForm f = (rationForm) form;
		f.setHidden();
		savedInRequest(request);
		//f.setState("1");//"设备配给页面，只检索已录入的配工单"
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		rationForm f = (rationForm) form;
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResult((rationForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		rationForm f = (rationForm) form;
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultCount((rationForm) form);
	}
}

