package com.stock.huidan;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;

public class HuidanReportService extends BusinessService{

	private CommonDao dao = new CommonDao();
	public void daochu(HuidanForm form,HttpServletResponse response,String dir)throws Exception{
		Calendar d = Calendar.getInstance();
		Date date = d.getTime();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date now = java.sql.Date.valueOf(time.format(date));
		dir = java.net.URLDecoder.decode(dir,"utf-8");
		dir=dir+"/report/";
		String templatePath = dir + "hdtj.xls";// 模板文件名
		String mtemplatePath = dir + "temp/hdtj" + now + ".xls";// 模板文件名
		OutputStream os = response.getOutputStream();// 取得输出流
		response.reset();// 清空输出流
		response.setContentType("application/msexcel");// 定义输出类型
		File tf = new File(templatePath);// 创建模板文件对象
		File tFile = new File(mtemplatePath);// 创建模板文件对象
		String filename = "打印模板";
		response.setHeader("Content-Disposition", "inline; filename=" + filename+ now  + ".xls");
		response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + now + ".xls");
		// 模板工作簿对象
		
		DataSet<DataRow> dateSet = getResult(form);
		if(dateSet != null){
			Workbook tk = Workbook.getWorkbook(tf);
			WritableWorkbook wk = Workbook.createWorkbook(tFile, tk);
			WritableSheet wt = wk.getSheet(0);
			wk.write();
			wk.close();
			tk.close();
			Workbook tBook = Workbook.getWorkbook(tFile);
			WritableWorkbook wbook = Workbook.createWorkbook(os, tBook);
			WritableSheet wsheet = wbook.getSheet(0);
			for(int i=0;i<dateSet.size();i++){
				DataRow dataRow = dateSet.get(i);
				String yonghuzhuangtai = dataRow.getDataElement("yonghuzhuangtai").getString();
				String shoukuanshijian = dataRow.getDataElement("shoukuanshijian").getString();
				String xingming = dataRow.getDataElement("xingming").getString();
				String shenfenzheng = dataRow.getDataElement("shenfenzheng").getString();
				String shoujuhao = dataRow.getDataElement("shoujuhao").getString();
				String fenguangxianhao = dataRow.getDataElement("fenguangxianhao").getString();
				String jiexuweizhi = dataRow.getDataElement("jiexuweizhi").getString();
				String kaijishijian = dataRow.getDataElement("kaijishijian").getString();
				String tingjishijian = dataRow.getDataElement("tingjishijian").getString();
				String xiaoqu = dataRow.getDataElement("xiaoqu").getString();
				String dizhi = dataRow.getDataElement("dizhi").getString();
				String lianxidianhua = dataRow.getDataElement("lianxidianhua").getString();
				String wangluo = dataRow.getDataElement("wangluo").getString();
				String dianshi = dataRow.getDataElement("dianshi").getString();
				String dianhua = dataRow.getDataElement("dianhua").getString();
				String yewu = dataRow.getDataElement("yewu").getString();
				String fenguang = dataRow.getDataElement("fenguang").getString();
				String onumac = dataRow.getDataElement("onumac").getString();
				String stbmcid = dataRow.getDataElement("stbmcid").getString();
				String dianshiip = dataRow.getDataElement("dianshiip").getString();
				String wangluoip = dataRow.getDataElement("wangluoip").getString();
				String dianhuaip = dataRow.getDataElement("dianhuaip").getString();
				String dianhuavlan = dataRow.getDataElement("dianhuavlan").getString();
				String wangluovlan = dataRow.getDataElement("wangluovlan").getString();
				String shangmenshijian = dataRow.getDataElement("shangmenshijian").getString();
				String danzheng = dataRow.getDataElement("danzheng").getString();
				String sxdhhm = dataRow.getDataElement("sxdhhm").getString();
				String onuyj = dataRow.getDataElement("onuyj").getString();
				String jidingheyj = dataRow.getDataElement("jidingheyj").getString();
				String shoushifei = dataRow.getDataElement("shoushifei").getString();
				String kuandaifei = dataRow.getDataElement("kuandaifei").getString();
				String chuzhuangfei = dataRow.getDataElement("chuzhuangfei").getString();
				String shebeixiaoshou = dataRow.getDataElement("shebeixiaoshou").getString();
				String cailiaofei = dataRow.getDataElement("cailiaofei").getString();
				String yunyingshang = dataRow.getDataElement("yunyingshang").getString();
				String bzygf = dataRow.getDataElement("bzygf").getString();
				String nianfei = dataRow.getDataElement("nianfei").getString();
				String beizhu = dataRow.getDataElement("beizhu").getString();
				String zongshoufei = dataRow.getDataElement("zongshoufei").getString();
				String shoujubenhao = dataRow.getDataElement("shoujubenhao").getString();
				String kaipiaoxinxi = dataRow.getDataElement("kaipiaoxinxi").getString();
				String qtsbsyqk = dataRow.getDataElement("qtsbsyqk").getString();
				String qitahaocai = dataRow.getDataElement("qitahaocai").getString();
				String jiexianzi = dataRow.getDataElement("jiexianzi").getString();
				String rj11 = dataRow.getDataElement("rj11").getString();
				String rj45 = dataRow.getDataElement("rj45").getString();
				String mokuai = dataRow.getDataElement("mokuai").getString();
				String mianban = dataRow.getDataElement("mianban").getString();
				String wangxian = dataRow.getDataElement("wangxian").getString();
				String shigongren = dataRow.getDataElement("shigongren").getString();
				String xianchangbeizhu = dataRow.getDataElement("xianchangbeizhu").getString();
				String beizhuhuizong = dataRow.getDataElement("beizhuhuizong").getString();
			
				int j = i+1;
					
					wsheet.addCell(new Label(3,j,yonghuzhuangtai));
					wsheet.addCell(new Label(4,j,shoukuanshijian));
					wsheet.addCell(new Label(5,j,xingming));
					wsheet.addCell(new Label(6,j,shenfenzheng));
					wsheet.addCell(new Label(7,j,shoujuhao));
					wsheet.addCell(new Label(8,j,fenguangxianhao));
					wsheet.addCell(new Label(9,j,jiexuweizhi));
					wsheet.addCell(new Label(10,j,kaijishijian));
					wsheet.addCell(new Label(11,j,tingjishijian));
					wsheet.addCell(new Label(12,j,xiaoqu));
					wsheet.addCell(new Label(13,j,dizhi));
					wsheet.addCell(new Label(14,j,lianxidianhua));
					wsheet.addCell(new Label(15,j,wangluo));
					wsheet.addCell(new Label(16,j,dianshi));
					wsheet.addCell(new Label(17,j,dianhua));
					wsheet.addCell(new Label(18,j,yewu));
					wsheet.addCell(new Label(19,j,fenguang));
					wsheet.addCell(new Label(20,j,onumac));
					wsheet.addCell(new Label(21,j,stbmcid));
					wsheet.addCell(new Label(22,j,dianshiip));
					wsheet.addCell(new Label(23,j,wangluoip));
					wsheet.addCell(new Label(24,j,dianhuaip));
					wsheet.addCell(new Label(25,j,dianhuavlan));
					wsheet.addCell(new Label(26,j,wangluovlan));
					wsheet.addCell(new Label(27,j,shangmenshijian));
					wsheet.addCell(new Label(28,j,danzheng));
					wsheet.addCell(new Label(29,j,sxdhhm));
					wsheet.addCell(new Label(30,j,onuyj));
					wsheet.addCell(new Label(31,j,jidingheyj));
					wsheet.addCell(new Label(32,j,shoushifei));
					wsheet.addCell(new Label(33,j,kuandaifei));
					wsheet.addCell(new Label(34,j,chuzhuangfei));
					wsheet.addCell(new Label(35,j,shebeixiaoshou));
					wsheet.addCell(new Label(36,j,cailiaofei));
					wsheet.addCell(new Label(37,j,yunyingshang));
					wsheet.addCell(new Label(38,j,bzygf));
					wsheet.addCell(new Label(39,j,nianfei));
					wsheet.addCell(new Label(40,j,beizhu));
					wsheet.addCell(new Label(41,j,zongshoufei));
					wsheet.addCell(new Label(42,j,shoujubenhao));
					wsheet.addCell(new Label(43,j,kaipiaoxinxi));
					wsheet.addCell(new Label(44,j,qtsbsyqk));
					wsheet.addCell(new Label(45,j,qitahaocai));
					wsheet.addCell(new Label(46,j,jiexianzi));
					wsheet.addCell(new Label(47,j,rj11));
					wsheet.addCell(new Label(48,j,rj45));
					wsheet.addCell(new Label(49,j,mokuai));
					wsheet.addCell(new Label(50,j,mianban));
					wsheet.addCell(new Label(51,j,wangxian));
					wsheet.addCell(new Label(52,j,shigongren));
					wsheet.addCell(new Label(53,j,xianchangbeizhu));
					wsheet.addCell(new Label(54,j,beizhuhuizong));
					
				
			}
			wbook.write();
			wbook.close();
			tBook.close();
		}
		
	}
	
	

	public DataSet<DataRow> getResult(HuidanForm form)throws Exception {
		ParameterSet set = new ParameterSet();
		String sqlString = "DaochuHuidan";
		String sqlstate = "";
		if (form.getUUIDS() != null) {
			String xqString = "";
			String str = form.getUUIDS()[0];
			String[] strings = str.split(",");
			for (int i = 0; i < strings.length; i++) {
				xqString += strings[i] + "','";
			}
			if (xqString.length() > 0) {
				sqlstate += " AND t.UUID in ('"
						+ xqString + "')";
			}
		}
		return dao.executeQuery(sqlString, set, sqlstate);	
		
	}
	
	
}
