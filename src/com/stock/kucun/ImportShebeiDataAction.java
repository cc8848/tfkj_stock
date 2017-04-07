/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: deal with excel import and ...
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2013-03-21   Li.Hai-Han            Create
 */
package com.stock.kucun; 

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.util.PropertyReader;


/** 
 * deal with excel import.
 * 
 * @author Li.Hai-Han 
 */
public class ImportShebeiDataAction extends BusinessAction {
	//private CommonDao dao = new CommonDao();
	List<Map<String, String>> zjlist;
	public static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
	private ImportValidator validator = new ImportValidator();
	private ImportShebeiDataService service = new ImportShebeiDataService();
	private KucunDataService kcDataService = new KucunDataService();
	//private KucunService kcservice = new KucunService();
	public static final String DOWNLOAD_DIR = PropertyReader.readProperty("BaseIp","server");
	/**
	 * 设备入库
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
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		FormFile file = ((ImportDataForm) form).getFormFile();
		String error = validator.fileUplodateValidate(file);
		CommonMessage message = null;
		
		if (error != null) {
			saveMessage(error, request);
			return mapping.findForward("success1");
		}
		InputStream input = file.getInputStream();
		message = service.update(input);
		if (saveMessage(message, request)) {
			
			return mapping.findForward("success1");
		}
		
		return mapping.findForward("success1");
	}
	
	/**
	 * 设备出库
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward shebeichuku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		KuncunForm f = (KuncunForm)form;
		List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> userNameAll = kcDataService.getUserNameAll();
		f.setUserNameList(userNameAll);
		List<CommonModule> statusList = kcDataService.getStatusYichangCodeAll();
		f.setStatusList(statusList);
		f.setZhuangtaiHidden(f.getZhuangtai());
		String[] uuids = f.getUUIDS();
		String str = "";
		for(int i = 0; i < uuids.length; i++) { 
			str += "," + uuids[i];
		}
		str = str.replaceFirst("," , "");
		f.setUUIDHidden(str);
		return mapping.findForward(FW_INIT);
	}
	
	/**
	 * 设备去异常
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward shebeiToyichangku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		KuncunForm f = (KuncunForm)form;
		f.setZhuangtaiHidden(f.getZhuangtai());
		List<CommonModule> statusList = kcDataService.getStatusYichangCodeAll();
		f.setStatusList(statusList);
		String[] uuids = f.getUUIDS();
		String str = "";
		for(int i = 0; i < uuids.length; i++) { 
			str += "," + uuids[i];
		}
		str = str.replaceFirst("," , "");
		f.setUUIDHidden(str);
		return mapping.findForward("success1");
	}
	
	/**
	 * zhuangtaibiangeng
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward shebeiZTchange(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		KuncunForm f = (KuncunForm)form;
		List<CommonModule> statusList;
		String[] uuids = f.getUUIDS();
		String str = "";
		for(int i = 0; i < uuids.length; i++) { 
			str += "," + uuids[i];
		}
		str = str.replaceFirst("," , "");
		f.setUUIDHidden(str);
		
		String zhuangtai = f.getZhuangtai();
		if (zhuangtai.equals("1")) {
			statusList = kcDataService.getStatus23CodeAll();
			f.setStatusList(statusList);
		} else if (zhuangtai.equals("2")) {
			statusList = kcDataService.getStatus24CodeAll();
			f.setStatusList(statusList);
		} else {
			statusList = kcDataService.getStatus234CodeAll();
			f.setStatusList(statusList);
		}
		f.setZhuangtaiHidden(zhuangtai);
		return mapping.findForward("init1");
	}
	
}

	

