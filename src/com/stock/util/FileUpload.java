package com.stock.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts.upload.FormFile;

import Decoder.BASE64Encoder;

/**
 * 上传文件
 * 创建人：代震 创建时间：2015年12月31日
 * @version
 */
public class FileUpload {

	/**
	 * @param file 			//文件对象
	 * @param filePath		//上传路径
	 * @param fileName		//文件名
	 * @return  文件名
	 */
	public static String fileUp(FormFile file, String filePath, String fileName){
		String extName = ""; // 扩展名格式：
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
	 * 写文件到当前目录的upload目录中
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
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     * @param imgSrcPath 生成64编码的图片的路径
     * @return
     */
    public static String getImageStr(String imgSrcPath){
        InputStream in = null;
        byte[] data = null;
        
        //读取图片字节数组
        try {
            in = new FileInputStream(imgSrcPath);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }
}
