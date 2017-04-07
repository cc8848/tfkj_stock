	package com.stock.userInfomation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.frame.sql.DataRow;

public class UserInfoEditAction extends BusinessAction{

	ImportUserService service = new ImportUserService();
	
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
		UserInfoForm uiForm = (UserInfoForm) form;
		DataRow dataRow = service.getUserinfoByUUID(uiForm.getUUID());
		
		
		uiForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		uiForm.setXiaoquname(dataRow.getDataElement("xiaoquname").getString());
		uiForm.setYonghu(dataRow.getDataElement("yonghu").getString());
		uiForm.setZhenjianno(dataRow.getDataElement("zhenjianno").getString());
		uiForm.setShoujuno(dataRow.getDataElement("shoujuno").getString());
		uiForm.setFenguang(dataRow.getDataElement("fenguang").getString());
		uiForm.setOnuzcwz(dataRow.getDataElement("onuzcwz").getString());
		uiForm.setDizi(dataRow.getDataElement("dizi").getString());
		uiForm.setKaijishijian(dataRow.getDataElement("kaijishijian").getString());
		uiForm.setTijishijian(dataRow.getDataElement("tijishijian").getString());
		uiForm.setDaikuan(dataRow.getDataElement("daikuan").getString());
		uiForm.setTv(dataRow.getDataElement("tv").getString());
		uiForm.setTel(dataRow.getDataElement("tel").getString());
		uiForm.setUsername(dataRow.getDataElement("username").getString());
		uiForm.setPasswords(dataRow.getDataElement("passwords").getString());
		uiForm.setGuhuahaoma(dataRow.getDataElement("guhuahaoma").getString());
		uiForm.setUsertel(dataRow.getDataElement("usertel").getString());
		uiForm.setJiguiweizhi(dataRow.getDataElement("jiguiweizhi").getString());
		uiForm.setOnumac(dataRow.getDataElement("onumac").getString());
		uiForm.setStbmac(dataRow.getDataElement("stbmac").getString());
		uiForm.setTvip(dataRow.getDataElement("tvip").getString());
		uiForm.setNetip(dataRow.getDataElement("netip").getString());
		uiForm.setTelip(dataRow.getDataElement("telip").getString());
		uiForm.setTelvaln(dataRow.getDataElement("telvaln").getString());
		uiForm.setNetvaln(dataRow.getDataElement("netvaln").getString());
		uiForm.setTvvaln(dataRow.getDataElement("tvvaln").getString());
		uiForm.setQtvaln(dataRow.getDataElement("qtvaln").getString());
		uiForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
		
		
		return mapping.findForward(FW_INIT_EDIT);
		
	}
	
	/**
	 * 查看详情
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserInfoForm uiForm = (UserInfoForm) form;
		DataRow dataRow = service.getUserinfoByUUID(uiForm.getUUID());
		
		
		uiForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		uiForm.setXiaoquname(dataRow.getDataElement("xiaoquname").getString());
		uiForm.setYonghu(dataRow.getDataElement("yonghu").getString());
		uiForm.setZhenjianno(dataRow.getDataElement("zhenjianno").getString());
		uiForm.setShoujuno(dataRow.getDataElement("shoujuno").getString());
		uiForm.setFenguang(dataRow.getDataElement("fenguang").getString());
		uiForm.setOnuzcwz(dataRow.getDataElement("onuzcwz").getString());
		uiForm.setDizi(dataRow.getDataElement("dizi").getString());
		uiForm.setKaijishijian(dataRow.getDataElement("kaijishijian").getString());
		uiForm.setTijishijian(dataRow.getDataElement("tijishijian").getString());
		uiForm.setDaikuan(dataRow.getDataElement("daikuan").getString());
		uiForm.setTv(dataRow.getDataElement("tv").getString());
		uiForm.setTel(dataRow.getDataElement("tel").getString());
		uiForm.setUsername(dataRow.getDataElement("username").getString());
		uiForm.setPasswords(dataRow.getDataElement("passwords").getString());
		uiForm.setGuhuahaoma(dataRow.getDataElement("guhuahaoma").getString());
		uiForm.setUsertel(dataRow.getDataElement("usertel").getString());
		uiForm.setJiguiweizhi(dataRow.getDataElement("jiguiweizhi").getString());
		uiForm.setOnumac(dataRow.getDataElement("onumac").getString());
		uiForm.setStbmac(dataRow.getDataElement("stbmac").getString());
		uiForm.setTvip(dataRow.getDataElement("tvip").getString());
		uiForm.setNetip(dataRow.getDataElement("netip").getString());
		uiForm.setTelip(dataRow.getDataElement("telip").getString());
		uiForm.setTelvaln(dataRow.getDataElement("telvaln").getString());
		uiForm.setNetvaln(dataRow.getDataElement("netvaln").getString());
		uiForm.setTvvaln(dataRow.getDataElement("tvvaln").getString());
		uiForm.setQtvaln(dataRow.getDataElement("qtvaln").getString());
		uiForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
		
		
		return mapping.findForward("showInfo");
		
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

		String result = service.update((UserInfoForm)form);
		if(saveMessage(result,request)){
			return mapping.findForward(FW_ERROR_EDIT);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	
}
