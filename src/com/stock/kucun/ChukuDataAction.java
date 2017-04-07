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

import java.net.URLDecoder;
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
import com.takucin.aceeci.util.PropertyReader;

/**
 * user data init and query..
 * 
 * @author Zhu.Xiao-Lei
 *
 */
public class ChukuDataAction extends BusinessPaginationAction{
	
	KucunDataService  kcDataService = new KucunDataService();
	KucunService  service = new KucunService();
	PaiGongDanService  servicedata = new PaiGongDanService();
	boolean selectkbn = false;
	public static final String DOWNLOAD_DIR = PropertyReader.readProperty("BaseIp","server");
	
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=500;
		savedInRequest(request);
		selectkbn = false;
		if("1".equals(request.getParameter("selectkbn"))) {
			selectkbn = true;
			String selectxiaoqu = request.getParameter("selectxiaoqu");
			selectxiaoqu = URLDecoder.decode(selectxiaoqu, "utf-8");
			KuncunForm f =  (KuncunForm) form;
			String quyuCode = kcDataService.getQuyuByXiaoqu(selectxiaoqu);
			f.setQuyuCode(quyuCode);
		}
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
		if(selectkbn) {
			return mapping.findForward("success4");
		}
		return mapping.findForward(FW_INIT);
	}
	
	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		KuncunForm f =  (KuncunForm) form;
		List<CommonModule> statusList = kcDataService.getStatus2CodeAll();
		f.setStatusList(statusList);
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		f.setXiaoquList(xiaoquList);
	
		return service.getResultchuku((KuncunForm) form, first, rows);
		//return null;
	}

	public int getResultCount(ActionForm form) throws Exception {
		KuncunForm f =  (KuncunForm) form;
		List<CommonModule> statusList = kcDataService.getStatus2CodeAll();
		f.setStatusList(statusList);
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultchukuCount(f);
	}
	
	public ActionForward zhuangTaiChange(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KuncunForm f =  (KuncunForm) form;
		CommonMessage message;
		String zhuangtai = f.getZhuangtaiHidden();
		if (zhuangtai.equals("1")) {
			message = service.zhuangTaiChange(f);
			if (saveMessage(message, request)) {
				return mapping.findForward("success1");
			} 
			return mapping.findForward("success1");
		} else if(zhuangtai.equals("2")) {
			 message = service.zhuangTaiChangeByPId(f);
			 if (saveMessage(message, request)) {
					return mapping.findForward("success2");
				} 
			return mapping.findForward("success2");
		} else {
			message = service.zhuangTaiChangeByPId(f);
			if (saveMessage(message, request)) {
				return mapping.findForward("success3");
			} 
			return mapping.findForward("success3");
		}
	}
	
	public ActionForward shebeixinxiOut(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ImportShebeiDataService service = new ImportShebeiDataService();
		KuncunForm f =  (KuncunForm) form;
		CommonMessage message = service.shebeixinxiOut(f, DOWNLOAD_DIR);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} 
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward shebeiEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KuncunForm f = (KuncunForm) form;
		KucunService  service = new KucunService();
		service.getKucunform_ByXiaoQuKuID(f);
		List<CommonModule> statusList = kcDataService.getStatus2CodeAll();
		f.setStatusList(statusList);
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> yunweiList = kcDataService.getlingqurenID();
		f.setUserNameList(yunweiList);
		return mapping.findForward(FW_INIT_EDIT);
	}
	
	public ActionForward xiaoqukutoxiaoquku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KuncunForm f =  (KuncunForm) form;
		CommonMessage message = service.xiaoqukutoxiaoquku(f);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} 
		return mapping.findForward(FW_SUCCESS);
	}
	public ActionForward yichangkutoxiaoquku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KuncunForm f =  (KuncunForm) form;
		CommonMessage message = service.yichangkutoxiaoquku(f);
		if (saveMessage(message, request)) {
			return mapping.findForward("success3");
		} 
		return mapping.findForward("success3");
	}
	public ActionForward backtodept(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	    String uuid = request.getParameter("uuid");
	    String uuid2 = request.getParameter("uuid2");
	    if(!"".equals(uuid)) {
	    	service.zhuangTaiChange(uuid,"2");
	    }
	    if(!"".equals(uuid2)) {
	    	service.zhuangTaiChange(uuid2,"2");
	    }
//	    if (resultMap != null) {
//		backMess = resultMap.get("backMess");
//		if ("1".equals(backMess)) {
//		    backMess = resultMap.get("RspDesc");
//		}
//	    } else {
//		backMess = "数据异常无法完成重发！";
//	    }
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html");
	    response.getWriter().print("0");
	    return mapping.findForward("null");
	}
}
