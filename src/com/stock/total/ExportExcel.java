package com.stock.total;



import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 
 * 
 * 应用泛型，代表任意一个符合javabean风格的类
 * 注意这里为了简单起见，boolean型的属性get器方式为getXxx(),而不是isXxx()
 * 
 */
public class ExportExcel {

    public void exportExcel( List<List<Object>> listData, OutputStream out, int i) {
    	exportExcel1("工作量统计表", listData, out, i);
    }
  


    
    
    public void exportExcel1(String string, List<List<Object>> listData, OutputStream out, int num) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(string);
        int size = listData.size();
        //标题头12行
        sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
        //标题第2，3行 合并
        sheet.addMergedRegion(new CellRangeAddress(0, 2, 1, 1));
        int startNum = 2;
        int midleNum = 9;
        int endNum = 11;
        for (int i = 0; i < num; i++){
	        sheet.addMergedRegion(new CellRangeAddress(0, 0, startNum, endNum));
	        sheet.addMergedRegion(new CellRangeAddress(1, 1, startNum, midleNum - 1));
	        sheet.addMergedRegion(new CellRangeAddress(1, 2, midleNum, midleNum));//维修数(包括收件）
	        sheet.addMergedRegion(new CellRangeAddress(1, 2, midleNum + 1, midleNum + 1));//续费
	        sheet.addMergedRegion(new CellRangeAddress(1, 2, midleNum + 2, midleNum + 2));//退订
	        
	        sheet.addMergedRegion(new CellRangeAddress(2, 2, startNum, startNum));
	        sheet.addMergedRegion(new CellRangeAddress(2, 2, startNum + 1, startNum + 1));
	        sheet.addMergedRegion(new CellRangeAddress(2, 2, startNum + 2, startNum + 2));
	        sheet.addMergedRegion(new CellRangeAddress(2, 2, startNum + 3, startNum + 3));
	        sheet.addMergedRegion(new CellRangeAddress(2, 2, startNum + 4, startNum + 4));
	        sheet.addMergedRegion(new CellRangeAddress(2, 2, startNum + 5, startNum + 5));
	        sheet.addMergedRegion(new CellRangeAddress(2, 2, startNum + 6, startNum + 6));
	        startNum = startNum + 10;
	        midleNum = midleNum + 10;
	        endNum = endNum + 10;
        }
   
        //3行开始写入数据
        HSSFCellStyle style2 = workbook.createCellStyle();
        
        style2.setFillForegroundColor(HSSFColor.WHITE.index);
        style2.setWrapText(true);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 13);
        // 生成一个样式
       // HSSFCellStyle[] style = getStyle(workbook);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        HSSFFont font3 = workbook.createFont();
        font3.setColor(HSSFColor.BLACK.index);
     
       for(int i = 0 ; i < listData.size() ; i++ ){
	        // 遍历集合数据，产生数据行
	        row = sheet.createRow(i);
	        for (int j = 0; j < listData.get(i).size(); j++) {
	            HSSFCell cell = row.createCell(j);
	            cell.setCellStyle(style2);
	            HSSFRichTextString richString = new HSSFRichTextString(String.valueOf(listData.get(i).get(j)));
	            richString.applyFont(font3);
	            cell.setCellValue(richString);
	        }
       }
       try {
    	   workbook.write(out);
       } catch (IOException e) {
    	   e.printStackTrace();
       }
   }
    
}