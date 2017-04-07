package com.stock.chukuqueren;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

/** 
 * @author wangdl 
 * @version ����ʱ�䣺2012-6-13 ����09:07:17 
 * ��˵�� 
 */
public class EquipStockChuKuService extends BusinessService{
	
	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(EquipStockChuKuForm form){
		ParameterSet set = new ParameterSet();
		set.add("type", "@type", form.getTypeHidden() + "%");
		set.add("state", "@state", form.getStateHidden());//���ÿ��״̬Ϊ �ѳ���
		set.add("xinghao", "@xinghao", form.getXinghaoHidden() + "%");
		set.add("mac", "@mac", form.getMacHidden() + "%");
		return set;
	}
	
	public DataSet<DataRow> getResult(EquipStockChuKuForm form, int first, int rows)
			throws Exception {
		return dao.executeQuery("GetEquipListByQR",getConditionParameterSet(form), first, rows);
	}
	
	public int getResultCount(EquipStockChuKuForm form) throws Exception {
		return dao.executeQueryToCount("GetEquipListCountByQR",getConditionParameterSet(form));
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
	 * ����ȷ�ϸ���
	 * @param form
	 * @return
	 */
	public String update(EquipChuKuQueRenForm form) throws Exception{
		DataRow dataRow = getEquipByUUID(form.getUUID());
		String state = dataRow.getDataElement("state").getString();
		if(form.getState().equals("3")){//ȷ�ϳ���ʱ
			if(!state.equals("2")){//����豸״̬��Ϊ2����δȷ��
				return ErrorConstant.QUEREN_CHUKU_STATE;
			}
		}
		else if(form.getState().equals("1")){//�������
			if(!state.equals("5")){
				return ErrorConstant.QUEREN_CHONGRUKU_STATE;
			}
		}
		else if(form.getState().equals("4")){//ȷ��������
			if(!state.equals("5")){
				return ErrorConstant.QUEREN_SUNHUAI_STATE;
			}
		}
		
		try {
			openTransaction();
			ParameterSet set = new ParameterSet();
			set.add("UUID", "@UUID", form.getUUID());
			set.add("state", "@state", form.getState());
			set.add("updatedt", "@updatedt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			dao.execute("updateEquipQuKuById",set);
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
}

