package com.takucin.aceeci.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ����һ��ͨ�ô���Ĺ�����.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class Common {

	/**
	 * ��������ʶ.
	 */
	public static final int FILL_LEFT = 0;

	/**
	 * ��������ʶ.
	 */
	public static final int FILL_RIGHT = 1;

	public static final String DATE_FORMAT_ORCL = "yyyy-MM-dd HH:mm:ss.S";
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_MINI = "yyyyMMdd";
	public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";

	private Common() {

	}

	/**
	 * �ж�һ���ַ����Ƿ�Ϊnull�����ǿ��ַ���.
	 * 
	 * @param value
	 *            һ���ַ���.
	 * @return ���������ַ�����null��������һ�����ַ�������ô����true�����򷵻�false.
	 */
	public static boolean isNull(String value) {
		if (value == null || value.equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * �����ַ����ȵķ�����ȫ�Ǵ��������ַ�����.
	 * 
	 * @param str
	 *            һ���ַ���ֵ.
	 * @return ������ַ�������ȫ�ǣ�����ȫ�ǰ������ַ�����ĳ���ֵ.
	 */

	public static int length(String str) throws UnsupportedEncodingException {

		str = new String(str.getBytes("GBK"), "ISO8859_1");
		return str.length();
	}

	/**
	 * �˷�������һ��ָ��λ�����ַ�������������ַ���С��ִ��λ������ʹ�ÿո������.
	 * 
	 * @param str
	 *            �������ַ���.
	 * @param dight
	 *            �ַ����Ĺ̶�λ��.
	 * @return ����ʹ�ÿո��������ַ���.
	 */
	public static String fillText(String str, int dight) {
		return fillText(str, dight, " ", FILL_RIGHT);
	}

	/**
	 * �˷�������һ��ָ��λ�����ַ�������������ַ���С��ִ��λ������ʹ��ft�������.
	 * 
	 * @param str
	 *            �������ַ���.
	 * @param dight
	 *            �ַ����Ĺ̶�λ��.
	 * @param ft
	 *            ���ָ���ַ���С�ڹ̶�λ������ôÿһλ����ֵ.
	 * @param lor
	 *            ��䷽���������������.
	 * @return ����ʹ��ft�����������ַ���.
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
	 * ��һ����ʾ���ڵ��ַ������ո�ʽ���ַ�����ʽ��Ϊ����.
	 * 
	 * @param date һ����ʾ���ڵ��ַ���.
	 * @param fmt ���ڵĸ�ʽ���ַ���.
	 * @return ����һ�����ڶ���.
	 * @throws ParseException �����ʽ�������з�������.
	 */
	public static Date parseDate(String date,String fmt) throws ParseException {
		return new SimpleDateFormat(fmt).parse(date);
	}
	
	/**
	 * ��һ���������͵Ķ�����ָ���ĸ�ʽ��ʽ��Ϊһ���ַ���.
	 * 
	 * @param date һ�����ڶ���.
	 * @param fmt ���ڵĸ�ʽ���ַ���.
	 * @return һ�������ַ���.
	 * @throws ParseException �����ʽ�������з�������.
	 */
	public static String formatDate(Date date,String fmt) throws ParseException {
		return new SimpleDateFormat(fmt).format(date);
	}
	
	/**
	 * ��һ�������ַ�������sourceFmtת�������ڣ����Ұ���targetFmt���ٴ�ת����һ���ַ���.
	 * 
	 * @param date һ����ʾ���ڵ��ַ���.
	 * @param sourceFmt Դ���ڸ�ʽ���ַ���.
	 * @param targetFmt Ŀ�����ڸ�ʽ���ַ���.
	 * @return һ�������ַ���.
	 * @throws ParseException �����ʽ�������з�������.
	 */
	public static String formatDate(String date,String sourceFmt,String targetFmt) throws ParseException {
		return new SimpleDateFormat(targetFmt).format(new SimpleDateFormat(sourceFmt).parse(date));
	}
	
	public static String getDate(String fmt){
		return new SimpleDateFormat(fmt).format(Calendar.getInstance().getTime());
	}
	
	/**
	 * ��ȡʱ��
	 * @return �Ѹ�ʽ������(yyyyMMddHHmmss)
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
