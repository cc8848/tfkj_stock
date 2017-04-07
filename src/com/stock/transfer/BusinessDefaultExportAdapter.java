package com.stock.transfer;

import java.util.List;

import com.takucin.aceeci.excel.Cell;
import com.takucin.aceeci.excel.Excel;
import com.takucin.aceeci.excel.Row;
import com.takucin.aceeci.transfer.ExportAdapter;
import com.takucin.aceeci.transfer.TransferEvent;

public abstract class BusinessDefaultExportAdapter implements ExportAdapter{

	
	public String getContentType(TransferEvent e) {
		return BusinessExportAction.CONTENT_TYPE_XLS;
	}
	
	public void buildFile(TransferEvent e) throws Exception{
		Excel excel = getExcel(e);
		List<Row> rows = excel.getSheetRows().get(0);
		if(rows.size() > 65536){
			excel = getErrorExcel();
		}
		if(rows.size() > 0){
			int cols = rows.get(0).size();
			if(cols > 255){
				excel = getErrorExcel();
			}
		}
		excel.create(e.getResponse().getOutputStream());
	}
	
	private Excel getErrorExcel(){
		Excel excel = new Excel();
		excel.setSheetName("error");
		Row row = new Row();
		row.addCell(new Cell("待导出的Excel行数或列数太大"));
		excel.set(row);
		return excel;
	}
	
	public abstract Excel getExcel(TransferEvent e) throws Exception;
	
}
