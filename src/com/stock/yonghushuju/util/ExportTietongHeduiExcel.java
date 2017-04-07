package com.stock.yonghushuju.util;

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
 * Ӧ�÷��ͣ���������һ������javabean������ ע������Ϊ�˼������boolean�͵�����get����ʽΪgetXxx(),������isXxx()
 * 
 */
public class ExportTietongHeduiExcel {

	public void exportExcelYHRiJiZhang(String[] headers, List<List<String>> listData, OutputStream out) {
		//exportYHRiJiExcel("��������ռ���", listData, out, "yyyy-MM-dd");
	}

	public void exportExcelHuiZongTongji(String[] headers, List<List<String>> listData, OutputStream out) {
		exportHuiZongTongJiExcel("����ͳ�Ʊ�", listData, out, "yyyy-MM-dd");
	}

	public void exportExcelCunKuanMingXi(String[] headers, List<List<String>> listData, OutputStream out) {
		exportCunKuanMingXiExcel(listData.get(0).get(0), listData, out, "yyyy-MM-dd");
	}

	public void exportExcelDianXinShouKuan(String[] headers, List<List<String>> listData, OutputStream out) {
		exportDianXinShouKuaniExcel(listData.get(0).get(0), listData, out, "yyyy-MM-dd");
	}
	
	public void exportExcelDuiZhang( List<List<String>> listData, OutputStream out, float Qian) {
		exportExcelDuiZhang(listData.get(0).get(0), listData, out, "yyyy-MM-dd", Qian);
	}

	public void exportExcelDuiZhang(String title, List<List<String>> listData, OutputStream out, String pattern, float qian) {
		// ����һ��������
		//	XSSFWorkbook workbook = new XSSFWorkbook();
		HSSFWorkbook workbook = new HSSFWorkbook();
		// ����һ�����
		HSSFSheet sheet = workbook.createSheet(title);

		// sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 12));
		// sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 12));
		// sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 12));
		// ���ñ��Ĭ���п��Ϊ15���ֽ�
		sheet.setDefaultColumnWidth((short) 20);
		// ����һ����ʽ
		HSSFCellStyle[] style = getStyle(workbook);

		// ������������
		HSSFRow row = sheet.createRow(0);
		/*List<String> listHead = listData.get(0);
		for (int i = 0; i < listHead.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style[0]);
			HSSFRichTextString text = new HSSFRichTextString(listHead.get(i));
			cell.setCellValue(text);
		}*/

		for (int i = 0; i < listData.size(); i++) {
			// �����������ݣ�����������
			row = sheet.createRow(i);
			List<String> list = listData.get(i);
			for (int j = 0; j < list.size(); j++) {
				HSSFCell cell = row.createCell(j);
				cell.setCellStyle(style[1]);
				HSSFRichTextString richString = new HSSFRichTextString(list.get(j));
				//HSSFFont font3 = workbook.createFont();
				//font3.setColor(HSSFColor.BLACK.index);
				//font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				//richString.applyFont(font3);
				cell.setCellValue(richString);
			}
		}
		row = sheet.createRow(listData.size());
		HSSFCell cell = row.createCell(29);
		HSSFRichTextString richString = new HSSFRichTextString(String.valueOf(qian));
		cell.setCellValue(richString);
		
		row = sheet.createRow(listData.size() + 1);
		cell = row.createCell(29);
		richString = new HSSFRichTextString(String.valueOf(qian / 2));
		cell.setCellValue(richString);
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exportHuiZongTongJiExcel(String title, List<List<String>> listData, OutputStream out, String pattern) {
		// ����һ��������
		HSSFWorkbook workbook = new HSSFWorkbook();
		// ����һ�����
		HSSFSheet sheet = workbook.createSheet(title);

		// ����ͷ12��
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
		// �����2��3�� �ϲ�
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 2, 2));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 9, 10));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 11, 11));

		// 3�п�ʼд������

		// ���ñ��Ĭ���п��Ϊ15���ֽ�
		sheet.setDefaultColumnWidth((short) 13);
		// ����һ����ʽ
		HSSFCellStyle[] style = getStyle(workbook);

		// ������������
		HSSFRow row = sheet.createRow(0);
		List<String> listHead = listData.get(0);
		for (int i = 0; i < listHead.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style[0]);
			HSSFRichTextString text = new HSSFRichTextString(listHead.get(i));
			cell.setCellValue(text);
		}

		for (int i = 1; i < listData.size(); i++) {
			// �����������ݣ�����������
			row = sheet.createRow(i);
			for (int j = 0; j < listData.get(i).size(); j++) {
				HSSFCell cell = row.createCell(j);
				cell.setCellStyle(style[1]);
				HSSFRichTextString richString = new HSSFRichTextString(listData.get(i).get(j));
				HSSFFont font3 = workbook.createFont();
				font3.setColor(HSSFColor.BLACK.index);
				if (i < 3) {
					font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				} else {
					if (j == listData.get(i).size() - 1) {
						cell.setCellStyle(style[2]);
						font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
					}
				}
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

	public void exportCunKuanMingXiExcel(String title, List<List<String>> listData, OutputStream out, String pattern) {
		// ����һ��������
		HSSFWorkbook workbook = new HSSFWorkbook();
		// ����һ�����
		HSSFSheet sheet = workbook.createSheet(title);

		// ����ͷ12��
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 25));
		// �����2��3�� �ϲ�
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 2, 2));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 3, 3));

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 4, 12));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 11, 11));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 12, 12));

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 13, 14));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 14, 14));

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 19, 24));

		sheet.addMergedRegion(new CellRangeAddress(1, 2, 25, 25));

		int size = listData.size();

		sheet.addMergedRegion(new CellRangeAddress(size - 2, size - 2, 3, 12));
		sheet.addMergedRegion(new CellRangeAddress(size - 2, size - 2, 13, 14));
		sheet.addMergedRegion(new CellRangeAddress(size - 1, size - 1, 1, 2));

		// 3�п�ʼд������

		// ���ñ��Ĭ���п��Ϊ15���ֽ�
		sheet.setDefaultColumnWidth((short) 8);

		HSSFCellStyle[] style = getStyle(workbook);

		// ������������
		HSSFRow row = sheet.createRow(0);
		List<String> listHead = listData.get(0);
		for (int i = 0; i < listHead.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style[0]);
			HSSFRichTextString text = new HSSFRichTextString(listHead.get(i));
			cell.setCellValue(text);
		}
		/*
		 * HSSFCellStyle cellStyle=workbook.createCellStyle();
		 * cellStyle.setWrapText(true); cell.setCellStyle(cellStyle);
		 */

		for (int i = 1; i < listData.size(); i++) {
			// �����������ݣ�����������
			row = sheet.createRow(i);
			row.setHeightInPoints(50);
			for (int j = 0; j < listData.get(i).size(); j++) {
				HSSFCell cell = row.createCell(j);
				cell.setCellStyle(style[1]);
				HSSFRichTextString richString = new HSSFRichTextString(listData.get(i).get(j));
				HSSFFont font3 = workbook.createFont();
				font3.setColor(HSSFColor.BLACK.index);
				if (i < 3) {
					font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				}
				if (i == listData.size() - 3) {
					font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				}
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

	public void exportDianXinShouKuaniExcel(String title, List<List<String>> listData, OutputStream out, String pattern) {
		// ����һ��������
		HSSFWorkbook workbook = new HSSFWorkbook();
		// ����һ�����
		HSSFSheet sheet = workbook.createSheet(title);

		// ����ͷ12��
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 17));
		// �����2��3�� �ϲ�
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));// �տ�����
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));// �վݺ�
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 2, 2));// ��ַ
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 3, 3));// ��ע

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 4, 5));// e8�ײ�
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 5, 5));

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 6, 7));// e9�ײ�
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 7, 7));

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 8, 11));// ����
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 11, 11));

		sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));// ������
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 13, 13));// �豸Ѻ��

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 15, 16));

		int size = listData.size();
		sheet.addMergedRegion(new CellRangeAddress(size - 1, size - 1, 0, 1));
		/*
		 * sheet.addMergedRegion(new CellRangeAddress(size - 2, size - 2, 3,
		 * 12)); sheet.addMergedRegion(new CellRangeAddress(size - 2, size - 2,
		 * 13, 14)); sheet.addMergedRegion(new CellRangeAddress(size - 1, size -
		 * 1, 1, 2));
		 */

		// 3�п�ʼд������

		// ���ñ��Ĭ���п��Ϊ15���ֽ�
		sheet.setDefaultColumnWidth((short) 8);

		// ����һ����ʽ
		HSSFCellStyle[] style = getStyle(workbook);

		// ������������
		HSSFRow row = sheet.createRow(0);
		List<String> listHead = listData.get(0);
		for (int i = 0; i < listHead.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style[0]);
			HSSFRichTextString text = new HSSFRichTextString(listHead.get(i));
			cell.setCellValue(text);
		}

		for (int i = 1; i < listData.size(); i++) {
			// �����������ݣ�����������
			row = sheet.createRow(i);
			row.setHeightInPoints(50);
			for (int j = 0; j < listData.get(i).size(); j++) {
				HSSFCell cell = row.createCell(j);
				cell.setCellStyle(style[1]);
				HSSFRichTextString richString = new HSSFRichTextString(listData.get(i).get(j));
				HSSFFont font3 = workbook.createFont();
				font3.setColor(HSSFColor.BLACK.index);
				if (i < 3) {
					font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				}
				if (i == listData.size() - 1) {
					font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				}
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

	public HSSFCellStyle[] getStyle(HSSFWorkbook workbook) {
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
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// ������Ӧ�õ���ǰ����ʽ
		style.setFont(font);
		// ���ɲ�������һ����ʽ
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

		// ���ɲ�������һ����ʽ
		HSSFCellStyle style3 = workbook.createCellStyle();
		style3.setFillForegroundColor(HSSFColor.YELLOW.index);
		style3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// ������һ������
		HSSFFont font4 = workbook.createFont();
		font4.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// ������Ӧ�õ���ǰ����ʽ
		style3.setFont(font4);

		HSSFCellStyle[] str = { style, style2, style3 };
		// ����һ����ͼ�Ķ���������
		// HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// ����ע�͵Ĵ�С��λ��,����ĵ�
		// HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
		// 0 , 0, 0, (short) 4, 2, (short) 6, 5));
		// ����ע������
		/*
		 * comment.setString(new HSSFRichTextString("������POI�����ע�ͣ�")); //
		 * ����ע�����ߣ�������ƶ�����Ԫ�����ǿ�����״̬���п���������. comment.setAuthor("lhh");
		 */
		return str;
	}

}