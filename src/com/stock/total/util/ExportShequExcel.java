package com.stock.total.util;

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

import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

/**
 * 
 * 
 * 应用泛型，代表任意一个符合javabean风格的类 注意这里为了简单起见，boolean型的属性get器方式为getXxx(),而不是isXxx()
 * 
 */
public class ExportShequExcel {

	public void exportExcelYHRiJiZhang(String[] headers, List<List<String>> listData, OutputStream out) {
	}

	public void exportExcelHuiZongTongji(DataSet<DataRow> executeQuery, OutputStream out1, String[] str) {
		exportHuiZongTongJiExcel("社区金额", out1, str, executeQuery);
	}
	public void exportExcelYunYingData(DataSet<DataRow> executeQuery, OutputStream out1, String[] str) {
		exportExcelYunYingData("运营商数据", out1, str, executeQuery);
	}

	private void exportExcelYunYingData(String title, OutputStream out1, String[] str, DataSet<DataRow> executeQuery) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);


		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 13);
		// 生成一个样式
		HSSFCellStyle[] style = getStyle(workbook);

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < str.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style[0]);
			HSSFRichTextString text = new HSSFRichTextString(str[i]);
			cell.setCellValue(text);
		}

		for (int i = 0; i < executeQuery.size(); i++) {
			// 遍历集合数据，产生数据行
			row = sheet.createRow(i+1);
			String xiaoqu = executeQuery.get(i).getDataElement("xiaoqu").getString();
			String yunyingshang = executeQuery.get(i).getDataElement("yunyingshang").getString();
			String wl_anzhuangNum = executeQuery.get(i).getDataElement("wl_anzhuangNum").getString();
			String ds_anzhuangNum = executeQuery.get(i).getDataElement("ds_anzhuangNum").getString();
			String dh_anzhuangNum = executeQuery.get(i).getDataElement("dh_anzhuangNum").getString();
			
			HSSFCell cell = row.createCell(0);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString1 = new HSSFRichTextString(xiaoqu);
			cell.setCellValue(richString1);
			
			cell = row.createCell(1);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString2 = new HSSFRichTextString(yunyingshang);
			cell.setCellValue(richString2);
			
			cell = row.createCell(2);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString3 = new HSSFRichTextString(wl_anzhuangNum);
			cell.setCellValue(richString3);
			
			cell = row.createCell(3);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString4 = new HSSFRichTextString(ds_anzhuangNum);
			cell.setCellValue(richString4);
			
			cell = row.createCell(4);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString5 = new HSSFRichTextString(dh_anzhuangNum);
			cell.setCellValue(richString5);
			
			
		}
		try {
			workbook.write(out1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void exportHuiZongTongJiExcel(String title, OutputStream out1, String[] str, DataSet<DataRow> executeQuery) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);


		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 13);
		// 生成一个样式
		HSSFCellStyle[] style = getStyle(workbook);

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < str.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style[0]);
			HSSFRichTextString text = new HSSFRichTextString(str[i]);
			cell.setCellValue(text);
		}

		for (int i = 0; i < executeQuery.size(); i++) {
			// 遍历集合数据，产生数据行
			row = sheet.createRow(i+1);
			String xiaoqu = executeQuery.get(i).getDataElement("xiaoqu").getString();
			String dizhi = executeQuery.get(i).getDataElement("dizhi").getString();
			String xingming = executeQuery.get(i).getDataElement("xingming").getString();
			String lianxidianhua = executeQuery.get(i).getDataElement("lianxidianhua").getString();
			String cishu = executeQuery.get(i).getDataElement("cishu").getString();
			int parseInt = Integer.parseInt(cishu);
			parseInt = parseInt * 40;
			
			HSSFCell cell = row.createCell(0);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString1 = new HSSFRichTextString(xiaoqu);
			cell.setCellValue(richString1);
			
			cell = row.createCell(1);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString2 = new HSSFRichTextString(dizhi);
			cell.setCellValue(richString2);
			
			cell = row.createCell(2);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString3 = new HSSFRichTextString(xingming);
			cell.setCellValue(richString3);
			
			cell = row.createCell(3);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString4 = new HSSFRichTextString(lianxidianhua);
			cell.setCellValue(richString4);
			
			cell = row.createCell(4);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString5 = new HSSFRichTextString(cishu);
			cell.setCellValue(richString5);
			
			cell = row.createCell(5);
			cell.setCellStyle(style[1]);
			HSSFRichTextString richString6 = new HSSFRichTextString(String.valueOf(parseInt));
			cell.setCellValue(richString6);
			
		}
		try {
			workbook.write(out1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exportCunKuanMingXiExcel(String title, List<List<String>> listData, OutputStream out, String pattern) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);

		// 标题头12行
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 25));
		// 标题第2，3行 合并
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

		// 3行开始写入数据

		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 8);

		HSSFCellStyle[] style = getStyle(workbook);

		// 产生表格标题行
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
			// 遍历集合数据，产生数据行
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
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);

		// 标题头12行
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 17));
		// 标题第2，3行 合并
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 0));// 收款日期
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));// 收据号
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 2, 2));// 地址
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 3, 3));// 备注

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 4, 5));// e8套餐
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 5, 5));

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 6, 7));// e9套餐
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 7, 7));

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 8, 11));// 单宽
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 11, 11));

		sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));// 不足月
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 13, 13));// 设备押金

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 15, 16));

		int size = listData.size();
		sheet.addMergedRegion(new CellRangeAddress(size - 1, size - 1, 0, 1));
		/*
		 * sheet.addMergedRegion(new CellRangeAddress(size - 2, size - 2, 3,
		 * 12)); sheet.addMergedRegion(new CellRangeAddress(size - 2, size - 2,
		 * 13, 14)); sheet.addMergedRegion(new CellRangeAddress(size - 1, size -
		 * 1, 1, 2));
		 */

		// 3行开始写入数据

		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 8);

		// 生成一个样式
		HSSFCellStyle[] style = getStyle(workbook);

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		List<String> listHead = listData.get(0);
		for (int i = 0; i < listHead.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style[0]);
			HSSFRichTextString text = new HSSFRichTextString(listHead.get(i));
			cell.setCellValue(text);
		}

		for (int i = 1; i < listData.size(); i++) {
			// 遍历集合数据，产生数据行
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
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
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

		// 生成并设置另一个样式
		HSSFCellStyle style3 = workbook.createCellStyle();
		style3.setFillForegroundColor(HSSFColor.YELLOW.index);
		style3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font4 = workbook.createFont();
		font4.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style3.setFont(font4);

		HSSFCellStyle[] str = { style, style2, style3 };
		// 声明一个画图的顶级管理器
		// HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		// HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
		// 0 , 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		/*
		 * comment.setString(new HSSFRichTextString("可以在POI中添加注释！")); //
		 * 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容. comment.setAuthor("lhh");
		 */
		return str;
	}

}