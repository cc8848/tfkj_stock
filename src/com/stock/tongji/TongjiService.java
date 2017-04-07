package com.stock.tongji; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessService;
import com.stock.paigongdan.PaiGongDanEntiyForm;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:29:45 
 * 类说明 
 */
public class TongjiService extends BusinessService{
	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(TongjiForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", form.getXiaoquHidden()+ "%");
		set.add("usertel", "@usertel", form.getUserTelHidden());
		set.add("state", "@state", form.getStateHidden());
		set.add("paigongriqi", "@paigongriqi", form.getPaigongriqiHidden());
		
		set.add("userplace", "@userplace", form.getDizhiHidden());
		set.add("nostate", "@nostate", "8");
		set.add("nostate2", "@nostate2", "14");
		set.add("noxiangmu", "@noxiangmu", "收件");
		
		set.add("importstate", "@importstate", form.getImportstate());
	///	set.add("stateDate", "@stateDate", form.getStateDateHidden());
	//	set.add("endDate", "@endDate", form.getEndDateHidden());
		return set;
	}
	
	public DataSet<DataRow> getResult(TongjiForm form, int first, int rows)throws Exception {
		if (form.getXiaoqu() == null) {
			return dao.executeQuery("GetEmptyDataList",getConditionParameterSet(form), first, rows);
		}
		return dao.executeQuery("GetPGDList",getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(TongjiForm form) throws Exception {
		if (form.getXiaoqu() == null) {
			return dao.executeQueryToCount("GetEmptyDataList",getConditionParameterSet(form));
		}
		return dao.executeQueryToCount("GetPGDListCount",getConditionParameterSet(form));
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
	 * 插入数据
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String insert(ChugongdanEditForm form)throws Exception{
		String[]  jidinghemac = form.getJidinghemac().split("  ");
		
		
		try {
			openTransaction();
			
			if(form.getDianshiip()!=null&&!form.getDianshiip().equals("")){
				
				ParameterModel model = new ParameterModel();
				model.put("xiaoquname", form.getXiaoquname());
				model.put("yonghu", form.getXingming());
				model.put("zhenjianno", form.getZhengjianhao());
				model.put("shoujuno", form.getShoujuhao());
				model.put("fenguang", form.getFenguangqihao());
				model.put("onuzcwz", form.getOnuzhuce());
				model.put("dizi", form.getFanghao());
				model.put("kaijishijian", form.getKaijishijian());
				model.put("tijishijian", form.getTingjishijian());
				model.put("daikuan", "0");
				model.put("tv", "标清");
				model.put("tel", form.getDianhua());
				model.put("username", "");//用户名
				model.put("passwords", "");//密码
				model.put("guhuahaoma", form.getGuhua());
				model.put("usertel", form.getLainxidianhua());
				model.put("jiguiweizhi", form.getJiguiweizhi());
				model.put("onumac", form.getOnumac());
				model.put("stbmac", jidinghemac[0]);
				
				
				model.put("tvip", form.getDianshiip());
				
				model.put("netip", "0");//宽带 ip
				model.put("telip", form.getDianhuaip());
				model.put("telvaln", form.getDianhuavlan());
				model.put("netvaln", form.getWangluovlan());
				model.put("tvvaln", form.getDianshivlan());
				model.put("qtvaln", form.getQitivlan());
				model.put("beizhu", form.getBeizhu());
				
				dao.insert("kehuziliao",model);
			}
			if(form.getDianshiip2()!=null&&!form.getDianshiip2().equals("")){
				ParameterModel model = new ParameterModel();
				model.put("xiaoquname", form.getXiaoquname());
				model.put("yonghu", form.getXingming());
				model.put("zhenjianno", form.getZhengjianhao());
				model.put("shoujuno", form.getShoujuhao());
				model.put("fenguang", form.getFenguangqihao());
				model.put("onuzcwz", form.getOnuzhuce());
				model.put("dizi", form.getFanghao());
				model.put("kaijishijian", form.getKaijishijian());
				model.put("tijishijian", form.getTingjishijian());
				model.put("daikuan", "0");
				model.put("tv", "标清");
				model.put("tel", form.getDianhua());
				model.put("username", "");//用户名
				model.put("passwords", "");//密码
				model.put("guhuahaoma", form.getGuhua());
				model.put("usertel", form.getLainxidianhua());
				model.put("jiguiweizhi", form.getJiguiweizhi());
				model.put("onumac", form.getOnumac());
				model.put("stbmac", jidinghemac[1]);
				
				
				model.put("tvip", form.getDianshiip2());
				
				model.put("netip", "0");//宽带 ip
				model.put("telip", form.getDianhuaip());
				model.put("telvaln", form.getDianhuavlan());
				model.put("netvaln", form.getWangluovlan());
				model.put("tvvaln", form.getDianshivlan());
				model.put("qtvaln", form.getQitivlan());
				model.put("beizhu", form.getBeizhu());
				
				dao.insert("kehuziliao",model);
			}
			if(form.getDianshiip3()!=null&&!form.getDianshiip3().equals("")){
				ParameterModel model = new ParameterModel();
				model.put("xiaoquname", form.getXiaoquname());
				model.put("yonghu", form.getXingming());
				model.put("zhenjianno", form.getZhengjianhao());
				model.put("shoujuno", form.getShoujuhao());
				model.put("fenguang", form.getFenguangqihao());
				model.put("onuzcwz", form.getOnuzhuce());
				model.put("dizi", form.getFanghao());
				model.put("kaijishijian", form.getKaijishijian());
				model.put("tijishijian", form.getTingjishijian());
				model.put("daikuan", "0");
				model.put("tv", "标清");
				model.put("tel", form.getDianhua());
				model.put("username", "");//用户名
				model.put("passwords", "");//密码
				model.put("guhuahaoma", form.getGuhua());
				model.put("usertel", form.getLainxidianhua());
				model.put("jiguiweizhi", form.getJiguiweizhi());
				model.put("onumac", form.getOnumac());
				model.put("stbmac", jidinghemac[2]);
				
				
				model.put("tvip", form.getDianshiip3());
				
				model.put("netip", "0");//宽带 ip
				model.put("telip", form.getDianhuaip());
				model.put("telvaln", form.getDianhuavlan());
				model.put("netvaln", form.getWangluovlan());
				model.put("tvvaln", form.getDianshivlan());
				model.put("qtvaln", form.getQitivlan());
				model.put("beizhu", form.getBeizhu());
				
				dao.insert("kehuziliao",model);
			}
			if(form.getDianshiip4()!=null&&!form.getDianshiip4().equals("")){
				ParameterModel model = new ParameterModel();
				model.put("xiaoquname", form.getXiaoquname());
				model.put("yonghu", form.getXingming());
				model.put("zhenjianno", form.getZhengjianhao());
				model.put("shoujuno", form.getShoujuhao());
				model.put("fenguang", form.getFenguangqihao());
				model.put("onuzcwz", form.getOnuzhuce());
				model.put("dizi", form.getFanghao());
				model.put("kaijishijian", form.getKaijishijian());
				model.put("tijishijian", form.getTingjishijian());
				model.put("daikuan", form.getKandai());
				model.put("tv", "0");
				model.put("tel", form.getDianhua());
				model.put("username", "");//用户名
				model.put("passwords", "");//密码
				model.put("guhuahaoma", form.getGuhua());
				model.put("usertel", form.getLainxidianhua());
				model.put("jiguiweizhi", form.getJiguiweizhi());
				model.put("onumac", form.getOnumac());
				model.put("stbmac", jidinghemac[3]);
				
				
				model.put("tvip", form.getDianshiip4());
				
				model.put("netip", "0");//宽带 ip
				model.put("telip", form.getDianhuaip());
				model.put("telvaln", form.getDianhuavlan());
				model.put("netvaln", form.getWangluovlan());
				model.put("tvvaln", form.getDianshivlan());
				model.put("qtvaln", form.getQitivlan());
				model.put("beizhu", form.getBeizhu());
				
				dao.insert("kehuziliao",model);
			}
			
			if(!form.getKandai().equals("0")){
				
				ParameterModel model = new ParameterModel();
				model.put("xiaoquname", form.getXiaoquname());
				model.put("yonghu", form.getXingming());
				model.put("zhenjianno", form.getZhengjianhao());
				model.put("shoujuno", form.getShoujuhao());
				model.put("fenguang", form.getFenguangqihao());
				model.put("onuzcwz", form.getOnuzhuce());
				model.put("dizi", form.getFanghao());
				model.put("kaijishijian", form.getKaijishijian());
				model.put("tijishijian", form.getTingjishijian());
				model.put("daikuan", form.getKandai());
				model.put("tv", "0");
				model.put("tel", form.getDianhua());
				model.put("username", form.getYonghuming());//用户名
				model.put("passwords", form.getMima());//密码
				model.put("guhuahaoma", form.getGuhua());
				model.put("usertel", form.getLainxidianhua());
				model.put("jiguiweizhi", form.getJiguiweizhi());
				model.put("onumac", form.getOnumac());
				model.put("stbmac", "0");
				
				
				model.put("tvip", "0");
				
				model.put("netip", form.getKuandaiip());//宽带 ip
				model.put("telip", form.getDianhuaip());
				model.put("telvaln", form.getDianhuavlan());
				model.put("netvaln", form.getWangluovlan());
				model.put("tvvaln", form.getDianshivlan());
				model.put("qtvaln", form.getQitivlan());
				model.put("beizhu", form.getBeizhu());
				
				dao.insert("kehuziliao",model);
			}
			
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			set.add("state", "@state", "3");//已回单
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			dao.execute("updatePGDstate",set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}


	/**
	 * 数据完工
	 * @param UUIDS
	 * @return
	 * @throws Exception
	 */
	public String operateShuJu(String[] UUIDS)throws Exception{
		try {
			openTransaction();
			
			for (String uuid : UUIDS) {
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", uuid);
				set.add("state", "@state", "5");
				set.add("shujuupdatedt", "@shujuupdatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = getUserInfo();
				set.add("shujuupdateby", "@shujuupdateby", emp.getEmployeeName());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set.add("updateby", "@updateby", emp.getEmployeeName());
				dao.execute("updateOperate",set);
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 施工中
	 * @param UUIDS
	 * @return
	 * @throws Exception
	 */
	public String operateshigong(String[] UUIDS)throws Exception{
		try {
			openTransaction();
			
			for (String uuid : UUIDS) {
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", uuid);
				set.add("state", "@state", "6");
				set.add("shigongzhongdt", "@shigongzhongdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = getUserInfo();
				set.add("shigongzhongby", "@shigongzhongby", emp.getEmployeeName());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set.add("updateby", "@updateby", emp.getEmployeeName());
				dao.execute("updateOperate",set);
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 工毕
	 * @param UUIDS
	 * @return
	 * @throws Exception
	 */
	public String operategongbi(String[] UUIDS)throws Exception{
		try {
			openTransaction();
			
			for (String uuid : UUIDS) {
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", uuid);
				set.add("state", "@state", "7");
				set.add("gongbidt", "@gongbidt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = getUserInfo();
				set.add("gongbiby", "@gongbiby", emp.getEmployeeName());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set.add("updateby", "@updateby", emp.getEmployeeName());
				dao.execute("updateOperate",set);
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 结单
	 * @param UUIDS
	 * @return
	 * @throws Exception
	 */
	public String operatejiedan(String[] UUIDS)throws Exception{
		try {
			openTransaction();
			
			for (String uuid : UUIDS) {
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", uuid);
				set.add("state", "@state", "8");
				set.add("jiedandt", "@jiedandt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = getUserInfo();
				set.add("jiedanby", "@jiedanby", emp.getEmployeeName());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set.add("updateby", "@updateby", emp.getEmployeeName());
				dao.execute("updateOperate",set);
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	/**
	 * 退单
	 * @param UUIDS
	 * @return
	 * @throws Exception
	 */
	public String operatetuidan(ChugongdanEditForm f)throws Exception{
		try {
			openTransaction();
		
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", f.getUUID());
				set.add("tuidanbeizhu", "@tuidanbeizhu", f.getTuidanbeizhu());
				set.add("state", "@state", "14");
				
				set.add("tuidandt", "@tuidandt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = getUserInfo();
				set.add("tuidanby", "@tuidanby", emp.getEmployeeName());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set.add("updateby", "@updateby", emp.getEmployeeName());
				dao.execute("updateOperate",set);
			
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	/**
	 * 异常结单
	 * @param UUIDS
	 * @return
	 * @throws Exception
	 */
	public String jiedan(ChugongdanEditForm f)throws Exception{
		try {
			openTransaction();
		
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", f.getUUID());
				set.add("jiedanbeizhu", "@jiedanbeizhu", f.getJiedanbeizhu());
				set.add("state", "@state", "8");
				
				set.add("jiedandt", "@jiedandt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = getUserInfo();
				set.add("jiedanby", "@jiedanby", emp.getEmployeeName());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				set.add("updateby", "@updateby", emp.getEmployeeName());
				dao.execute("updateOperate",set);
			
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 回单预导入
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public String preImport(String UUID,DataRow dataRow)throws Exception{
		String beizhu = "";
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("uuid", "@uuid", UUID);
			ParameterModel model = new ParameterModel();
			model.put("PUUID", UUID);
			List<String> keys = dataRow.getKeys();
			Employee emp = getUserInfo();
			for(int i =0;i<keys.size();i++) {
				String key = keys.get(i);
				if("PK_ID".equals(key)||"jiaohuanji".equals(key)) {
					continue;
				}else if("beizhu".equals(key)) {
					beizhu = dataRow.getDataElement("beizhu").getString()+"/提交信息："+emp.getEmployeeName()+" "+Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
					model.put("beizhu", beizhu);
				}else if("qtye".equals(key)) {
					String yewu = "";
					String biduikbn = dataRow.getDataElement("biduikbn").getString();
					String yewutype = dataRow.getDataElement("yewutype").getString();
					String nianxian = dataRow.getDataElement("tfkdnianxian").getString();
					if(biduikbn==null) {
						biduikbn = "0";
					}
					if(yewutype==null) {
						yewutype = "0";
					}
					if(nianxian==null) {
						nianxian = "0";
					}
					yewu = biduikbn+"/"+yewutype + "/(" +nianxian+")";
					model.put("qtye", yewu);
				}else if("netip".equals(key)) {
					String yunyingshang = dataRow.getDataElement("yuyingshang").getString();
					String wangluo = dataRow.getDataElement("tfkuandaidaikuan").getString();
					String wangluoip = dataRow.getDataElement("netip").getString();
					if(wangluoip!=null&&wangluoip.indexOf("特殊")!=-1) {
						wangluoip = wangluoip.replace("特殊", "");
					}
					if("电信".equals(yunyingshang)&&wangluo!=null&&!"".equals(wangluo)&&!"0".equals(wangluo)) {
						wangluoip = wangluoip+"@tf";
					}
					model.put("netip", wangluoip);
				}else if("telip".equals(key)) {
					String dianshiip = dataRow.getDataElement("telip").getString();
					if(dianshiip!=null) {
						if(dianshiip.indexOf("特殊")!=-1) {
							dianshiip = dianshiip.replace("特殊", "");
						}
					}
					model.put("telip", dianshiip);
				}else if("newtingjishijian".equals(key)) {
					String wangluo = dataRow.getDataElement("tfkuandaidaikuan").getString();
					String dianshi = dataRow.getDataElement("tfiptv").getString();
					String dianhua = dataRow.getDataElement("tfsfyewu").getString();
					if(checkEmpty(wangluo)&&checkEmpty(dianshi)&&!checkEmpty(dianhua)) {
						model.put("newtingjishijian", "2019-02-02");
					}else{
						if(dataRow.getDataElement("newtingjishijian")!=null) {
							model.put("newtingjishijian", dataRow.getDataElement("newtingjishijian").getString());
						}
					}
				}else{
					String data = dataRow.getDataElement(key).getString();
					if(data!=null) {
						model.put(key, data);
					}
				}
			}
			dao.insert("paigongdanpreimport", model);
			ParameterSet set2 = new ParameterSet();
			set2.add("UUID", "@UUID", UUID);
			set2.add("importstate", "@importstate", "1");
			
			set2.add("beizhu", "@beizhu", beizhu+"/提交信息："+emp.getEmployeeName()+" "+Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			set2.add("updatedt", "@updatedt",Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			set2.add("updateby", "@updateby", emp.getEmployeeName());
			dao.execute("updatePGDAfterPreimport", set2);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 内容为空时返回true
	 */
	private boolean checkEmpty(String content) {
		return content == null || "".equals(content) || " ".equals(content) || "　".equals(content) || "0".equals(content);
	}
}

