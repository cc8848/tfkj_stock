package com.webService.log;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.stock.tongji.TongjiForm;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.webService.webServiceTools.WSTools;

/**
 * 日志操作
 * 
 * @author Xinhua-Zhao
 * @date： 日期：2015-2-2 时间：下午5:09:44
 */
public class WebServiceService extends BusinessService {
    private static CommonDao dao = new CommonDao();

    private ParameterSet getConditionParameterSet(WebServiceLogForm form) throws Exception{
	ParameterSet set = new ParameterSet();
	String xiaoqu = form.getXiaoqu();
	if( null == xiaoqu || xiaoqu.equals("")) {
	} else {
	    set.add("xiaoqu", "@xiaoqu", form.getXiaoqu());
	}
	
	
	if(form.getDizhi() == null || "".equals(form.getDizhi()) || "null".equals(form.getDizhi())) {
	    set.add("dizhi", "@dizhi", "%%");
	} else {
	    set.add("dizhi", "@dizhi", "%" +form.getDizhi()+ "%");
	}
	if(!(form.getYonghuzhuangtai() == null || "".equals(form.getYonghuzhuangtai()) || "null".equals(form.getYonghuzhuangtai()))) {
		set.add("yonghuzhuangtai", "@yonghuzhuangtai", form.getYonghuzhuangtai());
	}
	if(!(form.getInterfaceResult() == null || "".equals(form.getInterfaceResult()) || "null".equals(form.getInterfaceResult()))) {
		set.add("interfaceResult", "@interfaceResult", form.getInterfaceResult());
	}
	if(form.getCreateDt() == null || "".equals(form.getCreateDt()) || "null".equals(form.getCreateDt())) {
	   
	} else {
	    set.add("createDt", "@createDt", form.getCreateDt() + " 00:00:00");
	    set.add("endDate", "@endDate", form.getCreateDt() + " 23:59:59");
	}
	
	return set;
    }
    
    public DataSet<DataRow> getResultWebServiceLog(WebServiceLogForm form, int first, int rows) throws Exception {
    	if (form.getXiaoqu() == null) {
			return dao.executeQuery("GetEmptyDataList",getConditionParameterSet(form), first, rows);
		}
	return dao.executeQuery("getWebServiceInfo",getConditionParameterSet(form), first, rows);
    }

    public int getResultWebServiceCount(WebServiceLogForm form) throws Exception {
    	if (form.getXiaoqu() == null) {
			return dao.executeQueryToCount("GetEmptyDataList",getConditionParameterSet(form));
		}
	return dao.executeQueryToCount("getServiceInfoCount", getConditionParameterSet(form));
    }

    /**
     * 插入WebService日志
     * 
     * @return
     * @throws Exception
     */
    public static String InsertWebServiceLog(WebServiceLogForm f) {
	try {
	    ParameterModel model = new ParameterModel();
	    model.put("uuid", f.getUUID());
	    model.put("xiaoqu", f.getXiaoqu());
	    model.put("dizhi", f.getDizhi());
	    if ("已修改".equals(f.getYonghuzhuangtai())) {
		model.put("yonghuzhuangtai", "修改密码");
	    } else if ("已安装".equals(f.getYonghuzhuangtai())) {
		model.put("yonghuzhuangtai", "安装");
	    } else if ("已续费".equals(f.getYonghuzhuangtai())) {
		model.put("yonghuzhuangtai", "续费");
	    } else if ("已退订".equals(f.getYonghuzhuangtai())) {
		model.put("yonghuzhuangtai", "退订");
	    } else if ("已拆机".equals(f.getYonghuzhuangtai())) {
		model.put("yonghuzhuangtai", "拆机");
	    }
	    model.put("interfaceDetail", f.getInterfaceDetail());
	    model.put("interfaceResult", f.getInterfaceResult());
	    model.put("tradeAccount", f.getTradeAccount());
	    model.put("logState", f.getLogState());
	    model.put("tradeDetail", f.getTradeDetail());
	    model.put("daikuan", f.getDaikuan());
	    model.put("userId", f.getUserId());
	    model.put("xmlId", f.getXmlId());
	    model.put("xmlState", f.getXmlState());
	    model.put("xmlString", f.getXmlString());

	    model.put("createDt", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	    dao.insert("WebService_Log", model);
	} catch (Exception e) {
	    e.printStackTrace();
	    return "1";
	}
	return "0";
    }

    /**
     * 重新发送xmlString
     * 
     * @param uuid
     * @return
     */
    public Map<String, String> reSend(String uuid) {
	Map<String, String> resultMap = null;
	ParameterSet set = new ParameterSet();
	set.add("uuid", "@uuid", uuid);
	try {
	    DataSet<DataRow> query = dao.executeQuery("GetLogByUUID", set);
	    if (query.size() == 1) {
		String xmlString = query.get(0).getDataElement("xmlString").getString();

		// 更新原有的记录
		upDateData(query.get(0));

		return WSTools.SyncMessGetMap(xmlString);
	    } else {
		return resultMap;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return resultMap;
	}

    }

    private void upDateData(DataRow dataRow) {
	try {
	    ParameterSet set = new ParameterSet();
	    set.add("uuid", "@uuid", dataRow.getDataElement("uuid").getString());
	    set.add("xmlId", "@xmlId", dataRow.getDataElement("xmlId").getString());
	    set.add("interfaceResult", "@interfaceResult", "发送成功，等待操作结果！");
	    set.add("logState", "@logState", "0");
	    set.add("xmlState", "@xmlState", "0");
	    dao.execute("UpdateLog", set);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
