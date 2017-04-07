package com.takucin.aceeci.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Cell {
	
	public static final int TYPE_STRING = 0;
	public static final int TYPE_INTEGER = 1;
	public static final int TYPE_DOUBLE = 2;
	
	private String stringValue;
	private int intValue;
	private double doubleValue;
	private int type;
	
	private int colspan = 1;
	private int rowspan = 1;
	
	private HSSFFont font;
	private HSSFCellStyle hssfCellStyle;
	
	public Cell(String stringValue){
		this(stringValue,null,null);
	}
	
	public Cell(String stringValue,CellStyle style,HSSFWorkbook workbook){
		this.setStringValue(stringValue);
		setCellStyle(style,workbook);
	}
	
	public Cell(int intValue){
		this(intValue,null,null);
	}
	
	public Cell(int intValue,CellStyle style,HSSFWorkbook workbook){
		this.setIntValue(intValue);
		setCellStyle(style,workbook);
	}
	
	public Cell(double doubleValue){
		this(doubleValue,null,null);
	}
	
	public Cell(double doubleValue,CellStyle style,HSSFWorkbook workbook){
		this.setDoubleValue(doubleValue);
		setCellStyle(style,workbook);
	}
	
	private void initCellFont(HSSFWorkbook workbook){
		if(font == null){
			font = workbook.createFont();
			initCellStyle(workbook);
		}
	}
	
	private void initCellStyle(HSSFWorkbook workbook){
		if(hssfCellStyle == null){
			hssfCellStyle = workbook.createCellStyle();
		}
	}
	
	public void setCellStyle(CellStyle style,HSSFWorkbook workbook){
		if(style != null){
			if(style.isSatFontSize()){
				initCellFont(workbook);
				font.setFontHeightInPoints((short)style.getFontSize());
			}
			if(style.isSatColor()){
				initCellFont(workbook);
				font.setColor((short)style.getColor());
			}
			if(style.isBlod()){
				initCellFont(workbook);
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			}
			if(style.isItalic()){
				initCellFont(workbook);
				font.setItalic(true);
			}
			if(style.isSatBorder()){
				initCellStyle(workbook);
				hssfCellStyle.setBorderBottom((short)style.getBorder());
				hssfCellStyle.setBorderLeft((short)style.getBorder());
				hssfCellStyle.setBorderRight((short)style.getBorder());
				hssfCellStyle.setBorderTop((short)style.getBorder());
			}
			if(style.isSatAlignment()){
				initCellStyle(workbook);
				hssfCellStyle.setAlignment((short)style.getAlignment());
			}
			if(style.isSatVerticalAlignment()){
				initCellStyle(workbook);
				hssfCellStyle.setVerticalAlignment((short)style.getVerticalAlignment());
			}
			if(hssfCellStyle != null){
				hssfCellStyle.setFont(font);
			}
		}
	}
	
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
		this.type = TYPE_STRING;
	}
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
		this.type = TYPE_INTEGER;
	}
	public double getDoubleValue() {
		return doubleValue;
	}
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
		this.type = TYPE_DOUBLE;
	}
	public int getType() {
		return type;
	}
	
	public void setType(int type){
		this.type = type;
	}

	public HSSFCellStyle getHssfCellStyle() {
		return hssfCellStyle;
	}

	public int getColspan() {
		return colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}

	public int getRowspan() {
		return rowspan;
	}

	public void setRowspan(int rowspan) {
		this.rowspan = rowspan;
	}
}
