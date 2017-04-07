
package com.stock.total; 

import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.util.PropertyReader;


/** 
 * deal with excel import.
 * 
 * @author Zhu.Xiao-Lei 
 */
public class ImportDataAction extends BusinessAction {
	//private CommonDao dao = new CommonDao();
	public static final String DOWNLOAD_DIR = PropertyReader.readProperty("BaseIp","server");
	CommonMessage message;
	
	
	public ActionForward downExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TotalService serviceData = new TotalService();

		String path = this.getClass().getClassLoader().getResource("/").getPath();
	    int index = path.indexOf("WEB-INF");   
	    path = path.substring(0, index); 
	    if (path.indexOf("%") >= 0) {
	    	try {
	    		path = URLDecoder.decode(path, "utf-8"); 
           } catch (Exception e) { 
              e.printStackTrace(); 
           } 
	    }
	    String pathDelet = path+ "excel/gongzuoliang.xls";
	    pathDelet = pathDelet.replaceFirst("/", "");
	    File file = new File(pathDelet);
	    if (file.exists()) {
	    	response.getWriter().write("0"+DOWNLOAD_DIR);//文件存在？
	    } else {
	    	response.getWriter().write("1");//文件不存在？
	    }
	  
		return mapping.findForward("null");
	}
	
	
}

	

