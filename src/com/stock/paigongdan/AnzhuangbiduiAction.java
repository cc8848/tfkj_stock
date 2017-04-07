package com.stock.paigongdan;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class AnzhuangbiduiAction extends BusinessPaginationAction{

	PaiGongDanService service = new PaiGongDanService();
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			this.rows=500;
			savedInRequest(request);
			String selectxiaoqu = request.getParameter("selectxiaoqu");
			selectxiaoqu = URLDecoder.decode(selectxiaoqu, "utf-8");
			String selectuserplace = request.getParameter("selectdizhi");
			selectuserplace = URLDecoder.decode(selectuserplace, "utf-8");
			PaiGongDanForm paigongdanform = (PaiGongDanForm) form;
			paigongdanform.setXiaoqu(selectxiaoqu);
			paigongdanform.setUserplaces(selectuserplace);
			String selectkbn = request.getParameter("selectkbn");
			selectuserplace = URLDecoder.decode(selectuserplace, "utf-8");
			if("2".equals(selectkbn)) {
				paigongdanform.setBusi("2");
			}
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	
	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		return service.getAnzhuangbiduiList((PaiGongDanForm) form, first, rows);
	}

	
	public int getResultCount(ActionForm f) throws Exception {
		return service.getAnzhuangbiduiListCount((PaiGongDanForm) f);
	}
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		
	}

}
