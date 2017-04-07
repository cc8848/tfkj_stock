package com.stock.yonghushuju.service;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessService;
import com.stock.kucun.KucunService;
import com.stock.kucun.KuncunForm;
import com.stock.util.RediusWebService;
import com.stock.weihu.RediusService;
import com.stock.yonghushuju.YonghuDataEntityForm;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.webService.WebServiceMethods;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;

/**
 * Created by wangqingxiang on 2016/12/27.
 */;import java.text.SimpleDateFormat;
import java.util.Date;

public class TuidingService extends BusinessService {
    private Log log = LogFactory.getLog(this.getClass());
    private CommonDao dao = new CommonDao();
    KucunService kuCunService = new KucunService();


    public String autoTuiding(YonghuDataEntityForm form, DataRow dataRow) throws Exception {

        openTransaction();
        String message = "";
        boolean finishied = true;
        //获取到数据后先将数据插入到系统中，状态默认为初始，未匹配
        finishied = insertTuidingData(form, dataRow);
        //然后选项，如果退onu，则找到这个设备，将其状态改为回库，
        String tuionu = form.getTuionu();
        if (finishied && tuionu != null && tuionu.equals("1")) {
            String mac = dataRow.getDataElement("onumac").getString();
            if (mac == null || mac.length() == 0) {
                message += "非网络业务";
            } else {
                ParameterSet set = new ParameterSet();
                set.add("mac", "@EqMAC", mac);
                DataRow dataRow2 = dao.executeQueryToDataRow("GetshebeiDataList", set);
                if (dataRow2 != null) {
                    KuncunForm kuncunForm = new KuncunForm();
                    kuncunForm.setShebeizhuangtai("2");
                    kuncunForm.setUUIDHidden(dataRow2.getDataElement("PK_ID").getString());
                    kuncunForm.setBeizhu(form.getTuidingshijian() + dataRow.getDataElement("xiaoqu").getString() + dataRow.getDataElement("dizhi").getString() + "退订");
                    kuCunService.zhuangTaiChangeByPId(kuncunForm);
                } else {
                    message += "mac:" + mac + "未找到对应信息请手动查询修改。";
                }
            }

        }

//		如果退机顶盒，则找到这个设备，将其状态改为回库，
        String tuijidinghe = form.getTuijidinghe();
        if (finishied && tuijidinghe != null && tuijidinghe.equals("1")) {
            String mcid = dataRow.getDataElement("stbmcid").getString();
            if (mcid == null || mcid.length() == 0) {
                message += "非电视业务";
            } else {
                ParameterSet set = new ParameterSet();
                set.add("mcid", "@EqMCID", mcid);
                DataRow dataRow2 = dao.executeQueryToDataRow("GetshebeiDataList", set);
                if (dataRow2 != null) {
                    KuncunForm kuncunForm = new KuncunForm();
                    kuncunForm.setShebeizhuangtai("2");
                    kuncunForm.setUUIDHidden(dataRow2.getDataElement("PK_ID").getString());
                    kuncunForm.setBeizhu(form.getTuidingshijian() + dataRow.getDataElement("xiaoqu").getString() + dataRow.getDataElement("dizhi").getString() + "退订");
                    kuCunService.zhuangTaiChangeByPId(kuncunForm);
                } else {
                    message += "mcid:" + mcid + "未找到对应信息请手动查询修改。";
                }
            }
        }

//		如果退宽带，则自动调用radius退订接口，如果是电信的还要调用电信退订接口
        String tuikuandai = form.getTuikuandai();
        if (finishied && tuikuandai != null && tuikuandai.equals("1")) {
            String wangluoip = dataRow.getDataElement("wangluoip").getString();
            if (wangluoip == null || wangluoip.length() == 0) {
                message += "非宽带业务";
            } else {
                boolean result = RediusWebService.tingJi(dataRow, "0");
                if (!result) {
                    message += "宽带账号:" + wangluoip + "未能自动停机成功请手动查询修改";
                }
                if (wangluoip != null && wangluoip.indexOf("@") > 0) {
                    //判断有效时间和退订时间
                    Date youxiaoshijian = dataRow.getDataElement("youxiaoshijian").getDate();
                    Date tuidingshijian = new SimpleDateFormat("yyyy-mm-dd").parse(form.getTuidingshijian());
                    //如果有效时间大于退订时间，则插入数据等待处理
                    if (youxiaoshijian.getTime() > tuidingshijian.getTime()) {


                    }

                }
            }

        }

//		将已安装数据改成拆机
        if (finishied) {
            ParameterModel model = new ParameterModel();
            model.put("yonghuzhuangtai", "已拆机");
            ParameterModel conds = new ParameterModel();
            model.put("uuid", form.getUUID());
            dao.update("yonghushuju", model, conds);
        }

        commit();
        return message;
    }

    public boolean insertTuidingData(YonghuDataEntityForm form, DataRow dataRow) {
        try {

            ParameterModel model = new ParameterModel();
            model.put("yonghuzhuangtai", "待退订");
            model.put("pipeizhuangtai", "未匹配");
//            model.put("shoukuanshijian", new Date());
            model.put("xianchangbeizhu", "");
            model.put("kaijishijian", form.getTuidingshijian());
            model.put("tingjishijian", form.getTuidingshijian());
            model.put("xiaoqu", dataRow.getDataElement("xiaoqu").getString());
            model.put("dizhi", dataRow.getDataElement("dizhi").getString());
            model.put("wangluo", dataRow.getDataElement("wangluo").getString());
            model.put("dianhua", dataRow.getDataElement("dianhua").getString());
            model.put("dianshi", dataRow.getDataElement("dianshi").getString());
            model.put("yewu", form.getTuidingyuanyin());
            model.put("fenguang", dataRow.getDataElement("fenguang").getString());
            model.put("onumac", dataRow.getDataElement("onumac").getString());
            model.put("stbmcid", dataRow.getDataElement("stbmcid").getString());
            model.put("dianhuaip", dataRow.getDataElement("dianhuaip").getString());
            model.put("dianshiip", dataRow.getDataElement("dianshiip").getString());
            model.put("wangluoip", dataRow.getDataElement("wangluoip").getString());
            model.put("onuyj", dataRow.getDataElement("onuyj").getString());
            model.put("jidingheyj", dataRow.getDataElement("jidingheyj").getString());
            model.put("shoushifei", dataRow.getDataElement("shoushifei").getString());
            model.put("kuandaifei", dataRow.getDataElement("kuandaifei").getString());
            model.put("chuzhuangfei", dataRow.getDataElement("chuzhuangfei").getString());
            model.put("shebeixiaoshou", dataRow.getDataElement("shebeixiaoshou").getString());
            model.put("cailiaofei", dataRow.getDataElement("cailiaofei").getString());
            model.put("bzygf", dataRow.getDataElement("bzygf").getString());
            model.put("yunyingshang", dataRow.getDataElement("yunyingshang").getString());
            model.put("nianfei", dataRow.getDataElement("nianfei").getString());
            model.put("zongshoufei", dataRow.getDataElement("zongshoufei").getString());
            model.put("shigongren", dataRow.getDataElement("shigongren").getString());
            model.put("beizhuhuizong", dataRow.getDataElement("beizhuhuizong").getString());
            dao.insert("yonghushuju", model);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
