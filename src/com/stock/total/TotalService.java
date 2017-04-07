/*
 * TianFang science corporation (c)2012 all rights reserved.
 * Description:  create TotalService .
 * 				 2013-02-20 add workload total service method.
 * 		
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-12-19   Li.Hai-Han(**)        Create
 * 2012-12-19   Li.Hai-Han(**)        Update
 * 2012-12-20   Li.Hai-Han(**)        Update
 * 2012-12-21   Li.Hai-Han(**)        Update
 * 2012-12-24   Li.Hai-Han(**)        Update
 * 2012-12-25   Li.Hai-Han(**)        Update
 * 2012-12-26   Li.Hai-Han(**)        Update
 * 2012-12-27   Li.Hai-Han(**)        Update
 * 2012-12-28   Li.Hai-Han(**)        Update
 * 2013-01-04   Li.Hai-Han(**)        Update
 * 2013-01-05   Li.Hai-Han(**)        Update
 * 2013-02-20   Zhu.Xiao-lei          Modify
 */
package com.stock.total;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.jfree.data.general.Dataset;
import org.jfree.data.time.DateRange;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.total.util.ExportShequExcel;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.DataSetUtil;

/**
 * TotalService get draw chart requirement.pass on requirement to draw total
 * chat.
 * 
 * @author Li.Hai-Han(**)
 */
public class TotalService extends BusinessService {
	String path;
	private CommonDao dao = new CommonDao();
	Map<String, List> mapDuoren = new HashMap<String, List>();

	private ParameterSet getYonghuCountSet(TotalForm form) {
		ParameterSet set = new ParameterSet();
		set.add("xiaoqu", "@xiaoqu", form.getXiaoqu());
		if (form.getShijianleixing() == null
				|| form.getShijianleixing().equals("")) {

		} else {
			if (form.getShijianleixing().equals("1")) {
				set.add("kaijis", "@kaijis", form.getKaijisHidden());
				set.add("kaijie", "@kaijie", form.getKaijieHidden());
			}
			if (form.getShijianleixing().equals("2")) {
				set.add("kaijis", "@tingjis", form.getKaijisHidden());
				set.add("kaijie", "@tingjie", form.getKaijieHidden());
			}
			if (form.getShijianleixing().equals("3")) {
				set.add("kaijis", "@shoukuanshijians", form.getKaijisHidden());
				set.add("kaijie", "@shoukuanshijiane", form.getKaijieHidden());
			}
			if (form.getShijianleixing().equals("4")) {
				set.add("kaijis", "@youxiaoshijians", form.getKaijisHidden());
				set.add("kaijie", "@youxiaoshijiane", form.getKaijieHidden());
			}
		}
		set.add("yonghuzhuangtai", "@yonghuzhuangtai", form.getStateCode());
		return set;
	}

	public DataSet<DataRow> getResult(TotalForm form, int first, int rows)
			throws Exception {
		return dao.executeQuery("getResultYonghuCount1",
				getYonghuCountSet(form), first, rows);
	}

	/**
	 * 得到统计数量，柱形图
	 * 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResultYonghuCount(TotalForm form, int first,
			int rows) throws Exception {
		List<TotalForm> totalList = new ArrayList<TotalForm>();
		List<DataSet<DataRow>> dataSetsList = new ArrayList<DataSet<DataRow>>();
		List<String> xiaoquList = new ArrayList<String>();
		DataSet<DataRow> set = new DataSet<DataRow>();
		String xiaoquText = form.getXiaoqutext();

		String path = getPath();
		int index = path.indexOf("image");
		String subpath = path.substring(index, path.length());
		form.setPathA(subpath);

		if (xiaoquText.trim().equals("")) {
			form.setWideSize(String.valueOf(0));
			form.setHeightSize(String.valueOf(0));
			return dao.executeQuery("GetEmptyDataList",
					getYonghuCountSet(form), first, rows);
		} else {
			// String sqlstate= "t2.xiaoqu ='" + xiaoquText.replaceAll(",",
			// "' OR t2.xiaoqu = '");
			// sqlstate = sqlstate +"'";
			DataSet<DataRow> dataSet = null;
			xiaoquList = splitXiaoqu(xiaoquText);
			DataSet<DataRow> query = dao.executeQuery("getResultYonghuCount",
					getYonghuCountSet(form), first, rows);
			set = getSplitXiaoquMatcQuery(xiaoquList, query);
			// DataRow dataRow = query.get(0);
			dataSetsList.add(set);
			dataSet = DataSetUtil.unionDataSet(dataSetsList);
			if (dataSet.size() < 1) {
				form.setWideSize(String.valueOf(0));
				form.setHeightSize(String.valueOf(0));
				return dao.executeQuery("GetEmptyDataList",
						getYonghuCountSet(form), first, rows);
			}
			for (DataRow s : dataSet) {
				TotalForm t = new TotalForm();
				t.setXiaoqu(s.getDataElement("xiaoqu1").getString());
				t.setAnzhuangNum(s.getDataElement("anzhuangNum").getString());
				t.setWeixiuNum(s.getDataElement("weixiuNum").getString());
				t.setXufeiNum(s.getDataElement("xufeiNum").getString());
				t.setTuidingNum(s.getDataElement("tuidingNum").getString());
				totalList.add(t);
			}
			new BarChart("统计图", path, totalList);
			if (totalList.size() == 1) {
				form.setHeightSize(String.valueOf(250));
				form.setWideSize(String.valueOf(totalList.size() * 500));
				return dataSet;
			}
			form.setHeightSize(String.valueOf(250));
			form.setWideSize(String.valueOf(totalList.size() * 200));
			return dataSet;
		}
	}

	/**
	 * 统计用户增减，收入增减 。点线图
	 * 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResultIncomeCount(TotalForm form, int first,
			int rows) throws Exception {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		if (form.getKaijis() != null && !form.getKaijis().equals("")) {
			int resultMonth = resultMonth(form);
			for (int i = 0; i < resultMonth; i++) {
				ParameterSet set = new ParameterSet();
				set.add("xiaoqu", "@xiaoqu", form.getXiaoqu());
				if (form.getShijianleixing() == null
						|| form.getShijianleixing().equals("")) {

				} else {
					if (form.getShijianleixing().equals("1")) {
						set.add("kaijis", "@kaijis", form.getKaijisHidden());
						set.add("kaijie", "@kaijie", form.getKaijieHidden());
					}
					if (form.getShijianleixing().equals("2")) {
						set.add("kaijis", "@tingjis", form.getKaijisHidden());
						set.add("kaijie", "@tingjie", form.getKaijieHidden());
					}
					if (form.getShijianleixing().equals("3")) {
						set.add("kaijis", "@shoukuanshijians",
								form.getKaijisHidden());
						set.add("kaijie", "@shoukuanshijiane",
								form.getKaijieHidden());
					}
					if (form.getShijianleixing().equals("4")) {
						set.add("kaijis", "@youxiaoshijians",
								form.getKaijisHidden());
						set.add("kaijie", "@youxiaoshijiane",
								form.getKaijieHidden());
					}
				}
				set.add("yonghuzhuangtai", "@yonghuzhuangtai",
						form.getStateCode());
				set.add("num", "@num", String.valueOf(i));

				DataSet<DataRow> executeQuery1 = dao.executeQuery(
						"getResultYonghuIncomeCount", set);
				String c = executeQuery1.get(0).getDataElement("c").getString();
				list1.add(Integer.parseInt(c));

				DataSet<DataRow> executeQuery2 = dao.executeQuery(
						"getResultYonghuCostCount", set);
				c = executeQuery2.get(0).getDataElement("c").getString();
				list2.add(Integer.parseInt(c == null ? "0" : c));
			}
		}
		String path1 = getPath();
		int index = path1.indexOf("image");
		String subpath = path1.substring(index, path1.length());
		form.setPathA(subpath);
		new LineChart("统计图", path1, "用户增减", form, list1);

		String path2 = getPath();
		subpath = path2.substring(index, path2.length());
		form.setPathB(subpath);
		new LineChart("统计图", path2, "收入增减", form, list2);
		if (list1.size() != 0) {
			form.setWideSize(String.valueOf(list1.size() * 180));
		} else {
			form.setWideSize("300");
		}
		return dao.executeQuery("getResultYonghuIncomeCount",
				getYonghuCountSet(form), first, rows);
	}

	/**
	 * 统计收费
	 * 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */

	public DataSet<DataRow> getResultShoufeiTotal(TotalForm form, int first,
			int rows) throws Exception {
		List<TotalForm> totalList = new ArrayList<TotalForm>();
		List<DataSet<DataRow>> dataSetsList = new ArrayList<DataSet<DataRow>>();
		List<String> xiaoquList = new ArrayList<String>();
		DataSet<DataRow> set = new DataSet<DataRow>();
		String xiaoquText = form.getXiaoqutext();
		String path = getPath();
		int index = path.indexOf("image");
		String subpath = path.substring(index, path.length());
		form.setPathA(subpath);
		if (xiaoquText.trim().equals("")) {
			form.setWideSize(String.valueOf(0));
			form.setHeightSize(String.valueOf(0));
			return dao.executeQuery("GetEmptyDataList",
					getYonghuCountSet(form), first, rows);
		} else {
			DataSet<DataRow> dataSet = null;
			xiaoquList = splitXiaoqu(xiaoquText);
			DataSet<DataRow> query = dao.executeQuery("getResultShoufeiTotal",
					getYonghuCountSet(form), first, rows);
			set = getSplitXiaoquMatcQuery(xiaoquList, query);
			dataSetsList.add(set);
			dataSet = DataSetUtil.unionDataSet(dataSetsList);
			if (dataSet.size() < 1) {
				form.setWideSize(String.valueOf(0));
				form.setHeightSize(String.valueOf(0));
				return dao.executeQuery("GetEmptyDataList",
						getYonghuCountSet(form), first, rows);
			}

			for (DataRow s : dataSet) {
				TotalForm t = new TotalForm();
				t.setXiaoqu(s.getDataElement("xiaoqu1").getString());
				t.setAnzhuangNum(s.getDataElement("az_zong").getString());
				t.setWeixiuNum(s.getDataElement("wx_zong").getString());
				t.setXufeiNum(s.getDataElement("xf_zong").getString());
				t.setTuidingNum(s.getDataElement("td_zong").getString());
				totalList.add(t);
			}
			new ShoufeiBarChart("统计图", path, totalList);
			if (totalList.size() == 1) {
				form.setHeightSize(String.valueOf(250));
				form.setWideSize(String.valueOf(totalList.size() * 500));
				return dataSet;
			}
			form.setHeightSize(String.valueOf(250));
			form.setWideSize(String.valueOf(totalList.size() * 200));
			return dataSet;
		}

	}

	/**
	 * 统计施工人耗材
	 * 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResultHaocaiTotal(TotalForm form, int first,
			int rows) throws Exception {
		List<TotalForm> totalList = new ArrayList<TotalForm>();
		List<DataSet<DataRow>> dataSetsList = new ArrayList<DataSet<DataRow>>();
		List<String> xiaoquList = new ArrayList<String>();
		DataSet<DataRow> set = new DataSet<DataRow>();
		String xiaoquText = form.getXiaoqutext();
		String path = getPath();
		int index = path.indexOf("image");
		String subpath = path.substring(index, path.length());
		form.setPathA(subpath);
		if (xiaoquText.trim().equals("")) {
			form.setWideSize(String.valueOf(0));
			form.setHeightSize(String.valueOf(0));
			return dao.executeQuery("GetEmptyDataList",
					getYonghuCountSet(form), first, rows);
		} else {
			DataSet<DataRow> dataSet = null;
			xiaoquList = splitXiaoqu(xiaoquText);
			DataSet<DataRow> query = dao.executeQuery("getResultXiaoquHaocai",
					getYonghuCountSet(form), first, rows);
			set = getSplitXiaoquMatcQuery(xiaoquList, query);
			dataSetsList.add(set);
			dataSet = DataSetUtil.unionDataSet(dataSetsList);
			if (dataSet.size() < 1) {
				form.setWideSize(String.valueOf(0));
				form.setHeightSize(String.valueOf(0));
				return dao.executeQuery("GetEmptyDataList",
						getYonghuCountSet(form), first, rows);
			}
			for (DataRow s : dataSet) {
				TotalForm t = new TotalForm();
				t.setXiaoqu(s.getDataElement("xiaoqu1").getString());
				t.setJiexianziNum(s.getDataElement("jiexianziNum").getString());
				t.setRj11Num(s.getDataElement("rj11Num").getString());
				t.setRj45Num(s.getDataElement("rj45Num").getString());
				t.setMokuaiNum(s.getDataElement("mokuaiNum").getString());
				t.setMianbanNum(s.getDataElement("mianbanNum").getString());
				t.setWangxianNum(s.getDataElement("wangxianNum").getString());
				totalList.add(t);
			}
			new HaocaiBarChart("统计图", path, totalList);
			if (totalList.size() == 1) {
				form.setHeightSize(String.valueOf(250));
				form.setWideSize(String.valueOf(totalList.size() * 500));
				return dataSet;
			}
			form.setHeightSize(String.valueOf(250));
			form.setWideSize(String.valueOf(totalList.size() * 200));
			return dataSet;
		}
	}

	/**
	 * 统计施工人安装维修退订量
	 * 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResultShigongrenTotal(TotalForm form, int first,
			int rows) throws Exception {
		List<TotalForm> totalList = new ArrayList<TotalForm>();
		DataSet<DataRow> emptyquery = dao.executeQuery("GetEmptyDataList",
				getYonghuCountSet(form), first, rows);
		String path = getPath();
		int index = path.indexOf("image");
		String subpath = path.substring(index, path.length());
		form.setPathA(subpath);
		if (form.getXiaoqu() == null) {
			form.setWideSize(String.valueOf(0));
			form.setHeightSize(String.valueOf(0));
			return emptyquery;
		}
		DataSet<DataRow> query = dao.executeQuery("getResultShigongrenCount",
				getYonghuCountSet(form), first, rows);
		if (query.size() == 0) {
			form.setWideSize(String.valueOf(0));
			form.setHeightSize(String.valueOf(0));
			return emptyquery;
		}
		for (int i = 0; i < query.size(); i++) {
			TotalForm t = new TotalForm();

			DataRow s = query.get(i);
			String shigongren = s.getDataElement("shigongren").getString();
			String anzhuangNum = s.getDataElement("anzhuangNum").getString();
			String weixiuNum = s.getDataElement("weixiuNum").getString();
			String xufeiNum = s.getDataElement("xufeiNum").getString();
			String tuidingNum = s.getDataElement("tuidingNum").getString();

			t.setShigongren(shigongren);
			t.setAnzhuangNum(anzhuangNum);
			t.setWeixiuNum(weixiuNum);
			t.setXufeiNum(xufeiNum);
			t.setTuidingNum(tuidingNum);
			totalList.add(t);

		}
		// new ShigongrenBarChart("统计图", path, totalList);
		if (totalList.size() != 0) {
			if (totalList.size() == 1) {
				form.setHeightSize(String.valueOf(250));
				form.setWideSize(String.valueOf(totalList.size() * 480));
				return query;
			}
			form.setHeightSize(String.valueOf(250));
			form.setWideSize(String.valueOf(totalList.size() * 150));
		}
		return query;
	}

	public int getResultCount(TotalForm form) throws Exception {
		int count = dao.executeQueryToCount("getResultShigongCount",
				getYonghuCountSet(form));
		return count;
	}

	public int getResultCountNull(TotalForm form) throws Exception {
		return dao.executeQueryToCount("GetEmptyDataList",
				getYonghuCountSet(form));
	}

	/**
	 * 得到图片存放路径，生成随即图片。
	 * 
	 * @return
	 */
	private String getPath() {
		UUID randomUUID = UUID.randomUUID();
		path = this.getClass().getClassLoader().getResource("/").getPath();
		int index = path.indexOf("WEB-INF");
		path = path.substring(0, index);
		if (path.indexOf("%") >= 0) {
			try {
				path = URLDecoder.decode(path, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * 删除image文件夹下所有图片
		 */
		String pathDelet = path + "image/";
		File file = new File(pathDelet);
		String[] list = file.list();
		File temp = null;
		if (list.length > 1000) {
			for (int i = 0; i < list.length; i++) {
				temp = new File(pathDelet + list[i]);
				temp.delete();
			}
		}
		// 生成随即图片路径
		path = path + "image/" + randomUUID + ".jpg";

		return path;
	}

	/**
	 * get total month.
	 * 
	 * @param form
	 * @return
	 */
	private int resultMonth(TotalForm form) {
		int mounth;
		String kaijis = form.getKaijis();
		String kaijiyue = kaijis.substring(5, 7);
		String kaijinian = kaijis.substring(0, 4);

		String tingjis = form.getKaijie();
		String tingjiyue = tingjis.substring(5, 7);
		String tingjinian = tingjis.substring(0, 4);

		Integer kaijisM = Integer.parseInt(kaijiyue);
		Integer kaijisYear = Integer.parseInt(kaijinian);

		Integer tingjisM = Integer.parseInt(tingjiyue);
		Integer tingjisYear = Integer.parseInt(tingjinian);
		mounth = (((tingjisYear * 12) + tingjisM) - ((kaijisYear * 12) + kaijisM));
		return mounth + 1;
	}

	/**
	 * Split xiaoqu.get every one.
	 * 
	 * @param form
	 * @return
	 */
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

	/**
	 * get Split xiaoqu matching Query.
	 * 
	 * @param form
	 * @return
	 */
	private DataSet<DataRow> getSplitXiaoquMatcQuery(List<String> xiaoquList,
			DataSet<DataRow> query) {
		List<Map<Integer, String>> listQueryXiaoqu = new ArrayList<Map<Integer, String>>();
		DataSet<DataRow> set = new DataSet<DataRow>();

		for (int i = 0; i < query.size(); i++) {
			Map<Integer, String> map = new HashMap<Integer, String>();
			String xiaoqui = query.get(i).getDataElement("xiaoqu1").getString();

			map.put(i, xiaoqui);
			listQueryXiaoqu.add(map);
		}

		for (int i = 0; i < xiaoquList.size(); i++) {
			for (int j = 0; j < listQueryXiaoqu.size(); j++) {
				if (xiaoquList.get(i).equals(listQueryXiaoqu.get(j).get(j))) {
					set.add(query.get(j));
				}
			}
		}
		return set;
	}

	/**
	 * 匹配出要查询出的小区记录
	 * 
	 * @param xiaoquText
	 * @param query
	 * @return
	 */
	private DataSet<DataRow> getSplitXiaoquMatcQuery(String xiaoquText,
			DataSet<DataRow> query) {
		DataSet<DataRow> set = new DataSet<DataRow>();
		for (int i = 0; i < query.size(); i++) {
			String xiaoqui = query.get(i).getDataElement("xiaoqu").getString();
			if (xiaoquText.contains(xiaoqui)) {
				set.add(query.get(i));
				continue;
			}
		}
		return set;
	}

	/**
	 * 用于生成 施工人 工作量的Excel
	 * 
	 * @param form
	 * @param downloadDir
	 * @param wllist
	 * @return
	 */
	public void downExcel(TotalForm form, String downloadDir,
			List<WorkLoadForm> wllist) {
		Map<String, String> mapGongren = new HashMap<String, String>();// 匹配施工人是否重复
		List<String> listGongren = new ArrayList<String>();// 把无重复的施工人存到list中，listGongren.size用于生成Excel的单行长度。
		Map<String, String> mapRiQu = new HashMap<String, String>();// 匹配日期小区是否重复
		List<String> listRiqiXiaoqu = new ArrayList<String>();// 把无重复的日期小区存到list中，

		Map<String, String> mapDizhi = new HashMap<String, String>();// 匹配日期小区是否重复
		List<String> listDizhi = new ArrayList<String>();// 把无重复的日期小区存到list中，
		// List mapZongshuju = new ArrayList();//存放总数据的
		Map<String, List<Map<String, List<Double>>>> mapRiqiXiaoqu = new HashMap<String, List<Map<String, List<Double>>>>();// 存放日期小区，工人对应的值（10个数值）。

		for (int i = 0; i < wllist.size(); i++) {
			String shigongren = wllist.get(i).getShigongren();

			/*
			 * get no replay shigongren in listGongren.
			 */
			if (mapGongren.get(shigongren) == null) {
				mapGongren.put(shigongren, shigongren);
				listGongren.add(shigongren);
			}

			/*
			 * get no replay riqi,xiaoqu in listRiqiXiaoqu.
			 */
			String riqi = wllist.get(i).getRiqi();
			String xiaoqu = wllist.get(i).getXiaoqu();
			String riqixiaoqu = riqi + "," + xiaoqu;
			if (mapRiQu.get(riqixiaoqu) == null) {
				mapRiQu.put(riqixiaoqu, riqixiaoqu);
				listRiqiXiaoqu.add(riqixiaoqu);
			}

			/*
			 * get no replay xiaoqu in listDizhi. this will get total heji.
			 */
			if (mapDizhi.get(xiaoqu) == null) {
				mapDizhi.put(xiaoqu, xiaoqu);
				listDizhi.add(xiaoqu);
			}

			/*
			 * get through riqixiaoqu create
			 * <riqixiaoqu,list(<gongren1,list<num1
			 * ,2,3,4...>>,<gongren2,list<num1,2,3...>>),...>
			 */
			if (mapRiqiXiaoqu.get(riqixiaoqu) == null) {
				List<Double> listZhi = new ArrayList<Double>();// list(工值1,工值2,工值3...)
				listZhi.add(wllist.get(i).getDianshi());
				listZhi.add(wllist.get(i).getKuandai());
				listZhi.add(wllist.get(i).getDianhua());
				listZhi.add(wllist.get(i).getDankuan());
				listZhi.add(wllist.get(i).getTaocan());
				listZhi.add(wllist.get(i).getRuhushu());
				listZhi.add(wllist.get(i).getShouciruhushu());
				listZhi.add(wllist.get(i).getWeixiushu());
				listZhi.add(wllist.get(i).getXufei());
				listZhi.add(wllist.get(i).getTuiding());
				Map<String, List> mapGongrenZhi = new HashMap<String, List>();// <施工人,list(工值1,工值2,工值3...)>
				mapGongrenZhi.put(wllist.get(i).getShigongren(), listZhi);

				List listGongrenzhi = new ArrayList();// 工值(<工人1,list(值)>,<工人2,list(值)>,<工人3,list(值)>...)
				listGongrenzhi.add(mapGongrenZhi);
				mapRiqiXiaoqu.put(riqixiaoqu, listGongrenzhi);
			} else {
				List<Double> listZhi = new ArrayList<Double>();// list(工值1,工值2,工值3...)
				listZhi.add(wllist.get(i).getDianshi());
				listZhi.add(wllist.get(i).getKuandai());
				listZhi.add(wllist.get(i).getDianhua());
				listZhi.add(wllist.get(i).getDankuan());
				listZhi.add(wllist.get(i).getTaocan());
				listZhi.add(wllist.get(i).getRuhushu());
				listZhi.add(wllist.get(i).getShouciruhushu());
				listZhi.add(wllist.get(i).getWeixiushu());
				listZhi.add(wllist.get(i).getXufei());
				listZhi.add(wllist.get(i).getTuiding());
				Map<String, List<Double>> mapGongrenZhi = new HashMap<String, List<Double>>();// <施工人,list(工值1,工值2,工值3...)>
				mapGongrenZhi.put(wllist.get(i).getShigongren(), listZhi);

				mapRiqiXiaoqu.get(riqixiaoqu).add(mapGongrenZhi);
			}
		}

		/*
		 * 异常导出 施工人大于25 删除execl文件
		 */
		if (listGongren.size() > 25) {
			String path = this.getClass().getClassLoader().getResource("/")
					.getPath();
			int index = path.indexOf("WEB-INF");
			path = path.substring(0, index);
			if (path.indexOf("%") >= 0) {
				try {
					path = URLDecoder.decode(path, "utf-8");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			String pathDelet = path + "excel/";
			File file = new File(pathDelet);
			String[] list = file.list();
			File temp = null;
			if (list.length > 0) {
				for (int i = 0; i < list.length; i++) {
					temp = new File(pathDelet + list[i]);
					temp.delete();
				}
			}
			return;
		}
		for (int i = 0; i < listRiqiXiaoqu.size(); i++) {
			List<Map<String, List<Double>>> list = mapRiqiXiaoqu
					.get(listRiqiXiaoqu.get(i));
			for (int j = 0; j < listGongren.size(); j++) {
				String gongren = listGongren.get(j);
				for (int k = 0; k < list.size(); k++) {
					Map<String, List<Double>> map = list.get(k);
					if (map.get(gongren) == null) {
						if (k == list.size() - 1) {
							List<Double> listZhi = new ArrayList<Double>();// list(工值1,工值2,工值3...)
							listZhi.add(0.00D);
							listZhi.add(0.00D);
							listZhi.add(0.00D);
							listZhi.add(0.00D);
							listZhi.add(0.00D);
							listZhi.add(0.00D);
							listZhi.add(0.00D);
							listZhi.add(0.00D);
							listZhi.add(0.00D);
							listZhi.add(0.00D);
							Map<String, List<Double>> mapGongrenZhi = new HashMap<String, List<Double>>();
							mapGongrenZhi.put(gongren, listZhi);
							list.add(j, mapGongrenZhi);
							break;
						}
						continue;
					} else {
						List<Double> listGongzhi = map.get(gongren);
						Map<String, List<Double>> mapGongrenZhi = new HashMap<String, List<Double>>();
						mapGongrenZhi.put(gongren, listGongzhi);
						list.remove(k);
						list.add(j, mapGongrenZhi);
						break;
					}
				}
			}
		}

		try {
			List<List<Object>> listData = new ArrayList<List<Object>>();
			List<Object> l1 = new ArrayList<Object>();
			l1.add("日期");
			l1.add("小区名称");
			for (int i = 0; i < listGongren.size(); i++) {
				l1.add(listGongren.get(i));
				l1.add("");
				l1.add("");
				l1.add("");
				l1.add("");
				l1.add("");
				l1.add("");
				l1.add("");
				l1.add("");
				l1.add("");
			}
			listData.add(l1);

			List<Object> l2 = new ArrayList<Object>();
			l2.add("");
			l2.add("");
			for (int i = 0; i < listGongren.size(); i++) {
				l2.add("安装数");
				l2.add("");
				l2.add("");
				l2.add("");
				l2.add("");
				l2.add("");
				l2.add("");
				l2.add("维修数(包括收件）");
				l2.add("续费");
				l2.add("退订");
			}
			listData.add(l2);

			List<Object> l3 = new ArrayList<Object>();
			l3.add("");
			l3.add("");
			for (int i = 0; i < listGongren.size(); i++) {
				l3.add("电视");
				l3.add("宽带");
				l3.add("电话");
				l3.add("单宽");
				l3.add("套餐");
				l3.add("入户数");
				l3.add("首次入户数");
				l3.add("");
				l3.add("");
				l3.add("");
			}
			listData.add(l3);

			for (int i = 0; i < mapRiqiXiaoqu.size(); i++) {
				List<Object> list = new ArrayList<Object>();
				String riqixiaoqu = listRiqiXiaoqu.get(i);
				int indexOf = riqixiaoqu.indexOf(",");
				String shijian = riqixiaoqu.substring(0, indexOf);
				String dizhi = riqixiaoqu.substring(indexOf + 1,
						riqixiaoqu.length());
				list.add(shijian);
				list.add(dizhi);
				for (int j = 0; j < listGongren.size(); j++) {
					List<Double> listzhi = mapRiqiXiaoqu
							.get(listRiqiXiaoqu.get(i)).get(j)
							.get(listGongren.get(j));
					for (int k = 0; k < listzhi.size(); k++) {
						Double d = listzhi.get(k);
						d = Math.floor(d * 100) / 100;
						list.add(d);
					}
				}
				// System.out.println("mapRiqiXiaoqu.size() = " +
				// mapRiqiXiaoqu.size());
				// System.out.println("listRiqiXiaoqu.size() = " +
				// listRiqiXiaoqu.size());
				listData.add(list);
			}

			int indexOf = listRiqiXiaoqu.get(0).indexOf(",");
			String shijians = listRiqiXiaoqu.get(0).substring(0, indexOf);

			int indexOf2 = listRiqiXiaoqu.get(listRiqiXiaoqu.size() - 1)
					.indexOf(",");
			String shijiane = listRiqiXiaoqu.get(listRiqiXiaoqu.size() - 1)
					.substring(0, indexOf2);

			Map mapXiaoqu = new HashMap();
			for (int i = 3; i < listData.size(); i++) {
				List<Object> list = listData.get(i);
				String xiaoqu = (String) list.get(1);
				if (mapXiaoqu.get(xiaoqu) == null) {
					List l = new ArrayList();
					for (int j = 2; j < list.size(); j++) {
						l.add(list.get(j));
					}
					mapXiaoqu.put(xiaoqu, l);
				} else {
					List l = (List) mapXiaoqu.get(xiaoqu);
					for (int j = 0; j < l.size(); j++) {
						Double sum = 0.0D;
						Double zhi1 = (Double) l.get(j);
						Double zhi2 = (Double) list.get(j + 2);
						sum = zhi1 + zhi2;

						l.remove(j);
						l.add(j, sum);
					}
				}
			}
			List<Object> listsum = new ArrayList<Object>();
			listsum.add(shijians + "到" + shijiane);
			listsum.add("总计");
			for (int i = 0; i < listDizhi.size(); i++) {
				List<Object> listheji = new ArrayList<Object>();
				listheji.add("合计" + shijians + "到" + shijiane);
				String xiaoqu = listDizhi.get(i);
				List list = (List) mapXiaoqu.get(xiaoqu);
				listheji.add(xiaoqu);
				for (int j = 0; j < list.size(); j++) {
					listheji.add(list.get(j));
					if (i > 0) {
						Double d1 = (Double) listsum.get(j + 2);
						Double d2 = (Double) list.get(j);
						Double sum = d1 + d2;
						// d = Math.floor(d * 100) / 100;
						listsum.remove(j + 2);
						listsum.add(j + 2, sum);
					} else {
						listsum.add(list.get(j));
					}
				}
				listData.add(listheji);
			}

			listData.add(listsum);

			toExcel(listData, listGongren.size());
			// return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG ,
			// "<a href='http://"+downloadDir+":8080/tfkj_stock/excel/gongzuoliang.xls'>下载工作量统计表Excel</a>");
		} catch (Exception e) {
			// return new
			// CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG,"Excel表格导出失败！");
		}
	}

	private void toExcel(List<List<Object>> listData, int i) {
		try {
			ExportExcel ex = new ExportExcel();
			String path = this.getClass().getClassLoader().getResource("/")
					.getPath();
			int index = path.indexOf("WEB-INF");
			path = path.substring(0, index);
			path = path + "excel/gongzuoliang.xls";
			if (path.indexOf("%") >= 0) {
				try {
					path = URLDecoder.decode(path, "utf-8");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			OutputStream out = new FileOutputStream(path);
			ex.exportExcel(listData, out, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 */
	public DataSet<DataRow> getWorkLoadData(TotalForm form,
			String DOWNLOAD_DIR, String SPLIT_CHAR) {
		DataSet<DataRow> set = new DataSet<DataRow>();
		List<WorkLoadForm> wllist = new ArrayList<WorkLoadForm>();
		try {
			if (form.getXiaoqutext().trim().equals("")) {
				return dao.executeQuery("GetEmptyDataList",
						getYonghuCountSet(form), 0, 0);
			}
			if (form.getShijianleixing().equals("1")) {
				set = dao.executeQuery("GetWorkloadDataList",
						getYonghuCountSet(form),
						" kaijishijian < t.kaijishijian ");
			} else if (form.getShijianleixing().equals("2")) {
				set = dao.executeQuery("GetWorkloadDataList",
						getYonghuCountSet(form),
						" tingjishijian < t.tingjishijian ");
			} else if (form.getShijianleixing().equals("3")) {
				set = dao.executeQuery("GetWorkloadDataList",
						getYonghuCountSet(form),
						" shoukuanshijian < t.shoukuanshijian ");
			} else if (form.getShijianleixing().equals("4")) {
				set = dao.executeQuery("GetWorkloadDataList",
						getYonghuCountSet(form),
						" youxiaoshijian < t.youxiaoshijian ");
			}
			

			set = getSplitXiaoquMatcQuery(form.getXiaoqutext(), set);
			if (set.size() == 0) {
				return set;
			}

			/*
			 * get shigongren list for init List<WorkLoadForm> wllist.
			 */
			DataSet<DataRow> query = dao.executeQuery("GetShiGongrenList",
					getYonghuCountSet(form));
			// List<String> xiaoquList = new ArrayList<String>();
			// xiaoquList = splitXiaoqu(form.getXiaoqutext());
			DataSet<DataRow> set2 = getSplitXiaoquMatcQuery(
					form.getXiaoqutext(), query);
			// List<String> shigong = new ArrayList<String>();
			initWorkLoadList(set2, wllist, form, SPLIT_CHAR);
			/*
			 * analyse data and set workload to entity from.
			 */
			for (int i = 0; i < set.size(); i++) {
				DataRow s = set.get(i);
				String shigongren = s.getDataElement("shigongren").getString() == null ? "null"
						: s.getDataElement("shigongren").getString();
				// check shigongren is contain split char or not.
				if (isSGRContainMutli(SPLIT_CHAR, shigongren)) {
					// call data analyse method for mutil shigongren.
					dataAnalyseMutil(s, wllist, form, SPLIT_CHAR);
				} else {
					// call data analyse method.
					dataAnalyse(s, wllist, form);
				}
			}

			set = dataParse(wllist);
			// call expert excel.
			downExcel(null, DOWNLOAD_DIR, wllist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapDuoren.clear();
		return set;
	}

	private DataSet<DataRow> dataParse(List<WorkLoadForm> wllist) {
		DataSet<DataRow> set = new DataSet<DataRow>();
		for (int i = 0; i < wllist.size(); i++) {
			DataRow dataRow = new DataRow();
			DataElement dataElement1 = new DataElement();
			dataElement1.setCloumnName("riqi");
			dataElement1.setColumnValue(wllist.get(i).getRiqi());
			dataRow.addDataElement("riqi", dataElement1);

			DataElement dataElement2 = new DataElement();
			dataElement2.setCloumnName("xiaoqu");
			dataElement2.setColumnValue(wllist.get(i).getXiaoqu());
			dataRow.addDataElement("xiaoqu", dataElement2);

			DataElement dataElement13 = new DataElement();
			dataElement13.setCloumnName("shigongren");
			dataElement13.setColumnValue(String.valueOf(wllist.get(i)
					.getShigongren()));
			dataRow.addDataElement("shigongren", dataElement13);

			DataElement dataElement3 = new DataElement();
			dataElement3.setCloumnName("dianshi");
			dataElement3.setColumnValue(String.valueOf(wllist.get(i)
					.getDianshi()));
			dataRow.addDataElement("dianshi", dataElement3);

			DataElement dataElement4 = new DataElement();
			dataElement4.setCloumnName("kuandai");
			dataElement4.setColumnValue(String.valueOf(wllist.get(i)
					.getKuandai()));
			dataRow.addDataElement("kuandai", dataElement4);

			DataElement dataElement5 = new DataElement();
			dataElement5.setCloumnName("dianhua");
			dataElement5.setColumnValue(String.valueOf(wllist.get(i)
					.getDianhua()));
			dataRow.addDataElement("dianhua", dataElement5);

			DataElement dataElement6 = new DataElement();
			dataElement6.setCloumnName("dankuan");
			dataElement6.setColumnValue(String.valueOf(wllist.get(i)
					.getDankuan()));
			dataRow.addDataElement("dankuan", dataElement6);

			DataElement dataElement7 = new DataElement();
			dataElement7.setCloumnName("taocan");
			dataElement7.setColumnValue(String.valueOf(wllist.get(i)
					.getTaocan()));
			dataRow.addDataElement("taocan", dataElement7);

			DataElement dataElement8 = new DataElement();
			dataElement8.setCloumnName("ruhushu");
			dataElement8.setColumnValue(String.valueOf(wllist.get(i)
					.getRuhushu()));
			dataRow.addDataElement("ruhushu", dataElement8);

			DataElement dataElement9 = new DataElement();
			dataElement9.setCloumnName("shoucirujushu");
			dataElement9.setColumnValue(String.valueOf(wllist.get(i)
					.getShouciruhushu()));
			dataRow.addDataElement("shoucirujushu", dataElement9);

			DataElement dataElement10 = new DataElement();
			dataElement10.setCloumnName("weixiushu");
			dataElement10.setColumnValue(String.valueOf(wllist.get(i)
					.getWeixiushu()));
			dataRow.addDataElement("weixiushu", dataElement10);

			DataElement dataElement11 = new DataElement();
			dataElement11.setCloumnName("xufei");
			dataElement11.setColumnValue(String.valueOf(wllist.get(i)
					.getXufei()));
			dataRow.addDataElement("xufei", dataElement11);

			DataElement dataElement12 = new DataElement();
			dataElement12.setCloumnName("tuiding");
			dataElement12.setColumnValue(String.valueOf(wllist.get(i)
					.getTuiding()));
			dataRow.addDataElement("tuiding", dataElement12);

			set.add(dataRow);
		}
		return set;
	}

	private boolean isSGRContainMutli(String SPLIT_CHAR, String shigongren) {
		String[] split = SPLIT_CHAR.split(",");
		boolean istrue = false;

		for (int i = 0; i < split.length; i++) {
			istrue = shigongren.contains(split[i]);
			if (istrue) {
				break;
			}
		}

		return istrue;
	}

	private void dataAnalyse(DataRow s, List<WorkLoadForm> frmList,
			TotalForm form) throws Exception {
		String dianshi = s.getDataElement("dianshi").getString();
		String wangluo = s.getDataElement("wangluo").getString();
		String yewu = s.getDataElement("yewu").getString();
		// String ruhushu = s.getDataElement("ruhushu").getString();
		// String shouciruhu = s.getDataElement("shouciruhu").getString();
		String shigongren = s.getDataElement("shigongren").getString() == null ? "null"
				: s.getDataElement("shigongren").getString();
		String xiaoqu = s.getDataElement("xiaoqu").getString();
		String kaijishijian = s.getDataElement("kaijishijian").getString();
		String tingjishijian = s.getDataElement("tingjishijian").getString();
		String shoukuanshijian = s.getDataElement("shoukuanshijian")
				.getString();
		String yonghuzhuangtai = s.getDataElement("yonghuzhuangtai")
				.getString();
		String dizhi = s.getDataElement("dizhi").getString();

		/*
		 * double hu = 0; if (Integer.parseInt(shouciruhu) == 0) { hu = 1; }
		 */
		/*
		 * data list loop for check every record.
		 */
		for (int i = 0; i < frmList.size(); i++) {
			WorkLoadForm frm = frmList.get(i);

			// check data type
			if (form.getShijianleixing().equals("1")) {
				// when search date and xiaoqu and shigongren all equals then
				// continue produce.
				if (kaijishijian.equals(frm.getRiqi())
						&& xiaoqu.equals(frm.getXiaoqu())
						&& shigongren.equals(frm.getShigongren())) {
					if (yonghuzhuangtai.equals("已安装")) {

						if (!dianshi.equals("0")) {
							frm.setDianshi(frm.getDianshi() + 1);
						}
						if (!wangluo.equals("0")) {
							frm.setKuandai(frm.getKuandai() + 1);
						}
						if (yewu.contains("固话业务")) {
							frm.setDianhua(frm.getDianhua() + 1);
						}
						if (yewu.contains("单产品")) {
							frm.setDankuan(frm.getDankuan() + 1);
						}
						if (yewu.contains("e8") || yewu.contains("e9")) {
							frm.setTaocan(frm.getTaocan() + 1);
						}

						if (frm.isFlag() == false) {
							ParameterSet set1 = new ParameterSet();
							set1.add("kaijishijian", "@kaijis", frm.getRiqi());
							set1.add("shigongren", "@shigongren",
									frm.getShigongren());
							set1.add("xiaoqu", "@xiaoqu", frm.getXiaoqu());
							DataSet<DataRow> executeQuery = dao.executeQuery(
									"GetRuhuList", set1);
							String num = executeQuery.get(0)
									.getDataElement("num").getString();
							frm.setRuhushu(frm.getRuhushu()
									+ Double.valueOf(num));

							ParameterSet set2 = new ParameterSet();
							String sql;
							sql = " SELECT SUM(  CASE   WHEN  (SELECT   COUNT(*) FROM yonghushuju t2 WHERE t2.dizhi = t1.dizhi AND  t2.xiaoqu = '"
									+ frm.getXiaoqu()
									+ "'  AND   t2.yonghuzhuangtai = '已安装'  AND t2.kaijishijian < '"
									+ frm.getRiqi()
									+ "' ) = 0 THEN 1 ELSE 0 END   ) AS az_shoushifei FROM (SELECT DISTINCT dizhi FROM yonghushuju a WHERE a.kaijishijian = '"
									+ frm.getRiqi()
									+ "'  AND a.shigongren = '"
									+ frm.getShigongren()
									+ "'  AND a.xiaoqu = '"
									+ frm.getXiaoqu()
									+ "'  AND a.yonghuzhuangtai = '已安装' ) t1";
							DataSet<DataRow> executeQuery1 = dao.executeQuery(
									"getShouciRuhu", set2, sql);
							String num1 = executeQuery1.get(0)
									.getDataElement("az_shoushifei")
									.getString();
							frm.setShouciruhushu(frm.getShouciruhushu()
									+ Double.valueOf(num1));
							frm.setFlag(true);
						}

					}
					if (yonghuzhuangtai.equals("已退订")) {
						frm.setTuiding(frm.getTuiding() + 1);
					}
					if (yonghuzhuangtai.equals("已维修")) {
						frm.setWeixiushu(frm.getWeixiushu() + 1);
					}
					if (yonghuzhuangtai.equals("已续费")) {
						frm.setXufei(frm.getXufei() + 1);
					}

				}
			} else if (form.getShijianleixing().equals("2")) {
				if (tingjishijian.equals(frm.getRiqi())
						&& xiaoqu.equals(frm.getXiaoqu())
						&& shigongren.equals(frm.getShigongren())) {
					if (yonghuzhuangtai.equals("已安装")) {
						if (!dianshi.equals("0")) {
							frm.setDianshi(frm.getDianshi() + 1);
						}
						if (!wangluo.equals("0")) {
							frm.setKuandai(frm.getKuandai() + 1);
						}
						if (yewu.contains("固话业务")) {
							frm.setDianhua(frm.getDianhua() + 1);
						}
						if (yewu.contains("单产品")) {
							frm.setDankuan(frm.getDankuan() + 1);
						}
						if (yewu.contains("e8") || yewu.contains("e9")) {
							frm.setTaocan(frm.getTaocan() + 1);
						}
						if (frm.isFlag() == false) {
							ParameterSet set1 = new ParameterSet();
							set1.add("tingjishijian", "@tingjis", frm.getRiqi());
							set1.add("shigongren", "@shigongren",
									frm.getShigongren());
							set1.add("xiaoqu", "@xiaoqu", frm.getXiaoqu());
							DataSet<DataRow> executeQuery = dao.executeQuery(
									"GetRuhuList", set1);
							String num = executeQuery.get(0)
									.getDataElement("num").getString();
							frm.setRuhushu(frm.getRuhushu()
									+ Double.valueOf(num));

							ParameterSet set2 = new ParameterSet();
							String sql;
							sql = " SELECT SUM(  CASE   WHEN  (SELECT   COUNT(*) FROM yonghushuju t2 WHERE t2.dizhi = t1.dizhi AND  t2.xiaoqu = '"
									+ frm.getXiaoqu()
									+ "'  AND   t2.yonghuzhuangtai = '已安装'  AND t2.kaijishijian < '"
									+ frm.getRiqi()
									+ "' ) = 0 THEN 1 ELSE 0 END   ) AS az_shoushifei FROM (SELECT DISTINCT dizhi FROM yonghushuju a WHERE a.tingjishijian = '"
									+ frm.getRiqi()
									+ "'  AND a.shigongren = '"
									+ frm.getShigongren()
									+ "'  AND a.xiaoqu = '"
									+ frm.getXiaoqu()
									+ "'  AND a.yonghuzhuangtai = '已安装' ) t1";
							DataSet<DataRow> executeQuery1 = dao.executeQuery(
									"getShouciRuhu", set2, sql);
							String num1 = executeQuery1.get(0)
									.getDataElement("az_shoushifei")
									.getString();
							frm.setShouciruhushu(frm.getShouciruhushu()
									+ Double.valueOf(num1));

							frm.setFlag(true);
						}
					}
					if (yonghuzhuangtai.equals("已退订")) {
						frm.setTuiding(frm.getTuiding() + 1);
					}
					if (yonghuzhuangtai.equals("已维修")) {
						frm.setWeixiushu(frm.getWeixiushu() + 1);
					}
					if (yonghuzhuangtai.equals("已续费")) {
						frm.setXufei(frm.getXufei() + 1);
					}
				}
			} else {
				if (shoukuanshijian.equals(frm.getRiqi())
						&& xiaoqu.equals(frm.getXiaoqu())
						&& shigongren.equals(frm.getShigongren())) {
					if (yonghuzhuangtai.equals("已安装")) {
						if (!dianshi.equals("0")) {
							frm.setDianshi(frm.getDianshi() + 1);
						}
						if (!wangluo.equals("0")) {
							frm.setKuandai(frm.getKuandai() + 1);
						}
						if (yewu.contains("固话业务")) {
							frm.setDianhua(frm.getDianhua() + 1);
						}
						if (yewu.contains("单产品")) {
							frm.setDankuan(frm.getDankuan() + 1);
						}
						if (yewu.contains("e8") || yewu.contains("e9")) {
							frm.setTaocan(frm.getTaocan() + 1);
						}
						if (frm.isFlag() == false) {
							ParameterSet set1 = new ParameterSet();
							set1.add("shoukuanshijian", "@shoukuanshijians",
									frm.getRiqi());
							set1.add("shigongren", "@shigongren",
									frm.getShigongren());
							set1.add("xiaoqu", "@xiaoqu", frm.getXiaoqu());
							DataSet<DataRow> executeQuery = dao.executeQuery(
									"GetRuhuList", set1);
							String num = executeQuery.get(0)
									.getDataElement("num").getString();
							frm.setRuhushu(frm.getRuhushu()
									+ Double.valueOf(num));

							ParameterSet set2 = new ParameterSet();
							String sql;
							sql = " SELECT SUM(  CASE   WHEN  (SELECT   COUNT(*) FROM yonghushuju t2 WHERE t2.dizhi = t1.dizhi AND  t2.xiaoqu = '"
									+ frm.getXiaoqu()
									+ "'  AND   t2.yonghuzhuangtai = '已安装'  AND t2.kaijishijian < '"
									+ frm.getRiqi()
									+ "' ) = 0 THEN 1 ELSE 0 END   ) AS az_shoushifei FROM (SELECT DISTINCT dizhi FROM yonghushuju a WHERE a.shoukuanshijian = '"
									+ frm.getRiqi()
									+ "'  AND a.shigongren = '"
									+ frm.getShigongren()
									+ "'  AND a.xiaoqu = '"
									+ frm.getXiaoqu()
									+ "'  AND a.yonghuzhuangtai = '已安装' ) t1";
							DataSet<DataRow> executeQuery1 = dao.executeQuery(
									"getShouciRuhu", set2, sql);
							String num1 = executeQuery1.get(0)
									.getDataElement("az_shoushifei")
									.getString();
							frm.setShouciruhushu(frm.getShouciruhushu()
									+ Double.valueOf(num1));

							frm.setFlag(true);
						}
					}
					if (yonghuzhuangtai.equals("已退订")) {
						frm.setTuiding(frm.getTuiding() + 1);
					}
					if (yonghuzhuangtai.equals("已维修")) {
						frm.setWeixiushu(frm.getWeixiushu() + 1);
					}
					if (yonghuzhuangtai.equals("已续费")) {
						frm.setXufei(frm.getXufei() + 1);
					}
				}
			}

			frmList.set(i, frm);
		}
	}

	private void initWorkLoadList(DataSet<DataRow> set,
			List<WorkLoadForm> frmList, TotalForm form, String SPLIT_CHAR) {
		List<String> listshigongren = new ArrayList<String>();
		String[] sgrArr = null;
		Set<String> setRen = new HashSet<String>();
		String kaijis = form.getKaijisHidden();
		String kaijie = form.getKaijieHidden();
		String[] xiaoquList = form.getXiaoqutext().split(",");
		List listTime = new ArrayList();
		Calendar calendars = Calendar.getInstance();
		Calendar calendare = Calendar.getInstance();
		SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfe = new SimpleDateFormat("yyyy-MM-dd");
		try {
			calendars.setTime(sdfs.parse(kaijis));
			listTime.add(sdfs.format(calendars.getTime()));
			calendare.setTime(sdfe.parse(kaijie));
			while (!sdfs.format(calendars.getTime()).equals(
					sdfe.format(calendare.getTime()))) {
				calendars.add(calendars.DAY_OF_MONTH, 1);
				listTime.add(sdfs.format(calendars.getTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Map<String, Double> map = new HashMap<String, Double>();
		for (int i = 0; i < set.size(); i++) {
			if (isSGRContainMutli(
					SPLIT_CHAR,
					set.get(i).getDataElement("shigongren").getString() == null ? "null"
							: set.get(i).getDataElement("shigongren")
									.getString())) {
				String[] split = SPLIT_CHAR.split(",");
				String shigongren = set.get(i).getDataElement("shigongren")
						.getString();
				for (int j = 0; j < split.length; j++) {
					if (shigongren.contains(split[j])) {
						sgrArr = shigongren.split(split[j]);
						if (sgrArr.length > 0) {
							int length = sgrArr.length;
							Double d = (1.0D / sgrArr.length);
							for (int h = 0; h < sgrArr.length; h++) {
								setRen.add(sgrArr[h]);
							}
						}
					}

				}
			} else {
				setRen.add(set.get(i).getDataElement("shigongren").getString());
			}
		}
		Object[] array = setRen.toArray();

		for (int h = 0; h < listTime.size(); h++) {
			for (int j = 0; j < xiaoquList.length; j++) {
				for (int i = 0; i < array.length; i++) {
					WorkLoadForm w = new WorkLoadForm();
					w.setRiqi(listTime.get(h).toString());
					w.setXiaoqu(xiaoquList[j]);
					if (String.valueOf(array[i]).equals("")) {
						continue;
					}
					w.setShigongren(String.valueOf(array[i]));
					w.setDianshi(0);
					w.setKuandai(0);
					w.setDianhua(0);
					w.setDankuan(0);
					w.setTaocan(0);
					w.setRuhushu(0);
					w.setShouciruhushu(0);
					w.setWeixiushu(0);
					w.setXufei(0);
					w.setTuiding(0);
					frmList.add(w);
				}
			}
		}
	}

	private void dataAnalyseMutil(DataRow s, List<WorkLoadForm> frmList,
			TotalForm form, String SPLIT_CHAR) throws Exception {
		String dianshi = s.getDataElement("dianshi").getString();
		String wangluo = s.getDataElement("wangluo").getString();
		String yewu = s.getDataElement("yewu").getString();
		// String ruhushu = s.getDataElement("ruhushu").getString();
		// String shouciruhu = s.getDataElement("shouciruhu").getString();
		String shigongren = s.getDataElement("shigongren").getString();
		String xiaoqu = s.getDataElement("xiaoqu").getString();
		String kaijishijian = s.getDataElement("kaijishijian").getString();
		String tingjishijian = s.getDataElement("tingjishijian").getString();
		String shoukuanshijian = s.getDataElement("shoukuanshijian")
				.getString();
		String yonghuzhuangtai = s.getDataElement("yonghuzhuangtai")
				.getString();
		String dizhi = s.getDataElement("dizhi").getString();
		String duoshigongren = shigongren;
		String[] sgrArr = null;
		// double shouciruhuDouble = Double.parseDouble(shouciruhu);

		String[] split = SPLIT_CHAR.split(",");
		Double d = 0.0D;

		for (int i = 0; i < split.length; i++) {
			if (!shigongren.contains(split[i])) {
				continue;
			}
			sgrArr = shigongren.split(split[i]);

			if (sgrArr.length > 0) {
				d = (1.0D / sgrArr.length);
				d = Math.floor(d * 100) / 100;
				break;
			}

		}

		/*
		 * if (Integer.parseInt(shouciruhu) == 0) { shouciruhuDouble = (1.0D /
		 * sgrArr.length); shouciruhuDouble = Math.floor(shouciruhuDouble * 100)
		 * / 100; } else { shouciruhuDouble = 0; }
		 */

		for (int j = 0; j < sgrArr.length; j++) {
			/*
			 * data list loop for check every record.
			 */
			for (int i = 0; i < frmList.size(); i++) {
				WorkLoadForm frm = frmList.get(i);

				// check data type
				if (form.getShijianleixing().equals("1")) {
					// when search date and xiaoqu and shigongren all equals
					// then continue produce.
					if (kaijishijian.equals(frm.getRiqi())
							&& xiaoqu.equals(frm.getXiaoqu())
							&& sgrArr[j].equals(frm.getShigongren())) {
						if (yonghuzhuangtai.equals("已安装")) {
							if (!dianshi.equals("0")) {
								frm.setDianshi(frm.getDianshi() + d);
							}
							if (!wangluo.equals("0")) {
								frm.setKuandai(frm.getKuandai() + d);
							}
							if (yewu.contains("固话业务")) {
								frm.setDianhua(frm.getDianhua() + d);
							}
							if (yewu.contains("单产品")) {
								frm.setDankuan(frm.getDankuan() + d);
							}
							if (yewu.contains("e8") || yewu.contains("e9")) {
								frm.setTaocan(frm.getTaocan() + d);
							}

							if (mapDuoren.get(duoshigongren) == null) {
								ParameterSet set1 = new ParameterSet();
								set1.add("kaijishijian", "@kaijis",
										frm.getRiqi());
								set1.add("shigongren", "@shigongren",
										duoshigongren);
								set1.add("xiaoqu", "@xiaoqu", frm.getXiaoqu());
								DataSet<DataRow> executeQuery = dao
										.executeQuery("GetRuhuList", set1);
								Double value = Double.valueOf(executeQuery
										.get(0).getDataElement("num")
										.getString());
								value = (value / sgrArr.length);
								value = Math.floor(value * 100) / 100;
								frm.setRuhushu(frm.getRuhushu() + value);

								ParameterSet set2 = new ParameterSet();
								String sql;
								sql = " SELECT  SUM(  CASE   WHEN  (SELECT   COUNT(*) FROM yonghushuju t2 WHERE t2.dizhi = t1.dizhi AND  t2.xiaoqu = '"
										+ frm.getXiaoqu()
										+ "'  AND   t2.yonghuzhuangtai = '已安装'  AND t2.kaijishijian < '"
										+ frm.getRiqi()
										+ "' ) = 0 THEN 1 ELSE 0 END   ) AS az_shoushifei FROM (SELECT DISTINCT dizhi FROM yonghushuju a WHERE a.kaijishijian = '"
										+ frm.getRiqi()
										+ "'  AND a.shigongren = '"
										+ duoshigongren
										+ "'  AND a.xiaoqu = '"
										+ frm.getXiaoqu()
										+ "'  AND a.yonghuzhuangtai = '已安装' ) t1";
								DataSet<DataRow> executeQuery1 = dao
										.executeQuery("getShouciRuhu", set2,
												sql);
								Double num1 = Double.valueOf(executeQuery1
										.get(0).getDataElement("az_shoushifei")
										.getString());
								num1 = (double) (num1 / sgrArr.length);
								num1 = Math.floor(num1 * 100) / 100;
								frm.setShouciruhushu(frm.getShouciruhushu()
										+ num1);

								List list = new ArrayList();
								list.add(frm.getShigongren());
								mapDuoren.put(duoshigongren, list);
							} else {
								boolean flage = false;
								for (int w = 0; w < mapDuoren
										.get(duoshigongren).size(); w++) {
									if (mapDuoren.get(duoshigongren).get(w)
											.equals(frm.getShigongren())) {
										flage = true;
										break;
									} else {
										flage = false;
									}
								}
								if (flage == false) {
									ParameterSet set1 = new ParameterSet();
									set1.add("kaijishijian", "@kaijis",
											frm.getRiqi());
									set1.add("shigongren", "@shigongren",
											duoshigongren);
									set1.add("xiaoqu", "@xiaoqu",
											frm.getXiaoqu());
									DataSet<DataRow> executeQuery = dao
											.executeQuery("GetRuhuList", set1);
									Double value = Double.valueOf(executeQuery
											.get(0).getDataElement("num")
											.getString());
									value = (value / sgrArr.length);
									value = Math.floor(value * 100) / 100;
									frm.setRuhushu(frm.getRuhushu() + value);

									ParameterSet set2 = new ParameterSet();
									String sql;
									sql = " SELECT  SUM(  CASE   WHEN  (SELECT   COUNT(*) FROM yonghushuju t2 WHERE t2.dizhi = t1.dizhi AND  t2.xiaoqu = '"
											+ frm.getXiaoqu()
											+ "'  AND   t2.yonghuzhuangtai = '已安装'  AND t2.kaijishijian < '"
											+ frm.getRiqi()
											+ "' ) = 0 THEN 1 ELSE 0 END   ) AS az_shoushifei FROM (SELECT DISTINCT dizhi FROM yonghushuju a WHERE a.kaijishijian = '"
											+ frm.getRiqi()
											+ "'  AND a.shigongren = '"
											+ duoshigongren
											+ "'  AND a.xiaoqu = '"
											+ frm.getXiaoqu()
											+ "'  AND a.yonghuzhuangtai = '已安装' ) t1";
									DataSet<DataRow> executeQuery1 = dao
											.executeQuery("getShouciRuhu",
													set2, sql);
									Double num1 = Double.valueOf(executeQuery1
											.get(0)
											.getDataElement("az_shoushifei")
											.getString());
									num1 = (double) (num1 / sgrArr.length);
									num1 = Math.floor(num1 * 100) / 100;
									frm.setShouciruhushu(frm.getShouciruhushu()
											+ num1);

									List list = mapDuoren.get(duoshigongren);
									list.add(frm.getShigongren());
									mapDuoren.put(duoshigongren, list);
								}
							}
							// frm.setRuhushu(frm.getRuhushu() + d);
						}
						if (yonghuzhuangtai.equals("已退订")) {
							frm.setTuiding(frm.getTuiding() + d);
						}
						if (yonghuzhuangtai.equals("已维修")) {
							frm.setWeixiushu(frm.getWeixiushu() + d);
						}
						if (yonghuzhuangtai.equals("已续费")) {
							frm.setXufei(frm.getXufei() + d);
						}

					}
				} else if (form.getShijianleixing().equals("2")) {
					if (tingjishijian.equals(frm.getRiqi())
							&& xiaoqu.equals(frm.getXiaoqu())
							&& sgrArr[j].equals(frm.getShigongren())) {
						if (yonghuzhuangtai.equals("已安装")) {
							if (!dianshi.equals("0")) {
								frm.setDianshi(frm.getDianshi() + d);
							}
							if (!wangluo.equals("0")) {
								frm.setKuandai(frm.getKuandai() + d);
							}
							if (yewu.contains("固话业务")) {
								frm.setDianhua(frm.getDianhua() + d);
							}
							if (yewu.contains("单产品")) {
								frm.setDankuan(frm.getDankuan() + d);
							}
							if (yewu.contains("e8") || yewu.contains("e9")) {
								frm.setTaocan(frm.getTaocan() + d);
							}

							// frm.setShouciruhushu(frm.getShouciruhushu() + 1);
							if (mapDuoren.get(duoshigongren) == null) {
								ParameterSet set1 = new ParameterSet();
								set1.add("tingjishijian", "@tingjis",
										frm.getRiqi());
								set1.add("shigongren", "@shigongren",
										duoshigongren);
								set1.add("xiaoqu", "@xiaoqu", frm.getXiaoqu());
								DataSet<DataRow> executeQuery = dao
										.executeQuery("GetRuhuList", set1);
								Double value = Double.valueOf(executeQuery
										.get(0).getDataElement("num")
										.getString());
								value = (value / sgrArr.length);
								value = Math.floor(value * 100) / 100;
								frm.setRuhushu(frm.getRuhushu() + value);

								ParameterSet set2 = new ParameterSet();
								String sql;
								sql = " SELECT  SUM(  CASE   WHEN  (SELECT   COUNT(*) FROM yonghushuju t2 WHERE t2.dizhi = t1.dizhi AND  t2.xiaoqu = '"
										+ frm.getXiaoqu()
										+ "'  AND   t2.yonghuzhuangtai = '已安装'  AND t2.kaijishijian < '"
										+ frm.getRiqi()
										+ "' ) = 0 THEN 1 ELSE 0 END   ) AS az_shoushifei FROM (SELECT DISTINCT dizhi FROM yonghushuju a WHERE a.tingjishijian = '"
										+ frm.getRiqi()
										+ "'  AND a.shigongren = '"
										+ duoshigongren
										+ "'  AND a.xiaoqu = '"
										+ frm.getXiaoqu()
										+ "'  AND a.yonghuzhuangtai = '已安装' ) t1";
								DataSet<DataRow> executeQuery1 = dao
										.executeQuery("getShouciRuhu", set2,
												sql);
								Double num1 = Double.valueOf(executeQuery1
										.get(0).getDataElement("az_shoushifei")
										.getString());
								num1 = (double) (num1 / sgrArr.length);
								num1 = Math.floor(num1 * 100) / 100;
								frm.setShouciruhushu(frm.getShouciruhushu()
										+ num1);

								List list = new ArrayList();
								list.add(frm.getShigongren());
								mapDuoren.put(duoshigongren, list);
							} else {
								boolean flage = false;
								for (int w = 0; w < mapDuoren
										.get(duoshigongren).size(); w++) {
									if (mapDuoren.get(duoshigongren).get(w)
											.equals(frm.getShigongren())) {
										flage = true;
										break;
									} else {
										flage = false;
									}
								}
								if (flage == false) {
									ParameterSet set1 = new ParameterSet();
									set1.add("tingjishijian", "@tingjis",
											frm.getRiqi());
									set1.add("shigongren", "@shigongren",
											duoshigongren);
									set1.add("xiaoqu", "@xiaoqu",
											frm.getXiaoqu());
									DataSet<DataRow> executeQuery = dao
											.executeQuery("GetRuhuList", set1);
									Double value = Double.valueOf(executeQuery
											.get(0).getDataElement("num")
											.getString());
									value = (value / sgrArr.length);
									value = Math.floor(value * 100) / 100;
									frm.setRuhushu(frm.getRuhushu() + value);

									ParameterSet set2 = new ParameterSet();
									String sql;
									sql = " SELECT  SUM(  CASE   WHEN  (SELECT   COUNT(*) FROM yonghushuju t2 WHERE t2.dizhi = t1.dizhi AND  t2.xiaoqu = '"
											+ frm.getXiaoqu()
											+ "'  AND   t2.yonghuzhuangtai = '已安装'  AND t2.kaijishijian < '"
											+ frm.getRiqi()
											+ "' ) = 0 THEN 1 ELSE 0 END   ) AS az_shoushifei FROM (SELECT DISTINCT dizhi FROM yonghushuju a WHERE a.tingjishijian = '"
											+ frm.getRiqi()
											+ "'  AND a.shigongren = '"
											+ duoshigongren
											+ "'  AND a.xiaoqu = '"
											+ frm.getXiaoqu()
											+ "'  AND a.yonghuzhuangtai = '已安装' ) t1";
									DataSet<DataRow> executeQuery1 = dao
											.executeQuery("getShouciRuhu",
													set2, sql);
									Double num1 = Double.valueOf(executeQuery1
											.get(0)
											.getDataElement("az_shoushifei")
											.getString());
									num1 = (double) (num1 / sgrArr.length);
									num1 = Math.floor(num1 * 100) / 100;
									frm.setShouciruhushu(frm.getShouciruhushu()
											+ num1);

									List list = mapDuoren.get(duoshigongren);
									list.add(frm.getShigongren());
									mapDuoren.put(duoshigongren, list);
								}
							}
						}
						if (yonghuzhuangtai.equals("已退订")) {
							frm.setTuiding(frm.getTuiding() + d);
						}
						if (yonghuzhuangtai.equals("已维修")) {
							frm.setWeixiushu(frm.getWeixiushu() + d);
						}
						if (yonghuzhuangtai.equals("已续费")) {
							frm.setXufei(frm.getXufei() + d);
						}
					}
				} else {
					if (shoukuanshijian.equals(frm.getRiqi())
							&& xiaoqu.equals(frm.getXiaoqu())
							&& sgrArr[j].equals(frm.getShigongren())) {
						if (yonghuzhuangtai.equals("已安装")) {
							if (!dianshi.equals("0")) {
								frm.setDianshi(frm.getDianshi() + d);
							}
							if (!wangluo.equals("0")) {
								frm.setKuandai(frm.getKuandai() + d);
							}
							if (yewu.contains("固话业务")) {
								frm.setDianhua(frm.getDianhua() + d);
							}
							if (yewu.contains("单产品")) {
								frm.setDankuan(frm.getDankuan() + d);
							}
							if (yewu.contains("e8") || yewu.contains("e9")) {
								frm.setTaocan(frm.getTaocan() + d);
							}

							// frm.setShouciruhushu(frm.getShouciruhushu() + 1);
							if (mapDuoren.get(duoshigongren) == null) {
								ParameterSet set1 = new ParameterSet();
								set1.add("shoukuanshijians",
										"@shoukuanshijians", frm.getRiqi());
								set1.add("shigongren", "@shigongren",
										duoshigongren);
								set1.add("xiaoqu", "@xiaoqu", frm.getXiaoqu());
								DataSet<DataRow> executeQuery = dao
										.executeQuery("GetRuhuList", set1);
								Double value = Double.valueOf(executeQuery
										.get(0).getDataElement("num")
										.getString());
								value = (value / sgrArr.length);
								value = Math.floor(value * 100) / 100;
								frm.setRuhushu(frm.getRuhushu() + value);

								ParameterSet set2 = new ParameterSet();
								String sql;
								sql = " SELECT  SUM(  CASE   WHEN  (SELECT   COUNT(*) FROM yonghushuju t2 WHERE t2.dizhi = t1.dizhi AND  t2.xiaoqu = '"
										+ frm.getXiaoqu()
										+ "'  AND   t2.yonghuzhuangtai = '已安装'  AND t2.kaijishijian < '"
										+ frm.getRiqi()
										+ "' ) = 0 THEN 1 ELSE 0 END   ) AS az_shoushifei FROM (SELECT DISTINCT dizhi FROM yonghushuju a WHERE a.shoukuanshijian = '"
										+ frm.getRiqi()
										+ "'  AND a.shigongren = '"
										+ duoshigongren
										+ "'  AND a.xiaoqu = '"
										+ frm.getXiaoqu()
										+ "'  AND a.yonghuzhuangtai = '已安装' ) t1";
								DataSet<DataRow> executeQuery1 = dao
										.executeQuery("getShouciRuhu", set2,
												sql);
								Double num1 = Double.valueOf(executeQuery1
										.get(0).getDataElement("az_shoushifei")
										.getString());
								num1 = (double) (num1 / sgrArr.length);
								num1 = Math.floor(num1 * 100) / 100;
								frm.setShouciruhushu(frm.getShouciruhushu()
										+ num1);

								List list = new ArrayList();
								list.add(frm.getShigongren());
								mapDuoren.put(duoshigongren, list);
							} else {
								boolean flage = false;
								for (int w = 0; w < mapDuoren
										.get(duoshigongren).size(); w++) {
									if (mapDuoren.get(duoshigongren).get(w)
											.equals(frm.getShigongren())) {
										flage = true;
										break;
									} else {
										flage = false;
									}
								}
								if (flage == false) {
									ParameterSet set1 = new ParameterSet();
									set1.add("shoukuanshijians",
											"@shoukuanshijians", frm.getRiqi());
									set1.add("shigongren", "@shigongren",
											duoshigongren);
									set1.add("xiaoqu", "@xiaoqu",
											frm.getXiaoqu());
									DataSet<DataRow> executeQuery = dao
											.executeQuery("GetRuhuList", set1);
									Double value = Double.valueOf(executeQuery
											.get(0).getDataElement("num")
											.getString());
									value = (value / sgrArr.length);
									value = Math.floor(value * 100) / 100;
									frm.setRuhushu(frm.getRuhushu() + value);

									String sql;
									ParameterSet set2 = new ParameterSet();
									sql = " SELECT  SUM(  CASE   WHEN  (SELECT   COUNT(*) FROM yonghushuju t2 WHERE t2.dizhi = t1.dizhi AND  t2.xiaoqu = '"
											+ frm.getXiaoqu()
											+ "'  AND   t2.yonghuzhuangtai = '已安装'  AND t2.kaijishijian < '"
											+ frm.getRiqi()
											+ "' ) = 0 THEN 1 ELSE 0 END   ) AS az_shoushifei FROM (SELECT DISTINCT dizhi FROM yonghushuju a WHERE a.shoukuanshijian = '"
											+ frm.getRiqi()
											+ "'  AND a.shigongren = '"
											+ duoshigongren
											+ "'  AND a.xiaoqu = '"
											+ frm.getXiaoqu()
											+ "'  AND a.yonghuzhuangtai = '已安装' ) t1";
									DataSet<DataRow> executeQuery1 = dao
											.executeQuery("getShouciRuhu",
													set2, sql);
									Double num1 = Double.valueOf(executeQuery1
											.get(0)
											.getDataElement("az_shoushifei")
											.getString());
									num1 = (double) (num1 / sgrArr.length);
									num1 = Math.floor(num1 * 100) / 100;
									frm.setShouciruhushu(frm.getShouciruhushu()
											+ num1);
									List list = mapDuoren.get(duoshigongren);
									list.add(frm.getShigongren());
									mapDuoren.put(duoshigongren, list);
								}
							}
						}
						if (yonghuzhuangtai.equals("已退订")) {
							frm.setTuiding(frm.getTuiding() + d);
						}
						if (yonghuzhuangtai.equals("已维修")) {
							frm.setWeixiushu(frm.getWeixiushu() + d);
						}
						if (yonghuzhuangtai.equals("已续费")) {
							frm.setXufei(frm.getXufei() + d);
						}
					}

					frmList.set(i, frm);
				}
			}
		}
	}

	// *******************************社区金额统计模块********************************************

	/*
	 * 存放查询条件 SET
	 */
	private ParameterSet SetShequjine(TotalForm form) {
		ParameterSet set = new ParameterSet();
		if (form.getXiaoquHidden() != null) {
			set.add("xiaoqu", "@xiaoqu", form.getXiaoquHidden());
		}

		if (form.getKaijisHidden() != null) {
			set.add("kaijis", "@kaijis", form.getKaijisHidden());
		}

		if (form.getKaijieHidden() != null) {
			set.add("kaijie", "@kaijie", form.getKaijieHidden());
		}
		return set;
	}

	/**
	 * 社区金额
	 * 
	 * @param form
	 * @param first
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getShequjine(TotalForm form, int first, int rows)
			throws Exception {
		if (form.getXiaoqu() == null) {
			return new DataSet<DataRow>();
		}
		if (form.getXiaoquHidden().equals("")
				&& form.getKaijisHidden().equals("")
				&& form.getKaijieHidden().equals("")) {
			return new DataSet<DataRow>();
		}
		return dao
				.executeQuery("getShequjine", SetShequjine(form), first, rows);
	}

	public CommonMessage shequjineimport(TotalForm form) throws Exception {
		// List<TotalForm> tflist = new ArrayList<TotalForm>();
		if (form.getXiaoquHidden().equals("")
				&& form.getKaijisHidden().equals("")
				&& form.getKaijieHidden().equals("")) {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,
					"请查询要生成的数据！");
		}
		DataSet<DataRow> executeQuery = dao.executeQuery("getShequjine",
				SetShequjine(form));

		try {
			toExcel(executeQuery);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,
					"数据异常,生成失败！");
		}
		// toExcel(tflist,date2,date1);
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,
				" 对账生成在C:\\\\shequjine路径下！");
	}

	private void toExcel(DataSet<DataRow> executeQuery) throws IOException {
		String path = "c:/shequjine";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		String str[] = { "小区", "地址", "姓名", "电话", "次数", "金额" };
		String excelAzpath = "c:\\shequjine\\社区金额.xls";
		OutputStream out1 = new FileOutputStream(excelAzpath);
		ExportShequExcel et = new ExportShequExcel();
		et.exportExcelHuiZongTongji(executeQuery, out1, str);
		out1.close();
	}

	// ********************************社区金额统计模块end******************************************

	// *******************************运营商数据统计模块********************************************
	private ParameterSet SetYunYing(TotalForm form) {
		ParameterSet set = new ParameterSet();
		if (form.getXiaoquHidden() != null) {
			set.add("xiaoqu", "@xiaoqu", form.getXiaoquHidden());
		}

		if (form.getShijianleixing() == null
				|| form.getShijianleixing().equals("")) {
		} else {
			if (form.getShijianleixing().equals("1")) {
				set.add("kaijis", "@kaijis", form.getKaijisHidden());
				set.add("kaijie", "@kaijie", form.getKaijieHidden());
			}
			if (form.getShijianleixing().equals("2")) {
				set.add("kaijis", "@tingjis", form.getKaijisHidden());
				set.add("kaijie", "@tingjie", form.getKaijieHidden());
			}
			if (form.getShijianleixing().equals("3")) {
				set.add("kaijis", "@shoukuanshijians", form.getKaijisHidden());
				set.add("kaijie", "@shoukuanshijiane", form.getKaijieHidden());
			}
			if (form.getShijianleixing().equals("4")) {
				set.add("kaijis", "@youxiaoshijians", form.getKaijisHidden());
				set.add("kaijie", "@youxiaoshijiane", form.getKaijieHidden());
			}
		}
		return set;
	}

	public DataSet<DataRow> getYunYingShangData(TotalForm form, int first,
			int rows) throws Exception {
		if (form.getXiaoqu() == null) {
			return new DataSet<DataRow>();
		}
		/*
		 * if (form.getXiaoquHidden().equals("") &&
		 * form.getKaijisHidden().equals("") &&
		 * form.getKaijieHidden().equals("") ){ return new DataSet<DataRow>(); }
		 */
		return dao.executeQuery("getYunYingShangData", SetYunYing(form), first,
				rows);
	}

	public CommonMessage yunYingShangDataImport(TotalForm f) throws Exception {
		/*
		 * if (f.getXiaoquHidden().equals("") && f.getKaijisHidden() .equals("")
		 * && f.getKaijieHidden().equals("") &&
		 * f.getShijianleixingHidden().equals("") ){ return new
		 * CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"请查询要生成的数据！"); }
		 */
		DataSet<DataRow> executeQuery = dao.executeQuery("getYunYingShangData",
				SetShequjine(f));

		try {
			toExcelYunYing(executeQuery);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,
					"数据异常,生成失败！");
		}
		// toExcel(tflist,date2,date1);
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,
				" 对账生成在C:\\\\shequjine路径下！");
	}

	private void toExcelYunYing(DataSet<DataRow> executeQuery)
			throws IOException {
		String path = "c:/shequjine";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		String str[] = { "小区", "运营商", "安装网络数量 ", "安装电视数量 ", "安装电话数量" };
		String excelAzpath = "c:\\shequjine\\运营商数据.xls";
		OutputStream out1 = new FileOutputStream(excelAzpath);
		ExportShequExcel et = new ExportShequExcel();
		et.exportExcelYunYingData(executeQuery, out1, str);
		out1.close();
	}

	// ********************************运营商数据统计模块end******************************************
	// *****************************日报统计***********************************************
	private ParameterSet SetRibao(TotalForm form) {
		ParameterSet set = new ParameterSet();
//		if(form.getYunyingshanghidden()!=null && !"".equals(form.getYunyingshanghidden())){
//			set.add("yunyingshang", "@yunyingshang", form.getYunyingshanghidden());
//		}
		if (form.getShijianleixing() == null
				|| form.getShijianleixing().equals("")) {
		} else {
			if (form.getShijianleixing().equals("1")) {
				set.add("kaijis", "@kaijis", form.getKaijisHidden());
				set.add("kaijie", "@kaijie", form.getKaijieHidden());
			}
			if (form.getShijianleixing().equals("2")) {
				set.add("kaijis", "@tingjis", form.getKaijisHidden());
				set.add("kaijie", "@tingjie", form.getKaijieHidden());
			}
			if (form.getShijianleixing().equals("3")) {
				set.add("kaijis", "@shoukuanshijians", form.getKaijisHidden());
				set.add("kaijie", "@shoukuanshijiane", form.getKaijieHidden());
			}
			if (form.getShijianleixing().equals("4")) {
				set.add("kaijis", "@youxiaoshijians", form.getKaijisHidden());
				set.add("kaijie", "@youxiaoshijiane", form.getKaijieHidden());
			}
		}
		return set;
	}

	public DataSet<DataRow> getMingxiDataSet(TotalForm form, int first, int rows)
			throws Exception {
		ParameterSet parameterSet = SetRibao(form);
		String sqlString = "GetResultRibaotongjiMingxi";
		String sqlstate = "";
		DataSet<DataRow> dataRows = new DataSet<DataRow>();
		if (form.getXiaoqutext() == null
				|| "".equals(form.getXiaoqutextHidden().trim())) {
			sqlString = "GetEmptyDataList";
			dataRows = dao.executeQuery(sqlString, parameterSet);
		} else {
			if (form.getXiaoqutextHidden() != null) {
				String xqString = "";
				String[] strings = form.getXiaoqutextHidden().split(",");
				for (int i = 0; i < strings.length; i++) {
					xqString += strings[i] + "','";
				}
				if (xqString.length() > 0) {
					sqlstate += " AND y.xiaoqu in ('"
							+ xqString.substring(0, xqString.length() - 3)
							+ "')";
				}
			}
			Map<String, String> gzlb = new HashMap<String, String>();
			gzlb.put("开户", "已安装");
			gzlb.put("收件", "已收件");
			gzlb.put("维修", "已维修");
			gzlb.put("续费", "已续费");
			gzlb.put("退订", "已退订");
			if (form.getGongzuoleibiehidden() != null
					&& !"".equals(form.getGongzuoleibiehidden().trim())) {
				String gzlbString = form.getGongzuoleibiehidden();
				String[] strings = gzlbString.split(",");
				String param = "";
				for (int i = 0; i < strings.length; i++) {
					param += ",'" + gzlb.get(strings[i]) + "'";
				}
				if (param.length() > 0) {
					sqlstate += " and y.yonghuzhuangtai in ("
							+ param.substring(1) + ")";
				}
			}
			if (form.getYunyingshanghidden() != null
					&& !"".equals(form.getYunyingshanghidden().trim())) {
				String yysString = form.getYunyingshanghidden();
				String[] strings = yysString.split(",");
				String yys = "";
				for (int i = 0; i < strings.length; i++) {
					yys += ",'" + strings[i] + "'";
				}
				if (yys.length() > 0) {
					sqlstate += " AND CASE WHEN yunyingshang ='0' OR yunyingshang ='' OR yunyingshang is null THEN '天房' ELSE yunyingshang END in ("
							+ yys.substring(1) + ")";
				}
			}
			sqlString = "GetResultRibaotongjiMingxi";
			dataRows = dao.executeQuery(sqlString, parameterSet,
					new String[] { sqlstate }, first, rows);

		}
		return dataRows;
	}

	public int getMingxiDataCount(TotalForm form) throws Exception {
		ParameterSet parameterSet = SetRibao(form);
		String sqlString = "GetCountRibaotongjiMingxi";
		String sqlstate = "";
		if (form.getXiaoqutextHidden() != null) {
			String xqString = "";
			String[] strings = form.getXiaoqutextHidden().split(",");
			for (int i = 0; i < strings.length; i++) {
				xqString += strings[i] + "','";
			}
			if (xqString.length() > 0) {
				sqlstate += " AND y.xiaoqu in ('"
						+ xqString.substring(0, xqString.length() - 3) + "')";
			}
		}
		Map<String, String> gzlb = new HashMap<String, String>();
		gzlb.put("开户", "已安装");
		gzlb.put("收件", "已收件");
		gzlb.put("维修", "已维修");
		gzlb.put("续费", "已续费");
		gzlb.put("退订", "已退订");
		if (form.getGongzuoleibiehidden() != null
				&& !"".equals(form.getGongzuoleibiehidden().trim())) {
			String gzlbString = form.getGongzuoleibiehidden();
			String[] strings = gzlbString.split(",");
			String param = "";
			for (int i = 0; i < strings.length; i++) {
				param += ",'" + gzlb.get(strings[i]) + "'";
			}
			if (param.length() > 0) {
				sqlstate += " and y.yonghuzhuangtai in (" + param.substring(1)
						+ ")";
			}
		}
		if (form.getYunyingshanghidden() != null
				&& !"".equals(form.getYunyingshanghidden().trim())) {
			String yysString = form.getYunyingshanghidden();
			String[] strings = yysString.split(",");
			String yys = "";
			for (int i = 0; i < strings.length; i++) {
				yys += ",'" + strings[i] + "'";
			}
			if (yys.length() > 0) {
				sqlstate += " AND CASE WHEN yunyingshang ='0' OR yunyingshang ='' OR yunyingshang is null THEN '天房' ELSE yunyingshang END in ("
						+ yys.substring(1) + ")";
			}
		}
		if (form.getXiaoqutext() == null
				|| "".equals(form.getXiaoqutextHidden().trim())) {
			return 0;
//			parameterSet.add("no", "@no", "1");
		}
		return dao
				.executeQueryToCount(sqlString, parameterSet, "CNT", sqlstate);
	}

	public DataSet<DataRow> getShuliangDataSet(TotalForm form) throws Exception {
		ParameterSet parameterSet = SetRibao(form);
		String sqlString = "GetResultRibaotongjiShuliang";
		String sqlstate = "";
		DataSet<DataRow> dataRows = new DataSet<DataRow>();
//		if (form.getXiaoqutext() == null
//				|| "".equals(form.getXiaoqutextHidden().trim())) {
//			sqlString = "GetEmptyDataList";
//			dataRows = dao.executeQuery(sqlString, parameterSet);
//		} else 
		{
			if (form.getXiaoqutextHidden() != null) {
				String xqString = "";
				String[] strings = form.getXiaoqutextHidden().split(",");
				for (int i = 0; i < strings.length; i++) {
					xqString += strings[i] + "','";
				}
				if (xqString.length() > 0) {
					sqlstate += " AND y.xiaoqu in ('"
							+ xqString.substring(0, xqString.length() - 3)
							+ "')";
				}
			}
//			if (form.getYunyingshanghidden() != null
//					&& !"".equals(form.getYunyingshanghidden())) {
//				String yysString = form.getYunyingshanghidden();
//				String[] strings = yysString.split(",");
//				String yys = "";
//				for (int i = 0; i < strings.length; i++) {
//					yys += ",'" + strings[i] + "'";
//				}
//				if (yys.length() > 0) {
//					sqlstate += " AND CASE WHEN yunyingshang ='0' OR yunyingshang ='' OR yunyingshang is null THEN '天房' ELSE yunyingshang END in ("
//							+ yys.substring(1) + ")";
//				}
//			}
			sqlString = "GetResultRibaotongjiShuliang";
			dataRows = dao.executeQuery("GetResultRibaotongjiShuliang",parameterSet,sqlstate);
			dataRows.get(0).addDataElement("yys", new DataElement("yys", "合计"));
			for(int i=1;i<form.getYunyingshangList().size();i++){
				parameterSet.add("yunyingshang","@yunyingshang", form.getYunyingshangList().get(i).getValue());
				DataSet<DataRow> dataRows2 = dao.executeQuery("GetResultRibaotongjiShuliang", parameterSet, sqlstate);
				dataRows2.get(0).addDataElement("yys", new DataElement("yys", form.getYunyingshangList().get(i).getKey()));
				dataRows.add(dataRows2.get(0));
			}
			

		}
		return dataRows;
	}
	public DataSet<DataRow> getShouruDataSet(TotalForm form) throws Exception {
		ParameterSet parameterSet = SetRibao(form);
		String sqlString = "GetResultRibaotongjishouru";
		String sqlstate = "";
		DataSet<DataRow> dataRows = new DataSet<DataRow>();
//		if (form.getXiaoqutext() == null
//				|| "".equals(form.getXiaoqutextHidden().trim())) {
//			sqlString = "GetEmptyDataList";
//			dataRows = dao.executeQuery(sqlString, parameterSet);
//		} else 
		{
			if (form.getXiaoqutextHidden() != null) {
				String xqString = "";
				String[] strings = form.getXiaoqutextHidden().split(",");
				for (int i = 0; i < strings.length; i++) {
					xqString += strings[i] + "','";
				}
				if (xqString.length() > 0) {
					sqlstate += " AND y.xiaoqu in ('"
							+ xqString.substring(0, xqString.length() - 3)
							+ "')";
				}
			}
//			if (form.getYunyingshanghidden() != null
//					&& !"".equals(form.getYunyingshanghidden())) {
//				String yysString = form.getYunyingshanghidden();
//				String[] strings = yysString.split(",");
//				String yys = "";
//				for (int i = 0; i < strings.length; i++) {
//					yys += ",'" + strings[i] + "'";
//				}
//				if (yys.length() > 0) {
//					sqlstate += " AND CASE WHEN yunyingshang ='0' OR yunyingshang ='' OR yunyingshang is null THEN '天房' ELSE yunyingshang END in ("
//							+ yys.substring(1) + ")";
//				}
//			}
			sqlString = "GetResultRibaotongjishouru";
			dataRows = dao.executeQuery("GetResultRibaotongjishouru",parameterSet,sqlstate);
			dataRows.get(0).addDataElement("yys", new DataElement("yys", "合计"));
			for(int i=1;i<form.getYunyingshangList().size();i++){
				parameterSet.add("yunyingshang","@yunyingshang", form.getYunyingshangList().get(i).getValue());
				DataSet<DataRow> dataRows2 = dao.executeQuery("GetResultRibaotongjishouru", parameterSet, sqlstate);
				dataRows2.get(0).addDataElement("yys", new DataElement("yys", form.getYunyingshangList().get(i).getKey()));
				dataRows.add(dataRows2.get(0));
			}
			

		}
		return dataRows;
	}
	// *****************************日报统计end***********************************************

}
