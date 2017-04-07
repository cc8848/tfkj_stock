package com.stock.yuyue;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.equipStock.EquipStockEntiyForm;
import com.stock.paigongdan.PaiGongDanService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;

public class YuyueEidtAction extends BusinessAction{
	
	YuyueService service = new YuyueService();
	PaiGongDanService service2 = new PaiGongDanService();
	
	/*private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList",xiaoquList);
		
	}*/
	/**
	 * 跳转到添加预约页面
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
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		List<CommonModule> quyuList = service.getQuYuCodeAll();
		
		YuyueEidtForm f = (YuyueEidtForm)form;
		f.setXiaoquList(xiaoquList);
		f.setQuyuList(quyuList);
		return mapping.findForward(FW_INIT_INSERT);
	}
	
	/**
	 * 添加设备
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result = service.insert((YuyueEidtForm)form);
		if(saveMessage(result,request)){
			List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
			List<CommonModule> quyuList = service.getQuYuCodeAll();
			YuyueEidtForm f = (YuyueEidtForm)form;
			f.setXiaoquList(xiaoquList);
			f.setQuyuList(quyuList);
			return mapping.findForward(FW_ERROR_INSERT);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 跳转到更新页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		YuyueEidtForm f = (YuyueEidtForm)form;
		DataRow dataRow = service.getYuyueByUUID(f.getUUID());
		
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		
		List<CommonModule> quyuList = service.getQuYuCodeAll();
		f.setQuyuList(quyuList);
		f.setXiaoquList(xiaoquList);
		
		f.setUUID(dataRow.getDataElement("PK_ID").getString());
		f.setRiqi(dataRow.getDataElement("riqi").getString());
		f.setShijian(dataRow.getDataElement("shijian").getString());
		f.setAzjh(dataRow.getDataElement("azjh").getString());
		f.setQjjh(dataRow.getDataElement("qjjh").getString());
		f.setXiaoqu(dataRow.getDataElement("xiaoqu").getString());
		f.setYujing(dataRow.getDataElement("yujing").getString());
		f.setAzsy(dataRow.getDataElement("azsy").getString()); //已安装数
		f.setQjsy(dataRow.getDataElement("qjsy").getString()); //已取件数
		f.setYujing(dataRow.getDataElement("yujing").getString());
		return mapping.findForward(FW_INIT_EDIT);
	}
	

	/**
	 * 更新
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String result = service.update((YuyueEidtForm)form);
		if(saveMessage(result,request)){
			YuyueEidtForm f = (YuyueEidtForm)form;
			List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
			List<CommonModule> quyuList = service.getQuYuCodeAll();
			f.setQuyuList(quyuList);
			f.setXiaoquList(xiaoquList);
			return mapping.findForward(FW_ERROR_EDIT);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 删除
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		YuyueEidtForm f = (YuyueEidtForm)form;
		CommonMessage message = checkDelet(f.getUUID());
		if(saveMessage(message, request)){
			return mapping.findForward(FW_SUCCESS);
		}else{
			service.delete(f);
		}
		
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 冻结计划--将剩余安装/取件数量置为0
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward dongjei(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String result = service.blocking((YuyueEidtForm)form);
		
		return mapping.findForward(FW_SUCCESS);
	}
	/**
	 * 校验是否可以删除
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public CommonMessage checkDelet(String UUID)throws Exception{
		DataRow daterow = service.getYuyueByUUID(UUID);
		String azsy = daterow.getDataElement("azsy").getString();//已安装户数
		String qjsy = daterow.getDataElement("qjsy").getString();
		if(!azsy.equals("0")||!qjsy.equals("0")){
			return new CommonMessage(ErrorConstant.YIPAIJIHUA);
		}else{
			return new CommonMessage("SUCCESS");
		}
	}
		
}
