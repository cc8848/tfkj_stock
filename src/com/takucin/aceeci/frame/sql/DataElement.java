package com.takucin.aceeci.frame.sql;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

import com.takucin.aceeci.util.Common;

/**
 * 数据元素对象，每个对象都是DataRow对象的一列.
 */
public class DataElement {

	private String cloumnName;		// 列标识.
	private String columnValue;		// 列值.

	/**
	 * 创建一个DataElement对象.
	 */
	public DataElement() {

	}

	/**
	 * 根据cloumnName和columnValue初始化一个DataElement对象.
	 * 
	 * @param cloumnName 列标识.
	 * @param columnValue 列值.
	 */
	public DataElement(String cloumnName, String columnValue) {
		this.cloumnName = cloumnName;
		this.columnValue = columnValue;
	}

	public String getCloumnName() {
		return cloumnName;
	}

	/**
	 * 设置列标识.
	 * 
	 * @param cloumnName 列标识.
	 */
	public void setCloumnName(String cloumnName) {
		this.cloumnName = cloumnName;
	}
	/**
	 * 设置列值.
	 * 
	 * @param columnValue 列值.
	 */
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}

	/**
	 * 返回列值的字符串表现形式.
	 * 
	 * @return 列值的字符串表现形式.
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
	 * 返回列值的双精度浮点型表现形式.
	 * 
	 * @return 列值的双精度浮点型表现形式.
	 */
	public double getDouble(){
		String value = new DecimalFormat("0.########").format(Double.parseDouble(columnValue));
		return Double.parseDouble(value);
	}
	
	/**
	 * 返回列值的单精度浮点型表现形式.
	 * 
	 * @return 列值的单精度浮点型表现形式.
	 */
	public float getFloat(){
		String value = new DecimalFormat("0.########").format(Float.parseFloat(columnValue));
		return Float.parseFloat(value);
	}
	
	/**
	 * 返回列值的整型表现形式.
	 * 
	 * @return 列值的整型表现形式.
	 */
	public int getInt(){
		return Integer.parseInt(columnValue);
	}
	
	/**
	 * 返回列值的长整型表现形式.
	 * 
	 * @return 列值的长整型表现形式.
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
