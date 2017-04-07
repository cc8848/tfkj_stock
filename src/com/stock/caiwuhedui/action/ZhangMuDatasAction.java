package com.stock.caiwuhedui.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import com.stock.caiwuhedui.service.AccountsMateService;
import com.stock.caiwuhedui.service.ZhangMuEditService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.paigongdan.PaiGongDanService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class ZhangMuDatasAction extends BusinessPaginationAction{

	PaiGongDanService  service = new PaiGongDanService();
	AccountsMateService serviceData = new AccountsMateService();
	ZhangMuEditService serviceEdit = new ZhangMuEditService();
	
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
		this.rows=100;
		savedInRequest(request);
		ZhangMuForm f = (ZhangMuForm) form;
		/*String[] uuids = f.getUUIDS();
		
		 * 将获取的UUID数组转换成一个字符串，放回给页面的隐藏域中，查询时候使用。
		 * 
		String str = "";
		for(int i = 0 ; i < uuids.length ; i++){
			str += "," + uuids[i] ;
		}
		str = str.replaceFirst("," , "");*/
		String uuidHidden = f.getUUIDHidden();
		System.out.println(uuidHidden);
		f.setUUIDSHidden(uuidHidden);
	
		return firstPage(mapping,  form , request, response);
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		ZhangMuForm f = (ZhangMuForm) form;
		savedInRequest(request);
		f.setHidden();
		String uuidsHidden = f.getUUIDSHidden();
		f.setUUIDSHidden(uuidsHidden);
		return firstPage(mapping, form, request, response);
	}
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		ZhangMuForm f = (ZhangMuForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		f.setStatusList(statusList);
		List<CommonModule> senList = serviceData.getSenListAll();
		f.setSenList(senList);
		f.setHidden();
		return serviceData.getResultZhangMuDatas((ZhangMuForm) form, first, rows);
	}
	
	public int getResultCount(ActionForm form) throws Exception {
		ZhangMuForm f = (ZhangMuForm) form;
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		f.setStatusList(statusList);
		List<CommonModule> senList = serviceData.getSenListAll();
		f.setSenList(senList);
		f.setHidden();
		return serviceData.getResultCountZhangMuDatas((ZhangMuForm) form);
	}
	
}
