package com.takucin.aceeci.transfer;

public interface DownloadAdapter extends TransferAdapter {
	
	public String getFileSourcePath(TransferEvent e);
	
	public int getBuffer(TransferEvent e);
	
	public String getFileName(TransferEvent e);
	
	public String getContentType(TransferEvent e);
	
	public String getFileNotExistsError(TransferEvent e);
	
	public void doFileNotExists(TransferEvent e);
}
