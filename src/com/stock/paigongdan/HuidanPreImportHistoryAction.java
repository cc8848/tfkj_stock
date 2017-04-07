package com.stock.paigongdan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.fenPeiIp.FenguangKeService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
/** 
 * @author daizhen 
 * @version 创建时间：2016-3-2 
 * 回单预导入查询
 */
public class HuidanPreImportHistoryAction extends BusinessPaginationAction{

	PaiGongDanService  pgdservice = new PaiGongDanService();
	HuidanPreImportService  service = new HuidanPreImportService();
	FenguangKeService fgservice = new FenguangKeService();
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	
	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		PaiGongDanPreImportForm f =  (PaiGongDanPreImportForm) form;
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultHistory((PaiGongDanPreImportForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		PaiGongDanPreImportForm f =  (PaiGongDanPreImportForm) form;
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultHistoryCount((PaiGongDanPreImportForm) form);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=30;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);

		List<CommonModule> dianxintaocan = pgdservice.getDianxintaocan();
		request.setAttribute("dianxintaocan", dianxintaocan);
		
		List<CommonModule> shichangList = pgdservice.getShichangAll();
		request.setAttribute("shichangList", shichangList);
		
		List<CommonModule> shichangtvList = pgdservice.getShichangtvAll();
		request.setAttribute("shichangtvList", shichangtvList);
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=30;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	
	/*****
	 * 复制回退action
	 *****/
	public ActionForward fuzhihuitui(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		service.fuzhihuitui(fenguangform);
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "复制回退成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 内容为空时返回true
	 */
	private boolean checkEmpty(String content) {
		if(content==null||"".equals(content)||" ".equals(content)||"　".equals(content)||"0".equals(content)) {
			return true;
		}
		return false;
	}
}
