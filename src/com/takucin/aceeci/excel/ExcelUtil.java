package com.takucin.aceeci.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.Common;

public class ExcelUtil {
	
	
	public static List<Row> toExcelRowList(DataSet<DataRow> dataSet){
		return toExcelRowList(dataSet,null,null);
	}
	
	public static List<Row> toExcelRowList(DataSet<DataRow> dataSet,List<String> keys){
		return toExcelRowList(dataSet,keys,null);
	}
	public static List<Row> toExcelRowList1(DataSet<DataRow> dataSet,List<String> keys,CellStyle biduistyle,CellStyle yichustyle,HSSFWorkbook pgdworkbook){
		return toExcelRowList1(dataSet,keys,null,biduistyle,yichustyle,pgdworkbook);
	}
	
	public static List<Row> toExcelRowList(DataSet<DataRow> dataSet,Map<String,Integer> types){
		return toExcelRowList(dataSet,null,types);
	}
	
	public static List<Row> toExcelRowList(DataSet<DataRow> dataSet,List<String> keys,Map<String,Integer> types){
		List<Row> rows = new ArrayList<Row>();
		if(dataSet != null){
			for(int i=0;i<dataSet.size();i++){
				DataRow dataRow = dataSet.get(i);
				Row row = new Row();
				List<String> ks = keys;
				if(ks == null){
					ks = dataRow.getKeys();
				}
				for(int j=0;j<ks.size();j++){
					String key = ks.get(j);
					int type = 0;
					if(types != null){
						type = types.get(key).intValue();
					}else{
						type = Cell.TYPE_STRING;
					}
					DataElement dataElement = dataRow.getDataElement(key);
					Cell cell = null;
					switch(type){
					case Cell.TYPE_STRING:
						cell = new Cell(dataElement.getString());
						break;
					case Cell.TYPE_INTEGER:
						if(Common.isNull(dataElement.getString())){
							cell = new Cell(dataElement.getString());
						}else{
							cell = new Cell(dataElement.getInt());
						}
						break;
					case Cell.TYPE_DOUBLE:
						if(Common.isNull(dataElement.getString())){
							cell = new Cell(dataElement.getString());
						}else{
							cell = new Cell(dataElement.getDouble());
						}
						break;
					}
					row.addCell(cell);
				}
				rows.add(row);
			}
		}
		return rows;
	}
	
	/*
	 *  为2013-3-21业务需求，新增方法。增添人：lhh
	 *  i.	导出报表中将“时长”列删除，将时长的信息增添到“业务”列中。
	 *	ii.	将“其他运营商”的“套餐信息”不仅填充到“业务”列，也同时增添到“电话”列。
	 *	i.	如果用户同时一次申请“宽带”和“其他运营商”的业务，业务列要同时存在“时长”和“套餐信息”，中间用“/”隔开。
	 *	ii.	导出的表中将“开票信息”列删除，将该列的内容增添到“备注”中，注意不要覆盖其他信息的内容。
	 *
	 *	2013-4-27业务需求，修改方法。修改人：lhh
	 *	将“工单管理”大项下的“出工单管理”界面中“导出报表”导出的“安装工单”中的“业务”项中的“网络时长：”4个汉子和一个标点删除，
	 *	将上述11个所选资费在选择后自动添加到业务项中与前部信息用“/”隔开。
	 */
	public static List<Row> toExcelRowList1(DataSet<DataRow> dataSet,List<String> keys,Map<String,Integer> types,CellStyle biduistyle,CellStyle yichustyle,HSSFWorkbook pgdworkbook){
		List<Row> rows = new ArrayList<Row>();
		if(dataSet != null){
			for(int i=0;i<dataSet.size();i++){
				DataRow dataRow = dataSet.get(i);
				Row row = new Row();
				List<String> ks = keys;
				if(ks == null){
					ks = dataRow.getKeys();
				}
				String yunyingshang = dataRow.getDataElement("yuyingshang").getString();
				String tfkdnianxian = dataRow.getDataElement("tfkdnianxian").getString();
				String kaipiaoxinxi = dataRow.getDataElement("kaipiaoxinxi").getString();
				String xiaoquname = dataRow.getDataElement("xiaoquname").getString();
				String biduikbn = dataRow.getDataElement("biduikbn").getString();
				for(int j=0;j<ks.size();j++){
					Cell cell = null;
					String key = ks.get(j);
					int type = 0;
					if(types != null){
						type = types.get(key).intValue();
					}else{
						type = Cell.TYPE_STRING;
					}
				
					//业务
					if (key.trim().equals("qtye")) {
						String yewu = dataRow.getDataElement(key).getString();
						if(yewu==null) {
							yewu = "";
						}
						if (tfkdnianxian != null && !tfkdnianxian.trim().equals("")) {
							yewu = yewu + "/(" +tfkdnianxian + ")";
						}
						if (biduikbn != null && !biduikbn.trim().equals("")) {
							yewu = biduikbn + "/" +yewu;
						}
					/*	if (!yunyingshang.equals("0")) {
							yewu = yewu + "/(运营商：" +yunyingshang + ")";
						}*/
						cell = new Cell(yewu);
						if (biduikbn != null && !biduikbn.trim().equals("")) {
							cell.setCellStyle(biduistyle, pgdworkbook);
						}else{
							cell.setCellStyle(new CellStyle(), pgdworkbook);
						}
						row.addCell(cell);
						continue;
					}
					
					if (key.trim().equals("dianhua")) {
						String dianhua = dataRow.getDataElement(key).getString();
						
//						if (!yunyingshang.equals("0")) {
//							dianhua = dataRow.getDataElement("qtye").getString();
//						}
						cell = new Cell(dianhua);
						row.addCell(cell);
						continue;
					}
					if (key.trim().equals("fenguangD")) {
						String fenguangD = dataRow.getDataElement(key).getString();
						String bdfenguang = dataRow.getDataElement("bdfenguang").getString();
						String yjfenguang = dataRow.getDataElement("yjfenguang").getString();
						cell = new Cell(fenguangD);
						if(fenguangD.equals(bdfenguang)) {
							cell.setCellStyle(biduistyle, pgdworkbook);
						}else if(fenguangD.equals(yjfenguang)) {
							cell.setCellStyle(yichustyle, pgdworkbook);
						}
						row.addCell(cell);
						continue;
					}
					if (key.trim().equals("onumacD")) {
						String onumacD = dataRow.getDataElement(key).getString();
						String bdonumac = dataRow.getDataElement("bdonumac").getString();
						String yjonumac = dataRow.getDataElement("yjonumac").getString();
						cell = new Cell(onumacD);
						if(onumacD.equals(bdonumac)) {
							cell.setCellStyle(biduistyle, pgdworkbook);
						}else if(onumacD.equals(yjonumac)) {
							cell.setCellStyle(yichustyle, pgdworkbook);
						}
						row.addCell(cell);
						continue;
					}
					if (key.trim().equals("stbmcidD")) {
						String stbmcidD = dataRow.getDataElement(key).getString();
						String bdstbmcid = dataRow.getDataElement("bdstbmcid").getString();
						String yjstbmcid = dataRow.getDataElement("yjstbmcid").getString();
						cell = new Cell(stbmcidD);
						if(stbmcidD.equals(bdstbmcid)) {
							cell.setCellStyle(biduistyle, pgdworkbook);
						}else if(stbmcidD.equals(yjstbmcid)) {
							cell.setCellStyle(yichustyle, pgdworkbook);
						}
						row.addCell(cell);
						continue;
					}
					if (key.trim().equals("dianshiipD")) {
						String dianshiipD = dataRow.getDataElement(key).getString();
						String bddianshiip = dataRow.getDataElement("bddianshiip").getString();
						String yjdianshiip = dataRow.getDataElement("yjdianshiip").getString();
						cell = new Cell(dianshiipD);
						if(dianshiipD.equals(bddianshiip)) {
							cell.setCellStyle(biduistyle, pgdworkbook);
						}else if(dianshiipD.equals(yjdianshiip)) {
							cell.setCellStyle(yichustyle, pgdworkbook);
						}
						row.addCell(cell);
						continue;
					}
					if (key.trim().equals("beizhu")) {
						String beizhu = dataRow.getDataElement(key).getString();
						
						if (!kaipiaoxinxi.trim().equals("") && kaipiaoxinxi != null) {
							beizhu = beizhu + "(开票信息：" +kaipiaoxinxi + ")";
						}
						cell = new Cell(beizhu);
						row.addCell(cell);
						continue;
					}
					if(key.trim().equals("onu")){
						String onu = dataRow.getDataElement(key).getString();
						String jiaohuanji = dataRow.getDataElement("jiaohuanji").getString();
						if(xiaoquname.equals("天欣花园")){
							onu = jiaohuanji ; 
						}
						cell = new Cell(onu);
						row.addCell(cell);
						continue;
					}
					
					DataElement dataElement = dataRow.getDataElement(key);
					
					switch(type){
					case Cell.TYPE_STRING:
						cell = new Cell(dataElement.getString());
						break;
					case Cell.TYPE_INTEGER:
						if(Common.isNull(dataElement.getString())){
							cell = new Cell(dataElement.getString());
						}else{
							cell = new Cell(dataElement.getInt());
						}
						break;
					case Cell.TYPE_DOUBLE:
						if(Common.isNull(dataElement.getString())){
							cell = new Cell(dataElement.getString());
						}else{
							cell = new Cell(dataElement.getDouble());
						}
						break;
					}
					row.addCell(cell);
				}
				rows.add(row);
			}
		}
		return rows;
	}
}
