package com.takucin.aceeci.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 此类是一个加密算法类，目前提供MD5加密.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public final class Encrypt {

	/**
	 * 此类禁止实例化标识.
	 */
	private Encrypt() {
	}
	
	/**
	 * 将一个字符串使用MD5加密并返回.
	 * 
	 * @param value
	 *            待加密的字符串.
	 * @return 返回使用MD5算法加密的字节串序列.
	 */
	public static String getMD5Message(String value) {

		// 定义十六进制序列.
		String hexSequence = "0123456789ABCDEF";

		// 将待转换的字符串分解为字节串.
		byte[] prepareMessage = value.getBytes();

		// 生成实现MD5摘要算法的 MessageDigest 对象.
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 使用指定的字节串更新此摘要.
		md.update(prepareMessage);
		// 完成哈希计算.
		byte[] newMessage = md.digest();

		// 获得新字节串的长度.
		int length = newMessage.length;
		// 定义最终返回的字节串.
		char[] message = new char[length * 2];
		// 定义为最终字节串赋值的索引.
		int index = 0;
		// 循环遍历新字节串的每一位，变换后追加至最终字节串.
		for (int i = 0; i < length; i++) {
			message[index++] = hexSequence.charAt(newMessage[i] >>> 4 & 0xf);
			message[index++] = hexSequence.charAt(newMessage[i] & 0xf);
		}
		// 返回经过MD5加密的最终字节串.
		return new String(message);
	}
	
	public static void main(String[] args){
		System.out.println(getMD5Message("3"));
	}
}