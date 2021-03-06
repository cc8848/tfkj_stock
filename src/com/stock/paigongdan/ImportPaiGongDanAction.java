package com.stock.paigongdan; 

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
import com.sun.org.apache.bcel.internal.generic.NEW;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-14 上午09:44:15 
 * 类说明 
 */
public class ImportPaiGongDanAction extends BusinessAction {
	
	public static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
	private ImportValidator validator = new ImportValidator();
	
	private ImportPaiGongDanService service = new ImportPaiGongDanService();
	
	/**
	 * 派工单上传
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		FormFile file = ((ImportPGDForm) form).getFormFile();
		String date = ((ImportPGDForm) form).getDateString();
		String error = validator.fileUplodateValidate(file);
		if(error != null){
			saveMessage(error, request);
			return mapping.findForward(FW_SUCCESS);
		}
		if(date==null||date.equals("")){
			saveMessage(ErrorConstant.IMPORT_PAIGONGDATE_EMPTY, request);
			return mapping.findForward(FW_SUCCESS);
		}
		InputStream input = file.getInputStream();
		CommonMessage message = service.insert(date,input);
		if(saveMessage(message, request)){
			
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_SUCCESS);
	}
}

	

