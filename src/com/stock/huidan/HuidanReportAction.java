package com.stock.huidan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class HuidanReportAction extends BusinessPaginationAction {
	
	HuidanReportService service = new HuidanReportService();

//	public void daochu(ActionForm form,HttpServletResponse response)throws Exception{
//		Calendar d = Calendar.getInstance();
//		Date date = d.getTime();
//		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
//		java.sql.Date now = java.sql.Date.valueOf(time.format(date));
//		String dir=request.getSession().getServletContext().getRealPath("/");
//		dir = java.net.URLDecoder.decode(dir,"utf-8");
//		dir=dir+"/report/";
//		String templatePath = dir + "hdtj.xls";// 模板文件名
//		String mtemplatePath = dir + "temp/hdtj" + now + ".xls";// 模板文件名
//		OutputStream os = response.getOutputStream();// 取得输出流
//		response.reset();// 清空输出流
//		response.setContentType("application/msexcel");// 定义输出类型
//		File tf = new File(templatePath);// 创建模板文件对象
//		File tFile = new File(mtemplatePath);// 创建模板文件对象
//		String filename = "回单提交导出表";
//		response.setHeader("Content-Disposition", "inline; filename=" + filename+ now  + ".xls");
//		response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + now + ".xls");
//		// 模板工作簿对象
//		Workbook tk = Workbook.getWorkbook(tf);
//		WritableWorkbook wk = Workbook.createWorkbook(tFile, tk);
//		WritableSheet wt = wk.getSheet(0);
//		HuidanForm f = (HuidanForm)form;
//		
//		DataSet<DataRow> dateSet = getResult(f);
//		if(dateSet != null){
//			for(int i=0;i<dateSet.size();i++){
//				DataRow dataRow = dateSet.get(i);
//				String yonghuzhuangtai = dataRow.getDataElement("yonghuzhuangtai").getString();
//				String shoukuanshijian = dataRow.getDataElement("shoukuanshijian").getString();
//				String xingming = dataRow.getDataElement("xingming").getString();
//				String shenfenzheng = dataRow.getDataElement("shenfenzheng").getString();
//				String shoujuhao = dataRow.getDataElement("shoujuhao").getString();
//				String fenguangxianhao = dataRow.getDataElement("fenguangxianhao").getString();
//				String jiexuweizhi = dataRow.getDataElement("jiexuweizhi").getString();
//				String kaijishijian = dataRow.getDataElement("kaijishijian").getString();
//				String tingjishijian = dataRow.getDataElement("tingjishijian").getString();
//				String xiaoqu = dataRow.getDataElement("xiaoqu").getString();
//				String dizhi = dataRow.getDataElement("dizhi").getString();
//				String lianxidianhua = dataRow.getDataElement("lianxidianhua").getString();
//				String wangluo = dataRow.getDataElement("wangluo").getString();
//				String dianshi = dataRow.getDataElement("dianshi").getString();
//				String dianhua = dataRow.getDataElement("dianhua").getString();
//				String yewu = dataRow.getDataElement("yewu").getString();
//				String fenguang = dataRow.getDataElement("fenguang").getString();
//				String onumac = dataRow.getDataElement("onumac").getString();
//				String stbmcid = dataRow.getDataElement("stbmcid").getString();
//				String dianshiip = dataRow.getDataElement("dianshiip").getString();
//				String wangluoip = dataRow.getDataElement("wangluoip").getString();
//				String dianhuaip = dataRow.getDataElement("dianhuaip").getString();
//				String dianhuavlan = dataRow.getDataElement("dianhuavlan").getString();
//				String wangluovlan = dataRow.getDataElement("wangluovlan").getString();
//				String shangmenshijian = dataRow.getDataElement("shangmenshijian").getString();
//				String danzheng = dataRow.getDataElement("danzheng").getString();
//				String sxdhhm = dataRow.getDataElement("sxdhhm").getString();
//				String onuyj = dataRow.getDataElement("onuyj").getString();
//				String jidingheyj = dataRow.getDataElement("jidingheyj").getString();
//				String shoushifei = dataRow.getDataElement("shoushifei").getString();
//				String kuandaifei = dataRow.getDataElement("kuandaifei").getString();
//				String chuzhuangfei = dataRow.getDataElement("chuzhuangfei").getString();
//				String shebeixiaoshou = dataRow.getDataElement("shebeixiaoshou").getString();
//				String cailiaofei = dataRow.getDataElement("cailiaofei").getString();
//				String yunyingshang = dataRow.getDataElement("yunyingshang").getString();
//				String bzygf = dataRow.getDataElement("bzygf").getString();
//				String nianfei = dataRow.getDataElement("nianfei").getString();
//				String beizhu = dataRow.getDataElement("beizhu").getString();
//				String zongshoufei = dataRow.getDataElement("zongshoufei").getString();
//				String shoujubenhao = dataRow.getDataElement("shoujubenhao").getString();
//				String kaipiaoxinxi = dataRow.getDataElement("kaipiaoxinxi").getString();
//				String qtsbsyqk = dataRow.getDataElement("qtsbsyqk").getString();
//				String qitahaocai = dataRow.getDataElement("qitahaocai").getString();
//				String jiexianzi = dataRow.getDataElement("jiexianzi").getString();
//				String rj11 = dataRow.getDataElement("rj11").getString();
//				String rj45 = dataRow.getDataElement("rj45").getString();
//				String mokuai = dataRow.getDataElement("mokuai").getString();
//				String mianban = dataRow.getDataElement("mianban").getString();
//				String wangxian = dataRow.getDataElement("wangxian").getString();
//				String shigongren = dataRow.getDataElement("shigongren").getString();
//				String xianchangbeizhu = dataRow.getDataElement("xianchangbeizhu").getString();
//				String beizhuhuizong = dataRow.getDataElement("beizhuhuizong").getString();
//			
//				for(int j=1;j<dateSet.size()+1;j++){
//					
//					wt.addCell(new Label(3,j,yonghuzhuangtai));
//				}
//				
//			}
//			
//		}
//		wk.write();
//		wk.close();
//		tk.close();
//	}
//	
//	
//
//	public DataSet<DataRow> getResult(HuidanForm form)throws Exception {
//		ParameterSet set = new ParameterSet();
//		String sqlString = "DaochuHuidan";
//		String sqlstate = "";
//		if (form.getUUIDS() != null) {
//			String xqString = "";
//			String[] strings = form.getUUIDS();
//			for (int i = 0; i < strings.length; i++) {
//				xqString += strings[i] + "','";
//			}
//			if (xqString.length() > 0) {
//				sqlstate += " AND t.UUID in ('"
//						+ xqString + "')";
//			}
//		}
//		return dao.executeQuery(sqlString, set, sqlstate);	
//		
//	}
		public  ActionForward daochu(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				HuidanForm f = (HuidanForm)form;
				String dir=request.getSession().getServletContext().getRealPath("/");
				service.daochu(f,response,dir);
				return mapping.findForward(FW_SUCCESS);
			}

		/**
		 * framework package method.
		 * 
		 * @param mapping
		 * @return ActionForward
		 */
		public ActionForward getActionForward(ActionMapping mapping) {
			return mapping.findForward(FW_INIT);
		}
		/**
		 * get user data list.
		 * contain all combox data for init page data.
		 * 
		 * @param form
		 * @param first
		 * @param request
		 * @return DataSet<DataRow>
		 */
		public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
				throws Exception {
			HuidanForm f =  (HuidanForm) form;
			
			return null;
		}
		/**
		 * get init or query result count.
		 * 
		 * @param request
		 * @throws Exception
		 */
		public int getResultCount(ActionForm form) throws Exception {
			return 0;
		}
	}

