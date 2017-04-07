package com.takucin.aceeci.transfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.takucin.aceeci.exception.DownloadAdapterInitException;
import com.takucin.aceeci.frame.CommonAction;

public abstract class DownloadAction extends CommonAction {

	private DownloadAdapter downloadAdapter;
	
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if(downloadAdapter == null){
			throw new DownloadAdapterInitException();
		}
		TransferEvent event = new TransferEvent(mapping, form, request, response);
		File file = new File(downloadAdapter.getFileSourcePath(event));
		if(!file.exists()){
			String fileName = getPath(request,"sales.S035.import.path") + "error.xls";
			file = new File(fileName);
		}
		if (file.exists()) {
			int buffer = downloadAdapter.getBuffer(event);
			byte b[] = new byte[buffer];
			response.setHeader("Content-disposition", "attachment;filename=" + downloadAdapter.getFileName(event));
//			response.setContentType(downloadAdapter.getContentType(event));
			response.setContentType("bin");
			response.setHeader("Content_Length", String.valueOf(file.length())); 
			FileInputStream in = new FileInputStream(file);
			OutputStream o = response.getOutputStream();
			int n = 0;
			while ((n = in.read(b)) != -1) {
				o.write(b, 0, n); 
			}
			in.close();
			o.close();
		}
		return null;
	}

	public DownloadAdapter getDownloadAdapter() {
		return downloadAdapter;
	}

	public void setDownloadAdapter(DownloadAdapter downloadAdapter) {
		this.downloadAdapter = downloadAdapter;
	}
}
