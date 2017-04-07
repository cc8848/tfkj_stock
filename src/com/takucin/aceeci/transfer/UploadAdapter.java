package com.takucin.aceeci.transfer;

import org.apache.struts.upload.FormFile;

public interface UploadAdapter extends TransferAdapter {
	
	public String[] getLegalContentTypes(TransferEvent e);
	
	public FormFile getFormFile(TransferEvent e);
	
	public String getIllegalContentTypeError(TransferEvent e);
	
	public String getFileTargetPath(TransferEvent e) throws Exception;
	
	public String parseFile(TransferEvent e) throws Exception;
	
	public String getUploadErrorForward(TransferEvent e);
	
	public String getUploadForward(TransferEvent e);
	
	public int getMaxSize(TransferEvent e);
	
	public String getIllegalFileSizeError(TransferEvent e);
	
}
