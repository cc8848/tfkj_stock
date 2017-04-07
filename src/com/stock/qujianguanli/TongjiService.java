package com.stock.qujianguanli; 

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
		
		set.add("nostate", "@nostate", "13");
		set.add("nostate2", "@nostate2", "15");
		set.add("xiangmu", "@xiangmu", "收件");
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
	 * 取件中
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
				set.add("state", "@state", "9");
				set.add("qujiandt", "@qujiandt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = (Employee)getUserInfo();
				set.add("qujianby", "@qujianby", emp.getEmployeeName());
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
	 * 已取件
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
				set.add("state", "@state", "10");
				set.add("yiqujiandt", "@yiqujiandt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = (Employee)getUserInfo();
				set.add("yiqujianby", "@yiqujianby", emp.getEmployeeName());
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
	 * 已上传
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
				set.add("state", "@state", "11");
				set.add("yishangchuandt", "@yishangchuandt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = (Employee)getUserInfo();
				set.add("yishangchuanby", "@yishangchuanby", emp.getEmployeeName());
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
	 * 已收电信下单
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
				set.add("state", "@state", "12");
				set.add("ysdxxddt", "@ysdxxddt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = (Employee)getUserInfo();
				set.add("ysdxxdby", "@ysdxxdby", emp.getEmployeeName());
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
	 * 上传客服和数据
	 * @param UUIDS
	 * @return
	 * @throws Exception
	 */
	public String operateshangchuan(String[] UUIDS)throws Exception{
		try {
			openTransaction();
			
			for (String uuid : UUIDS) {
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", uuid);
				set.add("state", "@state", "13");
				set.add("sckfsjdt", "@sckfsjdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				Employee emp = (Employee)getUserInfo();
				set.add("sckfsjby", "@sckfsjby", emp.getEmployeeName());
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
	 * 取件退单
	 * @return
	 * @throws Exception
	 */
	public String tuidan(String[] UUIDS)throws Exception{
		for (String uuid : UUIDS) {
			DataRow pgd =  getPGDByUUID(uuid);
			//更新 所选号码状态
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
			
			//更新收件单状态为已退单
			
			ParameterSet sjdset = new ParameterSet();
			sjdset.add("UUID", "@UUID", uuid);
			sjdset.add("state", "@state", "15");
			sjdset.add("tuidandt", "@tuidandt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			Employee emp = (Employee)getUserInfo();
			sjdset.add("tuidanby", "@tuidanby", emp.getEmployeeName());
			sjdset.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			sjdset.add("updateby", "@updateby", emp.getEmployeeName());
			dao.execute("updateOperate",sjdset);
		}
		
		return Constant.SUCCESS;
	}
	
	
}

