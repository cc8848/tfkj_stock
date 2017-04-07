package com.stock.fenPeiIp;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.yonghushuju.ImportValidator;
import com.takucin.aceeci.frame.sql.DataRow;

public class KeFenPeiFenGuangEditAction  extends BusinessAction{
	
	FenguangKeService  service = new FenguangKeService();
	PaiGongDanService  srv = new PaiGongDanService();
	private ImportValidator validator = new ImportValidator();
	/*****
	 * 一览界面点击删除信息按钮执行action
	 *****/
	public ActionForward delFenguang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KeFenPeiFenGuangForm fenguangform = (KeFenPeiFenGuangForm) form;
		String uuid = fenguangform.getUUID();
		service.updateJti(uuid, "9",request);
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "信息删除成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	public ActionForward editFenguang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KeFenPeiFenGuangForm fenguangform = (KeFenPeiFenGuangForm) form;
		String uuid = fenguangform.getUUID();
		DataRow photouploader = service.getFenguang(uuid);
		fenguangform.setUUID(photouploader.getDataElement("PK_ID").getString());		
		fenguangform.setFenguangID(photouploader.getDataElement("fenguangID").getString());
		fenguangform.setKuang(photouploader.getDataElement("kuang").getString());
		fenguangform.setFenguang(photouploader.getDataElement("fenguang").getString());
		fenguangform.setRemark(photouploader.getDataElement("remark").getString());
		return mapping.findForward(FW_INIT_INSERT);
	}
	public ActionForward updateFenguangGuize(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KeFenPeiFenGuangForm fenguangform = (KeFenPeiFenGuangForm) form;
		String uuid = fenguangform.getUUID();
		service.updateGuize(uuid,fenguangform,request);
		return mapping.findForward(FW_SUCCESS);
	}
	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FormFile file = ((KeFenPeiFenGuangForm) form).getFormFile();
		String error = validator.fileUplodateValidate(file);
		CommonMessage message = null;

		if (error != null) {
			saveMessage(error, request);
			return mapping.findForward(FW_SUCCESS);
		}
		InputStream input = file.getInputStream();
		message = service.importGuize(input);
		if (saveMessage(message, request)) {

			return mapping.findForward(FW_SUCCESS);
		}

		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * 一览界面点击手动分配分光按钮执行action
	 *****/
	public ActionForward handfenguang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KeFenPeiFenGuangForm fenguangform = (KeFenPeiFenGuangForm) form;
		String uuid = fenguangform.getUUID();
		service.updateMask(uuid, request,"1");
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "手动分配成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * 一览界面点击分光回收使用按钮执行action
	 *****/
	public ActionForward recyclefenguang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KeFenPeiFenGuangForm fenguangform = (KeFenPeiFenGuangForm) form;
		String[] uuids = fenguangform.getUUIDS();
		for(int i=0;i<uuids.length;i++) {
			service.updateMask(uuids[i],request, "0");
		}
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "分光回收成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
}
