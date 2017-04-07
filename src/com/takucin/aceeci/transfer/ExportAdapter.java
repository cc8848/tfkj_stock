package com.takucin.aceeci.transfer;

public interface ExportAdapter extends TransferAdapter {

	public String getFileName(TransferEvent e);
	
	public String getContentType(TransferEvent e);
	
	public void buildFile(TransferEvent e) throws Exception;
	
}
