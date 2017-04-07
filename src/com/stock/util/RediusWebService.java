package com.stock.util;

import com.hrbank.business.common.CommonDao;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangqingxiang on 2016/6/20.
 */
public class RediusWebService {
    private static CommonDao dao=new CommonDao();

    /**
     * ͣ��
     * @param dataRow
     * @return
     * @throws Exception
     */
    public static boolean tingJi(DataRow dataRow,String isweb) {

        String account=dataRow.getDataElement("wangluoip").getString();
        //����ǵ��ŵ�Ҫ��ȡ@ǰ����˺�
        if(account.indexOf("@")>0){
            account=account.substring(0,account.indexOf("@"));
        }
//        account="002123456";
        String xiaoqu=dataRow.getDataElement("xiaoqu").getString();
        String dizhi=dataRow.getDataElement("dizhi").getString();
        String kaijishijian=dataRow.getDataElement("kaijishijian").getString();
        String[] result=new String[3];
        try{
            URL url = new URL("http://192.168.21.101/radius/api.jsp?func=NbsToRadiusIntetface/ajaxFreeUserDisable&sUserName="+account);
//            result=excute(url);
        }catch(Exception e){
            e.printStackTrace();
            result[0]="ʧ��";
            result[1]="-1";
            result[2]=e.getMessage();
        }
        logRedius(account,kaijishijian,result[0],result[1],result[2],"ͣ��",xiaoqu,dizhi,isweb);
        return "�ɹ�".equals(result[0]);
    }

    /**
     * ����
     * @param dataRow
     * @return
     * @throws Exception
     */
    public static boolean fuji(DataRow dataRow,String isweb) {
        String account=dataRow.getDataElement("wangluoip").getString();
        //����ǵ��ŵ�Ҫ��ȡ@ǰ����˺�
        if(account.indexOf("@")>0){
            account=account.substring(0,account.indexOf("@"));
        }

//        account="002123456";
        String xiaoqu=dataRow.getDataElement("xiaoqu").getString();
        String dizhi=dataRow.getDataElement("dizhi").getString();
        String kaijishijian=dataRow.getDataElement("kaijishijian").getString();
        String[] result=new String[3];
        try{
            URL url = new URL("http://192.168.21.101/radius/api.jsp?func=NbsToRadiusIntetface/ajaxFreeUserEnable&sUserName="+account);
//            result=excute(url);
        }catch(Exception e){
            e.printStackTrace();
            result[0]="ʧ��";
            result[1]="-1";
            result[2]=e.getMessage();
        }
        logRedius(account,kaijishijian,result[0],result[1],result[2],"����",xiaoqu,dizhi,isweb);
        return "�ɹ�".equals(result[0]);

    }
    /**
     * �޸�����
     * @param dataRow ����
     * @param isweb  �Ƿ���Դ����վ
     * @return
     * @throws Exception
     */
    public static boolean changePwd(DataRow dataRow,String isweb) {

        String account=dataRow.getDataElement("wangluoip").getString();
        //����Ƿ��ǵ��ŵģ�����ǵ��ŵ�Ҫ��ȡ@ǰ�������
        if(account.indexOf("@")>0){
            account=account.substring(0,account.indexOf("@"));
        }
//        account="002123456";
        String password=dataRow.getDataElement("userId").getString();
        String xiaoqu=dataRow.getDataElement("xiaoqu").getString();
        String dizhi=dataRow.getDataElement("dizhi").getString();
        String kaijishijian=dataRow.getDataElement("kaijishijian").getString();
        String[] result=new String[3];
        try{
            URL url = new URL("http://192.168.21.101/radius/api.jsp?func=NbsToRadiusIntetface/ajaxFreeUserPWD&sUserName="+account+"&sPassword_1="+password+"&sPassword_2="+password);
//            result=excute(url);
        }catch(Exception e){
            e.printStackTrace();
            result[0]="ʧ��";
            result[1]="-1";
            result[2]=e.getMessage();
        }
        logRedius(account,kaijishijian,result[0],result[1],result[2],"�����޸�",xiaoqu,dizhi,isweb);
        return "�ɹ�".equals(result[0]);
    }
    private static String[] excute(URL url) throws Exception{
        long begintime = System.currentTimeMillis();
        String resultCode="";
        String resultMsg="";
        String status="ʧ��";
        HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
        urlcon.connect();         //��ȡ����
        InputStream is = urlcon.getInputStream();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
        StringBuffer bs = new StringBuffer();
        String result = null;
        while((result=buffer.readLine())!=null){
            bs.append(result);
        }
        System.out.println(bs.toString());

        result=bs.toString();
        if(result.length()<0){
            resultMsg="�޷����ӷ�����";
            resultCode="-1";
        }else{
            result=result.replace("\"", "");
            String[] errmsg=result.substring(1,result.lastIndexOf(",")).split(":");
            String[] errno=result.substring(result.lastIndexOf(",")+1,result.length()-1).split(":");
            resultMsg=errmsg[1];
            resultCode=errno[1];
        }
        if(resultCode.equals("0")){
            status="�ɹ�";
        }

        return new String[]{status,resultCode,resultMsg};
    }

    /**
     * ���ʱ����ʱ�����
     * @param dataRow
     * @return
     */
    public static boolean change(DataRow dataRow,String isweb) {
        String account=dataRow.getDataElement("wangluoip").getString();
        //����ǵ��ŵ�Ҫ��ȡ@ǰ����˺�
        if(account.indexOf("@")>0){
            account=account.substring(0,account.indexOf("@"));
        }
//        account="002123456";
        String xiaoqu=dataRow.getDataElement("xiaoqu").getString();
        String dizhi=dataRow.getDataElement("dizhi").getString();
        String kaijishijian=dataRow.getDataElement("kaijishijian").getString();
        String wangluo=dataRow.getDataElement("wangluo").getString();
        String dExpireDate="2049-09-09";
        String[] result=new String[3];
        try{
            URL url = new URL("http://192.168.21.101/radius/api.jsp?func=NbsToRadiusIntetface/ajaxUpdateDate&sUserName="+account+"&dExpireDate="+dExpireDate+"&iFlow="+wangluo);
//             result=excute(url);
        }catch(Exception e){
            e.printStackTrace();
            result[0]="ʧ��";
            result[1]="-1";
            result[2]=e.getMessage();
        }
        logRedius(account,kaijishijian,result[0],result[1],result[2],"���ʱ��",xiaoqu,dizhi,isweb);
        return "�ɹ�".equals(result[0]);
    }


    public  static void logRedius(String account,String createDt,String status,String resultcode,String resultmsg,String type,String xiaoqu,String dizhi,String isweb){
        try {
            ParameterModel model = new ParameterModel();
            model.put("createDt",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            model.put("account",account);
            model.put("status",status==null?"":status);
            model.put("type",type);
            model.put("resultmsg", resultmsg==null?"":status);
            model.put("resultcode",resultcode==null?"":status);
            model.put("serverip","");
            model.put("xiaoqu",xiaoqu);
            model.put("dizhi",dizhi);
            model.put("isweb",isweb);
            dao.insert("rediuslog", model);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("��־û�д�ӡ");
        }
    }
}
