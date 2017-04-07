package com.takucin.aceeci.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ������һ�������㷨�࣬Ŀǰ�ṩMD5����.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public final class Encrypt {

	/**
	 * �����ֹʵ������ʶ.
	 */
	private Encrypt() {
	}
	
	/**
	 * ��һ���ַ���ʹ��MD5���ܲ�����.
	 * 
	 * @param value
	 *            �����ܵ��ַ���.
	 * @return ����ʹ��MD5�㷨���ܵ��ֽڴ�����.
	 */
	public static String getMD5Message(String value) {

		// ����ʮ����������.
		String hexSequence = "0123456789ABCDEF";

		// ����ת�����ַ����ֽ�Ϊ�ֽڴ�.
		byte[] prepareMessage = value.getBytes();

		// ����ʵ��MD5ժҪ�㷨�� MessageDigest ����.
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// ʹ��ָ�����ֽڴ����´�ժҪ.
		md.update(prepareMessage);
		// ��ɹ�ϣ����.
		byte[] newMessage = md.digest();

		// ������ֽڴ��ĳ���.
		int length = newMessage.length;
		// �������շ��ص��ֽڴ�.
		char[] message = new char[length * 2];
		// ����Ϊ�����ֽڴ���ֵ������.
		int index = 0;
		// ѭ���������ֽڴ���ÿһλ���任��׷���������ֽڴ�.
		for (int i = 0; i < length; i++) {
			message[index++] = hexSequence.charAt(newMessage[i] >>> 4 & 0xf);
			message[index++] = hexSequence.charAt(newMessage[i] & 0xf);
		}
		// ���ؾ���MD5���ܵ������ֽڴ�.
		return new String(message);
	}
	
	public static void main(String[] args){
		System.out.println(getMD5Message("3"));
	}
}