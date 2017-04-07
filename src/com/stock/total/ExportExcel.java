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
 * Ӧ�÷��ͣ���������һ������javabean������
 * ע������Ϊ�˼������boolean�͵�����get����ʽΪgetXxx(),������isXxx()
 * 
 */
public class ExportExcel {

    public void exportExcel( List<List<Object>> listData, OutputStream out, int i) {
    	exportExcel1("������ͳ�Ʊ�", listData, out, i);
    }
  


    
    
    public void exportExcel1(String string, List<List<Object>> listData, OutputStream out, int num) {
        // ����һ��������
        HSSFWorkbook workbook = new HSSFWorkbook();
        // ����һ�����
        HSSFSheet sheet = workbook.createSheet(string);
        int size = listData.size();
        //����ͷ12��
        sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
        //�����2��3�� �ϲ�
        sheet.addMergedRegion(new CellRangeAddress(0, 2, 1, 1));
        int startNum = 2;
        int midleNum = 9;
        int endNum = 11;
        for (int i = 0; i < num; i++){
	        sheet.addMergedRegion(new CellRangeAddress(0, 0, startNum, endNum));
	        sheet.addMergedRegion(new CellRangeAddress(1, 1, startNum, midleNum - 1));
	        sheet.addMergedRegion(new CellRangeAddress(1, 2, midleNum, midleNum));//ά����(�����ռ���
	        sheet.addMergedRegion(new CellRangeAddress(1, 2, midleNum + 1, midleNum + 1));//����
	        sheet.addMergedRegion(new CellRangeAddress(1, 2, midleNum + 2, midleNum + 2));//�˶�
	        
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
   
        //3�п�ʼд������
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
        // ������һ������
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // ������Ӧ�õ���ǰ����ʽ
        style2.setFont(font2);
        // ���ñ��Ĭ���п��Ϊ15���ֽ�
        sheet.setDefaultColumnWidth((short) 13);
        // ����һ����ʽ
       // HSSFCellStyle[] style = getStyle(workbook);

        // ������������
        HSSFRow row = sheet.createRow(0);
        HSSFFont font3 = workbook.createFont();
        font3.setColor(HSSFColor.BLACK.index);
     
       for(int i = 0 ; i < listData.size() ; i++ ){
	        // �����������ݣ�����������
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