/*
 * TianFang science corporation (c)2012 all rights reserved.
 * Description: XiugaiShujuAction get xiugai info.
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Li.Hai-Han(**)        Create
 */



package com.stock.yonghushuju;

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
 * XiugaiShujuAction.
 * 
 * @author Li.Hai-Han(**)
 */

public class WeixiuJiaofeiAction extends BusinessPaginationAction {

	XiugaiShujuService service = new XiugaiShujuService();
	
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	private void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);
	}
	
	/**
	 * init.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
		
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		XiugaiShujuForm f = (XiugaiShujuForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	/**
	 * get user data list.
	 * contain all combox data for init page data.
	 * 
	 * @param form
	 * @param first
	 * @param request
	 * @return DataSet<DataRow>
	 */
	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		XiugaiShujuForm f =  (XiugaiShujuForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultWeixiuJiaofei((XiugaiShujuForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		XiugaiShujuForm f = (XiugaiShujuForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultCountWeixiuJiaofei((XiugaiShujuForm) form);
	}


}
