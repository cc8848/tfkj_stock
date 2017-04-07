/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data init and query.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2015-12-15   DaiZhen            Create
 */
package com.stock.huidan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class PhotoUploadDataAction extends BusinessPaginationAction{

	PhotoService  service = new PhotoService();
	PaiGongDanService  srv = new PaiGongDanService();
	YonghuDataService serviceData = new YonghuDataService();
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		
	}
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=10;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=10;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		PhotoUploadForm  f =  (PhotoUploadForm ) form;
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		f.setGamenKbn("UPLOAD");
		return service.getPhotoUploadList(f, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		PhotoUploadForm  f =  (PhotoUploadForm ) form;
		return service.getPhotoUploadListCount(f);
	}

}
