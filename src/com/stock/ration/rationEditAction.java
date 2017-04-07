package com.stock.ration; 

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
 * 设备
 */
public class rationEditAction extends BusinessPaginationAction{
	rationEquipStockService service = new rationEquipStockService();
	
	
	public ActionForward initEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows = 100;
		rationSecondForm f = (rationSecondForm) form;
		System.out.println(f.getPgdUUID());
		DataRow data = service.getPGDByUUID(f.getPgdUUID());
		f.setChukuplaceHidden(data.getDataElement("xiaoquname").getString());
		f.setChukuplace(data.getDataElement("xiaoquname").getString());
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		rationSecondForm f = (rationSecondForm) form;
		f.setHidden();
		this.rows = 100;
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT_EDIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		return service.getResult((rationSecondForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return service.getResultCount((rationSecondForm) form);
	}
}

