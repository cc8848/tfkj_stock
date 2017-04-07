package com.stock.userInfomation;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class ChangeEquipService extends BusinessService{
	
	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(ChangeEquipForm form){
		ParameterSet set = new ParameterSet();
		set.add("type", "@type", form.getType());//类型  
		set.add("state", "@state", "1");
		set.add("xinghao", "@xinghao", form.getXinghaoHidden()+ "%");
		set.add("mac", "@mac", form.getMacHidden() + "%");
		set.add("xianghao", "@xianghao",form.getXianghaoHidden()+"%");//箱号
		
		set.add("chukuplace", "@chukuplace", form.getChukuplace());//库存位置
		return set;
	}
	
	public DataSet<DataRow> getResult(ChangeEquipForm form, int first, int rows)
			throws Exception {
		return dao.executeQuery("GetEquipList",getConditionParameterSet(form), first, rows);
	}
	
	public int getResultCount(ChangeEquipForm form) throws Exception {
		return dao.executeQueryToCount("GetEquipListCount",getConditionParameterSet(form));
	}
	
	/**
	 * 更换onu设备方法
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String changeEquipONU(ChangeEquipForm form)throws Exception{
		String eqpUUID = form.getEqpUUID();
		String KehuUUID = form.getUUID();
		DataRow equData = getEqp(eqpUUID);//获取所选设备对象
		DataRow kehuData = getkehu(KehuUUID);//获取客户资料对象信息
		try {
			openTransaction();

			//设置被更换设备为已损坏
			ParameterSet oldEquSet = new ParameterSet();
			oldEquSet.add("state", "@state", "4");
			oldEquSet.add("mac", "@mac", kehuData.getDataElement("onumac").getString());
			dao.execute("updateOldEquState",oldEquSet);
			
			//更换onu mac  所有记录 where onumac = ‘’
			ParameterSet set = new ParameterSet();
			set.add("onumac", "@onumac", equData.getDataElement("mac").getString());
			set.add("dizi", "@dizi", kehuData.getDataElement("dizi").getString());
			dao.execute("changeEquBYfanghao",set);
			
			
			//将所选设备状态置为出库已确认
			ParameterSet newEquset = new ParameterSet();
			newEquset.add("state", "@state", "3");
			newEquset.add("UUID", "@UUID", equData.getDataElement("PK_ID").getString());
			newEquset.add("chukudate", "@chukudate", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));//出库时间
			newEquset.add("anzhuangplace", "@anzhuangplace", kehuData.getDataElement("xiaoquname").getString()
					+kehuData.getDataElement("dizi").getString());
			dao.execute("updateEquByUUID",newEquset);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 更换onu设备方法
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String changeEquipJidinghe(ChangeEquipForm form)throws Exception{
		String eqpUUID = form.getEqpUUID();
		String KehuUUID = form.getUUID();
		DataRow equData = getEqp(eqpUUID);//获取所选设备对象
		DataRow kehuData = getkehu(KehuUUID);//获取客户资料对象信息
		try {
			openTransaction();

			//设置被更换设备为已损坏
			ParameterSet oldEquSet = new ParameterSet();
			oldEquSet.add("state", "@state", "4");
			oldEquSet.add("mac", "@mac", kehuData.getDataElement("stbmac").getString());
			dao.execute("updateOldEquState",oldEquSet);
			
			//更换机顶盒 stbmac  
			ParameterSet set = new ParameterSet();
			set.add("stbmac", "@stbmac", equData.getDataElement("mac").getString());
			set.add("UUID", "@UUID", kehuData.getDataElement("PK_ID").getString());
			dao.execute("changeEquBYUUID",set);
			
			
			//将所选设备状态置为出库已确认
			ParameterSet newEquset = new ParameterSet();
			newEquset.add("state", "@state", "3");
			newEquset.add("UUID", "@UUID", equData.getDataElement("PK_ID").getString());
			newEquset.add("chukudate", "@chukudate", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			newEquset.add("anzhuangplace", "@anzhuangplace", kehuData.getDataElement("xiaoquname").getString()
					+kehuData.getDataElement("dizi").getString());
			dao.execute("updateEquByUUID",newEquset);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
	
	/**
	 * 获取设备对象
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public DataRow getEqp(String UUID)throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", UUID);
		return dao.executeQueryToDataRow("GetEquipById",set);
		
	}
	/**
	 * 获取客户信息对象
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public DataRow getkehu(String UUID)throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", UUID);
		return dao.executeQueryToDataRow("GetUserinfoByUUID",set);
	}
}

