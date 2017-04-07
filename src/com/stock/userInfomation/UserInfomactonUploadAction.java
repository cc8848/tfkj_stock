package com.stock.userInfomation;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.department.DepartmentService;
import com.hrbank.business.frame.BusinessAction;

public class UserInfomactonUploadAction extends BusinessAction {

	public static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
	
	private ImportUserService service = new ImportUserService();
	private ImportValidator validator = new ImportValidator();
	
	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		FormFile file = ((UserInfomactonForm) form).getFormFile();
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
