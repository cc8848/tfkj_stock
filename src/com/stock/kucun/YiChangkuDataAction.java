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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.PropertyReader;

/**
 * user data init and query..
 * 
 * @author Zhu.Xiao-Lei
 *
 */
public class YiChangkuDataAction extends BusinessPaginationAction{
	
	KucunDataService  kcDataService = new KucunDataService();
	KucunService  service = new KucunService();
	PaiGongDanService  servicedata = new PaiGongDanService();
	public static final String DOWNLOAD_DIR = PropertyReader.readProperty("BaseIp","server");
	
	
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
		List<CommonModule> statusList = kcDataService.getStatus4CodeAll();
		f.setStatusList(statusList);
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		f.setXiaoquList(xiaoquList);
	
		return service.getResultyichangku((KuncunForm) form, first, rows);
		//return null;
	}

	public int getResultCount(ActionForm form) throws Exception {
		KuncunForm f =  (KuncunForm) form;
		List<CommonModule> statusList = kcDataService.getStatus4CodeAll();
		f.setStatusList(statusList);
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultYiChangKuCount(f);
	}
	
	public ActionForward kucunToyichangku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KuncunForm f =  (KuncunForm) form;
		String zhuangtaiHidden = f.getZhuangtaiHidden();
		if (zhuangtaiHidden.equals("2")) {
			CommonMessage message = service.kucunToyichangku(f);
			if (saveMessage(message, request)) {
				return mapping.findForward(FW_SUCCESS);
			} 
			return mapping.findForward(FW_SUCCESS);
		} else {
			CommonMessage message = service.xiaoquToyichangku(f);
			if (saveMessage(message, request)) {
				return mapping.findForward("success1");
			} 
			return mapping.findForward("success1");
		}
		
	}
	
	public ActionForward shebeiEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		KuncunForm f =  (KuncunForm) form;
		//service.shebeiEdit(f);
		String UUID = f.getUUID();
		f.setUUIDHidden(UUID);
		f.setZhuangtaiHidden(f.getZhuangtai());
		service.getAnZhuangKuform_ByID( UUID , f);
		List<CommonModule> statusList = kcDataService.getStatus23CodeAll();
		f.setStatusList(statusList);
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> yunweiList = kcDataService.getlingqurenID();
		f.setUserNameList(yunweiList);
		return mapping.findForward(FW_INIT_EDIT);
	}
	
}
