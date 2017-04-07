package com.stock.paigongdan; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.DataSetUtil;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:29:45 
 * 类说明 
 */
public class PaiGongDanService extends BusinessService{
	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(PaiGongDanForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", form.getXiaoquHidden()+ "%");
		set.add("usertel", "@usertel", form.getUserTelHidden());
		set.add("state", "@state", form.getStateHidden());
	//	set.add("stateDate", "@stateDate", form.getStateDateHidden());
	//	set.add("endDate", "@endDate", form.getEndDateHidden());
		set.add("userplace", "@userplace", form.getUserplaceHidden());
		set.add("paigongriqi", "@paigongriqi", form.getPaigongriqisHidden());
		set.add("xiangmu", "@xiangmu",form.getXiangmusHidden() );
		set.add("telnumber", "@telnumber", form.getTelnumbeHidden());
		set.add("createby", "@createby", form.getCreatebyCodeaHidden());
		set.add("createdt", "@createdt", form.getCreatedtHiddenCode());
		set.add("createdt2", "@createdt2", form.getCreatedtHiddenCode2());
		if (form.getBusiHidden().equals("")) {
			set.add("tfkuandaidaikuan", "@tfkuandaidaikuan", "");
			set.add("tfiptv", "@tfiptv", "");
			set.add("qtye", "@qtye", "");
		} else if (form.getBusiHidden().equals("1")) {
			set.add("tfkuandaidaikuan", "@tfkuandaidaikuan", "0");
			set.add("tfiptv", "@tfiptv", "");
			set.add("qtye", "@qtye", "");
		} else if (form.getBusiHidden().equals("2")) {
			set.add("tfkuandaidaikuan", "@tfkuandaidaikuan", "");
			set.add("tfiptv", "@tfiptv", "0");
			set.add("qtye", "@qtye", "");
		} else if (form.getBusiHidden().equals("3")) {
			set.add("tfkuandaidaikuan", "@tfkuandaidaikuan", "");
			set.add("tfiptv", "@tfiptv", "");
			set.add("qtye", "@qtye", "0");
		}
		set.add("createdt", "@createdt", form.getCreatedtHiddenCode());
		return set;
	}
	
	public DataSet<DataRow> getResult(PaiGongDanForm form, int first, int rows)throws Exception {
		if (form.getXiaoqu() == null) {
			return dao.executeQuery("GetEmptyDataList",getConditionParameterSet(form), first, rows);
		}
		DataSet<DataRow> resultRow = dao.executeQuery("GetPGDList",getConditionParameterSet(form), first, rows);
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
	
	public DataSet<DataRow> getAnzhuangbiduiList(PaiGongDanForm form, int first, int rows)throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("yonghuzhuangtai", "@yonghuzhuangtai", "已安装");
		set.add("xiaoqu", "@xiaoqu", form.getXiaoqu());
		set.add("dizhi", "@dizhi", form.getUserplaces());
		DataSet<DataRow> executeQuery = dao.executeQuery("comparisonYianzhuangData", set);
		return executeQuery;
	}
	public int getAnzhuangbiduiListCount(PaiGongDanForm form)throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("yonghuzhuangtai", "@yonghuzhuangtai", "已安装");
		set.add("xiaoqu", "@xiaoqu", form.getXiaoqu());
		set.add("dizhi", "@dizhi", form.getUserplaces());
		DataSet<DataRow> executeQuery = dao.executeQuery("comparisonYianzhuangData", set);
		if(executeQuery==null) {
			return 0;
		}
		return executeQuery.size();
	}

	public int getResultCount(PaiGongDanForm form) throws Exception {
		if (form.getXiaoqu() == null) {
			return 0;
		}
		return dao.executeQueryToCount("GetPGDListCount",getConditionParameterSet(form));
	}
	
	
	/**
	 * 查询预约单
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getYuyue(PaiGongDanEntiyForm form) throws Exception{
		
		ParameterSet set = new ParameterSet();
		String quYu = getQuYu(form.getXiaoquname());
		//set.add("UUID", "@UUID", form.getUUID());
		set.add("xiaoqu", "@xiaoqu", quYu);
		set.add("riqi", "@riqi", form.getPaigongriqi());
		set.add("shijian", "@shijian", form.getAnzhuangshijian());
		return dao.executeQueryToDataRow("getYuyue",set);
	}
	
	/**
	 * 根据电话号码查看所选号码是否已经被选则
	 * @param telNo
	 * @return
	 * @throws Exception
	 */
	public DataRow getTelNo(String telNo)throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("telno", "@telno", telNo);
		return dao.executeQueryToDataRow("getTelStateByNo", set);
		
	}
	
	/**
	 * 获取区域名
	 * @param xiaoQuName
	 * @return
	 * @throws Exception
	 */
	public String getQuYu(String xiaoQuName)throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("name", "@name", xiaoQuName);
		DataRow dataRow = dao.executeQueryToDataRow("getQuyu", set);
		return dataRow.getDataElement("quyu").getString();
	}
	
	private DataRow getXiaoquCode(String cpname) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("CommunityName", "@CommunityName", cpname);
		
		return dao.executeQueryToDataRow("getXiaoquCode", set);
	}
	private String generateAcct(String xiaoqucode,String address) {
		String newAcct = "";
		address = address.replaceAll("别墅", "0000");
		newAcct = xiaoqucode+address.replaceAll("-", "");
		if("0".equals(xiaoqucode)) {
			newAcct = "有误"+newAcct;
		}
		String[] addressArr = address.split("-");
		for(int i = 0;i<addressArr.length;i++) {
			if("0".equals(addressArr[i])||"00".equals(addressArr[i])||addressArr[i].startsWith("00")||addressArr[i].endsWith("00")) {
				newAcct = newAcct+"特殊";
				break;
			}
		}
		return newAcct;
	}
	/**
	 * 当日派工单录入
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String insertDangRi(PaiGongDanEntiyForm form)throws Exception{
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			//model.put("employeeId", form.getEmployeeCode());Common.formatDate(form.getRukudateString(), "yyyy-MM-dd HH:mm:ss")
			model.put("paigongriqi", form.getPaigongriqi());
			model.put("state", "1");//
			if(form.getTfkuandaishichang()!=null&&!form.getTfkuandaishichang().equals("")){
				Integer tfkdsc = Integer.parseInt(form.getTfkuandaishichang());
				String paigongriqi = form.getPaigongriqi();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        Date dt=sdf.parse(paigongriqi);
		        Calendar rightNow = Calendar.getInstance();
		        rightNow.setTime(dt);
		        rightNow.add(Calendar.MONTH,tfkdsc);
		        rightNow.add(Calendar.DAY_OF_YEAR,-1);
		        Date dt1=rightNow.getTime();
		        String tfkdtjsj = sdf.format(dt1);
		        model.put("tingjishijian", tfkdtjsj);
			}
			DataRow xiaoqudataRow = getXiaoquCode(form.getXiaoquname());
			String netcode = xiaoqudataRow.getDataElement("netcode").getString();
			String tvcode = xiaoqudataRow.getDataElement("tvcode").getString();
			if(form.getTfkuandaidaikuan()!=null&&!"".equals(form.getTfkuandaidaikuan())&&!"0".equals(form.getTfkuandaidaikuan())) {
				
				model.put("netip", generateAcct(netcode,form.getUserplace()));
			}
			if(form.getTfiptv()!=null&&!"".equals(form.getTfiptv())&&!"0".equals(form.getTfiptv())) {
				model.put("telip", generateAcct(tvcode,form.getUserplace()));
			}
			model.put("xiaoquname", form.getXiaoquname());
			model.put("userplace", form.getUserplace());
			model.put("usertel", form.getUsertel());
			model.put("onu", form.getOnu());
			model.put("jidinghe", form.getJidinghe());
			model.put("shenfenzheng", form.getShenfenzheng());
			
			model.put("anzhuangshijian", form.getAnzhuangshijian());
			model.put("xiangmu", form.getXiangmu());
			model.put("tfkuandaidaikuan", form.getTfkuandaidaikuan());
			model.put("tfkdnianxian", form.getTfkdnianxian());
			model.put("tfiptv", form.getTfiptv());
			model.put("tfiptvnianxian", form.getTfiptvnianxian());
			model.put("tfsfyewu", form.getQtye());
			if(form.getYichuqita()!=null&&!"".equals(form.getYichuqita())) {
				model.put("tfsfyewu", form.getYichuqita());
			}
			model.put("shichangbeishu", form.getBeishuselect());
			if(!"1".equals(form.getBeishuselect())) {
				form.setQtye(form.getQtye()+"/【资费调整"+form.getBeishuselect()+"倍】");
			}
			if("1".equals(form.getIsQiegai())) {
				model.put("qtye", "【线路切改】//"+form.getQtye());
			}else if("1".equals(form.getIsYiji())) {
				model.put("qtye",  "【移机】");
			}else{
				model.put("qtye", form.getQtye());
			}
			model.put("fufei", form.getFufei());
			model.put("telhaoma1", form.getTelhaoma1());
			model.put("telhaoma2", form.getTelhaoma2());
			
			if(form.getDxfandan()==null){//如果电信返单未勾选则插入0
				model.put("dxfandan", "0");
			}else{
				model.put("dxfandan", form.getDxfandan());
			}
			if(form.getZhengjian()==null){
				model.put("zhengjian", "0");
			}else{
				model.put("zhengjian", form.getZhengjian());
			}
			
			
			model.put("shoushifei", form.getShoushifei());
			model.put("nianfei", form.getNianfei());
			model.put("buzuyue", form.getBuzuyue());
			model.put("chuzhuangfei", form.getChuzhuangfei());
			model.put("kuaidaifei", form.getKuaidaifei());
			
			 if(form.getSelectCommunityPileID()==null||"".equals(form.getSelectCommunityPileID())) {
			    	if(form.getSelectCommunityPileID2()==null||"".equals(form.getSelectCommunityPileID2())){
			    		model.put("beizhu", form.getBeizhu());
			    	}else{
			    		model.put("beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum2());//+"["+form.getXiaoquname()+"][安装用]");
			    	}
			    	}else {
			    		if(form.getSelectCommunityPileID2()==null||"".equals(form.getSelectCommunityPileID2())){
			    			model.put("beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum());//+"["+form.getXiaoquname()+"][安装用]");
				    	}else{
				    		model.put("beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum()+"/"+form.getEqboxnum2());//+"["+form.getXiaoquname()+"][安装用]");
				    	}
			    	
				}
			model.put("username", form.getUsername());//用户姓名
			//以下新增
			model.put("yewutype", form.getYewutype());
			model.put("biduikbn", form.getBiduikbn());
			model.put("tfkdczf", form.getTfkdczf());
			model.put("tfkuandaifei", form.getTfkuandaifei());
			model.put("tfiptvshoushifei", form.getTfiptvshoushifei());
			model.put("tfjidingheyajin", form.getTfjidingheyajin());
			model.put("yuyingshang", form.getYuyingshang());
			model.put("qtbuzuyue", form.getQtbuzuyue());
			model.put("heji", form.getHeji());
			
			model.put("jiaohuanji", form.getJiaohuanji());
			model.put("dxchuzhuangfei", form.getDxchuzhuangfei());
			
			model.put("telhaoma4", form.getTelhaoma4());
			model.put("telhaoma3", form.getTelhaoma3());
			
			model.put("onuzhiding", form.getOnu());//onu是否指定 初始值设置为onu押金值，指定后变为0
			
			model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			model.put("createby", getUserInfo().getEmployeeName());
			
			model.put("fufeitype", form.getFufeitype());
			model.put("shebeixiaoshou", form.getShebeixiaoshou());
			model.put("cailiaofei", form.getCailiaofei());
			model.put("kaipiaoxinxi", form.getKaipiaoxinxi());
			
			model.put("fenguangD", form.getFenguang());
			model.put("onumacD", form.getOnumac());
			model.put("stbmcidD", form.getStbmcid());
			model.put("dianshiipD", form.getDianshiip());
			
			model.put("bdfenguang", form.getBdfenguang());
			model.put("bdonumac", form.getBdonumac());
			model.put("bdstbmcid", form.getBdstbmcid());
			model.put("bddianshiip", form.getBddianshiip());
			
			model.put("yjfenguang", form.getYjfenguang());
			model.put("yjonumac", form.getYjonumac());
			model.put("yjstbmcid", form.getYjstbmcid());
			model.put("yjdianshiip", form.getYjdianshiip());
			if(!"".equals(form.getSelectCommunityPileID())) {
				model.put("CommunityPile_ID", form.getSelectCommunityPileID());
			}
			if(!"".equals(form.getSelectCommunityPileID2())) {
				model.put("CommunityPile_ID2", form.getSelectCommunityPileID2());
			}
			if(form.getQiegaidaikuan()!=null&&!"".equals(form.getQiegaidaikuan())) {
				model.put("tfkuandaidaikuan", form.getQiegaidaikuan());
				if(form.getQiegaidaikuan()!=null&&!"".equals(form.getQiegaidaikuan())&&!"0".equals(form.getQiegaidaikuan())) {
					
					model.put("netip", generateAcct(netcode,form.getUserplace()));
				}
			}
			if(form.getQiegaitingjishijian()!=null&&!"".equals(form.getQiegaitingjishijian())) {
				model.put("tingjishijian", form.getQiegaitingjishijian());
			}
			if(form.getYichuyewu()!=null&&!"".equals(form.getYichuyewu())) {
				model.put("tfkuandaidaikuan", form.getYichuyewu());
				if(form.getYichuyewu()!=null&&!"".equals(form.getYichuyewu())&&!"0".equals(form.getYichuyewu())) {
					
					model.put("netip", generateAcct(netcode,form.getUserplace()));
				}
				
			}
			if(form.getYichudianshi()!=null&&!"".equals(form.getYichudianshi())) {
				model.put("tfiptv", form.getYichudianshi());
				if(form.getYichudianshi()!=null&&!"".equals(form.getYichudianshi())&&!"0".equals(form.getYichudianshi())) {
					model.put("telip", generateAcct(tvcode,form.getUserplace()));
				}
			}
//			if(form.getYichutingjishijian()!=null&&!"".equals(form.getYichutingjishijian())) {
//				if(form.getYichutingjishijiands()!=null&&!"".equals(form.getYichutingjishijiands())) {
//					if(form.getYichutingjishijian().equals(form.getYichutingjishijiands())) {
//						model.put("tingjishijian", form.getYichutingjishijian());
//					}else{
//						model.put("beizhu", model.get("beizhu")+"/网络停机时间："+form.getYichutingjishijian()+"  电视停机时间："+form.getYichutingjishijiands());
//					}
//				}else{
//					model.put("tingjishijian", form.getYichutingjishijian());
//				}
//			}
			if(form.getYichutingjishijian()!=null&&!"".equals(form.getYichutingjishijian())&&(form.getYichutingjishijiands()==null||"".equals(form.getYichutingjishijiands()))&&(form.getYichutingjishijianqt()==null||"".equals(form.getYichutingjishijianqt()))) {
				model.put("tingjishijian", form.getYichutingjishijian());
			}else if(form.getYichutingjishijiands()!=null&&!"".equals(form.getYichutingjishijiands())&&(form.getYichutingjishijian()==null||"".equals(form.getYichutingjishijian()))&&(form.getYichutingjishijianqt()==null||"".equals(form.getYichutingjishijianqt()))) {
				model.put("tingjishijian", form.getYichutingjishijiands());
			}else if(form.getYichutingjishijianqt()!=null&&!"".equals(form.getYichutingjishijianqt())&&(form.getYichutingjishijiands()==null||"".equals(form.getYichutingjishijiands()))&&(form.getYichutingjishijian()==null||"".equals(form.getYichutingjishijian()))) {
				model.put("tingjishijian", form.getYichutingjishijianqt());
			}else{
				if("1".equals(form.getIsYiji())) {
					model.put("beizhu", "/网络停机时间："+form.getYichutingjishijian()+"  电视停机时间："+form.getYichutingjishijiands()+"  其他业务停机时间："+form.getYichutingjishijianqt()+"/"+model.get("beizhu"));
				}
			}
			if(form.getKaijishijian()!=null&&!"".equals(form.getKaijishijian())) {
				model.put("newkaijishijian", form.getKaijishijian());
			}
			if(form.getTingjishijian()!=null&&!"".equals(form.getTingjishijian())) {
				model.put("newtingjishijian", form.getTingjishijian());
			}
			dao.insert("paigongdan",model);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	/**
	 * 派工单录入。
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String insert(PaiGongDanEntiyForm form)throws Exception{
		//根据小区 日期 时间 查询当前预约信息，如果没有预约信息则不可录入，如果有预约信息 计划预约-已预约！>0则不可录入。
		DataRow dataRow = getYuyue(form);
		if(form.getXiangmu().equals("安装")||form.getXiangmu().equals("收件")){
		
		if(dataRow==null){
			return ErrorConstant.YUYUENOEXIST;
		}else if (form.getXiangmu().equals("安装")){
			if(dataRow.getDataElement("azjh").getInt()-dataRow.getDataElement("azsy").getInt()==0){
				return ErrorConstant.YUYUEAZ;//该日安装预约计划全部用完
			}
		}else if(form.getXiangmu().equals("收件")){
			if ("".equals(dataRow.getDataElement("qjjh").getString())){
			} else {
				if(dataRow.getDataElement("qjjh").getInt()-dataRow.getDataElement("qjsy").getInt()==0){
					return ErrorConstant.YUYUEQJ;//该日收件预约计划全部用完
				}
			}
			
			//如果选号号码1不为空 则校验所选号码是否已选用
			if(form.getTelhaoma1()!=null&&!form.getTelhaoma1().equals("00000000")){
			 DataRow  telstate1 = getTelNo(form.getTelhaoma1());
			 if(telstate1==null||telstate1.getDataElement("state").getString().equals("1")){
				 return ErrorConstant.YIXUANTEL1;
			}
			}	
			
			//如果选号号码2不为空 则校验所选号码是否已选用
			if(form.getTelhaoma2()!=null&&!form.getTelhaoma2().equals("00000000")){
			 DataRow  telstate2 = getTelNo(form.getTelhaoma2());
			 if(telstate2==null||telstate2.getDataElement("state").getString().equals("1")){
				 return ErrorConstant.YIXUANTEL2;
			}
			}
			
			//如果选号号码3不为空 则校验所选号码是否已选用
			if(form.getTelhaoma3()!=null&&!form.getTelhaoma3().equals("00000000")){
			 DataRow  telstate3 = getTelNo(form.getTelhaoma3());
			 if(telstate3==null||telstate3.getDataElement("state").getString().equals("1")){
				 return ErrorConstant.YIXUANTEL3;
			}
			}
			
			//如果选号号码4不为空 则校验所选号码是否已选用
			if(form.getTelhaoma4()!=null&&!form.getTelhaoma4().equals("00000000")){
			 DataRow  telstate4 = getTelNo(form.getTelhaoma4());
			 if(telstate4==null||telstate4.getDataElement("state").getString().equals("1")){
				 return ErrorConstant.YIXUANTEL4;
			}
			}
		}
		}
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			//model.put("employeeId", form.getEmployeeCode());Common.formatDate(form.getRukudateString(), "yyyy-MM-dd HH:mm:ss")
			model.put("paigongriqi", form.getPaigongriqi());
			model.put("state", "1");
			DataRow xiaoqudataRow = getXiaoquCode(form.getXiaoquname());
			String netcode = xiaoqudataRow.getDataElement("netcode").getString();
			String tvcode = xiaoqudataRow.getDataElement("tvcode").getString();
			if(form.getTfkuandaidaikuan()!=null&&!"".equals(form.getTfkuandaidaikuan())&&!"0".equals(form.getTfkuandaidaikuan())) {
				
				model.put("netip", generateAcct(netcode,form.getUserplace()));
			}
			if(form.getTfiptv()!=null&&!"".equals(form.getTfiptv())&&!"0".equals(form.getTfiptv())) {
				model.put("telip", generateAcct(tvcode,form.getUserplace()));
			}
			if(form.getTfkuandaishichang()!=null&&!form.getTfkuandaishichang().equals("")){
				Integer tfkdsc = Integer.parseInt(form.getTfkuandaishichang());
				String paigongriqi = form.getPaigongriqi();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        Date dt=sdf.parse(paigongriqi);
		        Calendar rightNow = Calendar.getInstance();
		        rightNow.setTime(dt);
		        rightNow.add(Calendar.MONTH,tfkdsc);
		        rightNow.add(Calendar.DAY_OF_YEAR,-1);
		        Date dt1=rightNow.getTime();
		        String tfkdtjsj = sdf.format(dt1);
		        model.put("tingjishijian", tfkdtjsj);
			}
			model.put("xiaoquname", form.getXiaoquname());
			model.put("userplace", form.getUserplace());
			model.put("usertel", form.getUsertel());
			model.put("onu", form.getOnu());
			model.put("jidinghe", form.getJidinghe());
			model.put("shenfenzheng", form.getShenfenzheng());
			
			
			model.put("anzhuangshijian", form.getAnzhuangshijian());
			model.put("xiangmu", form.getXiangmu());
			model.put("tfkuandaidaikuan", form.getTfkuandaidaikuan());
			model.put("tfkdnianxian", form.getTfkdnianxian());
			model.put("tfiptv", form.getTfiptv());
			model.put("tfiptvnianxian", form.getTfiptvnianxian());
			model.put("shichangbeishu", form.getBeishuselect());
			if("1".equals(form.getIsQiegai())) {
				model.put("qtye", "【线路切改】//"+form.getQtye());
			}else if("1".equals(form.getIsYiji())) {
				model.put("qtye",  "【移机】");
			}else{
				if(!"1".equals(form.getBeishuselect())) {
					model.put("qtye",  form.getQtye()+"/【资费调整"+form.getBeishuselect()+"倍】");
				}else{
					model.put("qtye",  form.getQtye());
				}
			}
			model.put("fufei", form.getFufei());
			model.put("telhaoma1", form.getTelhaoma1());
			model.put("telhaoma2", form.getTelhaoma2());
			
			if(form.getDxfandan()==null){//如果电信返单未勾选则插入0
				model.put("dxfandan", "0");
			}else{
				model.put("dxfandan", form.getDxfandan());
			}
			if(form.getZhengjian()==null){
				model.put("zhengjian", "0");
			}else{
				model.put("zhengjian", form.getZhengjian());
			}
			
			
			model.put("shoushifei", form.getShoushifei());
			model.put("nianfei", form.getNianfei());
			model.put("buzuyue", form.getBuzuyue());
			model.put("chuzhuangfei", form.getChuzhuangfei());
			model.put("kuaidaifei", form.getKuaidaifei());
			
			 if(form.getSelectCommunityPileID()==null||"".equals(form.getSelectCommunityPileID())) {
			    	if(form.getSelectCommunityPileID2()==null||"".equals(form.getSelectCommunityPileID2())){
			    		model.put("beizhu", form.getBeizhu());
			    	}else{
			    		model.put("beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum2());//+"["+form.getXiaoquname()+"][安装用]");
			    	}
			    	}else {
			    		if(form.getSelectCommunityPileID2()==null||"".equals(form.getSelectCommunityPileID2())){
			    			model.put("beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum());//+"["+form.getXiaoquname()+"][安装用]");
				    	}else{
				    		model.put("beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum()+"/"+form.getEqboxnum2());//+"["+form.getXiaoquname()+"][安装用]");
				    	}
			    	
				}
			model.put("username", form.getUsername());//用户姓名
			//以下新增
			model.put("yewutype", form.getYewutype());
			model.put("biduikbn", form.getBiduikbn());
			model.put("tfkdczf", form.getTfkdczf());
			model.put("tfkuandaifei", form.getTfkuandaifei());
			model.put("tfiptvshoushifei", form.getTfiptvshoushifei());
			model.put("tfjidingheyajin", form.getTfjidingheyajin());
			model.put("yuyingshang", form.getYuyingshang());
			model.put("qtbuzuyue", form.getQtbuzuyue());
			model.put("heji", form.getHeji());
			
			model.put("jiaohuanji", form.getJiaohuanji());
			model.put("dxchuzhuangfei", form.getDxchuzhuangfei());
			
			model.put("telhaoma4", form.getTelhaoma4());
			model.put("telhaoma3", form.getTelhaoma3());
			
			model.put("onuzhiding", form.getOnu());//onu是否指定 初始值设置为onu押金值，指定后变为0
			
			model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			model.put("createby", getUserInfo().getEmployeeName());
			
			model.put("fufeitype", form.getFufeitype());
			model.put("shebeixiaoshou", form.getShebeixiaoshou());
			model.put("cailiaofei", form.getCailiaofei());
			model.put("kaipiaoxinxi", form.getKaipiaoxinxi());
			
			model.put("fenguangD", form.getFenguang());
			model.put("onumacD", form.getOnumac());
			model.put("stbmcidD", form.getStbmcid());
			model.put("dianshiipD", form.getDianshiip());
			
			model.put("bdfenguang", form.getBdfenguang());
			model.put("bdonumac", form.getBdonumac());
			model.put("bdstbmcid", form.getBdstbmcid());
			model.put("bddianshiip", form.getBddianshiip());
			
			model.put("yjfenguang", form.getYjfenguang());
			model.put("yjonumac", form.getYjonumac());
			model.put("yjstbmcid", form.getYjstbmcid());
			model.put("yjdianshiip", form.getYjdianshiip());
			if(!"".equals(form.getSelectCommunityPileID())) {
				model.put("CommunityPile_ID", form.getSelectCommunityPileID());
			}
			if(!"".equals(form.getSelectCommunityPileID2())) {
				model.put("CommunityPile_ID2", form.getSelectCommunityPileID2());
			}
			if(form.getQiegaidaikuan()!=null&&!"".equals(form.getQiegaidaikuan())) {
				model.put("tfkuandaidaikuan", form.getQiegaidaikuan());
					if(form.getQiegaidaikuan()!=null&&!"".equals(form.getQiegaidaikuan())&&!"0".equals(form.getQiegaidaikuan())) {
					
					model.put("netip", generateAcct(netcode,form.getUserplace()));
				}	
			}
			if(form.getQiegaitingjishijian()!=null&&!"".equals(form.getQiegaitingjishijian())) {
				model.put("tingjishijian", form.getQiegaitingjishijian());
			}
			if(form.getYichuyewu()!=null&&!"".equals(form.getYichuyewu())) {
				model.put("tfkuandaidaikuan", form.getYichuyewu());
				if(form.getYichuyewu()!=null&&!"".equals(form.getYichuyewu())&&!"0".equals(form.getYichuyewu())) {
					model.put("netip", generateAcct(tvcode,form.getUserplace()));
				}
			}
			if(form.getYichudianshi()!=null&&!"".equals(form.getYichudianshi())) {
				model.put("tfiptv", form.getYichudianshi());
				if(form.getYichudianshi()!=null&&!"".equals(form.getYichudianshi())&&!"0".equals(form.getYichudianshi())) {
					model.put("telip", generateAcct(tvcode,form.getUserplace()));
				}
			}
			model.put("tfsfyewu", form.getQtye());
			if(form.getYichuqita()!=null&&!"".equals(form.getYichuqita())) {
				model.put("tfsfyewu", form.getYichuqita());
			}
//			if(form.getYichutingjishijian()!=null&&!"".equals(form.getYichutingjishijian())) {
//				if(form.getYichutingjishijiands()!=null&&!"".equals(form.getYichutingjishijiands())) {
//					if(form.getYichutingjishijian().equals(form.getYichutingjishijiands())&&form.getYichutingjishijian().equals(form.getYichutingjishijianqt())) {
//						model.put("tingjishijian", form.getYichutingjishijian());
//					}else{
//						model.put("beizhu", model.get("beizhu")+"/网络停机时间："+form.getYichutingjishijian()+"  电视停机时间："+form.getYichutingjishijiands()+"  其他业务停机时间："+form.getYichutingjishijianqt());
//					}
//				}else{
//					model.put("tingjishijian", form.getYichutingjishijian());
//				}
//			}
			if(form.getYichutingjishijian()!=null&&!"".equals(form.getYichutingjishijian())&&(form.getYichutingjishijiands()==null||"".equals(form.getYichutingjishijiands()))&&(form.getYichutingjishijianqt()==null||"".equals(form.getYichutingjishijianqt()))) {
				model.put("tingjishijian", form.getYichutingjishijian());
			}else if(form.getYichutingjishijiands()!=null&&!"".equals(form.getYichutingjishijiands())&&(form.getYichutingjishijian()==null||"".equals(form.getYichutingjishijian()))&&(form.getYichutingjishijianqt()==null||"".equals(form.getYichutingjishijianqt()))) {
				model.put("tingjishijian", form.getYichutingjishijiands());
			}else if(form.getYichutingjishijianqt()!=null&&!"".equals(form.getYichutingjishijianqt())&&(form.getYichutingjishijiands()==null||"".equals(form.getYichutingjishijiands()))&&(form.getYichutingjishijian()==null||"".equals(form.getYichutingjishijian()))) {
				model.put("tingjishijian", form.getYichutingjishijianqt());
			}else{
				if("1".equals(form.getIsYiji())) {
					model.put("beizhu","/网络停机时间："+form.getYichutingjishijian()+"  电视停机时间："+form.getYichutingjishijiands()+"  其他业务停机时间："+form.getYichutingjishijianqt()+"/"+model.get("beizhu"));
				}
			}
			if(form.getKaijishijian()!=null&&!"".equals(form.getKaijishijian())) {
				model.put("newkaijishijian", form.getKaijishijian());
			}
			if(form.getTingjishijian()!=null&&!"".equals(form.getTingjishijian())) {
				model.put("newtingjishijian", form.getTingjishijian());
			}
			dao.insert("paigongdan",model);
			// 更新预约表已安装
			if(form.getXiangmu().equals("安装")){
				int newazsy =dataRow.getDataElement("azsy").getInt()+1;
				ParameterSet set = new ParameterSet();
				set.add("azsy", "@azsy", String.valueOf(newazsy));
				set.add("UUID", "@UUID", dataRow.getDataElement("PK_ID").getString());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				dao.execute("updateYuyueJh",set);
			}
			if(form.getXiangmu().equals("收件")){
				int newqjsy =dataRow.getDataElement("qjsy").getInt()+1;
				ParameterSet set = new ParameterSet();
				set.add("qjsy", "@qjsy", String.valueOf(newqjsy));
				set.add("UUID", "@UUID", dataRow.getDataElement("PK_ID").getString());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				dao.execute("updateYuyueJh",set);
				
				//更新电话号码为已选号状态 （最多选四个号）
				ParameterSet set1 = new ParameterSet();
				set1.add("telno", "@telno", form.getTelhaoma1());
				set1.add("xiaoqu", "@xiaoqu", form.getXiaoquname());
				set1.add("dizhi", "@dizhi", form.getUserplace());
				set1.add("xuanhaodt", "@xuanhaodt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set1.add("xuanhaoby", "@xuanhaoby", getUserInfo().getEmployeeName());
				set1.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set1.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				set1.add("state", "@state", "1");
				dao.execute("updateTelXuanhao",set1);
				
				ParameterSet set2 = new ParameterSet();
				set2.add("telno", "@telno", form.getTelhaoma2());
				set2.add("xiaoqu", "@xiaoqu", form.getXiaoquname());
				set2.add("dizhi", "@dizhi", form.getUserplace());
				set2.add("xuanhaodt", "@xuanhaodt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set2.add("xuanhaoby", "@xuanhaoby", getUserInfo().getEmployeeName());
				set2.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set2.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				set2.add("state", "@state", "1");
				dao.execute("updateTelXuanhao",set2);
				
				ParameterSet set3 = new ParameterSet();
				set3.add("telno", "@telno", form.getTelhaoma3());
				set3.add("xiaoqu", "@xiaoqu", form.getXiaoquname());
				set3.add("dizhi", "@dizhi", form.getUserplace());
				set3.add("xuanhaodt", "@xuanhaodt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set3.add("xuanhaoby", "@xuanhaoby", getUserInfo().getEmployeeName());
				set3.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set3.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				set3.add("state", "@state", "1");
				dao.execute("updateTelXuanhao",set3);
				
				ParameterSet set4 = new ParameterSet();
				set4.add("telno", "@telno", form.getTelhaoma4());
				set4.add("xiaoqu", "@xiaoqu", form.getXiaoquname());
				set4.add("dizhi", "@dizhi", form.getUserplace());
				set4.add("xuanhaodt", "@xuanhaodt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set4.add("xuanhaoby", "@xuanhaoby", getUserInfo().getEmployeeName());
				set4.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set4.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				set4.add("state", "@state", "1");
				dao.execute("updateTelXuanhao",set4);
			}
			//--------------------------插入历史表---------------------
			/*ParameterModel model1 = new ParameterModel();
			model1.put("paigongriqi", form.getPaigongriqi());
			model1.put("state", "1");
			
			model1.put("xiaoquname", form.getXiaoquname());
			model1.put("userplace", form.getUserplace());
			model1.put("usertel", form.getUsertel());
			model1.put("onu", form.getOnu());
			model1.put("jidinghe", form.getJidinghe());
			
			model1.put("anzhuangshijian", form.getAnzhuangshijian());
			model1.put("xiangmu", form.getXiangmu());
			model1.put("tfkuandaidaikuan", form.getTfkuandaidaikuan());
			model1.put("tfkdnianxian", form.getTfkdnianxian());
			model1.put("tfiptv", form.getTfiptv());
			model1.put("tfiptvnianxian", form.getTfiptvnianxian());
			model1.put("qtye", form.getQtye());
			model1.put("fufei", form.getFufei());
			model1.put("telhaoma1", form.getTelhaoma1());
			model1.put("telhaoma2", form.getTelhaoma2());
			
			
			model1.put("dxfandan", form.getDxfandan());
			model1.put("zhengjian", form.getZhengjian());
			
			model1.put("shoushifei", form.getShoushifei());
			model1.put("nianfei", form.getNianfei());
			model1.put("buzuyue", form.getBuzuyue());
			model1.put("chuzhuangfei", form.getChuzhuangfei());
			model1.put("kuaidaifei", form.getKuaidaifei());
			
			model1.put("beizhu", form.getBeizhu());
			model1.put("username", form.getUsername());//用户姓名
			//以下新增
			
			model1.put("tfkdczf", form.getTfkdczf());
			model1.put("tfkuandaifei", form.getTfkuandaifei());
			model1.put("tfiptvshoushifei", form.getTfiptvshoushifei());
			model1.put("tfjidingheyajin", form.getTfjidingheyajin());
			model1.put("yuyingshang", form.getYuyingshang());
			model1.put("qtbuzuyue", form.getQtbuzuyue());
			model1.put("heji", form.getHeji());
			
			model1.put("jiaohuanji", form.getJiaohuanji());
			model1.put("dxchuzhuangfei", form.getDxchuzhuangfei());
			
			model1.put("telhaoma4", form.getTelhaoma4());
			model1.put("telhaoma3", form.getTelhaoma3());
			
			model1.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			model1.put("operate", "新建");
			Employee emp = getUserInfo();
			model1.put("updateby", emp.getEmployeeName());
			
			dao.insert("paigongdanhistory",model1);*/
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 根据UUID查询配工单详情
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getPGDByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("GetPGDByUUID",set);
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
		/*String error = validator.updateValidate(form);
		if(error != null){
			return error;
		}*/
		String a="1";
		DataRow pgdOld = getPGDByUUID(form.getUUID());
		
		String newQuyu = getQuYu(form.getXiaoquname());
		String oldQuyu = getQuYu(pgdOld.getDataElement("xiaoquname").getString());
		if(newQuyu.equals(oldQuyu) && form.getAnzhuangshijian().equals(pgdOld.getDataElement("anzhuangshijian").getString()) && form.getPaigongriqi().equals(pgdOld.getDataElement("paigongriqi").getString())) {
			a="2";//小区名称、派工日期以及派工时间没有变化
		} else {
			a="3";
		}
		/*
		 * update506-587 lhh
		 */
		String oldtelhaoma1 = pgdOld.getDataElement("telhaoma1").getString();
		String telhaoma1 = form.getTelhaoma1();
		String telno1 = "";
		String state1 = "";
		String oldtelhaoma2 = pgdOld.getDataElement("telhaoma2").getString();
		String telhaoma2 = form.getTelhaoma2();
		String telno2 = "";
		String state2 = "";
		String oldtelhaoma3 = pgdOld.getDataElement("telhaoma3").getString();
		String telhaoma3 = form.getTelhaoma3();
		String telno3 = "";
		String state3 = "";
		String oldtelhaoma4 = pgdOld.getDataElement("telhaoma4").getString();
		String telhaoma4 = form.getTelhaoma4();
		String telno4 = "";
		String state4 = "";
		try {
			if (!"00000000".equals(telhaoma1)) {
				ParameterSet set =new ParameterSet();
				set.add("telno", "@telno", telhaoma1);
				DataRow dataRow = dao.executeQueryToDataRow("CheckXuanHao", set);
				if (dataRow != null && dataRow.size() > 0) {
					 telno1 = dao.executeQueryToDataRow("CheckXuanHao", set).getDataElement("telno").getString();
					 state1 = dao.executeQueryToDataRow("CheckXuanHao", set).getDataElement("state").getString();
					 //如果state 为1 ，判断此号码 与旧号码是否一致，如果不一致，证明所选号码已被选过。state 为0，号码未被选过
					 if ("1".equals(state1) && !telno1.equals(oldtelhaoma1) ) {
						 return ErrorConstant.HAOMABEIXUAN;//所选电话号已被选
					 }
				} else {
					return ErrorConstant.XUANHAOBUCUNZAI;//所选电话号不存在
				}
			}
			
			if (!"00000000".equals(telhaoma2)) {
				ParameterSet set =new ParameterSet();
				set.add("telno", "@telno", telhaoma2);
				DataRow dataRow = dao.executeQueryToDataRow("CheckXuanHao", set);
				if (dataRow != null && dataRow.size() > 0) {
					 telno2 = dao.executeQueryToDataRow("CheckXuanHao", set).getDataElement("telno").getString();
					 state2 = dao.executeQueryToDataRow("CheckXuanHao", set).getDataElement("state").getString();
					 if ("1".equals(state2) && !telno2.equals(oldtelhaoma2) ) {
						 return ErrorConstant.HAOMABEIXUAN;//所选电话号已被选
					 }
				} else {
					return ErrorConstant.XUANHAOBUCUNZAI;//所选电话号不存在
				}
			}
			
			if (!"00000000".equals(telhaoma3)) {
				ParameterSet set =new ParameterSet();
				set.add("telno", "@telno", telhaoma3);
				DataRow dataRow = dao.executeQueryToDataRow("CheckXuanHao", set);
				if (dataRow != null && dataRow.size() > 0) {
					 telno3 = dao.executeQueryToDataRow("CheckXuanHao", set).getDataElement("telno").getString();
					 state3 = dao.executeQueryToDataRow("CheckXuanHao", set).getDataElement("state").getString();
					 if ("1".equals(state3) && !telno3.equals(oldtelhaoma3) ) {
						 return ErrorConstant.HAOMABEIXUAN;//所选电话号已被选
					 }
				} else {
					return ErrorConstant.XUANHAOBUCUNZAI;//所选电话号不存在
				}
			}
			
			if (!"00000000".equals(telhaoma4)) {
				ParameterSet set =new ParameterSet();
				set.add("telno", "@telno", telhaoma4);
				DataRow dataRow = dao.executeQueryToDataRow("CheckXuanHao", set);
				if (dataRow != null && dataRow.size() > 0) {
					 telno4 = dao.executeQueryToDataRow("CheckXuanHao", set).getDataElement("telno").getString();
					 state4 = dao.executeQueryToDataRow("CheckXuanHao", set).getDataElement("state").getString();
					 if ("1".equals(state4) && !telno4.equals(oldtelhaoma4) ) {
						 return ErrorConstant.HAOMABEIXUAN;//所选电话号已被选
					 }
				} else {
					return ErrorConstant.XUANHAOBUCUNZAI;//所选电话号不存在
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return ErrorConstant.XUANHAOCUOWU;//核对选号
		}
		
		try {
			openTransaction();
			//
			if(a.equals("3")){
				//根据小区 日期 时间 查询当前预约信息，如果没有预约信息则不可录入，如果有预约信息 计划预约-已预约！>0则不可录入。
				DataRow dataRow = getYuyue(form);
				if(dataRow==null){
					return ErrorConstant.YUYUENOEXIST;
				}else if (form.getXiangmu().equals("安装")){
					if(dataRow.getDataElement("azjh").getInt() - dataRow.getDataElement("azsy").getInt()==0){
						return ErrorConstant.YUYUEAZ;//该日安装预约计划全部用完
					}
				}else if(form.getXiangmu().equals("收件")){
					if ("".equals(dataRow.getDataElement("qjjh"))) {
					} else {
						if(dataRow.getDataElement("qjjh").getInt() - dataRow.getDataElement("qjsy").getInt()==0){
							return ErrorConstant.YUYUEQJ;//该日收件预约计划全部用完
						}
					}
				}
				//新预约单+1
				//原预约单-1
				PaiGongDanEntiyForm f = new PaiGongDanEntiyForm();
				f.setXiaoquname(pgdOld.getDataElement("xiaoquname").getString());
				f.setPaigongriqi(pgdOld.getDataElement("paigongriqi").getString());
				f.setAnzhuangshijian(pgdOld.getDataElement("anzhuangshijian").getString());
				DataRow oldYuyue = getYuyue(f);
				
				if(form.getXiangmu().equals("安装")){
					int newYuyeAZSY = dataRow.getDataElement("azsy").getInt()+1;
					ParameterSet set = new ParameterSet();
					set.add("azsy", "@azsy", String.valueOf(newYuyeAZSY));
					set.add("UUID", "@UUID", dataRow.getDataElement("PK_ID").getString());
					set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
					set.add("updateby", "@updateby", getUserInfo().getEmployeeName());
					dao.execute("updateYuyueJh",set);
					
					int oldYuyeAZSY = oldYuyue.getDataElement("azsy").getInt()-1;
					ParameterSet set2 = new ParameterSet();
					set2.add("azsy", "@azsy", String.valueOf(oldYuyeAZSY));
					set2.add("UUID", "@UUID", oldYuyue.getDataElement("PK_ID").getString());
					set2.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
					set2.add("updateby", "@updateby", getUserInfo().getEmployeeName());
					dao.execute("updateYuyueJh",set2);
					
				}else if(form.getXiangmu().equals("收件")){
					int newYuyueQJSY =dataRow.getDataElement("qjsy").getInt()+1;
					ParameterSet set = new ParameterSet();
					set.add("qjsy", "@qjsy", String.valueOf(newYuyueQJSY));
					set.add("UUID", "@UUID", dataRow.getDataElement("PK_ID").getString());
					set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
					set.add("updateby", "@updateby", getUserInfo().getEmployeeName());
					dao.execute("updateYuyueJh",set);
					
					
					int oldYuyueQJSY = oldYuyue.getDataElement("qjsy").getInt()-1;
					ParameterSet set2 = new ParameterSet();
					set2.add("qjsy", "@qjsy", String.valueOf(oldYuyueQJSY));
					set2.add("UUID", "@UUID", oldYuyue.getDataElement("PK_ID").getString());
					set2.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
					set2.add("updateby", "@updateby", getUserInfo().getEmployeeName());
					dao.execute("updateYuyueJh",set2);
				}
				
			}
			//一下更新派工单信息
			ParameterSet set = new ParameterSet();
			//set.add("employeeId", "@employeeId", form.getEmployeeCode());
			//set.add("type", "@type", form.getTypeString());
			set.add("xiaoquname", "@xiaoquname", form.getXiaoquname());
			set.add("userplace", "@userplace", form.getUserplace());
			set.add("usertel", "@usertel", form.getUsertel());
			
			set.add("paigongriqi", "@paigongriqi", form.getPaigongriqi());
			
			
			set.add("anzhuangshijian", "@anzhuangshijian", form.getAnzhuangshijian());
			set.add("xiangmu", "@xiangmu", form.getXiangmu());
			set.add("tfkuandaidaikuan", "@tfkuandaidaikuan", form.getTfkuandaidaikuan());
			set.add("tfkdnianxian", "@tfkdnianxian", form.getTfkdnianxian());
			set.add("tfiptv", "@tfiptv", form.getTfiptv());
			set.add("tfiptvnianxian", "@tfiptvnianxian", form.getTfiptvnianxian());
			set.add("shichangbeishu", "@shichangbeishu", form.getBeishuselect());
			if(!"1".equals(form.getBeishuselect())) {
				form.setQtye(form.getQtye()+"/【资费调整"+form.getBeishuselect()+"倍】");
			}
			set.add("tfsfyewu", "@tfsfyewu", form.getQtye());
			set.add("fufei", "@fufei", form.getFufei());
			/*
			 * update679-723  .lhh
			 */
			if ("0".equals(state1)) {
				//状态为0，此号码为新号码，一定未被选择。需要把此号码状态变1，把以前号码状态变0
				updateXuanhao(oldtelhaoma1, telhaoma1);
				set.add("telhaoma1", "@telhaoma1", form.getTelhaoma1());
			} else {
				//状态为1，被别人选过的已被检测，只有是自己的号码。直接更新
				//状态为1，如果号码为00000000，把之前号码庄伟变为0.
				if ("00000000".equals(telhaoma1)) {
					updateXuanhao(oldtelhaoma1, telhaoma1);
				}
				set.add("telhaoma1", "@telhaoma1", form.getTelhaoma1());
			}
			
			if ("0".equals(state2)) {
				//状态为0，此号码为新号码，一定未被选择。需要把此号码状态变1，把以前号码状态变0
				updateXuanhao(oldtelhaoma2, telhaoma2);
				set.add("telhaoma2", "@telhaoma2", form.getTelhaoma2());
			} else {
				if ("00000000".equals(telhaoma1)) {
					updateXuanhao(oldtelhaoma2, telhaoma2);
				}
				set.add("telhaoma2", "@telhaoma2", form.getTelhaoma2());
			}
			
			if ("0".equals(state3)) {
				//状态为0，此号码为新号码，一定未被选择。需要把此号码状态变1，把以前号码状态变0
				updateXuanhao(oldtelhaoma3, telhaoma3);
				set.add("telhaoma3", "@telhaoma3", form.getTelhaoma3());
			} else {
				if ("00000000".equals(telhaoma1)) {
					updateXuanhao(oldtelhaoma3, telhaoma3);
				}
				set.add("telhaoma3", "@telhaoma3", form.getTelhaoma3());
			}
			
			if ("0".equals(state4)) {
				//状态为0，此号码为新号码，一定未被选择。需要把此号码状态变1，把以前号码状态变0
				updateXuanhao(oldtelhaoma4, telhaoma4);
				set.add("telhaoma4", "@telhaoma4", form.getTelhaoma4());
			} else {
				if ("00000000".equals(telhaoma1)) {
					updateXuanhao(oldtelhaoma4, telhaoma4);
				}
				set.add("telhaoma4", "@telhaoma4", form.getTelhaoma4());
			}
			
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
			/*set.add("kuandai", "@kuandai",form.getKuadnai() );
			set.add("tv", "@tv",form.getTv());
			set.add("tel", "@tel", form.getTel());
			set.add("useryaoqiu", "@useryaoqiu",form.getUseryaoqiu() );*/
			
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
			set.add("telhaoma3", "@telhaoma3", form.getTelhaoma3());
			set.add("telhaoma4", "@telhaoma4", form.getTelhaoma4());
			set.add("onuzhiding", "@onuzhiding", form.getOnu());
			
			set.add("UUID", "@UUID", form.getUUID());
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			set.add("fufeitype", "@fufeitype", form.getFufeitype());
			set.add("shebeixiaoshou", "@shebeixiaoshou", form.getShebeixiaoshou());
			set.add("cailiaofei", "@cailiaofei", form.getCailiaofei());
			set.add("kaipiaoxinxi", "@kaipiaoxinxi", form.getKaipiaoxinxi());
			
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
			
			set.add("newkaijishijian", "@newkaijishijian",  form.getKaijishijian());
			set.add("newtingjishijian", "@newtingjishijian",  form.getTingjishijian());
			dao.execute("updatePGDById",set);
			//----------------以下插入修改历史-------------------
			ParameterModel model1 = new ParameterModel();
			model1.put("paigongriqi", form.getPaigongriqi());
			model1.put("state", "1");
			
			model1.put("xiaoquname", form.getXiaoquname());
			model1.put("userplace", form.getUserplace());
			model1.put("usertel", form.getUsertel());
			model1.put("onu", form.getOnu());
			model1.put("jidinghe", form.getJidinghe());
			
			model1.put("anzhuangshijian", form.getAnzhuangshijian());
			model1.put("xiangmu", form.getXiangmu());
			model1.put("tfkuandaidaikuan", form.getTfkuandaidaikuan());
			model1.put("tfkdnianxian", form.getTfkdnianxian());
			model1.put("tfiptv", form.getTfiptv());
			model1.put("tfiptvnianxian", form.getTfiptvnianxian());
			model1.put("qtye", form.getQtye());
			model1.put("fufei", form.getFufei());
			model1.put("fufeitype", form.getFufeitype());
			model1.put("telhaoma1", form.getTelhaoma1());
			model1.put("telhaoma2", form.getTelhaoma2());
			
			if(form.getDxfandan()==null){
				//set.add("dxfandan", "@dxfandan", "0");
				model1.put("dxfandan", "0");
			}else{
				//set.add("dxfandan", "@dxfandan", form.getDxfandan());
				model1.put("dxfandan", form.getDxfandan());
			}
			if(form.getZhengjian()==null){
				//set.add("zhengjian", "@zhengjian", "0");
				model1.put("zhengjian", "0");
			}else{
				//set.add("zhengjian", "@zhengjian", form.getZhengjian());
				model1.put("zhengjian", form.getZhengjian());
			}
			//model1.put("dxfandan", form.getDxfandan());
			//model1.put("zhengjian", form.getZhengjian());
			
			model1.put("shoushifei", form.getShoushifei());
			model1.put("nianfei", form.getNianfei());
			model1.put("buzuyue", form.getBuzuyue());
			model1.put("chuzhuangfei", form.getChuzhuangfei());
			model1.put("kuaidaifei", form.getKuaidaifei());
			 if(form.getSelectCommunityPileID()==null||"".equals(form.getSelectCommunityPileID())) {
			    	if(form.getSelectCommunityPileID2()==null||"".equals(form.getSelectCommunityPileID2())){
			    		model1.put("beizhu", form.getBeizhu());
			    	}else{
			    		model1.put("beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum2());//+"["+form.getXiaoquname()+"][安装用]");
			    	}
			    	}else {
			    		if(form.getSelectCommunityPileID2()==null||"".equals(form.getSelectCommunityPileID2())){
			    			model1.put("beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum());//+"["+form.getXiaoquname()+"][安装用]");
				    	}else{
				    		model1.put("beizhu", form.getBeizhu() + "/箱号："+form.getEqboxnum()+"/"+form.getEqboxnum2());//+"["+form.getXiaoquname()+"][安装用]");
				    	}
			    	
				}
			//model1.put("beizhu", form.getBeizhu());
			model1.put("username", form.getUsername());//用户姓名
			//以下新增
			
			model1.put("tfkdczf", form.getTfkdczf());
			model1.put("tfkuandaifei", form.getTfkuandaifei());
			model1.put("tfiptvshoushifei", form.getTfiptvshoushifei());
			model1.put("tfjidingheyajin", form.getTfjidingheyajin());
			model1.put("yuyingshang", form.getYuyingshang());
			model1.put("qtbuzuyue", form.getQtbuzuyue());
			model1.put("heji", form.getHeji());
			
			model1.put("jiaohuanji", form.getJiaohuanji());
			model1.put("dxchuzhuangfei", form.getDxchuzhuangfei());
			
			model1.put("telhaoma4", form.getTelhaoma4());
			model1.put("telhaoma3", form.getTelhaoma3());
			
			model1.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			model1.put("operate", "客服更改");
			Employee emp = getUserInfo();
			model1.put("updateby", emp.getEmployeeName());
			model1.put("pgdUUID", form.getUUID());
			dao.insert("paigongdanhistory",model1);
			
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	private void updateXuanhao(String oldtelhaoma, String telhaoma
			) throws Exception {
		ParameterModel model = new ParameterModel();
		ParameterModel conds = new ParameterModel();
		model.put("state", "1");
		conds.put("telno", telhaoma);
		dao.update("telnumber", model, conds);
		
		ParameterModel model1 = new ParameterModel();
		ParameterModel conds1 = new ParameterModel();
		model1.put("state", "0");
		model1.put("xiaoqu", "");
		model1.put("dizhi", "");
		model1.put("beizhu", "");
		model1.put("xuanhaoby", "");
		model1.putAllowNull("xuanhaodt");
		conds1.put("telno", oldtelhaoma);
		dao.update("telnumber", model1, conds1);
	}
	
	/**
	 * 删除
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String delete(PaiGongDanEntiyForm form) throws Exception {
		try {
			openTransaction();
			DataRow pgd = getPGDByUUID(form.getUUID());
			PaiGongDanEntiyForm f = new PaiGongDanEntiyForm();
			f.setXiaoquname(pgd.getDataElement("xiaoquname").getString());
			f.setPaigongriqi(pgd.getDataElement("paigongriqi").getString());
			f.setAnzhuangshijian(pgd.getDataElement("anzhuangshijian").getString());
			DataRow Yuyue = getYuyue(f);
			if(pgd.getDataElement("xiangmu").getString().equals("安装")){
				if(Yuyue!=null) {
					int newYuyeAZSY = Yuyue.getDataElement("azsy").getInt()-1;
					ParameterSet set = new ParameterSet();
					set.add("azsy", "@azsy", String.valueOf(newYuyeAZSY));
					set.add("UUID", "@UUID", Yuyue.getDataElement("PK_ID").getString());
					set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
					set.add("updateby", "@updateby", getUserInfo().getEmployeeName());
					dao.execute("updateYuyueJh",set);
				}
				
			}else if(pgd.getDataElement("xiangmu").getString().equals("收件")){
				int newYuyueQJSY =Yuyue.getDataElement("qjsy").getInt()-1;
				ParameterSet set = new ParameterSet();
				set.add("qjsy", "@qjsy", String.valueOf(newYuyueQJSY));
				set.add("UUID", "@UUID", Yuyue.getDataElement("PK_ID").getString());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				dao.execute("updateYuyueJh",set);
				
				//所选号码 重置为未选状态
				ParameterSet set1 = new ParameterSet();
				set1.add("telno", "@telno", pgd.getDataElement("telhaoma1").getString());
				set1.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set1.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				dao.execute("updateTel2NULL", set1);
				
				ParameterSet set2 = new ParameterSet();
				set2.add("telno", "@telno", pgd.getDataElement("telhaoma2").getString());
				set2.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set2.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				dao.execute("updateTel2NULL", set2);
				
				ParameterSet set3 = new ParameterSet();
				set3.add("telno", "@telno", pgd.getDataElement("telhaoma3").getString());
				set3.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set3.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				dao.execute("updateTel2NULL", set3);
				
				ParameterSet set4 = new ParameterSet();
				set4.add("telno", "@telno", pgd.getDataElement("telhaoma4").getString());
				set4.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set4.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				dao.execute("updateTel2NULL", set4);
				
			}
			
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			dao.execute("DeletePGDById",set);
			ParameterSet delset = new ParameterSet();
			delset.add("xiaoquname", "@xiaoquname", pgd.getDataElement("xiaoquname").getString());
			delset.add("userplace", "@userplace", pgd.getDataElement("userplace").getString());
			delset.add("operateuser", "@operateuser", getUserInfo().getEmployeeName());
			delset.add("operatetime", "@operatetime", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			dao.execute("InsertDelPGDLog",delset);
			commit();
		} catch (Exception e) {
			log.error(e);
			rollback();
			throw e;
		} 
		return Constant.SUCCESS;
	}
	
	/**
	 * 解绑
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String jiebang(PaiGongDanEntiyForm form) throws Exception{
		//清除派工单对应的mac地址
		//将对应的mac设备状态设置为“5” 被解绑 状态
		DataRow dateRow = getPGDByUUID(form.getUUID());
		String mac = dateRow.getDataElement("OUMMAC").getString();
		String stbmac = dateRow.getDataElement("STBMAC").getString();
		
	//	DataRow ONU =  getEquipByUUID(mac);
	//	DataRow STB = getEquipByUUID(stbmac);
		
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			set.add("state", "@state", "1");//派工单状态设置为1；
			dao.execute("jiebang",set);
			if(null!=mac){
			ParameterSet set2 = new ParameterSet();
			set2.add("mac", "@mac", mac);
			set2.add("state", "@state", "5");//设备状态设置为5
			dao.execute("updateEquSTATE",set2);
			}
			
			//查询出绑定的机顶盒信息
			/*DataSet<DataRow> JDHList = getJidinghebangding(form.getUUID());
			for (DataRow dataRow : JDHList) {
				dateRow.getDataElement("").getString();
				ParameterSet set3 = new ParameterSet();
				set.add("", "", dateRow.getDataElement("").getString());
				set.add("", "", dataRow.getDataElement("").getString());
				dao.execute("", set3);
				
			}*/
			
			if(null!=stbmac){
				String [] stbmacs = stbmac.split("  ");	
				for (String stbmaca : stbmacs) {
					ParameterSet set3 = new ParameterSet();
					set3.add("mac", "@mac", stbmaca);
					set3.add("state", "@state", "5");//设备状态设置为5
					dao.execute("updateEquSTATE",set3);
					}
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
	 * 查询出绑定的机顶盒
	 * @param PGDUUID
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getJidinghebangding(String PGDUUID)throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("", "", PGDUUID);
		return dao.executeQuery("",set);
		}
	
	/**
	 * 根据mac查询设备对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getEquipByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("mac", "@mac", code);
		return dao.executeQueryToDataRow("GetEquipByMac",set);
	}
	
	public DataSet<DataRow>  changetv(String shichangtv) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("shichangtv", "@shichangtv", shichangtv);
		DataSet<DataRow> executeQuery = dao.executeQuery("getChangetv", set);
		return executeQuery;
	}
	public DataSet<DataRow>   changekd(String shichangkd) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("shichangkd", "@shichangkd", shichangkd);
		DataSet<DataRow> executeQuery = dao.executeQuery("getChangekd", set);
		return executeQuery;
	}
	public DataSet<DataRow>   changekdsc(String shichangkd) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("shichangkd", "@shichangkd", shichangkd);
		DataSet<DataRow> executeQuery = dao.executeQuery("getChangekdlx", set);
		return executeQuery;
	}
	public DataSet<DataRow>   changekddk(String shichangkd) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("shichangkd", "@shichangkd", shichangkd);
		DataSet<DataRow> executeQuery = dao.executeQuery("getChangekddk", set);
		return executeQuery;
	}
	public DataSet<DataRow>   changekdshichang(String shichangkd) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("shichangkd", "@shichangkd", shichangkd);
		DataSet<DataRow> executeQuery = dao.executeQuery("getChangekdsj", set);
		return executeQuery;
	}
	public DataRow   getdianxinJouhou(String shichangkd) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("shichangkd", "@shichangkd", shichangkd);
		DataRow executeQuery = dao.executeQueryToDataRow("getChangedianxin", set);
		return executeQuery;
	}
	/**
	 * 获取小区列表
	 * @return
	 * @throws Exception
	 */
	public List<CommonModule> getXiaoQuCodeAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getXiaoQuCodeAll",new ParameterSet()));
	}
	
	public List<CommonModule> getDianxintaocan()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("dianxintaocan",new ParameterSet()));
	}
	
	public List<CommonModule> getShichangAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getShichangAll",new ParameterSet()));
	}
	
	public List<CommonModule> getShichangtvAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getShichangtvAll",new ParameterSet()));
	}
	
	public List<CommonModule> getXiaoQuByQuyu(String quyu)throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("quyu", "@quyu", quyu);
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getXiaoQuCodeByQuyu",set));
	}
	
	public DataRow getCPBOXIDByPGDuuid(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		
		return dao.executeQueryToDataRow("GetEBBOXIDByPGDuuid", set);
	}
	
	public DataRow getEBBOXIDByPGDuuid(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		
		return dao.executeQueryToDataRow("GetEBBOXIDByPGDuuid", set);
	}
	
	public static void main(String[] args) {
		String a =null;
		String [] b =a.split(" ");
		for (String string : b) {
			System.out.println("111"+string);
		}
	}
}

