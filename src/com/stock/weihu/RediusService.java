package com.stock.weihu;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;

import java.util.ArrayList;
import java.util.List;

/**
 * rediuslog µÄcrud service
 * Created by wangqingxiang on 2016/6/20.
 */
public class RediusService extends BusinessService {

    private CommonDao dao = new CommonDao();


    public DataSet<DataRow> getResult(RediusLogForm form, int first, int rows) throws Exception {

        return dao.executeQuery("getRediusLogInfo", convertToSet(form), first, rows);
    }

    private ParameterSet convertToSet(RediusLogForm form) {
        ParameterSet set = new ParameterSet();
        set.add("account", "@account", form.getAccount());
        set.add("createDt", "@createDt", form.getCreateDt());
        set.add("createBy", "@createBy", form.getCreateBy());
        set.add("type", "@type", form.getType());
        set.add("status", "@status", form.getStatus());
        set.add("uuid", "@uuid", form.getUuid());
        set.add("serverIp", "@serverIp", form.getServerIp());
        set.add("xiaoqu", "@xiaoqu", form.getXiaoqu());
        set.add("dizhi", "@dizhi", form.getDizhi());
        set.add("resultCode", "@resultCode", form.getResultCode());
        set.add("resultMsg", "@resultMsg", form.getResultMsg());
        set.add("isweb", "@isweb", form.getIsweb());
        return set;
    }
    private List<RediusLogForm> convertToForm(DataSet<DataRow>dataRows){
        List<RediusLogForm> logs=new ArrayList<RediusLogForm>();
        if(dataRows==null||dataRows.size()==0){
            return logs;
        }
        for(int i=0;i<dataRows.size();i++){

        }
        return null;
    }
    public int getResultCount(RediusLogForm log) throws Exception{
        return dao.executeQueryToCount("getRediuslogCount",convertToSet(log));
    }

}

