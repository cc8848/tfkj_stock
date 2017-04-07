/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: kucun data service class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2013-03-18   Li.Hai-Han            Create
 * 2013-03-22   zhangdongyu           Update
 */
package com.stock.kucun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessService;
import com.stock.yonghushuju.YonghuDataEntityForm;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.DataSetUtil;

public class KucunService extends BusinessService {
	private Log log = LogFactory.getLog(this.getClass());	
	private CommonDao dao = new CommonDao();
	/**
	 * ����UUID���ҵ�����product��¼����װ��form����
	 * @param f
	 * @return
	 * @throws Exception
	 */
	public KuncunForm getKucunform_ByID(String UUID, KuncunForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("Product_ID", "@Product_ID", UUID);
		
		DataRow r = dao.executeQueryToDataRow("getKucunform_ByID", set);
		f.setUUID(r.getDataElement("product_id").getString());
		f.setShebeizhuangtai(r.getDataElement("eqsta_name").getString());
		f.setXianghao(r.getDataElement("eqboxnum").getString());
		f.setRukuriqi(r.getDataElement("eqintime").getString());
		f.setRukuren(r.getDataElement("Job_ID").getString());
		f.setShebeileixing(r.getDataElement("eqtype").getString());
		f.setShebeixinghao(r.getDataElement("eqversion").getString());
		f.setMac(r.getDataElement("eqMAC").getString());
		f.setMcid(r.getDataElement("eqMCID").getString());
		f.setZhuceweizhi(r.getDataElement("EqRegister").getString());
		f.setShujuip(r.getDataElement("eqIp").getString());
		f.setBeizhu(r.getDataElement("eqremark").getString());

		return f;
	}
	
	public KuncunForm getAnZhuangKuform_ByID(String UUID, KuncunForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("Product_ID", "@Product_ID", UUID);
		
		DataRow r = dao.executeQueryToDataRow("getAnZhuangKucunform_ByID", set);
		f.setShebeizhuangtai(r.getDataElement("e1qsta_name").getString());
		f.setXiaoqurukuriqi(r.getDataElement("FirstEnterDate").getString());
		f.setRukuxiaoqu(r.getDataElement("Community_ID").getString());
		f.setLingquren(r.getDataElement("Get_person").getString());
		f.setAnzhuangdidian(r.getDataElement("Install_site").getString());
		f.setAnzhuangshijian(r.getDataElement("Install_time").getString());
		f.setBeizhu(r.getDataElement("Remark").getString());
		
		f.setMac(r.getDataElement("eqMAC").getString());
		f.setMcid(r.getDataElement("eqMCID").getString());
		f.setZhuceweizhi(r.getDataElement("EqRegister").getString());
		f.setShujuip(r.getDataElement("EqIp").getString());

		return f;
	}
	
	/**
	 * ����С����UUID���ҵ����ļ�¼����װ��form����
	 * @param f
	 * @return
	 * @throws Exception
	 */
	public void getKucunform_ByXiaoQuKuID(KuncunForm f) throws Exception {
		String uuid = f.getUUID();
		ParameterSet set = new ParameterSet();
		set.add("CommunityPile_ID", "@CommunityPile_ID", uuid);
		DataRow r = dao.executeQueryToDataRow("GetXiaoQuKuDataList", set);
		
		f.setShebeizhuangtai(r.getDataElement("eqsta_name").getString());
		f.setXiaoqurukuriqi(r.getDataElement("FirstEnterDate").getString());
		f.setRukuxiaoqu(r.getDataElement("Community_ID").getString());
		f.setLingquren(r.getDataElement("Get_person").getString());
		f.setAnzhuangdidian(r.getDataElement("Install_site").getString());
		f.setAnzhuangshijian(r.getDataElement("Install_time").getString());
	    f.setBeizhu(r.getDataElement("eqremark").getString());
		f.setZhuceweizhi(r.getDataElement("eqregister").getString());
		f.setMac(r.getDataElement("eqmac").getString());
		f.setMcid(r.getDataElement("eqmcid").getString());
		f.setShujuip(r.getDataElement("eqip").getString());
		f.setUUIDHidden(uuid);
	}
	
	/**
	 * get in storage info for query page init.
	 * 
	 * @return
	 * @throws Exception
	 */
	public DataSet<DataRow> getResult(KuncunForm form, int first, int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("Status", "@Status", form.getStatus());
		set = getResultParameterSet(set ,form);
		
		/*
		 * �״β�ѯ�����δ��������
		 */
		if (form.getStatus() == null || form.getStatus().trim().equals("")) {
			set.add("EqSta_Name", "@EqSta_Name", "δ����");
			return dao.executeQuery("GetshebeiDataList", set, first, rows);
		}
		
		return dao.executeQuery("GetshebeiDataList", set, first, rows);
	}
	
	private ParameterSet getResultParameterSet(ParameterSet set, KuncunForm form) {
		String sen = form.getSen();
		if (form.getQmac() != null && !"".equals(form.getQmac())) {
			set.add("EqMAC", "@EqMAC", "%"  + form.getQmac() + "%" );
		}
		if (form.getQmcid() != null && !"".equals(form.getQmcid())) {
			set.add("EqMCID", "@EqMCID", "%" + form.getQmcid() + "%" );
		}
		if ("1".equals(form.getShijianleixing())) {
			set.add("kaishi", "@kaishi",  form.getKaishi());
			set.add("jieshu", "@jieshu", form.getJieshu());
		}
		if (sen.equals("1")) {
			set.add("EqBoxNum", "@EqBoxNum", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("2")) {
			set.add("NAME", "@NAME", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("3")) {
			set.add("EqType", "@EqType", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("4")) {
			set.add("EqVersion", "@EqVersion", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("6")) {
			set.add("EqRegister", "@EqRegister", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("7")) {
			set.add("EqIp", "@EqIp", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("8")) {
			set.add("EqRemark", "@EqRemark", "%" + form.getSenValue() + "%");
		}
		return set;
	}

	public DataSet<DataRow> getResultchuku(KuncunForm form, int first, int rows) throws Exception {
		if (form.getStatus() == null){
			return dao.executeQuery("GetEmptyDataList", new  ParameterSet(), first, rows);
		}
		return dao.executeQuery("GetXiaoQuKuDataList", getParamertSetForChuku(form), first, rows);
	}
	

	private ParameterSet getParamertSetForChuku(KuncunForm form) {
		ParameterSet set = new ParameterSet();
		String sen = form.getSen();
		set.add("EQSTA_TYPE", "@EQSTA_TYPE", "2");
		set.add("EqSta_ID", "@EqSta_ID", form.getStatus());
		set.add("Community_ID", "@Community_ID", form.getQuyuCode());
		if (form.getInstall_site() != null && !"".equals(form.getInstall_site())){
			set.add("Install_site", "@Install_site","%" +  form.getInstall_site() + "%");
		}
		if (form.getQmac() != null && !"".equals(form.getQmac())){
			set.add("EqMAC", "@EqMAC", "%"  + form.getQmac() + "%" );
		}
		if (form.getQmcid() != null && !"".equals(form.getQmcid())){
			set.add("EqMCID", "@EqMCID", "%" + form.getQmcid() + "%" );
		}
		if ("1".equals(form.getShijianleixing())) {
			set.add("kaishi1", "@kaishi1",  form.getKaishi());
			set.add("jieshu1", "@jieshu1", form.getJieshu());
		}
		if ("2".equals(form.getShijianleixing())) {
			set.add("kaishi2", "@kaishi2",  form.getKaishi());
			set.add("jieshu2", "@jieshu2", form.getJieshu());
		}
		if ("3".equals(form.getShijianleixing())) {
			set.add("kaishi3", "@kaishi3",  form.getKaishi());
			set.add("jieshu3", "@jieshu3", form.getJieshu());
		}
		if("0".equals(form.getShebeitype())) {
			set.add("EqType", "@EqType", "%ONU%");
		}else if("1".equals(form.getShebeitype())) {
			set.add("EqType", "@EqType", "%������%");
		}
		if (sen.equals("1")) {
			set.add("EqBoxNum", "@EqBoxNum", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("2")) {
			set.add("rukuren", "@rukuren", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("3")) {
			set.add("EqType", "@EqType", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("4")) {
			set.add("EqVersion", "@EqVersion", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("5")) {
			set.add("Lingquren", "@Lingquren", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("6")) {
			set.add("EqRegister", "@EqRegister", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("7")) {
			set.add("EqIp", "@EqIp", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("8")) {
			set.add("EqRemark", "@EqRemark", "%" + form.getSenValue() + "%");
		}
		return set;
	}

	public DataSet<DataRow> getResultanzhuangku(KuncunForm form, int first,
			int rows) throws Exception {
		String EqSta_Type = "3";
		if (form.getQuyuCode() == null) {
			return dao.executeQuery("GetEmptyDataList", getParamertSetAnzhuang(form,EqSta_Type), first, rows);
		}
		return dao.executeQuery("GetKuDataList", getParamertSetAnzhuang(form,EqSta_Type), first, rows);
	}
	
	private ParameterSet getParamertSetAnzhuang(KuncunForm form, String eqSta_Type) {
		String sen = form.getSen();
		ParameterSet set = new ParameterSet();
		set.add("EqSta_Type", "@EqSta_Type", eqSta_Type);
		set.add("EqSta_ID", "@EqSta_ID", form.getStatus());
		set.add("Community_ID", "@Community_ID", form.getQuyuCode());
		if (form.getInstall_site() != null && !"".equals(form.getInstall_site())){
			set.add("Install_site", "@Install_site","%" +  form.getInstall_site() + "%");
		}
		if ("3".equals(form.getShijianleixing())) {
			set.add("kaishi3", "@kaishi3",  form.getKaishi());
			set.add("jieshu3", "@jieshu3", form.getJieshu());
		}
		if (form.getQmac() != null && !"".equals(form.getQmac())){
			set.add("EqMAC", "@EqMAC", "%"  + form.getQmac() + "%" );
		}
		if (form.getQmcid() != null && !"".equals(form.getQmcid())){
			set.add("EqMCID", "@EqMCID", "%" + form.getQmcid() + "%" );
		}
		if ("1".equals(form.getShijianleixing())) {
			set.add("kaishi1", "@kaishi1",  form.getKaishi());
			set.add("jieshu1", "@jieshu1", form.getJieshu());
		}
		if ("2".equals(form.getShijianleixing())) {
			set.add("kaishi2", "@kaishi2",  form.getKaishi());
			set.add("jieshu2", "@jieshu2", form.getJieshu());
		}
	
		if (sen.equals("1")) {
			set.add("EqBoxNum", "@EqBoxNum", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("2")) {
			set.add("rukuren", "@rukuren", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("3")) {
			set.add("EqType", "@EqType", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("4")) {
			set.add("EqVersion", "@EqVersion", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("5")) {
			set.add("Lingquren", "@Lingquren", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("6")) {
			set.add("EqRegister", "@EqRegister", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("7")) {
			set.add("EqIp", "@EqIp", "%" + form.getSenValue() + "%");
		}
		if (sen.equals("8")) {
			set.add("EqRemark", "@EqRemark", "%" + form.getSenValue() + "%");
		}
		return set;
	}

	public DataSet<DataRow> getResultyichangku(KuncunForm form, int first,
			int rows) throws Exception {
		String EqSta_Type = "4";
		if (form.getStatus() == null){
			return dao.executeQuery("GetEmptyDataList", new  ParameterSet(), first, rows);
		}
		return dao.executeQuery("GetKuDataList", getParamertSetAnzhuang(form,EqSta_Type), first, rows);
	}
	
	public DataSet<DataRow> getHistoryShebei(KuncunForm form, int first,
			int rows) throws Exception {
		String uuid = form.getUUID();
		ParameterSet set = new ParameterSet();
		set.add("Product_ID", "@Product_ID", uuid);
		return dao.executeQuery("getHistoryInfo", set, first, rows);
	}
	public DataSet<DataRow> getHistoryAnzhuangkuShebei(KuncunForm form,
			int first, int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("CommunityPile_ID", "@CommunityPile_ID", form.getUUID());
		String id = dao.executeQueryToDataRow("getProductIDfromXiaoquKuID", set).getDataElement("Product_id").getString();
		
		ParameterSet set1 = new ParameterSet();
		set1.add("Product_ID", "@Product_ID", id);
		return dao.executeQuery("getHistoryInfo", set1, first, rows);
	}
	/**
	 * 
	 * @param f
	 * @return
	 * @throws Exception
	 */
	public int getResultCount(KuncunForm form) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("Status", "@Status", form.getStatus());
		set = getResultParameterSet(set ,form);
		
		if (form.getStatus() == null || form.getStatus().trim().equals("")) {
			set.add("EqSta_Name", "@EqSta_Name", "δ����");
			return dao.executeQueryToCount("GetCount", set);
		}
		return dao.executeQueryToCount("GetCount",  set);
	}
	
	public int getResultchukuCount(KuncunForm form) throws Exception {
		if (form.getStatus() == null){
			return 0;
		}
		return dao.executeQueryToCount("GetChuKuCount", getParamertSetForChuku(form));
	}
	public int getResultAnZhuangKuCount(KuncunForm form) throws Exception {
		if (form.getQuyuCode() == null) {
			return 0;
		}
		String eqSta_Type = "3";
		return dao.executeQueryToCount("GetAnzhuangCount", getParamertSetAnzhuang(form, eqSta_Type));
	}
	public int getResultYiChangKuCount(KuncunForm form) throws Exception {
		if (form.getStatus() == null){
			return 0;
		}
		return dao.executeQueryToCount("GetAnzhuangCount", getParamertSetAnzhuang(form,"4"));
	}
	public int getHistoryShebeiInfoCount(KuncunForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("Product_ID", "@Product_ID", f.getUUID());
		return dao.executeQueryToCount("getHistoryInfoCount", set) + 1;
	}
	public int getHistoryAnzhuangkuShebeiInfoCount(KuncunForm f) throws Exception {
		
		
		ParameterSet set = new ParameterSet();
		set.add("CommunityPile_ID", "@CommunityPile_ID", f.getUUID());
		String id = dao.executeQueryToDataRow("getProductIDfromXiaoquKuID", set).getDataElement("Product_id").getString();
		ParameterSet set1 = new ParameterSet();
		set1.add("Product_ID", "@Product_ID", id);
		return dao.executeQueryToCount("getHistoryInfoCount", set1) + 1;
	}
	
	public CommonMessage shebeiEdit(KuncunForm form) {
		
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�༭�ɹ���");
	}
	
	public CommonMessage shebeiToXiaoqu(KuncunForm form) throws Exception {
		/*
		 * 1.get uuids
		 * 2.use uuids let Product EqQuantity ruduce 1.
		 * 3.CommunityPile input data by uuids Eqstate code is 2  , 
		 *   and use bring С��������ڡ�����ʽ��2013-12-13���������С����������ѡ�񣩡�����ȡ�ˡ�������ע  update.
		 * 4.copy info by uuids use product�� to recordpile��.
		 */
		String rukuriqi = form.getRukuriqi();
		String rukuxiaoquId = form.getRukuxiaoqu();
		String lingqurenId = form.getLingquren();
		String beizhu = form.getBeizhu();
		String uuid = form.getUUIDHidden();
		String[] uuids = uuid.split(",");
		String nowDate = Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		String employeeName = getUserInfo().getEmployeeName();
		StringBuilder sb =new StringBuilder();
		
		/*
		 * �豸����  ����Ϊ0  ״̬Ϊ�ѳ��� 
		 */
		try {
			openTransaction();
			Integer[] seq = new Integer[uuids.length];
			ParameterSet set1 = new ParameterSet();
			for (int i = 0; i < uuids.length; i++) {
				int execute = dao.executeQueryToCount("getSEQ1", set1);
				seq[i] = execute;
			}
			
			commit();
			openTransaction();
			for (int i = 0; i < uuids.length; i++) {
				
				//	(CommunityPile_ID , EqSta_ID ,EnterDate, NAME , Price ,EqRemark ,
				//EqQuantity , EqType , EqVersion ,EqRegister , EqMAC ,
				//EqMCID , EqIp , Install_site ,Install_time ,Create_Person , Create_time) 
			    ParameterSet set = new ParameterSet();
			    set.add("Product_ID", "@Product_ID", uuids[i]);
				DataSet<DataRow> executeQuery = dao.executeQuery("getdinfoFromProduct", set);
				String EqStateId = executeQuery.get(0).getDataElement("EqState").getString();
				String EqRemark = executeQuery.get(0).getDataElement("EqRemark").getString();
				
				
				if (EqStateId.equals("10")) {
				    String	EqBoxNum  = executeQuery.get(0).getDataElement("EqBoxNum").getString();
				    String	EqType  = executeQuery.get(0).getDataElement("EqType").getString();
				    String	EqVersion  = executeQuery.get(0).getDataElement("EqVersion").getString();
				    String	EqMAC  = executeQuery.get(0).getDataElement("EqMAC").getString();
				    sb.append("(��ţ�");
					sb.append(EqBoxNum);
					sb.append(",���ͣ�");
					sb.append(EqType);
					sb.append(",�ͺţ�");
					sb.append(EqVersion);
					sb.append(",MAC��");
					sb.append(EqMAC);
					sb.append(")");
				} else {
					ParameterModel model = new ParameterModel(); 
					model.put("EqQuantity", "0");
					model.put("EqState", "10");
					ParameterModel conds = new ParameterModel(); 
					conds.put("Product_ID", uuids[i]);
					dao.update("Product", model, conds);
					
					/*
					 * �ֿ��豸 ��С����֮ǰ��Ϣ ��¼
					 */
					ParameterModel model2 = new ParameterModel(); 
					model2.put("CommunityPile_ID", seq[i]);
					model2.put("Product_ID", uuids[i]);
					model2.put("EqSta_ID", "δ����");
					model2.put("EnterDate", nowDate);
					model2.put("NAME", executeQuery.get(0).getDataElement("NAME").getString());
					model2.put("Price", executeQuery.get(0).getDataElement("Price").getString());
					model2.put("EqRemark", executeQuery.get(0).getDataElement("EqRemark").getString());
					model2.put("EqBoxNum", executeQuery.get(0).getDataElement("EqBoxNum").getString());
					model2.put("EqQuantity", "1");
					model2.put("EqType", executeQuery.get(0).getDataElement("EqType").getString());
					model2.put("EqVersion", executeQuery.get(0).getDataElement("EqVersion").getString());
					model2.put("EqRegister", executeQuery.get(0).getDataElement("EqRegister").getString());
					model2.put("EqMAC", executeQuery.get(0).getDataElement("EqMAC").getString());
					model2.put("EqMCID", executeQuery.get(0).getDataElement("EqMCID").getString());
					model2.put("EqInPerson", executeQuery.get(0).getDataElement("EqInPerson").getString());
					model2.put("EqInTime", executeQuery.get(0).getDataElement("EqInTime").getString());
					model2.put("EqIp", executeQuery.get(0).getDataElement("EqIp").getString());
					model2.put("Create_person", executeQuery.get(0).getDataElement("Create_person").getString());
					model2.put("Create_time", executeQuery.get(0).getDataElement("Create_time").getString());
					model2.put("Update_person", executeQuery.get(0).getDataElement("Update_person").getString());
					model2.put("Update_time", executeQuery.get(0).getDataElement("Update_time").getString());
					dao.insert("recordpile", model2);
					
					ParameterModel model1 = new ParameterModel(); 
					model1.put("CommunityPile_ID", seq[i]);
					model1.put("Community_ID", rukuxiaoquId);
					model1.put("Product_ID", uuids[i]);
					model1.put("EqSta_ID", "2");//�����ֳ�
					model1.put("FirstEnterDate", rukuriqi);
					model1.put("Quantity", "1");
					model1.put("Get_person", lingqurenId);
					model1.put("Quantity", "1");
					model1.put("Create_person", employeeName);
					model1.put("Create_time", nowDate);
					if (EqRemark.trim().equals("") || EqRemark == null){
						if(beizhu.trim().equals("")) {
						} else {
							model1.put("Remark", beizhu);
						}
					} else {
						if(beizhu.trim().equals("")) {
							model1.put("Remark", EqRemark);
						} else {
							model1.put("Remark", EqRemark + "��������䱸ע��" + beizhu);
						}
					}
					dao.insert("CommunityPile", model1);
					
				}
			}
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "��Ʒת��ʧ�ܣ������쳣��");
		}
		if(sb.toString().equals("")) {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "����ɹ���");
		} else {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�豸��" + sb.toString() + "�ѳ���");
		}
	}

	/**
	 * ����С����ID ���С�����豸״̬
	 * @param f
	 * @return 
	 * @throws Exception 
	 */
	public CommonMessage zhuangTaiChange(KuncunForm f) throws Exception {
		
		String uuid = f.getUUIDHidden();
		String[] uuids = uuid.split(",");
		String status = f.getShebeizhuangtai();
		String beizhu = f.getBeizhu();
		try {
			openTransaction();
			for (int i = 0; i < uuids.length; i++) {
				ParameterSet set = new ParameterSet();
				set.add("CommunityPile_ID", "@CommunityPile_ID", uuids[i]);
				dao.execute("insertDaipipeiInfo", set);
				
				DataSet<DataRow> executeQuery = dao.executeQuery("getXiaoqukuBeizhu", set);
				String Remark = executeQuery.get(0).getDataElement("Remark").getString();
				
				ParameterModel model = new ParameterModel(); 
				model.put("EqSta_ID", status);
				if (beizhu.trim().equals("")){
				} else {
					if (Remark == null || Remark.trim().equals("")) {
						model.put("Remark", Remark + "״̬�����ע��" + beizhu );
					} else {
						model.put("Remark", Remark + "��״̬�����ע��" + beizhu );
					}
				}
				model.put("Update_person", getUserInfo().getEmployeeName());
				model.put("Update_time", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss") );
				ParameterModel conds = new ParameterModel(); 
				conds.put("CommunityPile_ID", uuids[i]);
				dao.update("communitypile", model, conds);
			}
			commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "״̬�ı�ɹ���");
	}
	/**
	 * ����С����ID ���С�����豸״̬
	 * @param f
	 * @return 
	 * @throws Exception 
	 */
	public void zhuangTaiChange(String uuid,String status) throws Exception {
		
		String beizhu = "";
		try {
			openTransaction();
				ParameterSet set = new ParameterSet();
				set.add("CommunityPile_ID", "@CommunityPile_ID", uuid);
				dao.execute("insertDaipipeiInfo", set);
				
				DataSet<DataRow> executeQuery = dao.executeQuery("getXiaoqukuBeizhu", set);
				String Remark = executeQuery.get(0).getDataElement("Remark").getString();
				
				ParameterModel model = new ParameterModel(); 
				model.put("EqSta_ID", status);
				if (beizhu.trim().equals("")){
				} else {
					if (Remark == null || Remark.trim().equals("")) {
						model.put("Remark", Remark + "״̬�����ע��" + beizhu );
					} else {
						model.put("Remark", Remark + "��״̬�����ע��" + beizhu );
					}
				}
				model.put("Update_person", getUserInfo().getEmployeeName());
				model.put("Update_time", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss") );
				ParameterModel conds = new ParameterModel(); 
				conds.put("CommunityPile_ID", uuid);
				dao.update("communitypile", model, conds);
			commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����С����ID ���С�����豸״̬(�����豸��)
	 * @param f
	 * @return 
	 * @throws Exception 
	 */
	public void zhuangTaiChange(String uuid,String status,String xiaoqu,String useage,String addr,String time) throws Exception {
		
		try {
			openTransaction();
				ParameterSet set = new ParameterSet();
				set.add("CommunityPile_ID", "@CommunityPile_ID", uuid);
				dao.execute("insertDaipipeiInfo", set);
				
				DataSet<DataRow> executeQuery = dao.executeQuery("getXiaoqukuBeizhu", set);
				String Remark = executeQuery.get(0).getDataElement("Remark").getString();
				if(Remark==null) {
					Remark="";
				}
				
				ParameterModel model = new ParameterModel(); 
				model.put("EqSta_ID", status);
				model.put("Install_site",addr);
				model.put("Install_time",time);
				model.put("Remark", Remark + "[" + xiaoqu +"]["+useage+"]");
				model.put("Update_person", getUserInfo().getEmployeeName());
				model.put("Update_time", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss") );
				ParameterModel conds = new ParameterModel(); 
				conds.put("CommunityPile_ID", uuid);
				dao.update("communitypile", model, conds);
			commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ݲ�ƷId ����״̬
	 * @param f
	 * @return 
	 */
	public CommonMessage zhuangTaiChangeByPId(KuncunForm f) {
		boolean flag = true;
		String uuid = f.getUUIDHidden();
		String[] uuids = uuid.split(",");
		String status = f.getShebeizhuangtai();
		String beizhu = f.getBeizhu();
		StringBuilder sb =new StringBuilder();
		try {
			openTransaction();
			for (int i = 0; i < uuids.length; i++) {
				ParameterSet set = new ParameterSet();
				set.add("Product_ID", "@Product_ID", uuids[i]);
				DataSet<DataRow> executeQuery = dao.executeQuery("getShebeiRemark", set);
				String Remark = executeQuery.get(0).getDataElement("Remark").getString();
				String CommunityPile_ID = executeQuery.get(0).getDataElement("CommunityPile_ID").getString();
				String EqBoxNum = executeQuery.get(0).getDataElement("EqBoxNum").getString();
				String EqType = executeQuery.get(0).getDataElement("EqType").getString();
				String EqVersion = executeQuery.get(0).getDataElement("EqVersion").getString();
				String EqMAC = executeQuery.get(0).getDataElement("EqMAC").getString();
				if (CommunityPile_ID == null || "".equals(CommunityPile_ID)) {
					sb.append("(��ţ�");
					sb.append(EqBoxNum);
					sb.append(",���ͣ�");
					sb.append(EqType);
					sb.append(",�ͺţ�");
					sb.append(EqVersion);
					sb.append(",MAC��");
					sb.append(EqMAC);
					sb.append(")");
					flag = false;
					continue;
				} else {
					dao.execute("insertDaipipeiInfo", set);
					
					ParameterModel model = new ParameterModel(); 
					model.put("EqSta_ID", status);
					if (!beizhu.trim().equals("")){
						if (Remark == null || Remark.trim().equals("")) {
							model.put("Remark", "״̬�����ע��" + beizhu );
						} else {
							model.put("Remark", Remark + "��״̬�����ע��" + beizhu );
						}
					}
					model.put("Update_person", getUserInfo().getEmployeeName());
					model.put("Update_time", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss") );
					ParameterModel conds = new ParameterModel(); 
					conds.put("Product_ID", uuids[i]);
					dao.update("communitypile", model, conds);
				}
			}
			commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag==false){
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�����豸��" + sb.toString() + "δ���⣬��˶ԣ�");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "״̬�ı�ɹ���");
	}
	/**
	 * �༭�����豸���������
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public CommonMessage updateXiaoquKuSheBei(KuncunForm form, HttpServletRequest request) throws Exception {
		try {
			openTransaction();
				String xiaoqukuID = form.getUUIDHidden();
				ParameterSet set = new ParameterSet();
				set.add("CommunityPile_ID", "@CommunityPile_ID",  xiaoqukuID);
				
				dao.execute("insertDaipipeiInfo", set);
				String productId = dao.executeQueryToDataRow("getProductIDfromXiaoquKuID", set).getDataElement("Product_id").getString();
				ParameterSet set1 = new ParameterSet();
				set1.add("Product_ID", "@Product_ID",  productId);
				DataRow row = dao.executeQueryToDataRow("getShebeiRemark", set1);
				String xiaoquRemark = row.getDataElement("Remark").getString();
				String rukuRemark = row.getDataElement("EqRemark").getString();
				String name =  getUserInfo(request).getEmployeeName();
				String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());// ��õ�ǰϵͳʱ��
				
				ParameterModel model = new ParameterModel();
				model.put("Install_site", form.getAnzhuangdidian());
				if (form.getAnzhuangshijian().trim().equals("")) {
					model.put("Install_time", null);
				} else {
					model.put("Install_time", form.getAnzhuangshijian());
				}
				model.put("FirstEnterDate", form.getXiaoqurukuriqi());
				model.put("Community_ID", form.getRukuxiaoqu());
				model.put("Get_person", form.getLingquren());
				model.put("Update_person", name);
				model.put("Update_time", time);
				model.put("Remark", form.getBeizhu());
				/*if (xiaoquRemark == null || xiaoquRemark.trim().equals("")){
					if (form.getBeizhu().trim().equals("")) {
//						model.put("Remark",  "�༭�ˣ�" + name + "�༭ʱ�䣺" + time );
					} else {
						model.put("Remark",  "��ע��Ϣ��" +form.getBeizhu());
					}
				} else {
					if (form.getBeizhu().trim().equals("")) {
						model.put("Remark", xiaoquRemark);
					} else {
						model.put("Remark", xiaoquRemark + "����ע��Ϣ��" +form.getBeizhu());
					}
				}*/
				
				ParameterModel conds = new ParameterModel();
				conds.put("CommunityPile_ID", xiaoqukuID);
				dao.update("communitypile", model, conds);
				
				
				ParameterModel model1 = new ParameterModel();
				model1.put("EqRegister", form.getZhuceweizhi());
				model1.put("EqIp", form.getShujuip());
				model1.put("EqMAC", form.getMac());
				model1.put("EqMCID", form.getMcid());
				if (rukuRemark == null || rukuRemark.trim().equals("")){
					model.put("EqRemark",  "��ע��Ϣ��" +form.getBeizhu());
				} else {
					model.put("EqRemark", rukuRemark + "����ע��Ϣ��" +form.getBeizhu());
				}
				model1.put("Update_person", name);
				model1.put("Update_time", time);
				ParameterModel conds1 = new ParameterModel();
				conds1.put("Product_ID", productId);
				dao.update("product", model1, conds1);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�������ݳ�������޶��˶Ժ�༭��");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "״̬�༭�ɹ���");
	}
	
	/**
	 * �༭����С��������
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String updateProduct(KuncunForm form, HttpServletRequest request) throws Exception {
		/*
		 * ���豸״̬ �ѳ��� δ���� ת���ַ���"10""1"
		 */
		String s1 = "";
		if (form.getShebeizhuangtai().equals("�ѳ���")) {
			s1 = "10";
		} else if (form.getShebeizhuangtai().equals("δ����")) {
			s1 = "1";
		}
		/*
		 *��õ�ǰ�û�����Ϣ
		 */
		Employee e=null;
		if(getUserInfo(request)!=null){
			e = (Employee) getUserInfo(request);
		}
		String name = e==null?"": e.getEmployeeName();
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());// ��õ�ǰϵͳʱ��
		/*
		 *�����¼�� recordpile
		 */
		ParameterSet set1 = new ParameterSet();
		if (form.getBeizhu() == null || form.getBeizhu().trim().equals("")){
			set1.add("beizhu", "@beizhu", " ");
		}else {
			set1.add("beizhu", "@beizhu", form.getBeizhu());
		}
		//set1.add("beizhu", "@beizhu", form.getBeizhu()==null?" ":form.getBeizhu());
		//set1.add("Create_Person", "@Create_Person", name);
		//set1.add("Create_Time", "@Create_Time", time);
		set1.add("Product_ID", "@Product_ID", form.getUUIDHidden());
		dao.execute("insertRecordPileByProductId", set1);
		
		ParameterSet set = new ParameterSet();
		set.add("product_ID", "@product_ID", form.getUUIDHidden());
		//�õ���Ʒ��ע��Ϣ
		String remark = dao.executeQueryToDataRow("getRukuBeizhu", set).getDataElement("EqRemark").getString();
		
		/*
		 * �༭���²�Ʒ��Ϣ�����ݲ�ƷID�� 
		 */
		ParameterModel model = new ParameterModel();
		model.put("Eqboxnum", form.getXianghao());
		model.put("EqInTime", form.getRukuriqi());
		model.put("EqInPerson", form.getRukuren());
		model.put("EqType", form.getShebeileixing());
		model.put("EqVersion", form.getShebeixinghao());
		model.put("EqRegister", form.getZhuceweizhi());
		model.put("EqMAC", form.getMac());
		model.put("EqMCID", form.getMcid());
		model.put("EqIp", form.getShujuip());
		/*if (form.getBeizhu() == null || form.getBeizhu().trim().equals("")){
		} else {
			if (remark == null || remark.trim().equals("")) {
				model.put("EqRemark", "�༭���ݣ�" + form.getBeizhu());
			} else {
				model.put("EqRemark", remark + "���༭���ݣ�" + form.getBeizhu());
			}
		}*/
		model.put("EqRemark", form.getBeizhu());
		model.put("Update_person", name);
		model.put("Update_time", time);
		model.put("EqIp", form.getShujuip());
		ParameterModel conds = new ParameterModel();
		conds.put("Product_ID", form.getUUIDHidden());
		dao.update("product", model, conds);
		return Constant.SUCCESS;
	}

	/**
	 * ����豸 ���쳣��
	 * @param f
	 * @return 
	 * @throws Exception 
	 */
	public CommonMessage kucunToyichangku(KuncunForm f) throws Exception {
		StringBuilder sb =new StringBuilder();
		try {
			String nowDate = Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
			String employeeName = getUserInfo().getEmployeeName();
			String status = f.getShebeizhuangtai();
			String beizhu = f.getBeizhu();
			String uuid = f.getUUIDHidden();
			String[] uuids = uuid.split(",");
			
			openTransaction();
			Integer[] seq = new Integer[uuids.length];
			ParameterSet set1 = new ParameterSet();
			for (int i = 0; i < uuids.length; i++) {
				int execute = dao.executeQueryToCount("getSEQ2", set1);
				seq[i] = execute;
			}
			commit();
			
			openTransaction();
			for (int i = 0; i < uuids.length; i++) {
			
				ParameterSet set = new ParameterSet();
			    set.add("Product_ID", "@Product_ID", uuids[i]);
				DataSet<DataRow> executeQuery = dao.executeQuery("getdinfoFromProduct", set);
				String EqStateId = executeQuery.get(0).getDataElement("EqState").getString();
				if (EqStateId.equals("10")) {
				    String	EqBoxNum  = executeQuery.get(0).getDataElement("EqBoxNum").getString();
				    String	EqType  = executeQuery.get(0).getDataElement("EqType").getString();
				    String	EqVersion  = executeQuery.get(0).getDataElement("EqVersion").getString();
				    String	EqMAC  = executeQuery.get(0).getDataElement("EqMAC").getString();
				    sb.append("(��ţ�");
					sb.append(EqBoxNum);
					sb.append(",���ͣ�");
					sb.append(EqType);
					sb.append(",�ͺţ�");
					sb.append(EqVersion);
					sb.append(",MAC��");
					sb.append(EqMAC);
					sb.append(")");
				} else {
					ParameterModel model = new ParameterModel(); 
					model.put("EqQuantity", "0");
					model.put("EqState", "10");
					ParameterModel conds = new ParameterModel(); 
					conds.put("Product_ID", uuids[i]);
					dao.update("Product", model, conds);
					
					ParameterModel model2 = new ParameterModel(); 
					model2.put("EqSta_ID", "δ����");
					model2.put("Product_ID", uuids[i]);
					model2.put("FaultPile_ID", seq[i]);
					model2.put("EnterDate", nowDate);
					model2.put("NAME", executeQuery.get(0).getDataElement("NAME").getString());
					model2.put("Price", executeQuery.get(0).getDataElement("Price").getString());
					model2.put("EqRemark", executeQuery.get(0).getDataElement("EqRemark").getString());
					model2.put("EqBoxNum", executeQuery.get(0).getDataElement("EqBoxNum").getString());
					model2.put("EqQuantity", "1");
					model2.put("EqType", executeQuery.get(0).getDataElement("EqType").getString());
					model2.put("EqVersion", executeQuery.get(0).getDataElement("EqVersion").getString());
					model2.put("EqRegister", executeQuery.get(0).getDataElement("EqRegister").getString());
					model2.put("EqMAC", executeQuery.get(0).getDataElement("EqMAC").getString());
					model2.put("EqMCID", executeQuery.get(0).getDataElement("EqMCID").getString());
					model2.put("EqInPerson", executeQuery.get(0).getDataElement("EqInPerson").getString());
					model2.put("EqInTime", executeQuery.get(0).getDataElement("EqInTime").getString());
					model2.put("EqIp", executeQuery.get(0).getDataElement("EqIp").getString());
					model2.put("Create_person", employeeName);
					model2.put("Create_time", nowDate);
					dao.insert("recordpile", model2);
					
					ParameterModel model1 = new ParameterModel(); 
					model1.put("FaultPile_ID", seq[i]);
					model1.put("Product_ID", uuids[i]);
					model1.put("Quantity", "1");
					model1.put("EqSta_ID", status);//�����ֳ�
					model1.put("FirstEnterDate", nowDate);
					model1.put("Create_person", employeeName);
					model1.put("Create_time", nowDate);
					String eqRemark = executeQuery.get(0).getDataElement("EqRemark").getString();
					if (!beizhu.trim().equals("")) {
						if (eqRemark == null || eqRemark.trim().equals("")) {
							model1.put("Remark", "״̬�쳣�����ע��" +  beizhu);
						} else {
							model1.put("Remark", eqRemark +"��״̬�쳣�����ע��" +  beizhu);
						}
					} else {
						model1.put("Remark", eqRemark);
					}
					dao.insert("communitypile", model1);
				}
			}
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�豸�쳣�Ǽ�ʧ�ܣ�");
		}
		if(sb.toString().equals("")) {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�豸�쳣�Ǽǳɹ���");
		} else {
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�豸��" + sb.toString() + "�ѳ���");
		}
	}
	
	/**
	 * �豸�쳣 �Ǽ�  С����  ��
	 * @param f
	 * @return
	 * @throws Exception
	 */
	public CommonMessage xiaoquToyichangku(KuncunForm f) throws Exception {
		try {
			String nowDate = Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
			String employeeName = getUserInfo().getEmployeeName();
			String status = f.getShebeizhuangtai();
			String beizhu = f.getBeizhu();
			String uuid = f.getUUIDHidden();
			String[] uuids = uuid.split(",");
			
			openTransaction();
			Integer[] seq = new Integer[uuids.length];
			ParameterSet set1 = new ParameterSet();
			for (int i = 0; i < uuids.length; i++) {
				int execute = dao.executeQueryToCount("getSEQ2", set1);
				seq[i] = execute;
			}
			commit();
			
			openTransaction();
			for (int i = 0; i < uuids.length; i++) {
				ParameterSet set = new ParameterSet();
			    set.add("CommunityPile_ID", "@CommunityPile_ID", uuids[i]);
			    dao.execute("insertDaipipeiInfo", set);
				DataSet<DataRow> executeQuery = dao.executeQuery("GetXiaoQuKuDataList", set);
				String eqRemark = executeQuery.get(0).getDataElement("eqremark").getString();
				
				ParameterModel model = new ParameterModel(); 
				model.put("EqSta_ID", status);
				model.put("Update_person", employeeName);
				model.put("Update_time", nowDate);
				model.put("FaultPile_ID", seq[i]);
				if (!beizhu.trim().equals("")) {
					if (eqRemark == null || eqRemark.trim().equals("")) {
						model.put("Remark", "״̬�쳣�����ע��" +  beizhu);
					} else {
						model.put("Remark", eqRemark +"��״̬�쳣�����ע��" +  beizhu);
					}
				} else {
					model.put("Remark", eqRemark);
				}
				ParameterModel conds = new ParameterModel(); 
				conds.put("CommunityPile_ID", uuids[i]);
				dao.update("communitypile", model, conds);
				
			}
			
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�豸�쳣�Ǽ�ʧ�ܣ�");
		}
		
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�豸�쳣�Ǽǳɹ���");
		
	}

	
	/**
	 * �༭���°�װ������
	 * @param form
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public CommonMessage updateAnzhuangKuSheBei(KuncunForm form,
			HttpServletRequest request) throws Exception {
		String productId = form.getUUIDHidden();
		String name = getUserInfo().getEmployeeName();
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());// ��õ�ǰϵͳʱ��
		openTransaction();
		try {
			ParameterSet set = new ParameterSet();
			set.add("Product_ID", "@Product_ID", productId);
			dao.execute("insertDaipipeiInfo", set);
			DataRow row = dao.executeQueryToDataRow("getShebeiRemark", set);
			String xiaoquRemark = row.getDataElement("Remark").getString();
			String rukuRemark = row.getDataElement("EqRemark").getString();
		
			String xiaoqukuID = dao.executeQueryToDataRow("isInCommunity", set).getDataElement("CommunityPile_ID").getString();
		
			ParameterModel model = new ParameterModel();
			model.put("Install_site", form.getAnzhuangdidian());
			model.put("Install_time", form.getAnzhuangshijian());
			model.put("FirstEnterDate", form.getXiaoqurukuriqi());
			model.put("Community_ID", form.getRukuxiaoqu());
			model.put("Get_person", form.getLingquren());
			model.put("Update_person", name);
			model.put("Update_time", time);
			model.put("Remark", form.getBeizhu());
	/*		if (xiaoquRemark == null || xiaoquRemark.trim().equals("")){
				if (form.getBeizhu().trim().equals("")) {
					//model.put("Remark",  "�༭�ˣ�" + name + "�༭ʱ�䣺" + time );
				} else {
					model.put("Remark",  "��ע��Ϣ��" +form.getBeizhu());
				}
			} else {
				if (form.getBeizhu().trim().equals("")) {
					model.put("Remark", xiaoquRemark );
				} else {
					model.put("Remark", xiaoquRemark + "����ע��Ϣ��" +form.getBeizhu());
				}
			}*/
			
			ParameterModel conds = new ParameterModel();
			conds.put("CommunityPile_ID", xiaoqukuID);
			dao.update("communitypile", model, conds);
			
			
			ParameterModel model1 = new ParameterModel();
			model1.put("EqRegister", form.getZhuceweizhi());
			model1.put("EqIp", form.getShujuip());
			model1.put("EqMAC", form.getMac());
			model1.put("EqMCID", form.getMcid());
			/*if (rukuRemark == null || rukuRemark.trim().equals("")){
				model.put("EqRemark",  "��ע��Ϣ��" +form.getBeizhu());
			} else {
				model.put("EqRemark", rukuRemark + "����ע��Ϣ��" +form.getBeizhu());
			}*/
			model1.put("Update_person", name);
			model1.put("Update_time", time);
			ParameterModel conds1 = new ParameterModel();
			conds1.put("Product_ID", productId);
			dao.update("product", model1, conds1);
			
	
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG , "��������̫������˶Ժ�༭��");
		}
		return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG , "���ݱ༭�ɹ���");
	}
	
	/**
	 * �༭�����쳣�������
	 * @param form
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public void updateYichangKuSheBei(KuncunForm form,
			HttpServletRequest request) throws Exception {
		try {
			String name = getUserInfo().getEmployeeName();
			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());// ��õ�ǰϵͳʱ��
			String uuid = form.getUUIDHidden();
			ParameterSet set = new ParameterSet();
			set.add("Product_ID", "@Product_ID", uuid);
			//String FaultPile_ID = dao.executeQueryToDataRow("getShebeiRemark", set).getDataElement("FaultPile_ID").getString();
			openTransaction();
		
			ParameterSet set1 = new ParameterSet();
			set1.add("beizhu", "@beizhu", "�༭�ˣ�" + name + "�༭ʱ�䣺" + time);
			set1.add("Create_Person", "@Create_Person", name);
			set1.add("Create_Time", "@Create_Time", time);
			set1.add("Product_ID", "@Product_ID", uuid);
			dao.execute("insertRecordPileFromyichangKu", set1);
			
			
		/*
		 * getShebeizhuangtaiΪ1 ���� �ֿ�  δ���
		 */
			if (form.getShebeizhuangtai().equals("1")) {
				ParameterModel model1 = new ParameterModel();
				model1.put("EqState", form.getShebeizhuangtai());
				model1.put("EqBoxNum", form.getXianghao());
				model1.put("EqInTime",form.getRukuriqi());
				model1.put("EqInPerson", form.getRukuren());
				model1.put("EqType", form.getShebeileixing());
				model1.put("EqVersion", form.getShebeixinghao());
				model1.put("EqMAC", form.getMac());
				model1.put("EqMCID", 	form.getMcid());
				model1.put("EqRemark", 	form.getBeizhu());
				model1.put("EqQuantity", "1");
				model1.put("Update_person", name);
				model1.put("Update_time", 	time);
				ParameterModel conds = new ParameterModel();
				conds.put("Product_ID", uuid);
				dao.update("product", model1, conds);
				
				dao.execute("DeletecommunitypileInfo", set);
			} else {
				ParameterModel model = new ParameterModel();
				model.put("EqSta_Id", form.getShebeizhuangtai());
				ParameterModel conds = new ParameterModel();
				conds.put("Product_ID", uuid);
				dao.update("communitypile", model, conds);
				
				ParameterModel model1 = new ParameterModel();
				model1.put("EqBoxNum", form.getXianghao());
				model1.put("EqInTime",form.getRukuriqi());
				model1.put("EqInPerson", form.getRukuren());
				model1.put("EqType", form.getShebeileixing());
				model1.put("EqVersion", form.getShebeixinghao());
				model1.put("EqMAC", form.getMac());
				model1.put("EqMCID", 	form.getMcid());
				model1.put("EqRemark", 	form.getBeizhu());
				model1.put("Update_person", name);
				model1.put("Update_time", 	time);
				ParameterModel conds1 = new ParameterModel();
				conds1.put("Product_ID", uuid);
				dao.update("product", model1, conds1);
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commit();
	}
	

	public ActionForward WhereIsIn(KuncunForm f, String uUID, ActionMapping mapping) {
		KucunDataService  kcDataService = new KucunDataService();
		try {
			ParameterSet set = new ParameterSet();
			set.add("Product_ID", "@Product_ID", uUID);
			String communityId = dao.executeQueryToDataRow("isInCommunity", set).getDataElement("Community_ID").getString();
			if (communityId == null || communityId.trim().equals("")) { 
				f = getKucunform_ByID(uUID,f);
				f.setZhuangtaiHidden(f.getZhuangtai());
				List<CommonModule> statusList = kcDataService.getStatus4CodeAll();
				f.setStatusList(statusList);
				List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
				f.setXiaoquList(xiaoquList);
				List<CommonModule> yunweiList = kcDataService.getYunweiAll();
				f.setUserNameList(yunweiList);
				return mapping.findForward("init.edit1");
			} else {
				f = getAnZhuangKuform_ByID(uUID,f);
				f.setZhuangtaiHidden(f.getZhuangtai());
				List<CommonModule> statusList = kcDataService.getStatus24CodeAll();
				f.setStatusList(statusList);
				List<CommonModule> xiaoquList = kcDataService.getXiaoquCodeAll();
				f.setXiaoquList(xiaoquList);
				List<CommonModule> yunweiList = kcDataService.getlingqurenID();
				f.setUserNameList(yunweiList);
				return mapping.findForward("init.edit2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("init.edit2");
	}

	/**
	 * ɾ��δ������Ʒ
	 * @param f
	 * @return 
	 * @throws Exception 
	 */
	public CommonMessage deleteShebeiData(KuncunForm f) throws Exception {
		try {
			String []uuids = f.getUUIDS();
			openTransaction();
			for (int i = 0; i < uuids.length; i++) {
				ParameterSet set = new ParameterSet();
				set.add("Product_ID", "@Product_ID", uuids[i]);
				String eqSta_Name = dao.executeQueryToDataRow("getkucunShebeizhuangtai", set).getDataElement("EqSta_Name").getString();
				if (eqSta_Name.trim().equals("δ����")) {
					ParameterModel model = new ParameterModel();
					model.put("Lifecycle_sta", "1");
					ParameterModel conds = new ParameterModel();
					conds.put("Product_ID", uuids[i]);
					dao.update("Product", model, conds);
				} else {
					rollback();
					return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "���豸�ѳ��⣬����ɾ����");
				}
			}
			commit();
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�����쳣��");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ɾ���ɹ���");
	}

	/**
	 * С����   �豸�ƿ�
	 * @param f
	 * @return
	 * @throws Exception 
	 */
	public CommonMessage xiaoqukutoxiaoquku(KuncunForm form) throws Exception {
		try {
			String rukuriqi = form.getRukuriqi();
			String rukuxiaoquId = form.getRukuxiaoqu();
			String lingqurenId = form.getLingquren();
			String beizhu = form.getBeizhu();
			String uuid = form.getUUIDHidden();
			String[] uuids = uuid.split(",");
			String nowDate = Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
			String employeeName = getUserInfo().getEmployeeName();
			openTransaction();
			for (int i = 0; i < uuids.length; i++) {
				/*
				 *��¼��������� 
				 */
				ParameterSet set = new ParameterSet();
				set.add("CommunityPile_ID", "@CommunityPile_ID", uuids[i]);
				dao.execute("insertDaipipeiInfo", set);
				String remark = dao.executeQueryToDataRow("getXiaoqukuBeizhu", set).getDataElement("Remark").getString();
				
				/*
				 * ����С��������
				 */
				ParameterModel model = new ParameterModel(); 
				model.put("FirstEnterDate", rukuriqi);
				model.put("Community_ID", rukuxiaoquId);
				model.put("Get_Person", lingqurenId);
				model.put("Update_person", employeeName);
				model.put("Update_time", nowDate);
				if (!beizhu.trim().equals("")) {
					if (remark != null && !remark.trim().equals("")) {
						model.put("Remark", remark + "���ƿⱸע��" + beizhu);
					} else {
						model.put("Remark", "�ƿⱸע��" + beizhu);
					}
				}
				ParameterModel conds = new ParameterModel(); 
				conds.put("CommunityPile_ID", uuids[i]);
				dao.update("communitypile", model, conds);
			}
			
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�豸�ƿ�ʧ�ܣ���˶����ݣ�");
		}
		commit();
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ƿ�ɹ���");
	}
	
	/**
	 *�쳣�� �豸�ƿ�
	 * @param f
	 * @return
	 * @throws Exception 
	 */
	public CommonMessage yichangkutoxiaoquku(KuncunForm form) throws Exception {
		try {
			String rukuriqi = form.getRukuriqi();
			String rukuxiaoquId = form.getRukuxiaoqu();
			String lingqurenId = form.getLingquren();
			String beizhu = form.getBeizhu();
			String uuid = form.getUUIDHidden();
			String[] uuids = uuid.split(",");
			String nowDate = Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
			String employeeName = getUserInfo().getEmployeeName();
			openTransaction();
			for (int i = 0; i < uuids.length; i++) {
				/*
				 *��¼��������� 
				 */
				ParameterSet set = new ParameterSet();
				set.add("Product_ID", "@Product_ID", uuids[i]);
				dao.execute("insertDaipipeiInfo", set);
				String remark = dao.executeQueryToDataRow("getShebeiRemark", set).getDataElement("Remark").getString();
				
				/*
				 * ����С��������
				 */
				ParameterModel model = new ParameterModel(); 
				model.put("FirstEnterDate", rukuriqi);
				model.put("Community_ID", rukuxiaoquId);
				model.put("Get_Person", lingqurenId);
				model.put("Update_person", employeeName);
				model.put("Update_time", nowDate);
				if (!beizhu.trim().equals("")) {
					if (remark != null && !remark.trim().equals("")) {
						model.put("Remark", remark + "���ƿⱸע��" + beizhu);
					} else {
						model.put("Remark", "�ƿⱸע��" + beizhu);
					}
				}
				ParameterModel conds = new ParameterModel(); 
				conds.put("Product_ID", uuids[i]);
				dao.update("communitypile", model, conds);
			}
			
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�豸�ƿ�ʧ�ܣ���˶����ݣ�");
		}
		commit();
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ƿ�ɹ���");
	}

	public DataSet<DataRow> getZongkufangInfoList(ZongkufangInfoForm form,
			int first, int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQuery("getZongkufangInfoList", set, first, rows);
	}
	public int getZongkufangInfoListCount(ZongkufangInfoForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQueryToCount("getZongkufangInfoListCount", set);
	}
	/**
	 * �༭�����豸���������
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public CommonMessage insertZongkufang(ZongkufangInfoForm form, HttpServletRequest request) throws Exception {
		try {
				openTransaction();
				ParameterModel model1 = new ParameterModel();
				model1.put("Zongkufang_ID", form.getZongkufang_ID());
				model1.put("EqType", form.getEqType());
				model1.put("EqVersion", form.getEqVersion());
				model1.put("kucunSuu", form.getKucunSuu());
				model1.put("Remark", form.getRemark());
				dao.insert("zongkufanginfo", model1);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�������ݳ�������޶��˶Ժ�༭��");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�ܿⷿ��Ϣ���ӳɹ���");
	}
	/**
	 * �༭�����豸���������
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public CommonMessage updateZongkufang(ZongkufangInfoForm form, HttpServletRequest request) throws Exception {
		try {
				openTransaction();
				ParameterSet set = new ParameterSet();
				set.add("UUID", "@UUID", form.getUUID());
				String kucunsuu = dao.executeQueryToDataRow("getZongkufangKucunsuu", set).getDataElement("kucunSuu").getString();
				int kucunsuunew = 0;
				if("���".equals(form.getOperateType())) {
					kucunsuunew = Integer.valueOf(kucunsuu)+form.getOperateSuu();
				}else{
					kucunsuunew = Integer.valueOf(kucunsuu)-form.getOperateSuu();
				}
				ParameterModel model = new ParameterModel(); 
				model.put("kucunSuu", kucunsuunew);
				ParameterModel conds = new ParameterModel(); 
				conds.put("UUID", form.getUUID());
				dao.update("zongkufanginfo", model, conds);
				ParameterModel model1 = new ParameterModel();
				model1.put("OperateinfoId", form.getUUID());
				model1.put("OperateType", form.getOperateType());
				model1.put("OperateTime", form.getOperateTime());
				model1.put("OperateSuu", form.getOperateSuu());
				if(!"".equals(form.getOperateStore())) {
					model1.put("OperateStore", form.getOperateStore());
				}
				model1.put("Remark", form.getRemark());
				dao.insert("zongkufanglog", model1);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�������ݳ�������޶��˶Ժ�༭��");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "�ܿⷿ���������ɹ���");
	}
	public DataSet<DataRow> getZongkufangLogList(ZongkufangInfoForm form,
			int first, int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("OperateType", "@OperateType", form.getOperateType());
		set.add("OperateTime", "@OperateTime", form.getOperateTime());
		set.add("OperateStore", "@OperateStore", form.getOperateStore());
		return dao.executeQuery("getZongkufangLogList", set, first, rows);
	}
	public int getZongkufangLogListCount(ZongkufangInfoForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQueryToCount("getZongkufangLogListCount", set);
	}
}
