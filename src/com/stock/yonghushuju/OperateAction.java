package com.stock.yonghushuju;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

/**
 * 密码修改和退订操作
 * @author Xinhua-Zhao
 * @date： 日期：2015-1-19 时间：下午3:46:33
 */
public class OperateAction extends BusinessPaginationAction{
	
	PaiGongDanService  service = new PaiGongDanService();
	YonghuDataService serviceData = new YonghuDataService();
	
	
	/**
	 * user data init method.
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

		return firstPage(mapping, form, request, response);
	}

	/**
	 * get user data list by query.
	 * contain all combox data for init page data.
	 * 
	 * @param form
	 * @param first
	 * @param request
	 * @return DataSet<DataRow>
	 */
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		return firstPage(mapping, form, request, response);
	}
	
	/**
	 * framework package method.
	 * 
	 * @param mapping
	 * @return ActionForward
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
		return serviceData.getResultOperate((YonghuDataForm) form, first, rows);
	}

	/**
	 * get init or query result count.
	 * 
	 * @param request
	 * @throws Exception
	 */
	public int getResultCount(ActionForm form) throws Exception {
		return serviceData.getResultCountOperate((YonghuDataForm) form);
	}
}
