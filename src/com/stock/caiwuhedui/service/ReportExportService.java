package com.stock.caiwuhedui.service;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.caiwuhedui.entity.ZhangMuForm;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.DataSetUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ���񱨱����ķ������ڽ������Ķ�����ȡ������Ҫ��Ȼ̫������
 * wangqingxiang
 * 2017.03.29
 */
public class ReportExportService extends BusinessService {
    private Log log = LogFactory.getLog(this.getClass());
    private CommonDao dao = new CommonDao();
    YonghuDataService serviceData = new YonghuDataService();
    ParameterSet set = new ParameterSet();


    /**
     * �������д���ռ��˱�񣬲��ṩ���ء�
     *
     * @param form
     * @param remoteAddr
     * @return
     */
    public CommonMessage downYHRiJiZhang(ZhangMuForm form, String remoteAddr) {
        try {
            List<List<String>> listData = new ArrayList<List<String>>();
            List<DataSet<DataRow>> dataSets = new ArrayList<DataSet<DataRow>>();
            String[] uuid = form.getUUIDS();
            String uuids = "";
            ParameterSet set=new ParameterSet();
            for (int i = 0; i < uuid.length; i++) {
                set.add("UUID", "@UUID", uuid[i]);
                DataSet<DataRow> rijizhang = dao.executeQuery("getYinHangRiJiZhang", set);
                dataSets.add(rijizhang);
            }
            DataSet<DataRow> rijizhangs = DataSetUtil.unionDataSet(dataSets);
            Set<Date> datex = new HashSet<Date>();
            Set<String> yinhangs = new HashSet<String>();
            for (int i = 0; i < rijizhangs.size(); i++) {
                Date date = rijizhangs.get(i).getDataElement("cunkuanshijian").getDate();
                datex.add(date);
                String yinhang=rijizhangs.get(i).getDataElement("cunkuanyinhang").getString();
                yinhangs.add(yinhang);

            }
            List<Date> datey = new ArrayList<Date>();
            datey.addAll(datex);
            Collections.sort(datey, new Comparator<Date>() {
                public int compare(Date arg0, Date arg1) {
                    return arg0.getTime() < arg1.getTime() ? -1 : 1;
                }
            });

            List<String> yinhangx=new ArrayList<String>();
            yinhangx.addAll(yinhangs);


            List<String> listWangdianTou = new ArrayList<String>();
            listWangdianTou.add("");
            for (int i = 0; i < yinhangx.size(); i++) {
                String yinhang = yinhangx.get(i);
                listWangdianTou.add(yinhang);
            }
            listWangdianTou.add("�ϼ�");
            listData.add(listWangdianTou);

//			������
            for (int i = 0; i < datey.size(); i++) {
//
                List<String> listbody = new ArrayList<String>();
                Date date1 = datey.get(i);
                listbody.add(new SimpleDateFormat("yyyy-MM-dd").format(date1));
                float sumY = 0;
                for (int j = 0; j < yinhangs.size(); j++) {
                    String yinghangy = yinhangx.get(j);
                    float value=0;
                    for (int k = 0; k < rijizhangs.size(); k++) {
                        Date curDate = rijizhangs.get(k).getDataElement("cunkuanshijian").getDate();
                        String curYinhang = rijizhangs.get(k).getDataElement("cunkuanyinhang").getString();
                        if (curDate.getTime()==date1.getTime() && curYinhang.equals(yinghangy)) {
                            String curJine = rijizhangs.get(k).getDataElement("cunkuanjine").getString();
                            value += Double.valueOf(curJine);
                        }
                    }
                    listbody.add(String.valueOf(value));
                    sumY += value;

                }
                listbody.add(String.valueOf(sumY));
                listData.add(listbody);
            }

            List<String> l = new ArrayList<String>();
            l.add("�ϼ�");
            //������
            float centerSum=0;
            for (int j = 1; j < yinhangs.size() + 1; j++) {
                float sum = 0;
                //������
                for (int i = 1; i < listData.size(); i++) {
                    //�ӵ�һ�У���һ��ֵ.�Դ����ơ�
                    sum += Double.valueOf(listData.get(i).get(j));
                }
                l.add(String.valueOf(sum));
                centerSum+=sum;
            }
            l.add(String.valueOf(centerSum));
            listData.add(l);
            int zt = 1;//����ռ���
            int time=toExcel(listData, zt);
            return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG, "<a href='"+remoteAddr+"/excel/rijizhang"+time+".xls'>���ش�������ռ���Excel</a>");
        } catch (Exception e) {
            return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG, "Excel��񵼳�ʧ�ܣ�");
        }
    }

    /**
     * ����ͳ�Ʊ�
     *
     * @param form
     * @param remoteAddr
     * @return
     */
    public CommonMessage downHuiZongTongji(ZhangMuForm form, String remoteAddr) {
        try {
            ParameterSet set = new ParameterSet();
            String date = "";
            String[] uuid = form.getUUIDS();
            List<List<String>> listData = new ArrayList<List<String>>();
            for (int i = 0; i < uuid.length; i++) {
                set.add("UUID", "@UUID", uuid[i]);
                DataSet<DataRow> queryDate = dao.executeQuery("getZhangmuXinxi", set);
                date += "," + queryDate.get(0).getDataElement("cunkuanshijian").getString();
            }
            date = date.replaceFirst(",", "");
            List<String> l1 = new ArrayList<String>();
            l1.add("��ά�����������������������");
            listData.add(l1);
            List<String> l2 = new ArrayList<String>();
            l2.add(date);
            l2.add("����");
            l2.add("���ӷ�");
            l2.add("����");
            l2.add("��װ��");
            l2.add("Ѻ��");
            l2.add("�豸����");
            l2.add("���Ϸ�");
            l2.add("����");
            l2.add("����ҵ��");
            l2.add("����ҵ��");
            l2.add("�ϼ�");
            listData.add(l2);
            List<String> l3 = new ArrayList<String>();
            l3.add(date);
            l3.add("����");
            l3.add("���ӷ�");
            l3.add("����");
            l3.add("��װ��");
            l3.add("Ѻ��");
            l3.add("�豸����");
            l3.add("���Ϸ�");
            l3.add("����");
            l3.add("����ҵ��");
            l3.add("���Żؿ�");
            l3.add("�ϼ�");
            listData.add(l3);

/*List<DataSet<DataRow>> dataSets = new ArrayList<DataSet<DataRow>>();
			
			ParameterSet set1 = new ParameterSet();
			for(int i=0 ; i <uuid.length;i++)
			{
				set1.add("zmid", "@zmid", uuid[i]);
				DataSet<DataRow> query = dao.executeQuery("GetYipipeiDataList", set1);
				dataSets.add(query);
			}*/
            List<DataSet<DataRow>> dataSets = new ArrayList<DataSet<DataRow>>();
            ParameterSet set1 = new ParameterSet();
            for (int i = 0; i < uuid.length; i++) {
                set1.add("zmid", "@zmid", uuid[i]);
                DataSet<DataRow> query = dao.executeQuery("byUUIDgetJinE", set1);
                dataSets.add(query);
            }
            DataSet<DataRow> executeQuery = DataSetUtil.unionDataSet(dataSets);
            for (int i = 0; i < executeQuery.size(); i++) {
                List<String> list = new ArrayList<String>();
                String xiaoqu = executeQuery.get(i).getDataElement("xiaoqu").getString();//0
                String kuandaifei = executeQuery.get(i).getDataElement("kuandaifei").getString();//1
                String shoushifei = executeQuery.get(i).getDataElement("shoushifei").getString();//2
                String huafei = "0";//3
                String chuzhuangfei = executeQuery.get(i).getDataElement("chuzhuangfei").getString();//4

                String onuyj = executeQuery.get(i).getDataElement("onuyj").getString();
                String jidingheyj = executeQuery.get(i).getDataElement("jidingheyj").getString();
                String yajin = String.valueOf((Double.valueOf(onuyj) + Double.valueOf(jidingheyj)));//5

                String shebeixiaoshou = executeQuery.get(i).getDataElement("shebeixiaoshou").getString();//6
                String cailiaofei = executeQuery.get(i).getDataElement("cailiaofei").getString();//7
                String diaozhang = "0";//8

                String nianfei = executeQuery.get(i).getDataElement("nianfei").getString();
                String bzygf = executeQuery.get(i).getDataElement("bzygf").getString();
                String dianxinyewu = String.valueOf((Double.valueOf(nianfei) + Double.valueOf(bzygf)));//9

                String dianxinhuikuan = "0";//10

                double hj = Double.valueOf(kuandaifei)
                        + Double.valueOf(shoushifei)
                        + Double.valueOf(huafei)
                        + Double.valueOf(chuzhuangfei)
                        + Double.valueOf(yajin)
                        + Double.valueOf(shebeixiaoshou)
                        + Double.valueOf(cailiaofei)
                        + Double.valueOf(diaozhang)
                        + Double.valueOf(dianxinyewu)
                        + Double.valueOf(dianxinhuikuan);
                String heji = String.valueOf(hj);//11
                list.add(xiaoqu);
                list.add(kuandaifei);
                list.add(shoushifei);
                list.add(huafei);
                list.add(chuzhuangfei);
                list.add(yajin);
                list.add(shebeixiaoshou);
                list.add(cailiaofei);
                list.add(diaozhang);
                list.add(dianxinyewu);
                list.add(dianxinhuikuan);
                list.add(heji);
                listData.add(list);
            }

            List<String> l = new ArrayList<String>();
            l.add("�ϼ�");
            //������
            for (int j = 1; j < listData.get(1).size(); j++) {
                float sum = 0;
                //������
                for (int i = 3; i < listData.size(); i++) {
                    //��ÿһ���������е�ֵ���Դ����ơ�
                    sum += Double.valueOf(listData.get(i).get(j));
                }
                l.add(String.valueOf(sum));
            }
            listData.add(l);

            List<String> lbaifen = new ArrayList<String>();
            lbaifen.add("�ٷֱ�");
            //������
            float baifenshu = 0.00f;
            //������
            for (int i = 1; i < listData.get(1).size(); i++) {
                //���һ�еĵ�һ��ֵ��
                float value1 = Float.valueOf(listData.get(listData.size() - 1).get(i));

                //���һ�е����һ��ֵ��
                float value2 = Float.valueOf(listData.get(listData.size() - 1).get(l.size() - 1));

                baifenshu = value1 / value2;
                baifenshu = (float) (Math.round(baifenshu * 10000)) / 100;

                String baifenzhi = String.valueOf(baifenshu);
                baifenzhi = baifenzhi + "%";
                lbaifen.add(baifenzhi);

            }

            listData.add(lbaifen);


            //float   a   =   123.2334f;
            //  float   b   =   (float)(Math.round(a*100))/100;

            int zt = 2;//������ܱ�
            int time=toExcel(listData, zt);
            return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG, "<a href='"+remoteAddr+"/excel/shouruhuizong"+time+".xls'>����������ܱ�Excel</a>");
        } catch (Exception e) {
            return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG, "Excel��񵼳�ʧ�ܣ�");
        }
    }

    /**
     * �մ����ϸ��
     *
     * @param form
     * @param remoteAddr
     * @return
     */
    public CommonMessage downCunKuanMingXi(ZhangMuForm form, String remoteAddr) {
        double beizhujine = 0D;
        try {
            ParameterSet set = new ParameterSet();
            String cunkuanyinhang = "";
            String date = "";
            String[] uuid = form.getUUIDS();
            List<List<String>> listData = new ArrayList<List<String>>();
            for (int i = 0; i < uuid.length; i++) {
                set.add("UUID", "@UUID", uuid[i]);
                DataSet<DataRow> queryDate = dao.executeQuery("getZhangmuXinxi", set);
                cunkuanyinhang += "," + queryDate.get(0).getDataElement("cunkuanyinhang").getString();
                date += "," + queryDate.get(0).getDataElement("cunkuanshijian").getString();
            }
            cunkuanyinhang = cunkuanyinhang.replaceFirst(",", "");
            date = date.replaceFirst(",", "");

            List<String> l1 = new ArrayList<String>();
            l1.add(date + "�շѴ����ϸ(" + cunkuanyinhang + ")");
            listData.add(l1);
            List<String> l2 = new ArrayList<String>();
            l2.add("�տ�����");
            l2.add("�վݺ�");
            l2.add("��ַ");
            l2.add("��ע");
            l2.add("����");//1
            l2.add("����");//2
            l2.add("����");//3
            l2.add("����");//4
            l2.add("����");//5
            l2.add("����");//6
            l2.add("����");
            l2.add("����");
            l2.add("�豸Ѻ��");
            l2.add("�豸Ѻ��");

            l2.add("�����豸");
            l2.add("��װ��");
            l2.add("�ӵ�/����/ά��/����");
            l2.add("���ϼ�");

            l2.add("���ϼ�");
            l2.add("���ϼ�");
            l2.add("���ϼ�");
            l2.add("���ϼ�");
            l2.add("���ϼ�");
            l2.add("���ϼ�");
            l2.add("���ϼ�");
            l2.add("���ϼ�");
            l2.add("���ϼ�");
            l2.add("��Ʊ��ϸ");

            listData.add(l2);

            List<String> l3 = new ArrayList<String>();
            l3.add("�տ�����");
            l3.add("�վݺ�");
            l3.add("��ַ");
            l3.add("��ע");
            l3.add("4M");
            l3.add("10M");
            l3.add("12M");
            l3.add("20M");
            l3.add("50M");
            l3.add("100M");
            l3.add("240Ԫ/1��");
            l3.add("120Ԫ/2��");
            l3.add("ONUѺ��");
            l3.add("������Ѻ��");
            l3.add("������400Ԫ");
            l3.add("���150Ԫ/�绰205Ԫ");
            l3.add("33-50Ԫ");
            l3.add("pos��");
            l3.add("pos����Ʊ");
            l3.add("�ֽ�");
            l3.add("��Ʊ");
            l3.add("֧Ʊ");
            l3.add("֧Ʊ��Ʊ");
            l3.add("΢��֧��");
            l3.add("֧����֧��");
            l3.add("���");
            l3.add("��㿪Ʊ");
            l3.add("��Ʊ��ϸ");

            listData.add(l3);

            List<DataSet<DataRow>> dataSets = new ArrayList<DataSet<DataRow>>();

            ParameterSet set1 = new ParameterSet();
            for (int i = 0; i < uuid.length; i++) {
                set1.add("zmid", "@zmid", uuid[i]);
                DataSet<DataRow> query = dao.executeQuery("GetYipipeiDataList", set1);
                dataSets.add(query);
            }
            DataSet<DataRow> executeQuery = DataSetUtil.unionDataSet(dataSets);
            for (int i = 0; i < executeQuery.size(); i++) {
                List<String> list = new ArrayList<String>();
                String shoukuanshijian = executeQuery.get(i).getDataElement("shoukuanshijian").getString();//0

                String shoujuhao = executeQuery.get(i).getDataElement("shoujubenhao").getString();//1

                String xiaoqu = executeQuery.get(i).getDataElement("xiaoqu").getString();//2
                String dizhi = xiaoqu + "/" + executeQuery.get(i).getDataElement("dizhi").getString();//2

                String beizhu = executeQuery.get(i).getDataElement("beizhu").getString();//3

                String wangluo = executeQuery.get(i).getDataElement("wangluo").getString();
                String wangluo1 = "";//1
                String wangluo2 = "";//2
                String wangluo3 = "";//3
                String wangluo4 = "";//4
                String wangluo5 = "";//5
                String wangluo6 = "";//6
                String kuandaifei = executeQuery.get(i).getDataElement("kuandaifei").getString();
                String dianhua = executeQuery.get(i).getDataElement("dianhua").getString();
                if (dianhua.trim().equals("0")) {
                    if (wangluo.equals("4M")) {
                        wangluo1 = kuandaifei;
                    } else if (wangluo.equals("10M")) {
                        wangluo2 = kuandaifei;
                    } else if (wangluo.equals("12M")) {
                        wangluo3 = kuandaifei;
                    } else if (wangluo.equals("20M")) {
                        wangluo4 = kuandaifei;
                    } else if (wangluo.equals("50M")) {
                        wangluo5 = kuandaifei;
                    } else if (wangluo.equals("100M")) {
                        wangluo6 = kuandaifei;
                    } else {
                        wangluo = kuandaifei;
                        beizhu = beizhu + kuandaifei;
                        if (kuandaifei == null || kuandaifei.trim().equals("")) {
                            kuandaifei = "0";
                            beizhujine += Double.valueOf(kuandaifei);
                        } else {
                            beizhujine += Double.valueOf(kuandaifei);
                        }
                    }
                } else {
                    continue;
                }


                String shoushifei = executeQuery.get(i).getDataElement("shoushifei").getString();
                String shoushifei1 = "";//13
                String shoushifei2 = "";//14
                if (shoushifei != null && !shoushifei.trim().equals("")) {
                    if (Integer.parseInt(shoushifei.trim()) < 240) {
                        shoushifei2 = shoushifei;
                    } else {
                        shoushifei1 = shoushifei;
                    }
                }

                String jidingheyj = executeQuery.get(i).getDataElement("jidingheyj").getString();
                if (jidingheyj.trim().equals("")) {
                    jidingheyj = "0";
                }
                String onuyj = executeQuery.get(i).getDataElement("onuyj").getString();
                if (onuyj.trim().equals("")) {
                    onuyj = "0";
                }
                String shebeiYJ = "";
                if (jidingheyj != null && onuyj != null) {
                    shebeiYJ = String.valueOf(Double.valueOf(jidingheyj) + Double.valueOf(onuyj));//15
                }

                String shebeixiaoshou = executeQuery.get(i).getDataElement("shebeixiaoshou").getString();//16
                String chuzhuangfei = executeQuery.get(i).getDataElement("chuzhuangfei").getString();//17
                String cailiaofei = executeQuery.get(i).getDataElement("cailiaofei").getString();//18

                String kuandaifei1;
                String shoushifeia;
                String shebeiYJ1;
                String shebeixiaoshou1;
                String chuzhuangfei1;
                String cailiaofei1;
                if (kuandaifei == null || kuandaifei.trim().equals("")) {
                    kuandaifei1 = "0";
                } else {
                    kuandaifei1 = kuandaifei;
                }

                if (shoushifei == null || shoushifei.trim().equals("")) {
                    shoushifeia = "0";
                } else {
                    shoushifeia = shoushifei;
                }

                if (shebeiYJ == null || shebeiYJ.trim().equals("")) {
                    shebeiYJ1 = "0";
                } else {
                    shebeiYJ1 = shebeiYJ;
                }

                if (shebeixiaoshou == null || shebeixiaoshou.trim().equals("")) {
                    shebeixiaoshou1 = "0";
                } else {
                    shebeixiaoshou1 = shebeixiaoshou;
                }

                if (chuzhuangfei == null || chuzhuangfei.trim().equals("")) {
                    chuzhuangfei1 = "0";
                } else {
                    chuzhuangfei1 = chuzhuangfei;
                }
                if (cailiaofei == null || cailiaofei.trim().equals("")) {
                    cailiaofei1 = "0";
                } else {
                    cailiaofei1 = cailiaofei;
                }
                double hj = 0.00D;
                hj = Double.valueOf(kuandaifei1)
                        + Double.valueOf(shoushifeia)
                        + Double.valueOf(shebeiYJ1)
                        + Double.valueOf(shebeixiaoshou1)
                        + Double.valueOf(chuzhuangfei1)
                        + Double.valueOf(cailiaofei1);
                if (hj == 0) {
                    continue;
                }
                String shoujujine = String.valueOf(hj);
                String zhifuleixing = executeQuery.get(i).getDataElement("zhifuleixing").getString();
                String zhifuleixing1 = "";
                String zhifuleixing2 = "";
                String zhifuleixing3 = "";
                String zhifuleixing4 = "";
                String zhifuleixing5 = "";
                String zhifuleixing6 = "";
                String zhifuleixing7 = "";
                String zhifuleixing8 = "";
                String zhifuleixing9 = "";
                String zhifuleixing10 = "";
                String kaipiaoxinxi = executeQuery.get(i).getDataElement("kaipiaoxinxi").getString();//25
                if (zhifuleixing.trim().equals("pos��")) {
                    zhifuleixing1 = shoujujine;
                } else if (zhifuleixing.trim().equals("pos����Ʊ")) {
                    zhifuleixing2 = shoujujine;
                } else if (zhifuleixing.trim().equals("�ֽ�")) {
                    zhifuleixing3 = shoujujine;
                } else if (zhifuleixing.trim().equals("��Ʊ")) {
                    zhifuleixing4 = shoujujine;
                } else if (zhifuleixing.trim().equals("֧Ʊ")) {
                    zhifuleixing5 = shoujujine;
                } else if (zhifuleixing.trim().equals("֧Ʊ��Ʊ")) {

                    zhifuleixing6 = shoujujine;
                } else if (zhifuleixing.trim().equals("΢��֧��")||zhifuleixing.trim().equals("΢��ɨ��֧��")) {
                    zhifuleixing7 = shoujujine;
                } else if (zhifuleixing.trim().equals("֧����֧��")||zhifuleixing.trim().equals("֧����ɨ��֧��")) {
                    zhifuleixing8 = shoujujine;
                } else if (zhifuleixing.trim().equals("���")) {
                    zhifuleixing9 = shoujujine;
                } else if (zhifuleixing.trim().equals("��㿪Ʊ")) {
                    zhifuleixing10 = shoujujine;
                } else {
                    kaipiaoxinxi = shoujujine;
                }


                //String shoujujine = String.valueOf(hj);//�� 19

                //String kaipiaojine ="";// 25
                //String posejijine ="";// 26


                list.add(shoukuanshijian);
                list.add(shoujuhao == null ? "" : shoujuhao);
                list.add(dizhi);
                list.add(beizhu == null ? "" : beizhu);
                list.add(wangluo1);
                list.add(wangluo2);
                list.add(wangluo3);
                list.add(wangluo4);
                list.add(wangluo5);
                list.add(wangluo6);
                list.add(shoushifei1);
                list.add(shoushifei2);
                list.add(onuyj);
                list.add(jidingheyj);
                list.add(shebeixiaoshou == null ? "" : shebeixiaoshou);
                list.add(chuzhuangfei == null ? "" : chuzhuangfei);
                list.add(cailiaofei == null ? "" : cailiaofei);
                list.add(zhifuleixing1 == null ? "" : zhifuleixing1);
                list.add(zhifuleixing2 == null ? "" : zhifuleixing2);
                list.add(zhifuleixing3 == null ? "" : zhifuleixing3);
                list.add(zhifuleixing4 == null ? "" : zhifuleixing4);
                list.add(zhifuleixing5 == null ? "" : zhifuleixing5);
                list.add(zhifuleixing6 == null ? "" : zhifuleixing6);
                list.add(zhifuleixing7 == null ? "" : zhifuleixing7);
                list.add(zhifuleixing8 == null ? "" : zhifuleixing8);
                list.add(zhifuleixing9 == null ? "" : zhifuleixing9);
                list.add(zhifuleixing10 == null ? "" : zhifuleixing10);
                list.add(kaipiaoxinxi == null ? "" : kaipiaoxinxi);

                listData.add(list);
            }

            List<String> l = new ArrayList<String>();
            l.add("�ϼ�");
            l.add("");
            l.add("");
            l.add(String.valueOf(beizhujine));
            //������
            for (int j = 4; j < listData.get(2).size() - 1; j++) {
                float sum = 0;
                //������
                for (int i = 3; i < listData.size(); i++) {
                    //��ÿһ���������е�ֵ���Դ����ơ�
                    String string = listData.get(i).get(j);
                    if (string == null || string.trim().equals("")) {
                        string = "0";
                    }
                    sum += Double.valueOf(string);
                }
                l.add(String.valueOf(sum));
            }
            l.add("");
            listData.add(l);

            List<String> ldaoshuto = new ArrayList<String>();
            ldaoshuto.add("");
            ldaoshuto.add("");
            ldaoshuto.add("");
            ldaoshuto.add("");
            //��4-9�� ���һ�к�  �����Ѻͣ�
            float sumWang = 0;
            for (int i = 4; i < 10; i++) {
                String string = listData.get(listData.size() - 1).get(i);
                if (string == null || string.trim().equals("")) {
                    string = "0";
                }
                sumWang += Double.valueOf(string);
            }
            ldaoshuto.add(String.valueOf(sumWang));
            ldaoshuto.add(String.valueOf(sumWang));
            ldaoshuto.add(String.valueOf(sumWang));
            ldaoshuto.add(String.valueOf(sumWang));
            ldaoshuto.add(String.valueOf(sumWang));
            ldaoshuto.add(String.valueOf(sumWang));


            //���һ�к�  ���绰�Ѻͣ�
            float sumDian = 0;
            for (int i = 10; i < 12; i++) {
                String string = listData.get(listData.size() - 1).get(i);
                if (string == null || string.equals("")) {
                    string = "0";
                }
                sumDian += Double.valueOf(string);
            }
            ldaoshuto.add(String.valueOf(sumDian));
            ldaoshuto.add(String.valueOf(sumDian));
            float sumshebei = 0;
            for (int i = 12; i < 17; i++) {
                String string = listData.get(listData.size() - 1).get(i);
                if (string == null || string.equals("")) {
                    string = "0";
                }
                sumshebei += Double.valueOf(string);
            }
            ldaoshuto.add(String.valueOf(sumshebei));
            ldaoshuto.add(String.valueOf(sumshebei));
            ldaoshuto.add(String.valueOf(sumshebei));
            ldaoshuto.add(String.valueOf(sumshebei));
            ldaoshuto.add(String.valueOf(sumshebei));


            Double zongji = 0.0d;

            zongji += Double.valueOf(listData.get(listData.size() - 1).get(17));
            zongji += Double.valueOf(listData.get(listData.size() - 1).get(18));
            zongji += Double.valueOf(listData.get(listData.size() - 1).get(19));
            zongji += Double.valueOf(listData.get(listData.size() - 1).get(20));
            zongji += Double.valueOf(listData.get(listData.size() - 1).get(21));
            zongji += Double.valueOf(listData.get(listData.size() - 1).get(22));
            zongji += Double.valueOf(listData.get(listData.size() - 1).get(23));
            zongji += Double.valueOf(listData.get(listData.size() - 1).get(24));
            zongji += Double.valueOf(listData.get(listData.size() - 1).get(25));
            zongji += Double.valueOf(listData.get(listData.size() - 1).get(26));


            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add(String.valueOf(zongji));
            ldaoshuto.add("");
            listData.add(ldaoshuto);

            List<String> lzongji = new ArrayList<String>();
            lzongji.add("�ܼ�");
            lzongji.add(String.valueOf(zongji));
            lzongji.add("Ԫ");
            listData.add(lzongji);

            int zt = 3;//�շѴ����ϸ��
            int time=toExcel(listData, zt);
            return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG,"<a href='"+remoteAddr+"/excel/shoufeicunkuanmingxi"+time+".xls'>�����շѴ����ϸ��Excel</a>");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG, "Excel��񵼳�ʧ�ܣ�");
        }
    }

    /**
     * ���Ŵ��շѱ�
     *
     * @param form
     * @param remoteAddr
     * @return
     */
    public CommonMessage downDianXinShouKuan(ZhangMuForm form, String remoteAddr) {
        double beizhujine = 0D;
        try {
            ParameterSet set = new ParameterSet();
            String cunkuanyinhang = "";
            String date = "";
            String[] uuid = form.getUUIDS();
            List<List<String>> listData = new ArrayList<List<String>>();
            for (int i = 0; i < uuid.length; i++) {
                set.add("UUID", "@UUID", uuid[i]);
                DataSet<DataRow> queryDate = dao.executeQuery("getZhangmuXinxi", set);
                cunkuanyinhang += "," + queryDate.get(0).getDataElement("cunkuanyinhang").getString();
                date += "," + queryDate.get(0).getDataElement("cunkuanshijian").getString();
            }
            cunkuanyinhang = cunkuanyinhang.replaceFirst(",", "");
            date = date.replaceFirst(",", "");

            List<String> l1 = new ArrayList<String>();
            //excel��һ�б�ͷ
            l1.add(date + "������Ŵ��շѴ����ϸ(" + cunkuanyinhang + ")");
            listData.add(l1);
            //excel�ڶ��б�ͷ
            List<String> l2 = new ArrayList<String>();
            l2.add("�տ�����");
            l2.add("�վݺ�");
            l2.add("��ַ");
            l2.add("��ע");
            l2.add("e8�ײ�");
            l2.add("e8�ײ�");
            l2.add("e9�ײ�");
            l2.add("e9�ײ�");
            l2.add("����");
            l2.add("����");
            l2.add("����");
            l2.add("����");
            l2.add("������");
            l2.add("�豸Ѻ��");
            l2.add("�绰��װ��");
            l2.add("���ϼ�");
            l2.add("���ϼ�");
            l2.add("��Ʊ����");

            listData.add(l2);
            //excel�����б�ͷ
            List<String> l3 = new ArrayList<String>();
            l3.add("�տ�����");
            l3.add("�վݺ�");
            l3.add("��ַ");
            l3.add("��ע");
            l3.add("108/��/4M");
            l3.add("1080/��");
            l3.add("139/��");
            l3.add("1390/��");
            l3.add("800/��/2M");
            l3.add("1000/��/4M");
            l3.add("1400/��/8M");
            l3.add("100/��");
            l3.add("������");
            l3.add("�豸Ѻ��");
            l3.add("205Ԫ");
            l3.add("�վݽ��");
            l3.add("��Ʊ���");
            l3.add("��Ʊ����");

            listData.add(l3);

            List<DataSet<DataRow>> dataSets = new ArrayList<DataSet<DataRow>>();
            ParameterSet set1 = new ParameterSet();
            for (int i = 0; i < uuid.length; i++) {
                set1.add("zmid", "@zmid", uuid[i]);
                DataSet<DataRow> query = dao.executeQuery("GetYipipeiDataList", set1);
                dataSets.add(query);
            }

            DataSet<DataRow> executeQuery = DataSetUtil.unionDataSet(dataSets);

            for (int i = 0; i < executeQuery.size(); i++) {
                List<String> list = new ArrayList<String>();
                String shoukuanshijian = executeQuery.get(i).getDataElement("shoukuanshijian").getString();//0
                String shoujuhao = executeQuery.get(i).getDataElement("shoujubenhao").getString();//1
                String xiaoqu = executeQuery.get(i).getDataElement("xiaoqu").getString();
                String dizhi = xiaoqu + "/" + executeQuery.get(i).getDataElement("dizhi").getString();//2
                String beizhu = executeQuery.get(i).getDataElement("beizhu").getString();//3
                double beizhuKuan = 0.00D;//4
                String wangluo1 = "";//4
                String wangluo2 = "";//5
                String wangluo3 = "";//6
                String wangluo4 = "";//7
                String wangluo5 = "";//8
                String wangluo6 = "";//9
                String wangluo7 = "";//10
                String wangluo8 = "";//11
                String bzygf = "";//12
                String shebeiYJ = "";//13
                String chuzhuangfei = "";//14

                String dianhua = executeQuery.get(i).getDataElement("dianhua").getString();
                if (!dianhua.trim().equals("0")) {
                    String kuandaifei = executeQuery.get(i).getDataElement("nianfei").getString();
                    if (kuandaifei.equals("108")) {
                        wangluo1 = kuandaifei;
                    } else if (kuandaifei.equals("1080")) {
                        wangluo2 = kuandaifei;
                    } else if (kuandaifei.equals("139")) {
                        wangluo3 = kuandaifei;
                    } else if (kuandaifei.equals("1390")) {
                        wangluo4 = kuandaifei;
                    } else if (kuandaifei.equals("800")) {
                        wangluo5 = kuandaifei;
                    } else if (kuandaifei.equals("1000")) {
                        wangluo6 = kuandaifei;
                    } else if (kuandaifei.equals("1400")) {
                        wangluo7 = kuandaifei;
                    } else if (kuandaifei.equals("100")) {
                        wangluo8 = kuandaifei;
                    } else {
                        beizhu = beizhu + kuandaifei;
                        if (kuandaifei == null || kuandaifei.trim().equals("")) {
                            kuandaifei = "0";
                            beizhujine += Double.valueOf(kuandaifei);
                            beizhuKuan = Double.valueOf(kuandaifei);
                        } else {
                            beizhujine += Double.valueOf(kuandaifei);
                            beizhuKuan = Double.valueOf(kuandaifei);
                        }
                    }
                    bzygf = executeQuery.get(i).getDataElement("bzygf").getString();//12
                    String jidingheyj = executeQuery.get(i).getDataElement("jidingheyj").getString();
                    if (jidingheyj.trim().equals("")) {
                        jidingheyj = "0";
                    }
                    String onuyj = executeQuery.get(i).getDataElement("onuyj").getString();
                    if (onuyj.trim().equals("")) {
                        onuyj = "0";
                    }
                    if (jidingheyj != null && onuyj != null) {
                        shebeiYJ = String.valueOf(Double.valueOf(jidingheyj) + Double.valueOf(onuyj));//13
                    }
                    chuzhuangfei = executeQuery.get(i).getDataElement("chuzhuangfei").getString();//14
                } else {
                    continue;
                }

                double sum = 0.00D;
                sum += beizhuKuan;
                if (wangluo1 == null || wangluo1.trim().equals("")) {
                } else {
                    sum += Double.valueOf(wangluo1);
                }
                if (wangluo2 == null || wangluo2.trim().equals("")) {
                } else {
                    sum += Double.valueOf(wangluo2);
                }
                if (wangluo3 == null || wangluo3.trim().equals("")) {
                } else {
                    sum += Double.valueOf(wangluo3);
                }
                if (wangluo4 == null || wangluo4.trim().equals("")) {
                } else {
                    sum += Double.valueOf(wangluo4);
                }
                if (wangluo5 == null || wangluo5.trim().equals("")) {
                } else {
                    sum += Double.valueOf(wangluo5);
                }
                if (wangluo6 == null || wangluo6.trim().equals("")) {
                } else {
                    sum += Double.valueOf(wangluo6);
                }
                if (wangluo7 == null || wangluo7.trim().equals("")) {
                } else {
                    sum += Double.valueOf(wangluo7);
                }
                if (wangluo8 == null || wangluo8.trim().equals("")) {
                } else {
                    sum += Double.valueOf(wangluo8);
                }
                if (bzygf == null || bzygf.trim().equals("")) {
                } else {
                    sum += Double.valueOf(bzygf);
                }
                if (shebeiYJ == null || shebeiYJ.trim().equals("")) {
                } else {
                    sum += Double.valueOf(shebeiYJ);
                }
                if (chuzhuangfei == null || chuzhuangfei.trim().equals("")) {
                } else {
                    sum += Double.valueOf(chuzhuangfei);
                }

                String shoujujine = String.valueOf(sum);//�� 15

                String kaipiaojine = "";// 16
                String kaipiaomingcheng = "";// 17

                list.add(shoukuanshijian);
                list.add(shoujuhao == null ? "" : shoujuhao);
                list.add(dizhi);
                list.add(beizhu == null ? "" : beizhu);
                list.add(wangluo1);
                list.add(wangluo2);
                list.add(wangluo3);
                list.add(wangluo4);
                list.add(wangluo5);
                list.add(wangluo6);
                list.add(wangluo7);
                list.add(wangluo8);
                list.add(bzygf);
                list.add(shebeiYJ);
                list.add(chuzhuangfei == null ? "" : chuzhuangfei);
                list.add(shoujujine);
                list.add(kaipiaojine);
                list.add(kaipiaomingcheng);

                listData.add(list);
            }

            List<String> l = new ArrayList<String>();
            l.add("�ϼ�");
            l.add("�ϼ�");
            l.add("");
            l.add(String.valueOf(beizhujine));
            //������
            for (int j = 4; j < listData.get(2).size() - 2; j++) {
                float sum = 0;
                //������
                for (int i = 3; i < listData.size(); i++) {
                    //��ÿһ���������е�ֵ���Դ����ơ�
                    String string = listData.get(i).get(j);
                    if (string == null || string.equals("")) {
                        string = "0";
                    }
                    sum += Double.valueOf(string);
                }
                l.add(String.valueOf(sum));
            }
            l.add("0");
            l.add("");
            listData.add(l);


            int zt = 4;//���Ŵ��շѴ����ϸ��
            int time=toExcel(listData, zt);
            //toExceldownDianXinShouKuan(listData);
            return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG, "<a href='"+remoteAddr+"/excel/dianxindaishoufei"+time+".xls'>���ص��Ŵ��շѴ����ϸ��Excel</a>");
        } catch (Exception e) {
            return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG, "Excel��񵼳�ʧ�ܣ�");
        }
    }


    private int  toExcel(List<List<String>> listData, int zt) throws IOException {
        int time= (int) (Math.random()*10000);
        try {
            ExportCaiwuExcel ex = new ExportCaiwuExcel();
            String[] headers = {};

            String path = this.getClass().getClassLoader().getResource("/").getPath();
            int index = path.indexOf("WEB-INF");
            path = path.substring(0, index);


            if (zt == 1) {
                path = path + "excel/rijizhang"+time+".xls";
                if (path.indexOf("%") >= 0) {
                    try {
                        path = URLDecoder.decode(path, "utf-8");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (zt == 2) {
                path = path + "excel/shouruhuizong"+time+".xls";
                if (path.indexOf("%") >= 0) {
                    try {
                        path = URLDecoder.decode(path, "utf-8");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (zt == 3) {
                path = path + "excel/shoufeicunkuanmingxi"+time+".xls";
                if (path.indexOf("%") >= 0) {
                    try {
                        path = URLDecoder.decode(path, "utf-8");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (zt == 4) {//���Ŵ��շѴ����ϸ��
                path = path + "excel/dianxindaishoufei"+time+".xls";
                if (path.indexOf("%") >= 0) {
                    try {
                        path = URLDecoder.decode(path, "utf-8");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            OutputStream out = new FileOutputStream(path);
            if (zt == 1) {
                ex.exportExcelYHRiJiZhang(headers, listData, out);
            }
            if (zt == 2) {
                ex.exportExcelHuiZongTongji(headers, listData, out);
            }
            if (zt == 3) {
                ex.exportExcelCunKuanMingXi(headers, listData, out);
            }
            if (zt == 4) {
                ex.exportExcelDianXinShouKuan(headers, listData, out);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }


}
