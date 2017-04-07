package com.webService.log;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class WebServiceLogAction extends BusinessPaginationAction{

	private WebServiceService webServiceService = new WebServiceService();
	private PaiGongDanService  srv = new PaiGongDanService();
	PaiGongDanService  service2 = new PaiGongDanService();
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	    	savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	    this.rows=10;
	    WebServiceLogForm f = (WebServiceLogForm)form;
	    List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
    	f.setXiaoquList(xiaoquList);
	    savedInRequest(request);
	    return firstPage(mapping, f, request, response);
	}
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
	    	WebServiceLogForm f = (WebServiceLogForm)form;
	    	List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
	    	f.setXiaoquList(xiaoquList);
		return webServiceService.getResultWebServiceLog((WebServiceLogForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		WebServiceLogForm f = (WebServiceLogForm)form;
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return webServiceService.getResultWebServiceCount((WebServiceLogForm) form);
	}
	
	public ActionForward reSend(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	    String backMess = "1";
	    String uuid = request.getParameter("uuid");
	    Map<String, String> resultMap = webServiceService.reSend(uuid);
	    if (resultMap != null) {
		backMess = resultMap.get("backMess");
		if ("1".equals(backMess)) {
		    backMess = resultMap.get("RspDesc");
		}
	    } else {
		backMess = "数据异常无法完成重发！";
	    }
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html");
	    response.getWriter().print(backMess);
	    return mapping.findForward("null");
	}
	
}
