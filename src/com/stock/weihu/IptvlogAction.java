package com.stock.weihu;

import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.task.NFDFlightDataTimerTask;
import com.stock.tongji.TongjiForm;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class IptvlogAction extends BusinessPaginationAction{

	
	
	WeihuService iptvlogService = new WeihuService();
	
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return firstPage(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IptvlogEidtForm f = (IptvlogEidtForm) form;
		f.setHidden();
		return firstPage(mapping, form, request, response);
	}
	
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		return iptvlogService.getResultIptvlog((IptvlogEidtForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		return iptvlogService.getResultIptvlogCount((IptvlogEidtForm) form);
	}
	
	public ActionForward ipStop(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Timer timer = new Timer();
		NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();
		// 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timer.schedule(task, 0);
		
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward insertIptvlog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IptvlogEidtForm f =  (IptvlogEidtForm) form;
		CommonMessage message = iptvlogService.insertIptvlog(f);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} 
		return mapping.findForward(FW_SUCCESS);
	}
}
