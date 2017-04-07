package com.takucin.aceeci.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 这是一个通用处理的工具类.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class Common {

	/**
	 * 向左填充标识.
	 */
	public static final int FILL_LEFT = 0;

	/**
	 * 向右填充标识.
	 */
	public static final int FILL_RIGHT = 1;

	public static final String DATE_FORMAT_ORCL = "yyyy-MM-dd HH:mm:ss.S";
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_MINI = "yyyyMMdd";
	public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";

	private Common() {

	}

	/**
	 * 判断一个字符串是否为null或者是空字符串.
	 * 
	 * @param value
	 *            一个字符串.
	 * @return 如果传入的字符串是null，或者是一个空字符串，那么返回true，否则返回false.
	 */
	public static boolean isNull(String value) {
		if (value == null || value.equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * 计算字符长度的方法，全角代表两个字符长度.
	 * 
	 * @param str
	 *            一个字符串值.
	 * @return 如果该字符串包含全角，返回全角按两个字符计算的长度值.
	 */

	public static int length(String str) throws UnsupportedEncodingException {

		str = new String(str.getBytes("GBK"), "ISO8859_1");
		return str.length();
	}

	/**
	 * 此方法返回一个指定位数的字符串，如果给定字符串小于执行位数，则使用空格右填充.
	 * 
	 * @param str
	 *            待填充的字符串.
	 * @param dight
	 *            字符串的固定位数.
	 * @return 返回使用空格右填充的字符串.
	 */
	public static String fillText(String str, int dight) {
		return fillText(str, dight, " ", FILL_RIGHT);
	}

	/**
	 * 此方法返回一个指定位数的字符串，如果给定字符串小于执行位数，则使用ft参数填充.
	 * 
	 * @param str
	 *            待填充的字符串.
	 * @param dight
	 *            字符串的固定位数.
	 * @param ft
	 *            如果指定字符串小于固定位数，那么每一位填充的值.
	 * @param lor
	 *            填充方向，左填充或者右填充.
	 * @return 返回使用ft参数以填充的字符串.
	 */
	public static String fillText(String str, int dight, String ft, int lor) {

		StringBuilder fillText = new StringBuilder("");

		for (int i = 0; i < (dight - str.length()); i++) {
			fillText.append(ft);
		}

		if (lor == FILL_RIGHT) {
			return new StringBuilder(str).append(fillText).toString();
		} else {
			return fillText.append(str).toString();
		}
	}
	
	/**
	 * 将一个表示日期的字符串按照格式化字符串格式化为日期.
	 * 
	 * @param date 一个表示日期的字符串.
	 * @param fmt 日期的格式化字符串.
	 * @return 返回一个日期对象.
	 * @throws ParseException 如果格式化过程中发生错误.
	 */
	public static Date parseDate(String date,String fmt) throws ParseException {
		return new SimpleDateFormat(fmt).parse(date);
	}
	
	/**
	 * 将一个日期类型的对象按照指定的格式格式化为一个字符串.
	 * 
	 * @param date 一个日期对象.
	 * @param fmt 日期的格式化字符串.
	 * @return 一个日期字符串.
	 * @throws ParseException 如果格式化过程中发生错误.
	 */
	public static String formatDate(Date date,String fmt) throws ParseException {
		return new SimpleDateFormat(fmt).format(date);
	}
	
	/**
	 * 将一个日期字符串按照sourceFmt转换成日期，并且按照targetFmt，再次转换成一个字符串.
	 * 
	 * @param date 一个表示日期的字符串.
	 * @param sourceFmt 源日期格式化字符串.
	 * @param targetFmt 目标日期格式化字符串.
	 * @return 一个日期字符串.
	 * @throws ParseException 如果格式化过程中发生错误.
	 */
	public static String formatDate(String date,String sourceFmt,String targetFmt) throws ParseException {
		return new SimpleDateFormat(targetFmt).format(new SimpleDateFormat(sourceFmt).parse(date));
	}
	
	public static String getDate(String fmt){
		return new SimpleDateFormat(fmt).format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 获取时间
	 * @return 已格式化日期(yyyyMMddHHmmss)
	 */
	public static String getTime()
	{
		String s = "";
		Calendar d = Calendar.getInstance();
		Date date = d.getTime();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		long startTime = System.nanoTime();
		long estimatedTime = System.nanoTime() - startTime;
		s = time.format(date) + String.valueOf(estimatedTime);
		
		return s;
	}
	
	public static void main(String[] args){
		System.out.println(Common.getDate(Common.DATE_FORMAT_DATE));
	}
}
