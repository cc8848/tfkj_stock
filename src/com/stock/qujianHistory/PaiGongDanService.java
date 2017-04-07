package com.stock.qujianHistory; 

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.DataSetUtil;

/** 
 * @author wangdl 
 * @version ����ʱ�䣺2012-6-13 ����02:29:45 
 * ��˵�� 
 */
public class PaiGongDanService extends BusinessService{
	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	
	private ParameterSet getConditionParameterSet(PaiGongDanForm form){
		ParameterSet set = new ParameterSet();
		set.add("xiaoquname", "@xiaoquname", form.getXiaoquHidden()+ "%");
		set.add("usertel", "@usertel", form.getUserTelHidden());
	//	set.add("state", "@state", "13");
	//	set.add("stateDate", "@stateDate", form.getStateDateHidden());
	//	set.add("endDate", "@endDate", form.getEndDateHidden());
		set.add("userplace", "@userplace", form.getUserplaceHidden());
		set.add("paigongriqi", "@paigongriqi", form.getPaigongriqisHidden());
		set.add("xiangmu", "@xiangmu","�ռ�");
		//set.add("noxiangmu", "@noxiangmu", "�ռ�");
		return set;
	}
	
	public DataSet<DataRow> getResult(PaiGongDanForm form, int first, int rows)throws Exception {
		if (form.getXiaoqu() == null) {
			return dao.executeQuery("GetEmptyDataList",getConditionParameterSet(form), first, rows);
		}
		return dao.executeQuery("GetQjHistoryList",getConditionParameterSet(form), first, rows);
	}

	public int getResultCount(PaiGongDanForm form) throws Exception {
		if (form.getXiaoqu() == null) {
			return 0;
		}
		return dao.executeQueryToCount("GetQjHistorytCount",getConditionParameterSet(form));
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
	 * ����mac��ѯ�豸����
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getEquipByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("mac", "@mac", code);
		return dao.executeQueryToDataRow("GetEquipByMac",set);
	}
	
	/**
	 * ��ȡС���б�
	 * @return
	 * @throws Exception
	 */
	public List<CommonModule> getXiaoQuCodeAll()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("getXiaoQuCodeAll",new ParameterSet()));
	}
	
	public List<CommonModule> getDianxintaocan()throws Exception{
		return DataSetUtil.toCommonModuleList(dao.executeQuery("dianxintaocan",new ParameterSet()));
	}
	
}

