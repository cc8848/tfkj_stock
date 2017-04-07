package com.stock.paigongdan; 

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;

import com.hrbank.business.frame.BusinessService;

public class ImportService extends BusinessService {
	
	/**
	 * 将一行Excel数据转换为字符串数组.
	 * 
	 * @param hssfRow 一行Excel数据
	 * @param cols 该行数据的列数
	 * @return 返回该行Excel数据的字符串数组.
	 */
	public String[] convertRow(HSSFRow hssfRow,int cols){
		String[] values = new String[cols];
		for(int i=0;i<cols;i++){
			HSSFCell hssfCell = hssfRow.getCell(i);
    		if (hssfCell == null){
    			values[i] = "";
    			continue;  
	    	}
    		int cellType = hssfCell.getCellType();
    		if(cellType == HSSFCell.CELL_TYPE_NUMERIC){
    			if (HSSFDateUtil.isCellDateFormatted(hssfCell)) {
    				Date d = hssfCell.getDateCellValue();
    				values[i] = new SimpleDateFormat("yyyy-MM-dd").format(d);
    			}else{
    				double d = hssfCell.getNumericCellValue();
    				NumberFormat fmt = NumberFormat.getInstance();
    				fmt.setGroupingUsed(false);
    				values[i] = fmt.format(d);
    			}
    		}else{
    			HSSFRichTextString text = hssfCell.getRichStringCellValue();
	    		String s = text.getString();
	    		values[i] = s;
    		}
		}
		return values;
	}
	
	
}
