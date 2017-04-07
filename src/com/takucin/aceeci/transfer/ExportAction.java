package com.takucin.aceeci.transfer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.takucin.aceeci.exception.ExportAdapterInitException;
import com.takucin.aceeci.frame.CommonAction;

public class ExportAction extends CommonAction{

	private ExportAdapter exportAdapter;
	
	
	public ActionForward export(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if(exportAdapter == null){
			throw new ExportAdapterInitException();
		}
		TransferEvent event = new TransferEvent(mapping, form, request, response);
		response.setHeader("Content-disposition", "attachment;filename=" + exportAdapter.getFileName(event));
		response.setContentType(exportAdapter.getContentType(event)); 
		exportAdapter.buildFile(event);
		return null;
	}


	public ExportAdapter getExportAdapter() {
		return exportAdapter;
	}


	public void setExportAdapter(ExportAdapter exportAdapter) {
		this.exportAdapter = exportAdapter;
	}
}
