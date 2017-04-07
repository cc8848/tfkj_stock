package com.takucin.aceeci.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.takucin.aceeci.exception.DefaultSheetNameNotFoundException;
import com.takucin.aceeci.exception.SheetNotFoundException;
import com.takucin.aceeci.util.Common;

public class Excel {

	private Log log = LogFactory.getLog(this.getClass());
	
	private String sheetName;
	private String path;
	private HSSFWorkbook workbook;
	private List<HSSFSheet> sheets;
	
	private List<List<Row>> sheetRows;
	
	public Excel() {
		workbook = new HSSFWorkbook();
		sheets = new ArrayList<HSSFSheet>();
		sheetRows = new ArrayList<List<Row>>();
		sheetRows.add(new ArrayList<Row>());
	}

	private void initDefaultSheet(){
		if(sheets.size() == 0){
			if(Common.isNull(this.sheetName)){
				throw new DefaultSheetNameNotFoundException();
			}
			this.addSheet(this.sheetName);
		}
	}
	
	public void set(Row row) {
		initDefaultSheet();
		this.set(0,row,0,0);
	}
	
	public void set(Row row,int offsetTop,int offsetleft) {
		initDefaultSheet();
		this.set(0,row,offsetTop,offsetleft);
	}
	
	public void set(int sheetIndex,Row row) {
		initDefaultSheet();
		this.set(sheetIndex,row,0,0);
	}
	
	public void set(int sheetIndex,Row row,int offsetTop,int offsetleft) {
		initDefaultSheet();
		List<Row> rows = new ArrayList<Row>();
		rows.add(row);
		this.set(sheetIndex,rows,offsetTop,offsetleft);
	}
	
	public void set(List<Row> rows){
		initDefaultSheet();
		this.set(0,rows,0,0);
	}
	
	public void set(List<Row> rows,int offsetTop,int offsetleft){
		initDefaultSheet();
		this.set(0,rows,offsetTop,offsetleft);
	}
	
	public void set(int sheetIndex,List<Row> rows) {
		initDefaultSheet();
		this.set(sheetIndex,rows,0,0);
	}
	
	public void set(int sheetIndex,List<Row> rows,int offsetTop,int offsetleft) {
		initDefaultSheet();
		int osTop = offsetTop;
		int osLeft = offsetleft;
		
		HSSFSheet sheet = sheets.get(sheetIndex);
		if(sheet == null){
			throw new SheetNotFoundException();
		}
		for(int j=0;j<rows.size();j++){
			osLeft = offsetleft;
			HSSFRow hssfRow = sheet.createRow(osTop);
			Row row = rows.get(j);
			setSheetRow(sheetIndex,row);
			int rowspan = 1;
			List<Cell> cells = row.getCells();
			for(int i=0;i<cells.size();i++){
				Cell cell = cells.get(i);
				HSSFCell hssfCell = hssfRow.createCell(osLeft);
				switch(cell.getType()){
				case Cell.TYPE_STRING:
					hssfCell.setCellType(HSSFCell.CELL_TYPE_STRING);
					hssfCell.setCellValue(new HSSFRichTextString(cell.getStringValue()));
					break;
				case Cell.TYPE_INTEGER:
					hssfCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					hssfCell.setCellValue(cell.getIntValue());
					break;
				case Cell.TYPE_DOUBLE:
					hssfCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					hssfCell.setCellValue(cell.getDoubleValue());
					break;
				}
				if(cell.getRowspan() > 1 || cell.getColspan() > 1){
					sheet.addMergedRegion(new CellRangeAddress(osTop,(short)(osTop + cell.getRowspan() - 1),osLeft,(short)(osLeft + cell.getColspan()) - 1));
				}
				if(cell.getHssfCellStyle() != null){
					hssfCell.setCellStyle(cell.getHssfCellStyle());
				}
				osLeft = osLeft + cell.getColspan();
				rowspan = cell.getRowspan();
			}
			osTop = osTop + rowspan;
		}
		
	}
	
	public List<Row> importSheet(int rows,int cols,int start) throws Exception{
		return importSheet(rows,cols,start);
	}
	
	public List<Row> importSheet(int rows,int cols) throws Exception{
		FileInputStream input = new FileInputStream(this.path);
		return importSheet(input,rows,cols,0);
	}
	public List<Row> importSheet(InputStream input,int rows,int cols,int start) throws Exception{
		List<Row> sheetRows = new ArrayList<Row>();
	    POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
	    HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
	    HSSFSheet sheet = wb.getSheetAt(0);
	    int i=start;
	    while(rows == -1 || i<rows){
//	    for(int i=2;i<rows;i++){
	    	 HSSFRow hssfRow = sheet.getRow(i);
	    	 Row row = new Row();
	    	 if (hssfRow == null){
	    		 if(rows == -1){
	    		    break;
	    		 }
	    		 continue;  
	    	 }
	    	 for(int j=0;j<cols;j++){
	    		 HSSFCell hssfCell =  hssfRow.getCell(j);
	    		 if (hssfCell == null){
	    			 row.addCell(new Cell(""));
		    		 continue;  
		    	 }
	    		 int ct = hssfCell.getCellType();
	    		 if(ct == HSSFCell.CELL_TYPE_NUMERIC){
	    			 row.addCell(new Cell(hssfCell.getNumericCellValue()));
	    		 }else if(ct == HSSFCell.CELL_TYPE_FORMULA){
	    			 // TODO 公式类型的会报错.
	    		 }else{
	    			 HSSFRichTextString text = hssfCell.getRichStringCellValue();
		    		 row.addCell(new Cell(text.getString()));
	    		 }
	    	 }
	    	 sheetRows.add(row);
	    }
	    
	    this.sheetRows.add(sheetRows);
	    
		return sheetRows;
	}
	
	public void create() throws Exception{
		try {
			OutputStream out = new FileOutputStream(this.path);
			this.workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	public void create(OutputStream out) throws Exception{
		try {
			this.workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public List<HSSFSheet> getSheets() {
		return sheets;
	}

	public void addSheet(String sheetName) {
		this.sheets.add(this.workbook.createSheet(sheetName));
	}
	
	private void setSheetRow(int sheetIndex,Row row){
		List<Row> rows = sheetRows.get(sheetIndex);
		if(rows == null){
			rows = new ArrayList<Row>();
		}
		rows.add(row);
		sheetRows.add(rows);
	}

	public List<List<Row>> getSheetRows() {
		return sheetRows;
	}
}
