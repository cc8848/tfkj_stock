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

public class JiaofeiXTActionYunWei extends BusinessPaginationAction{
	//用于判断是否为初始化。
//	private Integer count = 1; 
	PaiGongDanService  service = new PaiGongDanService();
	YonghuDataService serviceData = new YonghuDataService();
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		
		request.setAttribute("xiaoquList", xiaoquList);
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		YonghuDataForm f = (YonghuDataForm) form;
		f.setHidden();
//		count = 1;
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		YonghuDataForm f = (YonghuDataForm) form;
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
		YonghuDataForm f =  (YonghuDataForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		if (f.getTingjiDate() == null || f.getTingjiDate().equals("")) {
			f.setTingjiDate(Common.getDate("yyyy-MM-dd"));
			f.setTingjiDateHidden(Common.getDate("yyyy-MM-dd"));
		}
		return serviceData.getResultYunWeiByTingji((YonghuDataForm) form, first, rows);
	}
	


	public int getResultCount(ActionForm form) throws Exception {
		YonghuDataForm f = (YonghuDataForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		if (f.getTingjiDate() == null || f.getTingjiDate().equals("")) {
			f.setTingjiDate(Common.getDate("yyyy-MM-dd"));
			f.setTingjiDateHidden(Common.getDate("yyyy-MM-dd"));
		}
		return serviceData.getResultByTingjiYunweiCount((YonghuDataForm) form);
	}
}
