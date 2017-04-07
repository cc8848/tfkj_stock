package com.stock.userInfomation;

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

public class UserInfomactonAction extends BusinessPaginationAction{

	UserInfomactonService  service = new UserInfomactonService();
	PaiGongDanService  pgdservice = new PaiGongDanService();
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
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
		UserInfomactonForm f = (UserInfomactonForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		UserInfomactonForm f = (UserInfomactonForm) form;
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResult((UserInfomactonForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return service.getResultCount((UserInfomactonForm) form);
	}
}
