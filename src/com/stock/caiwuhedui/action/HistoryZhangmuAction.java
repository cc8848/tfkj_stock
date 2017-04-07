package com.stock.caiwuhedui.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import com.stock.caiwuhedui.service.ZhangMuService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class HistoryZhangmuAction extends BusinessPaginationAction{

	ZhangMuService serviceData = new ZhangMuService();
	YonghuDataService serviceData1 = new YonghuDataService();
	private String zhuangtai;
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> yinhangList = serviceData1.getYinhangAll();
		request.setAttribute("xiaoquList", yinhangList);
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		zhuangtai = request.getParameter("zhuangtai");
	
		this.rows=500;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		zhuangtai = request.getParameter("zhuangtai");
		this.rows=500;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		ZhangMuForm dataForm = (ZhangMuForm) form;
		String uuidHidden = dataForm.getUUIDHidden();
		//System.out.println(uuidHidden);
		/*String[] uuids = dataForm.getUUIDS();
		for (int i =0; i < uuids.length; i++) {
			System.out.println(uuids[i]);
		}*/
		dataForm.setXiaoquList(serviceData1.getYinhangAll());
		dataForm.setUUIDHidden(uuidHidden);
		return serviceData.getResultHistoryZhangmu( dataForm , first, rows , zhuangtai);
	}
	public int getResultCount(ActionForm form) throws Exception {
		return serviceData.getResultCount((ZhangMuForm) form , zhuangtai);
	}
	public ActionForward backAccount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm dataForm = (ZhangMuForm) form;
		//DataRow dataRow = serviceData.getZhangmuByUUID(dataForm.getZmUUID());
		//String chazhi = dataRow.getDataElement("chazhi").getString();
		String value = serviceData.updateZhangmuState(dataForm.getUUIDS(),"2");
		if (!value.equals("success")) 
		{
			CommonMessage message = new CommonMessage(ErrorConstant.SUBMIT_PIPEI_UPDATE_ERROR);
			saveMessage(message, request);
		}
		this.rows=500;
		return firstPage(mapping,  dataForm , request, response);
	}
	
	public ActionForward subAccount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm dataForm = (ZhangMuForm) form;
		serviceData.updateZhangmuState(dataForm.getZmUUID(),"3");
		this.rows=500;
		savedInRequest(request);
		return firstPage(mapping,  dataForm , request, response);
	}
	public void saveMessageNoCheck(CommonMessage message,HttpServletRequest request){
		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(message.getMessageCode(),message.getParams()));
		saveMessages(request, messages);
	}
	
	public boolean saveMessage(CommonMessage message,HttpServletRequest request){
		if(message.getMessageCode() != Constant.SUCCESS){
			saveMessageNoCheck(message,request);
			return true;
		}
		return false;
	}
}
