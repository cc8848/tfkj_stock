package com.stock.caiwuhedui.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class ZhangMuEditService extends BusinessService{
	private Log log = LogFactory.getLog(this.getClass());	
	private CommonDao dao = new CommonDao();
	ParameterSet set = new ParameterSet();
	List<String> zhifuleixinglist = new ArrayList<String>() ;
	List<String> uuidlist =new ArrayList<String>() ;

	public CommonMessage savePipeidata(ZhangMuForm f) throws Exception {
		
		zhifuleixinglist.clear();
		uuidlist.clear();
		
		String zhangmuUUID = f.getZhangmuUUIDHidden();//对应账目的ID
		String zongshoufei = f.getZongshoufeiHidden();//总收费
		String zhifuleixingStr = f.getZhifuleixingHidden(); //要存储的用户数据的支付类型
		String uuidStr = f.getUUIDHidden();              //要存储的用户数据的UUID
		/*
		 * 支付类型存到list中。
		 */
		while(zhifuleixingStr.indexOf(",") >= 0){
			int index = zhifuleixingStr.indexOf(",");
			zhifuleixinglist.add(zhifuleixingStr.substring(0, index));
			zhifuleixingStr = zhifuleixingStr.substring(index + 1, zhifuleixingStr.length());
		}
		zhifuleixinglist.add(zhifuleixingStr);
		
		/*
		 * UUID存到list中。
		 * */
		while(uuidStr.indexOf(",") >= 0){
			int index = uuidStr.indexOf(",");
			uuidlist.add(uuidStr.substring(0, index));
			uuidStr = uuidStr.substring(index + 1, uuidStr.length());
		}
		uuidlist.add(uuidStr);
		
		try {
			openTransaction();
			String uuid;
			String zhifuleixing;
			if(uuidlist.size()==zhifuleixinglist.size())
			{
				for(int i = 0 ; i < uuidlist.size(); i ++)
				{
					uuid = uuidlist.get(i);
					zhifuleixing = zhifuleixinglist.get(i);
					ParameterSet set = new ParameterSet();
					//GetDataByUUID
					set.add("UUID", "@UUID", uuid);
					DataSet<DataRow> query = dao.executeQuery("GetDataByUUID", set);
					
					/*
					 * 插入已匹配数据
					 * */
				    ParameterModel caiwumodel = new ParameterModel();
				    caiwumodel.put("zhifuleixing",zhifuleixing);
				    caiwumodel.put("shujuid",uuid);
				    caiwumodel.put("zmid",zhangmuUUID);
				    caiwumodel.put("yonghuzhuangtai",query.get(0).getDataElement("yonghuzhuangtai").getString());
				    caiwumodel.put("shoukuanshijian",query.get(0).getDataElement("shoukuanshijian").getString());
				    caiwumodel.put("xingming",query.get(0).getDataElement("xingming").getString());
				    caiwumodel.put("shenfenzheng",query.get(0).getDataElement("shenfensheng").getString());
				    caiwumodel.put("shoujuhao",query.get(0).getDataElement("shoujuhao").getString());
				    caiwumodel.put("fenguangxianhao",query.get(0).getDataElement("fenguangxianhao").getString());
				    caiwumodel.put("jiexuweizhi",query.get(0).getDataElement("jiexuweizhi").getString());
				    caiwumodel.put("kaijishijian",query.get(0).getDataElement("kaijishijian").getString());
				    caiwumodel.put("tingjishijian",query.get(0).getDataElement("tingjishijian").getString());
			 	    caiwumodel.put("xiaoqu",query.get(0).getDataElement("xiaoqu").getString());
				    caiwumodel.put("dizhi",query.get(0).getDataElement("dizhi").getString());
				    caiwumodel.put("lianxidianhua",query.get(0).getDataElement("lianxidianhua").getString());
				    caiwumodel.put("wangluo",query.get(0).getDataElement("wangluo").getString());
				    caiwumodel.put("dianshi",query.get(0).getDataElement("dianshi").getString());
				    caiwumodel.put("dianhua",query.get(0).getDataElement("dianhua").getString());
				    caiwumodel.put("yewu",query.get(0).getDataElement("yewu").getString());
				    caiwumodel.put("fenguang",query.get(0).getDataElement("fenguang").getString());
				    caiwumodel.put("onumac",query.get(0).getDataElement("onumac").getString());
				    caiwumodel.put("stbmcid",query.get(0).getDataElement("stbmcid").getString());
				    caiwumodel.put("dianshiip",query.get(0).getDataElement("dianshiip").getString());
				    caiwumodel.put("wangluoip",query.get(0).getDataElement("wangluoip").getString());
				    caiwumodel.put("dianhuaip",query.get(0).getDataElement("dianhuaip").getString());
				    caiwumodel.put("dianhuavlan",query.get(0).getDataElement("dianhuavlan").getString());
				    caiwumodel.put("wangluovlan",query.get(0).getDataElement("wangluovlan").getString());
				    caiwumodel.put("shangmenshijian",query.get(0).getDataElement("shangmenshijian").getString());
				    caiwumodel.put("danzheng",query.get(0).getDataElement("danzheng").getString());
				    caiwumodel.put("sxdhhm",query.get(0).getDataElement("sxdhhm").getString());
				    caiwumodel.put("onuyj",query.get(0).getDataElement("onuyj").getString());
				    caiwumodel.put("jidingheyj",query.get(0).getDataElement("jidingheyj").getString());
				    caiwumodel.put("shoushifei",query.get(0).getDataElement("shoushifei").getString());
				    caiwumodel.put("kuandaifei",query.get(0).getDataElement("kuandaifei").getString());
				    caiwumodel.put("chuzhuangfei",query.get(0).getDataElement("chuzhuangfei").getString());
				    caiwumodel.put("shebeixiaoshou",query.get(0).getDataElement("shebeixiaoshou").getString());
				    caiwumodel.put("cailiaofei",query.get(0).getDataElement("cailiaofei").getString());
				    caiwumodel.put("yunyingshang",query.get(0).getDataElement("yunyingshang").getString());
				    caiwumodel.put("bzygf",query.get(0).getDataElement("bzygf").getString());
				    caiwumodel.put("nianfei",query.get(0).getDataElement("nianfei").getString());
				    caiwumodel.put("beizhu",query.get(0).getDataElement("beizhu").getString());
				    caiwumodel.put("zongshoufei",query.get(0).getDataElement("zongshoufei").getString());
				    caiwumodel.put("shoujubenhao",query.get(0).getDataElement("shoujubenhao").getString());
				    caiwumodel.put("kaipiaoxinxi",query.get(0).getDataElement("kaipiaoxinxi").getString());
				    caiwumodel.put("qtsbsyqk",query.get(0).getDataElement("qtsbsyqk").getString());
				    caiwumodel.put("qitahaocai",query.get(0).getDataElement("qitahaocai").getString());
				    caiwumodel.put("jiexianzi",query.get(0).getDataElement("jiexianzi").getString());
				    caiwumodel.put("rj11",query.get(0).getDataElement("rj11").getString());
				    caiwumodel.put("rj45",query.get(0).getDataElement("rj45").getString());
				    caiwumodel.put("mokuai",query.get(0).getDataElement("mokuai").getString());
				    caiwumodel.put("mianban",query.get(0).getDataElement("mianban").getString());
				    caiwumodel.put("wangxian",query.get(0).getDataElement("wangxian").getString());
				    caiwumodel.put("shigongren",query.get(0).getDataElement("shigongren").getString());
				    caiwumodel.put("xianchangbeizhu",query.get(0).getDataElement("xianchangbeizhu").getString());
				    caiwumodel.put("beizhuhuizong",query.get(0).getDataElement("beizhuhuizong").getString());
				    caiwumodel.put("shebeixiaoshou",query.get(0).getDataElement("shebeixiaoshou").getString());
				    caiwumodel.put("cailiaofei",query.get(0).getDataElement("cailiaofei").getString());
				    caiwumodel.put("kaipiaoxinxi",query.get(0).getDataElement("kaipiaoxinxi").getString());
				    caiwumodel.put("createdt",Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				    caiwumodel.put("createby",getUserInfo().getEmployeeName());
				    dao.insert("caiwushuju", caiwumodel);
					
					/*
					 * 更新当前uuid 对应匹配状态为已匹配。
					 */
				    ParameterModel model = new ParameterModel();
				    model.put("pipeizhuangtai", "已匹配");
				    ParameterModel conds = new ParameterModel();
				    conds.put("UUID", uuid);
					dao.update("yonghushuju", model, conds);
					
				}
			}else{
				rollback();
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "匹配失败！");
			}
			commit();
			/*
			 * 更新当前 账目 对应的属性。
			 */
			openTransaction();
			ParameterSet set1 = new ParameterSet();
			ParameterModel zmmodel = new ParameterModel();
			ParameterModel zmconds = new ParameterModel();
			set1.add("zmid", "@zmid", zhangmuUUID);
			int count = dao.executeQueryToCount("countToZhangmuList", set1);
			DataSet<DataRow> executeQuery = dao.executeQuery("sumZongshoufeiToZhangmuList", set1);
			zongshoufei = executeQuery.get(0).getDataElement("zongshoufei").getString();
			zmmodel.put("zongshoufeiheji", zongshoufei);
			zmmodel.put("xinxishuliang", count);
		    zmconds.put("UUID", zhangmuUUID);
		    CommonDao dao1 = new CommonDao();
		    dao1.update("zhangmu", zmmodel, zmconds);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "匹配失败！");
			
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "匹配成功！");
	}

	/**
	 * 删除已匹配信息。对应的更改用户数据表的状态为“未匹配”。
	 * @param f
	 * @return
	 */
	public CommonMessage deleteYipipei(ZhangMuForm f) {
		String zmuuid = f.getZhangmuUUIDHidden();
		
		try {
			ParameterSet s = new ParameterSet();
			s.add("uuid", "@uuid", zmuuid);
			DataSet<DataRow> dataSet = dao.executeQuery("GetZhangMuZhuangTai", s);
			String zhuangtai = dataSet.get(0).getDataElement("zhuangtai").getString();
			/*
			 * 状态为0的账目方可删除信息
			 * */
			if("0".equals(zhuangtai)){
				openTransaction();
				String cwshujuid = f.getUUID();
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", cwshujuid);
				/*
				 * 恢复用户数据匹配类型“未匹配”
				 * */
				/*DataSet<DataRow> query = dao.executeQuery("InZhangmuGetShujuID", set);
				String yhshujuid = query.get(0).getDataElement("shujuid").getString();
				CommonDao dao1 = new CommonDao();
				ParameterModel zmmodel = new ParameterModel();
				zmmodel.put("pipeizhuangtai", "未匹配");
				ParameterModel zmconds = new ParameterModel();
				zmconds.put("uuid", yhshujuid);
				dao1.update("yonghushuju", zmmodel, zmconds);*/
				/*
				 * 删除选中财务数据
				 * */
				dao.execute("DeleteCaiWuData", set);
				commit();
				
				openTransaction();
				ParameterSet set1 = new ParameterSet();
				ParameterModel zmmodel1 = new ParameterModel();
				ParameterModel zmconds1 = new ParameterModel();
				set1.add("zmid", "@zmid", zmuuid);
				int count = dao.executeQueryToCount("countToZhangmuList", set1);
				DataSet<DataRow> executeQuery = dao.executeQuery("sumZongshoufeiToZhangmuList", set1);
				String zongshoufei = executeQuery.get(0).getDataElement("zongshoufei").getString();
				zmmodel1.put("zongshoufeiheji", zongshoufei==null?"0":zongshoufei);
				zmmodel1.put("xinxishuliang", count);
			    zmconds1.put("UUID", zmuuid);
			    CommonDao dao2 = new CommonDao();
			    dao2.update("zhangmu", zmmodel1, zmconds1);
				commit();
				
			}else{
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "数据已提交不能进行操作，请刷新页面！");
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "删除失败！");
		}
		f.setZmUUID(zmuuid);
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "删除成功！");
	}
	
	
	/**
	 * 删除空账目
	 * @param f
	 * @return
	 */
	public CommonMessage deleteZhangmu(ZhangMuForm f) {
		String uuid = f.getZmUUID();
		try {
			ParameterSet s = new ParameterSet();
			s.add("uuid", "@uuid", uuid);
			DataSet<DataRow> dataSet = dao.executeQuery("GetZhangMuZhuangTai", s);
			String xinxishuliang = dataSet.get(0).getDataElement("xinxishuliang").getString();
			/*
			 * 信息为0的账目方可删除信息
			 * */
			if("0".equals(xinxishuliang)){
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@zmuuid", uuid);
				dao.execute("DeleteZhangmu", set);
				f.setZmUUID(uuid);
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "删除成功！");
			} else {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "账目信息数量不为0，不能删除！");
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "删除失败！");
		}
		
	}

		// TODO Auto-generated method stub
	public CommonMessage saveShenhe(ZhangMuForm f) {
		String[] uuids = f.getUUIDS();
		for(int i = 0 ; i < uuids.length; i ++){
			try {
				ParameterSet set= new ParameterSet();
				set.add("UUID", "@UUID", uuids[i]);
				DataSet<DataRow> query = dao.executeQuery("getHeduiZhuangtai", set);
				String hedui = query.get(0).getDataElement("hedui").getString();
			    ParameterModel model = new ParameterModel();
			    if(hedui.equals("未核对"))
			    {
			    	model.put("hedui", "已核对");
			    }else{
			    	model.put("hedui", "未核对");
			    }
			    ParameterModel conds = new ParameterModel();
			    conds.put("UUID", uuids[i]);
			    dao.update("caiwushuju", model, conds);
			} catch (Exception e) {
				log.error(e);
				e.printStackTrace();
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "核对失败！");
			}
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "核对成功保存！");
	}

}
