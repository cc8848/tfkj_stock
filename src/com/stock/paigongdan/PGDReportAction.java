package com.stock.paigongdan;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.stock.transfer.BusinessDefaultExportAdapter;
import com.stock.transfer.BusinessExportAction;
import com.takucin.aceeci.excel.Excel;
import com.takucin.aceeci.transfer.TransferEvent;

public class PGDReportAction extends BusinessExportAction {

	PGDReportService service = new PGDReportService();

	public PGDReportAction() {
		this.setExportAdapter(new BusinessDefaultExportAdapter() {

			public Excel getExcel(TransferEvent e) throws Exception {
				PaiGongDanForm form = new PaiGongDanForm();
				String pgri = e.getRequest().getParameter("paigongriqi");
				String createdtCode = e.getRequest().getParameter(
						"createdtCode");
				createdtCode = URLDecoder.decode(createdtCode, "utf-8");
//				System.out.println("xiaoqu" + createdtCode);
				form.setPaigongriqis(pgri);
				form.setCreatebyCode(createdtCode);
				return service.getExportExcel(form);
			}

			/**
			 * utf8 编码输出
			 * 
			 * @param s
			 * @return
			 */
			public String toUtf8String(String s) {
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
							sb.append("%"
									+ Integer.toHexString(k).toUpperCase());
						}
					}
				}
				return sb.toString();
			}

			public String getFileName(TransferEvent e) {
				// TODO Auto-generated method stub
				// String pgri = e.getRequest().getParameter("paigongriqi");
				String xiangmu = "派工单";

				/*
				 * try { if(!xiangmu.equals("")){ xiangmu =
				 * URLDecoder.decode(xiangmu,"utf-8"); } } catch
				 * (UnsupportedEncodingException e1) { // TODO Auto-generated
				 * catch block e1.printStackTrace(); }
				 */
				String name = xiangmu;
				try {
					name = new String(name.getBytes("GBK"), "ISO-8859-1");// 解决文件中文名称问题
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return name + ".xls";
			}
		});

	}
}
