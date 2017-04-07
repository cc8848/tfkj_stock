package com.stock.ration;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class bangdingService extends BusinessService{

private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	public String bangding(rationSecondForm form) throws Exception {
		/*String error = validator.updateValidate(form);
		if(error != null){
			return error;
		}*/
		String error = null;
		String type = null;//��ѡ�豸���
		
		String PGDUUID = form.getPgdUUID();
		String eqpUUID = form.getUUID();
		//��ѯ��PGD ����
		DataRow dateRowPGD = getPGDByUUID(PGDUUID);
		
		//�Ѿ�ָ������
		int num = dateRowPGD.getDataElement("tvzhidingnum").getInt();
		//iptv����
		int tfiptv = dateRowPGD.getDataElement("tfiptv").getInt();
		//ʣ��ָ������
		int shengyu = tfiptv - num;
		
		//��ѯ���豸 ����
		DataRow	dateRowEqp = getEquipByUUID(eqpUUID);
		//�豸���
		String EqpType = dateRowEqp.getDataElement("TYPE").getString();
		
		//�ж�pgd �Ƿ��ж�����豸����û���׳��쳣��
		//���û�����⣬���豸����mac��ַ����pgd�С�ͬʱ�޸��豸״̬ ��2��
		if(EqpType.equals("ONU")){
			type="1";
			if(dateRowPGD.getDataElement("onu").getString()=="0"
					||dateRowPGD.getDataElement("onu").getString().equals("")){
				//�׳��쳣  ���ɹ���û��OUN����   2012��6��20�� ����Ϊÿ������onu
				//error = "PGD_ONU_NULL";
				
			}else{
				if(dateRowPGD.getDataElement("OUMMAC").getString()!=null
						&&!dateRowPGD.getDataElement("OUMMAC").getString().equals("")){
					error="PGD_ONU_EXIST";//ONU�Ѿ��󶨣� 
				}
				
			}
		}else if(EqpType.equals("������")){
			type="2";
			if(dateRowPGD.getDataElement("tfiptv").getString()=="0"
					||dateRowPGD.getDataElement("tfiptv").getString().equals("")){
				//�׳��쳣 ���ɹ���û�� ������ ����
				error = "PGD_STB_NULL";
				
			}else{
				if(shengyu==0){
					error="PGD_STB_EXIST";//�������Ѿ�����ɣ� 
				}
			}
		}
		
		//���error ��Ϊ�� �׳��쳣
		if(error!=null){
			return error;
		}
		
		
		try {
			openTransaction();
		if(type=="1"){
			//����� onu  ����pgd ���� ONUMAC   ���豸״̬���� ��ָ�� 
			ParameterSet set1 = new ParameterSet();
			set1.add("OUMMAC", "@OUMMAC", dateRowEqp.getDataElement("mac").getString());//OUNMAC
			set1.add("UUID", "@UUID", PGDUUID);//PGD UUID
			set1.add("state", "@state","4");//֧����
			set1.add("onuzhiding", "@onuzhiding", "0");
			dao.execute("updateONUMAC",set1);
			
			ParameterSet set2 = new ParameterSet();
			set2.add("state", "@state", "2");//�豸״̬
			//���ó������ڣ�����Ϊ�ɹ����ڡ�
			set2.add("chukudate", "@chukudate", dateRowPGD.getDataElement("paigongriqi").getString());
			//��װ�ص� ������С��+��ַ
			set2.add("anzhuangplace", "@anzhuangplace", 
					dateRowPGD.getDataElement("xiaoquname").getString()+dateRowPGD.getDataElement("userplace").getString());
			set2.add("UUID", "@UUID", eqpUUID);//�豸UUID
			dao.execute("updateEQPstate",set2);
			commit();
		}else{
			
			ParameterSet set1 = new ParameterSet();
			if(dateRowPGD.getDataElement("STBMAC").getString()!=null){
				set1.add("STBMAC", "@STBMAC", 
						dateRowPGD.getDataElement("STBMAC").getString()+"  "+ dateRowEqp.getDataElement("mac").getString());//����mac
			}else{
				set1.add("STBMAC", "@STBMAC", dateRowEqp.getDataElement("mac").getString());//����mac
			}
			
			set1.add("UUID", "@UUID", PGDUUID);
			int tvzhidingnum = dateRowPGD.getDataElement("tvzhidingnum").getInt()+1;
			//String tvzhidingnumstring =  ;
			set1.add("tvzhidingnum", "@tvzhidingnum", String.valueOf(tvzhidingnum));
			set1.add("state", "@state","4");//֧����
			//�����ɹ���
			dao.execute("updateSTBMAC",set1);
			
			//����Ҫ����ָ���Ļ�������Ϣд��jidinghe����
			ParameterModel model = new ParameterModel();
			model.put("pgdUUID", dateRowPGD.getDataElement("PK_ID").getString());
			model.put("equipUUID", dateRowEqp.getDataElement("PK_ID").getString());
			model.put("mac", dateRowEqp.getDataElement("mac").getString());
		//	model.put("tvip", value)
			model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			Employee emp = getUserInfo();
			model.put("createby", emp.getEmployeeName());
			dao.insert("jidinghe",model);
			
			
			ParameterSet set2 = new ParameterSet();
			set2.add("state", "@state", "2");//�豸״̬
			//���ó������ڣ�����Ϊ�ɹ����ڡ�
			set2.add("chukudate", "@chukudate", dateRowPGD.getDataElement("paigongriqi").getString());
			//��װ�ص� ������С��+��ַ
			set2.add("anzhuangplace", "@anzhuangplace", 
					dateRowPGD.getDataElement("xiaoquname").getString()+dateRowPGD.getDataElement("userplace").getString());
			
			set2.add("UUID", "@UUID", eqpUUID);
			
			dao.execute("updateEQPstate",set2);
			commit();
		}
		//ȫ��Ϊ�� onu��Ϊ�� jidinghe��Ϊ�� �� onu��Ϊ�ջ�����Ϊ�� ��onuΪ�ջ����в�Ϊ��
		updatePGD(PGDUUID);
		
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
		}
	
	/**
	 * ����UUID��ѯ�乤������
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getPGDByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("GetPGDByUUID",set);
	}
	
	/**
	 * ����UUID��ѯ�豸����
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getEquipByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("GetEquipById",set);
	}
	 
	/**
	 * �����ɹ���Ϊ��ָ��2
	 * @param PGDUUID
	 * @throws Exception
	 */
	public void updatePGD(String PGDUUID) throws Exception{
		String up = "1";//�Ƿ����pgd״̬Ϊ��ָ��
		DataRow dateRowPGDNew = getPGDByUUID(PGDUUID);
		System.out.println(dateRowPGDNew.getDataElement("OUMMAC").getString());
		System.out.println(dateRowPGDNew.getDataElement("STBMAC").getString());
		System.out.println(dateRowPGDNew.getDataElement("onu").getString());
		System.out.println(dateRowPGDNew.getDataElement("jidinghe").getString());
		

		//�Ѿ�ָ������
		int num = dateRowPGDNew.getDataElement("tvzhidingnum").getInt();
		//iptv����
		int tfiptv = dateRowPGDNew.getDataElement("tfiptv").getInt();
		//ʣ��ָ������
		int shengyu = tfiptv - num;
		
		String zhidingonu = dateRowPGDNew.getDataElement("onuzhiding").getString();
		if(shengyu==0&&zhidingonu.equals("0")){//���������ʣ��ָ�����Լ�onuָ����ȫΪ0 �����״̬Ϊ��ָ��
			ParameterSet set3 = new ParameterSet();
			set3.add("state", "@state", "2");
			set3.add("UUID", "@UUID", PGDUUID);
			dao.execute("updatePGDstateto2",set3);
			commit();
		}
		//if(dateRowPGDNew.get)
		
		/*if(!dateRowPGDNew.getDataElement("onu").getString().equals("")
				&&!dateRowPGDNew.getDataElement("jidinghe").getString().equals("")){
			if(null!=dateRowPGDNew.getDataElement("OUMMAC").getString()
					&&null!=dateRowPGDNew.getDataElement("STBMAC").getString()){
				up="2";
			}
		}else if(!dateRowPGDNew.getDataElement("onu").getString().equals("")
				//&&dateRowPGDNew.getDataElement("jidinghe").getString()==null
				){
			if(null!=dateRowPGDNew.getDataElement("OUMMAC").getString()){
				up="2";
			}
		}else if(!dateRowPGDNew.getDataElement("jidinghe").getString().equals("")){
			if(null!=dateRowPGDNew.getDataElement("STBMAC").getString()){
				up="2";
			}
		}
		
		if(up=="2"){
			//����pgd״̬Ϊ �ѷ���
			ParameterSet set3 = new ParameterSet();
			set3.add("state", "@state", "2");
			set3.add("UUID", "@UUID", PGDUUID);
			dao.execute("updatePGDstateto2",set3);
			commit();
		}*/
	}
}
