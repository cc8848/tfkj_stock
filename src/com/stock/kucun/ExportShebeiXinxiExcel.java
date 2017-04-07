package com.stock.kucun;



import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 
 * 
 * Ӧ�÷��ͣ���������һ������javabean������
 * ע������Ϊ�˼������boolean�͵�����get����ʽΪgetXxx(),������isXxx()
 * 
 */
public class ExportShebeiXinxiExcel<T> {

   

    public void exportExcel1(String[] headers, List<List<String>> listdata, OutputStream out) {
        exportExcel("�豸��Ϣ", headers, listdata, out);
    }

    /**
     * ����һ��ͨ�õķ�����������JAVA�ķ�����ƣ����Խ�������JAVA�����в��ҷ���һ��������������EXCEL ����ʽ�����ָ��IO�豸��
     * 
     * @param title
     *            ��������
     * @param headers
     *            ���������������
     * @param listdata
     *            ��Ҫ��ʾ�����ݼ���,������һ��Ҫ���÷���javabean������Ķ��󡣴˷���֧�ֵ�
     *            javabean���Ե����������л����������ͼ�String,Date,byte[](ͼƬ����)
     * @param out
     *            ������豸�����������󣬿��Խ�EXCEL�ĵ������������ļ�����������
     * @param pattern
     *            �����ʱ�����ݣ��趨�����ʽ��Ĭ��Ϊ"yyy-MM-dd"
     */
    @SuppressWarnings("unchecked")
    public void exportExcel(String title, String[] headers,
            List<List<String>> listdata, OutputStream out) {
        // ����һ��������
        HSSFWorkbook workbook = new HSSFWorkbook();
        // ����һ�����
        HSSFSheet sheet = workbook.createSheet(title);
       // sheet.addMergedRegion(new CellRangeAddress(2, 3, 2, 3));
        // ���ñ��Ĭ���п��Ϊ15���ֽ�
        sheet.setDefaultColumnWidth((short) 15);
        // ����һ����ʽ
        HSSFCellStyle style = workbook.createCellStyle();
        // ������Щ��ʽ
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // ����һ������
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // ������Ӧ�õ���ǰ����ʽ
        style.setFont(font);
        // ���ɲ�������һ����ʽ
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
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

        // ����һ����ͼ�Ķ���������
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // ����ע�͵Ĵ�С��λ��,����ĵ�
        /*HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0 , 0, 0, (short) 4, 2, (short) 6, 5));
        // ����ע������
        comment.setString(new HSSFRichTextString("������POI�����ע�ͣ�"));
        // ����ע�����ߣ�������ƶ�����Ԫ�����ǿ�����״̬���п���������.
        comment.setAuthor("lhh");*/

        // ������������
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        for(int i = 0 ; i < listdata.size() ; i++ ){
	        // �����������ݣ�����������
	        row = sheet.createRow(i+1);
	        row.setHeightInPoints(50); 
	        for (int j = 0; j < listdata.get(0).size(); j++) {
	            HSSFCell cell = row.createCell(j);
	            cell.setCellStyle(style);
	            HSSFRichTextString richString = new HSSFRichTextString(listdata.get(i).get(j));
	            HSSFFont font3 = workbook.createFont();
	            font3.setColor(HSSFColor.BLACK.index);
	            richString.applyFont(font3);
	            cell.setCellValue(richString);
	        }
       }
        
        try {
            workbook.write(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}