package com.stock.caiwuhedui.service;

import java.util.ArrayList;
import java.util.List;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.DataSetUtil;


public class AccountsMateService extends BusinessService{
	private Log log = LogFactory.getLog(this.getClass());	
	private CommonDao dao = new CommonDao();
	ParameterSet set = new ParameterSet();
	
	private ParameterSet getConditionParameterSetByFuzData(ZhangMuForm form){
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
		
		set.add("kaijis", "@kaijis", form.getKaijisHidden());
		set.add("tingjis", "@tingjis", form.getTingjisHidden());
		set.add("state", "@state", form.getStateCodeHidden());
		
		return set;
	}
	
	private ParameterSet getParameterSet(ZhangMuForm form){
		ParameterSet set = new ParameterSet();
		
		set.add("quyu", "@quyu", form.getQuyuCodeHidden());
		if (form.getAddressCodeHidden() == null || form.getAddressCodeHidden().equals("")) {
			set.add("address", "@address", form.getAddressCodeHidden());
		} else {
			set.add("address", "@address", "%" + form.getAddressCodeHidden() + "%");
		}
		if (form.getSen1() == null || form.getSen1().equals("")) {
//			set.add(form.getSen1().substring(1, form.getSen1().length()), form.getSen1(), "");
		} else {
			set.add(form.getSen1().substring(1, form.getSen1().length()), form.getSen1(), "%" + form.getSenValue1() + "%");
		}
		if (form.getSen2() == null || form.getSen2().equals("")) {
//			set.add(form.getSen2().substring(1, form.getSen2().length()), form.getSen2(), "");
		} else {
			set.add(form.getSen2().substring(1, form.getSen2().length()), form.getSen2(), "%" + form.getSenValue2() + "%");
		}
		if (form.getSen3() == null || form.getSen3().equals("")) {
//			set.add(form.getSen3().substring(1, form.getSen3().length()), form.getSen3(), "");
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
				set.add("tingjis", "@tingjis", form.getKaijisHidden());
				set.add("tingjie", "@tingjie", form.getKaijieHidden());	
			}
			if(form.getShijianleixing().equals("3")){
				set.add("tingjis", "@shoukuanshijians", form.getKaijisHidden());
				set.add("tingjie", "@shoukuanshijiane", form.getKaijieHidden());	
			}
		
		}
		set.add("state", "@state", form.getStateCodeHidden());
		
		return set;
	}
	
	public List<CommonModule> getStatusCodeAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getPartStatusCodeAll",new ParameterSet()));
	}
	
	public List<CommonModule> getSenListAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getSenListAll",new ParameterSet()));
	}

	public DataSet<DataRow> getResult(ZhangMuForm form, int first, int rows) throws Exception {
		ParameterSet parameterSet = getParameterSet(form);
		if(form.getAddressCode() == null)
		{
			return dao.executeQuery("GetEmptyDataList",parameterSet, first, rows);
		}
		String sqlString = "GetWeipipeiDataList";
		String sqlstate = "";
		
		if (form.getQuyuCodeHidden() != null) {
			String xqString = "";
			String[] strings = form.getQuyuCodeHidden().split(",");
			for (int i = 0; i < strings.length; i++) {
				xqString += strings[i] + "','";
			}
			if (xqString.length() > 0) {
				sqlstate += " AND t.xiaoqu in ('"
						+ xqString.substring(0, xqString.length() - 3)
						+ "')";
			}
		}
		return dao.executeQuery(sqlString, parameterSet,
				new String[] { sqlstate }, first, rows);
	}
	
	public DataSet<DataRow> getResultZhangMuData(ZhangMuForm form, int first, int rows) throws Exception {
		String zmid = form.getZmUUID();
		if (zmid == null) {
			zmid = form.getZhangmuUUIDHidden();
		}
		String hedui = form.getHedui();
		//String heduiHidden = form.getHeduiHidden();
		ParameterSet set = new ParameterSet();
		set.add("zmid", "@zmid", zmid);
		set.add("hedui", "@hedui", hedui);

		return dao.executeQuery("GetYipipeiDataList", set, first, rows);
	}
	
	/**
	 *  财务核对中历史账目-信息查询 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResultZhangMuDatas(ZhangMuForm form, int first, int rows) throws Exception {
		String uuids = form.getUUIDSHidden();
		form.setUUIDSHidden(uuids);
		if (uuids.equals("")){
			return dao.executeQuery("GetEmptyDataList", getParameterSet(form), first, rows);
		}
		return dao.executeQuery("byUUIDsgetdata", getParameterSet(form), uuids, first, rows);
	}
	

	public int getResultCount(ZhangMuForm form) throws Exception {
		List<String> xiaoquList = new ArrayList<String>();
		ParameterSet parameterSet = getParameterSet(form);
		if(form.getAddressCode() == null)
		{
			return dao.executeQueryToCount("GetEmptyDataList",parameterSet);
		}
		String sqlString = "GetWeipipeiDataCount";
		String sqlstate = "";
		if (form.getQuyuCodeHidden() != null) {
			String xqString = "";
			String[] strings = form.getQuyuCodeHidden().split(",");
			for (int i = 0; i < strings.length; i++) {
				xqString += strings[i] + "','";
			}
			if (xqString.length() > 0) {
				sqlstate += " AND t.xiaoqu in ('"
						+ xqString.substring(0, xqString.length() - 3)
						+ "')";
			}
		}
		return dao.executeQueryToCount(sqlString, parameterSet, "CNT", sqlstate);
	}
	public int getResultCountZhangMuData(ZhangMuForm form) throws Exception {
		String zmid = form.getZmUUID();
		if(zmid == null)
		{
			zmid = form.getZhangmuUUIDHidden();
		}
		String hedui = form.getHedui();
		ParameterSet set = new ParameterSet();
		set.add("zmid", "@zmid", zmid);
		set.add("hedui", "@hedui", hedui);
		return dao.executeQueryToCount("GetYipipeiDataCount", set);
	}
	
	/**
	 *  财务核对中历史账目-信息查询内容数量
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public int getResultCountZhangMuDatas(ZhangMuForm form) throws Exception {
		String uuids = form.getUUIDSHidden();
		form.setUUIDSHidden(uuids);
		if (uuids.equals("")){
			return dao.executeQueryToCount("GetEmptyDataList", getParameterSet(form));
		}
		return dao.executeQueryToCount("GetYipipeiDatasCount",  getParameterSet(form) ,"CNT",uuids);
	}

	public ZhangMuForm getResultZhangmuxinxi(ZhangMuForm f) throws Exception {
		String uuid = f.getZmUUID();
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", uuid);
		DataSet<DataRow> query = dao.executeQuery("getZhangmuXinxi", set);
		String cunkuanren = query.get(0).getDataElement("cunkuanren").getString();
		String cunkuanshijian = query.get(0).getDataElement("cunkuanshijian").getString();
		String cunkuanyinhang = query.get(0).getDataElement("cunkuanyinhang").getString();
		String wangdianhao = query.get(0).getDataElement("wangdianhao").getString();
		String cunkuanjine = query.get(0).getDataElement("cunkuanjine").getString();
		String xinxishuliang = query.get(0).getDataElement("xinxishuliang").getString();
		String zongshoufeiheji = query.get(0).getDataElement("zongshoufeiheji").getString();
		String chazhi = query.get(0).getDataElement("chazhi").getString();
		f.setCunkuanren(cunkuanren);
		f.setCunkuanshijian(cunkuanshijian);
		f.setCunkuanyinhang(cunkuanyinhang);
		f.setWangdianhao(wangdianhao);
		f.setCunkuanjine(cunkuanjine);
		f.setXinxishuliang(xinxishuliang);
		f.setZongshoufeiheji(zongshoufeiheji);
		f.setChazhi(chazhi);
		f.setZhangmuUUIDHidden(uuid);
		
		return f;
	}
	
	public ZhangMuForm getResultZhangmuHeduiXinxi(ZhangMuForm f) throws Exception {
		String uuid = f.getZmUUID();
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", uuid);
		DataSet<DataRow> query = dao.executeQuery("getZhangmuHeduiXinxi", set);
		String cunkuanren = query.get(0).getDataElement("cunkuanren").getString();
		String cunkuanshijian = query.get(0).getDataElement("cunkuanshijian").getString();
		String cunkuanyinhang = query.get(0).getDataElement("cunkuanyinhang").getString();
		String wangdianhao = query.get(0).getDataElement("wangdianhao").getString();
		String cunkuanjine = query.get(0).getDataElement("cunkuanjine").getString();
		String xinxishuliang = query.get(0).getDataElement("xinxishuliang").getString();
		String yihedui = query.get(0).getDataElement("yihedui").getString();
		String chazhi = query.get(0).getDataElement("chazhi").getString();
		f.setCunkuanren(cunkuanren);
		f.setCunkuanshijian(cunkuanshijian);
		f.setCunkuanyinhang(cunkuanyinhang);
		f.setWangdianhao(wangdianhao);
		f.setCunkuanjine(cunkuanjine);
		f.setXinxishuliang(xinxishuliang);
		f.setYihedui(yihedui);
		f.setChazhi(chazhi);
		f.setZhangmuUUIDHidden(uuid);
		
		return f;
	}
	private List<String> splitXiaoqu(String xiaoquText) {
		List<String> xiaoqu = new ArrayList<String>();
		int indexOf;
		while (xiaoquText.indexOf(",") > 0) {
			indexOf = xiaoquText.indexOf(",");
			String substring = xiaoquText.substring(0, indexOf);
			xiaoqu.add(substring);
			xiaoquText = xiaoquText.substring(indexOf + 1);
		}
		xiaoqu.add(xiaoquText);
		return xiaoqu;
	}

}
