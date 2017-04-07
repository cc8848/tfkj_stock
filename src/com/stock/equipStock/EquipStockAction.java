package com.stock.equipStock; 

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
 * @author wangdl 
 * @version 创建时间：2012-6-13 上午08:40:01 
 * 类说明 
 */
public class EquipStockAction extends BusinessPaginationAction{
	EquipStockService service = new EquipStockService();
	
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> kucunlist = service.getKucunAll();
		request.setAttribute("kucunlist",kucunlist);
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		savedInRequest(request);
		EquipStockForm f = (EquipStockForm) form;
		f.setStateHidden("1");
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		savedInRequest(request);
		EquipStockForm f = (EquipStockForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		
		//request.setAttribute("kucunlist",kucunlist);
		return service.getResult((EquipStockForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return service.getResultCount((EquipStockForm) form);
	}
	
	
}

