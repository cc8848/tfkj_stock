package com.stock.caiwuhedui.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import com.stock.caiwuhedui.service.AccountsMateService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.paigongdan.PaiGongDanService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class AccountsMateAction extends BusinessPaginationAction{

	PaiGongDanService  service = new PaiGongDanService();
	AccountsMateService serviceData = new AccountsMateService();
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		List<CommonModule> senList = serviceData.getSenListAll();
		
		request.setAttribute("xiaoquList", xiaoquList);
		request.setAttribute("statusList", statusList);
		request.setAttribute("senList", senList);
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm f = serviceData.getResultZhangmuxinxi(((ZhangMuForm)form));
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping,  form , request, response);
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		ZhangMuForm f = serviceData.getResultZhangmuxinxi(((ZhangMuForm)form));
		f.setUUIDHidden("");
		f.setZhifuleixingHidden("");
		f.setZhifuleixing("");
		savedInRequest(request);
		f.setHidden();
		
		return firstPage(mapping, form, request, response);
	}
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		ZhangMuForm f =  (ZhangMuForm) form;
		//String zhangmuUUIDHidden = f.getZhangmuUUIDHidden();
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		f.setStatusList(statusList);
		List<CommonModule> senList = serviceData.getSenListAll();
		f.setSenList(senList);
		
		makeHidden(f);
		
		f.setZhifuleixing("");
		return serviceData.getResult((ZhangMuForm) form, first, rows);
	}
	


	public int getResultCount(ActionForm form) throws Exception {
		ZhangMuForm f = (ZhangMuForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		f.setStatusList(statusList);
		List<CommonModule> senList = serviceData.getSenListAll();
		f.setSenList(senList);
		return serviceData.getResultCount((ZhangMuForm) form);
	}
	
	private void makeHidden(ZhangMuForm f) {
		String zongshoufeiHidden = f.getZongshoufeiHidden();
		String zhifuleixingHidden = f.getZhifuleixingHidden();
		String uuidHidden = f.getZhangmuUUIDHidden();
		if(zongshoufeiHidden==null){
			f.setZongshoufeiHidden("0");
		}
		if(zongshoufeiHidden != null && zhifuleixingHidden != null && uuidHidden != null)
		{
			f.setZongshoufeiHidden(zongshoufeiHidden);
			f.setZhifuleixingHidden(zhifuleixingHidden);
			f.setUUIDHidden(uuidHidden);
		}
		
	}

	
}
