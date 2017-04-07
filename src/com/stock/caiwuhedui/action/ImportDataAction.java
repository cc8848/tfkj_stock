/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: deal with excel import.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 * 2012-11-24   Zhu.Xiao-Lei          Update
 */
package com.stock.caiwuhedui.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import com.stock.caiwuhedui.service.ReportExportService;
import com.stock.caiwuhedui.service.ZhangMuService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessAction;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.util.PropertyReader;


/** 
 * deal with excel import.
 * 
 * @author Zhu.Xiao-Lei 
 */
public class ImportDataAction extends BusinessAction {
	//private CommonDao dao = new CommonDao();
	YonghuDataService serviceData = new YonghuDataService();
	/**
	 * user data import.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initInsert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm f = (ZhangMuForm)form;
		List<CommonModule> yinhangList = serviceData.getYinhangAll();
		f.setXiaoquList(yinhangList);
		return mapping.findForward(FW_INIT_INSERT);
	}
	
	public ActionForward insertZhangmu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuService serviceData = new ZhangMuService();
		serviceData.insertZhangmu((ZhangMuForm)form);
		return mapping.findForward(FW_SUCCESS);
	
	}
	/**
	 * 下载银行日记账
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward downYHRiJiZhang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path ="http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath();

		ReportExportService serviceData = new ReportExportService();
		CommonMessage message = serviceData.downYHRiJiZhang((ZhangMuForm)form,path);
	
		if (saveMessage(message, request)) {
			return mapping.findForward("success1");
		}
		
		return mapping.findForward("success1");
	
	}
	/**
	 * 汇总统计下载
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward downHuiZongTongJi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path ="http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath();

		ReportExportService serviceData = new ReportExportService();
		CommonMessage message = serviceData.downHuiZongTongji((ZhangMuForm)form,path);
	
		if (saveMessage(message, request)) {
			return mapping.findForward("success1");
		}
		
		return mapping.findForward("success1");
	
	}
	/**
	 * 存款明细下载
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward downCunKuanMingXi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path ="http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath();

		ReportExportService serviceData = new ReportExportService();
		CommonMessage message = serviceData.downCunKuanMingXi((ZhangMuForm)form,path);
	
		if (saveMessage(message, request)) {
			return mapping.findForward("success1");
		}
		
		return mapping.findForward("success1");
	
	}
	/**
	 * 电信代收费下载
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward downDianXinShouFei(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path ="http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath();

		ReportExportService serviceData = new ReportExportService();
		CommonMessage message = serviceData.downDianXinShouKuan((ZhangMuForm)form,path);
		if (saveMessage(message, request)) {
			return mapping.findForward("success1");
		}
		return mapping.findForward("success1");
	}
}

	

