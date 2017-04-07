package com.stock.chukuqueren;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 上午08:40:01 
 * 类说明 
 */
public class EquipStockChuKUAction extends BusinessPaginationAction{
	EquipStockChuKuService service = new EquipStockChuKuService();
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EquipStockChuKuForm f = (EquipStockChuKuForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		return service.getResult((EquipStockChuKuForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return service.getResultCount((EquipStockChuKuForm) form);
	}
}

