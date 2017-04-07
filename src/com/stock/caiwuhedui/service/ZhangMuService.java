package com.stock.caiwuhedui.service;

import java.util.List;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.frame.BusinessService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.DataSetUtil;


public class ZhangMuService extends BusinessService{
	private Log log = LogFactory.getLog(this.getClass());	
	private CommonDao dao = new CommonDao();
	YonghuDataService serviceData = new YonghuDataService();
	ParameterSet set = new ParameterSet();
	
	public DataSet<DataRow> getResult(ZhangMuForm form, int first, int rows, String zhuangtai) throws Exception {
		ParameterSet set1 = new ParameterSet();
		set.add("zhuangtai", "@zhuangtai", zhuangtai);
		set1.add("zhuangtai", "@zhuangtai", zhuangtai);
		if (form.getSen1() == null || form.getSen1().equals("")) {

		} else {
			set1.add(form.getSen1().substring(1, form.getSen1().length()), form.getSen1(), "%" + form.getSenValue1() + "%");
		}
		set1.add("cunkuanshijians", "@cunkuanshijians", form.getKaijis());
		set1.add("cunkuanshijiane", "@cunkuanshijiane", form.getKaijie());
		
		if("on".equals(form.getChazhi())) {
			set1.add("chazhi", "@chazhi", "0");
		}

		return  dao.executeQuery("zhangmuList", set1 , first, rows);
	}
	public List<CommonModule> getSenListAll2()throws Exception{
		ParameterSet se=new ParameterSet();
		set.add("dictype","@dictype","caiwu_hedui_search");
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getSenListAll2",set));
	}
	public DataSet<DataRow> getResultHistoryZhangmu(ZhangMuForm dataForm, int first, int rows, String zhuangtai) throws Exception {
		set.add("zhuangtai", "@zhuangtai", zhuangtai);
		set.add("cunkuanren", "@cunkuanren", 	dataForm.getCunkuanren());
		set.add("cunkuanshijians", "@cunkuanshijians", dataForm.getCunkuanshijians());
		set.add("cunkuanshijiane", "@cunkuanshijiane", dataForm.getCunkuanshijiane());
		set.add("cunkuanyinhang", "@cunkuanyinhang", dataForm.getCunkuanyinhang());
		set.add("wangdianhao", "@wangdianhao", dataForm.getWangdianhao());
		set.add("cunkuanjine", "@cunkuanjine", dataForm.getCunkuanjine());
		return  dao.executeQuery("zhangmuList3", set , first, rows);
	}

	public int getResultCount(ZhangMuForm form, String zhuangtai) throws Exception {
		ParameterSet set1 = new ParameterSet();
		set.add("zhuangtai", "@zhuangtai", zhuangtai);
		set1.add("zhuangtai", "@zhuangtai", zhuangtai);
		if (form.getSen1() == null || form.getSen1().equals("")) {

		} else {
			set1.add(form.getSen1().substring(1, form.getSen1().length()), form.getSen1(), "%" + form.getSenValue1() + "%");
		}
		set1.add("cunkuanshijians", "@cunkuanshijians", form.getKaijis());
		set1.add("cunkuanshijiane", "@cunkuanshijiane", form.getKaijie());
		if("on".equals(form.getChazhi())) {
			set1.add("chazhi", "@chazhi", "ÒÑºË¶Ô");
		}
		return dao.executeQueryToCount("countZhangmuList", set1);
	}
	

	public String insertZhangmu(ZhangMuForm form) throws Exception {
		try {
			openTransaction();
			
			ParameterModel model = new ParameterModel();
			model.put("zhuangtai", "0");
			model.put("cunkuanren", form.getCunkuanren());
			model.put("cunkuanshijian", form.getCunkuanshijian());
			model.put("cunkuanyinhang",form.getCunkuanyinhang());
			model.put("wangdianhao", form.getWangdianhao());
			model.put("cunkuanjine", form.getCunkuanjine());
			model.put("xinxishuliang", "0");
			model.put("zongshoufeiheji", "0");
			dao.insert("zhangmu",model);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	public DataRow getZhangmuByUUID(String uuid) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", uuid);

		return dao.executeQueryToDataRow("getZhangmuXinxi", set);
	}
	
	public String updateZhangmuState(String uuid, String zt)  throws Exception {
		try {
			openTransaction();
			ParameterModel zmmodel = new ParameterModel();
			ParameterModel zmconds = new ParameterModel();
			if(zt.equals("0")){
				zmmodel.put("zhuangtai" , "0");
			}
			if(zt.equals("1")){
				zmmodel.put("zhuangtai" , "1");
			}
			if(zt.equals("2")){
				zmmodel.put("zhuangtai" , "2");
			}
			if(zt.equals("3")){
				zmmodel.put("zhuangtai" , "3");
			}
			zmconds.put("UUID" , uuid);
			CommonDao dao1 = new CommonDao();
			dao1.update("zhangmu" , zmmodel , zmconds);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			e.printStackTrace();
			return "false";

		}
		return "success";
	}

	public String updateZhangmuState(String[] uuids, String zt) {
		try {
			for(int i = 0 ; i < uuids.length ; i++){
				ParameterModel zmmodel = new ParameterModel();
				ParameterModel zmconds = new ParameterModel();
				if(zt.equals("0")){
					zmmodel.put("zhuangtai" , "0");
				}
				if(zt.equals("1")){
					zmmodel.put("zhuangtai" , "1");
				}
				if(zt.equals("2")){
					zmmodel.put("zhuangtai" , "2");
				}
				if(zt.equals("3")){
					zmmodel.put("zhuangtai" , "3");
				}
				zmconds.put("UUID" , uuids[i]);
				CommonDao dao1 = new CommonDao();
				dao1.update("zhangmu" , zmmodel , zmconds);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

}
