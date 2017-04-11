package com.stock.renewtask.service;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.util.IptvWebService;
import com.stock.util.RediusWebService;
import com.stock.weihu.IptvlogEidtForm;
import com.stock.yonghushuju.ChangeSLThread;
import com.takucin.aceeci.frame.BaseDao;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.webService.WebServiceMethods;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangqingxiang on 2016/6/28.
 */
public class RenewTaskService extends BusinessService {
    private static CommonDao dao = new CommonDao();

    /**
     * 执行网上续费的数据自动审核
     *
     * @throws Exception
     */
    public void approve() throws Exception {
        System.out.println("开始执行网上续费自动复机");
        //查询数据库中所有待缴费的网上续费的数据


        ParameterSet set = new ParameterSet();
        set.add("beizhuhuizong", "@beizhuhuizong", "网上续费");
        set.add("beizhuhuizong2", "@beizhuhuizong2", "快速续费");
        set.add("yonghuzhuangtai", "@yonghuzhuangtai", "待缴费");

        DataSet<DataRow> query = dao.executeQuery("findRenewTaskData", set);
        if(query==null||query.size()==0){
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<没有找到自动续费的待缴费数据，退出>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return;
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<获取到的待缴费的数据有：" + query.size() + "条>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i=0;i<query.size();i++) {
//            查询网络和电视，从而判断是网络或电视或电话
            //循环集合时从新查一下数据，防止出现并发问题
            DataRow r=query.get(i);
            openTransaction();
            String uuid = r.getDataElement("uuid").getString();
            ParameterSet set2 = new ParameterSet();
            set2.add("uuid", "@UUID", uuid);
            DataSet<DataRow> query2 = dao.executeQuery("GetDaijiaofeiList", set2);
            if(query2==null||query2.size()==0){
                continue;
            }
            r=query2.get(0);
            String  wangluo=r.getDataElement("wangluo").getString();
            String dianshi=r.getDataElement("dianshi").getString();
            String yewu="";
            if(wangluo.length()>1&&dianshi.equals("0")){
                yewu="wangluo";
            }else if(wangluo.equals("0")&&dianshi.length()>1){
                yewu="dianshi";
            }else{
                continue;
            }
            //根据小区地址和ip，查询数据库中的已安装的数据（即原单）
            String  wangluoip=r.getDataElement("wangluoip").getString();
            String dianhuaip=r.getDataElement("dianhuaip").getString();
            ParameterSet set1 = new ParameterSet();
            set1.add("xiaoqu", "@xiaoqu", r.getDataElement("xiaoqu").getString());
            set1.add("dizhi", "@dizhi", r.getDataElement("dizhi").getString());
            set1.add("wangluoip", "@wangluoip",yewu.equals("wangluo")?wangluoip:"0" );
            set1.add("dianhuaip", "@dianhuaip", yewu.equals("dianshi")?dianhuaip:"0" );
            DataSet<DataRow> qy = dao.executeQuery("findYianzhuangData", set1);
            if (qy == null || qy.size() == 0) {
                System.out.println("没有找到续费对应的原单");
                continue;
            } else if (qy.size() > 1) {
                System.out.println("查询到多条原单，请检查数据库");
                continue;
            }
            DataRow data = qy.get(0);
            String curdate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String kaijishijian=r.getDataElement("kaijishijian").getString().substring(0,10);
            boolean result=true;
            if(curdate.equals(kaijishijian)){
                if(yewu.equals("wangluo")){
                    result= approveWangluo(data,r);
                }else if(yewu.equals("dianshi")){
                    result= approveDianshi(data,r);
                }
            }
            if(result){
                update(r,yewu);
                commit();
            }else{
                rollback();
            }



        }


    }
    private boolean approveDianshi(DataRow yianzhuang,DataRow daijiaofei) throws Exception {
        String dianshiip=yianzhuang.getDataElement("dianhuaip").getString();
        String kaijishijian=daijiaofei.getDataElement("kaijishijian").getString();
        String xiaoqu=daijiaofei.getDataElement("xiaoqu").getString();
        String dizhi=daijiaofei.getDataElement("dizhi").getString();
        IptvlogEidtForm log = new IptvlogEidtForm();
        log.setTingjizhanghao(dianshiip);
        log.setInterfaceType("复机");
        //原来字段叫停机时间，因为是复机 所以这里用开机时间
        log.setTingjishijian(kaijishijian);
        log.setShifouchenggong("待发送");
        log.setIsweb("是");
        log(log);
        //两个服务器地址分别复机
        String msg = IptvWebService.fuJi(dianshiip, "http://10.104.0.6:8500/", kaijishijian, "是");
        String msg1 = IptvWebService.fuJi(dianshiip, "http://10.103.0.6:8500/", kaijishijian,"是");
        //只有同时失败，才弹出窗口
        if (msg.equals("FAIL") && msg1.equals("FAIL")) {
            msg = xiaoqu + dizhi + "电视复机接口触发失败，请查询日志后手动修改";
        }
        System.out.println("<<<<<<<<<<" + msg + ">>>>>>>>>>>>>>>>>>>>>>");
        return true;
    }

    private boolean approveWangluo(DataRow yianzhuang,DataRow daijiaofei) throws Exception{

        //执行redius接口
        RediusWebService.fuji(daijiaofei,"是");
        //变更
        RediusWebService.change(daijiaofei,"是");

        //检查运营商
        String yunyingshang = daijiaofei.getDataElement("yunyingshang").getString();
        if ("电信".equals(yunyingshang)) {
//            电信复机

            if (!"0".equals(WebServiceMethods.Fuji(daijiaofei))) {
                return false;
            }
//                看新续费的网络模式是否与原来的相同
            String curdaikuan = daijiaofei.getDataElement("wangluo").getString();
            String orgdaikuan = yianzhuang.getDataElement("wangluo").getString();
            if (curdaikuan != null && orgdaikuan != null && !curdaikuan.equals(orgdaikuan)) {
                DataSet<DataRow> queryrow = new DataSet<DataRow>();
                queryrow.add(daijiaofei);
                ChangeSLThread changeSLThread = new ChangeSLThread();
                changeSLThread.setQuery(queryrow);
                changeSLThread.setWangluo(curdaikuan);
                changeSLThread.setDaikuan(orgdaikuan);
                Thread t1 = new Thread(changeSLThread);
                t1.start();
            }

//

        }
        return true;
    }
    private void update(DataRow data, String yewu) throws Exception {

        //更新续费申请的状态和相关信息
        ParameterModel model = new ParameterModel();
        model.put("xiaoqu", data.getDataElement("xiaoqu").getString());
        model.put("dizhi", data.getDataElement("dizhi").getString());
        model.put("wangluo", data.getDataElement("wangluo").getString());
        model.put("dianshi", data.getDataElement("dianshi").getString());
        model.put("yonghuzhuangtai", "已续费");
        model.put("pipeizhuangtai", "未匹配");
        model.put("shoukuanshijian",data.getDataElement("shoukuanshijian").getString());
        model.put("kaijishijian",data.getDataElement("kaijishijian").getString());
        model.put("tingjishijian",data.getDataElement("tingjishijian").getString());
        model.put("yewu", data.getDataElement("yewu").getString());
        model.put("onuyj", data.getDataElement("onuyj").getString());
        model.put("jidingheyj", data.getDataElement("jidingheyj").getString());
        model.put("shoushifei", data.getDataElement("shoushifei").getString());
        model.put("kuandaifei", data.getDataElement("kuandaifei").getString());
        model.put("zongshoufei", data.getDataElement("zongshoufei").getString());
        model.put("shoujubenhao", data.getDataElement("shoujubenhao").getString());
        model.put("kaipiaoxinxi", data.getDataElement("kaipiaoxinxi").getString());
        model.put("shigongren", data.getDataElement("shigongren").getString());
//        model.put("beizhuhuizong", data.getDataElement("beizhuhuizong").getString() + " 录入人:" + getUserInfo().getEmployeeName() + " 录入时间：" + Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        ParameterModel conds = new ParameterModel();
        conds.put("uuid", data.getDataElement("uuid").getString());

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
        set.add("tingjishijian", "@tingjishijian",data.getDataElement("tingjishijian").getString());
        set.add("dianshiip", "@dianshiip", data.getDataElement("dianhuaip").getString());
        set.add("wangluoip", "@wangluoip",data.getDataElement("wangluoip").getString());
        set.add("xiaoqu", "@xiaoqu",data.getDataElement("xiaoqu").getString());
        set.add("dizhi", "@dizhi", data.getDataElement("dizhi").getString());
        openTransaction();
        dao.update("yonghushuju", model, conds);
        //更新已安装数据的状态和有效时间
        if (yewu.equals("wangluo")) {
            set.add("wangluo", "@wangluo", data.getDataElement("wangluo").getString());
            dao.execute("updateAnZhuangWangluoDataByUser", set);
        } else if (yewu.equals("dianshi")) {
            set.add("dianshi", "@dianshi", data.getDataElement("dianshi").getString());
            dao.execute("updateAnZhuangDianshiDataByUser", set);
        }
        commit();
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
            model.put("createdt", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
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
