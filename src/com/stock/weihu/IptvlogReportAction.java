package com.stock.weihu;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.stock.transfer.BusinessDefaultExportAdapter;
import com.stock.transfer.BusinessExportAction;
import com.takucin.aceeci.excel.Excel;
import com.takucin.aceeci.transfer.TransferEvent;

public class IptvlogReportAction extends BusinessExportAction{
	
	IptvlogReportService service = new IptvlogReportService();
	
	public IptvlogReportAction(){
		this.setExportAdapter(new BusinessDefaultExportAdapter(){
			
			public Excel getExcel(TransferEvent e) throws Exception {
				IptvlogEidtForm form = new IptvlogEidtForm();
				String tingjishijian = e.getRequest().getParameter("tingjishijian");
				String tingjizhanghao = e.getRequest().getParameter("tingjizhanghao");
				String shifouchenggong = e.getRequest().getParameter("shifouchenggong");
				tingjizhanghao = URLDecoder.decode(tingjizhanghao,"utf-8");
				shifouchenggong = URLDecoder.decode(shifouchenggong,"utf-8");
				form.setTingjishijian(tingjishijian);
				form.setTingjizhanghao(tingjizhanghao);
				form.setShifouchenggong(shifouchenggong);
				return service.getExportExcel(form);
			}

			
			/**
			 * utf8 编码输出
			 * @param s
			 * @return
			 */
			public  String toUtf8String(String s) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < s.length(); i++) {
					char c = s.charAt(i);
					if (c >= 0 && c <= 255) {
						sb.append(c);
					} else {
						byte[] b;
						try {
							b = Character.toString(c).getBytes("utf-8");
						} catch (Exception ex) {
							System.out.println(ex);
							b = new byte[0];
						}
						for (int j = 0; j < b.length; j++) {
							int k = b[j];
							if (k < 0)
								k += 256;
							sb.append("%" + Integer.toHexString(k).toUpperCase());
						}
					}
				}
				return sb.toString();
			}
			
			
			public String getFileName(TransferEvent e) {
				// TODO Auto-generated method stub
				String xiangmu="iptv接口日志";
				String name = xiangmu;
				try {
					name=new String(name.getBytes("GBK"),"ISO-8859-1");//解决文件中文名称问题
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return name+".xls"; 
			}
		});
		
	}
}
