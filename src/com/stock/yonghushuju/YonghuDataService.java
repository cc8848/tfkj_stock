/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data service class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 */
package com.stock.yonghushuju;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.DataSetUtil;

/**
 * User data service class.
 * 
 * @author Zhu.Xiao-Lei
 *
 */
public class YonghuDataService extends BusinessService {
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
	public List<CommonModule> getHuidanStatusCodeAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getHuidanStatusCodeAll",new ParameterSet()));
	}
	public List<CommonModule> getYinhangAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getYinhangAll",new ParameterSet()));
	}
	
	public List<CommonModule> getSenListAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getSenListAll",new ParameterSet()));
	}
	
	private ParameterSet getConditionParameterSetByFuz(YonghuDataForm form){
		ParameterSet set = new ParameterSet();
		set.add("quyu", "@quyu", form.getQuyuCodeHidden());
		if (form.getAddressCodeHidden() == null || form.getAddressCodeHidden().equals("")) {
			set.add("address", "@address", form.getAddressCodeHidden());
		} else {
			set.add("address", "@address", "%" + form.getAddressCodeHidden() + "%");
		}
		if (form.getUserNameCodeHidden() == null || form.getUserNameCodeHidden().equals("")) {
			set.add("username", "@username", form.getUserNameCodeHidden());
		} else {
			set.add("username", "@username", "%" + form.getUserNameCodeHidden() + "%");
		}
		if (form.getTelNoCodeHidden() == null || form.getTelNoCodeHidden().equals("")) {
			set.add("telno", "@telno", form.getTelNoCodeHidden());
		} else {
			set.add("telno", "@telno", "%" + form.getTelNoCodeHidden() + "%");
		}
		if (form.getOnuCodeHidden() == null || form.getOnuCodeHidden().equals("")) {
			set.add("onu", "@onu", form.getOnuCodeHidden());
		} else {
			set.add("onu", "@onu", "%" + form.getOnuCodeHidden() + "%");
		}
		if (form.getMcidCodeHidden() == null || form.getMcidCodeHidden().equals("")) {
			set.add("mcid", "@mcid", form.getMcidCodeHidden());
		} else {
			set.add("mcid", "@mcid", "%" + form.getMcidCodeHidden() + "%");
		}
		if (form.getFenguangHidden() == null || form.getFenguangHidden().equals("")) {
			set.add("fenguang", "@fenguang", form.getFenguangHidden());
		} else {
			set.add("fenguang", "@fenguang", "%" + form.getFenguangHidden() + "%");
		}
		if (form.getShoujuhaoHidden() == null || form.getShoujuhaoHidden().equals("")) {
			set.add("shoujuhao", "@shoujuhao", form.getShoujuhaoHidden());
		} else {
			set.add("shoujuhao", "@shoujuhao", "%" + form.getShoujuhaoHidden() + "%");
		}
		set.add("kaijis", "@kaijis", form.getKaijisHidden());
		set.add("kaijie", "@kaijie", form.getKaijieHidden());
		set.add("tingjis", "@tingjis", form.getTingjisHidden());
		set.add("tingjie", "@tingjie", form.getTingjieHidden());	
		set.add("state", "@state", form.getStateCodeHidden());
		
		return set;
	}
	
	private ParameterSet getConditionParameterSetByFuzData(YonghuDataForm form){
		ParameterSet set = new ParameterSet();
		set.add("quyu", "@quyu", form.getQuyuCodeHidden());
		if (form.getAddressCodeHidden() == null || form.getAddressCodeHidden().equals("")) {
			set.add("address", "@address", form.getAddressCodeHidden());
		} else {
			set.add("address", "@address", "%" + form.getAddressCodeHidden() + "%");
		}
		if (form.getSen1() == null || form.getSen1().equals("")) {

		} else {
			set.add(form.getSen1().substring(1, form.getSen1().length()), form.getSen1(), "%" + form.getSenValue1() + "%");
		}
		if (form.getSen2() == null || form.getSen2().equals("")) {
		} else {
			set.add(form.getSen2().substring(1, form.getSen2().length()), form.getSen2(), "%" + form.getSenValue2() + "%");
		}
		if (form.getSen3() == null || form.getSen3().equals("")) {
		} else {
			set.add(form.getSen3().substring(1, form.getSen3().length()), form.getSen3(), "%" + form.getSenValue3() + "%");
		}
		if (form.getShijianleixing() == null || form.getShijianleixing().equals("")) {
		} else {
			if(form.getShijianleixing().equals("1")){
				set.add("kaijis", "@kaijis", form.getKaijisHidden());
				set.add("kaijie", "@kaijie", form.getKaijieHidden());
			}
			if(form.getShijianleixing().equals("2")){
				set.add("kaijis", "@tingjis", form.getKaijisHidden());
				set.add("kaijie", "@tingjie", form.getKaijieHidden());	
			}
			if(form.getShijianleixing().equals("3")){
				set.add("kaijis", "@shoukuanshijians", form.getKaijisHidden());
				set.add("kaijie", "@shoukuanshijiane", form.getKaijieHidden());	
			}
			//billy20141023新增有效时间查询条件
			if(form.getShijianleixing().equals("4")){
				set.add("kaijis", "@youxiaoshijians", form.getKaijisHidden());
				set.add("kaijie", "@youxiaoshijiane", form.getKaijieHidden());	
			}
		
		}
		set.add("state", "@state", form.getStateCodeHidden());
		
		return set;
	}
	
	private ParameterSet getConditionParameterSet(YonghuDataForm form){
		ParameterSet set = new ParameterSet();
		if("1".equals(form.getZhuangtai())) {
			set.add("telno", "@telno", "%" +form.getTelNoCodeHidden() + "%");
		}else{
			set.add("quyu", "@quyu", form.getQuyuCodeHidden());
			set.add("address", "@address", form.getAddressCodeHidden());
		}
		set.add("username", "@username", form.getUserNameCodeHidden());
		//set.add("telno", "@telno", form.getTelNoCodeHidden());
		set.add("onu", "@onu", form.getOnuCodeHidden());
		set.add("mcid", "@mcid", form.getMcidCodeHidden());
		set.add("state", "@state", form.getStateCodeHidden());
		if (form.getShijianleixing() == null || form.getShijianleixing().equals("")) {
		} else {
			if(form.getShijianleixing().equals("1")){
				set.add("kaijis", "@kaijis", form.getKaijisHidden());
				set.add("kaijie", "@kaijie", form.getKaijieHidden());
			}
			if(form.getShijianleixing().equals("2")){
				set.add("tingjis", "@tingjis", form.getKaijisHidden());
				set.add("tingjie", "@tingjie", form.getKaijieHidden());
			}
			if(form.getShijianleixing().equals("3")){
				set.add("shoukuanshijians", "@shoukuanshijians", form.getKaijisHidden());
				set.add("shoukuanshijiane", "@shoukuanshijiane", form.getKaijieHidden());
			}
			//billy20141023新增有效时间查询条件
			if(form.getShijianleixing().equals("4")){
				set.add("youxiaoshijians", "@youxiaoshijians", form.getKaijisHidden());
				set.add("youxiaoshijiane", "@youxiaoshijiane", form.getKaijieHidden());
			}

		}
		return set;
		
	}
	
	private ParameterSet getConditionParameterSetManageWeixiu(YonghuDataForm form){
		ParameterSet set = new ParameterSet();
		set.add("weixiuleixing", "@weixiuleixing", form.getZhuangtai());
		set.add("xiaoqu", "@xiaoqu", form.getQuyuCodeHidden());
		set.add("dizhi", "@dizhi", "%" + form.getAddressCodeHidden() + "%");
		set.add("shoukuanshijian", "@shoukuanshijian", form.getTingjiDateHidden());
		
		return set;
		
	}
	
	private ParameterSet getConditionParameterSetForTixingByFuz(YonghuDataForm form){
		ParameterSet set = new ParameterSet();
		set.add("quyu", "@quyu", form.getQuyuCodeHidden());
		set.add("address", "@address", "%" + form.getAddressCodeHidden() + "%");
		set.add("tingjishijian", "@tingjishijian", form.getTingjiDateHidden());
		
		return set;
	}
	
	private ParameterSet getConditionParameterSetForTixing(YonghuDataForm form){
		ParameterSet set = new ParameterSet();
		set.add("quyu", "@quyu", form.getQuyuCodeHidden());
		set.add("address", "@address", form.getAddressCodeHidden());
		set.add("tingjishijian", "@tingjishijian", form.getTingjiDateHidden());
		
		return set;
	}
	
	/**
	 * Get user data list.
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResult(YonghuDataForm form, int first, int rows)throws Exception {
		if (form.getAddressCode() == null ) {
			ParameterSet set = new ParameterSet();
			return dao.executeQuery("GetEmptyDataList", set, first, rows);
		}
		if (form.getZhuangtai().equals("0")){
			ParameterSet set = new ParameterSet();
			return dao.executeQuery("GetEmptyDataList", set, first, rows);
		}
		boolean e1 = form.getQuyuCode().trim().equals("");
		boolean e2 = form.getAddressCode().trim().equals("");
		boolean e3 = form.getShijianleixing().trim().equals("");
		boolean e4 = form.getKaijis().trim().equals("");
		boolean e5 = form.getKaijie().trim().equals("");
		boolean e6 = form.getStateCode().trim().equals("");
		boolean e7 = form.getSen1().trim().equals("");
		boolean e8 = form.getSenValue1().trim().equals("");
		boolean e9 = form.getSen2().trim().equals("");
		boolean e10 = form.getSenValue2().trim().equals("");
		boolean e11 = form.getSen3().trim().equals("");
		boolean e12 = form.getSenValue3().trim().equals("");
		if(e1&e2&e3&e4&e5&e6&e7&e8&e9&e10&e11&e12) {
			ParameterSet set = new ParameterSet();
			return dao.executeQuery("GetEmptyDataList", set, first, rows);
		}
		
		return dao.executeQuery("GetUserDataListByFuz", getConditionParameterSetByFuzData(form), first, rows);
	}
	
	/**
	 * Get user data list.
	 * @param form 
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResultByYunwei(YonghuDataForm form, int first, int rows)throws Exception {
		YonghuDataForm f = form;
		
		if("".equals(f.getZhuangtai())||("0".equals(f.getZhuangtai()) && f.getAddressCodeHidden() == null && f.getQuyuCodeHidden() == null)||("1".equals(f.getZhuangtai()) && f.getTelNoCode() == null))
		{
			return dao.executeQuery("GetEmptyDataList", getConditionParameterSet(form), first, rows);
		}
		
		return dao.executeQuery("GetUserDataList", getConditionParameterSet(form), first, rows);
	}
	
	/**
	 * 得到仅维修记录
	 * 
	 * @param form
	 * @param first
	 * @param
	 *
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResultWeixiu(YonghuDataForm form, int first, int rows)throws Exception {
		if(form.getAddressCode() == null)
		{
			ParameterSet set = new ParameterSet();
			set.add("quyu", "@quyu", "雅安里");
			return dao.executeQuery("GetUserWeiXiuDataList", set, first, rows);
		}
		return dao.executeQuery("GetUserWeiXiuDataList", getConditionParameterSetByFuz(form), first, rows);
	}
	
	public DataSet<DataRow> getResultYunweiByWeixiu(YonghuDataForm form, int first, int rows)throws Exception {
		YonghuDataForm f = form;
		if(f.getAddressCodeHidden() == null && f.getQuyuCodeHidden() == null)
		{
			return dao.executeQuery("GetEmptyDataList", getConditionParameterSet(form), first, rows);
		}
		return dao.executeQuery("GetUserWeiXiuDataList", getConditionParameterSet(form), first, rows);
	}

	/**
	 * Get user data list count.
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public int getResultCount(YonghuDataForm form) throws Exception {
		if (form.getAddressCode() == null) {
			return 0;
		}
		if (form.getZhuangtai().equals("0")){
			return 0;
		}
		boolean e1 = form.getQuyuCode().trim().equals("");
		boolean e2 = form.getAddressCode().trim().equals("");
		boolean e3 = form.getShijianleixing().trim().equals("");
		boolean e4 = form.getKaijis().trim().equals("");
		boolean e5 = form.getKaijie().trim().equals("");
		boolean e6 = form.getStateCode().trim().equals("");
		boolean e7 = form.getSen1().trim().equals("");
		boolean e8 = form.getSenValue1().trim().equals("");
		boolean e9 = form.getSen2().trim().equals("");
		boolean e10 = form.getSenValue2().trim().equals("");
		boolean e11 = form.getSen3().trim().equals("");
		boolean e12 = form.getSenValue3().trim().equals("");
		if(e1&e2&e3&e4&e5&e6&e7&e8&e9&e10&e11&e12) {
			return 0;
		}
		return dao.executeQueryToCount("GetUserDataListCountByFuz", getConditionParameterSetByFuzData(form));
	}
	
	/**
	 * 运维查询仅维修记录数量，如果隐藏域中无查询条件。返回空值。
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public int getResultYunweiCount(YonghuDataForm form) throws Exception {
		YonghuDataForm f = form;
		if("".equals(f.getZhuangtai())||("0".equals(f.getZhuangtai()) && f.getAddressCodeHidden() == null && f.getQuyuCodeHidden() == null)||("1".equals(f.getZhuangtai()) && f.getTelNoCode() == null))
		{
			return dao.executeQueryToCount("GetEmptyDataList", getConditionParameterSet(form));
		}
		
		return dao.executeQueryToCount("GetUserDataListCount", getConditionParameterSet(form));
	}
	
	/**
	 * 得到维修记录数量，如果隐藏域中无查询条件。返回空值。
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public int getResultWeixiuCount(YonghuDataForm form) throws Exception {
		if(form.getAddressCode() == null)
		{
			ParameterSet set = new ParameterSet();
			set.add("quyu", "@quyu", "雅安里");
			return dao.executeQueryToCount("GetUserDataByWeixiuListCount", set);
		}
		return dao.executeQueryToCount("GetUserDataByWeixiuListCount", getConditionParameterSetByFuz(form));
	}
	public int getResultWeixiuYunweiCount(YonghuDataForm form) throws Exception {
		if(form.getAddressCodeHidden() == null && form.getQuyuCodeHidden() == null)
		{
			return dao.executeQueryToCount("GetEmptyDataList", getConditionParameterSet(form));
		}
		return dao.executeQueryToCount("GetUserDataByWeixiuListCount", getConditionParameterSet(form));
	}
	
	/**
	 * Get user data list by out of service time.
	 * 得到结果通过停机时间
	 * 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResultByTingji(YonghuDataForm form, int first, int rows)throws Exception {
		if(form.getAddressCode() == null)
		{
			ParameterSet set = new ParameterSet();
			set.add("quyu", "@quyu", "雅安里");
			return dao.executeQuery("GetUserDataByTingjiList", set, first, rows);
		}
		return dao.executeQuery("GetUserDataByTingjiList", getConditionParameterSetForTixingByFuz(form), first, rows);
	}
	
	public DataSet<DataRow> getResultYunWeiByTingji(YonghuDataForm form, int first, int rows)throws Exception {
		YonghuDataForm f = form;
		if(f.getAddressCodeHidden() == null && f.getQuyuCodeHidden() == null)
		{
			return dao.executeQuery("GetEmptyDataList", getConditionParameterSet(form), first, rows);
		}
		return dao.executeQuery("GetUserDataByTingjiList", getConditionParameterSetForTixing(form), first, rows);
	}

	/**
	 * Get user data list count by out of service time.
	 * 得到结果通过停机时间，如果隐藏域中无查询条件。返回空值。
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public int getResultByTingjiCount(YonghuDataForm form) throws Exception {
		if(form.getAddressCode() == null)
		{
			ParameterSet set = new ParameterSet();
			set.add("quyu", "@quyu", "雅安里");
			return dao.executeQueryToCount("GetUserDataByTingjiListCount", set);
		}
		return dao.executeQueryToCount("GetUserDataByTingjiListCount", getConditionParameterSetForTixing(form));
	}
	public int getResultByTingjiYunweiCount(YonghuDataForm form) throws Exception {
		YonghuDataForm f = form;
		if(f.getAddressCodeHidden() == null && f.getQuyuCodeHidden() == null)
		{
			return dao.executeQueryToCount("GetEmptyDataList", getConditionParameterSetForTixing(form));
		}
		return dao.executeQueryToCount("GetUserDataByTingjiListCount", getConditionParameterSetForTixing(form));
	}
	
	/**
	 * Query user data by UUID.
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getDataByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		
		return dao.executeQueryToDataRow("GetDataByUUID", set);
	}
	
	/**
	 * Query user 待缴费 data by UUID.
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getDaijiaofeiDataByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		
		return dao.executeQueryToDataRow("GetDaijiaofeiDataByUUID", set);
	}
	
	public DataRow getDaiweixiuDataByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		
		return dao.executeQueryToDataRow("GetDaiweixiuList", set);
	}
	
	public DataRow GetEBNBOXIDByUSERuuid(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		
		return dao.executeQueryToDataRow("GetEBNBOXIDByUSERuuid", set);
	}
	
	public DataRow getDeviceJti(String cpid) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("CommunityPile_ID", "@CommunityPile_ID", cpid);
		
		return dao.executeQueryToDataRow("getXiaoqukuZhangtai", set);
	}
	
	public void changeDeviceJti(String cpid,String jti) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("CommunityPile_ID", "@CommunityPile_ID", cpid);
		set.add("EqSta_ID", "@EqSta_ID", jti);
		
		dao.execute("updateXiaoqukuZhangtai", set);
	}
	
	/**
	 * not use.
	 * 通过UUID得到数据。
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getDataByUUIDs(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		
		return dao.executeQuery("GetDataByUUIDS", set);
	}

	/**
	 * 得到一个空集。
	 * 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResultNull(YonghuDataForm form, int first,
			int rows) throws Exception {
		return dao.executeQuery("GetEmptyDataList", getConditionParameterSet(form), first, rows);
	}

	/**
	 * update user data.
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String updateData(YonghuDataEntityForm form) throws Exception {
		try {
			openTransaction();
			
			/*
			 * insert modify log to log table.(not perfect)
			 */
			ParameterSet set1 = new ParameterSet();
			set1.add("username", "@username", getUserInfo().getEmployeeName());
			set1.add("xiugai", "@xiugai", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			set1.add("uuid", "@uuid", form.getUUID());
			dao.execute("insertLogByEdit", set1);
			
			/*
			 * update yonghu data.
			 */
			ParameterSet set = new ParameterSet();
			set.add("yonghuzhuangtai", "@yonghuzhuangtai", form.getYonghuzhuangtai());
			set.add("xingming", "@xingming", form.getXingming());
			set.add("shenfensheng", "@shenfensheng", form.getShenfensheng());
			set.add("shoujuhao", "@shoujuhao", form.getShoujuhao());
			set.add("fenguangxianhao", "@fenguangxianhao", form.getFenguangxianhao());
			set.add("jiexuweizhi", "@jiexuweizhi", form.getJiexuweizhi());
			set.add("kaijishijian", "@kaijishijian", form.getKaijishijian());
			set.add("tingjishijian", "@tingjishijian", form.getTingjishijian());
			set.add("youxiaoshijian", "@youxiaoshijian", form.getYouxiaoshijian());
			set.add("xiaoqu", "@xiaoqu", form.getXiaoqu());
			set.add("dizhi", "@dizhi", form.getDizhi());
			set.add("lianxidianhua", "@lianxidianhua", form.getLianxidianhua());
			set.add("wangluo", "@wangluo", form.getWangluo());
			set.add("dianshi", "@dianshi", form.getDianshi());
			set.add("dianhua", "@dianhua", form.getDianhua());
			set.add("yewu", "@yewu", form.getYewu());
			set.add("fenguang", "@fenguang", form.getFenguang());
			set.add("onumac", "@onumac", form.getOnumac());
			set.add("stbmcid", "@stbmcid", form.getStbmcid());
			set.add("dianshiip", "@dianshiip", form.getDianshiip());
			set.add("wangluoip", "@wangluoip", form.getWangluoip());
			set.add("dianhuaip", "@dianhuaip", form.getDianhuaip());
			set.add("dianhuavlan", "@dianhuavlan", form.getDianhuavlan());
			set.add("wangluovlan", "@wangluovlan", form.getWangluovlan());
			set.add("shangmenshijian", "@shangmenshijian", isNull(form.getShangmenshijian()));
			set.add("danzheng", "@danzheng", isNull(form.getDanzheng()));
			set.add("sxdhhm", "@sxdhhm", isNull(form.getSxdhhm()));
			set.add("onuyj", "@onuyj", isNull(form.getOnuyj()));
			set.add("jidingheyj", "@jidingheyj", isNull(form.getJidingheyj()));
			set.add("shoushifei", "@shoushifei", isNull(form.getShoushifei()));
			set.add("kuandaifei", "@kuandaifei", isNull(form.getKuandaifei()));
			set.add("chuzhuangfei", "@chuzhuangfei", isNull(form.getChuzhuangfei()));
			set.add("yunyingshang", "@yunyingshang", isNull(form.getYunyingshang()));
			set.add("bzygf", "@bzygf", isNull(form.getBzygf()));
			set.add("nianfei", "@nianfei", isNull(form.getNianfei()));
			set.add("beizhu", "@beizhu", isNull(form.getBeizhu()));
			set.add("zongshoufei", "@zongshoufei", isNull(form.getZongshoufei()));
			set.add("shoujubenhao", "@shoujubenhao", isNull(form.getShoujubenhao()));
			set.add("qtsbsyqk", "@qtsbsyqk", isNull(form.getQtsbsyqk()));
			set.add("qitahaocai", "@qitahaocai", isNull(form.getQitahaocai()));
			set.add("jiexianzi", "@jiexianzi", isNull(form.getJiexianzi()));
			set.add("rj11", "@rj11", isNull(form.getRj11()));
			set.add("rj45", "@rj45", isNull(form.getRj45()));
			set.add("mokuai", "@mokuai", isNull(form.getMokuai()));
			set.add("mianban", "@mianban", isNull(form.getMianban()));
			set.add("wangxian", "@wangxian", isNull(form.getWangxian()));
			set.add("shigongren", "@shigongren", isNull(form.getShigongren()));
			set.add("xianchangbeizhu", "@xianchangbeizhu", isNull(form.getXianchangbeizhu()));
			set.add("username", "@username", getUserInfo().getEmployeeName());
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			set.add("beizhuhuizong", "@beizhuhuizong", isNull(form.getBeizhuhuizong()));
			set.add("shebeixiaoshou", "@shebeixiaoshou", isNull(form.getShebeixiaoshou()));
			set.add("cailiaofei", "@cailiaofei", isNull(form.getCailiaofei()));
			set.add("kaipiaoxinxi", "@kaipiaoxinxi", isNull(form.getKaipiaoxinxi()));
			set.add("pipeizhuangtai", "@pipeizhuangtai", form.getPipeizhuangtai());
			set.add("shoukuanshijian", "@shoukuanshijian", form.getShoukuanshijian());
			set.add("UUID", "@UUID", form.getUUID());
				
			dao.execute("updateYonghuDataById", set);
			
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		
		return Constant.SUCCESS;
	}
	
	/**
	 * not use.
	 *	更新设备数据 
	 * 
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String updateShebeiData(YonghuDataEntityForm form) throws Exception {
		try {
			openTransaction();
			
			/*
			 * insert modify log to log table.
			 */
			ParameterSet set1 = new ParameterSet();
			set1.add("username", "@username", getUserInfo().getEmployeeName());
			set1.add("xiugai", "@xiugai", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			set1.add("uuid", "@uuid", form.getUUID());
			dao.execute("insertLogByEdit", set1);
			
			/*
			 * update yonghu data.
			 */
			ParameterSet set = new ParameterSet();
			set.add("yonghuzhuangtai", "@yonghuzhuangtai", form.getYonghuzhuangtai());
			set.add("xingming", "@xingming", form.getXingming());
			set.add("shenfensheng", "@shenfensheng", form.getShenfensheng());
			set.add("shoujuhao", "@shoujuhao", form.getShoujuhao());
			set.add("fenguangxianhao", "@fenguangxianhao", form.getFenguangxianhao());
			set.add("jiexuweizhi", "@jiexuweizhi", form.getJiexuweizhi());
			set.add("kaijishijian", "@kaijishijian", form.getKaijishijian());
			set.add("tingjishijian", "@tingjishijian", form.getTingjishijian());
			set.add("xiaoqu", "@xiaoqu", form.getXiaoqu());
			set.add("dizhi", "@dizhi", form.getDizhi());
			set.add("lianxidianhua", "@lianxidianhua", form.getLianxidianhua());
			set.add("wangluo", "@wangluo", form.getWangluo());
			set.add("dianshi", "@dianshi", form.getDianshi());
			set.add("dianhua", "@dianhua", form.getDianhua());
			set.add("yewu", "@yewu", form.getYewu());
			set.add("fenguang", "@fenguang", form.getFenguang());
			set.add("onumac", "@onumac", form.getOnumac());
			set.add("stbmcid", "@stbmcid", form.getStbmcid());
			set.add("dianshiip", "@dianshiip", form.getDianshiip());
			set.add("wangluoip", "@wangluoip", form.getWangluoip());
			set.add("dianhuaip", "@dianhuaip", form.getDianhuaip());
			set.add("dianhuavlan", "@dianhuavlan", form.getDianhuavlan());
			set.add("wangluovlan", "@wangluovlan", form.getWangluovlan());
			set.add("shangmenshijian", "@shangmenshijian", isNull(form.getShangmenshijian()));
			set.add("danzheng", "@danzheng", isNull(form.getDanzheng()));
			set.add("sxdhhm", "@sxdhhm", isNull(form.getSxdhhm()));
			set.add("onuyj", "@onuyj", isNull(form.getOnuyj()));
			set.add("jidingheyj", "@jidingheyj", isNull(form.getJidingheyj()));
			set.add("shoushifei", "@shoushifei", isNull(form.getShoushifei()));
			set.add("kuandaifei", "@kuandaifei", isNull(form.getKuandaifei()));
			set.add("chuzhuangfei", "@chuzhuangfei", isNull(form.getChuzhuangfei()));
			set.add("yunyingshang", "@yunyingshang", isNull(form.getYunyingshang()));
			set.add("bzygf", "@bzygf", isNull(form.getBzygf()));
			set.add("nianfei", "@nianfei", isNull(form.getNianfei()));
			set.add("beizhu", "@beizhu", isNull(form.getBeizhu()));
			set.add("zongshoufei", "@zongshoufei", isNull(form.getZongshoufei()));
			set.add("shoujubenhao", "@shoujubenhao", isNull(form.getShoujubenhao()));
			set.add("qtsbsyqk", "@qtsbsyqk", isNull(form.getQtsbsyqk()));
			set.add("qitahaocai", "@qitahaocai", isNull(form.getQitahaocai()));
			set.add("jiexianzi", "@jiexianzi", isNull(form.getJiexianzi()));
			set.add("rj11", "@rj11", isNull(form.getRj11()));
			set.add("rj45", "@rj45", isNull(form.getRj45()));
			set.add("mokuai", "@mokuai", isNull(form.getMokuai()));
			set.add("mianban", "@mianban", isNull(form.getMianban()));
			set.add("wangxian", "@wangxian", isNull(form.getWangxian()));
			set.add("shigongren", "@shigongren", isNull(form.getShigongren()));
			set.add("xianchangbeizhu", "@xianchangbeizhu", isNull(form.getXianchangbeizhu()));
			set.add("username", "@username", getUserInfo().getEmployeeName());
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			set.add("beizhuhuizong", "@beizhuhuizong", isNull(form.getBeizhuhuizong()));
			set.add("UUID", "@UUID", form.getUUID());
			
			dao.execute("updateYonghuDataById", set);
			
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		
		return Constant.SUCCESS;
	}
	
	public String insertJiaofeo(JiaofeiDataFrom form) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String isNull(String obj) {
		String returnVal = "";
		if (obj == null || obj.trim() == "" || obj.trim().equals("")) {
			returnVal = " ";
		} else {
			returnVal = obj;
		}
		
		return returnVal;
	}

	public DataSet<DataRow> getResultDaijiaofei(YonghuDataForm form, int first,
			int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("yonghuzhuangtai", "@yonghuzhuangtai","待缴费");
		DataSet<DataRow> executeQuery = dao.executeQuery("GetDaijiaofeiList", set, first, rows);
		String linecolor = "background-color: rgb(255, 255, 255)";
		for(int i = 0;i<executeQuery.size();i++) {
			linecolor = "background-color: rgb(255, 255, 255)";
			DataRow row = executeQuery.get(i);
			//总收费
			String zongshoufei = row.getDataElement("zongshoufei").getString();
			int zonghoufeiint = 0;
			if(zongshoufei!=null) {
				zonghoufeiint = Integer.valueOf(zongshoufei);
			}
			//收据编号
			String shoujuhao = row.getDataElement("shoujubenhao").getString();
			if(zonghoufeiint==0) {
				linecolor  = "background-color: rgb(102, 255, 255)";
			}else if(zonghoufeiint>90000) {
				linecolor  = "background-color: rgb(255, 255, 0)";
			}
			if(shoujuhao!=null&&shoujuhao.length()<6) {
				linecolor  = "background-color: rgb(244, 176, 132)";
			}
			String beizhuhuizong=row.getDataElement("beizhuhuizong").getString();
			if("网上续费".equals(beizhuhuizong)||"快速续费".equals(beizhuhuizong)){
				linecolor  = "background-color: rgb(122, 172, 199)";
			}
			DataElement colordata = new DataElement();
			colordata.setCloumnName("linkcolor");
			colordata.setColumnValue(linecolor);
			row.addDataElement("linkcolor", colordata);
		}
		return executeQuery;
	}
	
	
	/**
	 * 执行修改密码和退订操作
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
    	public DataSet<DataRow> getResultOperate(YonghuDataForm form, int first, int rows) throws Exception {
        	ParameterSet set = new ParameterSet();
        	DataSet<DataRow> executeQuery = dao.executeQuery("GetOperateList", set, first, rows);
        	return executeQuery;
        }
        	
	
	public DataSet<DataRow> getResultDaiweixiu(YonghuDataForm form, int first,
			int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		
		DataSet<DataRow> executeQuery = dao.executeQuery("GetDaiweixiuList", getConditionParameterSetManageWeixiu(form), first, rows);
		String linecolor = "background-color: rgb(255, 255, 255)";
		for(int i = 0;i<executeQuery.size();i++) {
			linecolor = "background-color: rgb(255, 255, 255)";
			DataRow row = executeQuery.get(i);
			if(row.getDataElement("fenguangID").getString()==null||"".equals(row.getDataElement("fenguangID").getString())) {
				row.getDataElement("fenguang").setColumnValue(row.getDataElement("fenguang").getString());
			}else{
				row.getDataElement("fenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"green\">"+row.getDataElement("fenguang").getString()+"</font>");
			}
			//维修类型
			String weixiuleixing = row.getDataElement("weixiuleixing").getString();
			if("设备更换".equals(weixiuleixing)) {
				linecolor  = "background-color: rgb(102, 255, 255)";
			}else if("平台升级".equals(weixiuleixing)) {
				linecolor  = "background-color: rgb(255, 255, 0)";
			}else if("FTTH改造".equals(weixiuleixing)) {
				linecolor  = "background-color: rgb(227, 179, 59)";
			}
			DataElement colordata = new DataElement();
			colordata.setCloumnName("linkcolor");
			colordata.setColumnValue(linecolor);
			row.addDataElement("linkcolor", colordata);
		}
		return executeQuery;
	}

	public int getResultCountDaijiaofei(YonghuDataForm form) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("yonghuzhuangtai", "@yonghuzhuangtai","待缴费");
		return dao.executeQueryToCount("GetDaijiaofeiCount", getConditionParameterSet(form));
	}
	
	/**
	 * 获取要操作的数量
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public int getResultCountOperate(YonghuDataForm form) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQueryToCount("GetOperateCount", set);
	}
	
	public int getResultCountDaiweixiu(YonghuDataForm form) throws Exception {
		ParameterSet set = new ParameterSet();
		
		return dao.executeQueryToCount("GetDaiweixiuCount", getConditionParameterSetManageWeixiu(form));
	}
	
	public DataSet<DataRow> getResultTingji(String tingjishijian) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("tingjishijian", "@tingjishijian",tingjishijian);
		DataSet<DataRow> executeQuery = dao.executeQuery("GetResultTingji", set);
		return executeQuery;
	}
	public DataRow getXiaoquCode(String cpname) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("CommunityName", "@CommunityName", cpname);
		
		return dao.executeQueryToDataRow("getXiaoquCode", set);
	}
	public DataSet<DataRow> getKuandaiByXiaoqu(String xiaoqu) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu",xiaoqu);
		DataSet<DataRow> executeQuery = dao.executeQuery("getKuandaiByXiaoqu", set);
		return executeQuery;
	}
	public DataSet<DataRow> getDianshiByXiaoqu(String xiaoqu) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu",xiaoqu);
		DataSet<DataRow> executeQuery = dao.executeQuery("getDianshiByXiaoqu", set);
		return executeQuery;
	}
	public DataSet<DataRow> getAllKuandaiByXiaoqu(String xiaoqu) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu",xiaoqu);
		DataSet<DataRow> executeQuery = dao.executeQuery("getAllKuandaiByXiaoqu", set);
		return executeQuery;
	}
	public DataSet<DataRow> getAllDianshiByXiaoqu(String xiaoqu) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu",xiaoqu);
		DataSet<DataRow> executeQuery = dao.executeQuery("getAllDianshiByXiaoqu", set);
		return executeQuery;
	}
}
