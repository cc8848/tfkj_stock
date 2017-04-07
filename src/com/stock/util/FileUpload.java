package com.stock.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts.upload.FormFile;

import Decoder.BASE64Encoder;

/**
 * �ϴ��ļ�
 * �����ˣ����� ����ʱ�䣺2015��12��31��
 * @version
 */
public class FileUpload {

	/**
	 * @param file 			//�ļ�����
	 * @param filePath		//�ϴ�·��
	 * @param fileName		//�ļ���
	 * @return  �ļ���
	 */
	public static String fileUp(FormFile file, String filePath, String fileName){
		String extName = ""; // ��չ����ʽ��
		try {
			if (file.getFileName().lastIndexOf(".") >= 0){
				extName = file.getFileName().substring(file.getFileName().lastIndexOf("."));
			}
			copyFile(file.getInputStream(), filePath, fileName+extName).replaceAll("-", "");
		} catch (IOException e) {
			System.out.println(e);
		}
		return fileName+extName;
	}
	
	/**
	 * д�ļ�����ǰĿ¼��uploadĿ¼��
	 * 
	 * @param in
	 * @param fileName
	 * @throws IOException
	 */
	private static String copyFile(InputStream in, String dir, String realName)
			throws IOException {
		File file = new File(dir, realName);
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		FileUtils.copyInputStreamToFile(in, file);
		return realName;
	}
	  /**
     * ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
     * @param imgSrcPath ����64�����ͼƬ��·��
     * @return
     */
    public static String getImageStr(String imgSrcPath){
        InputStream in = null;
        byte[] data = null;
        
        //��ȡͼƬ�ֽ�����
        try {
            in = new FileInputStream(imgSrcPath);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //���ֽ�����Base64����
        BASE64Encoder encoder = new BASE64Encoder();
        
        return encoder.encode(data);//����Base64��������ֽ������ַ���
    }
}
