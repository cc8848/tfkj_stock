package com.takucin.aceeci.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;

public class CellStyle {
	
	public static final int ALIGN_CENTER = HSSFCellStyle.ALIGN_CENTER;
	public static final int ALIGN_CENTER_SELECTION = HSSFCellStyle.ALIGN_CENTER_SELECTION;
	public static final int ALIGN_FILL = HSSFCellStyle.ALIGN_FILL;
	public static final int ALIGN_GENERAL = HSSFCellStyle.ALIGN_GENERAL;
	public static final int ALIGN_JUSTIFY = HSSFCellStyle.ALIGN_JUSTIFY;
	public static final int ALIGN_LEFT = HSSFCellStyle.ALIGN_LEFT;
	public static final int ALIGN_RIGHT = HSSFCellStyle.ALIGN_RIGHT;
	
	public static final int VERTICAL_BOTTOM = HSSFCellStyle.VERTICAL_BOTTOM;
	public static final int VERTICAL_CENTER = HSSFCellStyle.VERTICAL_CENTER;
	public static final int VERTICAL_JUSTIFY = HSSFCellStyle.VERTICAL_JUSTIFY;
	public static final int VERTICAL_TOP = HSSFCellStyle.VERTICAL_TOP;
	
	private int fontSize;
	private int color;
	private boolean blod = false;
	private boolean italic = false;
	private int border;
	private int alignment;
	private int verticalAlignment;
	
	private boolean satFontSize;
	private boolean satColor;
	private boolean satBorder;
	private boolean satAlignment;
	private boolean satVerticalAlignment;

	public CellStyle(){
	}
	
	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
		this.satFontSize = true;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
		this.satColor = true;
	}

	public boolean isBlod() {
		return blod;
	}

	public void setBlod(boolean blod) {
		this.blod = blod;
	}

	public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	public int getBorder() {
		return border;
	}

	public void setBorder(int border) {
		this.border = border;
		this.satBorder = true;
	}

	public boolean isSatFontSize() {
		return satFontSize;
	}

	public boolean isSatColor() {
		return satColor;
	}

	public boolean isSatBorder() {
		return satBorder;
	}

	public int getAlignment() {
		return alignment;
	}

	public void setAlignment(int alignment) {
		this.alignment = alignment;
		this.satAlignment = true;
	}

	public boolean isSatAlignment() {
		return satAlignment;
	}

	public int getVerticalAlignment() {
		return verticalAlignment;
	}

	public void setVerticalAlignment(int verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
		this.satVerticalAlignment = true;
	}

	public boolean isSatVerticalAlignment() {
		return satVerticalAlignment;
	}
}
