package com.stock.paigongdan;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.huidan.HuidanEntityForm;
import com.takucin.aceeci.excel.CellStyle;
import com.takucin.aceeci.excel.Excel;
import com.takucin.aceeci.excel.ExcelUtil;
import com.takucin.aceeci.excel.Row;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

/** 
 * @author daizhen 
 * @version 创建时间：2016-3-2 
 * 回单预导入Service 
 */
public class HuidanPreImportService extends BusinessService {
	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(PaiGongDanPreImportForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", form.getXiaoqu());
		set.add("userplace", "@userplace", form.getDizhi());
		set.add("paigongriqi", "@paigongriqi", form.getPaigongriqis());
		set.add("kaijishijian", "@kaijishijian", form.getKaijishijian());
		set.add("tingjishijian", "@tingjishijian", form.getTingjishijian());
		if(form.getYewutype()!=null) {
			set.add("yewutype", "@yewutype", "%"+form.getYewutype()+"%");
		}
		return set;
	}
	
	public int getResultCount(PaiGongDanPreImportForm form) throws Exception {
//		if (form.getXiaoqu() == null) {
//			return 0;
//		}
		return dao.executeQueryToCount("GetPreImportListCount",getConditionParameterSet(form));
	}
	
	public DataSet<DataRow> getResult(PaiGongDanPreImportForm form, int first, int rows)throws Exception {
//		if (form.getXiaoqu() == null) {
//			return dao.executeQuery("GetEmptyDataList",getConditionParameterSet(form), first, rows);
//		}
		DataSet<DataRow> resultRow = dao.executeQuery("GetPreImportList",getConditionParameterSet(form), first, rows);
		for(int i=0;i<resultRow.size();i++) {
			DataRow line = resultRow.get(i);
			if(line.getDataElement("fenguangD").getString()!=null&&line.getDataElement("fenguangD").getString().equals(line.getDataElement("bdfenguang").getString())) {
				line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("fenguangD").getString()+"</font>");
			}else if(line.getDataElement("fenguangD").getString()!=null&&line.getDataElement("fenguangD").getString().equals(line.getDataElement("yjfenguang").getString())) {
				line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("fenguangD").getString()+"</font>");
			}else{
				if(line.getDataElement("fenguangID").getString()==null||"".equals(line.getDataElement("fenguangID").getString())) {
					line.getDataElement("bdfenguang").setColumnValue(line.getDataElement("fenguangD").getString());
				}else{
					line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"green\">"+line.getDataElement("fenguangD").getString()+"</font>");
				}
			}
			if(line.getDataElement("onumacD").getString()!=null&&line.getDataElement("onumacD").getString().equals(line.getDataElement("bdonumac").getString())) {
				line.getDataElement("bdonumac").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("onumacD").getString()+"</font>");
			}else if(line.getDataElement("onumacD").getString()!=null&&line.getDataElement("onumacD").getString().equals(line.getDataElement("yjonumac").getString())) {
				line.getDataElement("bdonumac").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("onumacD").getString()+"</font>");
			}else{
				line.getDataElement("bdonumac").setColumnValue(line.getDataElement("onumacD").getString());
			}
			if(line.getDataElement("stbmcidD").getString()!=null&&line.getDataElement("stbmcidD").getString().equals(line.getDataElement("bdstbmcid").getString())) {
				line.getDataElement("bdstbmcid").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("stbmcidD").getString()+"</font>");
			}else if(line.getDataElement("stbmcidD").getString()!=null&&line.getDataElement("stbmcidD").getString().equals(line.getDataElement("yjstbmcid").getString())) {
				line.getDataElement("bdstbmcid").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("stbmcidD").getString()+"</font>");
			}else{
				line.getDataElement("bdstbmcid").setColumnValue(line.getDataElement("stbmcidD").getString());
			}
			if(line.getDataElement("dianshiipD").getString()!=null&&line.getDataElement("dianshiipD").getString().equals(line.getDataElement("bddianshiip").getString())) {
				line.getDataElement("bddianshiip").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("dianshiipD").getString()+"</font>");
			}else if(line.getDataElement("dianshiipD").getString()!=null&&line.getDataElement("dianshiipD").getString().equals(line.getDataElement("yjdianshiip").getString())) {
				line.getDataElement("bddianshiip").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("dianshiipD").getString()+"</font>");
			}else{
				line.getDataElement("bddianshiip").setColumnValue(line.getDataElement("dianshiipD").getString());
			}
		}
		return resultRow;
	}
	
	/**
	 * 删除
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String delete(PaiGongDanPreImportForm form,String operater,String time) throws Exception {
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			ParameterModel conds = new ParameterModel();
			String[] uuids = form.getUUIDS();
			for (int i = 0; i < uuids.length; i++) {
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", uuids[i]);
				DataRow datarow = dao.executeQueryToDataRow("getPreImportInfo",set);
				model.put("deleteFlag", "1");
				model.put("updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				conds.put("UUID", uuids[i]);
				model.put("beizhu", "删除信息："+operater+" "+time+"/"+datarow.getDataElement("beizhu").getString());
				dao.update("paigongdanpreimport", model, conds);
			}
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		}
		return Constant.SUCCESS;
	}

	/**
	 * 第三方分光
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String sanfangfenguang(String UUID) throws Exception {
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			ParameterModel conds = new ParameterModel();
			model.put("fenguangD", "三方分光");
			conds.put("UUID", UUID);
			dao.update("paigongdanpreimport", model, conds);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * FTTB小区
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String fttbxiaoqu(String UUID) throws Exception {
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			ParameterModel conds = new ParameterModel();
			model.put("fenguangD", "FTTB");
			model.put("onumacD", "FTTB");
			conds.put("UUID", UUID);
			dao.update("paigongdanpreimport", model, conds);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 待分配ONU
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String daifenpeionu(String UUID) throws Exception {
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			ParameterModel conds = new ParameterModel();
			model.put("onumacD", "待分配");
			conds.put("UUID", UUID);
			dao.update("paigongdanpreimport", model, conds);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 待分配机顶盒
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String daifenpeijidinghe(String UUID) throws Exception {
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			ParameterModel conds = new ParameterModel();
			model.put("stbmcidD", "待分配");
			conds.put("UUID", UUID);
			dao.update("paigongdanpreimport", model, conds);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 根据UUID查询回单预导入详情
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getPreImportByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("getPreImportInfo",set);
	}
	
	/**
	 * 更新
	 * @param form
	 * @return
	 * @throws Exception
	 * 
	 * uopdate person:lhh 2013-4-25 
	 * 由于编辑时候导致的  所选电话号码是否回调的BUG
	 * 
	 */
	@SuppressWarnings("unused")
	public String update(PaiGongDanEntiyForm form) throws Exception {
		try {
		openTransaction();
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", form.getXiaoquname());
		set.add("userplace", "@userplace", form.getUserplace());
		set.add("usertel", "@usertel", form.getUsertel());
		if("".equals(form.getShenfenzheng())) {
			form.setShenfenzheng(" ");
		}
		set.add("shenfenzheng", "@shenfenzheng", form.getShenfenzheng());
		set.add("paigongriqi", "@paigongriqi", form.getPaigongriqi());
		
		
		set.add("anzhuangshijian", "@anzhuangshijian", form.getAnzhuangshijian());
		set.add("xiangmu", "@xiangmu", form.getXiangmu());
		set.add("tfkuandaidaikuan", "@tfkuandaidaikuan", form.getTfkuandaidaikuan());
		set.add("tfkdnianxian", "@tfkdnianxian", form.getTfkdnianxian());
		set.add("tfiptv", "@tfiptv", form.getTfiptv());
		set.add("tfiptvnianxian", "@tfiptvnianxian", form.getTfiptvnianxian());
		set.add("shichangbeishu", "@shichangbeishu", form.getBeishuselect());
		set.add("tfsfyewu", "@tfsfyewu", form.getTfsfyewu());
		set.add("qtye", "@qtye", form.getQtye());
		set.add("fufei", "@fufei", form.getFufei());
		
		if(form.getDxfandan()==null){
			set.add("dxfandan", "@dxfandan", "0");
		}else{
			set.add("dxfandan", "@dxfandan", form.getDxfandan());
		}
		if(form.getZhengjian()==null){
			set.add("zhengjian", "@zhengjian", "0");
		}else{
			set.add("zhengjian", "@zhengjian", form.getZhengjian());
		}
		
		set.add("shoushifei", "@shoushifei", form.getShoushifei());
		set.add("nianfei", "@nianfei", form.getNianfei());
		set.add("buzuyue", "@buzuyue", form.getBuzuyue());
		set.add("chuzhuangfei", "@chuzhuangfei", form.getChuzhuangfei());
		set.add("kuaidaifei", "@kuaidaifei", form.getKuaidaifei());
		
		set.add("onu", "@onu", form.getOnu());
		set.add("jidinghe", "@jidinghe", form.getJidinghe());
		 if(form.getSelectCommunityPileID()==null||"".equals(form.getSelectCommunityPileID())||"0".equals(form.getSelectCommunityPileID())) {
		    	if(form.getSelectCommunityPileID2()==null||"".equals(form.getSelectCommunityPileID2())||"0".equals(form.getSelectCommunityPileID2())){
		    		set.add("beizhu","@beizhu", form.getBeizhu());
		    	}else{
		    		set.add("beizhu","@beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum2());//+"["+form.getXiaoquname()+"][安装用]");
		    	}
		    	}else {
		    		if(form.getSelectCommunityPileID2()==null||"".equals(form.getSelectCommunityPileID2())||"0".equals(form.getSelectCommunityPileID2())){
		    			set.add("beizhu","@beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum());//+"["+form.getXiaoquname()+"][安装用]");
			    	}else{
			    		set.add("beizhu","@beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum()+"/"+form.getEqboxnum2());//+"["+form.getXiaoquname()+"][安装用]");
			    	}
		    	
			}			
		//xinzeng
		set.add("tfkdczf", "@tfkdczf", form.getTfkdczf());
		set.add("tfkuandaifei", "@tfkuandaifei", form.getTfkuandaifei());
		set.add("tfiptvshoushifei", "@tfiptvshoushifei", form.getTfiptvshoushifei());
		set.add("tfjidingheyajin", "@tfjidingheyajin", form.getTfjidingheyajin());
		set.add("yuyingshang", "@yuyingshang", form.getYuyingshang());
		set.add("qtbuzuyue", "@qtbuzuyue", form.getQtbuzuyue());
		set.add("heji", "@heji", form.getHeji());
		set.add("username", "@username", form.getUsername());
		
		set.add("jiaohuanji", "@jiaohuanji", form.getJiaohuanji());
		set.add("dxchuzhuangfei", "@dxchuzhuangfei", form.getDxchuzhuangfei());
		set.add("telhaoma1", "@telhaoma1", form.getTelhaoma1());
		set.add("telhaoma2", "@telhaoma2", form.getTelhaoma2());
		set.add("telhaoma3", "@telhaoma3", form.getTelhaoma3());
		set.add("telhaoma4", "@telhaoma4", form.getTelhaoma4());
		set.add("onuzhiding", "@onuzhiding", form.getOnu());
		
		set.add("UUID", "@UUID", form.getUUID());
		set.add("fufeitype", "@fufeitype", form.getFufeitype());
		set.add("shebeixiaoshou", "@shebeixiaoshou", form.getShebeixiaoshou());
		set.add("cailiaofei", "@cailiaofei", form.getCailiaofei());
		set.add("kaipiaoxinxi", "@kaipiaoxinxi", form.getKaipiaoxinxi());
		
		if("".equals(form.getFenguang())) {
			form.setFenguang(" ");
		}
		if("".equals(form.getDianshiip())) {
			form.setDianshiip(" ");
		}
		set.add("fenguangD", "@fenguangD", form.getFenguang());
		set.add("onumacD", "@onumacD",  form.getOnumac());
		set.add("stbmcidD", "@stbmcidD", form.getStbmcid());
		set.add("dianshiipD", "@dianshiipD",  form.getDianshiip());
		set.add("CommunityPile_ID","@CommunityPile_ID", form.getSelectCommunityPileID());
		set.add("CommunityPile_ID2","@CommunityPile_ID2", form.getSelectCommunityPileID2());
		
		set.add("bdfenguang", "@bdfenguang", form.getBdfenguang());
		set.add("bdonumac", "@bdonumac",  form.getBdonumac());
		set.add("bdstbmcid", "@bdstbmcid", form.getBdstbmcid());
		set.add("bddianshiip", "@bddianshiip",  form.getBddianshiip());
		set.add("biduikbn", "@biduikbn",  form.getBiduikbn());
		
		set.add("netip", "@netip",  form.getWangluoip());
		set.add("telip", "@telip", form.getDianhuaip());
		set.add("telvaln", "@telvaln",  form.getDianhuavlan());
		set.add("netvaln", "@netvaln",  form.getWangluovlan());
		
		set.add("newkaijishijian", "@newkaijishijian",  form.getKaijishijian());
		set.add("newtingjishijian", "@newtingjishijian",  form.getTingjishijian());
		dao.execute("updatePreImportById",set);
		commit();
	} catch (Exception e) {
		rollback();
		log.error(e);
		throw e;
	}
	return Constant.SUCCESS;
	}
	
	public Excel getExportExcel(PaiGongDanPreImportForm form)throws Exception{
		DataSet<DataRow> dateSet = getResultExcel(form);
		Excel excel = new Excel();
		HSSFWorkbook pgdworkbook = excel.getWorkbook();
		CellStyle biduistyle = new CellStyle();
		// 生成并设置另一个样式
        biduistyle.setColor(HSSFColor.BLUE.index);
        biduistyle.setBlod(true);
        CellStyle yichustyle = new CellStyle();
		// 生成并设置另一个样式
        yichustyle.setColor(HSSFColor.BROWN.index);
        yichustyle.setBlod(true);
		excel.setSheetName("安装统计");
		Row header = new Row();
		header.addCell("用户姓名");
		header.addCell("身份证");
		header.addCell("日期");
		header.addCell("停机时间");
		header.addCell("小区");
		header.addCell("地址");
		header.addCell("电话");
		header.addCell("网络");
		header.addCell("电视");
		header.addCell("电话");
		header.addCell("业务");
		header.addCell("分光");
		header.addCell("onumac");
		header.addCell("STB MCID");
		header.addCell("电视ip");
		header.addCell("网络ip");
		header.addCell("电话ip");
		header.addCell("电话valn");
		header.addCell("网络valn");
		header.addCell("上门时间");
		header.addCell("单证");
		header.addCell("所选电话号码");
		header.addCell("ONU押金");
		header.addCell("机顶盒押金");
		header.addCell("收视费");
		header.addCell("宽带费");
		header.addCell("初装费");
		header.addCell("设备销售费");
		header.addCell("材料费");
		header.addCell("运营商");
		header.addCell("不足月够费 ");
		header.addCell("年费 ");
		header.addCell("备注");
		header.addCell("业务类型");
		excel.set(header);
		List<String> list = new ArrayList<String>();
		list.add("username");
		list.add("shenfenzheng");
		list.add("newkaijishijian");
		list.add("newtingjishijian");
		list.add("xiaoquname");
		list.add("userplace");
		list.add("usertel");
		list.add("tfkuandaidaikuan");
		list.add("tfiptv");
		list.add("tfsfyewu");
		list.add("qtye");
		list.add("fenguangD");
		list.add("onumacD");
		list.add("stbmcidD");
		list.add("dianshiipD");
		list.add("netip");
		list.add("telip");
		list.add("telvaln");
		list.add("netvaln");
		list.add("anzhuangshijian");
		//单证
		list.add("danzheng");
		//所选号码
		list.add("telhaoma");
		//onu押金
		list.add("onu");
		list.add("jidinghe");
		list.add("shoushifei");
		//宽带费
		list.add("kuaidaifei");
		list.add("chuzhuangfei");
		list.add("shebeixiaoshou");
		list.add("cailiaofei");
		list.add("yuyingshang");
		list.add("buzuyue");
		list.add("nianfei");
		list.add("beizhu");
		list.add("yewuleixing");
		excel.set(ExcelUtil.toExcelRowList1(dateSet,list,biduistyle,yichustyle,pgdworkbook),1,0);
		return excel;
	}
	
	public DataSet<DataRow> getResultExcel(PaiGongDanPreImportForm form)throws Exception {
		return dao.executeQuery("GetPreImportListExcel",getConditionParameterSet(form));
	}
	
	public CommonMessage insert(DataRow dataRow,String operater,String time) throws Exception {
		try {
			openTransaction();
				ParameterModel m = new ParameterModel();
				m.put("puuid", dataRow.getDataElement("PK_ID").getString());
				m.put("xingming", dataRow.getDataElement("username").getString());
				m.put("shenfenzheng", dataRow.getDataElement("shenfenzheng").getString());
				m.put("kaijishijian", dataRow.getDataElement("newkaijishijian").getString());
				m.put("tingjishijian", dataRow.getDataElement("newtingjishijian").getString());
				m.put("youxiaoshijian", dataRow.getDataElement("newtingjishijian").getString());
				m.put("xiaoqu", dataRow.getDataElement("xiaoquname").getString());
				m.put("dizhi", dataRow.getDataElement("userplace").getString());
				m.put("lianxidianhua", dataRow.getDataElement("usertel").getString());
				m.put("wangluo", dataRow.getDataElement("tfkuandaidaikuan").getString());
				m.put("dianshi", dataRow.getDataElement("tfiptv").getString());
				m.put("dianhua", dataRow.getDataElement("tfsfyewu").getString());
				m.put("yewu", dataRow.getDataElement("qtye").getString());
				m.put("fenguang", dataRow.getDataElement("fenguangD").getString());
				m.put("onumac", dataRow.getDataElement("onumacD").getString());
				m.put("stbmcid", dataRow.getDataElement("stbmcidD").getString());
				String dianshiip = dataRow.getDataElement("tvip").getString();
				if(dianshiip==null) {
					dianshiip = "";
				}
				m.put("dianshiip", dianshiip);
				String wangluoip = dataRow.getDataElement("netip").getString();
				if(wangluoip==null) {
					wangluoip = "";
				}
				m.put("wangluoip", wangluoip);
				String dianhuaip = dataRow.getDataElement("telip").getString();
				if(dianhuaip==null) {
					dianhuaip = "";
				}
				m.put("dianhuaip", dianhuaip);
				m.put("dianhuavlan", dataRow.getDataElement("telvaln").getString());
				m.put("wangluovlan", dataRow.getDataElement("netvaln").getString());
				m.put("shangmenshijian", dataRow.getDataElement("anzhuangshijian").getString());
				m.put("danzheng", dataRow.getDataElement("danzheng").getString());
				m.put("sxdhhm", dataRow.getDataElement("telhaoma").getString());
				m.put("onuyj", dataRow.getDataElement("onuzhiding").getString());
				m.put("jidingheyj", dataRow.getDataElement("jidinghe").getString());
				m.put("shoushifei", dataRow.getDataElement("shoushifei").getString());
				m.put("kuandaifei", dataRow.getDataElement("kuaidaifei").getString());
				m.put("chuzhuangfei", dataRow.getDataElement("chuzhuangfei").getString());
				m.put("shebeixiaoshou", dataRow.getDataElement("shebeixiaoshou").getString());
				m.put("cailiaofei", dataRow.getDataElement("cailiaofei").getString());
				m.put("yunyingshang", dataRow.getDataElement("yuyingshang").getString());
				m.put("bzygf", dataRow.getDataElement("buzuyue").getString());
				m.put("nianfei", dataRow.getDataElement("nianfei").getString());
				m.put("beizhu", "传输信息："+operater+" "+time+"/"+dataRow.getDataElement("beizhu").getString());
//				m.put("beizhuhuizong", dataRow.getDataElement("").getString()+"/"+dataRow.getDataElement("").getString());
				m.put("createby", getUserInfo().getEmployeeName());
				m.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				m.put("yewutype", dataRow.getDataElement("yewutype").getString());
				
				m.put("biduikbn", dataRow.getDataElement("biduikbn").getString());
				m.put("bdfenguang", dataRow.getDataElement("bdfenguang").getString());
				m.put("bdonumac", dataRow.getDataElement("bdonumac").getString());
				m.put("bdstbmcid", dataRow.getDataElement("bdstbmcid").getString());
				m.put("bddianshiip", dataRow.getDataElement("bddianshiip").getString());
				m.put("fenguangID", dataRow.getDataElement("fenguangID").getString());
				m.put("yjfenguang", dataRow.getDataElement("yjfenguang").getString());
				m.put("yjonumac", dataRow.getDataElement("yjonumac").getString());
				m.put("yjstbmcid", dataRow.getDataElement("yjstbmcid").getString());
				m.put("yjdianshiip", dataRow.getDataElement("yjdianshiip").getString());
				m.put("CommunityPile_ID", dataRow.getDataElement("CommunityPile_ID").getString());
				m.put("CommunityPile_ID2", dataRow.getDataElement("CommunityPile_ID2").getString());
				m.put("shichangbeishu",  dataRow.getDataElement("shichangbeishu").getString());
				
				String wangluo = dataRow.getDataElement("tfkuandaidaikuan").getString();
				String dianshi = dataRow.getDataElement("tfiptv").getString();
				String dianhua = dataRow.getDataElement("tfsfyewu").getString();
				if((!checkEmpty(wangluo)&&checkEmpty(dianshi)&&checkEmpty(dianhua))||(checkEmpty(wangluo)&&!checkEmpty(dianshi)&&checkEmpty(dianhua))||(checkEmpty(wangluo)&&checkEmpty(dianshi)&&!checkEmpty(dianhua))) {
					dao.insert("huidandata", m);
				}else{
					if(!checkEmpty(wangluo)) {
						ParameterModel m1 = new ParameterModel();
						m1.putAll(m);
						m1.remove("CommunityPile_ID2");
						m1.put("dianshi", "");
						m1.put("stbmcid", "");
						m1.put("dianshiip", "");
						m1.put("dianhuaip", "");
						m1.put("jidingheyj", "0");
						m1.put("shoushifei", "0");
						if (!checkEmpty(dianshi)) {
							m1.put("shebeixiaoshou", "0");
						}
						
						m1.put("dianhua", "");
						m1.put("dianhuaip", "");
						m1.put("bzygf", "0");
						m1.put("nianfei", "0");
						dao.insert("huidandata", m1);
						
						m.put("onuyj", "0");
						m.put("chuzhuangfei","0");
						m.put("cailiaofei", "0");
						if (checkEmpty(dianshi)) {
							m.put("shebeixiaoshou", "0");
						}
					}
					if (!checkEmpty(dianshi)) {
						ParameterModel m2 = new ParameterModel();
						m2.putAll(m);
						m2.put("wangluo", "");
						m2.put("wangluoip", "");
						m2.put("kuandaifei", "0");						
						m2.put("dianhua", "");
						m2.put("bzygf", "0");
						m2.put("nianfei", "0");
						dao.insert("huidandata", m2);
						
						m.put("onuyj", "0");
						m.put("chuzhuangfei","0");
						m.put("cailiaofei", "0");
						m.put("shebeixiaoshou", "0");
					}
					if (!checkEmpty(dianhua)) {
						ParameterModel m3 = new ParameterModel();
						m3.putAll(m);
						
						m3.put("wangluo", "");
						m3.put("wangluoip", "");
						m3.put("kuandaifei", "0");
						m3.remove("CommunityPile_ID2");
						m3.put("dianshi", "");
						m3.put("stbmcid", "");
						m3.put("dianshiip", "");
						m3.put("jidingheyj", "0");
						m3.put("shoushifei", "0");
						m3.put("tingjishijian", "2019-02-02");
						dao.insert("huidandata", m3);
					}
				}
				ParameterModel model = new ParameterModel();
				ParameterModel conds = new ParameterModel();
				model.put("deleteFlag", "1");
				model.put("updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				conds.put("UUID", dataRow.getDataElement("PK_ID").getString());
				model.put("beizhu", "传输信息："+operater+" "+time+"/"+dataRow.getDataElement("beizhu").getString());
				dao.update("paigongdanpreimport", model, conds);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			return new CommonMessage(ErrorConstant.PGD_DATA_ERROR);
		}
		return new CommonMessage(Constant.SUCCESS);
	}
	
	/**
	 * 内容为空时返回true
	 */
	private boolean checkEmpty(String content) {
		if(content==null||"".equals(content)||" ".equals(content)||"　".equals(content)||"0".equals(content)) {
			return true;
		}
		return false;
	}
	
	private ParameterSet getHistoryConditionParameterSet(PaiGongDanPreImportForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", form.getXiaoqu());
		set.add("userplace", "@userplace", form.getDizhi());
		set.add("paigongriqi", "@paigongriqi", form.getPaigongriqis());
		set.add("kaijishijian", "@kaijishijian", form.getKaijishijian());
		set.add("tingjishijian", "@tingjishijian", form.getTingjishijian());
		set.add("updatedt", "@updatedt", form.getCaozuoshijian());
		set.add("yewutype", "@yewutype", "%"+form.getYewutype()+"%");
		set.add("beizhu", "@beizhu", "%"+form.getBeizhu()+"%");
		return set;
	}
	
	public int getResultHistoryCount(PaiGongDanPreImportForm form) throws Exception {
		if (form.getXiaoqu() == null) {
			return 0;
		}
		return dao.executeQueryToCount("GetPreImportHistoryListCount",getHistoryConditionParameterSet(form));
	}
	
	public DataSet<DataRow> getResultHistory(PaiGongDanPreImportForm form, int first, int rows)throws Exception {
		if (form.getXiaoqu() == null) {
			return dao.executeQuery("GetEmptyDataList",getHistoryConditionParameterSet(form), first, rows);
		}
		DataSet<DataRow> resultRow = dao.executeQuery("GetPreImportHistoryList",getHistoryConditionParameterSet(form), first, rows);
		for(int i=0;i<resultRow.size();i++) {
			DataRow line = resultRow.get(i);
			if(line.getDataElement("fenguangD").getString()!=null&&line.getDataElement("fenguangD").getString().equals(line.getDataElement("bdfenguang").getString())) {
				line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("fenguangD").getString()+"</font>");
			}else if(line.getDataElement("fenguangD").getString()!=null&&line.getDataElement("fenguangD").getString().equals(line.getDataElement("yjfenguang").getString())) {
				line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("fenguangD").getString()+"</font>");
			}else{
				if(line.getDataElement("fenguangID").getString()==null||"".equals(line.getDataElement("fenguangID").getString())) {
					line.getDataElement("bdfenguang").setColumnValue(line.getDataElement("fenguangD").getString());
				}else{
					line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"green\">"+line.getDataElement("fenguangD").getString()+"</font>");
				}
			}
			if(line.getDataElement("onumacD").getString()!=null&&line.getDataElement("onumacD").getString().equals(line.getDataElement("bdonumac").getString())) {
				line.getDataElement("bdonumac").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("onumacD").getString()+"</font>");
			}else if(line.getDataElement("onumacD").getString()!=null&&line.getDataElement("onumacD").getString().equals(line.getDataElement("yjonumac").getString())) {
				line.getDataElement("bdonumac").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("onumacD").getString()+"</font>");
			}else{
				line.getDataElement("bdonumac").setColumnValue(line.getDataElement("onumacD").getString());
			}
			if(line.getDataElement("stbmcidD").getString()!=null&&line.getDataElement("stbmcidD").getString().equals(line.getDataElement("bdstbmcid").getString())) {
				line.getDataElement("bdstbmcid").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("stbmcidD").getString()+"</font>");
			}else if(line.getDataElement("stbmcidD").getString()!=null&&line.getDataElement("stbmcidD").getString().equals(line.getDataElement("yjstbmcid").getString())) {
				line.getDataElement("bdstbmcid").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("stbmcidD").getString()+"</font>");
			}else{
				line.getDataElement("bdstbmcid").setColumnValue(line.getDataElement("stbmcidD").getString());
			}
			if(line.getDataElement("dianshiipD").getString()!=null&&line.getDataElement("dianshiipD").getString().equals(line.getDataElement("bddianshiip").getString())) {
				line.getDataElement("bddianshiip").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("dianshiipD").getString()+"</font>");
			}else if(line.getDataElement("dianshiipD").getString()!=null&&line.getDataElement("dianshiipD").getString().equals(line.getDataElement("yjdianshiip").getString())) {
				line.getDataElement("bddianshiip").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("dianshiipD").getString()+"</font>");
			}else{
				line.getDataElement("bddianshiip").setColumnValue(line.getDataElement("dianshiipD").getString());
			}
		}
		return resultRow;
	}
	
	/**
	 * 复制回退
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String fuzhihuitui(PaiGongDanPreImportForm form) throws Exception {
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			String[] uuids = form.getUUIDS();
			for (int i = 0; i < uuids.length; i++) {
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", uuids[i]);
				DataRow datarow = dao.executeQueryToDataRow("getPreImportInfo",set);
				List<String> ks = datarow.getKeys();
				for(int j = 0;j<ks.size();j++) {
					String key = ks.get(j);
					if("PK_ID".equals(key)||"telhaoma".equals(key)||"danzheng".equals(key)) {
						continue;
					}else{
						model.put(ks.get(j), datarow.getDataElement(ks.get(j)).getString());
					}
				}
				dao.insert("paigongdanpreimport", model);
			}
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 生成第二台IPTV
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String diertaiiptv(String uuid,String tingjishijiannew,String operater,String time) throws Exception {
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", uuid);
			DataRow datarow = dao.executeQueryToDataRow("getPreImportInfo",set);
			ParameterModel model = new ParameterModel();
			List<String> ks = datarow.getKeys();
			for(int i = 0;i<ks.size();i++) {
				String key = ks.get(i);
				if("PK_ID".equals(key)||"telhaoma".equals(key)||"danzheng".equals(key)||"CommunityPile_ID2".equals(key)) {
					continue;
				}else if("onu".equals(key)||"jidinghe".equals(key)||"kuaidaifei".equals(key)||"tfkuandaifei".equals(key)||"shebeixiaoshou".equals(key)||
						"cailiaofei".equals(key)||"buzuyue".equals(key)||"nianfei".equals(key)) {
					//ONU押金、机顶盒押金、宽带费、设备销售费、材料费、不足月够费、年费置零
					model.put(ks.get(i), "0");
				}else if("tfkuandaidaikuan".equals(key)||"tfsfyewu".equals(key)||"stbmcidD".equals(key)||"dianshiipD".equals(key)||"netip".equals(key)) {
					//网络、电话、STB MCID、电视IP、网络IP置空
					model.put(ks.get(i), "");
				}else if("chuzhuangfei".equals(key)) {
					model.put(ks.get(i), "400");
				}else if("telip".equals(key)) {
					String telip = datarow.getDataElement("telip").getString();
					if(telip!=null) {
						telip = telip+"0";
					}
					model.put(ks.get(i), telip);
				}else if("shoushifei".equals(key)) {
					String kaijishijian = datarow.getDataElement("newkaijishijian").getString();
					String tingjishijian = datarow.getDataElement("newtingjishijian").getString();
					if(!"".equals(tingjishijiannew)) {
						tingjishijian = tingjishijiannew;
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar bef = Calendar.getInstance();
					Calendar aft = Calendar.getInstance();
					bef.setTime(sdf.parse(kaijishijian));
					aft.setTime(sdf.parse(tingjishijian));
					int day = 0;
					if( aft.get(Calendar.DAY_OF_MONTH)>bef.get(Calendar.DAY_OF_MONTH)) {
						day = 1;
					}
					int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
					int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR))*12;
					model.put(ks.get(i), (month+result+day)*10);
				}else if("newtingjishijian".equals(key)) {
					if(!"".equals(tingjishijiannew)) {
						model.put(ks.get(i), tingjishijiannew);
					}else{
						model.put(ks.get(i), datarow.getDataElement(ks.get(i)).getString());
					}
				}else if("beizhu".equals(key)) {
					model.put(ks.get(i), "生成第二台电视信息："+operater+" "+time+"/"+datarow.getDataElement(ks.get(i)).getString());
				}else{
					model.put(ks.get(i), datarow.getDataElement(ks.get(i)).getString());
				}
			}
			dao.insert("paigongdanpreimport", model);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		}
		return Constant.SUCCESS;
	}
}
