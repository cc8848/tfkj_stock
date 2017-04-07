package com.stock.huidan;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessAction;
import com.stock.yonghushuju.ImportDataForm;
import com.stock.yonghushuju.ImportValidator;

public class ImportHuidanDataAction extends BusinessAction {
	
	private ImportValidator validator = new ImportValidator();
	private ImporHuidanDataService service= new ImporHuidanDataService(); 

	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FormFile file = ((ImportDataForm) form).getFormFile();
		String error = validator.fileUplodateValidate(file);
		CommonMessage message = null;

		if (error != null) {
			saveMessage(error, request);
			return mapping.findForward(FW_SUCCESS);
		}
		InputStream input = file.getInputStream();
		message = service.insert(input);
		if (saveMessage(message, request)) {

			return mapping.findForward(FW_SUCCESS);
		}

		return mapping.findForward(FW_SUCCESS);
	}
}
