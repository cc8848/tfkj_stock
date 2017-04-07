package com.stock.fenPeiIp;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.yonghushuju.ImportDataForm;
import com.stock.yonghushuju.ImportValidator;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;

public class FenGuangGuiZeEditAction  extends BusinessAction{
	
	FenguangService  service = new FenguangService();
	PaiGongDanService  srv = new PaiGongDanService();
	private ImportValidator validator = new ImportValidator();
	/*****
	 * 一览界面点击删除信息按钮执行action
	 *****/
	public ActionForward delFenguang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FenPeiFenGuangGuiZeForm fenguangform = (FenPeiFenGuangGuiZeForm) form;
		String uuid = fenguangform.getUUID();
		service.updateJti(uuid, "9");
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "信息删除成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	public ActionForward editFenguang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FenPeiFenGuangGuiZeForm fenguangform = (FenPeiFenGuangGuiZeForm) form;
		String uuid = fenguangform.getUUID();
		DataRow photouploader = service.getFenguang(uuid);
		fenguangform.setUUID(photouploader.getDataElement("PK_ID").getString());
		fenguangform.setXiaoqu(photouploader.getDataElement("xiaoqu").getString());
		fenguangform.setLouhao(photouploader.getDataElement("louhao").getString());
		fenguangform.setLoumen(photouploader.getDataElement("loumen").getString());
		fenguangform.setLouceng(photouploader.getDataElement("louceng").getString());
		fenguangform.setDanyuan(photouploader.getDataElement("danyuan").getString());
		fenguangform.setFenguangID(photouploader.getDataElement("fenguangID").getString());
		fenguangform.setBeizhu(photouploader.getDataElement("beizhu").getString());
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		fenguangform.setXiaoquList(xiaoquList);
		return mapping.findForward(FW_INIT_INSERT);
	}
	public ActionForward updateFenguangGuize(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FenPeiFenGuangGuiZeForm fenguangform = (FenPeiFenGuangGuiZeForm) form;
		String uuid = fenguangform.getUUID();
		service.updateGuize(uuid,fenguangform);
		return mapping.findForward(FW_SUCCESS);
	}
	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FormFile file = ((FenPeiFenGuangGuiZeForm) form).getFormFile();
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
}
