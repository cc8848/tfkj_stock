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
	 *  Ϊ2013-3-21ҵ���������������������ˣ�lhh
	 *  i.	���������н���ʱ������ɾ������ʱ������Ϣ������ҵ�����С�
	 *	ii.	����������Ӫ�̡��ġ��ײ���Ϣ��������䵽��ҵ���У�Ҳͬʱ�������绰���С�
	 *	i.	����û�ͬʱһ�����롰������͡�������Ӫ�̡���ҵ��ҵ����Ҫͬʱ���ڡ�ʱ�����͡��ײ���Ϣ�����м��á�/��������
	 *	ii.	�����ı��н�����Ʊ��Ϣ����ɾ���������е�������������ע���У�ע�ⲻҪ����������Ϣ�����ݡ�
	 *
	 *	2013-4-27ҵ�������޸ķ������޸��ˣ�lhh
	 *	�����������������µġ����������������С��������������ġ���װ�������еġ�ҵ�����еġ�����ʱ������4�����Ӻ�һ�����ɾ����
	 *	������11����ѡ�ʷ���ѡ����Զ���ӵ�ҵ��������ǰ����Ϣ�á�/��������
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
				
					//ҵ��
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
							yewu = yewu + "/(��Ӫ�̣�" +yunyingshang + ")";
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
							beizhu = beizhu + "(��Ʊ��Ϣ��" +kaipiaoxinxi + ")";
						}
						cell = new Cell(beizhu);
						row.addCell(cell);
						continue;
					}
					if(key.trim().equals("onu")){
						String onu = dataRow.getDataElement(key).getString();
						String jiaohuanji = dataRow.getDataElement("jiaohuanji").getString();
						if(xiaoquname.equals("������԰")){
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
