/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data init and query.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2015-12-15   DaiZhen            Create
 */
package com.stock.fenPeiIp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class KeFenPeiFenGuangDataAction extends BusinessPaginationAction{

	FenguangKeService  service = new FenguangKeService();
	PaiGongDanService  srv = new PaiGongDanService();
	YonghuDataService serviceData = new YonghuDataService();
	String mask = null;
	private void savedInRequest(HttpServletRequest request)throws Exception{
		
	}
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		KeFenPeiFenGuangForm  f =  (KeFenPeiFenGuangForm ) form;
		f.setUUID("0");
		f.setFenguang("");
		f.setRemark("");
		f.setKuang("");
		f.setFenguangID("");
		mask = request.getParameter("mask");
		f.setMask(mask);
		return firstPage(mapping, form, request, response);
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		KeFenPeiFenGuangForm  f =  (KeFenPeiFenGuangForm ) form;
		return service.getFenguangKeList(f, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		KeFenPeiFenGuangForm  f =  (KeFenPeiFenGuangForm ) form;
		return service.getFenguangKeListCount(f);
	}

}
