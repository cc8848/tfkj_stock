package com.stock.equipStock;

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
import com.stock.paigongdan.ImportPGDForm;
import com.stock.paigongdan.ImportValidator;

public class ImportEquipAction  extends BusinessAction{

	public static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
	private ImportValidator validator = new ImportValidator();
	private ImportEquipService service = new ImportEquipService();
	
	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		FormFile file = ((ImportEquipForm) form).getFormFile();
		String error = validator.fileUplodateValidate(file);
		if(error != null){
			saveMessage(error, request);
			return mapping.findForward(FW_SUCCESS);
		}
		InputStream input = file.getInputStream();
		CommonMessage message = service.insert(input);
		if(saveMessage(message, request)){
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_SUCCESS);
	}
}
