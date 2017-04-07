/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: kucun data service class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2013-03-18   Li.Hai-Han            Create
 */
package com.stock.huidan;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.frame.BusinessService;
import com.stock.paigongdan.PaiGongDanEntiyForm;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.DataSetUtil;


public class HuidanDataService extends BusinessService {
	private Log log = LogFactory.getLog(this.getClass());	
	private CommonDao dao = new CommonDao();
	
	/**
	 * get user status for query page init.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CommonModule> getStatusCodeAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getStatusCodeAll",new ParameterSet()));
	}
	public List<CommonModule> getYinhangAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getYinhangAll",new ParameterSet()));
	}
	
	public List<CommonModule> getSenListAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getSenListAll",new ParameterSet()));
	}
	
	
	/**
	 * 得到UUID对应的数据
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	public DataRow getDataByUUID(String uuid) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("uuid", "@uuid", uuid);
		return dao.executeQueryToDataRow("GongdanCheckDataInfo", set);
	}
	
	public String update(PaiGongDanEntiyForm form) throws Exception {
		try {
		openTransaction();
		ParameterSet set = new ParameterSet();
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
		dao.execute("updateHuidanById",set);
		commit();
	} catch (Exception e) {
		rollback();
		log.error(e);
		throw e;
	}
	return Constant.SUCCESS;
	}
	
	/**
	 * 根据UUID查找相应小区的数据
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getDataByUUIDOnu(String xiaoqu,String dizhi,String onumac) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu", xiaoqu);
		set.add("dizhi", "@dizhi", dizhi);
		set.add("onumac", "@onumac", onumac);
		return dao.executeQuery("checkguanlianshebei", set);
	}
	/**
	 * 根据UUID查找相应小区的数据
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getDataByUUIDStb(String xiaoqu,String dizhi,String stbmcid) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu", xiaoqu);
		set.add("dizhi", "@dizhi", dizhi);
		set.add("stbmcid", "@stbmcid", stbmcid);
		return dao.executeQuery("checkguanlianshebei", set);
	}
	
	/**
	 * 根据UUID查找相应小区的数据
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getWXDataByUUIDOnu(String xiaoqu,String dizhi) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu", xiaoqu);
		set.add("dizhi", "@dizhi", dizhi);
		return dao.executeQuery("GetDaiweixiuListByXiaoQuDizhiOnu", set);
	}
	/**
	 * 根据UUID查找相应小区的数据
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getWXDataByUUIDStb(String xiaoqu,String dizhi) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu", xiaoqu);
		set.add("dizhi", "@dizhi", dizhi);
		return dao.executeQuery("GetDaiweixiuListByXiaoQuDizhiSTBMCID", set);
	}
	/**
	 * 根据UUID查找相应小区的数据
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	public void updateHuidanEQByUUID(String uuid, String eqtype, String eqid,String eqvalue) throws Exception {
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			ParameterModel conds = new ParameterModel();
			if ("0".equals(eqtype)) {
				model.put("onumac", eqvalue);
				model.put("CommunityPile_ID", eqid);
			} else {
				model.put("stbmcid", eqvalue);
				model.put("CommunityPile_ID2", eqid);
			}
			conds.put("uuid", uuid);
			dao.update("huidandata", model, conds);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
	}
	/**
	 * 根据UUID查找相应小区的数据
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	public void updateWXByUUID(String uuid,String newjti) throws Exception {
		ParameterModel model = new ParameterModel();
		ParameterModel conds = new ParameterModel();
		model.put("yonghuzhuangtai", newjti);
		conds.put("uuid", uuid);
		dao.update("yonghushuju", model, conds);
	}
}
