package com.stock.weihu;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.DataSetUtil;
import com.webService.log.WebServiceLogForm;

public class WeihuService extends BusinessService{

    	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(ShichangEidtForm form){
		ParameterSet set = new ParameterSet();
		return set;
	}
	
	public DataSet<DataRow> getResult(ShichangEidtForm form, int first, int rows)throws Exception {
		return dao.executeQuery("getShichangInfo",getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(ShichangEidtForm form) throws Exception {
		return dao.executeQueryToCount("getShichangInfoCount",getConditionParameterSet(form));
	}
	
	/**
	 * 增加时长
	 * @param f
	 * @return
	 */
	public CommonMessage insertShichang(ShichangEidtForm f) {
		try {
			ParameterModel model = new ParameterModel();
			model.put("shichangName", f.getShichang());
			model.put("seq", 	f.getSeq());
			model.put("beiyong1", 	f.getLeixing());
			model.put("beiyong2", 	f.getDaikuan());
			model.put("beiyong3", 	Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			model.put("shichang", 	f.getShichangyue());
			model.put("jine", 	f.getJine());
			dao.insert("shichang", model);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加成功！");
	}

	/**
	 * 编辑时长初始化
	 * @param f
	 * @throws Exception
	 */
	public void editInit(ShichangEidtForm f) throws Exception {
		String uuid = f.getUUID();
		ParameterSet set = new ParameterSet();
		set.add("id", "@id", uuid);
		DataRow dataRow = dao.executeQueryToDataRow("getShichangInfo", set);
		String shichangName = dataRow.getDataElement("shichangName").getString();
		String seq = dataRow.getDataElement("seq").getString();
		String leixing = dataRow.getDataElement("leixing").getString();
		String daikuan = dataRow.getDataElement("daikuan").getString();
		String shichangyue = dataRow.getDataElement("shichangyue").getString();
		String jine = dataRow.getDataElement("jine").getString();
		f.setShichang(shichangName);
		f.setSeq(seq);
		f.setLeixing(leixing);
		f.setDaikuan(daikuan);
		f.setUUIDHidden(uuid);
		f.setShichangyue(shichangyue);
		f.setJine(jine);
	}

	/**
	 * 更新时长
	 * @param f
	 * @return
	 */
	public CommonMessage update(ShichangEidtForm f) {
		try {
			f.getUUIDHidden();
			ParameterModel model = new ParameterModel();
			model.put("shichangName", f.getShichang());
			model.put("seq", f.getSeq());
			model.put("beiyong1", f.getLeixing());
			model.put("beiyong2", f.getDaikuan());
			model.put("shichang", f.getShichangyue());
			model.put("jine", f.getJine());
			ParameterModel conds = new ParameterModel();
			conds.put("id", f.getUUIDHidden());
			dao.update("shichang", model, conds);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "编辑失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "编辑成功！");
	}

	public void delete(ShichangEidtForm f) throws Exception {
		String uuid = f.getUUID();
		ParameterSet set = new ParameterSet();
		set.add("id", "@id", uuid);
		dao.execute("shichangDelete", set);
	}
	
	
	
//*************************小区相关********************	
	

	public DataSet<DataRow> getResultXiaoqu(XiaoquForm form, int first, int rows) throws Exception {
		return dao.executeQuery("getXiaoquInfo", new ParameterSet(), first, rows);
	}

	public int getResultXiaoquCount(XiaoquForm form) {
		return 0;
	}

	public CommonMessage insertXiaoqu(XiaoquForm f) {
		try {
		//判断有无小区
			if (isHaveCommunity(f)){
				ParameterModel model = new ParameterModel();
				model.put("CommunityName", f.getName());//小区名
				model.put("CommunityRemark", 	f.getSeq());//排序
				model.put("District_ID", 	f.getQuyu());//区域ID
				model.put("netcode", 	f.getNetcode());//
				model.put("tvcode", 	f.getTvcode());
				model.put("Create_time", 	Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				model.put("address", f.getAddress());
				model.put("costumecount", f.getCostumeCount());
				model.put("storeID", f.getKufang());//库房
				model.put("remark", f.getRemark());
				
				ParameterModel model1 = new ParameterModel();
				model1.put("name", f.getName());//小区名
				model1.put("seq", 	f.getSeq());//排序
				model1.put("quyu", 	f.getQuyuName());//区域ID	
				model1.put("netcode", 	f.getNetcode());//
				model1.put("tvcode", 	f.getTvcode());
				model1.put("address", f.getAddress());
				model1.put("costumecount", f.getCostumeCount());
				
				try {
					openTransaction();
					dao.insert("community", model);
					dao.insert("xiaoqucode1", model1);
					commit();
				} catch (Exception e) {
					rollback();
					e.printStackTrace();
					return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
				}
			} else {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "小区已存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加成功！");
	}

	

	public CommonMessage updateXiaoqu(XiaoquForm f) {
		try {
			//判断区域是否存在
			if (isHaveQuYu1(f)) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "区域不存在！");
			}
			if(f.getName().equals(f.getNameHidden())) {
				ParameterModel model = new ParameterModel();
				model.put("netcode", f.getNetcode());
				model.put("CommunityRemark", f.getSeq());
				model.put("tvcode", f.getTvcode());
				model.put("District_ID", f.getQuyu());
				model.put("address", f.getAddress());
				model.put("costumecount", f.getCostumeCount());
				ParameterModel conds = new ParameterModel();
				conds.put("Community_ID", f.getUuidHidden());
				model.put("storeID", f.getKufang());
				model.put("remark", f.getRemark());
				dao.update("community", model, conds);
				
				ParameterModel model1 = new ParameterModel();
				model1.put("netcode", f.getNetcode());
				model1.put("seq", f.getSeq());
				model1.put("tvcode", f.getTvcode());
				model1.put("quyu", f.getQuyuName());
				ParameterModel conds1 = new ParameterModel();
				conds1.put("name", f.getName());
				model1.put("address", f.getAddress());
				model1.put("costumecount", f.getCostumeCount());
				dao.update("xiaoqucode1", model1, conds1);
			} else {
			//判断小区是否存在
				if(isHaveCommunity(f)){
					ParameterModel model = new ParameterModel();
					model.put("CommunityName", f.getName());
					model.put("netcode", f.getNetcode());
					model.put("CommunityRemark", f.getSeq());
					model.put("tvcode", f.getTvcode());
					model.put("District_ID", f.getQuyu());
					model.put("address", f.getAddress());
					model.put("costumecount", f.getCostumeCount());
					ParameterModel conds = new ParameterModel();
					conds.put("Community_ID", f.getUuidHidden());
					model.put("storeID", f.getKufang());
					model.put("remark", f.getRemark());
					dao.update("community", model, conds);
					ParameterModel model1 = new ParameterModel();
					model1.put("netcode", f.getNetcode());
					model1.put("seq", f.getSeq());
					model1.put("tvcode", f.getTvcode());
					model1.put("quyu", f.getQuyuName());
					model1.put("name", f.getName());
					
					ParameterModel conds1 = new ParameterModel();
					conds1.put("name", f.getNameHidden());
					model1.put("address", f.getAddress());
					model1.put("costumecount", f.getCostumeCount());
					
					dao.update("xiaoqucode1", model1, conds1);
				} else {
					return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "小区重复，编辑失败！");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "编辑成功！");
	}
	public CommonMessage delete(XiaoquForm f) {
		try {
			//删除之前判断小区下有无 绑定 设备。
			String uuid = f.getUUID();
//			ParameterSet setw = new ParameterSet();
//			setw.add("Community_ID", "@Community_ID", uuid);
//			int count = dao.executeQueryToCount("isHaveProduct", setw);
//			if (count > 0) {
//				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "不能删除,小区有设备库存！");
//			}
			
			ParameterSet set3 = new ParameterSet();
			set3.add("id", "@id", uuid);
			String name = dao.executeQueryToDataRow("getXiaoquInfo", set3).getDataElement("CommunityName").getString();
			ParameterSet set = new ParameterSet();
			set.add("CommunityName", "@CommunityName", name);
			ParameterSet set1 = new ParameterSet();
			set1.add("name", "@name", name);
			dao.execute("xiaoquweihuDelete", set);
			dao.execute("xiaoquweihuDelete1", set1);
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "删除成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "删除失败！");
		}
	}

	public void editInit(XiaoquForm f) throws Exception {
		String uuid = f.getUUID();
	    ParameterSet set = new ParameterSet();
	    set.add("id", "@id", uuid);
		DataRow dataRow = dao.executeQueryToDataRow("getXiaoquInfo", set);
		String CommunityName = dataRow.getDataElement("CommunityName").getString();
		String seq = dataRow.getDataElement("seq").getString();
		String netcode = dataRow.getDataElement("netcode").getString();
		String tvcode = dataRow.getDataElement("tvcode").getString();
		String District_ID = dataRow.getDataElement("District_ID").getString();
		String address = dataRow.getDataElement("address").getString();
		String costumeCount = dataRow.getDataElement("costumeCount").getString();
		String kufang = dataRow.getDataElement("kufang").getString();
		String remark = dataRow.getDataElement("remark").getString();
		
		f.setName(CommunityName);
		f.setSeq(seq);
		f.setNetcode(netcode);
		f.setTvcode(tvcode);
		f.setQuyu(District_ID);
		f.setKufang(kufang);
		f.setAddress(address);
		f.setCostumeCount(costumeCount);
		f.setUuidHidden(uuid);
		f.setNameHidden(CommunityName);
		f.setRemark(remark);
		
	}
	
	
//*************************区域相关********************	
	public DataSet<DataRow> getResultQuyu(XiaoquForm form, int first, int rows) throws Exception {
		return dao.executeQuery("getQuyuInfo", new ParameterSet(), first, rows);
	}

	public int getResultQuyuCount(XiaoquForm form) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void editInitQuyu(XiaoquForm f) throws Exception {
		String uuid = f.getUUID();
	    ParameterSet set = new ParameterSet();
	    set.add("id", "@id", uuid);
		DataRow dataRow = dao.executeQueryToDataRow("getQuyuInfo", set);
		String quyu = dataRow.getDataElement("District_Name").getString();
		String suoshuquyu = dataRow.getDataElement("suoshuquyu").getString();
		
		f.setQuyu(quyu);
		f.setSuoshuquyu(suoshuquyu);
		f.setUuidHidden(uuid);
		f.setNameHidden(quyu);
	}

	public CommonMessage insertQuyu(XiaoquForm f) {
		
		try {
			//判断区域是否存在
			if (isHaveQuYu(f)) {
				ParameterModel model = new ParameterModel();
				model.put("District_Name", f.getQuyu());
				model.put("suoshuquyu", f.getSuoshuquyu());
				dao.insert("district", model);
			} else {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "存在此区域，编辑失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加成功！");
	}

	
	public CommonMessage updateQuyu(XiaoquForm f) {
		try {
			if(f.getQuyu().equals(f.getNameHidden())) {
				ParameterModel model = new ParameterModel();
				model.put("District_Name", f.getQuyu());
				model.put("suoshuquyu", f.getSuoshuquyu());
				ParameterModel conds = new ParameterModel();
				conds.put("District_ID", f.getUuidHidden());
				dao.update("district", model, conds);
			} else {
			//判断区域是否存在
				if(isHaveQuYu(f)){
					ParameterModel model = new ParameterModel();
					model.put("District_Name", f.getQuyu());
					model.put("suoshuquyu", f.getSuoshuquyu());
					ParameterModel conds = new ParameterModel();
					conds.put("District_ID", f.getUuidHidden());
					dao.update("district", model, conds);
				} else {
					return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "存在此区域，编辑失败！");
					
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "编辑失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "编辑成功！");
	}


	public CommonMessage deleteQuyu(XiaoquForm f)  {
		try {
			String uuid = f.getUUID();
			//判断区域下面是否有小区
			ParameterSet set1 = new ParameterSet();
			set1.add("District_ID", "@District_ID", uuid);
			String string = dao.executeQueryToDataRow("isQuyuHaveXiaoquInfo",set1).getDataElement("cnt").getString();
			if (string.equals("0")){
				ParameterSet set = new ParameterSet();
				set.add("District_ID", "@District_ID", uuid);
				dao.execute("quyuweihuDelete", set);
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "删除成功！");
			} else {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "区域下存在小区，不能删除！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "删除失败！");
		}
	}

	
	public List<CommonModule> getQuYuCodeAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("GetQuyuList",new ParameterSet()));
	}
	
	public List<CommonModule> getKuFangCodeAll()throws Exception{
		DataSet<DataRow> kufanglist = dao.executeQuery("GetKuFangList",new ParameterSet());
//		for(int i = 0;i<kufanglist.size();i++) {
//			if("2".equals(kufanglist.get(i).getDataElement("level"))) {
//				kufanglist.get(i).addDataElement("store_name", kufanglist.get(i).getDataElement("store_name"));
//			}
//		}
		return DataSetUtil.toCommonModuleList(kufanglist);
	}

	private boolean isHaveQuYu(XiaoquForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("District_Name", "@District_Name", f.getQuyu().trim());
		String string = dao.executeQueryToDataRow("isHaveQuyuInfo",set).getDataElement("cnt").getString();
		return string.equals("0");
	}
	
	private boolean isHaveQuYu1(XiaoquForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("District_ID", "@District_ID", f.getQuyu().trim());
		String string = dao.executeQueryToDataRow("isHaveQuyuInfo",set).getDataElement("cnt").getString();
		return string.equals("0");
	}
	
	private boolean isHaveCommunity(XiaoquForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("CommunityName", "@CommunityName", f.getName().trim());
		String string = dao.executeQueryToDataRow("isHaveCommunityInfo",set).getDataElement("cnt").getString();
		//不存在
//存在
		return string.equals("0");
	}

	private ParameterSet getConditionParameterSet(DianshiEidtForm form){
		ParameterSet set = new ParameterSet();
		return set;
	}
	public DataSet<DataRow> getResultDianshi(DianshiEidtForm form, int first, int rows) throws Exception {
		return dao.executeQuery("getDianshiInfo",getConditionParameterSet(form), first, rows);
	}

	public int getResultDianshiCount(DianshiEidtForm form) throws Exception {
		return dao.executeQueryToCount("getShichangInfoCount",getConditionParameterSet(form));
	}

	public CommonMessage insertDianshi(DianshiEidtForm f) {
		try {
			ParameterModel model = new ParameterModel();
			model.put("shichangName", f.getShichangName());
			model.put("seq", 	f.getSeq());
			model.put("shichangLeibie", 	f.getShichangLeibie());
			model.put("yewuLeibie", 	f.getYewuLeibie());
			model.put("shichangYue", 	f.getShichangyue());
			model.put("jine", 	f.getJine());
			dao.insert("dianshiyewu", model);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加成功！");
	}

	public CommonMessage update(DianshiEidtForm f) {
		try {
			f.getUUIDHidden();
			ParameterModel model = new ParameterModel();
			model.put("shichangName", f.getShichangName());
			model.put("shichangLeibie", f.getShichangLeibie());
			model.put("yewuLeibie", f.getYewuLeibie());
			model.put("shichangYue", f.getShichangyue());
			model.put("jine", f.getJine());
			model.put("seq", f.getSeq());
			ParameterModel conds = new ParameterModel();
			conds.put("id", f.getUUIDHidden());
			dao.update("dianshiyewu", model, conds);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "编辑失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "编辑成功！");
	}

	public void editInit(DianshiEidtForm f) throws Exception {
		String uuid = f.getUUID();
		ParameterSet set = new ParameterSet();
		set.add("id", "@id", uuid);
		DataRow dataRow = dao.executeQueryToDataRow("getDianshiInfo", set);
		String shichangName = dataRow.getDataElement("shichangName").getString();
		String seq = dataRow.getDataElement("seq").getString();
		String leixing = dataRow.getDataElement("shichangLeibie").getString();
		String daikuan = dataRow.getDataElement("yewuLeibie").getString();
		String shichangyue = dataRow.getDataElement("shichangyue").getString();
		String jine = dataRow.getDataElement("jine").getString();
		f.setShichangName(shichangName);
		f.setSeq(seq);
		f.setShichangLeibie(leixing);
		f.setYewuLeibie(daikuan);
		f.setUUIDHidden(uuid);
		f.setShichangyue(shichangyue);
		f.setJine(jine);
	}

	public void delete(DianshiEidtForm f) throws Exception {
		String uuid = f.getUUID();
		ParameterSet set = new ParameterSet();
		set.add("id", "@id", uuid);
		dao.execute("dianshiDelete", set);
	}
	/**
	 * @param form
	 * @return
	 * @author billy by 20140919
	 */
	private ParameterSet getConditionParameterSet(IptvlogEidtForm form){
		ParameterSet set = new ParameterSet();
		set.add("tingjizhanghao", "@tingjizhanghao", form.getTingjizhanghaoHidden());
		set.add("tingjishijian", "@tingjishijian", form.getTingjishijianHidden());
		set.add("shifouchenggong", "@shifouchenggong", form.getShifouchenggongHidden());
		set.add("interfaceType", "@interfaceType", form.getInterfaceType());
		set.add("isweb", "@isweb", form.getIsweb());
		return set;
	}
	/**
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 * @author billy by 20140919
	 */
	public DataSet<DataRow> getResultIptvlog(IptvlogEidtForm form, int first, int rows) throws Exception {
		if (form.getShifouchenggong() == null) {
			return dao.executeQuery("GetEmptyDataList",getConditionParameterSet(form), first, rows);
		}
		return dao.executeQuery("getIptvlogInfo",getConditionParameterSet(form), first, rows);
	}
	/**
	 * @param form
	 * @return
	 * @throws Exception
	 * @author billy by 20140919
	 */
	public int getResultIptvlogCount(IptvlogEidtForm form) throws Exception {
		if (form.getShifouchenggong() == null) {
			return dao.executeQueryToCount("GetEmptyDataList",getConditionParameterSet(form));
		}
		return dao.executeQueryToCount("getIptvlogInfoCount",getConditionParameterSet(form));
	}
	/**
	 * @param f
	 * @return
	 * @author billy by 20140919
	 */
	public CommonMessage insertIptvlog(IptvlogEidtForm f) {
		try {
			ParameterModel model = new ParameterModel();
			model.put("tingjishijian", f.getTingjishijian());
			model.put("tingjizhanghao", 	f.getTingjizhanghao());
			model.put("shifouchenggong", 	f.getShifouchenggong());
			model.put("shibaibianhao", 	f.getShibaibianhao());
			model.put("shibaixinxi", 	f.getShibaixinxi());
			model.put("createdt", 	f.getCreatedt());
			model.put("serverip", 	f.getServerip());
			model.put("interfaceType", 	f.getInterfaceType());
			model.put("isweb", 	f.getIsweb());
			dao.insert("iptvlog", model);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加成功！");
	}
	public CommonMessage insertXiaoQuKuandai(String xiaoquid,String yewuid) {
		try {
			ParameterModel model = new ParameterModel();
			model.put("Community_ID", xiaoquid);
			model.put("shichang_ID", 	yewuid);
			dao.insert("xiaoqushichangLink", model);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加成功！");
	}
	
	public CommonMessage insertXiaoQuDianshi(String xiaoquid,String yewuid) {
		try {
			ParameterModel model = new ParameterModel();
			model.put("Community_ID", xiaoquid);
			model.put("dianshiyewu_ID", yewuid);
			dao.insert("xiaoqudianshiyewuLink", model);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加成功！");
	}
	public CommonMessage removeXiaoQuAllKuandai(String xiaoquid) {
		try {
			ParameterSet set = new ParameterSet();
			set.add("Community_ID", "@Community_ID", xiaoquid);
			dao.execute("removeXiaoQuAllKuandai",set);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "删除失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "删除成功！");
	}
	public CommonMessage removeXiaoQuAllDianshi(String xiaoquid) {
		try {
			ParameterSet set = new ParameterSet();
			set.add("Community_ID", "@Community_ID", xiaoquid);
			dao.execute("removeXiaoQuAllDianshi",set);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "删除失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "删除成功！");
	}
	
	
}
