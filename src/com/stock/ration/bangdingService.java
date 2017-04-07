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
		String type = null;//所选设备类别
		
		String PGDUUID = form.getPgdUUID();
		String eqpUUID = form.getUUID();
		//查询出PGD 对象
		DataRow dateRowPGD = getPGDByUUID(PGDUUID);
		
		//已经指定数量
		int num = dateRowPGD.getDataElement("tvzhidingnum").getInt();
		//iptv数量
		int tfiptv = dateRowPGD.getDataElement("tfiptv").getInt();
		//剩余指定数量
		int shengyu = tfiptv - num;
		
		//查询出设备 对象
		DataRow	dateRowEqp = getEquipByUUID(eqpUUID);
		//设备类别
		String EqpType = dateRowEqp.getDataElement("TYPE").getString();
		
		//判断pgd 是否有对象的设备需求，没有抛出异常。
		//如果没有问题，则将设备对象mac地址插入pgd中。同时修改设备状态 “2”
		if(EqpType.equals("ONU")){
			type="1";
			if(dateRowPGD.getDataElement("onu").getString()=="0"
					||dateRowPGD.getDataElement("onu").getString().equals("")){
				//抛出异常  该派工单没有OUN需求   2012年6月20日 更改为每个都有onu
				//error = "PGD_ONU_NULL";
				
			}else{
				if(dateRowPGD.getDataElement("OUMMAC").getString()!=null
						&&!dateRowPGD.getDataElement("OUMMAC").getString().equals("")){
					error="PGD_ONU_EXIST";//ONU已经绑定！ 
				}
				
			}
		}else if(EqpType.equals("机顶盒")){
			type="2";
			if(dateRowPGD.getDataElement("tfiptv").getString()=="0"
					||dateRowPGD.getDataElement("tfiptv").getString().equals("")){
				//抛出异常 该派工单没有 机顶盒 需求
				error = "PGD_STB_NULL";
				
			}else{
				if(shengyu==0){
					error="PGD_STB_EXIST";//机顶盒已经绑定完成！ 
				}
			}
		}
		
		//如果error 不为空 抛出异常
		if(error!=null){
			return error;
		}
		
		
		try {
			openTransaction();
		if(type=="1"){
			//如果是 onu  更新pgd 更新 ONUMAC   、设备状态更新 已指定 
			ParameterSet set1 = new ParameterSet();
			set1.add("OUMMAC", "@OUMMAC", dateRowEqp.getDataElement("mac").getString());//OUNMAC
			set1.add("UUID", "@UUID", PGDUUID);//PGD UUID
			set1.add("state", "@state","4");//支配中
			set1.add("onuzhiding", "@onuzhiding", "0");
			dao.execute("updateONUMAC",set1);
			
			ParameterSet set2 = new ParameterSet();
			set2.add("state", "@state", "2");//设备状态
			//设置出库日期，这里为派工日期。
			set2.add("chukudate", "@chukudate", dateRowPGD.getDataElement("paigongriqi").getString());
			//安装地点 这里是小区+地址
			set2.add("anzhuangplace", "@anzhuangplace", 
					dateRowPGD.getDataElement("xiaoquname").getString()+dateRowPGD.getDataElement("userplace").getString());
			set2.add("UUID", "@UUID", eqpUUID);//设备UUID
			dao.execute("updateEQPstate",set2);
			commit();
		}else{
			
			ParameterSet set1 = new ParameterSet();
			if(dateRowPGD.getDataElement("STBMAC").getString()!=null){
				set1.add("STBMAC", "@STBMAC", 
						dateRowPGD.getDataElement("STBMAC").getString()+"  "+ dateRowEqp.getDataElement("mac").getString());//叠加mac
			}else{
				set1.add("STBMAC", "@STBMAC", dateRowEqp.getDataElement("mac").getString());//叠加mac
			}
			
			set1.add("UUID", "@UUID", PGDUUID);
			int tvzhidingnum = dateRowPGD.getDataElement("tvzhidingnum").getInt()+1;
			//String tvzhidingnumstring =  ;
			set1.add("tvzhidingnum", "@tvzhidingnum", String.valueOf(tvzhidingnum));
			set1.add("state", "@state","4");//支配中
			//更新派工单
			dao.execute("updateSTBMAC",set1);
			
			//这里要将待指定的机顶盒信息写入jidinghe表中
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
			set2.add("state", "@state", "2");//设备状态
			//设置出库日期，这里为派工日期。
			set2.add("chukudate", "@chukudate", dateRowPGD.getDataElement("paigongriqi").getString());
			//安装地点 这里是小区+地址
			set2.add("anzhuangplace", "@anzhuangplace", 
					dateRowPGD.getDataElement("xiaoquname").getString()+dateRowPGD.getDataElement("userplace").getString());
			
			set2.add("UUID", "@UUID", eqpUUID);
			
			dao.execute("updateEQPstate",set2);
			commit();
		}
		//全不为空 onu不为空 jidinghe不为空 ； onu不为空机顶盒为空 ；onu为空机顶盒不为空
		updatePGD(PGDUUID);
		
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
		}
	
	/**
	 * 根据UUID查询配工单详情
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
	 * 根据UUID查询设备详情
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
	 * 更新派工单为已指定2
	 * @param PGDUUID
	 * @throws Exception
	 */
	public void updatePGD(String PGDUUID) throws Exception{
		String up = "1";//是否更新pgd状态为已指定
		DataRow dateRowPGDNew = getPGDByUUID(PGDUUID);
		System.out.println(dateRowPGDNew.getDataElement("OUMMAC").getString());
		System.out.println(dateRowPGDNew.getDataElement("STBMAC").getString());
		System.out.println(dateRowPGDNew.getDataElement("onu").getString());
		System.out.println(dateRowPGDNew.getDataElement("jidinghe").getString());
		

		//已经指定数量
		int num = dateRowPGDNew.getDataElement("tvzhidingnum").getInt();
		//iptv数量
		int tfiptv = dateRowPGDNew.getDataElement("tfiptv").getInt();
		//剩余指定数量
		int shengyu = tfiptv - num;
		
		String zhidingonu = dateRowPGDNew.getDataElement("onuzhiding").getString();
		if(shengyu==0&&zhidingonu.equals("0")){//如果机顶盒剩余指定数以及onu指定数全为0 则更新状态为已指定
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
			//更新pgd状态为 已分配
			ParameterSet set3 = new ParameterSet();
			set3.add("state", "@state", "2");
			set3.add("UUID", "@UUID", PGDUUID);
			dao.execute("updatePGDstateto2",set3);
			commit();
		}*/
	}
}
