package com.stock.yonghushuju;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stock.util.RediusWebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.PropertyReader;
import com.webService.WebServiceMethods;

/**
 * @author wangdl
 * @version ����ʱ�䣺2012-6-14 ����09:44:35 ��˵��
 */

public class ImportDataService extends BusinessService {
	public static final String URL = PropertyReader.readProperty("BaseIp", "radius_server");
	private Log log = LogFactory.getLog(this.getClass());
	private ImportService service = new ImportService();
	private CommonDao dao = new CommonDao();
	private DataValidator validator = new DataValidator();
	// StringBuffer sb = new StringBuffer();
	Integer count = 0;
	String uuid = null;

	/**
	 * parse input to list.
	 *
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public List<EntityData> parse(InputStream input) throws Exception {
		List<EntityData> list = new ArrayList<EntityData>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);

		int i = 1;// ��excel�����п�ʼȡ����
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			EntityData entityTel = new EntityData();
			String[] values = service.convertRow(hssfRow, 53);// excel ��ȡ������

			entityTel.setYonghuzhuangtai(values[0]);
			if (values[1] == null || values[1].trim().equals("") || values[1].trim() == "") {
				entityTel.setPipeizhuangtai("δƥ��");
			} else {
				entityTel.setPipeizhuangtai(values[1]);
			}
			entityTel.setShoukuanshijian(values[2]);
			entityTel.setXingming(values[3]);
			entityTel.setShenfensheng(values[4]);
			entityTel.setShoujuhao(values[5]);
			entityTel.setFenguangxianhao(values[6]);
			entityTel.setJiexuweizhi(values[7]);
			entityTel.setKaijishijian(values[8]);
			entityTel.setTingjishijian(values[9]);
			// 20141027billy�����Чʱ��洢����
			entityTel.setYouxiaoshijian(values[9]);
			entityTel.setXiaoqu(values[10]);
			entityTel.setDizhi(values[11]);
			entityTel.setLianxidianhua(values[12]);
			entityTel.setWangluo(getDefValue(values[13]));
			entityTel.setDianshi(getDefValue(values[14]));
			entityTel.setDianhua(getDefValue(values[15]));
			entityTel.setYewu(values[16]);
			entityTel.setFenguang(values[17]);
			entityTel.setOnumac(values[18]);
			entityTel.setStbmcid(values[19]);
			entityTel.setDianshiip(values[20]);
			entityTel.setWangluoip(values[21]);
			entityTel.setDianhuaip(values[22]);
			entityTel.setDianhuavlan(values[23]);
			entityTel.setWangluovlan(values[24]);
			entityTel.setShangmenshijian(values[25]);
			entityTel.setDanzheng(values[26]);
			entityTel.setSxdhhm(values[27]);
			if (values[28] == null || values[28].trim().equals("") || values[28].trim() == "") {
				entityTel.setOnuyj("0");
			} else {
				entityTel.setOnuyj(values[28]);
			}
			if (values[29] == null || values[29].trim().equals("") || values[29].trim() == "") {
				entityTel.setJidingheyj("0");
			} else {
				entityTel.setJidingheyj(values[29]);
			}
			if (values[30] == null || values[30].trim().equals("") || values[30].trim() == "") {
				entityTel.setShoushifei("0");
			} else {
				entityTel.setShoushifei(values[30]);
			}
			if (values[31] == null || values[31].trim().equals("") || values[31].trim() == "") {
				entityTel.setKuandaifei("0");
			} else {
				entityTel.setKuandaifei(values[31]);
			}
			if (values[32] == null || values[32].trim().equals("") || values[32].trim() == "") {
				entityTel.setChuzhuangfei("0");
			} else {
				entityTel.setChuzhuangfei(values[32]);
			}
			if (values[33] == null || values[33].trim().equals("") || values[33].trim() == "") {
				entityTel.setShebeicaigou("0");
			} else {
				entityTel.setShebeicaigou(values[33]);
			}
			if (values[34] == null || values[34].trim().equals("") || values[34].trim() == "") {
				entityTel.setCailiaofei("0");
			} else {
				entityTel.setCailiaofei(values[34]);
			}
			entityTel.setYunyingshang(values[35]);
			if (values[36] == null || values[36].trim().equals("") || values[36].trim() == "") {
				entityTel.setBzygf("0");
			} else {
				entityTel.setBzygf(values[36]);
			}
			if (values[37] == null || values[37].trim().equals("") || values[37].trim() == "") {
				entityTel.setNianfei("0");
			} else {
				entityTel.setNianfei(values[37]);
			}
			entityTel.setBeizhu(values[38]);
			if (values[39] == null || values[39].trim().equals("") || values[39].trim() == "") {
				entityTel.setZongshoufei("0");
			} else {
				entityTel.setZongshoufei(values[39]);
			}
			entityTel.setShoujubenhao(values[40]);
			entityTel.setKaipiaoxinxi(values[41]);
			entityTel.setQtsbsyqk(values[42]);
			entityTel.setQitahaocai(values[43]);
			entityTel.setJiexianzi(values[44]);
			entityTel.setRj11(values[45]);
			entityTel.setRj45(values[46]);
			entityTel.setMokuai(values[47]);
			entityTel.setMianban(values[48]);
			entityTel.setWangxian(values[49]);
			entityTel.setShigongren(values[50]);
			entityTel.setXianchangbeizhu(values[51]);
			entityTel.setBeizhuhuizong(values[52]);

			list.add(entityTel);
			i++;
		}

		return list;
	}

	/**
	 * �����û�����
	 *
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public CommonMessage insert(InputStream input) throws Exception {
		List<EntityData> list = new ArrayList<EntityData>();
		String wangluo = null;
		String dianshi = null;
		String dianhua = null;

		try {
			list = parse(input);
			if (null == list || list.size() == 0) {
				return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
			}
		} catch (Exception e) {
			return new CommonMessage(ErrorConstant.UP_DATA_ERROR);
		}

		try {
			openTransaction();
			int i = 1;
			for (EntityData pgd : list) {
				// ����У��
				String error = validator.insertValidate(pgd);
				if (error != null) {
					return new CommonMessage(error, String.valueOf(i));
				}

		/*
		 * when multi business in one row,then split to multi rows and
		 * insert to DB.
		 */
				wangluo = pgd.getWangluo();
				dianshi = pgd.getDianshi();
				dianhua = pgd.getDianhua();
				if (!wangluo.equals("0")) {
					ParameterModel model = setModel(pgd, "1");
					dao.insert("yonghushuju", model);
				}
				if (!dianshi.equals("0")) {
					ParameterModel model = setModel(pgd, "2");
					dao.insert("yonghushuju", model);
				}
				if (!dianhua.equals("0")) {
					ParameterModel model = setModel(pgd, "3");
					dao.insert("yonghushuju", model);
				}
				i++;
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			return new CommonMessage(ErrorConstant.PGD_DATA_ERROR);
		}
		return new CommonMessage(Constant.SUCCESS);
	}

	private ParameterModel setModel(EntityData pgd, String busiType) {
		ParameterModel model = new ParameterModel();
		try {
			model.put("yonghuzhuangtai", pgd.getYonghuzhuangtai());
			model.put("pipeizhuangtai", pgd.getPipeizhuangtai());
			model.put("shoukuanshijian", pgd.getShoukuanshijian());
			model.put("xingming", pgd.getXingming());
			model.put("shenfenzheng", pgd.getShenfensheng());
			model.put("shoujuhao", pgd.getShoujuhao());
			model.put("Fenguangxianhao", pgd.getFenguangxianhao());
			model.put("Jiexuweizhi", pgd.getJiexuweizhi());
			model.put("Kaijishijian", pgd.getKaijishijian());
			model.put("Tingjishijian", pgd.getTingjishijian());
			// 20141028billy������Чʱ��洢����
			model.put("Youxiaoshijian", pgd.getYouxiaoshijian());
			model.put("Xiaoqu", pgd.getXiaoqu());
			model.put("Dizhi", pgd.getDizhi());
			model.put("Lianxidianhua", pgd.getLianxidianhua());
			if (busiType.equals("1")) {
				model.put("Wangluo", pgd.getWangluo());
				model.put("Dianshi", "0");
				model.put("Dianhua", "0");
			} else if (busiType.equals("2")) {
				model.put("Wangluo", "0");
				model.put("Dianshi", pgd.getDianshi());
				model.put("Dianhua", "0");
			} else if (busiType.equals("3")) {
				model.put("Wangluo", "0");
				model.put("Dianshi", "0");
				model.put("Dianhua", pgd.getDianhua());
			}
			model.put("Yewu", pgd.getYewu());
			model.put("Fenguang", pgd.getFenguang());
			model.put("Onumac", pgd.getOnumac());
			model.put("Stbmcid", pgd.getStbmcid());
			model.put("Dianshiip", pgd.getDianshiip());
			model.put("Wangluoip", pgd.getWangluoip());
			model.put("Dianhuaip", pgd.getDianhuaip());
			model.put("Dianhuavlan", pgd.getDianhuavlan());
			model.put("Wangluovlan", pgd.getWangluovlan());
			model.put("Shangmenshijian", pgd.getShangmenshijian());
			model.put("Danzheng", pgd.getDanzheng());
			model.put("Sxdhhm", pgd.getSxdhhm());
			model.put("Onuyj", pgd.getOnuyj());
			model.put("Jidingheyj", pgd.getJidingheyj());
			model.put("Shoushifei", pgd.getShoushifei());
			model.put("Kuandaifei", pgd.getKuandaifei());
			model.put("Chuzhuangfei", pgd.getChuzhuangfei());
			model.put("shebeixiaoshou", pgd.getShebeicaigou());
			model.put("cailiaofei", pgd.getCailiaofei());
			model.put("Yunyingshang", pgd.getYunyingshang());
			model.put("Bzygf", pgd.getBzygf());
			model.put("Nianfei", pgd.getNianfei());
			model.put("Beizhu", pgd.getBeizhu());
			model.put("Zongshoufei", pgd.getZongshoufei());
			model.put("Shoujubenhao", pgd.getShoujubenhao());
			model.put("kaipiaoxinxi", pgd.getKaipiaoxinxi());
			model.put("Qtsbsyqk", pgd.getQtsbsyqk());
			model.put("Qitahaocai", pgd.getQitahaocai());
			model.put("Jiexianzi", pgd.getJiexianzi());
			model.put("Rj11", pgd.getRj11());
			model.put("Rj45", pgd.getRj45());
			model.put("Mokuai", pgd.getMokuai());
			model.put("Mianban", pgd.getMianban());
			model.put("Wangxian", pgd.getWangxian());
			model.put("Shigongren", pgd.getShigongren());
			model.put("Xianchangbeizhu", pgd.getXianchangbeizhu());
			model.put("Beizhuhuizong", pgd.getBeizhuhuizong());
			model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			model.put("createby", getUserInfo().getEmployeeName());
		} catch (ParseException e) {

		}
		return model;
	}

	/**
	 * ���ϴ�ά�޼�¼
	 *
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public CommonMessage insertOnlyWeixiu(InputStream input) throws Exception {
		List<EntityData> list = new ArrayList<EntityData>();
		int errorRow = 0;
		try {
			list = parse(input);
			if (null == list || list.size() == 0) {
				return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
			}
		} catch (Exception e) {
			return new CommonMessage(ErrorConstant.UP_DATA_ERROR);
		}

		try {
			openTransaction();
			int i = 1;
			for (EntityData pgd : list) {
				// ����У��
				errorRow = i;
				String error = validator.insertWeixiuValidate(pgd);
				if (error != null) {
					return new CommonMessage(error, String.valueOf(i));
				}
				ParameterModel model = new ParameterModel();
				model.put("yonghuzhuangtai", pgd.getYonghuzhuangtai());
				model.put("pipeizhuangtai", pgd.getPipeizhuangtai());
				model.put("shoukuanshijian", pgd.getShoukuanshijian());
				model.put("xingming", pgd.getXingming());
				model.put("shenfenzheng", pgd.getShenfensheng());
				model.put("shoujuhao", pgd.getShoujuhao());
				model.put("Fenguangxianhao", pgd.getFenguangxianhao());
				model.put("Jiexuweizhi", pgd.getJiexuweizhi());
				model.put("Kaijishijian", pgd.getKaijishijian());
				model.put("Tingjishijian", pgd.getTingjishijian());
				// 20141027billy�����Чʱ��洢����
				model.put("Youxiaoshijian", pgd.getYouxiaoshijian());
				model.put("Xiaoqu", pgd.getXiaoqu());
				model.put("Dizhi", pgd.getDizhi());
				model.put("Lianxidianhua", pgd.getLianxidianhua());
				model.put("Wangluo", pgd.getWangluo());
				model.put("Dianshi", pgd.getDianshi());
				model.put("Dianhua", pgd.getDianhua());
				model.put("Yewu", pgd.getYewu());
				model.put("Fenguang", pgd.getFenguang());
				model.put("Onumac", pgd.getOnumac());
				model.put("Stbmcid", pgd.getStbmcid());
				model.put("Dianshiip", pgd.getDianshiip());
				model.put("Wangluoip", pgd.getWangluoip());
				model.put("Dianhuaip", pgd.getDianhuaip());
				model.put("Dianhuavlan", pgd.getDianhuavlan());
				model.put("Wangluovlan", pgd.getWangluovlan());
				model.put("Shangmenshijian", pgd.getShangmenshijian());
				model.put("Danzheng", pgd.getDanzheng());
				model.put("Sxdhhm", pgd.getSxdhhm());
				model.put("Onuyj", pgd.getOnuyj());
				model.put("Jidingheyj", pgd.getJidingheyj());
				model.put("Shoushifei", pgd.getShoushifei());
				model.put("Kuandaifei", pgd.getKuandaifei());
				model.put("Chuzhuangfei", pgd.getChuzhuangfei());
				model.put("shebeixiaoshou", pgd.getShebeicaigou());
				model.put("cailiaofei", pgd.getCailiaofei());
				model.put("Yunyingshang", pgd.getYunyingshang());
				model.put("Bzygf", pgd.getBzygf());
				model.put("Nianfei", pgd.getNianfei());
				model.put("Beizhu", pgd.getBeizhu());
				model.put("Zongshoufei", pgd.getZongshoufei());
				model.put("Shoujubenhao", pgd.getShoujubenhao());
				model.put("kaipiaoxinxi", pgd.getKaipiaoxinxi());
				model.put("Qtsbsyqk", pgd.getQtsbsyqk());
				model.put("Qitahaocai", pgd.getQitahaocai());
				model.put("Jiexianzi", pgd.getJiexianzi());
				model.put("Rj11", pgd.getRj11());
				model.put("Rj45", pgd.getRj45());
				model.put("Mokuai", pgd.getMokuai());
				model.put("Mianban", pgd.getMianban());
				model.put("Wangxian", pgd.getWangxian());
				model.put("Shigongren", pgd.getShigongren());
				model.put("Xianchangbeizhu", pgd.getXianchangbeizhu());
				model.put("Beizhuhuizong", pgd.getBeizhuhuizong());
				model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				model.put("createby", getUserInfo().getEmployeeName());

				dao.insert("yonghushuju", model);

				i++;
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			return new CommonMessage(ErrorConstant.WXD_DATA_ERROR, String.valueOf(errorRow));
		}
		return new CommonMessage(Constant.SUCCESS);
	}

	/**
	 * ���ϴ��ɷѼ�¼�������������ϴ��ɷѣ���¼�ϴ�����°�װ��¼��
	 *
	 * @param input
	 *            �Ѱ�װ�û�����
	 * @return
	 * @throws Exception
	 */
	public CommonMessage insertOnlyXufei(InputStream input) throws Exception {
		List<EntityData> list = new ArrayList<EntityData>();
		StringBuffer sb = new StringBuffer();
		String xiaoqu = null;
		String dizhi = null;
		String wangluo = null;
		String dianshi = null;
		String dianhua = null;
		int errorRow = 0;

		try {
			list = parse(input);
			if (null == list || list.size() == 0) {
				return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
			}
		} catch (Exception e) {
			return new CommonMessage(ErrorConstant.UP_DATA_ERROR);
		}

		try {
			openTransaction();
			int i = 1;
			for (EntityData pgd : list) {
		/*
		 * ����У��
		 */
				errorRow = i;
				String error = validator.insertXufeiValidate(pgd);
				if (error != null) {
					rollback();
					return new CommonMessage(error, String.valueOf(i));
				}
				Integer countWangluo = 0;
				Integer countDianshi = 0;
				Integer countDianhua = 0;
				xiaoqu = pgd.getXiaoqu();
				dizhi = pgd.getDizhi();
				wangluo = pgd.getWangluo();
				dianshi = pgd.getDianshi();
				dianhua = pgd.getDianhua();

				String checkJiaoFeiDanNull = checkJiaoFeiDanNull(xiaoqu, dizhi, wangluo, dianshi, dianhua);
				String checkJiaoFeiDanMore = checkJiaoFeiDanMore(xiaoqu, dizhi, wangluo, dianshi, dianhua);

				if (!checkJiaoFeiDanNull.equals("true")) {
					sb.append(checkJiaoFeiDanNull);
					return backCommonMessage(sb);
					// continue;
				}
				if (!checkJiaoFeiDanMore.equals("true")) {
					sb.append(checkJiaoFeiDanMore);
					return backCommonMessage(sb);
					// continue;
				}

		/*
		 * �ж��Ѱ�װ��������
		 */
				if (!wangluo.equals("0")) {
					String s;
					countWangluo = checkWangluoCount(xiaoqu, dizhi);
					if (countWangluo == 0) {
						s = "(";
						s += xiaoqu;
						s += ",";
						s += dizhi;
						s += ")";
						s += "�ް�װ����<br>";
						sb.append(s);
						// backCommonMessage(sb);
						continue;

					}
					if (countWangluo == 1) {
						updateAndinsert(pgd, "wangluo");
					}
					if (countWangluo > 1) {
						s = "(";
						s += xiaoqu;
						s += ",";
						s += dizhi;
						s += ")";
						s += "��װ�����ظ�<br>";
						sb.append(s);
						// backCommonMessage(sb);
						continue;
					}
				}

		/*
		 * �ж��Ѱ�װ��������
		 */
				if (!dianshi.equals("0")) {
					String s;
					countDianshi = checkDianshiCount(xiaoqu, dizhi);
					if (countDianshi == 0) {
						s = "(";
						s += xiaoqu;
						s += ",";
						s += dizhi;
						s += ")";
						s += "�ް�װ����<br>";
						sb.append(s);
						// backCommonMessage(sb);
						continue;
					}
					if (countDianshi == 1) {
						updateAndinsert(pgd, "dianshi");
					}
					if (countDianshi > 1) {
						s = "(";
						s += xiaoqu;
						s += ",";
						s += dizhi;
						s += ")";
						s += "��װ�����ظ�<br>";
						sb.append(s);
						// backCommonMessage(sb);
						continue;
					}
				}

		/*
		 * �ж��Ѱ�װ�绰����
		 */
				if (!dianhua.equals("0")) {
					String s;
					countDianhua = checkDianhuaCount(xiaoqu, dizhi);
					if (countDianhua == 0) {
						s = "(";
						s += xiaoqu;
						s += ",";
						s += dizhi;
						s += ")";
						s += "�ް�װ�绰<br>";
						sb.append(s);
						// backCommonMessage(sb);
						continue;
					}
					if (countDianhua == 1) {
						updateAndinsert(pgd, "dianhua");
					}
					if (countDianhua > 1) {
						s = "(";
						s += xiaoqu;
						s += ",";
						s += dizhi;
						s += ")";
						s += "��װ�绰�ظ�<br>";
						sb.append(s);
						// backCommonMessage(sb);
						continue;
					}
				}
				i++;
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.XFD_DATA_ERROR, String.valueOf(errorRow));
		}
		return backCommonMessage(sb);
	}

	private void updateAndinsert(EntityData pgd, String yewu) throws Exception {
		ParameterModel model = new ParameterModel();
		model.put("yonghuzhuangtai", pgd.getYonghuzhuangtai());
		model.put("pipeizhuangtai", pgd.getPipeizhuangtai());
		model.put("shoukuanshijian", pgd.getShoukuanshijian());
		model.put("xingming", pgd.getXingming());
		model.put("shenfenzheng", pgd.getShenfensheng());
		model.put("shoujuhao", pgd.getShoujuhao());
		model.put("Fenguangxianhao", pgd.getFenguangxianhao());
		model.put("Jiexuweizhi", pgd.getJiexuweizhi());
		model.put("Kaijishijian", pgd.getKaijishijian());
		model.put("Tingjishijian", pgd.getTingjishijian());
		model.put("Xiaoqu", pgd.getXiaoqu());
		model.put("Dizhi", pgd.getDizhi());
		model.put("Lianxidianhua", pgd.getLianxidianhua());
		model.put("Wangluo", pgd.getWangluo());
		model.put("Dianshi", pgd.getDianshi());
		model.put("Dianhua", pgd.getDianhua());
		model.put("Yewu", pgd.getYewu());
		model.put("Fenguang", pgd.getFenguang());
		model.put("Onumac", pgd.getOnumac());
		model.put("Stbmcid", pgd.getStbmcid());
		model.put("Dianshiip", pgd.getDianshiip());
		model.put("Wangluoip", pgd.getWangluoip());
		model.put("Dianhuaip", pgd.getDianhuaip());
		model.put("Dianhuavlan", pgd.getDianhuavlan());
		model.put("Wangluovlan", pgd.getWangluovlan());
		model.put("Shangmenshijian", pgd.getShangmenshijian());
		model.put("Danzheng", pgd.getDanzheng());
		model.put("Sxdhhm", pgd.getSxdhhm());
		model.put("Onuyj", pgd.getOnuyj());
		model.put("Jidingheyj", pgd.getJidingheyj());
		model.put("Shoushifei", pgd.getShoushifei());
		model.put("Kuandaifei", pgd.getKuandaifei());
		model.put("Chuzhuangfei", pgd.getChuzhuangfei());
		model.put("shebeixiaoshou", pgd.getShebeicaigou());
		model.put("cailiaofei", pgd.getCailiaofei());
		model.put("Yunyingshang", pgd.getYunyingshang());
		model.put("Bzygf", pgd.getBzygf());
		model.put("Nianfei", pgd.getNianfei());
		model.put("Beizhu", pgd.getBeizhu());
		model.put("Zongshoufei", pgd.getZongshoufei());
		model.put("Shoujubenhao", pgd.getShoujubenhao());
		model.put("kaipiaoxinxi", pgd.getKaipiaoxinxi());
		model.put("Qtsbsyqk", pgd.getQtsbsyqk());
		model.put("Qitahaocai", pgd.getQitahaocai());
		model.put("Jiexianzi", pgd.getJiexianzi());
		model.put("Rj11", pgd.getRj11());
		model.put("Rj45", pgd.getRj45());
		model.put("Mokuai", pgd.getMokuai());
		model.put("Mianban", pgd.getMianban());
		model.put("Wangxian", pgd.getWangxian());
		model.put("Shigongren", pgd.getShigongren());
		model.put("Xianchangbeizhu", pgd.getXianchangbeizhu());
		model.put("Beizhuhuizong", pgd.getBeizhuhuizong());
		model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		model.put("createby", getUserInfo().getEmployeeName());

		dao.insert("yonghushuju", model);

		ParameterSet set = new ParameterSet();
		set.add("yonghuzhuangtai", "@yonghuzhuangtai", "�Ѱ�װ");
		set.add("tingjishijian", "@tingjishijian", pgd.getTingjishijian());
		set.add("xiaoqu", "@xiaoqu", pgd.getXiaoqu());
		set.add("dizhi", "@dizhi", pgd.getDizhi());
		set.add("wangluo", "@wangluo", pgd.getWangluo());
		set.add("dianshi", "@dianshi", pgd.getDianshi());
		set.add("dianhua", "@dianhua", pgd.getDianhua());

		if (yewu.equals("wangluo")) {
			dao.execute("updateAnZhuangWangluoDataByUser", set);
		} else if (yewu.equals("dianshi")) {
			dao.execute("updateAnZhuangDianshiDataByUser", set);
		}

	}

	ParameterSet set1 = new ParameterSet();

	private int checkDianhuaCount(String xiaoqu, String dizhi) throws Exception {
		set1.add("xiaoqu", "@xiaoqu", xiaoqu);
		set1.add("dizhi", "@dizhi", dizhi);
		set1.add("wangluo", "@wangluo", "0");
		set1.add("dianhua", "@dianshi", "0");
		return dao.executeQueryToCount("GetUserDataByAnZhuangCount", set1);

	}

	private int checkDianshiCount(String xiaoqu, String dizhi) throws Exception {
		ParameterSet set1 = new ParameterSet();
		set1.add("xiaoqu", "@xiaoqu", xiaoqu);
		set1.add("dizhi", "@dizhi", dizhi);
		set1.add("dianshi", "@dianshi", "0");
		// set1.add("dianhua", "@dianhua", "0");
		return dao.executeQueryToCount("GetUserDataByAnZhuangCount", set1);

	}

	private int checkWangluoCount(String xiaoqu, String dizhi) throws Exception {
		ParameterSet set1 = new ParameterSet();
		set1.add("xiaoqu", "@xiaoqu", xiaoqu);
		set1.add("dizhi", "@dizhi", dizhi);
		set1.add("wangluo", "@wangluo", "0");
		// set1.add("dianhua", "@dianhua", "0");
		return dao.executeQueryToCount("GetUserDataByAnZhuangCount", set1);
	}




	/**
	 * check jiaofeidan is has more service.
	 *
	 * @param xiaoqu
	 * @param dizhi
	 * @param wangluo
	 * @param dianhua
	 * @param dianshi
	 * @return
	 * @throws Exception
	 */
	private String checkJiaoFeiDanMore(String xiaoqu, String dizhi, String wangluo, String dianhua, String dianshi) throws Exception {
		String s;
	/*
	 * �ɷѵ�һ�����ݰ�������ҵ��
	 */
		if ((!wangluo.equals("0") && !dianshi.equals("0")) || (!wangluo.equals("0") && !dianhua.equals("0")) || (!dianshi.equals("0") && !dianhua.equals("0")) || (!dianshi.equals("0") && !dianhua.equals("0") && !wangluo.equals("0"))) {

			s = "(";
			s += xiaoqu;
			s += ",";
			s += dizhi;
			s += ")";
			s += "���ж���ҵ��";
			rollback();
			// �ɷѵ��û�{0}���ж���ҵ��
			// return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR02 ,
			// sb.toString());
			return s.toString();
		}
		return "true";
	}

	/**
	 * check jiaofeidan is has null service.
	 *
	 * @param xiaoqu
	 * @param dizhi
	 * @param wangluo
	 * @param dianhua
	 * @param dianshi
	 * @return
	 * @throws Exception
	 */
	private String checkJiaoFeiDanNull(String xiaoqu, String dizhi, String wangluo, String dianhua, String dianshi) throws Exception {
		String s;
	/*
	 * �ɷѵ�һ��������ҵ��
	 */
		if (dianshi.equals("0") && dianhua.equals("0") && wangluo.equals("0")) {

			s = "(";
			s += xiaoqu;
			s += ",";
			s += dizhi;
			s += ")";
			s += "ҵ��Ϊ��";
			rollback();
			// �ɷѵ��û�{0}ҵ��Ϊ�գ�
			// return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR01 ,
			// sb.toString());
			return s;
		}
		return "true";
	}

	private CommonMessage backCommonMessage(StringBuffer error) throws Exception {
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, error.toString());
	}

	@SuppressWarnings("unused")
	private String isNull(String obj) {
		String returnVal = "";
		if (obj == null || obj.trim() == "" || obj.trim().equals("")) {
			returnVal = "";
		} else {
			returnVal = obj;
		}
		return returnVal;
	}

	private String getDefValue(String value) {
		String returnVal = "0";
		if (value == null || value.trim() == "" || value.trim().equals("")) {
			returnVal = "0";
		} else {
			returnVal = value;
		}
		return returnVal;
	}

	/**
	 * �ȶ��Ѱ�װ��¼������������д��list�У���¼��ɺ� д��excel �ṩ���ء�
	 *
	 * @param input
	 * @param remoteAddr
	 *            �Ѱ�װ�û�����
	 * @return
	 * @throws Exception
	 */
	public CommonMessage comparisonYianzhuang(InputStream input, String remoteAddr) throws Exception {
		List<EntityData> list = new ArrayList<EntityData>();
		List<EntityData> listdata = new ArrayList<EntityData>();
		try {
			list = parse(input);
			if (null == list || list.size() == 0) {
				return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
			}
		} catch (Exception e) {
			return new CommonMessage(ErrorConstant.UP_DATA_ERROR);
		}

		try {
			// openTransaction();
			int i = 1;
			// int i = list.size();
			for (EntityData pgd : list) {
				String error = validator.insertAnzhuangValidate(pgd);
				if (error != null) {
					return new CommonMessage(error, String.valueOf(i));
				}

				ParameterSet set = new ParameterSet();
				set.add("yonghuzhuangtai", "@yonghuzhuangtai", "�Ѱ�װ");
				set.add("xiaoqu", "@xiaoqu", pgd.getXiaoqu());
				set.add("dizhi", "@dizhi", pgd.getDizhi());
				DataSet<DataRow> executeQuery = dao.executeQuery("comparisonYianzhuangData", set);
				if (executeQuery.size() > 0) {
					for (DataRow row : executeQuery) {
						EntityData entityData = new EntityData();
						entityData.setUUID(row.getDataElement("PK_ID").getString());
						entityData.setYonghuzhuangtai(row.getDataElement("yonghuzhuangtai").getString());
						entityData.setPipeizhuangtai(row.getDataElement("pipeizhuangtai") == null ? "" : row.getDataElement("pipeizhuangtai").getString());
						entityData.setShoukuanshijian(row.getDataElement("shoukuanshijian") == null ? "" : row.getDataElement("shoukuanshijian").getString());
						entityData.setXingming(row.getDataElement("xingming").getString() == null ? "" : row.getDataElement("xingming").getString());
						entityData.setShenfensheng(row.getDataElement("shenfensheng").getString() == null ? "" : row.getDataElement("shenfensheng").getString());
						entityData.setShoujuhao(row.getDataElement("shoujuhao").getString() == null ? "" : row.getDataElement("shoujuhao").getString());
						entityData.setFenguangxianhao(row.getDataElement("fenguangxianhao").getString() == null ? "" : row.getDataElement("fenguangxianhao").getString());
						entityData.setJiexuweizhi(row.getDataElement("jiexuweizhi").getString() == null ? "" : row.getDataElement("jiexuweizhi").getString());
						entityData.setKaijishijian(row.getDataElement("kaijishijian").getString());
						entityData.setTingjishijian(row.getDataElement("tingjishijian").getString());
						// 20141028billy������Чʱ��洢����
						entityData.setYouxiaoshijian(row.getDataElement("youxiaoshijian").getString());
						entityData.setXiaoqu(row.getDataElement("xiaoqu").getString());
						entityData.setDizhi(row.getDataElement("dizhi").getString());
						entityData.setLianxidianhua(row.getDataElement("lianxidianhua").getString() == null ? "" : row.getDataElement("lianxidianhua").getString());
						entityData.setWangluo(row.getDataElement("wangluo").getString());
						entityData.setDianshi(row.getDataElement("dianshi").getString());
						entityData.setDianhua(row.getDataElement("dianhua").getString());
						entityData.setYewu(row.getDataElement("yewu").getString() == null ? "" : row.getDataElement("yewu").getString());
						entityData.setFenguang(row.getDataElement("fenguang").getString() == null ? "" : row.getDataElement("fenguang").getString());
						entityData.setOnumac(row.getDataElement("onumac").getString() == null ? "" : row.getDataElement("onumac").getString());
						entityData.setStbmcid(row.getDataElement("stbmcid").getString() == null ? "" : row.getDataElement("stbmcid").getString());
						entityData.setDianshiip(row.getDataElement("dianshiip").getString() == null ? "" : row.getDataElement("dianshiip").getString());
						entityData.setWangluoip(row.getDataElement("wangluoip").getString() == null ? "" : row.getDataElement("wangluoip").getString());
						entityData.setDianhuaip(row.getDataElement("dianhuaip").getString() == null ? "" : row.getDataElement("dianhuaip").getString());
						entityData.setDianhuavlan(row.getDataElement("dianhuavlan").getString() == null ? "" : row.getDataElement("dianhuavlan").getString());
						entityData.setWangluovlan(row.getDataElement("wangluovlan").getString() == null ? "" : row.getDataElement("wangluovlan").getString());
						entityData.setShangmenshijian(row.getDataElement("shangmenshijian").getString() == null ? "" : row.getDataElement("shangmenshijian").getString());
						entityData.setDanzheng(row.getDataElement("danzheng").getString() == null ? "" : row.getDataElement("danzheng").getString());
						entityData.setSxdhhm(row.getDataElement("sxdhhm").getString() == null ? "" : row.getDataElement("sxdhhm").getString());
						entityData.setOnuyj(row.getDataElement("onuyj").getString() == null ? "" : row.getDataElement("onuyj").getString());
						entityData.setJidingheyj(row.getDataElement("jidingheyj").getString() == null ? "" : row.getDataElement("jidingheyj").getString());
						entityData.setShoushifei(row.getDataElement("shoushifei").getString() == null ? "" : row.getDataElement("shoushifei").getString());
						entityData.setKuandaifei(row.getDataElement("kuandaifei").getString() == null ? "" : row.getDataElement("kuandaifei").getString());
						entityData.setChuzhuangfei(row.getDataElement("chuzhuangfei").getString() == null ? "" : row.getDataElement("chuzhuangfei").getString());
						entityData.setShebeicaigou(row.getDataElement("shebeixiaoshou").getString() == null ? "" : row.getDataElement("shebeixiaoshou").getString());
						entityData.setCailiaofei(row.getDataElement("cailiaofei").getString() == null ? "" : row.getDataElement("cailiaofei").getString());
						entityData.setYunyingshang(row.getDataElement("yunyingshang").getString() == null ? "" : row.getDataElement("yunyingshang").getString());
						entityData.setBzygf(row.getDataElement("bzygf").getString() == null ? "" : row.getDataElement("bzygf").getString());
						entityData.setNianfei(row.getDataElement("nianfei").getString() == null ? "" : row.getDataElement("nianfei").getString());
						entityData.setBeizhu(row.getDataElement("beizhu").getString() == null ? "" : row.getDataElement("beizhu").getString());
						entityData.setZongshoufei(row.getDataElement("zongshoufei").getString() == null ? "" : row.getDataElement("zongshoufei").getString());
						entityData.setShoujubenhao(row.getDataElement("shoujubenhao").getString() == null ? "" : row.getDataElement("shoujubenhao").getString());
						entityData.setKaipiaoxinxi(row.getDataElement("kaipiaoxinxi").getString() == null ? "" : row.getDataElement("kaipiaoxinxi").getString());
						entityData.setQtsbsyqk(row.getDataElement("qtsbsyqk").getString() == null ? "" : row.getDataElement("qtsbsyqk").getString());
						entityData.setQitahaocai(row.getDataElement("qitahaocai").getString() == null ? "" : row.getDataElement("qitahaocai").getString());
						entityData.setJiexianzi(row.getDataElement("jiexianzi").getString() == null ? "" : row.getDataElement("jiexianzi").getString());
						entityData.setRj11(row.getDataElement("rj11").getString() == null ? "" : row.getDataElement("rj11").getString());
						entityData.setRj45(row.getDataElement("rj45").getString() == null ? "" : row.getDataElement("rj45").getString());
						entityData.setMokuai(row.getDataElement("mokuai").getString() == null ? "" : row.getDataElement("mokuai").getString());
						entityData.setMianban(row.getDataElement("mianban").getString() == null ? "" : row.getDataElement("mianban").getString());
						entityData.setWangxian(row.getDataElement("wangxian").getString() == null ? "" : row.getDataElement("wangxian").getString());
						entityData.setShigongren(row.getDataElement("shigongren").getString() == null ? "" : row.getDataElement("shigongren").getString());
						entityData.setXianchangbeizhu(row.getDataElement("xianchangbeizhu").getString() == null ? "" : row.getDataElement("xianchangbeizhu").getString());
						entityData.setBeizhuhuizong(row.getDataElement("beizhuhuizong").getString() == null ? "" : row.getDataElement("beizhuhuizong").getString());

						listdata.add(entityData);
					}
				}
				i++;
			}
			if (listdata.size() == 0) {
				return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG, "�ް�װ���ݿ��Աȶԣ�");
			} else {
				toExcel(listdata);
				return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG, "<a href='http://" + remoteAddr + ":8080/tfkj_stock/excel/a.xls'>���رȶ��Ѱ�װExcel</a>");
			}
		} catch (Exception e) {
			// rollback();
			log.error(e);
			e.printStackTrace();

			return new CommonMessage(ErrorConstant.AZD_DATA_ERROR);
		}

		// return new CommonMessage(Constant.SUCCESS);
	}

	private void toExcel(List<EntityData> listdata) throws IOException {

		ExportExcel<EntityData> ex = new ExportExcel<EntityData>();
		String[] headers = { "UUID", "�û�״̬", "ƥ��״̬", "�տ�ʱ��", "����", "���֤��", "�վݺ�", "�ֹ��ߺ�", "����λ��", "����", "ͣ��", "��Чʱ��", "С��", "��ַ", "��ϵ�绰", "����", "����", "�绰", "ҵ��", "�ֹ�", "Onu mac", "STB MCID", "����ip", "����ip", "�绰IP", "�绰VLAN", "����vlan", "����ʱ��", "��֤", "��ѡ�绰����", "ONUѺ��", "������Ѻ��", "���ӷ�", "�����", "��װ��", "�豸���۷�", "���Ϸ�", "��Ӫ��", "�����¹���", "���", "��ע", "���շ�", "�վݱ���/�վݺ�", "��Ʊ��Ϣ", "�����豸ʹ�����", "�����Ĳ�", "������", "RJ11", "RJ45", "ģ��", "���", "����", "ʩ����", "�ֳ���ע", "��ע����" };

		String path = this.getClass().getClassLoader().getResource("/").getPath();
		int index = path.indexOf("WEB-INF");
		path = path.substring(0, index);
		path = path + "excel/a.xls";
		if (path.indexOf("%") >= 0) {
			try {
				path = URLDecoder.decode(path, "utf-8");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		OutputStream out = new FileOutputStream(path);
		ex.exportExcel(headers, listdata, out);
		out.close();
	}

	public String insertDaijiaofei(JiaofeiDataFrom form) throws Exception {
		// DataRow dataRow = getDaijiaofei(form);
	/*
	 * if(dataRow!=null){ return ErrorConstant.YUYUEEXIST; }
	 */
		try {
			openTransaction();

			ParameterModel model = new ParameterModel();
			model.put("xiaoqu", form.getXiaoqu());
			model.put("dizhi", form.getDizhi());
			model.put("yonghuzhuangtai", "���ɷ�");
			if (form.getWangluo().equals("")) {
				form.setWangluo("0");
			}
			model.put("wangluo", form.getWangluo());
			if (form.getDianshi().equals("")) {
				form.setDianshi("0");
			}

			// model.put("dianshiip", form.getDianshiip());
			model.put("wangluoip", form.getWangluoip());
			model.put("dianhuaip", form.getDianhuaip());

			model.put("dianshi", form.getDianshi());
			model.put("dianhua", form.getDianhua());
			model.put("kaijishijian", form.getKaijishijian());
			model.put("tingjishijian", form.getTingjishijian());
			// 20141027billy������Чʱ��Ĵ洢����
			model.put("youxiaoshijian", form.getTingjishijian());
			model.put("kuandaifei", Integer.parseInt(form.getKuandaifei()));
			model.put("shoushifei", Integer.parseInt(form.getShoushifei()));
			model.put("nianfei", Integer.parseInt(form.getNianfei()));
			model.put("onuyj", Integer.parseInt(form.getOnuyj()));
			model.put("jidingheyj", Integer.parseInt(form.getJidingheyj()));
			model.put("zongshoufei", form.getZongshoufei());
			String shichang = form.getShichang();
			String shichangtv = form.getShichangtv();
			String dianhua = form.getDianhua();
			if(!"1".equals(form.getBeishuselect())) {
				form.setYewu(form.getYewu()+"/���ʷѵ���"+form.getBeishuselect()+"����");
			}
			if("1".equals(form.getBeishutype())) {
				form.setYewu(form.getYewu()+"/�������������ʷѡ�");
			}else if("2".equals(form.getBeishutype())) {
				form.setYewu(form.getYewu()+"/�����ۡ�");
			}else if("3".equals(form.getBeishutype())) {
				form.setYewu(form.getYewu()+"/��������ѡ�");
			}
			if (shichang == null && shichangtv == null && dianhua == null) {
				model.put("yewu", form.getYewu());
			} else if (shichang != null) {
				model.put("yewu", form.getYewu() + "/" + shichang);
			} else if (dianhua != null) {
				model.put("yewu", form.getYewu());
			} else {
				model.put("yewu", form.getYewu() + "/" + shichangtv);
			}

			model.put("shoujubenhao", form.getShoujuhao());
			model.put("shigongren", form.getShigongren());
			model.put("createdt", form.getNowdata());
			model.put("kaipiaoxinxi", form.getKaipiaoxinxi());
			model.put("shoukuanshijian", form.getShoukuanshijian());
			model.put("beiyong1", form.getShichangRadius());
			model.put("yunyingshang", form.getYunyingshang());
			model.put("beizhuhuizong", form.getBeizhuhuizong() + " ������:" + getUserInfo().getEmployeeName() + " ����ʱ�䣺" + form.getNowdata());
			dao.insert("yonghushuju", model);

			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	/**
	 * ����Ų����ļ�¼
	 *
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String insertOperate(JiaofeiDataFrom form, String caozuo) throws Exception {
		try {
			openTransaction();

			ParameterModel model = new ParameterModel();
			model.put("xiaoqu", form.getXiaoqu());
			model.put("dizhi", form.getDizhi());
			model.put("yonghuzhuangtai", caozuo);
			if (form.getWangluo().equals("")) {
				form.setWangluo("0");
			}
			model.put("wangluo", form.getWangluo());
			if (form.getDianshi().equals("")) {
				form.setDianshi("0");
			}
			model.put("dianhuaip", form.getDianhuaip());
			model.put("wangluoip", form.getWangluoip());

			model.put("dianshi", form.getDianshi());
			model.put("dianhua", form.getDianhua());

			String nowDateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			form.setKaijishijian(nowDateString);
			form.setTingjishijian(nowDateString);

			model.put("kaijishijian", form.getKaijishijian());
			model.put("tingjishijian", form.getTingjishijian());
			model.put("youxiaoshijian", form.getTingjishijian());
			model.put("zongshoufei", form.getZongshoufei());
			String shichang = form.getShichang();
			String shichangtv = form.getShichangtv();
			String dianhua = form.getDianhua();
			if (shichang == null && shichangtv == null && dianhua == null) {
				model.put("yewu", form.getYewu());
			} else if (shichang != null) {
				model.put("yewu", form.getYewu() + "/" + shichang);
			} else if (dianhua != null) {
				model.put("yewu", form.getYewu());
			} else {
				model.put("yewu", form.getYewu() + "/" + shichangtv);
			}

			model.put("shoujubenhao", form.getShoujuhao());
			model.put("shigongren", form.getShigongren());
			model.put("createdt", nowDateString);
			model.put("kaipiaoxinxi", form.getKaipiaoxinxi());
			model.put("beiyong1", form.getShichangRadius());
			model.put("yunyingshang", form.getYunyingshang());
			model.put("userId", form.getBeizhuhuizong());
			if ("���޸�".equals(caozuo)) {
				model.put("beizhuhuizong", " ������:" + form.getBeizhuhuizong() + " ��ע��" + form.getKaipiaoxinxi() + " ������:" + getUserInfo().getEmployeeName() + " ����ʱ�䣺" + form.getNowdata());
			} else {
				model.put("beizhuhuizong", "��ע��" + form.getKaipiaoxinxi() + " ������:" + getUserInfo().getEmployeeName() + " ����ʱ�䣺" + form.getNowdata());
			}
			dao.insert("yonghushuju", model);

			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	public String insertDaiweixiu(JiaofeiDataFrom form) throws Exception {
		try {
			openTransaction();
			ParameterModel model = new ParameterModel();
			model.put("xiaoqu", form.getXiaoqu());
			model.put("dizhi", form.getDizhi());
			model.put("yonghuzhuangtai", "ά�޴�����");
			model.put("kaijishijian", form.getWeixiushijian());
			model.put("tingjishijian", form.getWeixiushijian());
			// 20141028billy������Чʱ��洢����
			model.put("youxiaoshijian", form.getWeixiushijian());
			model.put("shoukuanshijian", form.getWeixiushijian());
			model.put("kuandaifei", form.getKuandaifei());
			model.put("shoushifei", form.getShoushifei());
			model.put("chuzhuangfei", form.getChuzhuangfei());
			model.put("shebeixiaoshou", form.getShebeixiaoshou());
			model.put("cailiaofei", form.getCailiaofei());
			model.put("nianfei", form.getNianfei());
			model.put("onuyj", form.getOnuyj());
			model.put("jidingheyj", form.getJidingheyj());
			model.put("zongshoufei", form.getZongshoufei());

			model.put("jiexianzi", form.getJiexianzi());
			model.put("rj11", form.getRj11());
			model.put("rj45", form.getRj45());
			model.put("mokuai", form.getMokuai());
			model.put("mianban", form.getMianban());
			model.put("wangxian", form.getWangxian());
			model.put("qitahaocai", form.getQitahaocai());

			model.put("shoujubenhao", form.getShoujubenhao());
			model.put("kaipiaoxinxi", form.getKaipiaoxinxi());
			model.put("shigongren", form.getShigongren());
			model.put("createdt", form.getNowdata());
			model.put("yewu", form.getWeixiuneirong());
			model.put("weixiuleixing", form.getWeixiuleixing());// 20140922billy����
			model.put("yunyingshang", form.getYunyingshang());// 20140923billy����

			model.put("fenguang", form.getFenguang());
			model.put("onumac", form.getOnumac());
			model.put("stbmcid", form.getStbmcid());
			model.put("dianshiip", form.getDianshiip());
			if(!"".equals(form.getSelectCommunityPileID())) {
				model.put("CommunityPile_ID", form.getSelectCommunityPileID());
			}else{
				model.put("CommunityPile_ID", 0);
			}
			if(!"".equals(form.getSelectCommunityPileID2())) {
				model.put("CommunityPile_ID2", form.getSelectCommunityPileID2());
			}else{
				model.put("CommunityPile_ID2", 0);
			}
			if (form.getSelectCommunityPileID() == null
					|| "".equals(form.getSelectCommunityPileID())) {
				if (form.getSelectCommunityPileID2() == null
						|| "".equals(form.getSelectCommunityPileID2())) {
					model.put("beizhuhuizong", form.getBeizhuhuizong()
							+ " ������:" + getUserInfo().getEmployeeName()
							+ " ����ʱ�䣺" + form.getNowdata());
				} else {
					model.put("beizhuhuizong", form.getBeizhuhuizong()
							+ " ������:" + getUserInfo().getEmployeeName()
							+ " ����ʱ�䣺" + form.getNowdata() + "/��ţ�"
							+ form.getEqboxnum2());
				}
			} else {
				if (form.getSelectCommunityPileID2() == null
						|| "".equals(form.getSelectCommunityPileID2())) {
					model.put("beizhuhuizong", form.getBeizhuhuizong()
							+ " ������:" + getUserInfo().getEmployeeName()
							+ " ����ʱ�䣺" + form.getNowdata() + "/��ţ�"
							+ form.getEqboxnum());
				} else {
					model.put("beizhuhuizong", form.getBeizhuhuizong()
							+ " ������:" + getUserInfo().getEmployeeName()
							+ " ����ʱ�䣺" + form.getNowdata() + "/��ţ�"
							+ form.getEqboxnum() + "/" + form.getEqboxnum2());
				}

			}
			dao.insert("yonghushuju", model);

			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	public String updateDaiweixiu(JiaofeiDataFrom form) throws Exception {
		try {
			openTransaction();
			ParameterModel model2 = new ParameterModel();
			model2.put("xx_xiaoqu", form.getXiaoqu());
			model2.put("xx_dizhi", form.getDizhi());
			model2.put("yh_zhuangtai", "ά�޴�����");
			model2.put("yh_kaijiDate", form.getWeixiushijian());
			model2.put("yh_tingjiDate", form.getWeixiushijian());
			model2.put("shoukuanshijian", form.getWeixiushijian());
			model2.put("fy_kuandai", form.getKuandaifei());
			model2.put("fy_shoushi", form.getShoushifei());
			model2.put("fy_chuzhuang", form.getChuzhuangfei());
			model2.put("fy_shebeixiaoshou", form.getShebeixiaoshou());
			model2.put("fy_cailiao", form.getCailiaofei());
			model2.put("fy_nianfei", form.getNianfei());
			model2.put("fy_onu", form.getOnuyj());
			model2.put("fy_jidinghe", form.getJidingheyj());
			model2.put("qt_zongshoufei", form.getZongshoufei());

			model2.put("qt_jiexianzi", form.getJiexianzi());
			model2.put("qt_rj11", form.getRj11());
			model2.put("qt_rj45", form.getRj45());
			model2.put("qt_mokuai", form.getMokuai());
			model2.put("qt_mianban", form.getMianban());
			model2.put("qt_wangxian", form.getWangxian());
			model2.put("qt_haocai", form.getQitahaocai());

			model2.put("qt_shoujuNum", form.getShoujubenhao());
			model2.put("qt_kaipiaoxinxi", form.getKaipiaoxinxi());
			model2.put("qt_shigongren", form.getShigongren());
			model2.put("xiugai_date", form.getNowdata());
			model2.put("pipeizhuangtai", "δƥ��");

			model2.put("xx_yewu", form.getWeixiuneirong());
			model2.put("beizhuhuizong", form.getBeizhuhuizong() + " �༭��:" + getUserInfo().getEmployeeName() + " �༭ʱ�䣺" + form.getNowdata());
			model2.put("xiugai_ren", getUserInfo().getEmployeeName());
			dao.insert("yonghudatalog", model2);

			ParameterModel model = new ParameterModel();
			model.put("xiaoqu", form.getXiaoqu());
			model.put("dizhi", form.getDizhi());
			model.put("yonghuzhuangtai", "ά�޴�����");
			model.put("kaijishijian", form.getWeixiushijian());
			model.put("tingjishijian", form.getWeixiushijian());
			model.put("shoukuanshijian", form.getWeixiushijian());
			model.put("kuandaifei", form.getKuandaifei());
			model.put("shoushifei", form.getShoushifei());
			model.put("chuzhuangfei", form.getChuzhuangfei());
			model.put("shebeixiaoshou", form.getShebeixiaoshou());
			model.put("cailiaofei", form.getCailiaofei());
			model.put("nianfei", form.getNianfei());
			model.put("onuyj", form.getOnuyj());
			model.put("jidingheyj", form.getJidingheyj());
			model.put("zongshoufei", form.getZongshoufei());

			model.put("jiexianzi", form.getJiexianzi());
			model.put("rj11", form.getRj11());
			model.put("rj45", form.getRj45());
			model.put("mokuai", form.getMokuai());
			model.put("mianban", form.getMianban());
			model.put("wangxian", form.getWangxian());
			model.put("qitahaocai", form.getQitahaocai());

			model.put("shoujubenhao", form.getShoujubenhao());
			model.put("kaipiaoxinxi", form.getKaipiaoxinxi());
			model.put("shigongren", form.getShigongren());
			model.put("createdt", form.getNowdata());
			model.put("yewu", form.getWeixiuneirong());
			model.put("weixiuleixing", form.getWeixiuleixing());// 20140922billy����
			model.put("yunyingshang", form.getYunyingshang());// 20140923billy����

			model.put("fenguang", form.getFenguang());
			model.put("onumac", form.getOnumac());
			model.put("stbmcid", form.getStbmcid());
			model.put("dianshiip", form.getDianshiip());

			model.put("CommunityPile_ID", form.getSelectCommunityPileID());
			model.put("CommunityPile_ID2", form.getSelectCommunityPileID2());

			if (form.getSelectCommunityPileID() == null
					|| "".equals(form.getSelectCommunityPileID())) {
				if (form.getSelectCommunityPileID2() == null
						|| "".equals(form.getSelectCommunityPileID2())) {
					model.put("beizhuhuizong", form.getBeizhuhuizong()
							+ " �༭��:" + getUserInfo().getEmployeeName()
							+ " �༭ʱ�䣺" + form.getNowdata());
				} else {
					model.put("beizhuhuizong", form.getBeizhuhuizong()
							+ " �༭��:" + getUserInfo().getEmployeeName()
							+ " �༭ʱ�䣺" + form.getNowdata() + "/��ţ�"
							+ form.getEqboxnum2());
				}
			} else {
				if (form.getSelectCommunityPileID2() == null
						|| "".equals(form.getSelectCommunityPileID2())) {
					model.put("beizhuhuizong", form.getBeizhuhuizong()
							+ " �༭��:" + getUserInfo().getEmployeeName()
							+ " �༭ʱ�䣺" + form.getNowdata() + "/��ţ�"
							+ form.getEqboxnum());
				} else {
					model.put("beizhuhuizong", form.getBeizhuhuizong()
							+ " �༭��:" + getUserInfo().getEmployeeName()
							+ " �༭ʱ�䣺" + form.getNowdata() + "/��ţ�"
							+ form.getEqboxnum() + "/" + form.getEqboxnum2());
				}

			}
			ParameterModel conds = new ParameterModel();
			conds.put("uuid", form.getUUID());
			dao.update("yonghushuju", model, conds);

			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	public String updateDaijiaofei(JiaofeiDataFrom form) throws Exception {
		try {
			openTransaction();
			ParameterModel model2 = new ParameterModel();
			model2.put("xx_xiaoqu", form.getXiaoqu());
			model2.put("xx_dizhi", form.getDizhi());
			model2.put("xx_wangluo", form.getWangluo());
			model2.put("yh_zhuangtai", "���ɷ�");
			model2.put("xx_dianshi", form.getDianshi());
			model2.put("xx_dianhua", form.getDianhua());
			model2.put("shoukuanshijian", form.getShoukuanshijian());
			model2.put("yh_kaijiDate", form.getKaijishijian());
			model2.put("yh_tingjiDate", form.getTingjishijian());
			// 20141027billy������Чʱ��洢����
			model2.put("yh_youxiaoDate", form.getTingjishijian());
			model2.put("fy_kuandai", form.getKuandaifei());
			model2.put("fy_shoushi", form.getShoushifei());
			model2.put("fy_nianfei", form.getNianfei());
			model2.put("fy_onu", form.getOnuyj());
			model2.put("fy_jidinghe", form.getJidingheyj());
			model2.put("qt_zongshoufei", form.getZongshoufei());
			model2.put("xx_yewu", form.getYewu());
			model2.put("qt_shoujuNum", form.getShoujuhao());
			model2.put("qt_kaipiaoxinxi", form.getKaipiaoxinxi());
			model2.put("qt_shigongren", form.getShigongren());
			model2.put("xiugai_date", form.getNowdata());
			model2.put("beizhuhuizong", form.getBeizhuhuizong() + " �༭��:" + getUserInfo().getEmployeeName() + " �༭ʱ�䣺" + form.getNowdata());
			model2.put("xiugai_ren", getUserInfo().getEmployeeName());
			dao.insert("yonghudatalog", model2);

			String wangluo = form.getWangluo();
			String dianshi = form.getDianshi();
			String dianhua = form.getDianhua();
			ParameterModel model = new ParameterModel();
			model.put("xiaoqu", form.getXiaoqu());
			model.put("kaijishijian", form.getKaijishijian());
			model.put("tingjishijian", form.getTingjishijian());
			// 20141027billy������Чʱ��洢����
			model.put("youxiaoshijian", form.getTingjishijian());
			model.put("dizhi", form.getDizhi());
			model.put("yunyingshang", form.getYunyingshang());// 20140923billy����
			if (wangluo == null) {
				model.put("wangluo", "0");
			} else {
				model.put("wangluo", form.getWangluo());
			}
			if (dianshi == null) {
				model.put("dianshi", "0");
			} else {
				model.put("dianshi", form.getDianshi());
			}
			if (dianhua == null) {
				model.put("dianhua", "0");
			} else {
				model.put("dianhua", form.getDianhua());
			}
			model.put("onuyj", form.getOnuyj());
			model.put("jidingheyj", form.getJidingheyj());
			model.put("kuandaifei", form.getKuandaifei());
			model.put("shoushifei", form.getShoushifei());
			model.put("nianfei", form.getNianfei());
			model.put("zongshoufei", form.getZongshoufei());
			model.put("yewu", form.getYewu());
			model.put("shoujubenhao", form.getShoujubenhao());
			model.put("kaipiaoxinxi", form.getKaipiaoxinxi());
			model.put("shigongren", form.getShigongren());
			model.put("shoukuanshijian", form.getShoukuanshijian());
			model.put("beizhuhuizong", form.getBeizhuhuizong() + " �༭��:" + getUserInfo().getEmployeeName() + " �༭ʱ�䣺" + form.getNowdata());
			model.put("updatedt", form.getNowdata());
			ParameterModel conds = new ParameterModel();
			conds.put("uuid", form.getUUID());
			dao.update("yonghushuju", model, conds);

			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}

	public DataRow getDaijiaofei(JiaofeiDataFrom form) throws Exception {
		ParameterSet set = new ParameterSet();
		// set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("getYuyue", set);
	}

	/**
	 * ���޸������¼��ȷ�ϲ���
	 *
	 * @return
	 * @throws Exception
	 */
	public CommonMessage daiXiugai(String tfids) throws Exception {
		openTransaction();
		String wsFlag = "";
		int count1 = 0;
		int count2 = 0;
		String[] uuidArray = tfids.split(",");
		for (int i = 0; i < uuidArray.length; i++) {
			ParameterSet set = new ParameterSet();
			set.add("uuid", "@UUID", uuidArray[i]);
			DataSet<DataRow> query = dao.executeQuery("GetOperateList", set);
			ParameterModel model = new ParameterModel();
			String yonghuzhuangtai = query.get(0).getDataElement("yonghuzhuangtai").getString();
			String wangluo = query.get(0).getDataElement("wangluo").getString();

			/****************************************************************************************/

			String yunyingshang = query.get(0).getDataElement("yunyingshang").getString();

			ParameterSet set1 = new ParameterSet();
			set1.add("uuid", "@uuid", uuidArray[i]);
			DataSet<DataRow> query1 = dao.executeQuery("GetByUUID", set1);

			// ���Žӿ�  ��������ҵ���û� �����޸ĺ��˶��� change by ���˻�
			if (!"".equals(wangluo) && !"0".equals(wangluo) && query1.size() == 1) {

				//ͬ����radius
				RediusWebService.changePwd(query1.get(0), "��");

				if("����".equals(yunyingshang)) {
					wsFlag = "0";
					//�����û�״̬�ж��Ǵ��޸ĵ�Ϊ�޸��������
					if (yonghuzhuangtai.equals("���޸�")) {
						//���õ��Ŷ������޸ĵĽӿڣ����ͱ���
						if (!"0".equals(WebServiceMethods.ChangePwd(query1))){
							count1++;
							wsFlag = "1";
							continue;
						}
					} else if (yonghuzhuangtai.equals("���˶�")) {
						if (!"0".equals(WebServiceMethods.TuiDing(query1))) {
							count2++;
							wsFlag = "1";
							continue;
						}
					} else {
						model.put("yonghuzhuangtai", "�쳣״̬");
						continue;
					}
				}


			}

			/****************************************************************************************/

			if (yonghuzhuangtai.equals("���޸�")) {
				model.put("yonghuzhuangtai", "���޸�");
			} else if (yonghuzhuangtai.equals("���˶�")) {
				model.put("yonghuzhuangtai", "���˶�");
			} else {
				model.put("yonghuzhuangtai", "�쳣״̬");
			}
			model.put("beizhuhuizong", query.get(0).getDataElement("beizhuhuizong").getString() + " ������:" + getUserInfo().getEmployeeName() + " ����ʱ�䣺" + Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			ParameterModel conds = new ParameterModel();
			conds.put("uuid", uuidArray[i]);
			dao.update("yonghushuju", model, conds);

		}

		commit();
		try {

		} catch (Exception e) {
			rollback();
			log.error(e);
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�����쳣,��˲�����");
		}

		if ("".equals(wsFlag)) {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "����ɹ���");
		} else if ("0".equals(wsFlag)) {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "����ɹ�������Ŷ�ͬ���ɹ���");
		} else {
			String str = "";
			if (count1 != 0) {
				str += "��" + count1 + "�������޸ļ�¼����ʧ�ܣ�";
			}
			if (count2 != 0) {
				str += "��" + count2 + "���˶���¼����ʧ�ܣ�";
			}
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, str);

		}
	}

	public CommonMessage daiweixiuApprove(JiaofeiDataFrom jiaofeiDataFrom) throws Exception {
		String[] uuids = jiaofeiDataFrom.getUUIDS();
		openTransaction();
		for (int i = 0; i < uuids.length; i++) {
			ParameterSet set = new ParameterSet();
			set.add("uuid", "@UUID", uuids[i]);
			DataSet<DataRow> query = dao.executeQuery("GetDaiweixiuList", set);
			String zongshoufei = query.get(0).getDataElement("zongshoufei").getString();
			ParameterModel model = new ParameterModel();
			model.put("yonghuzhuangtai", "��ά��");
			if (!zongshoufei.trim().equals("0")) {
				model.put("dianshi", "����");
			}
			model.put("beizhuhuizong", query.get(0).getDataElement("beizhuhuizong").getString() + " ¼����:" + getUserInfo().getEmployeeName() + " ¼��ʱ�䣺" + Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			// form.getBeizhuhuizong()+" �༭��:"+getUserInfo().getEmployeeName()+" �༭ʱ�䣺"+form.getNowdata()
			ParameterModel conds = new ParameterModel();
			conds.put("uuid", uuids[i]);
			dao.update("yonghushuju", model, conds);
		}
		commit();
		try {

		} catch (Exception e) {
			rollback();
			log.error(e);
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�������,��˲�����");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "¼��ɹ���");
	}

	public CommonMessage deleteDaijiaofei(JiaofeiDataFrom jiaofeiDataFrom) throws Exception {
		try {
			String uuid = jiaofeiDataFrom.getUUID();
			ParameterSet set = new ParameterSet();
			set.add("uuid", "@UUID", uuid);
			DataSet<DataRow> query = dao.executeQuery("GetDaijiaofeiList", set);
			ParameterModel model2 = new ParameterModel();
			model2.put("xx_xiaoqu", query.get(0).getDataElement("xiaoqu").getString());
			model2.put("xx_dizhi", query.get(0).getDataElement("dizhi").getString());
			model2.put("xx_wangluo", query.get(0).getDataElement("wangluo").getString());
			model2.put("shoukuanshijian", query.get(0).getDataElement("shoukuanshijian").getString());
			model2.put("yh_zhuangtai", "���ɷ�");
			model2.put("xx_dianshi", query.get(0).getDataElement("dianshi").getString());
			model2.put("yh_kaijiDate", query.get(0).getDataElement("kaijishijian").getString());
			model2.put("yh_tingjiDate", query.get(0).getDataElement("tingjishijian").getString());
			model2.put("fy_kuandai", query.get(0).getDataElement("kuandaifei").getString());
			model2.put("fy_shoushi", query.get(0).getDataElement("shoushifei").getString());
			model2.put("fy_onu", query.get(0).getDataElement("onuyj").getString());
			model2.put("fy_jidinghe", query.get(0).getDataElement("jidingheyj").getString());
			model2.put("qt_zongshoufei", query.get(0).getDataElement("zongshoufei").getString());
			model2.put("xx_yewu", query.get(0).getDataElement("yewu").getString());
			model2.put("qt_shoujuNum", query.get(0).getDataElement("xiaoqu").getString());
			model2.put("qt_kaipiaoxinxi", query.get(0).getDataElement("shoujubenhao").getString());
			model2.put("qt_shigongren", query.get(0).getDataElement("shigongren").getString());
			model2.put("xiugai_date", Common.getDate("yyyy-MM-dd HH:mm:ss"));
			model2.put("beizhuhuizong", query.get(0).getDataElement("beizhuhuizong").getString() + " ɾ����:" + getUserInfo().getEmployeeName() + " ɾ��ʱ�䣺" + Common.getDate("yyyy-MM-dd HH:mm:ss"));
			model2.put("xiugai_ren", getUserInfo().getEmployeeName());
			dao.insert("yonghudatalog", model2);

			dao.execute("DeleteDaijiaofei", set);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ɾ��ʧ�ܣ�");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ɾ���ɹ���");
	}

	/**
	 * ���˻�
	 *
	 * @return
	 * @throws Exception
	 */
	public CommonMessage delOperate(String tfids) throws Exception {
		try {
			String[] tfidArray = tfids.split(",");
			for (int i = 0; i < tfidArray.length; i++) {
				String uuid = tfidArray[i];
				ParameterSet set = new ParameterSet();
				set.add("uuid", "@UUID", uuid);
				// DataSet<DataRow> query =
				// dao.executeQuery("GetDaijiaofeiList", set);
		/*
		 * ParameterModel model2 = new ParameterModel();
		 * model2.put("xx_xiaoqu",
		 * query.get(0).getDataElement("xiaoqu").getString());
		 * model2.put("xx_dizhi",
		 * query.get(0).getDataElement("dizhi").getString());
		 * model2.put("xx_wangluo",
		 * query.get(0).getDataElement("wangluo").getString());
		 * model2.put("shoukuanshijian",
		 * query.get(0).getDataElement("shoukuanshijian").getString());
		 * model2.put("yh_zhuangtai", "���ɷ�"); model2.put("xx_dianshi",
		 * query.get(0).getDataElement("dianshi").getString());
		 * model2.put("yh_kaijiDate",
		 * query.get(0).getDataElement("kaijishijian").getString());
		 * model2.put("yh_tingjiDate",
		 * query.get(0).getDataElement("tingjishijian").getString());
		 * model2.put("fy_kuandai",
		 * query.get(0).getDataElement("kuandaifei").getString());
		 * model2.put("fy_shoushi",
		 * query.get(0).getDataElement("shoushifei").getString());
		 * model2.put("fy_onu",
		 * query.get(0).getDataElement("onuyj").getString());
		 * model2.put("fy_jidinghe",
		 * query.get(0).getDataElement("jidingheyj").getString());
		 * model2.put("qt_zongshoufei",
		 * query.get(0).getDataElement("zongshoufei").getString());
		 * model2.put("xx_yewu",
		 * query.get(0).getDataElement("yewu").getString());
		 * model2.put("qt_shoujuNum",
		 * query.get(0).getDataElement("xiaoqu").getString());
		 * model2.put("qt_kaipiaoxinxi",
		 * query.get(0).getDataElement("shoujubenhao").getString());
		 * model2.put("qt_shigongren",
		 * query.get(0).getDataElement("shigongren").getString());
		 * model2.put("xiugai_date",
		 * Common.getDate("yyyy-MM-dd HH:mm:ss"));
		 * model2.put("beizhuhuizong",
		 * query.get(0).getDataElement("beizhuhuizong").getString() +
		 * " ɾ����:" + getUserInfo().getEmployeeName() + " ɾ��ʱ�䣺" +
		 * Common.getDate("yyyy-MM-dd HH:mm:ss"));
		 * model2.put("xiugai_ren", getUserInfo().getEmployeeName());
		 * dao.insert("yonghudatalog", model2);
		 */

				dao.execute("DeleteOperate", set);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ɾ��ʧ�ܣ�");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ɾ���ɹ���");
	}

	public CommonMessage deleteDaiweixiu(JiaofeiDataFrom jiaofeiDataFrom) throws Exception {
		try {
			String[] uuids = jiaofeiDataFrom.getUUIDS();
			for (int i = 0; i < uuids.length; i++) {
				ParameterSet set = new ParameterSet();
				set.add("uuid", "@UUID", uuids[i]);
				DataSet<DataRow> query = dao.executeQuery("GetDaiweixiuList", set);
				String fenguangID = query.get(0).getDataElement("fenguangID").getString();
				if(fenguangID==null||"".equals(fenguangID)||"0".equals(fenguangID)) {
					new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "����ƥ��ֹ����Ϣ���ܱ�ɾ����");
				}
				ParameterModel model2 = new ParameterModel();
				model2.put("xx_xiaoqu", query.get(0).getDataElement("xiaoqu").getString());
				model2.put("xx_dizhi", query.get(0).getDataElement("dizhi").getString());
				model2.put("yh_zhuangtai", "ά�޴�����");
				model2.put("yh_kaijiDate", query.get(0).getDataElement("shoukuanshijian").getString());
				model2.put("yh_tingjiDate", query.get(0).getDataElement("shoukuanshijian").getString());
				model2.put("shoukuanshijian", query.get(0).getDataElement("shoukuanshijian").getString());
				model2.put("fy_kuandai", query.get(0).getDataElement("kuandaifei").getString());
				model2.put("fy_shoushi", query.get(0).getDataElement("shoushifei").getString());
				model2.put("fy_chuzhuang", query.get(0).getDataElement("chuzhuangfei").getString());
				model2.put("fy_shebeixiaoshou", query.get(0).getDataElement("shebeixiaoshou").getString());
				model2.put("fy_cailiao", query.get(0).getDataElement("cailiaofei").getString());
				model2.put("fy_nianfei", query.get(0).getDataElement("nianfei").getString());
				model2.put("fy_onu", query.get(0).getDataElement("onuyj").getString());
				model2.put("fy_jidinghe", query.get(0).getDataElement("jidingheyj").getString());
				model2.put("qt_zongshoufei", query.get(0).getDataElement("zongshoufei").getString());
				model2.put("qt_jiexianzi", query.get(0).getDataElement("jiexianzi").getString());
				model2.put("qt_rj11", query.get(0).getDataElement("rj11").getString());
				model2.put("qt_rj45", query.get(0).getDataElement("rj45").getString());
				model2.put("qt_mokuai", query.get(0).getDataElement("mokuai").getString());
				model2.put("qt_mianban", query.get(0).getDataElement("mianban").getString());
				model2.put("qt_wangxian", query.get(0).getDataElement("wangxian").getString());
				model2.put("qt_haocai", query.get(0).getDataElement("qitahaocai").getString());
				model2.put("qt_shoujuNum", query.get(0).getDataElement("shoujubenhao").getString());
				model2.put("qt_kaipiaoxinxi", query.get(0).getDataElement("kaipiaoxinxi").getString());
				model2.put("qt_shigongren", query.get(0).getDataElement("shigongren").getString());
				model2.put("xiugai_date", Common.getDate("yyyy-MM-dd HH:mm:ss"));
				model2.put("pipeizhuangtai", "δƥ��");
				model2.put("xx_yewu", query.get(0).getDataElement("yewu").getString());

				model2.put("beizhuhuizong", query.get(0).getDataElement("beizhuhuizong").getString() + " ɾ����:" + getUserInfo().getEmployeeName() + " ɾ��ʱ�䣺" + Common.getDate("yyyy-MM-dd HH:mm:ss"));
				model2.put("xiugai_ren", getUserInfo().getEmployeeName());

				dao.insert("yonghudatalog", model2);

				dao.execute("DeleteDaiweixiu", set);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ɾ��ʧ�ܣ�");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ɾ���ɹ���");
	}

}
