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
     * ִ���������ѵ������Զ����
     *
     * @throws Exception
     */
    public void approve() throws Exception {
        System.out.println("��ʼִ�����������Զ�����");
        //��ѯ���ݿ������д��ɷѵ��������ѵ�����


        ParameterSet set = new ParameterSet();
        set.add("beizhuhuizong", "@beizhuhuizong", "��������");
        set.add("beizhuhuizong2", "@beizhuhuizong2", "��������");
        set.add("yonghuzhuangtai", "@yonghuzhuangtai", "���ɷ�");

        DataSet<DataRow> query = dao.executeQuery("findRenewTaskData", set);
        if(query==null||query.size()==0){
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<û���ҵ��Զ����ѵĴ��ɷ����ݣ��˳�>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return;
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<��ȡ���Ĵ��ɷѵ������У�" + query.size() + "��>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i=0;i<query.size();i++) {
//            ��ѯ����͵��ӣ��Ӷ��ж����������ӻ�绰
            //ѭ������ʱ���²�һ�����ݣ���ֹ���ֲ�������
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
            //����С����ַ��ip����ѯ���ݿ��е��Ѱ�װ�����ݣ���ԭ����
            String  wangluoip=r.getDataElement("wangluoip").getString();
            String dianhuaip=r.getDataElement("dianhuaip").getString();
            ParameterSet set1 = new ParameterSet();
            set1.add("xiaoqu", "@xiaoqu", r.getDataElement("xiaoqu").getString());
            set1.add("dizhi", "@dizhi", r.getDataElement("dizhi").getString());
            set1.add("wangluoip", "@wangluoip",yewu.equals("wangluo")?wangluoip:"0" );
            set1.add("dianhuaip", "@dianhuaip", yewu.equals("dianshi")?dianhuaip:"0" );
            DataSet<DataRow> qy = dao.executeQuery("findYianzhuangData", set1);
            if (qy == null || qy.size() == 0) {
                System.out.println("û���ҵ����Ѷ�Ӧ��ԭ��");
                continue;
            } else if (qy.size() > 1) {
                System.out.println("��ѯ������ԭ�����������ݿ�");
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
        log.setInterfaceType("����");
        //ԭ���ֶν�ͣ��ʱ�䣬��Ϊ�Ǹ��� ���������ÿ���ʱ��
        log.setTingjishijian(kaijishijian);
        log.setShifouchenggong("������");
        log.setIsweb("��");
        log(log);
        //������������ַ�ֱ𸴻�
        String msg = IptvWebService.fuJi(dianshiip, "http://10.104.0.6:8500/", kaijishijian, "��");
        String msg1 = IptvWebService.fuJi(dianshiip, "http://10.103.0.6:8500/", kaijishijian,"��");
        //ֻ��ͬʱʧ�ܣ��ŵ�������
        if (msg.equals("FAIL") && msg1.equals("FAIL")) {
            msg = xiaoqu + dizhi + "���Ӹ����ӿڴ���ʧ�ܣ����ѯ��־���ֶ��޸�";
        }
        System.out.println("<<<<<<<<<<" + msg + ">>>>>>>>>>>>>>>>>>>>>>");
        return true;
    }

    private boolean approveWangluo(DataRow yianzhuang,DataRow daijiaofei) throws Exception{

        //ִ��redius�ӿ�
        RediusWebService.fuji(daijiaofei,"��");
        //���
        RediusWebService.change(daijiaofei,"��");

        //�����Ӫ��
        String yunyingshang = daijiaofei.getDataElement("yunyingshang").getString();
        if ("����".equals(yunyingshang)) {
//            ���Ÿ���

            if (!"0".equals(WebServiceMethods.Fuji(daijiaofei))) {
                return false;
            }
//                �������ѵ�����ģʽ�Ƿ���ԭ������ͬ
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

        //�������������״̬�������Ϣ
        ParameterModel model = new ParameterModel();
        model.put("xiaoqu", data.getDataElement("xiaoqu").getString());
        model.put("dizhi", data.getDataElement("dizhi").getString());
        model.put("wangluo", data.getDataElement("wangluo").getString());
        model.put("dianshi", data.getDataElement("dianshi").getString());
        model.put("yonghuzhuangtai", "������");
        model.put("pipeizhuangtai", "δƥ��");
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
//        model.put("beizhuhuizong", data.getDataElement("beizhuhuizong").getString() + " ¼����:" + getUserInfo().getEmployeeName() + " ¼��ʱ�䣺" + Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        ParameterModel conds = new ParameterModel();
        conds.put("uuid", data.getDataElement("uuid").getString());

        // ParameterSet set1 = new ParameterSet();
        // set1.add("xiaoqu", "@xiaoqu",
        // query.get(0).getDataElement("xiaoqu").getString());
        // set1.add("dizhi", "@dizhi",
        // query.get(0).getDataElement("dizhi").getString());
        // set1.add("yonghuzhuangtai", "@yonghuzhuangtai", "�Ѱ�װ");
        // set1.add("username", "@username", getUserInfo().getEmployeeName());
        // set1.add("xiugai", "@xiugai", Common.formatDate(new Date(),
        // "yyyy-MM-dd HH:mm:ss"));

        ParameterSet set = new ParameterSet();
        set.add("yonghuzhuangtai", "@yonghuzhuangtai", "�Ѱ�װ");
        set.add("tingjishijian", "@tingjishijian",data.getDataElement("tingjishijian").getString());
        set.add("dianshiip", "@dianshiip", data.getDataElement("dianhuaip").getString());
        set.add("wangluoip", "@wangluoip",data.getDataElement("wangluoip").getString());
        set.add("xiaoqu", "@xiaoqu",data.getDataElement("xiaoqu").getString());
        set.add("dizhi", "@dizhi", data.getDataElement("dizhi").getString());
        openTransaction();
        dao.update("yonghushuju", model, conds);
        //�����Ѱ�װ���ݵ�״̬����Чʱ��
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
            return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "���ʧ�ܣ�");
        }
        return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "��ӳɹ���");

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
