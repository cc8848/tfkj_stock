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
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class FinancingCheckAction extends BusinessPaginationAction{

	ZhangMuService serviceData = new ZhangMuService();
	private String zhuangtai;
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		zhuangtai = request.getParameter("zhuangtai");
		ZhangMuForm f =  (ZhangMuForm) form;
//		f.setKaijie("1000-10-1");
		savedInRequest(request);
		this.rows=100;
		return firstPage(mapping, form, request, response);
	}
	
	private void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> senList = serviceData.getSenListAll2();
		
		request.setAttribute("senList", senList);
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		zhuangtai = request.getParameter("zhuangtai");
		savedInRequest(request);
		ZhangMuForm f =  (ZhangMuForm) form;



		request.getSession().setAttribute("heduiForm",form);
		this.rows=100;
		return firstPage(mapping, form, request, response);
	}
	public ActionForward reback(ActionMapping mapping, ActionForm form,
							   HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		zhuangtai = request.getParameter("zhuangtai");
		savedInRequest(request);

		//如果缓存中有之前的查询条件，则查询出来
		if(request.getSession().getAttribute("heduiForm")!=null){

			ZhangMuForm f=(ZhangMuForm) request.getSession().getAttribute("heduiForm");
			((ZhangMuForm)form).setSenList(f.getSenList());
			((ZhangMuForm)form).setChazhi(f.getChazhi());
			((ZhangMuForm)form).setKaijie(f.getKaijie());
			((ZhangMuForm)form).setTingjie(f.getTingjie());
			((ZhangMuForm)form).setSen1(f.getSen1());
			((ZhangMuForm)form).setSenValue1(f.getSenValue1());

		}
		this.rows=100;
		return firstPage(mapping, form, request, response);
	}
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		ZhangMuForm f =  (ZhangMuForm) form;
		List<CommonModule> senList = serviceData.getSenListAll2();
		f.setSenList(senList);
		return serviceData.getResult((ZhangMuForm) form, first, rows , zhuangtai);
	}
	public int getResultCount(ActionForm form) throws Exception {
		ZhangMuForm f =  (ZhangMuForm) form;
		List<CommonModule> senList = serviceData.getSenListAll2();
		f.setSenList(senList);
		return serviceData.getResultCount((ZhangMuForm) form , zhuangtai);
	}

	public ActionForward backAccount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm dataForm = (ZhangMuForm) form;
		String value = serviceData.updateZhangmuState(dataForm.getZmUUID(),"0");
		if (!value.equals("success")) {
			CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "回退失败！");
			saveMessage(message, request);
		}
		this.rows=100;
		return firstPage(mapping,  dataForm , request, response);
	}
	public ActionForward subAccount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm dataForm = (ZhangMuForm) form;
		String[] uuids = dataForm.getZmUUIDS();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = serviceData.getZhangmuByUUID(uuids[i]);
			String chazhi1 = dataRow.getDataElement("chazhi1").getString();
			if (chazhi1.equals("0") ) {
				String value = serviceData.updateZhangmuState(uuids[i],"2");
				if (!value.equals("success")) {
					//已核对的账目提交失败，请核查后进行提交。
					CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "已核对的账目提交失败，请核查后进行提交！");
					saveMessage(message, request);
					this.rows=100;
					return firstPage(mapping,  dataForm , request, response);
				}
			} else {
				//提交的待核对的账目差值不为0，请验证后重新提交！
				CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "总金额与已核对的差值不为0，请验证后重新提交！");
				saveMessage(message, request);
				this.rows=100;
				return firstPage(mapping,  dataForm , request, response);
			}
		}
		this.rows=100;
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
