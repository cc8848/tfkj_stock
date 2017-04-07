/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: deal with excel import.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 * 2012-11-24   Zhu.Xiao-Lei          Update
 */
package com.stock.yonghushuju;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.yonghushuju.service.JiaoFeiService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.util.PropertyReader;

/**
 * deal with excel import.
 * 
 * @author Zhu.Xiao-Lei
 */
public class ImportDataAction extends BusinessAction {
    // private CommonDao dao = new CommonDao();
    List<Map<String, String>> zjlist;
    public static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
    private ImportValidator validator = new ImportValidator();
    private ImportDataService service = new ImportDataService();
	private JiaoFeiService jiaoFeiService=new JiaoFeiService();
    public static final String DOWNLOAD_DIR = PropertyReader.readProperty("BaseIp", "server");

    /**
     * user data import.
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward upload(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

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

    /**
     * 运维4权限 用户数据上传 ，返回空结果集，不予显示。
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward yunWeiUpload(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

	FormFile file = ((ImportDataForm) form).getFormFile();
	String error = validator.fileUplodateValidate(file);
	if (error != null) {
	    saveMessage(error, request);
	    return mapping.findForward(FW_INIT);
	}

	InputStream input = file.getInputStream();
	CommonMessage message = service.insert(input);
	if (saveMessage(message, request)) {
	    return mapping.findForward(FW_INIT);
	}

	return mapping.findForward(FW_INIT);
    }

    /**
     * 已维修单上传 ，返回结果，显示清单。
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward uploadWeixiu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	FormFile file = ((ImportDataForm) form).getFormFile();
	String error = validator.fileUplodateValidate(file);
	if (error != null) {
	    saveMessage(error, request);
	    return mapping.findForward(FW_SUCCESS);
	}
	InputStream input = file.getInputStream();
	CommonMessage message = service.insertOnlyWeixiu(input);
	if (saveMessage(message, request)) {

	    return mapping.findForward(FW_SUCCESS);
	}

	return mapping.findForward(FW_SUCCESS);
    }

    /**
     * 运维4权限已维修单上传 ，返回空结果集，不予显示。
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward yunWeiUploadWeixiu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

	FormFile file = ((ImportDataForm) form).getFormFile();
	String error = validator.fileUplodateValidate(file);
	if (error != null) {
	    saveMessage(error, request);
	    return mapping.findForward(FW_INIT);
	}

	InputStream input = file.getInputStream();
	CommonMessage message = service.insertOnlyWeixiu(input);
	if (saveMessage(message, request)) {
	    return mapping.findForward(FW_INIT);
	}

	return mapping.findForward(FW_INIT);
    }

    /**
     * 运维4权限已缴费单上传 ，返回空结果集，不予显示。
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward yunWeiUploadJiaoFei(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	FormFile file = ((ImportDataForm) form).getFormFile();
	String error = validator.fileUplodateValidate(file);
	if (error != null) {
	    saveMessage(error, request);
	    return mapping.findForward(FW_INIT);
	}

	InputStream input = file.getInputStream();
	CommonMessage message = service.insertOnlyXufei(input);
	if (saveMessage(message, request)) {
	    return mapping.findForward(FW_INIT);
	}

	return mapping.findForward(FW_INIT);
    }

    /**
     * 缴费单上传 ，成功后数据库插入缴费单，不予显示缴费单，显示更新后已安装记录。
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward jiaoFeiUpload(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

	FormFile file = ((ImportDataForm) form).getFormFile();
	String error = validator.fileUplodateValidate(file);
	if (error != null) {
	    saveMessage(error, request);
	    return mapping.findForward(FW_SUCCESS);
	}

	InputStream input = file.getInputStream();
	CommonMessage message = service.insertOnlyXufei(input);
	if (saveMessage(message, request)) {
	    return mapping.findForward(FW_SUCCESS);
	}

	return mapping.findForward(FW_SUCCESS);
    }

    // 缴费申请后，处理缴费 录入（续费维修管理---处理续费---录入按钮）
    public ActionForward daijiaofeiImport(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	JiaofeiDataFrom jiaofeiDataFrom = ((JiaofeiDataFrom) form);
	CommonMessage message = jiaoFeiService.approve(jiaofeiDataFrom);
	if (saveMessage(message, request)) {
	    return mapping.findForward(FW_SUCCESS);
	}
	return mapping.findForward(FW_SUCCESS);
    }

    public ActionForward daiweixiuImport(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	JiaofeiDataFrom jiaofeiDataFrom = ((JiaofeiDataFrom) form);
	CommonMessage message = service.daiweixiuApprove(jiaofeiDataFrom);
	if (saveMessage(message, request)) {
	    return mapping.findForward("success1");
	}
	return mapping.findForward("success1");
    }

    /**
     * 待修改 create by 赵兴华
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward daoxiugai(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	String tfids = request.getParameter("tfids");
	CommonMessage message = service.daiXiugai(tfids);
	if (saveMessage(message, request)) {
	    return mapping.findForward("success2");
	}
	return mapping.findForward("success2");
    }

    public ActionForward daijiaofeiDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	JiaofeiDataFrom jiaofeiDataFrom = ((JiaofeiDataFrom) form);
	CommonMessage message = service.deleteDaijiaofei(jiaofeiDataFrom);
	if (saveMessage(message, request)) {
	    return mapping.findForward(FW_SUCCESS);
	}

	return mapping.findForward(FW_SUCCESS);
    }

    public ActionForward daiweixiuDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	JiaofeiDataFrom jiaofeiDataFrom = ((JiaofeiDataFrom) form);
	CommonMessage message = service.deleteDaiweixiu(jiaofeiDataFrom);
	if (saveMessage(message, request)) {
	    return mapping.findForward("success1");
	}

	return mapping.findForward("success1");
    }
    
    
    
    /**
     * create by 赵兴华
     */
    public ActionForward operateDel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	String tfids = request.getParameter("tfids");
	CommonMessage message = service.delOperate(tfids);
	if (saveMessage(message, request)) {
	    return mapping.findForward("success2");
	}

	return mapping.findForward("success2");
    }
    
    
    
    /**
     * 上传数据对比查询已安装记录后下载excel
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward comparison(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	// String remoteAddr = request.getLocalAddr();
	FormFile file = ((ImportDataForm) form).getFormFile();
	String error = validator.fileUplodateValidate(file);
	if (error != null) {
	    saveMessage(error, request);
	    return mapping.findForward(FW_SUCCESS);
	}

	InputStream input = file.getInputStream();
	CommonMessage message = service.comparisonYianzhuang(input, DOWNLOAD_DIR);
	if (saveMessage(message, request)) {
	    return mapping.findForward(FW_SUCCESS);
	}

	return mapping.findForward(FW_SUCCESS);
    }
}
