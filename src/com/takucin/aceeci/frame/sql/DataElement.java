package com.takucin.aceeci.frame.sql;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

import com.takucin.aceeci.util.Common;

/**
 * ����Ԫ�ض���ÿ��������DataRow�����һ��.
 */
public class DataElement {

	private String cloumnName;		// �б�ʶ.
	private String columnValue;		// ��ֵ.

	/**
	 * ����һ��DataElement����.
	 */
	public DataElement() {

	}

	/**
	 * ����cloumnName��columnValue��ʼ��һ��DataElement����.
	 * 
	 * @param cloumnName �б�ʶ.
	 * @param columnValue ��ֵ.
	 */
	public DataElement(String cloumnName, String columnValue) {
		this.cloumnName = cloumnName;
		this.columnValue = columnValue;
	}

	public String getCloumnName() {
		return cloumnName;
	}

	/**
	 * �����б�ʶ.
	 * 
	 * @param cloumnName �б�ʶ.
	 */
	public void setCloumnName(String cloumnName) {
		this.cloumnName = cloumnName;
	}
	/**
	 * ������ֵ.
	 * 
	 * @param columnValue ��ֵ.
	 */
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}

	/**
	 * ������ֵ���ַ���������ʽ.
	 * 
	 * @return ��ֵ���ַ���������ʽ.
	 */
	public String getString() {
		try{
			if(Common.isNull(columnValue)){
				return columnValue;
			}
			if(columnValue.matches("0+\\d*")){
				return columnValue;
			}
			if(columnValue.matches("-?\\d*[.]\\d+")){
				return new DecimalFormat("0.########").format(Double.parseDouble(columnValue));
			}
			return columnValue;
		}catch(NumberFormatException e){
			return columnValue;
		}
	}

	/**
	 * ������ֵ��˫���ȸ����ͱ�����ʽ.
	 * 
	 * @return ��ֵ��˫���ȸ����ͱ�����ʽ.
	 */
	public double getDouble(){
		String value = new DecimalFormat("0.########").format(Double.parseDouble(columnValue));
		return Double.parseDouble(value);
	}
	
	/**
	 * ������ֵ�ĵ����ȸ����ͱ�����ʽ.
	 * 
	 * @return ��ֵ�ĵ����ȸ����ͱ�����ʽ.
	 */
	public float getFloat(){
		String value = new DecimalFormat("0.########").format(Float.parseFloat(columnValue));
		return Float.parseFloat(value);
	}
	
	/**
	 * ������ֵ�����ͱ�����ʽ.
	 * 
	 * @return ��ֵ�����ͱ�����ʽ.
	 */
	public int getInt(){
		return Integer.parseInt(columnValue);
	}
	
	/**
	 * ������ֵ�ĳ����ͱ�����ʽ.
	 * 
	 * @return ��ֵ�ĳ����ͱ�����ʽ.
	 */
	public long getLong(){
		return Long.parseLong(columnValue);
	}
	
	public Date getDate() throws ParseException{
		Date date = null;
		try{
			date = Common.parseDate(columnValue, Common.DATE_FORMAT_ORCL);
		}catch(ParseException e){
			throw e;
		}
		return date;
	}
	
	public String getConverString(String type) throws Exception{
		
		Object converter = Class.forName(type).newInstance();
		Method method = converter.getClass().getMethod("conver", new Class[]{String.class});
		Object object = method.invoke(converter, new Object[]{columnValue});
		
		return (String)object;
	}
}
