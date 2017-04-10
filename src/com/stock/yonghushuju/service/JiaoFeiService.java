package com.stock.yonghushuju.service;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.util.IptvWebService;
import com.stock.util.RediusWebService;
import com.stock.util.SoapClient;
import com.stock.util.StringUtils;
import com.stock.weihu.IptvlogEidtForm;
import com.stock.weihu.RediusLogForm;
import com.stock.yonghushuju.ChangeSLThread;
import com.stock.yonghushuju.JiaofeiDataFrom;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.webService.WebServiceMethods;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.util.StringUtil;
import org.apache.struts.action.ActionForm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangqingxiang on 2016/6/14.
 */
public class JiaoFeiService extends BusinessService {
    private CommonDao dao = new CommonDao();
    private Log log = LogFactory.getLog(this.getClass());
    private IptvWebService iptvWebService = new IptvWebService();


    /**
     * 保存续费申请
     * @param countNum  账号
     * @param form
     * @return
     * @throws Exception
     */
    public String saveApply(String countNum,ActionForm form) throws  Exception{


//        先根据账号小区地址取到本条已安装数据
        countNum = java.net.URLDecoder.decode(countNum, "utf-8");
        JiaofeiDataFrom jfForm = (JiaofeiDataFrom) form;
        ParameterSet set = new ParameterSet();
        set.add("xiaoqu", "@xiaoqu", jfForm.getXiaoqu());
        set.add("dizhi", "@dizhi", "%" + jfForm.getDizhi() + "%");
        if (!"".equals(jfForm.getDianshi()) && !"0".equals(jfForm.getDianshi()) && null != jfForm.getDianshi()) {
            set.add("dianhuaip", "@dianhuaip", countNum);
        } else if (!"".equals(jfForm.getWangluo()) && !"0".equals(jfForm.getWangluo()) && null != jfForm.getWangluo()) {
            set.add("wangluoip", "@wangluoip", countNum);
        }

        DataSet<DataRow> executeQuery =dao.executeQuery("findCounNum", set);


//        计算有效时间
        String stringyouxiao = "";
        for (int i = 0; i < executeQuery.size(); i++) {
            DataRow obj = executeQuery.get(i);
            String wangluoip = obj.getDataElement("wangluoip").getString();
            String dianshiip = obj.getDataElement("dianhuaip").getString();
            String wangluo = obj.getDataElement("wangluo").getString();
            String dianshi = obj.getDataElement("dianshi").getString();
            String youxiaoshijian = obj.getDataElement("youxiaoshijian").getString();
            Date youxiaodate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(youxiaoshijian);
            stringyouxiao = new SimpleDateFormat("yyyy-MM-dd").format(youxiaodate);
            if (countNum.equals(wangluoip)&&(!"".equals(jfForm.getWangluo()) && !"0".equals(jfForm.getWangluo()) && null != jfForm.getWangluo())) {
                stringyouxiao = wangluo +","+ stringyouxiao+"/";
            }else if (countNum.equals(dianshiip)&&(!"".equals(jfForm.getDianshi()) && !"0".equals(jfForm.getDianshi()) && null != jfForm.getDianshi())) {
                stringyouxiao = dianshi +","+ stringyouxiao+"/";
            }
        }

//        生成到数据库
        jfForm.setYewu(stringyouxiao+jfForm.getYewu());
        if (!"".equals(jfForm.getDianshi()) && !"0".equals(jfForm.getDianshi()) && null != jfForm.getDianshi()) {
            jfForm.setDianhuaip(countNum);
        } else if (!"".equals(jfForm.getWangluo()) && !"0".equals(jfForm.getWangluo()) && null != jfForm.getWangluo()) {
            jfForm.setWangluoip(countNum);
        }
        return this.insertDaijiaofei((JiaofeiDataFrom) form);
    }

    /**
     * 执行保存
     * @param form
     * @return
     * @throws Exception
     */
    public String insertDaijiaofei(JiaofeiDataFrom form) throws Exception {
        // DataRow dataRow = getDaijiaofei(form);
	/*
	 * if(dataRow!=null){ return ErrorConstant.YUYUEEXIST; }
	 */
        try {
            openTransaction();

            ParameterModel model = new ParameterModel();
            model.put("xiaoqu", form.getXiaoqu());
            model.put("dizhi", form.getDizhi());
            model.put("yonghuzhuangtai", "待缴费");
            if (form.getWangluo().equals("")) {
                form.setWangluo("0");
            }
            model.put("wangluo", form.getWangluo());
            if (form.getDianshi().equals("")) {
                form.setDianshi("0");
            }

            // model.put("dianshiip", form.getDianshiip());
            model.put("wangluoip", form.getWangluoip());
            model.put("dianhuaip", form.getDianhuaip());

            model.put("dianshi", form.getDianshi());
            model.put("dianhua", form.getDianhua());
            model.put("kaijishijian", form.getKaijishijian());
            model.put("tingjishijian", form.getTingjishijian());
            // 20141027billy新增有效时间的存储功能
            model.put("youxiaoshijian", form.getTingjishijian());
            model.put("kuandaifei", Integer.parseInt(form.getKuandaifei()));
            model.put("shoushifei", Integer.parseInt(form.getShoushifei()));
            model.put("nianfei", Integer.parseInt(form.getNianfei()));
            model.put("onuyj", Integer.parseInt(form.getOnuyj()));
            model.put("jidingheyj", Integer.parseInt(form.getJidingheyj()));
            model.put("zongshoufei", form.getZongshoufei());
            String shichang = form.getShichang();
            String shichangtv = form.getShichangtv();
            String dianhua = form.getDianhua();
            if(!"1".equals(form.getBeishuselect())) {
                form.setYewu(form.getYewu()+"/【资费调整"+form.getBeishuselect()+"倍】");
            }
            if("1".equals(form.getBeishutype())) {
                form.setYewu(form.getYewu()+"/【升级或特殊资费】");
            }else if("2".equals(form.getBeishutype())) {
                form.setYewu(form.getYewu()+"/【八折】");
            }else if("3".equals(form.getBeishutype())) {
                form.setYewu(form.getYewu()+"/【特批免费】");
            }
            if (shichang == null && shichangtv == null && dianhua == null) {
                model.put("yewu", form.getYewu());
            } else if (shichang != null) {
                model.put("yewu", form.getYewu() + "/" + shichang);
            } else if (dianhua != null) {
                model.put("yewu", form.getYewu());
            } else {
                model.put("yewu", form.getYewu() + "/" + shichangtv);
            }

            model.put("shoujubenhao", form.getShoujuhao());
            model.put("shigongren", form.getShigongren());
            model.put("createdt", form.getNowdata());
            model.put("kaipiaoxinxi", form.getKaipiaoxinxi());
            model.put("shoukuanshijian", form.getShoukuanshijian());
            model.put("beiyong1", form.getShichangRadius());
            model.put("yunyingshang", form.getYunyingshang());
            model.put("beizhuhuizong", form.getBeizhuhuizong() + " 操作人:" + getUserInfo().getEmployeeName() + " 申请时间：" + form.getNowdata());
            dao.insert("yonghushuju", model);

            commit();
        } catch (Exception e) {
            rollback();
            log.error(e);
            throw e;
        }
        return Constant.SUCCESS;
    }


    public CommonMessage approve(JiaofeiDataFrom jiaofeiDataFrom) throws Exception {
        openTransaction();
        String wsFlag = "";
        StringBuffer sb = new StringBuffer();
        Integer countWangluo = 0;
        Integer countDianshi = 0;
        String uuid = jiaofeiDataFrom.getUUID();
        ParameterSet set = new ParameterSet();
        set.add("uuid", "@UUID", uuid);
        DataSet<DataRow> query = dao.executeQuery("GetDaijiaofeiList", set);

        String xiaoqu = query.get(0).getDataElement("xiaoqu").getString();
        String dizhi = query.get(0).getDataElement("dizhi").getString();
        String wangluo = query.get(0).getDataElement("wangluo").getString();
        String dianshi = query.get(0).getDataElement("dianshi").getString();
        String dianhua = query.get(0).getDataElement("dianhua").getString();
        String yunyingshang = query.get(0).getDataElement("yunyingshang").getString();
        String wangluoip = query.get(0).getDataElement("wangluoip").getString();
        String dianshiip = query.get(0).getDataElement("dianhuaip").getString();

        Date kaijishijian = new SimpleDateFormat("yyyy-MM-dd").parse(query.get(0).getDataElement("kaijishijian").getString());

        try {

	    /*
        * 网络的缴费
	     * 判断已安装网络数量
	     */
            if (!wangluo.equals("0") && !wangluo.equals("") && dianshi.equals("0")) {
                String s;
                countWangluo = checkWangluoCountByAccount(xiaoqu, dizhi, wangluoip);
                if (countWangluo == 0) {
                    s = "(" + xiaoqu + "," + dizhi + ")" + "无安装网络<br>";
                    sb.append(s);
                    backCommonMessage(sb);

                }
                if (countWangluo == 1) {

                    // 缴费接口：对于是电信网络业务的用户执行续费操作
                    /**
                     * 续费详情说明：
                     * 	对于未出现业务变更且处于开机状态的：不执行任何操作
                     * 	对于未出现业务变更但已处于停机状态的：执行复机操作
                     * 	对于出现业务变更的处于开机状态的：发送变速操作
                     * 	对于出现业务变更且处于停机状态的：执行复机操作然后在发送变速操作
                     */


                    ParameterSet set1 = new ParameterSet();
                    set1.add("xiaoqu", "@xiaoqu", xiaoqu);
                    set1.add("dizhi", "@dizhi", dizhi);
                    set1.add("wangluoip", "@wangluoip", wangluoip);
                    set1.add("dianhuaip", "@dianhuaip", "0");
                    DataSet<DataRow> qy = dao.executeQuery("findYianzhuangData", set1);
                    if (qy.size() == 1) {
                        Date nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 00:00:00");
                        String daikuan = qy.get(0).getDataElement("wangluo").getString();
                        Date youxiaoshijian = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(qy.get(0).getDataElement("youxiaoshijian").getString());
                        // Fix By Daizhen On 2015-4-7 START
                        // wsFlag从1改为0，wsFlag若初始为1时处理续费录入操作永远不能录入
                        wsFlag = "0";
                        // Fix By Daizhen On 2015-4-7 END
                        // 续费时变更业务的
                        if (!wangluo.equals(daikuan)) {
                            // 续费时的时间是开机时间的
                            if (nowDate.getTime() == kaijishijian.getTime()) {
                                //执行redius接口
                                if (!RediusWebService.fuji(query.get(0),"否")) {
                                    backCommonMessage(sb.append(xiaoqu + dizhi + "宽带复机接口触发失败，请查询日志后手动修改"));
                                }
                                if (!RediusWebService.change(query.get(0),"否")) {
                                    backCommonMessage(sb.append(xiaoqu + dizhi + "宽带速率变更接口触发失败，请查询日志后手动修改"));
                                }
//                              //    如果运营商是电信的还要走电信接口
                                if ("电信".equals(yunyingshang)) {
                                    if (!"0".equals(WebServiceMethods.Fuji(query.get(0)))) {
                                        wsFlag = "1";
                                        rollback();
                                    }
                                    ChangeSLThread changeSLThread = new ChangeSLThread();
                                    changeSLThread.setQuery(query);
                                    changeSLThread.setWangluo(wangluo);
                                    changeSLThread.setDaikuan(daikuan);
                                    Thread t1 = new Thread(changeSLThread);
                                    t1.start();

                                }

                            }
                        } else {
                            // 续费时的时间是开机时间的
                            if (nowDate.getTime() == kaijishijian.getTime()) {
                                if ("电信".equals(yunyingshang)) {
                                    if (!"0".equals(WebServiceMethods.Fuji(query.get(0)))) {
                                        wsFlag = "1";
                                        rollback();
                                    }
                                }
                                //执行redius接口
                                if (!RediusWebService.fuji(query.get(0),"否")) {
                                    backCommonMessage(sb.append(xiaoqu + dizhi + "宽带续费接口触发失败，请查询日志后手动修改"));
                                }
                            }
                        }
                    }
                    if ("0".equals(wsFlag)) {
                        updateAndinsertAnddelet(query, "wangluo", uuid);
                    }
                }


                if (countWangluo > 1) {
                    s = "(" + xiaoqu + "," + dizhi + ")" + "安装网络重复<br>";
                    sb.append(s);
                    backCommonMessage(sb);
                }
            }
	    /*
	     * 判断已安装电视数量
	     */
            if (!dianshi.equals("0") && wangluo.equals("0")) {
                String s;
                countDianshi = checkDianshiCountByAccount(xiaoqu, dizhi, dianshiip);
                if (countDianshi == 0) {
                    s = "(";
                    s += xiaoqu;
                    s += ",";
                    s += dizhi;
                    s += ")";
                    s += "无安装电视<br>";
                    sb.append(s);
                    backCommonMessage(sb);
                }
                if (countDianshi == 1) {
                    //电视缴费，判断日期为当天的
//                    开机时间项 等于当天日期
//                    电视项 非空非零
//                    电视账号项 非空非零
//                    如果是停机的状态，要将状态改为复机，且自动续费
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String curDate = dateFormat.format(new Date());
                    String startDate = query.get(0).getDataElement("kaijishijian").getString();
                    if (curDate.equals(startDate) && StringUtils.isNotBlankAndZero(dianshi) && StringUtils.isNotBlankAndZero(dianshiip)) {

                        IptvlogEidtForm log = new IptvlogEidtForm();
                        log.setTingjizhanghao(dianshiip);
                        log.setInterfaceType("复机");
                        log.setTingjishijian(curDate);
                        log.setShifouchenggong("待发送");
                        log.setIsweb("否");
                        log(log);
                        //两个服务器地址分别复机
                        String msg = IptvWebService.fuJi(dianshiip, "http://10.104.0.6:8500/", curDate,"否");
                        String msg1 = IptvWebService.fuJi(dianshiip, "http://10.103.0.6:8500/", curDate,"否");
                        //只有同时失败，才弹出窗口
                        if (msg.equals("FAIL") && msg1.equals("FAIL")) {
                            msg = xiaoqu + dizhi + "电视复机接口触发失败，请查询日志后手动修改";
                            backCommonMessage(sb.append(msg));
                        }
                        System.out.println("<<<<<<<<<<" + msg + ">>>>>>>>>>>>>>>>>>>>>>");
                    }
                    updateAndinsertAnddelet(query, "dianshi", uuid);

                }
                if (countDianshi > 1) {
                    s = "(";
                    s += xiaoqu;
                    s += ",";
                    s += dizhi;
                    s += ")";
                    s += "安装电视重复<br>";
                    sb.append(s);
                    backCommonMessage(sb);
                }
            }
            if (wangluo.equals("0") && dianshi.equals("0") && (!dianhua.equals("0"))) {
                // 插入电话业务待缴费信息。
                countWangluo = checkDianhuaCount1(xiaoqu, dizhi);
                if (countWangluo > 0) {
                    boolean insertDianhua = insertDianhua(query, "dianhua", uuid);
                    if (!insertDianhua) {
                        sb.append("数据异常，未能成功录入！");
                    }
                } else {
                    sb.append("小区地址不正确，未能成功录入！");
                }

            }

        } catch (Exception e) {
            rollback();
            log.error(e);
            e.printStackTrace();
            return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "数据异常，未能成功录入！");
        }

        if ("".equals(wsFlag)) {
            return backCommonMessage(sb);
        } else {
            if ("0".equals(wsFlag)) {
                return backCommonMessage(sb.append(""));
            } else {
                rollback();
                return backCommonMessage(sb.append("未能成功录入！"));
            }
        }
    }


    private int checkDianshiCountByAccount(String xiaoqu, String dizhi, String account) throws Exception {
        ParameterSet set1 = new ParameterSet();
        set1.add("xiaoqu", "@xiaoqu", xiaoqu);
        set1.add("dizhi", "@dizhi", dizhi);
        set1.add("dianhuaip", "@dianhuaip", account);
        set1.add("dianshi", "@dianshi", "0");
        // set1.add("dianhua", "@dianhua", "0");
        return dao.executeQueryToCount("GetUserDataBydianshiip", set1);

    }

    private int checkDianhuaCount1(String xiaoqu, String dizhi) throws Exception {
        ParameterSet set1 = new ParameterSet();
        set1.add("xiaoqu", "@xiaoqu", xiaoqu);
        set1.add("dizhi", "@dizhi", dizhi);
        set1.add("dianhua", "@dianhua", "0");
        return dao.executeQueryToCount("GetUserDataByAnZhuangCount", set1);
    }

    private void updateAndinsertAnddelet(DataSet<DataRow> query, String yewu, String uuid) throws Exception {

        ParameterModel model = new ParameterModel();
        model.put("xiaoqu", query.get(0).getDataElement("xiaoqu").getString());
        model.put("dizhi", query.get(0).getDataElement("dizhi").getString());
        model.put("wangluo", query.get(0).getDataElement("wangluo").getString());
        model.put("dianshi", query.get(0).getDataElement("dianshi").getString());
        model.put("yonghuzhuangtai", "已续费");
        model.put("pipeizhuangtai", "未匹配");
        model.put("shoukuanshijian", query.get(0).getDataElement("shoukuanshijian").getString());
        model.put("kaijishijian", query.get(0).getDataElement("kaijishijian").getString());
        model.put("tingjishijian", query.get(0).getDataElement("tingjishijian").getString());
        model.put("yewu", query.get(0).getDataElement("yewu").getString());
        model.put("onuyj", query.get(0).getDataElement("onuyj").getString());
        model.put("jidingheyj", query.get(0).getDataElement("jidingheyj").getString());
        model.put("shoushifei", query.get(0).getDataElement("shoushifei").getString());
        model.put("kuandaifei", query.get(0).getDataElement("kuandaifei").getString());
        model.put("zongshoufei", query.get(0).getDataElement("zongshoufei").getString());
        model.put("shoujubenhao", query.get(0).getDataElement("shoujubenhao").getString());
        model.put("kaipiaoxinxi", query.get(0).getDataElement("kaipiaoxinxi").getString());
        model.put("shigongren", query.get(0).getDataElement("shigongren").getString());
        model.put("beizhuhuizong", query.get(0).getDataElement("beizhuhuizong").getString() + " 录入人:" + getUserInfo().getEmployeeName() + " 录入时间：" + Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        ParameterModel conds = new ParameterModel();
        conds.put("uuid", uuid);

        // ParameterSet set1 = new ParameterSet();
        // set1.add("xiaoqu", "@xiaoqu",
        // query.get(0).getDataElement("xiaoqu").getString());
        // set1.add("dizhi", "@dizhi",
        // query.get(0).getDataElement("dizhi").getString());
        // set1.add("yonghuzhuangtai", "@yonghuzhuangtai", "已安装");
        // set1.add("username", "@username", getUserInfo().getEmployeeName());
        // set1.add("xiugai", "@xiugai", Common.formatDate(new Date(),
        // "yyyy-MM-dd HH:mm:ss"));

        ParameterSet set = new ParameterSet();
        set.add("yonghuzhuangtai", "@yonghuzhuangtai", "已安装");
        set.add("tingjishijian", "@tingjishijian", query.get(0).getDataElement("tingjishijian").getString());
        set.add("dianshiip", "@dianshiip", query.get(0).getDataElement("dianhuaip").getString());
        set.add("wangluoip", "@wangluoip", query.get(0).getDataElement("wangluoip").getString());
        set.add("xiaoqu", "@xiaoqu", query.get(0).getDataElement("xiaoqu").getString());
        set.add("dizhi", "@dizhi", query.get(0).getDataElement("dizhi").getString());
        openTransaction();
        dao.update("yonghushuju", model, conds);
        if (yewu.equals("wangluo")) {
            set.add("wangluo", "@wangluo", query.get(0).getDataElement("wangluo").getString());
            dao.execute("updateAnZhuangWangluoDataByUser", set);
        } else if (yewu.equals("dianshi")) {
            set.add("dianshi", "@dianshi", query.get(0).getDataElement("dianshi").getString());
            dao.execute("updateAnZhuangDianshiDataByUser", set);
        }
        commit();
    }

    private int checkWangluoCountByAccount(String xiaoqu, String dizhi, String account) throws Exception {
        ParameterSet set1 = new ParameterSet();
        set1.add("xiaoqu", "@xiaoqu", xiaoqu);
        set1.add("dizhi", "@dizhi", dizhi);
        set1.add("wangluoip", "@wangluoip", account);
        set1.add("wangluo", "@wangluo", "0");
        // set1.add("dianhua", "@dianhua", "0");
        return dao.executeQueryToCount("GetUserDataBywangluoip", set1);
    }

    private CommonMessage backCommonMessage(StringBuffer error) throws Exception {
        return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, error.toString());
    }

    private boolean insertDianhua(DataSet<DataRow> query, String string, String id) throws Exception {
        try {
            ParameterSet set1 = new ParameterSet();
	    /*
	     * ParameterModel model = new ParameterModel(); model.put("isuse",
	     * "1"); ParameterModel conds = new ParameterModel();
	     * conds.put("uuid", id);
	     */
            set1.add("UUID", "@UUID", id);

            openTransaction();
            dao.execute("insertDaijiaofeiByUUID", set1);
            dao.execute("DeleteDaijiaofei", set1);
            commit();
            return true;
        } catch (Exception e) {
            rollback();
            log.error(e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param f
     * @return
     * @author billy by 20140919
     */
    public CommonMessage log(IptvlogEidtForm f) {
        try {
            ParameterModel model = new ParameterModel();
            model.put("tingjishijian", f.getTingjishijian());
            model.put("tingjizhanghao", f.getTingjizhanghao());
            model.put("shifouchenggong", f.getShifouchenggong());
            model.put("shibaibianhao", f.getShibaibianhao());
            model.put("shibaixinxi", f.getShibaixinxi());
            model.put("createdt", 	new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            model.put("serverip", f.getServerip());
            model.put("interfaceType", f.getInterfaceType());
            model.put("isweb", f.getIsweb());
            dao.insert("iptvlog", model);
            commit();
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
        }
        return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加成功！");

    }

    public void logRedius(String account, String createDt, String[] result, String type, String xiaoqu, String dizhi) {
        try {
            ParameterModel model = new ParameterModel();
            model.put("createDt", createDt);
            model.put("account", account);
            model.put("status", result[0]);
            model.put("type", type);
            model.put("resultmsg", result[2]);
            model.put("resultcode", result[1]);
            model.put("serverip", "");
            model.put("xiaoqu", xiaoqu);
            model.put("dizhi", dizhi);
            dao.insert("rediuslog", model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
