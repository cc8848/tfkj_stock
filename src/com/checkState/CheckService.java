package com.checkState;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.stock.util.RediusWebService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.webService.WebServiceMethods;

public class CheckService extends BusinessService {
    private static CommonDao dao = new CommonDao();

    /**
     * ��ѯ�����ǡ��ǿշ�0�����ҡ��û�״̬���ǡ��Ѱ�װ������Чʱ���ǵ��յ���Ϣ
     * ���䷢�͵�ͣ���ӿ�ʵʩ�����������־�Ͻ��м�¼
     * ִ��redius�ӿڣ������Ӫ���ǵ��ŵ�ͬʱִ�е��Žӿ�
     */
    public static void checkDianxinStop() {
        System.out.println("��ʼִ�е���ͣ��");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 2);
        String todayTime = null;
        try {
            todayTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            ParameterSet set = new ParameterSet();
            set.add("youxiaoshijian", "@youxiaoshijian", todayTime);

            DataSet<DataRow> query = dao.executeQuery("tingjiyonghu", set);
            for (DataRow r : query) {
                String yunyingshang = r.getDataElement("yunyingshang").getString();
                if ("����".equals(yunyingshang)) {
                    WebServiceMethods.Tingji(r);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("����ͣ��ִ�����");

    }

    /**
     * ��ѯ�����ǡ��ǿշ�0�����ҡ��û�״̬���ǡ������ѡ�������ʱ���ǵ��յ���Ϣ
     * ���䷢�͵����������ʱ���ӿ�ʵʩ�����������־�Ͻ��м�¼
     * �����Ӫ���ǵ��ŵ�ͬʱִ�е��Žӿ�
     */
    public static void checkDianxinStart() {
        System.out.println("��ʼִ�е��Ÿ���");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 1);
        String startTime = null;
        try {
            startTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            ParameterSet set = new ParameterSet();
            set.add("kaijishijian", "@kaijishijian", startTime);
            DataSet<DataRow> query = dao.executeQuery("kaijiyonghu", set);
            for (DataRow r : query) {

                String yunyingshang = r.getDataElement("yunyingshang").getString();
                if ("����".equals(yunyingshang)) {
                    WebServiceMethods.Fuji(r);
                    ParameterSet set1 = new ParameterSet();
                    set1.add("xiaoqu", "@xiaoqu", r.getDataElement("xiaoqu").getString());
                    set1.add("dizhi", "@dizhi", r.getDataElement("dizhi").getString());
                    set1.add("wangluoip", "@wangluoip", r.getDataElement("wangluoip").getString());
                    DataSet<DataRow> qy = dao.executeQuery("findCounNum", set1);
                    if (qy.size() == 1) {
                        //ȡ�Ѱ�װ���ݵĴ���
                        String daikuan = qy.get(0).getDataElement("wangluo").getString();
                        DataSet<DataRow> queryrow = new DataSet<DataRow>();
                        queryrow.add(r);
                        Thread.sleep(5 * 60 * 1000);
                        //���Ѽ�¼�ϵ��´���
                        String wangluo = r.getDataElement("wangluo").getString();
                        WebServiceMethods.ChangeSL(queryrow, wangluo, daikuan);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("���Ÿ���ִ�����");
    }

    /**
     * ��ѯ�����ǡ��ǿշ�0�����ҡ��û�״̬���ǡ��Ѱ�װ������Чʱ�����������Ϣ
     * ���䷢�͵�ͣ���ӿ�ʵʩ�����������־�Ͻ��м�¼
     * ����redius�ӿ�
     */
    public static void checkRediusStop() {
        System.out.println("��ʼִ��radiusͣ��");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);
        String todayTime = null;
        try {
            todayTime = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
            ParameterSet set = new ParameterSet();
            set.add("youxiaoshijian", "@youxiaoshijian", todayTime);
            DataSet<DataRow> query = dao.executeQuery("tingjiyonghu", set);
            for (DataRow r : query) {
                RediusWebService.tingJi(r,"��");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("radiusͣ��ִ�����");

    }

    /**
     * ��ѯ�����ǡ��ǿշ�0�����ҡ��û�״̬���ǡ������ѡ�������ʱ���ǵ��յ���Ϣ
     * ���䷢�͵����������ʱ���ӿ�ʵʩ�����������־�Ͻ��м�¼
     * ִ��redius�ӿ�
     */
    public static void checkRediusStart() {
        System.out.println("��ʼִ��radius����");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 1);
        String startTime = null;
        try {
            startTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            ParameterSet set = new ParameterSet();
            set.add("kaijishijian", "@kaijishijian", startTime);
            DataSet<DataRow> query = dao.executeQuery("kaijiyonghu", set);
            for (DataRow r : query) {
                //ִ��redius�ӿ�
                RediusWebService.fuji(r, "��");
                //���
                RediusWebService.change(r,"��");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("radius��������");
    }
}
