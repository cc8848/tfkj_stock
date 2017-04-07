package com.stock.huidan;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.webService.WebServiceMethods;
import com.webService.service.UserManage;

public class HuidanService extends BusinessService {
    private Log log = LogFactory.getLog(this.getClass());
    private CommonDao dao = new CommonDao();

    /**
     * ��Ʊ��� �ύ��Ϣ1
     */
    public void get_1(HuidanForm f) {
	/*
	 * 1 onuѺ�� 2 ������Ѻ�� 3 ���ӷ� 4 ����� 5 ��װ�� 6 �豸���۷� 7 ���Ϸ� 8 �����¹��� 9 ���
	 */
	if (f.getChecks() != null) {
	    String[] a = f.getChecks();
	    for (int i = 0; i < a.length; i++) {
		switch (Integer.parseInt(a[i])) {
		case 1:
		    f.setZongshoufei(Integer.parseInt(f.getZongshoufei()) - Integer.parseInt(f.getOnuyj()) + "");
		    f.setOnuyj("0");
		    break;
		case 2:
		    f.setZongshoufei(Integer.parseInt(f.getZongshoufei()) - Integer.parseInt(f.getJidingheyj()) + "");
		    f.setJidingheyj("0");
		    break;
		case 3:
		    f.setZongshoufei(Integer.parseInt(f.getZongshoufei()) - Integer.parseInt(f.getShoushifei()) + "");
		    f.setShoushifei("0");
		    break;
		case 4:
		    f.setZongshoufei(Integer.parseInt(f.getZongshoufei()) - Integer.parseInt(f.getKuandaifei()) + "");
		    f.setKuandaifei("0");
		    break;
		case 5:
		    f.setZongshoufei(Integer.parseInt(f.getZongshoufei()) - Integer.parseInt(f.getChuzhuangfei()) + "");
		    f.setChuzhuangfei("0");
		    break;
		case 6:
		    f.setZongshoufei(Integer.parseInt(f.getZongshoufei()) - Integer.parseInt(f.getShebeixiaoshoufei()) + "");
		    f.setShebeixiaoshoufei("0");
		    break;
		case 7:
		    f.setZongshoufei(Integer.parseInt(f.getZongshoufei()) - Integer.parseInt(f.getCailiaofei()) + "");
		    f.setCailiaofei("0");
		    break;
		case 8:
		    f.setZongshoufei(Integer.parseInt(f.getZongshoufei()) - Integer.parseInt(f.getBzygf()) + "");
		    f.setBzygf("0");
		    break;
		case 9:
		    f.setZongshoufei(Integer.parseInt(f.getZongshoufei()) - Integer.parseInt(f.getNianfei()) + "");
		    f.setNianfei("0");
		    break;
		}
	    }
	}

    }

    /**
     * ��Ʊ��� �ύ��Ϣ2
     */
    public void get_2(HuidanForm f) {
	boolean onu = true;
	boolean ji = true;
	boolean shou = true;
	boolean kuan = true;
	boolean chu = true;
	boolean she = true;
	boolean cai = true;
	boolean bu = true;
	boolean nian = true;
	if (f.getChecks() != null) {
	    String[] a = f.getChecks();
	    int count = 0;
	    for (int i = 0; i < a.length; i++) {
		switch (Integer.parseInt(a[i])) {
		case 1:
		    count += Integer.parseInt(f.getOnuyj());
		    onu = false;
		    break;
		case 2:
		    count += Integer.parseInt(f.getJidingheyj());
		    ji = false;
		    break;
		case 3:
		    count += Integer.parseInt(f.getShoushifei());
		    shou = false;
		    break;
		case 4:
		    count += Integer.parseInt(f.getKuandaifei());
		    kuan = false;
		    break;
		case 5:
		    count += Integer.parseInt(f.getChuzhuangfei());
		    chu = false;
		    break;
		case 6:
		    count += Integer.parseInt(f.getShebeixiaoshoufei());
		    she = false;
		    break;
		case 7:
		    count += Integer.parseInt(f.getCailiaofei());
		    cai = false;
		    break;
		case 8:
		    count += Integer.parseInt(f.getBzygf());
		    bu = false;
		    break;
		case 9:
		    count += Integer.parseInt(f.getNianfei());
		    nian = false;
		    break;
		}
	    }
	    f.setZongshoufei(count + "");
	    if (onu) {
		f.setOnuyj("0");
	    }
	    if (ji) {
		f.setJidingheyj("0");
	    }
	    if (shou) {
		f.setShoushifei("0");
	    }
	    if (kuan) {
		f.setKuandaifei("0");
	    }
	    if (chu) {
		f.setChuzhuangfei("0");
	    }
	    if (she) {
		f.setShebeixiaoshoufei("0");
	    }
	    if (cai) {
		f.setCailiaofei("0");
	    }
	    if (bu) {
		f.setBzygf("0");
	    }
	    if (nian) {
		f.setNianfei("0");
	    }
	}
    }

    /**
     * �ص�����-��Ʊ���֮�������ݿ��в����¼
     * 
     * @return
     */
    public void get_into(HuidanForm f, HttpServletRequest request, String life_to, String stats) throws Exception {
	String name = getUserInfo(request).getEmployeeName();
	String time = Common.formatDate(new Date(), "yyyy/MM/dd");
	try {
	    openTransaction();

	    ParameterModel m = new ParameterModel();
	    m.put("Lifecycle_sta", life_to);
	    m.put("yonghuzhuangtai", stats);
	    m.put("xingming", f.getXingming());
	    m.put("shenfenzheng", f.getShenfenzheng());
	    m.put("shoujuhao", f.getFeikaipiaoshouju());
	    m.put("fenguangxianhao", f.getFenguangxianhao());
	    m.put("jiexuweizhi", f.getJiexuweizhi());
	    m.put("kaijishijian", f.getKaijis());
	    m.put("tingjishijian", f.getKaijis());
	    m.put("xiaoqu", f.getXiaoqu());
	    m.put("dizhi", f.getDizhi());
	    m.put("lianxidianhua", f.getTelNoCode());
	    m.put("wangluo", "0");
	    m.put("dianshi", "����");
	    m.put("dianhua", "0");
	    m.put("yewu", "���ò��");
	    m.put("fenguang", f.getFenguang());
	    m.put("onumac", f.getOnuCode());
	    m.put("stbmcid", f.getMcidCode());
	    m.put("dianshiip", f.getDianshiip());
	    m.put("wangluoip", f.getWangluoip());
	    m.put("dianhuaip", f.getDianhuaip());
	    m.put("dianhuavlan", f.getDianhuavlan());
	    m.put("wangluovlan", f.getWangluovlan());
	    m.put("shangmenshijian", f.getShangmenshijian());
	    m.put("danzheng", f.getDanzheng());
	    m.put("sxdhhm", f.getSxdhhm());
	    m.put("onuyj", f.getOnuyj());
	    m.put("jidingheyj", f.getJidingheyj());
	    m.put("shoushifei", f.getShoushifei());
	    m.put("kuandaifei", f.getKuandaifei());
	    m.put("chuzhuangfei", f.getChuzhuangfei());
	    m.put("yunyingshang", f.getYunyingshang());
	    m.put("bzygf", f.getBzygf());
	    m.put("nianfei", f.getNianfei());
	    m.put("beizhu", f.getBeizhu());
	    m.put("zongshoufei", f.getZongshoufei());
	    m.put("shoujubenhao", f.getFeikaipiaoshouju());
	    m.put("qtsbsyqk", f.getQtsbsyqk());
	    m.put("qitahaocai", "0");
	    m.put("jiexianzi", "0");
	    m.put("rj11", "0");
	    m.put("rj45", "0");
	    m.put("mokuai", "0");
	    m.put("mianban", "0");
	    m.put("wangxian", "0");
	    m.put("shigongren", "0");
	    m.put("xianchangbeizhu", f.getXianchangbeizhu());
	    m.put("beizhuhuizong", f.getBeizhuhuizong());
	    m.put("createby", name);
	    m.put("createdt", time);
	    m.put("shebeixiaoshou", f.getShebeixiaoshoufei());
	    m.put("cailiaofei", f.getCailiaofei());
	    m.put("kaipiaoxinxi", "0");
	    m.put("pipeizhuangtai", f.getPipeizhuangtai());
	    m.put("shoukuanshijian", f.getShoukuanshijian());

	    dao.insert("huidandata", m);
	    commit();
	} catch (Exception e) {
	    rollback();
	    e.printStackTrace();
	}

    }

    public void update_into(HuidanForm f, HttpServletRequest request, String stats, String life_to) throws Exception {
	ParameterSet set = new ParameterSet();
	String name = getUserInfo(request).getEmployeeName();
	String time = Common.formatDate(new Date(), "yyyy/MM/dd");

	try {
	    openTransaction();
	    set.add("uuid", "@uuid", f.getUUID());
	    set.add("lifecycle_sta", "@lifecycle_sta", life_to);
	    set.add("yonghuzhuangtai", "@yonghuzhuangtai", stats);
	    set.add("shoujuhao", "@shoujuhao", f.getKaipiaoshouju());
	    set.add("shoujubenhao", "@shoujubenhao", f.getKaipiaoshouju());
	    set.add("createby", "@createby", name);
	    set.add("createdt", "@createdt", time);

	    set.add("zongshoufei", "@zongshoufei", f.getZongshoufei());
	    set.add("onuyj", "@onuyj", f.getOnuyj());
	    set.add("jidingheyj", "@jidingheyj", f.getJidingheyj());
	    set.add("shoushifei", "@shoushifei", f.getShoushifei());
	    set.add("kuandaifei", "@kuandaifei", f.getKuandaifei());
	    set.add("chuzhuangfei", "@chuzhuangfei", f.getChuzhuangfei());
	    set.add("shebeixiaoshoufei", "@shebeixiaoshoufei", f.getShebeixiaoshoufei());
	    set.add("cailiaofei", "@cailiaofei", f.getCailiaofei());
	    set.add("bzygf", "@bzygf", f.getBzygf());
	    set.add("nianfei", "@nianfei", f.getNianfei());
	    dao.execute("chaifen_update", set);
	    commit();
	} catch (Exception e) {
	    rollback();
	    e.printStackTrace();
	}
    }

    /**
     * ����UUID�����û�״̬
     * 
     * @param f
     * @return
     * @throws Exception
     */
    public String get_yonghuzhuangtai(HuidanForm f) throws Exception {
	String s = "";
	ParameterSet set = new ParameterSet();
	set.add("uuid", "@uuid", f.getUUID());
	DataRow r = dao.executeQueryToDataRow("yonghuzhuangtai", set);
	s = r.getDataElement("stats").getString();
	return s;
    }

    /**
     * �˻ػص�
     * 
     * @param f
     * @param request
     * @param stats
     * @param life_to
     * @return
     * @throws Exception
     */
    public String tuihui(HuidanForm f, HttpServletRequest request, String stats, String life_to) throws Exception {
	String name = getUserInfo(request).getEmployeeName();
	String time = Common.formatDate(new Date(), "yyyy/MM/dd");
	try {
	    openTransaction();
	    ParameterSet set = new ParameterSet();
	    set.add("yonghuzhuangtai", "@yonghuzhuangtai", stats);
	    set.add("lifecycle_sta", "@lifecycle_sta", life_to);
	    set.add("updateby", "@updateby", name);
	    set.add("updatedt", "@updatedt", time);
	    set.add("uuid", "@uuid", f.getUUID());
	    dao.execute("tuihui", set);
	    commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    rollback();
	}
	return Constant.SUCCESS;
    }

    /**
     * �ύ�ص���update
     * 
     * @param f
     * @param request
     * @param life_to
     * @return
     * @throws Exception
     */
    public String update_tijiao(HuidanForm f, HttpServletRequest request, String stats, String life_to) throws Exception {
	String name = getUserInfo(request).getEmployeeName();
	String time = Common.formatDate(new Date(), "yyyy/MM/dd HH:mm:ss");
	String huizong = "";
	if (stats.equals("������")) {
	    huizong = f.getChayimiaoshu();
	}
	if (stats.equals("��Ʊ���")) {
	    huizong = f.getKaipiaochaifen();
	}
	try {
	    openTransaction();
	    ParameterSet set = new ParameterSet();
	    set.add("yonghuzhuangtai", "@yonghuzhuangtai", stats);
	    set.add("pipeizhuantai", "@pipeizhuangtai", "δƥ��");
	    set.add("lifecycle_sta", "@lifecycle_sta", life_to);
	    set.add("updateby", "@updateby", name);
	    set.add("updatedt", "@updatedt", time);
	    set.add("uuid", "@uuid", f.getUUID());
	    set.add("shigongren", "@shigongren", f.getShigongren());
	    set.add("shoukuangshijian", "@shoukuanshijian", f.getShoukuanshijian());
	    set.add("xingming", "@xingming", f.getXingming());
	    set.add("shenfenzheng", "@shenfenzheng", f.getShenfenzheng());
	    set.add("fenguangxianhao", "@fenguangxianhao", f.getFenguangxianhao() == null ? "" : f.getFenguangxianhao());
	    set.add("jiexuweizhi", "@jiexuweizhi", f.getJiexuweizhi());
	    set.add("zongshoufei", "@zongshoufei", f.getZongshoufei());
	    set.add("shoujubenhao", "@shoujubenhao", f.getShoujubenhao());
	    set.add("shoujuhao", "@shoujuhao", f.getShoujubenhao());
	    set.add("kaipiaoxinxi", "@kaipiaoxinxi", f.getKaipiaoxinxi() == null ? "" : f.getKaipiaoxinxi());
	    set.add("qtsbsyqk", "@qtsbsyqk", f.getQtsbsyqk() == null ? "" : f.getQtsbsyqk());
	    set.add("qitahaocai", "@qitahaocai", f.getQitahaocai() == null ? "" : f.getQitahaocai());
	    set.add("jiexianzi", "@jiexianzi", f.getJiexianzi() == null ? "0" : f.getJiexianzi());
	    set.add("rj11", "@rj11", f.getRj11() == null ? "0" : f.getRj11());
	    set.add("rj45", "@rj45", f.getRj45() == null ? "0" : f.getRj45());
	    set.add("mokuai", "@mokuai", f.getMokuai() == null ? "0" : f.getMokuai());
	    set.add("mianban", "@mianban", f.getMianban() == null ? "0" : f.getMianban());
	    set.add("wangxian", "@wangxian", f.getWangxian() == null ? "0" : f.getWangxian());
	    set.add("beizhuhuizong", "@beizhuhuizong", f.getBeizhuhuizong() == null ? "" : f.getBeizhuhuizong() + "/��дʱ��:" + time + "/��д��:" + name + "/���޳���:" + f.getYouwuchuru() + "/ע:" + huizong);
	    set.add("xianchangbeizhu", "@xianchangbeizhu", f.getXianchangbeizhu() == null ? "" : f.getXianchangbeizhu());
	    dao.execute("zhengcheng_update", set);
	    if((f.getDianshi()!=null&&!"".equals(f.getDianshi())&&!"0".equals(f.getDianshi()))||(f.getWangluo()!=null&&!"".equals(f.getWangluo())&&!"0".equals(f.getWangluo()))) {
	    	int num = dao.executeQueryToCount("queryByhuidandata", set);
	    	if(num==0) {
		    	dao.execute("insertPhotoUploadByhuidandata", set);
		    	dao.execute("initPhotoUploadJtiByhuidandata", set);
	    	}
	    }
	    commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    rollback();
	}
	return Constant.SUCCESS;
    }

    /**
     * �ص���LIST
     * 
     * @param form
     * @param first
     * @param rows
     * @return
     * @throws Exception
     */
    public DataSet<DataRow> getResult(HuidanForm form, int first, int rows, String life) throws Exception {
	ParameterSet set = new ParameterSet();
	if(form.getYonghuzhuangtai_cha()==null||"".equals(form.getYonghuzhuangtai_cha())) {
		set.add("lifecycle_sta", "@lifecycle_sta", life);
	}else if("��ά��".equals(form.getYonghuzhuangtai_cha())||"�˵�".equals(form.getYonghuzhuangtai_cha())||"�Ѱ�װ".equals(form.getYonghuzhuangtai_cha())) {
		set.add("lifecycle_sta", "@lifecycle_sta", "4");
	}else if("���ӵ�δ��".equals(form.getYonghuzhuangtai_cha())||"������".equals(form.getYonghuzhuangtai_cha())) {
		set.add("lifecycle_sta", "@lifecycle_sta", "2");
	}else if("������".equals(form.getYonghuzhuangtai_cha())) {
		set.add("lifecycle_sta", "@lifecycle_sta", "3");
	}
	if (form != null) {
	    if (form.getYonghuzhuangtai_cha() != null) {
		set.add("yonghuzhuangtai", "@yonghuzhuangtai", form.getYonghuzhuangtai_cha());
	    }
	    if (form.getXiaoqu_cha() != null) {
		set.add("xiaoqu", "@xiaoqu", form.getXiaoqu_cha());
	    }
	    if (form.getDizhi_cha() != null) {
		set.add("dizhi", "@dizhi", "%" + form.getDizhi_cha() + "%");
	    }
	    if (form.getShijianleixing() != null && form.getKaijie() != null && form.getTingjie() != null) {
		if (form.getShijianleixing().equals("1")) {
		    set.add("kaijishijian_b", "@kaijishijian_b", form.getKaijie());
		    set.add("kaijishijian_e", "@kaijishijian_e", form.getTingjie());
		}
		if (form.getShijianleixing().equals("2")) {
		    set.add("tingjishijian_b", "@tingjishijian_b", form.getKaijie());
		    set.add("tingjishijian_e", "@tingjishijian_e", form.getTingjie());
		}
		if (form.getShoukuanshijian().equals("3")) {
		    set.add("shoukuanshijian_b", "@shoukuanshijian_b", form.getKaijie());
		    set.add("shoukuanshijian_e", "@shoukuanshijian_e", form.getTingjie());
		}
	    }
	}
	DataSet<DataRow> resultRow = dao.executeQuery("huidanList", set, first, rows);
	for(int i=0;i<resultRow.size();i++) {
		DataRow line = resultRow.get(i);
		if(line.getDataElement("fenguang").getString()!=null&&line.getDataElement("fenguang").getString().equals(line.getDataElement("bdfenguang").getString())) {
			line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("fenguang").getString()+"</font>");
		}else if(line.getDataElement("fenguang").getString()!=null&&line.getDataElement("fenguang").getString().equals(line.getDataElement("yjfenguang").getString())) {
			line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("fenguang").getString()+"</font>");
		}else{
			if(line.getDataElement("fenguangID").getString()==null||"".equals(line.getDataElement("fenguangID").getString())) {
				line.getDataElement("bdfenguang").setColumnValue(line.getDataElement("fenguang").getString());
			}else{
				line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"green\">"+line.getDataElement("fenguang").getString()+"</font>");
			}
		}
		if(line.getDataElement("onumac").getString()!=null&&line.getDataElement("onumac").getString().equals(line.getDataElement("bdonumac").getString())) {
			line.getDataElement("bdonumac").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("onumac").getString()+"</font>");
		}else if(line.getDataElement("onumac").getString()!=null&&line.getDataElement("onumac").getString().equals(line.getDataElement("yjonumac").getString())) {
			line.getDataElement("bdonumac").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("onumac").getString()+"</font>");
		}else{
			line.getDataElement("bdonumac").setColumnValue(line.getDataElement("onumac").getString());
		}
		if(line.getDataElement("stbmcid").getString()!=null&&line.getDataElement("stbmcid").getString().equals(line.getDataElement("bdstbmcid").getString())) {
			line.getDataElement("bdstbmcid").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("stbmcid").getString()+"</font>");
		}else if(line.getDataElement("stbmcid").getString()!=null&&line.getDataElement("stbmcid").getString().equals(line.getDataElement("yjstbmcid").getString())) {
			line.getDataElement("bdstbmcid").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("stbmcid").getString()+"</font>");
		}else{
			line.getDataElement("bdstbmcid").setColumnValue(line.getDataElement("stbmcid").getString());
		}
		if(line.getDataElement("dianshiip").getString()!=null&&line.getDataElement("dianshiip").getString().equals(line.getDataElement("bddianshiip").getString())) {
			line.getDataElement("bddianshiip").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("dianshiip").getString()+"</font>");
		}else if(line.getDataElement("dianshiip").getString()!=null&&line.getDataElement("dianshiip").getString().equals(line.getDataElement("yjdianshiip").getString())) {
			line.getDataElement("bddianshiip").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("dianshiip").getString()+"</font>");
		}else{
			line.getDataElement("bddianshiip").setColumnValue(line.getDataElement("dianshiip").getString());
		}
	}
	return resultRow;
    }

    /**
     * ����2��������������豸�˶�
     * 
     * @param form
     * @param first
     * @param rows
     * @return
     * @throws Exception
     */
    public DataSet<DataRow> getResultHuidanCheck(HuidanForm f, int first, int rows) throws Exception {
    	DataSet<DataRow> resultRow =  dao.executeQuery("GongdanCheckDataInfo", getParameterSetHuiDanHedui(f, "4"), first, rows);
    	for(int i=0;i<resultRow.size();i++) {
    		DataRow line = resultRow.get(i);
    		if(line.getDataElement("fenguang").getString()!=null&&line.getDataElement("fenguang").getString().equals(line.getDataElement("bdfenguang").getString())) {
    			line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("fenguang").getString()+"</font>");
    		}else if(line.getDataElement("fenguang").getString()!=null&&line.getDataElement("fenguang").getString().equals(line.getDataElement("yjfenguang").getString())) {
    			line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("fenguang").getString()+"</font>");
    		}else{
    			if(line.getDataElement("fenguangID").getString()==null||"".equals(line.getDataElement("fenguangID").getString())) {
    				line.getDataElement("bdfenguang").setColumnValue(line.getDataElement("fenguang").getString());
    			}else{
    				line.getDataElement("bdfenguang").setColumnValue("<font style=\"font-weight:bloder;\" color=\"green\">"+line.getDataElement("fenguang").getString()+"</font>");
    			}
    		}
    		if(line.getDataElement("onumac").getString()!=null&&line.getDataElement("onumac").getString().equals(line.getDataElement("bdonumac").getString())) {
    			line.getDataElement("bdonumac").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("onumac").getString()+"</font>");
    		}else if(line.getDataElement("onumac").getString()!=null&&line.getDataElement("onumac").getString().equals(line.getDataElement("yjonumac").getString())) {
    			line.getDataElement("bdonumac").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("onumac").getString()+"</font>");
    		}else{
    			line.getDataElement("bdonumac").setColumnValue(line.getDataElement("onumac").getString());
    		}
    		if(line.getDataElement("stbmcid").getString()!=null&&line.getDataElement("stbmcid").getString().equals(line.getDataElement("bdstbmcid").getString())) {
    			line.getDataElement("bdstbmcid").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("stbmcid").getString()+"</font>");
    		}else if(line.getDataElement("stbmcid").getString()!=null&&line.getDataElement("stbmcid").getString().equals(line.getDataElement("yjstbmcid").getString())) {
    			line.getDataElement("bdstbmcid").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("stbmcid").getString()+"</font>");
    		}else{
    			line.getDataElement("bdstbmcid").setColumnValue(line.getDataElement("stbmcid").getString());
    		}
    		if(line.getDataElement("dianshiip").getString()!=null&&line.getDataElement("dianshiip").getString().equals(line.getDataElement("bddianshiip").getString())) {
    			line.getDataElement("bddianshiip").setColumnValue("<font style=\"font-weight:bloder;\" color=\"blue\">"+line.getDataElement("dianshiip").getString()+"</font>");
    		}else if(line.getDataElement("dianshiip").getString()!=null&&line.getDataElement("dianshiip").getString().equals(line.getDataElement("yjdianshiip").getString())) {
    			line.getDataElement("bddianshiip").setColumnValue("<font style=\"font-weight:bloder;\" color=\"chocolate\">"+line.getDataElement("dianshiip").getString()+"</font>");
    		}else{
    			line.getDataElement("bddianshiip").setColumnValue(line.getDataElement("dianshiip").getString());
    		}
    	}
    	return resultRow;
    }

    public int getResultCountHuidanCheck(HuidanForm form) throws Exception {
	return dao.executeQueryToCount("GongdanCheckDataCount", getParameterSetHuiDanHedui(form, "4"));
    }

    /**
     * ����3�������û� ��ȡ�ص��˶Լ�¼
     * 
     * @param form
     * @param first
     * @param rows
     * @return
     * @throws Exception
     */
    public DataSet<DataRow> getResultHuidan(HuidanForm form, int first, int rows) throws Exception {
	return dao.executeQuery("GongdanCheckDataInfo", getParameterSetHuiDanHedui(form, "5"), first, rows);
    }

    public int getResultCountHuidan(HuidanForm form) throws Exception {
	return dao.executeQueryToCount("GongdanCheckDataCount", getParameterSetHuiDanHedui(form, "5"));
    }
    
    public DataSet<DataRow> getResultAudit(HuidanForm form, int first, int rows) throws Exception {
    	ParameterSet set = new ParameterSet();
    	set.add("yewutype", "@yewutype", "���ƻ���");
    	return dao.executeQuery("HuidanAuditDataInfo",set, first, rows);
        }

        public int getResultCountAudit(HuidanForm form) throws Exception {
        	ParameterSet set = new ParameterSet();
        	set.add("yewutype", "@yewutype", "���ƻ���");
        	return dao.executeQueryToCount("HuidanAuditDataCount", set);
        }
        
        public DataSet<DataRow> getResultAuditQiegai(HuidanForm form, int first, int rows) throws Exception {
        	ParameterSet set = new ParameterSet();
        	set.add("yewutype", "@yewutype", "����·�иġ�");
        	return dao.executeQuery("QiegaiAuditDataInfo",set, first, rows);
            }

            public int getResultCountAuditQiegai(HuidanForm form) throws Exception {
            	ParameterSet set = new ParameterSet();
            	set.add("yewutype", "@yewutype", "����·�иġ�");
            	return dao.executeQueryToCount("QiegaiAuditDataCount", set);
            }

    private ParameterSet getParameterSetHuiDanHedui(HuidanForm form, String string) {
	String shijianleixing = form.getShijianleixing();
	ParameterSet set = new ParameterSet();
	set.add("daihedui", "@daihedui", "���˶�");
	set.add("yirudang", "@yirudang", "���뵵");
	if (!(form.getQuyuCode() == null) && !(form.getQuyuCode().trim().equals(""))) {
	    set.add("xiaoqu", "@xiaoqu", "%" + form.getQuyuCode() + "%");
	}
	if (!(form.getAddressCode() == null) && !(form.getAddressCode().trim().equals(""))) {
	    set.add("dizhi", "@dizhi", "%" + form.getAddressCode() + "%");
	}
	if (shijianleixing.equals("1")) {
	    set.add("kaijis", "@kaijis", form.getSen1());
	    set.add("kaijie", "@kaijie", form.getSen2());
	}
	if (shijianleixing.equals("2")) {
	    set.add("tingjis", "@tingjis", form.getSen1());
	    set.add("tingjie", "@tingjie", form.getSen2());
	}
	if (shijianleixing.equals("3")) {
	    set.add("shoukuanshijians", "@shoukuanshijians", form.getSen1());
	    set.add("shoukuanshijiane", "@shoukuanshijiane", form.getSen2());
	}
	set.add("yonghuzhuangtai", "@yonghuzhuangtai", form.getStateCode());
	set.add("Lifecycle_sta", "@Lifecycle_sta", string);

	return set;
    }

    /**
     * ����3�����û� ��ȡ�ص������¼
     * 
     * @param form
     * @param first
     * @param rows
     * @return
     * @throws Exception
     */
    public DataSet<DataRow> getResultHuidanReview(HuidanForm f, int first, int rows) throws Exception {
	return dao.executeQuery("GongdanCheckDataInfo", getParameterSetHuiDanHeduiReview(f), first, rows);
    }

    public int getResultCountHuidanReview(HuidanForm form) throws Exception {
	return dao.executeQueryToCount("GongdanCheckDataCount", getParameterSetHuiDanHeduiReview(form));
    }

    private ParameterSet getParameterSetHuiDanHeduiReview(HuidanForm form) {
	String shijianleixing = form.getShijianleixing();
	ParameterSet set = new ParameterSet();
	if (!(form.getXiaoqu() == null) && !(form.getXiaoqu().trim().equals(""))) {
	    set.add("xiaoqu", "@xiaoqu", "%" + form.getXiaoqu() + "%");
	}
	if (!(form.getDizhi() == null) && !(form.getDizhi().trim().equals(""))) {
	    set.add("dizhi", "@dizhi", "%" + form.getDizhi() + "%");
	}
	if (!(form.getStateCode() == null) && !(form.getStateCode().trim().equals(""))) {
	    set.add("heduibeizhu", "@heduibeizhu", form.getStateCode());
	}
	if (shijianleixing.equals("1")) {
	    set.add("kaijis", "@kaijis", form.getKaijis());
	    set.add("kaijie", "@kaijie", form.getKaijie());
	}
	if (shijianleixing.equals("2")) {
	    set.add("tingjis", "@tingjis", form.getKaijis());
	    set.add("tingjie", "@tingjie", form.getKaijie());
	}
	if (shijianleixing.equals("3")) {
	    set.add("shoukuanshijians", "@shoukuanshijians", form.getKaijis());
	    set.add("shoukuanshijiane", "@shoukuanshijiane", form.getKaijie());
	}
	set.add("yonghuzhuangtai", "@yonghuzhuangtai", "���˶�");
	return set;
    }

    /**
     * ��¼�����ķ���
     * 
     * @param f
     * @return
     * @throws Exception
     */
    public int getResultCount(HuidanForm form, String life) throws Exception {
	// form.getStatus()����Ϊsql�жϵ����ݣ�product��״̬��10��δ���⣬1���ѳ���
	ParameterSet set = new ParameterSet();
	if(form.getYonghuzhuangtai_cha()==null||"".equals(form.getYonghuzhuangtai_cha())) {
		set.add("lifecycle_sta", "@lifecycle_sta", life);
	}else if("��ά��".equals(form.getYonghuzhuangtai_cha())||"�˵�".equals(form.getYonghuzhuangtai_cha())||"�Ѱ�װ".equals(form.getYonghuzhuangtai_cha())) {
		set.add("lifecycle_sta", "@lifecycle_sta", "4");
	}else if("���ӵ�δ��".equals(form.getYonghuzhuangtai_cha())||"������".equals(form.getYonghuzhuangtai_cha())) {
		set.add("lifecycle_sta", "@lifecycle_sta", "2");
	}else if("������".equals(form.getYonghuzhuangtai_cha())) {
		set.add("lifecycle_sta", "@lifecycle_sta", "3");
	}
	if (form != null) {
	    if (form.getYonghuzhuangtai_cha() != null) {
		set.add("yonghuzhuangtai", "@yonghuzhuangtai", form.getYonghuzhuangtai_cha());
	    }
	    if (form.getXiaoqu_cha() != null) {
		set.add("xiaoqu", "@xiaoqu", form.getXiaoqu_cha());
	    }
	    if (form.getDizhi_cha() != null) {
		set.add("dizhi", "@dizhi", "%" + form.getDizhi_cha() + "%");
	    }
	    if (form.getShijianleixing() != null && form.getKaijie() != null && form.getTingjie() != null) {
		if (form.getShijianleixing().equals("1")) {
		    set.add("kaijishijian_b", "@kaijishijian_b", form.getKaijie());
		    set.add("kaijishijian_e", "@kaijishijian_e", form.getTingjie());
		}
		if (form.getShijianleixing().equals("2")) {
		    set.add("tingjishijian_b", "@tingjishijian_b", form.getKaijie());
		    set.add("tingjishijian_e", "@tingjishijian_e", form.getTingjie());
		}
		if (form.getShoukuanshijian().equals("3")) {
		    set.add("shoukuanshijian_b", "@shoukuanshijian_b", form.getKaijie());
		    set.add("shoukuanshijian_e", "@shoukuanshijian_e", form.getTingjie());
		}
	    }
	}
	return dao.executeQueryToCount("GetCount_huidan", set);
    }

    /**
     * ��õ����ص���¼
     * 
     * @param UUID
     * @param f
     * @return
     * @throws Exception
     */
    public HuidanForm getHuidanForm_ByID(String UUID, HuidanForm f) throws Exception {
	ParameterSet set = new ParameterSet();
	set.add("uuid", "@uuid", UUID);
	DataRow r = dao.executeQueryToDataRow("getHuidanFormById", set);
	f.setYonghuzhuangtai(r.getDataElement("yonghuzhuangtai").getString());
	f.setKaijis(r.getDataElement("kaijishijian").getString());
	f.setTingjis(r.getDataElement("tingjishijian").getString());
	f.setXiaoqu(r.getDataElement("xiaoqu").getString());
	f.setDizhi(r.getDataElement("dizhi").getString());
	f.setTelNoCode(r.getDataElement("lianxidianhua").getString());
	f.setWangluo(r.getDataElement("wangluo").getString());
	f.setDianshi(r.getDataElement("dianshi").getString());
	f.setDianhua(r.getDataElement("dianhua").getString());
	f.setYewu(r.getDataElement("yewu").getString());
	f.setFenguang(r.getDataElement("fenguang").getString());
	f.setOnuCode(r.getDataElement("onumac").getString());
	f.setMcidCode(r.getDataElement("stbmcid").getString());
	f.setDianshiip(r.getDataElement("dianshiip").getString());
	f.setDianhuaip(r.getDataElement("dianhuaip").getString());
	f.setWangluoip(r.getDataElement("wangluoip").getString());
	f.setDianhuavlan(r.getDataElement("dianhuavlan").getString());
	f.setWangluovlan(r.getDataElement("wangluovlan").getString());
	f.setShangmenshijian(r.getDataElement("shangmenshijian").getString());
	f.setDanzheng(r.getDataElement("danzheng").getString());
	f.setSxdhhm(r.getDataElement("sxdhhm").getString());
	f.setOnuyj(r.getDataElement("onuyj").getString());
	f.setJidingheyj(r.getDataElement("jidingheyj").getString());
	f.setShoushifei(r.getDataElement("shoushifei").getString());
	f.setKuandaifei(r.getDataElement("kuandaifei").getString());
	f.setChuzhuangfei(r.getDataElement("chuzhuangfei").getString());
	f.setShebeixiaoshoufei(r.getDataElement("shebeixiaoshou").getString());
	f.setCailiaofei(r.getDataElement("cailiaofei").getString());
	f.setYunyingshang(r.getDataElement("yunyingshang").getString());
	f.setBzygf(r.getDataElement("bzygf").getString());
	f.setNianfei(r.getDataElement("nianfei").getString());
	f.setBeizhu(r.getDataElement("beizhu").getString());
	f.setBeizhuhuizong(r.getDataElement("beizhuhuizong").getString());
	f.setZongshoufei(r.getDataElement("zongshoufei").getString());
	f.setShoujubenhao(r.getDataElement("shoujubenhao").getString());
	f.setShoujuhao(r.getDataElement("shoujuhao").getString());
	f.setQtsbsyqk(r.getDataElement("qtsbsyqk").getString());
	f.setQitahaocai(r.getDataElement("qitahaocai").getString());
	f.setJiexianzi(r.getDataElement("jiexianzi").getString());
	f.setRj11(r.getDataElement("rj11").getString());
	f.setRj45(r.getDataElement("rj45").getString());
	f.setMokuai(r.getDataElement("mokuai").getString());
	f.setMianban(r.getDataElement("mianban").getString());
	f.setWangxian(r.getDataElement("wangxian").getString());
	f.setShigongren(r.getDataElement("shigongren").getString());
	f.setXianchangbeizhu(r.getDataElement("xianchangbeizhu").getString());
	f.setKaipiaoxinxi(r.getDataElement("kaipiaoxinxi").getString());
	f.setPipeizhuangtai(r.getDataElement("pipeizhuangtai").getString());
	f.setShoukuanshijian(r.getDataElement("shoukuanshijian").getString());
	f.setXingming(r.getDataElement("xingming").getString());
	f.setShenfenzheng(r.getDataElement("shenfenzheng").getString());
	f.setFenguangxianhao(r.getDataElement("fenguangxianhao").getString());
	f.setJiexuweizhi(r.getDataElement("jiexuweizhi").getString());
	f.setYewu(r.getDataElement("yewu").getString());
	f.setBiduikbn(r.getDataElement("biduikbn").getString());
	f.setBdfenguang(r.getDataElement("bdfenguang").getString());
	f.setBdonumac(r.getDataElement("bdonumac").getString());
	f.setBdstbmcid(r.getDataElement("bdstbmcid").getString());
	f.setBddianshiip(r.getDataElement("bddianshiip").getString());
	f.setFenguangID(r.getDataElement("fenguangID").getString());
	f.setSelectCommunityPileID(r.getDataElement("CommunityPile_ID").getString());
	f.setSelectCommunityPileID2(r.getDataElement("CommunityPile_ID2").getString());
	f.setBeishuselect(r.getDataElement("shichangbeishu").getString());
	return f;
    }

    public CommonMessage shebeiEdit(HuidanForm form) {

	return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�༭�ɹ���");
    }

    /**
     * ���»ص���Ϣ ������ life_toΪҪ���µ��û�״̬
     * 
     * @param f
     * @param request
     * @param life_now
     * @param life_to
     * @return
     * @throws Exception
     */
    public String updateHuidan(HuidanForm f, HttpServletRequest request, String life_to) throws Exception {
	String wsFlag = "";
	String name = getUserInfo(request).getEmployeeName();
	String time = Common.formatDate(new Date(), "yyyy/MM/dd  HH:mm:ss");
	String yewu = f.getYewu();
	String yewuHidden = f.getYewuHidden();
	ParameterSet set = new ParameterSet();
	if (f.getUUIDS() != null) {
	    String[] uuids = f.getUUIDS();
	    for (int i = 0; i < uuids.length; i++) {
		set.add("uuid", "@uuid", uuids[i]);
		DataSet<DataRow> query = dao.executeQuery("GetByUUIDFormHuidanData", set);

		set.add("updateby", "@updateby", name);
		set.add("updatedt", "updatedt", time);
		set.add("lifecycle_sta", "@lifecycle_sta", life_to);
		if (life_to.equals("0")) {
		    set.add("beizhuhuizong", "@beizhuhuizong", "�������˻أ������ˣ�" + name + " ����ʱ�䣺" + time + ")");
		    set.add("yonghuzhuangtai", "@yonghuzhuangtai", "�����˻�");
		} else {
		    set.add("beizhuhuizong", "@beizhuhuizong", "�����ӵ��·��������ˣ�" + name + " ����ʱ�䣺" + time + ")");
		    set.add("yonghuzhuangtai", "@yonghuzhuangtai", "���ӵ�δ��");
		}

		String yunyingshang = query.get(0).getDataElement("yunyingshang").getString();
		String wangluo = query.get(0).getDataElement("wangluo").getString();

		// WebService �����ǵ��������ҵ����û�ִ�а�װ���� ��װ�ӿ� change by ���˻�
		if (!"0".equals(life_to) && "����".equals(yunyingshang) && !"".equals(wangluo) && !"0".equals(wangluo)) {
		    wsFlag = "0";

		    //���õ��Ŷ˰�װ�ӿڵı���
		    if (!"0".equals(WebServiceMethods.AnZhuang(query, ""))) {
			System.err.println("****************���Žӿڵ���ʧ��************************");
			wsFlag = "1";
		    } else {
			// �����û���Ϣ
			List<String> uapList = UserManage.InsertUAP(query);
			if (null != uapList) {
			    set.add("userId", "@userId", uapList.get(1));
			}
		    }

		}

		if ("".equals(wsFlag) || "0".equals(wsFlag)) {
		    dao.execute("updateHuidan", set);
		}

	    }
	    return Constant.SUCCESS;
	}
	if (life_to.equals("4")) {
	    set.add("yonghuzhuangtai", "@yonghuzhuangtai", "�˵�");
	    set.add("pipeizhuantai", "@pipeizhuangtai", "δƥ��");
	    set.add("beizhuhuizong", "@beizhuhuizong", "�������ˣ�" + name + " ����ʱ�䣺" + time + " �˵�ԭ��" + f.getYewu() + ")");
	}
	if (life_to.equals("0")) {
	    set.add("beizhuhuizong", "@beizhuhuizong", "�������˻أ������ˣ�" + name + " ����ʱ�䣺" + time + ")");
	    set.add("yonghuzhuangtai", "@yonghuzhuangtai", "�����˻�");
	}
	set.add("updateby", "@updateby", name);
	set.add("updatedt", "@updatedt", time);
	set.add("uuid", "@uuid", f.getUUID());
	// set.add("yewu", "@yewu", f.getYewu()==null?"":f.getYewu());
	set.add("lifecycle_sta", "@lifecycle_sta", life_to);
	dao.execute("updateHuidan", set);
	return Constant.SUCCESS;
    }

    /**
     * ���»ص���Ϣ
     * 
     * @param form
     * @param request
     * @return
     * @throws Exception
     */
    public String updateHuidan(HuidanForm f, HttpServletRequest request) throws Exception {
	String name = getUserInfo(request).getEmployeeName();
	String time = Common.formatDate(new Date(), "yyyy/MM/dd HH:mm:ss");
	try {
	    openTransaction();
	    ParameterSet set = new ParameterSet();
	    set.add("uuid", "@uuid", f.getUUIDHidden());
	    set.add("dizhi", "@dizhi", f.getDizhi());
	    set.add("kaijishijian", "@kaijishijian", f.getKaijis());
	    set.add("tingjishijian", "@tingjishijian", f.getTingjis());
	    // 20141027billy������Чʱ�䱣�湦��
	    set.add("youxiaoshijian", "@youxiaoshijian", f.getTingjis());
	    set.add("xiaoqu", "@xiaoqu", f.getXiaoqu());
	    set.add("lianxidianhua", "@lianxidianhua", f.getTelNoCode());
	    set.add("wangluo", "@wangluo", f.getWangluo());
	    set.add("dianshi", "@dianshi", f.getDianshi());
	    set.add("dianhua", "@dianhua", f.getDianhua());
	    set.add("fenguang", "@fenguang", f.getFenguang());
	    set.add("onumac", "@onumac", f.getOnuCode());
	    set.add("stbmcid", "@stbmcid", f.getMcidCode());
	    set.add("dianshiip", "@dianshiip", f.getDianshiip());
	    set.add("dianhuaip", "@dianhuaip", f.getDianhuaip());
	    set.add("wangluoip", "@wangluoip", f.getWangluoip());
	    set.add("dianhuavlan", "@dianhuavlan", f.getDianhuavlan());
	    set.add("wangluovlan", "@wangluovlan", f.getWangluovlan());
	    set.add("shangmenshijian", "@shangmenshijian", f.getShangmenshijian());
	    set.add("danzheng", "@danzheng", f.getDanzheng());
	    set.add("sxdhhm", "@sxdhhm", f.getSxdhhm());
	    set.add("onuyj", "@onuyj", f.getOnuyj());
	    set.add("jidingheyj", "@jidingheyj", f.getJidingheyj());
	    set.add("shoushifei", "@shoushifei", f.getShoushifei());
	    set.add("kuandaifei", "@kuandaifei", f.getKuandaifei());
	    set.add("chuzhuangfei", "@chuzhuangfei", f.getChuzhuangfei());
	    set.add("yunyingshang", "@yunyingshang", f.getYunyingshang());
	    set.add("bzygf", "@bzygf", f.getBzygf());
	    set.add("nianfei", "@nianfei", f.getNianfei());
	    set.add("beizhu", "@beizhu", f.getBeizhu());
	    set.add("beizhuhuizong1", "@beizhuhuizong1", "(�豸�˶�  /�༭��:" + name + "/�༭ʱ��:" + time + ")" + f.getBeizhuhuizong());
	    set.add("updateby", "@updateby", name);
	    set.add("updatedt", "@updatedt", time);
	    set.add("shebeixiaoshou", "@shebeixiaoshou", f.getShebeixiaoshoufei());
	    set.add("cailiaofei", "@cailiaofei", f.getCailiaofei());
	    set.add("yonghuzhuangtai", "@yonghuzhuangtai", f.getYonghuzhuangtai() == null ? "" : f.getYonghuzhuangtai());
	    set.add("pipeizhuangtai", "@pipeizhuangtai", f.getPipeizhuangtai() == null ? "" : f.getPipeizhuangtai());
	    set.add("yewu", "@yewu", f.getYewu() == null ? "" : f.getYewu());

	    set.add("shigongren", "@shigongren", f.getShigongren() == null ? "" : f.getShigongren());
	    set.add("shoukuanshijian", "@shoukuanshijian", f.getShoukuanshijian() == null ? "" : f.getShoukuanshijian());
	    set.add("xingming", "@xingming", f.getXingming() == null ? "" : f.getXingming());
	    set.add("shenfenzheng", "@shenfenzheng", f.getShenfenzheng() == null ? "" : f.getShenfenzheng());
	    set.add("fenguangxianhao", "@fenguangxianhao", f.getFenguangxianhao() == null ? "" : f.getFenguangxianhao());
	    set.add("jiexuweizhi", "@jiexuweizhi", f.getJiexuweizhi() == null ? "" : f.getJiexuweizhi());
	    set.add("zongshoufei", "@zongshoufei", f.getZongshoufei() == null ? "" : f.getZongshoufei());
	    set.add("shoujubenhao", "@shoujubenhao", f.getShoujubenhao() == null ? "" : f.getShoujubenhao());
	    set.add("kaipiaoxinxi", "@kaipiaoxinxi", f.getKaipiaoxinxi() == null ? "" : f.getKaipiaoxinxi());
	    set.add("qtsbsyqk", "@qtsbsyqk", f.getQtsbsyqk() == null ? "" : f.getQtsbsyqk());
	    set.add("qitahaocai", "@qitahaocai", f.getQitahaocai() == null ? "" : f.getQitahaocai());
	    set.add("jiexianzi", "@jiexianzi", f.getJiexianzi() == null ? "" : f.getJiexianzi());
	    set.add("rj11", "@rj11", f.getRj11() == null ? "" : f.getRj11());
	    set.add("rj45", "@rj45", f.getRj45() == null ? "" : f.getRj45());
	    set.add("mokuai", "@mokuai", f.getMokuai() == null ? "" : f.getMokuai());
	    set.add("mianban", "@mianban", f.getMianban() == null ? "" : f.getMianban());
	    set.add("wangxian", "@wangxian", f.getWangxian() == null ? "" : f.getWangxian());
	    set.add("xianchangbeizhu", "@xianchangbeizhu", f.getXianchangbeizhu() == null ? "" : f.getXianchangbeizhu());

	    dao.execute("updateHuidan", set);
	    commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    rollback();
	}
	return Constant.SUCCESS;
    }

    /**
     * ɾ�����ݿ��Ӧ�ص���Ϣ UUIDS
     * 
     * @param f
     * @param request
     * @return
     * @throws Exception
     */
    public String deleteHuidan(HuidanForm f, HttpServletRequest request) throws Exception {
	String[] uuids = f.getUUIDS();
	String name = getUserInfo(request).getEmployeeName();
	String time = Common.formatDate(new Date(), "yyyy/MM/dd  HH:mm:ss");
	ParameterSet set = new ParameterSet();
	for (String a : uuids) {
		set.add("uuid", "@uuid", a);
		DataSet<DataRow> query = dao.executeQuery("GetByUUIDFormHuidanData", set);
	    set.add("uuid", "@uuid", a);
	    set.add("updateby", "@updateby", name);
	    set.add("updatedt", "@updatedt", time);
	    set.add("beizhu", "@beizhu","ɾ����Ϣ��"+name+" "+time+"/"+query.get(0).getDataElement("beizhu").getString());
	    dao.execute("deleteHuidan", set);
	}
	return Constant.SUCCESS;
    }

    /**
     * �˶Ա�ע
     * 
     * @param f
     * @param request
     * @return
     * @throws Exception
     */
    public CommonMessage heduiBeizhu(HuidanForm f) throws Exception {
	try {
	    openTransaction();
	    String uuid = f.getUUIDHidden();
	    String beizhuhuizong = f.getBeizhuhuizong();
	    String name = getUserInfo().getEmployeeName();
	    String time = Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	    ParameterSet set = new ParameterSet();
	    set.add("UUID", "@UUID", uuid);
	    set.add("beizhu", "@beizhu", "�˶Ա�ע�ˣ�" + name + "�˶Ա�עʱ�䣺" + time + "�˶����ݣ�" + beizhuhuizong);
	    set.add("updateby", "@updateby", name);
	    set.add("updatedt", "@updatedt", time);
	    dao.execute("updateHeduiBeizhu", set);
	    commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    rollback();
	    return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ύʧ�ܣ� ��˶����ݣ�");
	}
	return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�˶Ա�ע�ɹ�����");
    }
    
    public CommonMessage heduiBeizhuAudit(HuidanForm f) throws Exception {
	try {
	    openTransaction();
	    String uuid = f.getUUIDHidden();
	    String beizhuhuizong = f.getBeizhuhuizong();
	    String name = getUserInfo().getEmployeeName();
	    String time = Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	    ParameterSet set = new ParameterSet();
	    set.add("UUID", "@UUID", uuid);
	    set.add("beizhu", "@beizhu", "�˶Ա�ע�ˣ�" + name + "�˶Ա�עʱ�䣺" + time + "�˶����ݣ�" + beizhuhuizong);
	    set.add("updateby", "@updateby", name);
	    set.add("updatedt", "@updatedt", time);
	    dao.execute("updateHeduiBeizhuAudit", set);
	    commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    rollback();
	    return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ύʧ�ܣ� ��˶����ݣ�");
	}
	return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�˶Ա�ע�ɹ�����");
    }

    /**
     * �˶��ύ
     * 
     * @param f
     * @param request
     * @return
     * @throws Exception
     */
    public CommonMessage tijiaoHedui(HuidanForm f) {
	try {
	    String[] uuid = f.getUUIDS();
	    for (int i = 0; i < uuid.length; i++) {
		ParameterModel model = new ParameterModel();
		model.put("yonghuzhuangtai", "���˶�");
		model.put("Lifecycle_sta", "6");
		ParameterModel conds = new ParameterModel();
		conds.put("uuid", uuid[i]);
		dao.update("huidandata", model, conds);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ύʧ�ܣ� ��˶����ݣ�");
	}
	return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�˶��ύ�ɹ���");
    }
    
    public CommonMessage tijiaoHeduiAudit(HuidanForm f) {
	try {
	    String[] uuid = f.getUUIDS();
	    for (int i = 0; i < uuid.length; i++) {
		ParameterModel model = new ParameterModel();
		model.put("yewutype", "�Ѻ˶�");
		ParameterModel conds = new ParameterModel();
		conds.put("uuid", uuid[i]);
		dao.update("huidanaudit", model, conds);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ύʧ�ܣ� ��˶����ݣ�");
	}
	return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�˶��ύ�ɹ���");
    }
    public CommonMessage tijiaoHeduiAuditQiegai(HuidanForm f) {
    	try {
    	    String[] uuid = f.getUUIDS();
    	    for (int i = 0; i < uuid.length; i++) {
    		ParameterModel model = new ParameterModel();
    		model.put("yewutype", "�Ѻ˶�");
    		ParameterModel conds = new ParameterModel();
    		conds.put("uuid", uuid[i]);
    		dao.update("qiegaiaudit", model, conds);
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ύʧ�ܣ� ��˶����ݣ�");
    	}
    	return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�˶��ύ�ɹ���");
        }
    /**
     * �˶��뵵
     * 
     * @param f
     * @param request
     * @return
     * @throws Exception
     */
    public CommonMessage heduirudang(HuidanForm f) {
	try {
	    String[] uuid = f.getUUIDS();
	    for (int i = 0; i < uuid.length; i++) {
		ParameterModel model = new ParameterModel();
		model.put("yonghuzhuangtai", "���뵵");
		model.put("Lifecycle_sta", "6");
		ParameterModel conds = new ParameterModel();
		conds.put("uuid", uuid[i]);
		dao.update("huidandata", model, conds);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ύʧ�ܣ� ��˶����ݣ�");
	}
	return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�˶��뵵�ɹ���");
    }

    /**
     * �˶��ύ
     * 
     * @param f
     * @param request
     * @return
     * @throws Exception
     */
	public CommonMessage heduitijiao(HuidanForm f) throws Exception {
		String wsFlag = "";
		StringBuffer wrongdata = new StringBuffer();
		try {
			openTransaction();
			String name = getUserInfo().getEmployeeName();
			String time = Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
			String[] uuids = f.getUUIDS();
			for (int i = 0; i < uuids.length; i++) {
				ParameterSet set = new ParameterSet();
				set.add("uuid", "@uuid", uuids[i]);
				DataSet<DataRow> query = dao.executeQuery("GetByUUIDFromHuidan", set);
				String xiaoqu = query.get(0).getDataElement("xiaoqu").getString();
				String dizhi = query.get(0).getDataElement("dizhi").getString();
				ParameterSet set3 = new ParameterSet();
				set3.add("xiaoqu", "@xiaoqu", xiaoqu);
				set3.add("dizhi", "@dizhi", dizhi);
				int weixiusuu = dao.executeQueryToCount("checkyonghushujuweixiu", set3);
				if (weixiusuu != 0) {
					wrongdata.append(xiaoqu+dizhi+"����ά�޴��������Ϣ���ύʧ�ܣ�</br>");
					continue;
				}
				String anzhuangType = query.get(0).getDataElement("yewutype").getString();
				if ("���ƻ���".equals(anzhuangType)) {
					dao.execute("insertYijiAuditByhuidandata", set);
				}
				if ("����·�иġ�".equals(anzhuangType)) {
					dao.execute("insertQiegaiAuditByhuidandata", set);
				}
				String yonghuzhuangtai2 = query.get(0).getDataElement("yonghuzhuangtai").getString();
				
				DataElement cpid = query.get(0).getDataElement("CommunityPile_ID");
				DataElement onu = query.get(0).getDataElement("onumac");
				ParameterSet shebeiset = new ParameterSet();
				DataSet<DataRow> shebeiInfo = null;
				if(cpid!=null&&cpid.getString()!=null) {
					shebeiset.add("CommunityPile_ID", "@CommunityPile_ID", cpid.getString());
					shebeiInfo = dao.executeQuery("getDaipipeiShebeiInfo", shebeiset);
				}
				DataElement cpid2 = query.get(0).getDataElement("CommunityPile_ID2");
				DataElement stbmcid = query.get(0).getDataElement("stbmcid");
				DataSet<DataRow> shebei2Info = null;
				if(cpid2!=null&&cpid2.getString()!=null) {
					shebeiset.add("CommunityPile_ID", "@CommunityPile_ID", cpid2.getString());
					shebei2Info = dao.executeQuery("getDaipipeiShebeiInfo", shebeiset);
				}
				DataElement fenguangID = query.get(0).getDataElement("fenguangID");
				if("�Ѱ�װ".equals(yonghuzhuangtai2)) {
					if(cpid!=null&&!"0".equals(cpid.getString())&&cpid.getString()!=null&&onu!=null&&onu.getString()!=null) {
						ParameterModel model = new ParameterModel(); 
						String eqsta_name = shebeiInfo.get(0).getDataElement("eqsta_name").getString();
						if("��ƥ��".equals(eqsta_name)||"�Ѱ�װ".equals(eqsta_name)) {
							model.put("EqSta_ID", "5");
						}else{
							wrongdata.append(xiaoqu+dizhi+"ONU�豸״̬�쳣�����ֶ��鿴��</br>");
							continue;
						}
						model.put("Update_person", getUserInfo().getEmployeeName());
						model.put("Update_time", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss") );
						ParameterModel conds = new ParameterModel(); 
						conds.put("CommunityPile_ID", cpid.getString());
						dao.update("communitypile", model, conds);
					}
					if(cpid2!=null&&!"0".equals(cpid2.getString())&&cpid2.getString()!=null&&stbmcid!=null&&stbmcid.getString()!=null) {
						ParameterModel model = new ParameterModel(); 
						String eqsta_name = shebei2Info.get(0).getDataElement("eqsta_name").getString();
						if("��ƥ��".equals(eqsta_name)||"�Ѱ�װ".equals(eqsta_name)) {
							model.put("EqSta_ID", "5");
						}else{
							wrongdata.append(xiaoqu+dizhi+"�������豸״̬�쳣�����ֶ��鿴��</br>");
							continue;
						}
						model.put("Update_person", getUserInfo().getEmployeeName());
						model.put("Update_time", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss") );
						ParameterModel conds = new ParameterModel(); 
						conds.put("CommunityPile_ID", cpid2.getString());
						dao.update("communitypile", model, conds);
					}
				}else if("�˵�".equals(yonghuzhuangtai2)) {
					if(cpid!=null&&!"0".equals(cpid.getString())&&cpid.getString()!=null&&onu!=null&&onu.getString()!=null) {
						ParameterModel model = new ParameterModel(); 
						String eqsta_name = shebeiInfo.get(0).getDataElement("eqsta_name").getString();
						if("��ƥ��".equals(eqsta_name)||"�����ֳ�".equals(eqsta_name)) {
							model.put("EqSta_ID", "2");
						}else if("�Ѱ�װ".equals(eqsta_name)){
							model.put("EqSta_ID", "5");
						}else{
							wrongdata.append(xiaoqu+dizhi+"ONU�豸״̬�쳣�����ֶ��鿴��</br>");
							continue;
						}
						model.put("Update_person", getUserInfo().getEmployeeName());
						model.put("Update_time", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss") );
						ParameterModel conds = new ParameterModel(); 
						conds.put("CommunityPile_ID", cpid.getString());
						dao.update("communitypile", model, conds);
					}
					if(cpid2!=null&&!"0".equals(cpid2.getString())&&cpid2.getString()!=null&&stbmcid!=null&&stbmcid.getString()!=null) {
						ParameterModel model = new ParameterModel(); 
						String eqsta_name = shebei2Info.get(0).getDataElement("eqsta_name").getString();
						if("��ƥ��".equals(eqsta_name)||"�����ֳ�".equals(eqsta_name)) {
							model.put("EqSta_ID", "2");
						}else if("�Ѱ�װ".equals(eqsta_name)){
							model.put("EqSta_ID", "5");
						}else{
							wrongdata.append(xiaoqu+dizhi+"�������豸״̬�쳣�����ֶ��鿴��</br>");
							continue;
						}
						model.put("Update_person", getUserInfo().getEmployeeName());
						model.put("Update_time", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss") );
						ParameterModel conds = new ParameterModel(); 
						conds.put("CommunityPile_ID", cpid2.getString());
						dao.update("communitypile", model, conds);
					}
//					if(fenguangID!=null&&fenguangID.getString()!=null) {
//						ParameterModel model = new ParameterModel(); 
//						model.put("mask", "0");
//						ParameterModel conds = new ParameterModel(); 
//						conds.put("uuid", fenguangID.getString());
//						dao.update("fenguangfenpei", model, conds);
//					}
				}else if("��ά��".equals(yonghuzhuangtai2)) {
					//��ά��״ֱ̬������
				}else{
					wrongdata.append(xiaoqu+dizhi+"״̬�쳣������ϵ����Ա��</br>");
					continue;
				}
				set = new ParameterSet();
				set.add("UUID", "@UUID", uuids[i]);
				set.add("createby", "@createby", getUserInfo().getEmployeeName());
				set.add("beizhuhuizong", "@beizhuhuizong", "���˶��ύ�������ˣ�" + name + " ����ʱ�䣺" + time + ")");
				set.add("createdt", "@createdt",Common.formatDate(new Date(), "yyyy-MM-dd hh:mm:ss"));
				dao.execute("insertYonghushujuByhuidandata", set);

				set.add("updateby", "@updateby", getUserInfo().getEmployeeName());
				set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd hh:mm:ss"));
				set.add("beizhu", "@beizhu", "���˶��ύ�������ˣ�" + name + " ����ʱ�䣺" + time + ")");
				dao.execute("updateHeduitijiao", set);

				String yunyingshang = query.get(0).getDataElement("yunyingshang").getString();
				String wangluo = query.get(0).getDataElement("wangluo").getString();
				String yonghuzhuangtai = query.get(0).getDataElement("yonghuzhuangtai").getString();

				// �˵��ӿ� ���ڵ�������ҵ���û�ִ���˵����� change by ���˻�WebService
				if ("����".equals(yunyingshang) && !"".equals(wangluo)
						&& !"0".equals(wangluo) && "�˵�".equals(yonghuzhuangtai)) {
					wsFlag = "0";
					// �˵���������װ�û�ʱ�ڣ��ڵ��Ŷ���Ϊ�˶�����
					if (!"0".equals(WebServiceMethods.TuiDing(query))) {
						wsFlag = "1";
						rollback();
						return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"�ύʧ�ܣ� ��˶����ݣ�");
					}
				}
			}
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"�ύʧ�ܣ� ��˶����ݣ�");
		}
		if(wrongdata.length()!=0) {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		if ("".equals(wsFlag)) {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"�˶��ύ�ɹ���");
		} else {
			if ("0".equals(wsFlag)) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"�˶��ύ�ɹ������Ŷ�����ͬ���ɹ���");
			} else {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"�ύʧ�ܣ� ��˶����ݣ�");
			}
		}
	}

    /**
     * �����豸�˶� �˻�
     * 
     * @param f
     * @param request
     * @return
     * @throws Exception
     */
    public CommonMessage cuowutuihui(HuidanForm f) {
	try {
	    String uuid = f.getUUID();
	    ParameterSet set = new ParameterSet();
	    set.add("uuid", "@uuid", uuid);
	    String yonghuzhuangtai = dao.executeQueryToDataRow("GongdanCheckDataInfo", set).getDataElement("yonghuzhuangtai").getString();
	    if (yonghuzhuangtai.equals("��ά��")) {
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "��ά�޵����ݲ��ܱ������أ�");
	    } else {
		ParameterModel model = new ParameterModel();
		model.put("Lifecycle_sta", "2");
		model.put("yonghuzhuangtai", "������");
		ParameterModel conds = new ParameterModel();
		conds.put("uuid", uuid);
		dao.update("huidandata", model, conds);
	    }
	    return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "������˳ɹ���");
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ύʧ�ܣ� ��˶����ݣ�");
	}
    }

    public String getYewuByUUID(String uuid) throws Exception {
	ParameterSet set = new ParameterSet();
	set.add("uuid", "@uuid", uuid);
	DataRow executeQueryToDataRow = dao.executeQueryToDataRow("huidanList", set);
	String yewu = executeQueryToDataRow.getDataElement("yewu").getString();
	return yewu;
    }
}
