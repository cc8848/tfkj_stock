package com.stock.paigongdan;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.stock.transfer.BusinessDefaultExportAdapter;
import com.stock.transfer.BusinessExportAction;
import com.takucin.aceeci.excel.Excel;
import com.takucin.aceeci.transfer.TransferEvent;

public class HuidanPreImportReportAction extends BusinessExportAction{
	HuidanPreImportService  service = new HuidanPreImportService();
	public HuidanPreImportReportAction(){
		this.setExportAdapter(new BusinessDefaultExportAdapter(){

			public Excel getExcel(TransferEvent e) throws Exception {
				PaiGongDanPreImportForm form = new PaiGongDanPreImportForm();
				String pgri = e.getRequest().getParameter("paigongriqi");
				String xiaoqu = e.getRequest().getParameter("xiaoqu");
				xiaoqu = URLDecoder.decode(xiaoqu,"utf-8");
				form.setPaigongriqis(pgri);
				form.setXiaoqu(xiaoqu);
				return service.getExportExcel(form);
			}
			public String getFileName(TransferEvent e) {
				String pgri = e.getRequest().getParameter("paigongriqi");
				String xiangmu="��װ����-";
				String name = xiangmu+pgri;
				try {
					name=new String(name.getBytes("GBK"),"ISO-8859-1");//����ļ�������������
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				return name+".xls"; 
			}
		});
	}
	
}
