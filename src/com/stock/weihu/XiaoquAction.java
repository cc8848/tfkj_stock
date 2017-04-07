package com.stock.weihu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class XiaoquAction extends BusinessPaginationAction{

	
	
	WeihuService shichangService = new WeihuService();
	
	WeihuService service = new WeihuService();
	
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=1000;
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=1000;
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		return shichangService.getResultXiaoqu((XiaoquForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return shichangService.getResultXiaoquCount((XiaoquForm) form);
	}
	
	
	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		List<CommonModule> quyulist = service.getQuYuCodeAll();
		for(int i = 0;i<quyulist.size();i++) {
			if(quyulist.get(i).getKey().equals(f.getQuyu())) {
				f.setQuyuName(quyulist.get(i).getValue());
				break;
			}
		}
		CommonMessage message = shichangService.insertXiaoqu(f);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} 
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		List<CommonModule> quyulist = service.getQuYuCodeAll();
		for(int i = 0;i<quyulist.size();i++) {
			if(quyulist.get(i).getKey().equals(f.getQuyu())) {
				f.setQuyuName(quyulist.get(i).getValue());
				break;
			}
		}
		CommonMessage message = shichangService.updateXiaoqu(f);
		if (saveMessage(message, request)) {
			return mapping.findForward("success1");
		} 
		return mapping.findForward("success1");
	}
	public ActionForward saveShichang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		service.removeXiaoQuAllKuandai(f.getUUID());
		String[] shichangs = f.getRightselect();
		if(shichangs!=null) {
			for(int i=0;i<shichangs.length;i++) {
				service.insertXiaoQuKuandai(f.getUUID(),shichangs[i]); 
			}
		}
		return mapping.findForward("success1");
	}
	public ActionForward saveDianshi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XiaoquForm f =  (XiaoquForm) form;
		service.removeXiaoQuAllDianshi(f.getUUID());
		String[] shichangs = f.getRightselect();
		if(shichangs!=null) {
			for(int i=0;i<shichangs.length;i++) {
				service.insertXiaoQuDianshi(f.getUUID(),shichangs[i]); 
			}
		}
		return mapping.findForward("success1");
	}
}
