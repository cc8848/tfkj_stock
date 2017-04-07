package com.stock.total;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessAction;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.paigongdan.PaiGongDanService;
import com.stock.paigongdan.XufeilvForm;
import com.stock.paigongdan.XufeilvService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;


public class XufeilvAction extends BusinessPaginationAction{	
	XufeilvService  service = new XufeilvService();
	PaiGongDanService  service2 = new PaiGongDanService();
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}
	public DataSet<DataRow> getResult(ActionForm form, int arg1, int arg2) throws Exception {
		XufeilvForm f = (XufeilvForm) form;
		f.setHidden();
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		DataSet<DataRow> dataSet = service.getResult(f);
		return dataSet;
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows = 100;
		savedInRequest(request);
		XufeilvForm f = (XufeilvForm) form;
		f.setHidden();
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		savedInRequest(request);
		XufeilvForm f = (XufeilvForm) form;
		f.setHidden();
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return firstPage(mapping, form, request, response);
	}

	@Override
	public int getResultCount(ActionForm form) throws Exception {
		
		return 1000;
	}
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);
	}

}
