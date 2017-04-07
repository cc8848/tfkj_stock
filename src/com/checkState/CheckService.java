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
     * 查询网络是“非空非0”并且“用户状态”是“已安装”，有效时间是当日的信息
     * 将其发送到停机接口实施变更，且在日志上进行记录
     * 执行redius接口，如果运营商是电信的同时执行电信接口
     */
    public static void checkDianxinStop() {
        System.out.println("开始执行电信停机");
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
                if ("电信".equals(yunyingshang)) {
                    WebServiceMethods.Tingji(r);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("电信停机执行完毕");

    }

    /**
     * 查询网络是“非空非0”并且“用户状态”是“已续费”，开机时间是当日的信息
     * 将其发送到复机和速率变更接口实施变更，且在日志上进行记录
     * 如果运营商是电信的同时执行电信接口
     */
    public static void checkDianxinStart() {
        System.out.println("开始执行电信复机");
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
                if ("电信".equals(yunyingshang)) {
                    WebServiceMethods.Fuji(r);
                    ParameterSet set1 = new ParameterSet();
                    set1.add("xiaoqu", "@xiaoqu", r.getDataElement("xiaoqu").getString());
                    set1.add("dizhi", "@dizhi", r.getDataElement("dizhi").getString());
                    set1.add("wangluoip", "@wangluoip", r.getDataElement("wangluoip").getString());
                    DataSet<DataRow> qy = dao.executeQuery("findCounNum", set1);
                    if (qy.size() == 1) {
                        //取已安装数据的带宽
                        String daikuan = qy.get(0).getDataElement("wangluo").getString();
                        DataSet<DataRow> queryrow = new DataSet<DataRow>();
                        queryrow.add(r);
                        Thread.sleep(5 * 60 * 1000);
                        //续费记录上的新带宽
                        String wangluo = r.getDataElement("wangluo").getString();
                        WebServiceMethods.ChangeSL(queryrow, wangluo, daikuan);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("电信复机执行完毕");
    }

    /**
     * 查询网络是“非空非0”并且“用户状态”是“已安装”，有效时间是昨天的信息
     * 将其发送到停机接口实施变更，且在日志上进行记录
     * 运行redius接口
     */
    public static void checkRediusStop() {
        System.out.println("开始执行radius停机");
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
                RediusWebService.tingJi(r,"否");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("radius停机执行完毕");

    }

    /**
     * 查询网络是“非空非0”并且“用户状态”是“已续费”，开机时间是当日的信息
     * 将其发送到复机和速率变更接口实施变更，且在日志上进行记录
     * 执行redius接口
     */
    public static void checkRediusStart() {
        System.out.println("开始执行radius复机");
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
                //执行redius接口
                RediusWebService.fuji(r, "否");
                //变更
                RediusWebService.change(r,"否");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("radius复机结束");
    }
}
