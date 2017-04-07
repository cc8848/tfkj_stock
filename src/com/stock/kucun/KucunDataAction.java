/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data init and query.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2013-03-18   Li.Hai-Han            Create
 */
package com.stock.kucun;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
/**
 * user data init and query..
 * 
 * @author Zhu.Xiao-Lei
 *
 */
public class KucunDataAction extends BusinessPaginationAction{
	
	KucunDataService  kcDataService = new KucunDataService();
	KucunService  service = new KucunService();
	PaiGongDanService  servicedata = new PaiGongDanService();
	
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=500;
		savedInRequest(request);
		
		return firstPage(mapping, form, request, response);
	}

	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=500;
		savedInRequest(request);
		//f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}
	
	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		KuncunForm f =  (KuncunForm) form;
		List<CommonModule> statusList = kcDataService.getStatusCodeAll("1");
		f.setStatusList(statusList);
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResult((KuncunForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		KuncunForm f =  (KuncunForm) form;
		List<CommonModule> statusList = kcDataService.getStatusCodeAll("1");
		f.setStatusList(statusList);
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		f.setXiaoquList(xiaoquList);
		
		return service.getResultCount(f);
	}
	

	
	
	public ActionForward shebeitoxiaoquku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KuncunForm f =  (KuncunForm) form;
		CommonMessage message = service.shebeiToXiaoqu(f);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} 
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward shebeiEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		KuncunForm f =  (KuncunForm) form;
		service.shebeiEdit(f);
		String UUID = f.getUUID();
		f.setUUIDHidden(UUID);
		service.getKucunform_ByID(UUID, f);
		
		List<CommonModule> yunweiList = kcDataService.getYunweiAll();
		f.setUserNameList(yunweiList);
		f.setZhuangtaiHidden(f.getZhuangtai());
		return mapping.findForward(FW_INIT_EDIT);
	}
	public ActionForward deleteShebeiData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		KuncunForm f =  (KuncunForm) form;
		
		
		CommonMessage message = service.deleteShebeiData(f);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} 
	
		return mapping.findForward("success");
	}
	
}
