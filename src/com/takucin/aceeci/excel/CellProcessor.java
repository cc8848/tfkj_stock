package com.takucin.aceeci.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;

public interface CellProcessor {

	public Object processor(HSSFCell cell);
}
