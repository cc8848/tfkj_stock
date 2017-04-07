package com.stock.tietongshuju; 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.yonghushuju.TietongDataForm;
import com.stock.yonghushuju.YonghuDataForm;
import com.stock.yonghushuju.util.ExportTietongHeduiExcel;
import com.takucin.aceeci.frame.ContainerManager;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.PropertyReader;



/** 
 * @author wangdl 
 * @version ����ʱ�䣺2012-6-14 ����09:44:35 
 * ��˵�� 
 */

public class ImportDataService extends BusinessService {
	public static final String URL = PropertyReader.readProperty("BaseIp","radius_server");	
	public static final String FTP = PropertyReader.readProperty("BaseIp","ftp_ip");	
	public static final String FTP_USER = PropertyReader.readProperty("BaseIp","ftp_user");	
	public static final String FTP_PWD = PropertyReader.readProperty("BaseIp","ftp_pwd");	
	private Log log = LogFactory.getLog(this.getClass());
	private ImportService service = new ImportService();
	private CommonDao dao = new CommonDao();
	private DataValidator validator = new DataValidator();
	//StringBuffer sb = new StringBuffer();
	Integer count = 0 ;
	String uuid = null ;
	
	/**
	 * parse input to list.
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public List<EntityData> parse(InputStream input) throws Exception{
		List<EntityData> list = new ArrayList<EntityData>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int i = 1;//��excel�����п�ʼȡ����
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			EntityData entityTel = new EntityData();
			String[] values = service.convertRow(hssfRow, 53);//excel ��ȡ������

			entityTel.setYonghuzhuangtai(values[0]);
			if(values[1] == null || values[1].trim().equals("") || values[1].trim() == ""){
				entityTel.setPipeizhuangtai("δƥ��");
			}else{
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
			if(values[28] == null || values[28].trim().equals("") || values[28].trim() == ""){
				entityTel.setOnuyj("0");
			}else{
				entityTel.setOnuyj(values[28]);
			}
			if(values[29] == null || values[29].trim().equals("") || values[29].trim() == ""){
				entityTel.setJidingheyj("0");
			}else{
				entityTel.setJidingheyj(values[29]);
			}
			if(values[30] == null || values[30].trim().equals("") || values[30].trim() == ""){
				entityTel.setShoushifei("0");
			}else{
				entityTel.setShoushifei(values[30]);
			}
			if(values[31] == null || values[31].trim().equals("") || values[31].trim() == ""){
				entityTel.setKuandaifei("0");
			}else{
				entityTel.setKuandaifei(values[31]);
			}
			if(values[32] == null || values[32].trim().equals("") || values[32].trim() == ""){
				entityTel.setChuzhuangfei("0");
			}else{
				entityTel.setChuzhuangfei(values[32]);
			}
			if(values[33] == null || values[33].trim().equals("") || values[33].trim() == ""){
				entityTel.setShebeicaigou("0");
			}else{
				entityTel.setShebeicaigou(values[33]);
			}
			if(values[34] == null || values[34].trim().equals("") || values[34].trim() == ""){
				entityTel.setCailiaofei("0");
			}else{
				entityTel.setCailiaofei(values[34]);
			}
			entityTel.setYunyingshang(values[35]);
			if(values[36] == null || values[36].trim().equals("") || values[36].trim() == ""){
				entityTel.setBzygf("0");
			}else{
				entityTel.setBzygf(values[36]);
			}
			if(values[37] == null || values[37].trim().equals("") || values[37].trim() == ""){
				entityTel.setNianfei("0");
			}else{
				entityTel.setNianfei(values[37]);
			}
			entityTel.setBeizhu(values[38]);
			if(values[39] == null || values[39].trim().equals("") || values[39].trim() == ""){
				entityTel.setZongshoufei("0");
			}else{
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
	 * @param classid
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
				//����У��
				String error = validator.insertValidate(pgd);
				if(error != null) {
					return new CommonMessage(error, String.valueOf(i));
				}
				
				/*
				 * when multi business in one row,then split to multi rows and insert to DB.
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
		}
		catch (Exception e) {
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
		int errorRow = 0 ;
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
				//����У��
				errorRow = i;
				String error = validator.insertWeixiuValidate(pgd);
				if(error != null) {
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
		}
		catch (Exception e) {
			rollback();
			log.error(e);
			return new CommonMessage(ErrorConstant.WXD_DATA_ERROR , String.valueOf(errorRow));
		}
			return new CommonMessage(Constant.SUCCESS);
	}
	
	
	
	/**
	 * ���ϴ��ɷѼ�¼�������������ϴ��ɷѣ���¼�ϴ�����°�װ��¼��
	 * 
	 * @param input
	 * @param zjlist �Ѱ�װ�û�����
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
		int errorRow = 0 ;

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
				if(error != null) {
					rollback();
					return new CommonMessage(error, String.valueOf(i));
				}
				Integer countWangluo = 0 ;
				Integer countDianshi = 0 ;
				Integer countDianhua = 0 ;
				xiaoqu = pgd.getXiaoqu();
				dizhi = pgd.getDizhi();
				wangluo = pgd.getWangluo();
				dianshi = pgd.getDianshi();
				dianhua = pgd.getDianhua();
				
				String checkJiaoFeiDanNull = checkJiaoFeiDanNull(xiaoqu , dizhi , wangluo , dianshi , dianhua);
				String checkJiaoFeiDanMore = checkJiaoFeiDanMore(xiaoqu , dizhi , wangluo , dianshi , dianhua);
				
				if(!checkJiaoFeiDanNull.equals("true")){
					 sb.append(checkJiaoFeiDanNull);
					 return backCommonMessage(sb);
					//continue;
				}
				if(!checkJiaoFeiDanMore.equals("true")){
					 sb.append(checkJiaoFeiDanMore);
					  return backCommonMessage(sb);
					//continue;
				}
				
				/*
				 * �ж��Ѱ�װ��������
				 */
				if(!wangluo.equals("0"))
				{
					String s ;
					countWangluo = checkWangluoCount(xiaoqu,dizhi);
					if(countWangluo==0) {
						s = "(";
						s += xiaoqu ;
					    s += "," ;
						s += dizhi;
						s +=")";
						s += "�ް�װ����<br>";
						sb.append(s);
						//backCommonMessage(sb);
						continue;
						 
					}
					if(countWangluo==1) { 
						updateAndinsert(pgd,"wangluo");
					}
					if(countWangluo>1) {
						s = "(";
						s += xiaoqu ;
					    s += "," ;
						s += dizhi;
						s +=")";
						s += "��װ�����ظ�<br>";
						sb.append(s);
						//backCommonMessage(sb);
						continue;
					}
				}
				
				/*
				 * �ж��Ѱ�װ��������
				 */
				if(!dianshi.equals("0"))
				{
					String s ;
					countDianshi = checkDianshiCount(xiaoqu,dizhi);
					if(countDianshi==0) {
						s = "(";
						s += xiaoqu ;
					    s += "," ;
						s += dizhi;
						s +=")";
						s += "�ް�װ����<br>";
						sb.append(s);
						//backCommonMessage(sb);
						continue;
					}
					if(countDianshi==1) { 
						updateAndinsert(pgd , "dianshi");
					}
					if(countDianshi>1) {
						s = "(";
						s += xiaoqu ;
					    s += "," ;
						s += dizhi;
						s +=")";
						s += "��װ�����ظ�<br>";
						sb.append(s);
						//backCommonMessage(sb);
						continue;
					}
				}
				
				/*
				 * �ж��Ѱ�װ�绰����
				 */
				if(!dianhua.equals("0"))
				{
					String s ;
					countDianhua = checkDianhuaCount(xiaoqu,dizhi);
					if(countDianhua==0) {
						s = "(";
						s += xiaoqu ;
					    s += "," ;
						s += dizhi;
						s +=")";
						s += "�ް�װ�绰<br>";
						sb.append(s);
						//backCommonMessage(sb);
						continue;
					}
					if(countDianhua==1) { 
						updateAndinsert(pgd , "dianhua");
					}
					if(countDianhua>1) {
						s = "(";
						s += xiaoqu ;
					    s += "," ;
						s += dizhi;
						s +=")";
						s += "��װ�绰�ظ�<br>";
						sb.append(s);
						//backCommonMessage(sb);
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
			return new CommonMessage(ErrorConstant.XFD_DATA_ERROR , String.valueOf(errorRow));
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
	
			
		if(yewu.equals("wangluo")) {
			dao.execute("updateAnZhuangWangluoDataByUser", set);
		}
		else if(yewu.equals("dianshi")) {
			dao.execute("updateAnZhuangDianshiDataByUser", set);
		}
			
	}

	private int checkDianhuaCount(String xiaoqu, String dizhi) throws Exception {
		ParameterSet set1 =new ParameterSet();
		set1.add("xiaoqu" , "@xiaoqu" , xiaoqu);
		set1.add("dizhi" , "@dizhi" , dizhi);
		set1.add("wangluo" , "@wangluo" , "0");
		set1.add("dianhua", "@dianshi", "0");
		return dao.executeQueryToCount("GetUserDataByAnZhuangCount", set1);
		
	}

	private int checkDianshiCount(String xiaoqu, String dizhi) throws Exception {
		ParameterSet set1 =new ParameterSet();
		set1.add("xiaoqu" , "@xiaoqu" , xiaoqu);
		set1.add("dizhi" , "@dizhi" , dizhi);
		set1.add("dianshi" , "@dianshi" , "0");
		//set1.add("dianhua", "@dianhua", "0");
		return dao.executeQueryToCount("GetUserDataByAnZhuangCount", set1);
		
	}

	private int checkWangluoCount(String xiaoqu, String dizhi) throws Exception {
		ParameterSet set1 =new ParameterSet();
		set1.add("xiaoqu" , "@xiaoqu" , xiaoqu);
		set1.add("dizhi" , "@dizhi" , dizhi);
		set1.add("wangluo", "@wangluo", "0");
		//set1.add("dianhua", "@dianhua", "0");
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
		String s ;
		/*
		 * �ɷѵ�һ�����ݰ�������ҵ��
		 */
		if( (!wangluo.equals("0") && !dianshi.equals("0")) 
			|| (!wangluo.equals("0") && !dianhua.equals("0")) 
        	|| (!dianshi.equals("0") && !dianhua.equals("0")) 
        	|| (!dianshi.equals("0") && !dianhua.equals("0") && !wangluo.equals("0"))) {
		
			 s = "(";
			 s += xiaoqu ;
			 s += "," ;
			 s += dizhi;
			 s +=")";
			 s += "���ж���ҵ��";
			 rollback();
			//�ɷѵ��û�{0}���ж���ҵ��
		   // return	new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR02 , sb.toString());
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
		if( dianshi.equals("0") && dianhua.equals("0") && wangluo.equals("0")) {
		    
			 s = "(";
			 s += xiaoqu ;
			 s += "," ;
			 s += dizhi;
			 s +=")";
			 s += "ҵ��Ϊ��";
			 rollback();
			 //�ɷѵ��û�{0}ҵ��Ϊ�գ�
//			 return	new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR01 , sb.toString());
			 return s;
		}
		return "true";
	}
	
	
	private CommonMessage backCommonMessage(StringBuffer error) throws Exception {
		return	new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , error.toString());
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
	 * @param zjlist �Ѱ�װ�û�����
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
//				openTransaction();
				int i = 1;
//				int i = list.size();
				for (EntityData pgd : list) {
					String error = validator.insertAnzhuangValidate(pgd);
					if(error != null) {
						return new CommonMessage(error, String.valueOf(i));
					}
					
					ParameterSet set = new ParameterSet();
					set.add("yonghuzhuangtai", "@yonghuzhuangtai", "�Ѱ�װ");
					set.add("xiaoqu", "@xiaoqu", pgd.getXiaoqu());
					set.add("dizhi", "@dizhi", pgd.getDizhi());
					DataSet<DataRow> executeQuery = dao.executeQuery("comparisonYianzhuangData", set);
					if (executeQuery.size() > 0) {
						for(DataRow row : executeQuery) {
							EntityData entityData = new EntityData();
							entityData.setUUID(row.getDataElement("PK_ID").getString());
							entityData.setYonghuzhuangtai(row.getDataElement("yonghuzhuangtai").getString());
							entityData.setPipeizhuangtai(row.getDataElement("pipeizhuangtai")==null?"":row.getDataElement("pipeizhuangtai").getString());
							entityData.setShoukuanshijian(row.getDataElement("shoukuanshijian")==null?"":row.getDataElement("shoukuanshijian").getString());
							entityData.setXingming(row.getDataElement("xingming").getString()==null?"":row.getDataElement("xingming").getString());
							entityData.setShenfensheng(row.getDataElement("shenfensheng").getString()==null?"":row.getDataElement("shenfensheng").getString());
							entityData.setShoujuhao(row.getDataElement("shoujuhao").getString()==null?"":row.getDataElement("shoujuhao").getString());
							entityData.setFenguangxianhao(row.getDataElement("fenguangxianhao").getString()==null?"":row.getDataElement("fenguangxianhao").getString());
							entityData.setJiexuweizhi(row.getDataElement("jiexuweizhi").getString()==null?"":row.getDataElement("jiexuweizhi").getString());
							entityData.setKaijishijian(row.getDataElement("kaijishijian").getString());
							entityData.setTingjishijian(row.getDataElement("tingjishijian").getString());
							entityData.setXiaoqu(row.getDataElement("xiaoqu").getString());
							entityData.setDizhi(row.getDataElement("dizhi").getString());
							entityData.setLianxidianhua(row.getDataElement("lianxidianhua").getString()==null?"":row.getDataElement("lianxidianhua").getString());
							entityData.setWangluo(row.getDataElement("wangluo").getString());
							entityData.setDianshi(row.getDataElement("dianshi").getString());
							entityData.setDianhua(row.getDataElement("dianhua").getString());
							entityData.setYewu(row.getDataElement("yewu").getString()==null?"":row.getDataElement("yewu").getString());
							entityData.setFenguang(row.getDataElement("fenguang").getString()==null?"":row.getDataElement("fenguang").getString());
							entityData.setOnumac(row.getDataElement("onumac").getString()==null?"":row.getDataElement("onumac").getString());
							entityData.setStbmcid(row.getDataElement("stbmcid").getString()==null?"":row.getDataElement("stbmcid").getString());
							entityData.setDianshiip(row.getDataElement("dianshiip").getString()==null?"":row.getDataElement("dianshiip").getString());
							entityData.setWangluoip(row.getDataElement("wangluoip").getString()==null?"":row.getDataElement("wangluoip").getString());
							entityData.setDianhuaip(row.getDataElement("dianhuaip").getString()==null?"":row.getDataElement("dianhuaip").getString());
							entityData.setDianhuavlan(row.getDataElement("dianhuavlan").getString()==null?"":row.getDataElement("dianhuavlan").getString());
							entityData.setWangluovlan(row.getDataElement("wangluovlan").getString()==null?"":row.getDataElement("wangluovlan").getString());
							entityData.setShangmenshijian(row.getDataElement("shangmenshijian").getString()==null?"":row.getDataElement("shangmenshijian").getString());
							entityData.setDanzheng(row.getDataElement("danzheng").getString()==null?"":row.getDataElement("danzheng").getString());
							entityData.setSxdhhm(row.getDataElement("sxdhhm").getString()==null?"":row.getDataElement("sxdhhm").getString());
							entityData.setOnuyj(row.getDataElement("onuyj").getString()==null?"":row.getDataElement("onuyj").getString());
							entityData.setJidingheyj(row.getDataElement("jidingheyj").getString()==null?"":row.getDataElement("jidingheyj").getString());
							entityData.setShoushifei(row.getDataElement("shoushifei").getString()==null?"":row.getDataElement("shoushifei").getString());
							entityData.setKuandaifei(row.getDataElement("kuandaifei").getString()==null?"":row.getDataElement("kuandaifei").getString());
							entityData.setChuzhuangfei(row.getDataElement("chuzhuangfei").getString()==null?"":row.getDataElement("chuzhuangfei").getString());
							entityData.setShebeicaigou(row.getDataElement("shebeixiaoshou").getString()==null?"":row.getDataElement("shebeixiaoshou").getString());
							entityData.setCailiaofei(row.getDataElement("cailiaofei").getString()==null?"":row.getDataElement("cailiaofei").getString());
							entityData.setYunyingshang(row.getDataElement("yunyingshang").getString()==null?"":row.getDataElement("yunyingshang").getString());
							entityData.setBzygf(row.getDataElement("bzygf").getString()==null?"":row.getDataElement("bzygf").getString());
							entityData.setNianfei(row.getDataElement("nianfei").getString()==null?"":row.getDataElement("nianfei").getString());
							entityData.setBeizhu(row.getDataElement("beizhu").getString()==null?"":row.getDataElement("beizhu").getString());
							entityData.setZongshoufei(row.getDataElement("zongshoufei").getString()==null?"":row.getDataElement("zongshoufei").getString());
							entityData.setShoujubenhao(row.getDataElement("shoujubenhao").getString()==null?"":row.getDataElement("shoujubenhao").getString());
							entityData.setKaipiaoxinxi(row.getDataElement("kaipiaoxinxi").getString()==null?"":row.getDataElement("kaipiaoxinxi").getString());
							entityData.setQtsbsyqk(row.getDataElement("qtsbsyqk").getString()==null?"":row.getDataElement("qtsbsyqk").getString());
							entityData.setQitahaocai(row.getDataElement("qitahaocai").getString()==null?"":row.getDataElement("qitahaocai").getString());
							entityData.setJiexianzi(row.getDataElement("jiexianzi").getString()==null?"":row.getDataElement("jiexianzi").getString());
							entityData.setRj11(row.getDataElement("rj11").getString()==null?"":row.getDataElement("rj11").getString());
							entityData.setRj45(row.getDataElement("rj45").getString()==null?"":row.getDataElement("rj45").getString());
							entityData.setMokuai(row.getDataElement("mokuai").getString()==null?"":row.getDataElement("mokuai").getString());
							entityData.setMianban(row.getDataElement("mianban").getString()==null?"":row.getDataElement("mianban").getString());
							entityData.setWangxian(row.getDataElement("wangxian").getString()==null?"":row.getDataElement("wangxian").getString());
							entityData.setShigongren(row.getDataElement("shigongren").getString()==null?"":row.getDataElement("shigongren").getString());
							entityData.setXianchangbeizhu(row.getDataElement("xianchangbeizhu").getString()==null?"":row.getDataElement("xianchangbeizhu").getString());
							entityData.setBeizhuhuizong(row.getDataElement("beizhuhuizong").getString()==null?"":row.getDataElement("beizhuhuizong").getString());
							
							listdata.add(entityData);
						}
					}
					i++;
				}
				if(listdata.size() == 0) {
					return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG,"�ް�װ���ݿ��Աȶԣ�");
				} else {
					//toExcel(listdata);
					return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG , "<a href='http://"+remoteAddr+":8080/tfkj_stock/excel/a.xls'>���رȶ��Ѱ�װExcel</a>");
				}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.AZD_DATA_ERROR);
		}
	}
	public static final String DOWNLOAD_DIR = PropertyReader.readProperty("BaseIp","server");
	/**
	 * ���ҵ��յĿ�����������Ϣ��װ��ʵ����
	 * @param request 
	 * @param f2 
	 * @return
	 * @throws ParseException
	 */

	public String findTodayDate() throws Exception {
		Date date = new Date();
		Calendar date1 = Calendar.getInstance();
		date1.setTime(date);
		//date1.set(Calendar.DATE, date1.get(Calendar.DATE) - 1);
		date1.set(Calendar.DATE, date1.get(Calendar.DATE) - 1);
		SimpleDateFormat dft = new SimpleDateFormat("yyyy/MM/dd");
		Date endDate = dft.parse(dft.format(date1.getTime()));
		String formatDate = Common.formatDate(endDate, "yyyy/MM/dd");
		List<TietongDataForm> tflist = null;
		List<TietongDataForm> tfZifeilist = null;
		List<TietongDataForm> tfXiaoqulist = null;
		//try {
			tflist = getTflist(null,formatDate,"","");
			tfZifeilist = getTfZifeilist(null,formatDate,"","");
			tfXiaoqulist = getTfXiaoqulist(null,formatDate,"","");
	/*	} catch (Exception e1) {
			e1.printStackTrace();
		}*/
		
		if(toText(formatDate,tflist, tfXiaoqulist, tfZifeilist)){
			String ftpUploadFile = ftpUploadFile(formatDate);
			return ftpUploadFile;
		} else {
			return "�����ļ��쳣!";
		}
		
	}
	public CommonMessage findTodayDate(TietongDataForm f2) throws ParseException {
		/*Date date = new Date();
		Calendar date1 = Calendar.getInstance();
		date1.setTime(date);
		date1.set(Calendar.DATE, date1.get(Calendar.DATE) - 1);
		SimpleDateFormat dft = new SimpleDateFormat("yyyy/MM/dd");
		Date endDate = dft.parse(dft.format(date1.getTime()));
		String formatDate = Common.formatDate(endDate, "yyyy/MM/dd");*/
		/*SimpleDateFormat dft = new SimpleDateFormat("yyyy/MM/dd");
		Date endDate = dft.parse(dft.format(date1.getTime()));
		String formatDate = Common.formatDate(endDate, "yyyy/MM/dd");*/
		
		//String formatDate = Common.formatDate(new Date(), "yyyy/MM/dd");
		String daochuriqiStart = f2.getDaochuriqiStart();
		daochuriqiStart = daochuriqiStart.replaceAll("-", "");
		List<TietongDataForm> tflist;
		List<TietongDataForm> tfXiaoqulist;
		List<TietongDataForm> tfZifeilist;
		try {
			tfZifeilist = getTfZifeilist(f2,null,"","");
			tfXiaoqulist = getTfXiaoqulist(f2,null,"","");
			tflist = getTflist(f2,null,"","");
		} catch (Exception e1) {
			e1.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"�����쳣,����ʧ�ܣ�");
		}
		if(toText(daochuriqiStart,tflist ,tfXiaoqulist , tfZifeilist)){
			
		    /*
		     * ftp�ļ��ϴ�
	         **/
			ftpUploadFile(daochuriqiStart);
			//return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, ftpUploadFile);
			//String f = Common.formatDate(new Date(), "yyyy/MM/dd");
			//daochuriqiStart = daochuriqiStart.replaceAll("-", "");
			//String path = "c:/tietong";

			String textName1 = "user_"+daochuriqiStart+".txt";
			String textName2 = "pay_"+daochuriqiStart+".txt";
			String textName3 = "communities_"+daochuriqiStart+".txt";
			String textName4 = "services_"+daochuriqiStart+".txt";
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "<a href='http://"+DOWNLOAD_DIR+":8080/tfkj_stock/excel/user_"+daochuriqiStart+".txt'>����"+daochuriqiStart+"�û�TXT</a></br>" +
					"<a href='http://"+DOWNLOAD_DIR+":8080/tfkj_stock/excel/pay_"+daochuriqiStart+".txt'>����"+daochuriqiStart+"�ɷ�TXT</a></br>" +
							"<a href='http://"+DOWNLOAD_DIR+":8080/tfkj_stock/excel/communities_"+daochuriqiStart+".txt'>����"+daochuriqiStart+"С��TXT</a></br>" +
									"<a href='http://"+DOWNLOAD_DIR+":8080/tfkj_stock/excel/services_"+daochuriqiStart+".txt'>����"+daochuriqiStart+"�ʷ�TXT</a>");
		}else {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"�����쳣,����ʧ�ܣ�");
		}
		
	}

	

	/**
	 * ������һ������ʱ�����һ��Ľ�� ������������ ����
	 * ��һ������Ϊ������������������ʱ ����ʱ��ν����  (С����ǰ�������ں�)
	 * @param f2 
	 * @param formatDate ��ѭ��ʽ yyyy/mm/dd
	 * @param date1                  ��ѭ��ʽ yyyy/mm/dd
	 * @param date2                  ��ѭ��ʽ yyyy/mm/dd
	 * @return List<TietongDataForm>
	 * @throws Exception
	 */
	
	
	//��ȡ�ʷѵ���Ϣ
	private List<TietongDataForm> getTfZifeilist(TietongDataForm f2, String formatDate, String date1, String date2) throws Exception {
		List<TietongDataForm> tflist = new ArrayList<TietongDataForm>();
		CommonDao d = new CommonDao();
		//String formatDate = Common.formatDate(new Date(), "yyyy/MM/dd");
		ParameterSet set = new ParameterSet();
		if (formatDate != null) {
			set.add("createdt1", "@createdt1", formatDate + " 00:00:01");
			set.add("createdt2", "@createdt2", formatDate + " 23:59:59");
		} else {
			String daochuriqiStart = f2.getDaochuriqiStart();
			set.add("createdt1", "@createdt1", daochuriqiStart + " 00:00:01");
			set.add("createdt2", "@createdt2", daochuriqiStart + " 23:59:59");
		}
		DataSet<DataRow> queryZifei = d.executeQuery("getTietongShujuZifei", set);
		ContainerManager.closeConnection();
		//���ʷѸ���
		java.text.DecimalFormat   df = new   java.text.DecimalFormat("#.##");   
		if (queryZifei != null && queryZifei.size() > 0) {
			for (int i = 0 ; i < queryZifei.size(); i++) {
				String zifeidaima = "";        //�ʷѴ���
				String zifeimiaosu = "";       //�ʷ�����
				String daikuan = "";           //����
				String shichang = "";          //ʱ��
				String zifei = "";	           //�ʷ�	char	10	�������ڵķ���
				String yuejunfeiyong = "";     //�¾�����	char	10	ÿ���µķ���
				String shangxingDK = "";       //���д���
				String xiaxingDK = "";         //���д���
				String zhuangtaidaima = "N";    //״̬����
				
				String shichangName = queryZifei.get(i).getDataElement("shichangName").getString();
				daikuan = queryZifei.get(i).getDataElement("daikuan").getString();
				
				//��ȡ���� toLowerCase();//������ȫ��ת����Сдm
				int indexOfDk = daikuan.toLowerCase().indexOf("m");
				if (indexOfDk > -1) {
					daikuan = daikuan.substring(0, indexOfDk);
				}
				
				//��ȡ�ʷѴ��룬�ʷ�����
				int indexOf = shichangName.indexOf(":");
				if (indexOf > -1 ) {
					zifeidaima = shichangName.substring(indexOf + 1, indexOf + 8);
					zifeimiaosu = shichangName.substring(0, indexOf);
				}
				int indexOfBaoyue = shichangName.indexOf("����");
				//��ȡʱ��
				if (indexOfBaoyue > -1) {
					shichang = "1";
					if (isNumeric(daikuan)) {
						int dk = Integer.parseInt(daikuan);
						int sh = dk * 1024;
						int xh = dk * 1024 / 3;
						shangxingDK = String.valueOf(sh);
						xiaxingDK = String.valueOf(xh);
					}
				}
				int indexOfGeYue = shichangName.indexOf("����");
				//��ȡʱ��
				if (indexOfGeYue > -1) {
					int bao = shichangName.indexOf("��");
					if ( bao > -1) {
						shichang = shichangName.substring(bao + 1,  indexOfGeYue);
					}
				}
				
				//��ȡ�ʷ�
				if (shichangName.indexOf("��") > -1 && shichangName.indexOf("Ԫ") > -1) {
					int indexOfyue = shichangName.indexOf("��");
					int indexOfyuan = shichangName.indexOf("Ԫ");
					zifei = shichangName.substring(indexOfyue + 1 , indexOfyuan);
					double zf = Double.parseDouble(zifei);
					zifei = df.format(zf);
				}
				
				//��ȡ�¾�����
				if (isNumeric(shichang) && isNumeric(zifei)) {
					Double sc = Double.parseDouble(shichang);
					Double zf = Double.parseDouble(zifei);
					Double yuejun = zf / sc;
					yuejunfeiyong = String.valueOf(df.format(yuejun));
				}
				
				//��ȡ�����д���
				if (isNumeric(daikuan)) {
					int dk = Integer.parseInt(daikuan);
					int xh = dk * 1024 ;
					int sh = xh / 3;
					xiaxingDK = String.valueOf(xh);
					shangxingDK = String.valueOf(sh);
				}
				
				TietongDataForm tdf = new TietongDataForm();
				tdf.setZifeidaima(zifeidaima);
				tdf.setZifeimiaosu(zifeimiaosu);
				tdf.setXianshidaikuan(daikuan);
				tdf.setShichang(shichang);
				tdf.setZifei(zifei);
				tdf.setYuejunfeiyong(yuejunfeiyong);
				tdf.setShangxingdaikuan(shangxingDK);
				tdf.setXiaxingdaikuan(xiaxingDK);
				tdf.setZhuangtaidaima(zhuangtaidaima);
				
				tflist.add(tdf);
			}
		}
		return tflist;
	}
	
	public static boolean isNumeric(String str){ 
		if(str == null || "".equals(str.trim())) {
			return false;
		}
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 }

	private List<TietongDataForm> getTfXiaoqulist(TietongDataForm f2, String formatDate, String date1, String date2) throws Exception {
		List<TietongDataForm> tflist = new ArrayList<TietongDataForm>();
		CommonDao d = new CommonDao();
		//String formatDate = Common.formatDate(new Date(), "yyyy/MM/dd");
		ParameterSet set = new ParameterSet();
		if (formatDate != null) {
			set.add("createdt1", "@createdt1", formatDate + " 00:00:01");
			set.add("createdt2", "@createdt2", formatDate + " 23:59:59");
		} else {
			String daochuriqiStart = f2.getDaochuriqiStart();
			set.add("createdt1", "@createdt1", daochuriqiStart + " 00:00:01");
			set.add("createdt2", "@createdt2", daochuriqiStart + " 23:59:59");
		}
		DataSet<DataRow> queryXiaoqu = d.executeQuery("getTietongShujuXiaoqu", set);
		ContainerManager.closeConnection();
		//��С������
		if (queryXiaoqu != null && queryXiaoqu.size() > 0) {
			for (int i = 0 ; i < queryXiaoqu.size(); i++) {
				String netcode = queryXiaoqu.get(i).getDataElement("netcode").getString();
				String communityname = queryXiaoqu.get(i).getDataElement("communityname").getString();
				TietongDataForm tdf = new TietongDataForm();
				tdf.setXiaoqudaima(netcode);
				tdf.setXiaoqumiaosu(communityname);
				tdf.setZhuangtaidaima("N");
				tdf.setBeizhushuoming("");
				tflist.add(tdf);
			}
		}
		return tflist;
	}
	private List<TietongDataForm> getTflist(TietongDataForm f2, String formatDate, String date1, String date2) throws Exception {
		List<TietongDataForm> tflist = new ArrayList<TietongDataForm>();
		CommonDao d = new CommonDao();
		//String formatDate = Common.formatDate(new Date(), "yyyy/MM/dd");
		ParameterSet set = new ParameterSet();
		if (formatDate != null) {
			set.add("createdt1", "@createdt1", formatDate + " 00:00:01");
			set.add("createdt2", "@createdt2", formatDate + " 23:59:59");
		} else {
			String daochuriqiStart = f2.getDaochuriqiStart();
			set.add("createdt1", "@createdt1", daochuriqiStart + " 00:00:01");
			set.add("createdt2", "@createdt2", daochuriqiStart + " 23:59:59");
		}
		//set.add("kaijishijian", "@kaijishijian", formatDate);
		//set.add("kaijishijian1", "@kaijishijian1", date1);
		//set.add("kaijishijian2", "@kaijishijian2", date2);
		DataSet<DataRow> executeQuery = d.executeQuery("getTietongShuju1", set);
		ContainerManager.closeConnection();
		for (int i = 0 ; i < executeQuery.size(); i++) {
			TietongDataForm tf = new TietongDataForm();
			String zifei = "";
			String zifeimiaosu = "";
			String yonghumoshi = "";
			//String id = executeQuery.get(i).getDataElement("id").getString();
			String yonghuzhuangtai = executeQuery.get(i).getDataElement("yonghuzhuangtai").getString();
			String kaijishijian = executeQuery.get(i).getDataElement("kaijishijian").getString();
			String tingjishijian = executeQuery.get(i).getDataElement("tingjishijian").getString();
			String xiaoqu = executeQuery.get(i).getDataElement("xiaoqu").getString();
			String dizhi = executeQuery.get(i).getDataElement("dizhi").getString();
			String wangluo = executeQuery.get(i).getDataElement("wangluo").getString();
			String lianxidianhua = executeQuery.get(i).getDataElement("lianxidianhua").getString();
			if (lianxidianhua == null || lianxidianhua.trim().equals("") || lianxidianhua.trim().length() > 11) {
				lianxidianhua ="";
			} else {
				lianxidianhua = executeQuery.get(i).getDataElement("lianxidianhua").getString();
			}
			String xingming = executeQuery.get(i).getDataElement("xingming").getString();
			String yewu = executeQuery.get(i).getDataElement("yewu").getString();
			String username = executeQuery.get(i).getDataElement("username").getString();
			String username1 = executeQuery.get(i).getDataElement("username1").getString();
			tf.setZhuangtai(yonghuzhuangtai);
			if(yonghuzhuangtai.trim().equals("������")){
				//����̫�ң����û�У����� ��û���ԷѴ���,�Է��������п���
				if(yewu.indexOf(":") == -1){
					zifei = "";
					zifeimiaosu = yewu;
				} else {
					int beginIndex =  yewu.lastIndexOf(":");
					zifei = yewu.substring(beginIndex + 1, yewu.length());
					zifeimiaosu = yewu.substring(yewu.lastIndexOf("/") + 1, yewu.lastIndexOf(":"));
				}
			} else {
				//���û�У����� ��û���ԷѴ���,�Է��������п���
				if(yewu.indexOf(":") == -1 || yewu.lastIndexOf(")") == -1){
					zifei = "";
					zifeimiaosu = yewu;
				} else {
					int beginIndex = yewu.indexOf(":");
					int indexOf = yewu.lastIndexOf(")");
					zifei = yewu.substring(beginIndex + 1, indexOf  > beginIndex ? indexOf : yewu.length());
					zifeimiaosu = yewu.substring(yewu.lastIndexOf("/") + 2, yewu.lastIndexOf(":"));
				}
			}
			if(yewu.contains("��������λ")){
				yonghumoshi = "����";
				continue;
			} else if (yewu.contains("����")){
				yonghumoshi = "����";
				continue;
			} else {
				yonghumoshi = "����";
				/*if(username.indexOf("-") != -1) {
					username = username.replaceAll("-", "");
				}*/
				if ( username.trim().equals("") || username.trim().equals("0") ||username == null) {
					username =  username1;
				}
			}
			String zongshoufei = executeQuery.get(i).getDataElement("zongshoufei").getString();
			String kuandaifei = executeQuery.get(i).getDataElement("kuandaifei").getString();
			String shoukuanshijian = executeQuery.get(i).getDataElement("shoukuanshijian").getString();
			String netcode = executeQuery.get(i).getDataElement("netcode").getString();
			/*DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		    Date d1 = df.parse(kaijishijian);
		    Date d2 = df.parse(tingjishijian);
		    long diff = d2.getTime() - d1.getTime();
		    long days = diff / (1000 * 60 * 60 * 24);
		    
		    long month =  days / 30;
		    if (month == 0){
		    	month = 1;
		    }*/
			/*long month = 1;
		    if(yewu.contains("����")) {
		    	month = 1;
		    } else if (yewu.contains("����")) {
		    	//System.out.println(yewu);
		    	int start = yewu.lastIndexOf("��");
		    	int end = yewu.lastIndexOf("����");
		    	month = Long.parseLong(yewu.substring(start + 1, end));
		    }
		    long zsf = 0;//���շ�
		    if(yewu.contains("����")) {
		    	System.out.println(yewu);
		    	int start = yewu.indexOf("����");
		    	int end = yewu.indexOf("Ԫ");
		    	if (end < start){
		    		start = yewu.lastIndexOf("����");
		    		end = yewu.lastIndexOf("Ԫ");
		    	}
		    	zsf = Long.parseLong(yewu.substring(start + 2, end));
		    } else if (yewu.contains("����")) {
		    	System.out.println(yewu);
		    	int start = yewu.indexOf("����");
		    	int end = yewu.indexOf("Ԫ");
		    	if (end - start > 4){
		    		start = yewu.lastIndexOf("����");
		    	}
		    	if (end < start){
		    		start = yewu.lastIndexOf("����");
		    		end = yewu.lastIndexOf("Ԫ");
		    	}
		    	zsf = Long.parseLong(yewu.substring(start + 2, end));
		    }
		    */
		   
		  /*  long yuefei = 0L;//�·�
		    yuefei = zsf / month;    */ 
		    if (kuandaifei == null || kuandaifei.trim().equals("") || kuandaifei.equals("0") ){
		    	 if (zongshoufei == null || zongshoufei.trim().equals("") || zongshoufei.equals("0")){
		    		 kuandaifei = "0";

		    	 } else {
		    		 kuandaifei = zongshoufei;
		    	 }
		    } 
		   //���û��zongshoufei��Ϊ0  ���ܼ����·ѣ��շѣ�ȫΪ0
		 /*   if (kuandaifei == null || kuandaifei.trim().equals("") || kuandaifei.equals("0") ){
		    	  if (zongshoufei == null || zongshoufei.trim().equals("") || zongshoufei.equals("0")){
		    		  zongshoufei = "0";
				      zsf = "0";
				      yuefei = 0L;
		    	  } else{
		    		  	kuandaifei = zongshoufei;
		    		  	long parseLong = Long.parseLong(kuandaifei);
			    	    if (parseLong < 100) {
			    	    	continue;
			    	    }
			    	    if(yewu.contains("����")) {
			    	    	parseLong = parseLong - month * 10;
			    	        DecimalFormat format = new DecimalFormat("0.00");//����С�����2λ
						    zsf = format.format(parseLong);
						    yuefei = parseLong / month;         //�·�
						    zongshoufei = format.format(yuefei);//���շ�
			    	    } else {
			    	        DecimalFormat format = new DecimalFormat("0.00");//����С�����2λ
						    zsf = format.format(parseLong);
						    yuefei = parseLong / month;         //�·�
						    zongshoufei = format.format(yuefei);//���շ�
			    	    }
		    	  }
		    	
		    } else {
	    	    long parseLong = Long.parseLong(kuandaifei);
	    	    if (parseLong < 100) {
	    	    	continue;
	    	    }
	    	    if(yewu.contains("����")) {
	    	    	parseLong = parseLong - month * 10;
	    	        DecimalFormat format = new DecimalFormat("0.00");//����С�����2λ
				    zsf = format.format(parseLong);
				    yuefei = parseLong / month;         //�·�
				    zongshoufei = format.format(yuefei);//���շ�
	    	    } else {
	    	        DecimalFormat format = new DecimalFormat("0.00");//����С�����2λ
				    zsf = format.format(parseLong);
				    yuefei = parseLong / month;         //�·�
				    zongshoufei = format.format(yuefei);//���շ�
	    	    }
			
		    }*/
			tf.setYonghuleixing("2");//�û�����	char	10	Ԥ��2/��0
			tf.setDengluming(username);
			if (lianxidianhua.indexOf("null") > -1) {
				tf.setMima("");
				tf.setLianxidianhua("");
			} else {
				tf.setMima(lianxidianhua);
				tf.setLianxidianhua(lianxidianhua);
			}
			tf.setXingming(xingming);
			tf.setDizhi(xiaoqu + dizhi);
			tf.setXiaoqu(xiaoqu);
			tf.setZhuceri(kaijishijian);
			tf.setDaoqiri(tingjishijian);
			tf.setJierufangshi("FTTH");//���뷽ʽ	char	10	�û��Ľ��뷽ʽ����ѡadsl����� addl/ftth
			if (yonghumoshi.equals("����")) {//�û���ģ	char	10	��ҵ1/����0
				tf.setYonghuguimo("0");
			} else {
				tf.setYonghuguimo("1");
			}
			tf.setZifeidaima(zifei);
			tf.setZifeimiaosu(zifeimiaosu);
			if (yonghuzhuangtai.trim().equals("�Ѳ��")) {
				tf.setYonghuzhuangtai("O");
			} else {
				tf.setYonghuzhuangtai("A");//�û�״̬	char	10	����A/ע��δ��ͨN/ͣ��C/����O
			}
			tf.setXiaoqudaima(netcode);
			
			Double kdf = Double.parseDouble(kuandaifei) * 10d * 10d;//*10  ë * 10 ��
			tf.setYufujine(String.valueOf(kdf));
			tf.setYufuriqi(shoukuanshijian);
			tf.setHoufujine("");
			tf.setHoufuriqi("");
			
			tf.setXiaoqumiaosu("");
			tf.setZhuangtaidaima("A");//״̬����	char	10	N��������A��������C���޸ģ�E��ע��
			tf.setBeizhushuoming("");
			
			
			tf.setShichang("");
			//tf.setZifei(zifei);
			tf.setZifei("");
			tf.setYuejunfeiyong("");
			/*if (wangluo.equals("�������")){
				tf.setShangxingdaikuan("");
				tf.setXiaxingdaikuan("");
				tf.setXianshidaikuan("");
			} else {*/
				wangluo = wangluo.toLowerCase();//������ȫ��ת����Сдm
				if(wangluo.indexOf("m") > -1) {
					wangluo = wangluo.trim().replaceAll("m", "");
					double parseDouble = Double.parseDouble(wangluo.trim().replaceAll("m", ""));
					tf.setShangxingdaikuan(String.valueOf((int)(parseDouble * 1024 / 3)));
					tf.setXiaxingdaikuan(String.valueOf((int)(parseDouble * 1024)));
					tf.setXianshidaikuan((wangluo.trim().replaceAll("m", "")));
				}
			//}
			tflist.add(tf);
		}
		return tflist;
	}

	private String ftpUploadFile(String daochuriqiStart) throws ParseException  {
		
		String path2 = this.getClass().getClassLoader().getResource("/").getPath();
		int index = path2.indexOf("WEB-INF");   
		path2 = path2.substring(0, index); 
		try {
			path2 = URLDecoder.decode(path2, "utf-8");
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		} 
		//String realPath = request.getSession().getServletContext().getRealPath("/");
		String realPath = path2;
		realPath = realPath + "\\excel";
		/*String textName1 = realPath + "\\user_"+daochuriqiStart+".txt";
		String textName2 = realPath + "\\pay_"+daochuriqiStart+".txt";
		String textName3 = realPath + "\\communities_"+daochuriqiStart+".txt";
		String textName4 = realPath + "\\services_"+daochuriqiStart+".txt";*/
		
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		FileInputStream fis3 = null;
		FileInputStream fis4 = null;
    	String formatDate = Common.formatDate(new Date(), "yyyy/MM/dd");
		String date = daochuriqiStart.replaceAll("/", "");
		String textName1 = realPath + "\\user_"+date+".txt";
		String textName2 = realPath + "\\pay_"+date+".txt";
		String textName3 = realPath + "\\communities_"+date+".txt";
		String textName4 = realPath + "\\services_"+date+".txt";
        
		try {
			ftpClient.connect(FTP);
			ftpClient.login(FTP_USER, FTP_PWD);
		} catch (Exception e1) {
			log.error("ftp�쳣��" + e1.toString());
        	return "FTP���Ӳ��ϣ�" + e1.toString();
		} 
		
        try {
        	int replyCode = ftpClient.getReplyCode();
           /* if (!(replyCode == 230)) {
            	
            }*/
            File srcFile1 = new File(textName1);
            File srcFile2 = new File(textName2);
            File srcFile3 = new File(textName3);
            File srcFile4 = new File(textName4);
            fis1 = new FileInputStream(srcFile1);
            fis2 = new FileInputStream(srcFile2);
            fis3 = new FileInputStream(srcFile3);
            fis4 = new FileInputStream(srcFile4);
            //�����ϴ�Ŀ¼
            //ftpClient.changeWorkingDirectory("/");
           // ftpClient.changeWorkingDirectory("/home/richftp" ); 
           // ftpClient.setBufferSize(1024);
            //ftpClient.setControlEncoding("GBK");
            //�����ļ����ͣ������ƣ�
            //ftpClient.setFileType(FTPClient.LOCAL_FILE_TYPE);
			//@TODO ��ʱע�͵���ͨ�Ľӿڣ���ֹ�Զ��ϴ�<<
//            boolean storeFile  = ftpClient.storeFile("user_"+date+".txt", fis1);
//            boolean storeFile2 = ftpClient.storeFile("pay_"+date+".txt", fis2);
//            boolean storeFile3 = ftpClient.storeFile("communities_"+date+".txt", fis3);
//            boolean storeFile4 = ftpClient.storeFile("services_"+date+".txt", fis4);
//            if(storeFile&storeFile2&storeFile3&storeFile4) {
//            } else {
//            	 log.error("�ͻ��������쳣��");
//            	 return "�ͻ��������쳣��";
//            }
//			>>
        } catch (IOException e) {
            e.printStackTrace();
            log.error("ftp�쳣��"  + "FTP�ͻ��˳���");
            return "FTP�ͻ��˳���" + e.toString();
        } finally {
            IOUtils.closeQuietly(fis1);
            IOUtils.closeQuietly(fis2);
            IOUtils.closeQuietly(fis3);
            IOUtils.closeQuietly(fis4);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("�ر�FTP���ӷ����쳣��" + e.toString());
                return "�ر�FTP���ӷ����쳣��" + e.toString();
            }
        }
		return "ftp�ϴ��ɹ�";
		
	}

	/**
	 * ������ͨ��Ҫ��txt�ļ�
	 * @param f2 
	 * @param tflist
	 * @param tfZifeilist 
	 * @param tfXiaoqulist 
	 * @param request 
	 * @return
	 * @throws ParseException
	 */
	private boolean toText(String f2, List<TietongDataForm> tflist, List<TietongDataForm> tfXiaoqulist, List<TietongDataForm> tfZifeilist) throws ParseException {
		try {
			String path2 = this.getClass().getClassLoader().getResource("/").getPath();
			int index = path2.indexOf("WEB-INF");   
			path2 = path2.substring(0, index); 
			path2 = URLDecoder.decode(path2, "utf-8"); 
			//String realPath = request.getSession().getServletContext().getRealPath("/");
			String realPath = path2;
			realPath = realPath + "\\excel";
			//String formatDate = Common.formatDate(new Date(), "yyyy/MM/dd");
			//String daochuriqiStart = f2.getDaochuriqiStart();
			//String date = formatDate.replaceAll("/", "");
			//String path = "c:/tietong";
			String date = f2.replaceAll("/", "");
			String path = realPath;
			File file = new File(path);
			if(!file.exists()){
				file.mkdir();
			}

			String textName1 = realPath + "\\user_"+date+".txt";
			String textName2 = realPath + "\\pay_"+date+".txt";
			String textName3 = realPath + "\\communities_"+date+".txt";
			String textName4 = realPath + "\\services_"+date+".txt";
			
			/*
			 *����TXT�ļ���д������ 
			 */
			FileWriter fileWriter1 = new FileWriter(textName1);
			BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
			PrintWriter printWriter1 = new PrintWriter(bufferedWriter1);
			
			FileWriter fileWriter2 = new FileWriter(textName2);
			BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
			PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);
			
			FileWriter fileWriter3 = new FileWriter(textName3);
			BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
			PrintWriter printWriter3 = new PrintWriter(bufferedWriter3);
			
			FileWriter fileWriter4 = new FileWriter(textName4);
			BufferedWriter bufferedWriter4 = new BufferedWriter(fileWriter4);
			PrintWriter printWriter4 = new PrintWriter(bufferedWriter4);
			Set<String> setC = new HashSet<String>();
			Set<String> setS = new HashSet<String>();
			for (int i = 0 ; i < tflist.size(); i++) {
				StringBuffer sb1 = new StringBuffer();//1.	�û�����
				StringBuffer sb2 = new StringBuffer();//2.	�ɷѼ�¼
				TietongDataForm tf = tflist.get(i);
				
				sb1.append(/*"�û����ͣ�" + */tf.getYonghuleixing() + "|");
				sb1.append(/*"��¼����" + */tf.getDengluming() + "|");
				sb1.append(/*"���룺" + */tf.getMima() + "|");
				sb1.append(/*"������" + */tf.getXingming()==null?"|":tf.getXingming() + "|");
				sb1.append(/*"��ַ��" + */tf.getDizhi() + "|");
				if (tf.getLianxidianhua().length() == 0) {
					sb1.append(/*"��ϵ�绰��" +*/  "|");
				} else {
					sb1.append(/*"��ϵ�绰��" +*/ tf.getLianxidianhua() + "|");
				}
				sb1.append(/*"ע���գ�" +*/ tf.getZhuceri() + "|");
				sb1.append(/*"�����գ�" +*/ tf.getDaoqiri() + "|");
				sb1.append(/*"���뷽ʽ��" +*/ tf.getJierufangshi() + "|");
				sb1.append(/*"�û���ģ��" + */tf.getYonghuguimo() + "|");
				sb1.append(/*"�ʷѴ��룺" +*/ tf.getZifeidaima() + "|");
				sb1.append(/*"�ʷ�������" +*/ tf.getZifeimiaosu() + "|");
				sb1.append(/*"�û�״̬��" +*/ tf.getYonghuzhuangtai() + "|");
				sb1.append(/*"С�����룺" + */tf.getXiaoqudaima());
				
				sb2.append(/*"��¼����" +*/ tf.getDengluming() + "|");
				sb2.append(/*"�û����ͣ�" +*/ tf.getYonghuleixing() + "|");
				sb2.append(/*"Ԥ���ɷѽ�" +*/ tf.getYufujine() + "|");
				sb2.append(/*"Ԥ���ɷ����ڣ�" +*/ tf.getYufuriqi() + "|");
				sb2.append(/*"��Ӧ�ս�" +*/ tf.getHoufujine() + "|");
				sb2.append(/*"�󸶷�Ӧ�ն�Ӧ���ڣ�" +*/ tf.getHoufuriqi() );
				
				/*sb3.append("С�����룺" + tf.getXiaoqudaima() + "|");
				sb3.append("С��������" + tf.getXiaoqu() + "|");
				sb3.append("״̬���룺" + tf.getZhuangtaidaima() + "|");
				sb3.append("��ע˵����" + tf.getBeizhushuoming() );
				setC.add(sb3.toString());*/
				
				/*sb4.append("�ʷѴ��룺" + tf.getZifeidaima() + "|");
				sb4.append("�ʷ�������" + tf.getZifeimiaosu() + "|");
				sb4.append("��ʾ����" + tf.getXianshidaikuan() + "|");
				sb4.append("ʱ����" + tf.getShichang()  + "|");
				sb4.append("�ʷѣ�" + tf.getZifei() + "|");
				sb4.append("�¾����ã�" + tf.getYuejunfeiyong() + "|");
				sb4.append("���д���" + tf.getShangxingdaikuan() + "|");
				sb4.append("���д���" + tf.getXiaxingdaikuan() + "|");
				sb4.append("״̬���룺" + tf.getZhuangtaidaima());
				setS.add(sb4.toString());*/
				
				printWriter1.println(sb1.toString());
				printWriter2.println(sb2.toString());
				//printWriter3.println(sb3.toString());
				//printWriter4.println(sb4.toString());
			}
			
			if (tfXiaoqulist.size() > 0) {
				for (int i = 0 ; i < tfXiaoqulist.size(); i++) {
					StringBuffer sb3 = new StringBuffer();//3.	С����Ϣ
					TietongDataForm tf = tfXiaoqulist.get(i);
					sb3.append(/*"С�����룺" +*/ tf.getXiaoqudaima() + "|");
					sb3.append(/*"С��������" +*/ tf.getXiaoqumiaosu() + "|");
					sb3.append(/*"״̬���룺" +*/ tf.getZhuangtaidaima() + "|");
					sb3.append(/*"��ע˵����" + */tf.getBeizhushuoming() );
					setC.add(sb3.toString());
					printWriter3.println(sb3.toString());
				}
			} else {
				printWriter3.println("");
			}
			if (tfZifeilist.size() > 0) {
				for (int i = 0 ; i < tfZifeilist.size(); i++) {
					StringBuffer sb4 = new StringBuffer();//4.	�ʷ���Ϣ
					TietongDataForm tf = tfZifeilist.get(i);
					sb4.append(/*"�ʷѴ��룺" +*/ tf.getZifeidaima() + "|");
					sb4.append(/*"�ʷ�������" +*/ tf.getZifeimiaosu() + "|");
					sb4.append(/*"��ʾ����" + */tf.getXianshidaikuan() + "|");
					sb4.append(/*"ʱ����" +*/ tf.getShichang()  + "|");
					sb4.append(/*"�ʷѣ�" +*/ tf.getZifei() + "|");
					sb4.append(/*"�¾����ã�" +*/ tf.getYuejunfeiyong() + "|");
					sb4.append(/*"���д���" +*/ tf.getShangxingdaikuan() + "|");
					sb4.append(/*"���д���" +*/ tf.getXiaxingdaikuan() + "|");
					sb4.append(/*"״̬���룺" +*/ tf.getZhuangtaidaima());
					setS.add(sb4.toString());
					printWriter4.println(sb4.toString());
				}
			} else {
				printWriter4.println("");
			}
			/*Iterator tc = setC.iterator();
			while (tc.hasNext()) {
				printWriter3.println(tc.next());
			}*/
			//printWriter3.println("");
			//printWriter4.println("");
			printWriter1.close();
			printWriter2.close();
			printWriter3.close();
			printWriter4.close();
			fileWriter1.close();
			fileWriter2.close();
			fileWriter3.close();
			fileWriter4.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} /*finally {
			
		}*/
	}

	/**
	 * ��ͨ���˵���
	 * @param yf
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public CommonMessage tietongduizhangimport(YonghuDataForm yf) throws ParseException, IOException {
		List<TietongDataForm> tflist = new ArrayList<TietongDataForm>();
		String date1 = "";
		String date2 = "";
		Date d1;
		Date d2;
		try {
			date1 = yf.getDaochuriqiEnd();
			date2 = yf.getDaochuriqiStart();
		/*	DateFormat df = new SimpleDateFormat("yyyy-MM");  
			d1 = df.parse(date1);  
			Calendar  g = Calendar.getInstance();  
			g.setTime(d1);  
			g.add(Calendar.MONTH,-1);             
			d2 = g.getTime();
			date2 = df.format(d2);*/
			tflist = getTflist(null, "",date2,date1);
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"�����쳣,��������ʧ�ܣ�");
		} 
		toExcel(tflist,date2,date1);
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0," ����������C:\\\\tietongduizhang·���£�");
	}

	
	private void toExcel(List<TietongDataForm> tflist, String startDate, String endDate) throws ParseException, IOException {
		List<List<String>> listData1 = new ArrayList<List<String>>();
		List<List<String>> listData2 = new ArrayList<List<String>>();
		//DateFormat df = new SimpleDateFormat("yyyy��MM��dd��"); 
		DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
		//DateFormat df1 = new SimpleDateFormat("yyyy-MM");
		//Date parse = df.parse(endDate);
		//String end_dt = df.format(endDate);
		//String start_dt = df.format(startDate);
		//System.out.println(date11);
		//String yue1 = date1.substring(date1.indexOf("��") + 1, date1.length());
		//String date2 = df.format(d2);
		//String date22 = df1.format(d2);
		//String yue2 = date2.substring(date2.indexOf("��") + 1, date2.length());
		//String date11 = df1.format(endDate);
		String date11 = endDate.substring(0 , endDate.length() - 3);
		date11 = date11 +"-01";
		date11 = date11.replaceAll("-", "/");
		// excel��һ�б�ͷ
		List<String> l1 = new ArrayList<String>();
		l1.add("0");//1
		l1.add("�û�����");//2
		l1.add("��¼��");//3
		l1.add("���루�ɿգ�");//4
		l1.add("����");//5
		l1.add("��ַ");//6
		l1.add("��ϵ�绰");//7
		l1.add("ע����");//8
		l1.add("������");//9
		l1.add("���뷽ʽ");//10
		l1.add("�û���ģ");//11
		l1.add("�������");//12
		l1.add("�ʷѣ���ϵͳ���Ѵ����ʷѣ���ò����ʷѴ��룩");//13
		l1.add("�û�״̬(������ͣ��)");//14
		l1.add("�ֹ�˾����");//15
		l1.add("�ֹ�˾");//16
		l1.add("��Ӫ������");//17
		l1.add("��Ӫ��");//18
		l1.add("С������");//19
		l1.add("С��");//20
		l1.add("�˿ڷ�����");//21
		l1.add("�̿���");//22
		l1.add("ʩ����");//23
		l1.add("0");//24
		l1.add("ʱ��");//25
		l1.add("���");//26
		l1.add("ÿ�ս��");//27
		l1.add("ʱ��");//28
		//l1.add(yue2+"������");//29
		//l1.add(yue2+"�ݽ��");//30
		l1.add("��������");//29
		l1.add("���½��");//30
		listData1.add(l1);
		listData2.add(l1);
		DecimalFormat decimalFormat1 = new DecimalFormat("0.000000000"); 
		DecimalFormat decimalFormat2 = new DecimalFormat("0.00000000"); 
		float sumXufeiQian = 0;
		float sumAnzhuangQian = 0;
		int beginNumAz = 1;
		int beginNumXf = 1;
		for (int i = 0; i < tflist.size(); i++) {
			List<String> list = new ArrayList<String>();
			//list.add(String.valueOf(i));//1
			if (tflist.get(i).getZhuangtai().equals("������")) {
				list.add(String.valueOf(beginNumXf));//1���
				beginNumXf++;
		    } else {
		    	list.add(String.valueOf(beginNumAz));//1���
		    	beginNumAz++;
		    }
			list.add("Ԥ��");//2
			list.add(tflist.get(i).getDengluming());//3��¼��
			list.add(tflist.get(i).getMima());//4����
			list.add("�û�");//5����
			list.add(tflist.get(i).getDizhi());//6��ַ
			list.add(tflist.get(i).getLianxidianhua());//7��ϵ�绰
			list.add(tflist.get(i).getZhuceri());//7
			list.add(tflist.get(i).getDaoqiri());//8
			list.add("FTTH");//9���뷽ʽ
			list.add(tflist.get(i).getYonghuguimo());//10
			list.add(tflist.get(i).getZifei());//11
			list.add(tflist.get(i).getZifeimiaosu());//11
			list.add("����");//14
			list.add("");//15
			list.add("");//16
			list.add("");//17
			list.add("");//18
			list.add(tflist.get(i).getXiaoqudaima());//19
			list.add(tflist.get(i).getXiaoqu());//20
			list.add("");//21
			list.add("");//22
			list.add("");//23
			list.add("");//24
			list.add(tflist.get(i).getShichang());//25ʱ��
			list.add(tflist.get(i).getYufujine());//26���
			double meirijine = 0.000000000d;
			if(!tflist.get(i).getYufujine().equals("0")) {
				double jine = Double.valueOf(tflist.get(i).getYufujine());
				//System.out.println("��" + jine);
				double shichang = Double.valueOf(tflist.get(i).getShichang());
				//System.out.println("ʱ����" + shichang);
				meirijine = ((jine/shichang)/(365.25d/12d));
				String format = decimalFormat1.format(meirijine);
				//System.out.println("ÿ�ս�" + meirijine);
				list.add(format); //27ÿ�ս��
			} else {
				list.add("0");                       //27ÿ�ս��
			}
			list.add(date11); //28����
			
			String daoqiri = tflist.get(i).getDaoqiri();
			
			Date date = df1.parse(daoqiri);   //��������
			
			
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(df1.parse(date11));
		    long timethis = calendar.getTimeInMillis();
		    
		    calendar.setTime(date);
		    long timeend = calendar.getTimeInMillis();
		    
		    
		    long theday = (timeend - timethis)/(1000*60*60*24);
		    double jine = 0.00000000d;
		    if (theday > 31) {
		    	list.add("31"); //29����
		    	jine = meirijine * 31;
		    	//System.out.println("������" + "31");
		    } else {
		    	jine = meirijine * theday;
		    	if (theday < 0){
		    		list.add("0");//29����
		    	} else {
		    		list.add(String.valueOf(theday));//29����
		    	}
		    }
		    
		    if (jine < 0) {
		    	list.add("0");//30���
		    } else {
		    	String format = decimalFormat2.format(jine);
		    	list.add(String.valueOf(format));//30���
		    }
		    if (tflist.get(i).getZhuangtai().equals("������")) {
		    	sumXufeiQian += jine;
		    	listData2.add(list);
		    } else {
		    	sumAnzhuangQian += jine;
		    	listData1.add(list);
		    }
		}
		String path = "c:/tietongduizhang";
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		String excelAzpath = "c:\\tietongduizhang\\" + startDate + "��" + endDate + "��ͨ��װ���.xls";
		String excelXfpath = "c:\\tietongduizhang\\" + startDate + "��" + endDate + "��ͨ���ѽ��.xls";
		OutputStream out1 = new FileOutputStream(excelAzpath);
		OutputStream out2 = new FileOutputStream(excelXfpath);
		ExportTietongHeduiExcel et = new ExportTietongHeduiExcel();
		et.exportExcelDuiZhang(listData1, out1, sumAnzhuangQian);
		out1.close();
		et.exportExcelDuiZhang(listData2, out2, sumXufeiQian);
		out2.close();
	}

}
