package com.stock.huidan;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
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
import com.stock.yonghushuju.ImportService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class ImporHuidanDataService extends BusinessService {
	private Log log = LogFactory.getLog(this.getClass());
	private ImportService service = new ImportService();
	private CommonDao dao = new CommonDao();
	private String check_huidan="";
	private String pattern = "\\d{6}";
	
	public List<HuidanEntityForm> parse(InputStream input) throws Exception {
		List<HuidanEntityForm> list = new ArrayList<HuidanEntityForm>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		DataSet<DataRow> xiaoqus = dao.executeQuery("getcode1", new ParameterSet());
		
		int i = 1;// ��excel��һ�п�ʼȡ����
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			HuidanEntityForm huidanentity = new HuidanEntityForm();
			String[] values = service.convertRow(hssfRow, 36);// excel ��ȡ������
			if(!values[2].matches(pattern) || !values[3].matches(pattern)){
				check_huidan = "error1";
				break;
			}
			for(int x=0;x<values.length;x++){
				if(values[x] == null){
					check_huidan = "error2";
					break;
				}
			}
			if(!("����װ��".equals(values[33])||"���ƻ���".equals(values[33])||"����·�иġ�".equals(values[33]))){
				check_huidan = "error4";
				break;
			}
			for (int m = 0; m < xiaoqus.size(); m++) {
				check_huidan = "error3";
				if (xiaoqus.get(m).getDataElement("xiaoqu").getString().equals(values[4])) {
					check_huidan = "";
					break;
				} 
			}
//			String a  = values[0].substring(0, 2);
//			String b  = values[0].substring(2, 4);
//			String c  = values[0].substring(4, 6);
//			String a1 = values[1].substring(0, 2);
//			String a2 = values[1].substring(2, 4);
//			String a3 = values[1].substring(4, 6);
			huidanentity.setXingming(values[0]);
			huidanentity.setShenfenzheng(values[1]);
			huidanentity.setKaijishijian(values[2]);//����ʱ��
			huidanentity.setTingjishijian(values[3]);//ͣ��ʱ��
			huidanentity.setYouxiaoshijian(values[3]);//��Чʱ��
			huidanentity.setXiaoqu(values[4]);//С��
			huidanentity.setDizhi(values[5]);//��ַ
			huidanentity.setLianxidianhua(values[6]);//��ϵ�绰
			huidanentity.setWangluo(values[7]);//����
			huidanentity.setDianshi(values[8]);//����
			huidanentity.setDianhua(values[9]);//�绰
			huidanentity.setYewu(values[10]);//ҵ��
			huidanentity.setFenguang(values[11]);//�ֹ�
			huidanentity.setOnuMAC(values[12]);//MAC
			huidanentity.setSTB_MCID(values[13]);//MCID
			huidanentity.setDianshiIP(values[14]);//����IP
			huidanentity.setWangluoIP(values[15]);//����IP
			huidanentity.setDianhuaIP(values[16]);//�绰IP
			huidanentity.setDianhuaVLAN(values[17]);//�绰VLAN
			huidanentity.setWangluoVLAN(values[18]);//����VLAN
			huidanentity.setShangmenshijian(values[19]);//����ʱ��
			huidanentity.setDanzheng(values[20]);//��֤
			huidanentity.setSuoxuandianhua(values[21]);// ��ѡ�绰����
			huidanentity.setOnuyj(values[22]);//onuѺ��
			huidanentity.setJidingheyj(values[23]);//������Ѻ��
			huidanentity.setShoushifei(values[24]);//���ӷ�
			huidanentity.setKuandaifei(values[25]);//�����
			huidanentity.setChuzhuangfei(values[26]);//��װ��
			huidanentity.setShebeixiaoshoufei(values[27]);//�豸���۷�
			huidanentity.setCailiaofei(values[28]);//���Ϸ�
			huidanentity.setYunyingshang(values[29]);//��Ӫ��
			huidanentity.setBzygf(values[30]);//�����¹���
			huidanentity.setNianfei(values[31]);//���
			huidanentity.setBeizhu(values[32]);//��ע
			huidanentity.setXianghao(values[33]);//���
			huidanentity.setJidinghehao(values[34]);//�����к�
			huidanentity.setYewutype(values[33]);
			list.add(huidanentity);
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
		List<HuidanEntityForm> list = new ArrayList<HuidanEntityForm>();

		try {
			list = parse(input);
			if (check_huidan.equals("error1")) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"���ڸ�ʽ��������");
			} else if (check_huidan.equals("error2")) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"��ʽ��������");
			} else if (check_huidan.equals("error3")) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"С���������ڣ�������������룡");
			} else if (check_huidan.equals("error4")) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"��װ���Ͳ���ȷ��������������룡");
			} else if (null == list || list.size() == 0) {
				return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.UP_DATA_ERROR);
		}

		try {
			openTransaction();
			// int i = 1;
			for (HuidanEntityForm huidan : list) {
				// ����У��
				//String error = validator.insertValidate(pgd);
				/*
				 * if(error != null) { return new CommonMessage(error,
				 * String.valueOf(i)); }
				 */
				// getUserInfo().getEmployeeName()
				// Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss")
				ParameterModel m = new ParameterModel();
				m.put("xingming", huidan.getXingming());
				m.put("shenfenzheng", huidan.getShenfenzheng());
				m.put("kaijishijian", huidan.getKaijishijian());
				m.put("tingjishijian", huidan.getTingjishijian());
				m.put("youxiaoshijian", huidan.getYouxiaoshijian());
				m.put("xiaoqu", huidan.getXiaoqu());
				m.put("dizhi", huidan.getDizhi());
				m.put("lianxidianhua", huidan.getLianxidianhua());
				m.put("wangluo", huidan.getWangluo());
				m.put("dianshi", huidan.getDianshi());
				m.put("dianhua", huidan.getDianhua());
				m.put("yewu", huidan.getYewu());
				m.put("fenguang", huidan.getFenguang());
				m.put("onumac", huidan.getOnuMAC());
				m.put("stbmcid", huidan.getSTB_MCID());
				m.put("dianshiip", huidan.getDianshiIP());
				m.put("wangluoip", huidan.getWangluoIP());
				m.put("dianhuaip", huidan.getDianhuaIP());
				m.put("dianhuavlan", huidan.getDianhuaVLAN());
				m.put("wangluovlan", huidan.getWangluoVLAN());
				m.put("shangmenshijian", huidan.getShangmenshijian());
				m.put("danzheng", huidan.getDanzheng());
				m.put("sxdhhm", huidan.getSuoxuandianhua());
				m.put("onuyj", huidan.getOnuyj());
				m.put("jidingheyj", huidan.getJidingheyj());
				m.put("shoushifei", huidan.getShoushifei());
				m.put("kuandaifei", huidan.getKuandaifei());
				m.put("chuzhuangfei", huidan.getChuzhuangfei());
				m.put("shebeixiaoshou", huidan.getShebeixiaoshoufei());
				m.put("cailiaofei", huidan.getCailiaofei());
				m.put("yunyingshang", huidan.getYunyingshang());
				m.put("bzygf", huidan.getBzygf());
				m.put("nianfei", huidan.getNianfei());
				m.put("beizhu", huidan.getBeizhu());
				m.put("beizhuhuizong", huidan.getXianghao()+"/"+huidan.getJidinghehao());
				m.put("createby", getUserInfo().getEmployeeName());
				m.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				m.put("yewutype", huidan.getYewutype());
				
				String wangluo = huidan.getWangluo();
				String dianshi = huidan.getDianshi();
				String dianhua = huidan.getDianhua();
				if((!checkEmpty(wangluo)&&checkEmpty(dianshi)&&checkEmpty(dianhua))||(checkEmpty(wangluo)&&!checkEmpty(dianshi)&&checkEmpty(dianhua))||(checkEmpty(wangluo)&&checkEmpty(dianshi)&&!checkEmpty(dianhua))) {
					dao.insert("huidandata", m);
				}else{
					if(!checkEmpty(wangluo)) {
						ParameterModel m1 = new ParameterModel();
						m1.putAll(m);
//						m1.put("wangluo", "0");
//						m1.put("wangluoip", "0");
//						m1.put("kuandaifei", "0");
						
						m1.put("dianshi", "");
						m1.put("stbmcid", "");
						m1.put("dianshiip", "");
						m1.put("dianhuaip", "");
						m1.put("jidingheyj", "0");
						m1.put("shoushifei", "0");
						if (!checkEmpty(dianshi)) {
							m1.put("shebeixiaoshou", "0");
						}
						
						m1.put("dianhua", "");
						m1.put("dianhuaip", "");
						m1.put("bzygf", "0");
						m1.put("nianfei", "0");
						dao.insert("huidandata", m1);
						
						m.put("onuyj", "0");
						m.put("chuzhuangfei","0");
						m.put("cailiaofei", "0");
						if (checkEmpty(dianshi)) {
							m.put("shebeixiaoshou", "0");
						}
					}
					if (!checkEmpty(dianshi)) {
						ParameterModel m2 = new ParameterModel();
						m2.putAll(m);
						m2.put("wangluo", "");
						m2.put("wangluoip", "");
						m2.put("kuandaifei", "0");
						
//						m2.put("dianshi", "0");
//						m2.put("stbmcid", "0");
//						m2.put("dianshiip", "0");
//						m2.put("dianhuaip", "0");
//						m2.put("jidingheyj", "0");
//						m2.put("shoushifei", "0");
//						m2.put("shebeixiaoshou", "0");
						
						m2.put("dianhua", "");
//						m2.put("dianhuaip", "0");
						m2.put("bzygf", "0");
						m2.put("nianfei", "0");
						dao.insert("huidandata", m2);
						
						m.put("onuyj", "0");
						m.put("chuzhuangfei","0");
						m.put("cailiaofei", "0");
						m.put("shebeixiaoshou", "0");
					}
					if (!checkEmpty(dianhua)) {
						ParameterModel m3 = new ParameterModel();
						m3.putAll(m);
						m3.put("wangluo", "");
						m3.put("wangluoip", "");
						m3.put("kuandaifei", "0");
						
						m3.put("dianshi", "");
						m3.put("stbmcid", "");
						m3.put("dianshiip", "");
//						m3.put("dianhuaip", "0");
						m3.put("jidingheyj", "0");
						m3.put("shoushifei", "0");
						m3.put("tingjishijian", "2019-02-02");
//						m3.put("dianhua", "0");
//						m3.put("dianhuaip", "0");
//						m3.put("bzygf", "0");
//						m3.put("nianfei", "0");
						dao.insert("huidandata", m3);
					}
				}
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			return new CommonMessage(ErrorConstant.PGD_DATA_ERROR);
		}
		return new CommonMessage(Constant.SUCCESS);
	}
	/**
	 * ����Ϊ��ʱ����true
	 */
	private boolean checkEmpty(String content) {
		if(content==null||"".equals(content)||" ".equals(content)||"��".equals(content)||"0".equals(content)) {
			return true;
		}
		return false;
	}
}
