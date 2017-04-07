/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: payment service class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 */
package com.stock.yonghushuju;

import java.util.List;

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
import com.takucin.aceeci.util.Common;

/**
 * payment service class.
 * 
 * @author Zhu.Xiao-Lei
 *
 */
public class JiaofeiXTAction extends BusinessPaginationAction{
	
	PaiGongDanService  service = new PaiGongDanService();
	YonghuDataService serviceData = new YonghuDataService();
	
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
	 * Data init.
	 * 
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
	
	/**
	 * Data query.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		YonghuDataForm f = (YonghuDataForm) form;
		f.setHidden();
		
		return firstPage(mapping, form, request, response);
	}
	
	/**
	 * package method.
	 * 
	 * @param mapping
	 */
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
		YonghuDataForm f =  (YonghuDataForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		
		if (f.getTingjiDate() == null || f.getTingjiDate().equals("")) {
			f.setTingjiDate(Common.getDate("yyyy-MM-dd"));
			f.setTingjiDateHidden(Common.getDate("yyyy-MM-dd"));
		}
		
		return serviceData.getResultByTingji((YonghuDataForm) form, first, rows);
	}

	/**
	 * Get count of userdata.
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public int getResultCount(ActionForm form) throws Exception {
		YonghuDataForm f = (YonghuDataForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		if (f.getTingjiDate() == null || f.getTingjiDate().equals("")) {
			f.setTingjiDate(Common.getDate("yyyy-MM-dd"));
			f.setTingjiDateHidden(Common.getDate("yyyy-MM-dd"));
		}
		
		return serviceData.getResultByTingjiCount((YonghuDataForm) form);
	}
}
