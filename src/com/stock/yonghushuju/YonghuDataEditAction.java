/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data edit or update class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 */
package com.stock.yonghushuju;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.yonghushuju.service.TuidingService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.fenPeiIp.FenguangKeService;
import com.stock.kucun.KucunService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

/**
 * user data edit or update class.
 *
 * @author Zhu.Xiao-Lei
 */
public class YonghuDataEditAction extends BusinessAction {
    PaiGongDanService service = new PaiGongDanService();
    YonghuDataService serviceData = new YonghuDataService();
    PaiGongDanService service2 = new PaiGongDanService();
    KucunService kucunService = new KucunService();
    FenguangKeService fgservice = new FenguangKeService();
    TuidingService tuidingService = new TuidingService();
    private CommonDao dao = new CommonDao();

    /**
     * 放入小区列表
     *
     * @param request
     * @throws Exception
     */
    private void savedInRequest(HttpServletRequest request) throws Exception {
        List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
        request.setAttribute("xiaoquList", xiaoquList);
    }

    /**
     * 跳转到更新页面
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward initEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        savedInRequest(request);
        YonghuDataEntityForm dataForm = (YonghuDataEntityForm) form;
        DataRow dataRow = serviceData.getDataByUUID(dataForm.getUUID());
        CommonMessage message = new CommonMessage("SUCCESS");
        if (saveMessage(message, request)) {
            return mapping.findForward(FW_SUCCESS);
        } else {
            dataForm.setUUID(dataRow.getDataElement("PK_ID").getString());
            dataForm.setYonghuzhuangtai(dataRow.getDataElement("yonghuzhuangtai").getString());
            dataForm.setXingming(dataRow.getDataElement("xingming").getString());
            dataForm.setShenfensheng(dataRow.getDataElement("shenfensheng").getString());
            dataForm.setShoujuhao(dataRow.getDataElement("shoujuhao").getString());
            dataForm.setFenguangxianhao(dataRow.getDataElement("fenguangxianhao").getString());
            dataForm.setJiexuweizhi(dataRow.getDataElement("jiexuweizhi").getString());
            dataForm.setKaijishijian(dataRow.getDataElement("kaijishijian").getString());
            dataForm.setTingjishijian(dataRow.getDataElement("tingjishijian").getString());
            dataForm.setYouxiaoshijian(dataRow.getDataElement("youxiaoshijian").getString());
            dataForm.setXiaoqu(dataRow.getDataElement("xiaoqu").getString());
            dataForm.setDizhi(dataRow.getDataElement("dizhi").getString());
            dataForm.setLianxidianhua(dataRow.getDataElement("lianxidianhua").getString());
            dataForm.setWangluo(dataRow.getDataElement("wangluo").getString());
            dataForm.setDianshi(dataRow.getDataElement("dianshi").getString());
            dataForm.setDianhua(dataRow.getDataElement("dianhua").getString());
            dataForm.setYewu(dataRow.getDataElement("yewu").getString());
            dataForm.setFenguang(dataRow.getDataElement("fenguang").getString());
            dataForm.setOnumac(dataRow.getDataElement("onumac").getString());
            dataForm.setStbmcid(dataRow.getDataElement("stbmcid").getString());
            dataForm.setDianshiip(dataRow.getDataElement("dianshiip").getString());
            dataForm.setWangluoip(dataRow.getDataElement("wangluoip").getString());
            dataForm.setDianhuaip(dataRow.getDataElement("dianhuaip").getString());
            dataForm.setDianhuavlan(dataRow.getDataElement("dianhuavlan").getString());
            dataForm.setWangluovlan(dataRow.getDataElement("wangluovlan").getString());
            dataForm.setShangmenshijian(dataRow.getDataElement("shangmenshijian").getString());
            dataForm.setDanzheng(dataRow.getDataElement("danzheng").getString());
            dataForm.setSxdhhm(dataRow.getDataElement("sxdhhm").getString());
            dataForm.setOnuyj(dataRow.getDataElement("onuyj").getString());
            dataForm.setJidingheyj(dataRow.getDataElement("jidingheyj").getString());
            dataForm.setShoushifei(dataRow.getDataElement("shoushifei").getString());
            dataForm.setKuandaifei(dataRow.getDataElement("kuandaifei").getString());
            dataForm.setChuzhuangfei(dataRow.getDataElement("chuzhuangfei").getString());
            dataForm.setYunyingshang(dataRow.getDataElement("yunyingshang").getString());
            dataForm.setBzygf(dataRow.getDataElement("bzygf").getString());
            dataForm.setNianfei(dataRow.getDataElement("nianfei").getString());
            dataForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
            dataForm.setZongshoufei(dataRow.getDataElement("zongshoufei").getString());
            dataForm.setShoujubenhao(dataRow.getDataElement("shoujubenhao").getString());
            dataForm.setQtsbsyqk(dataRow.getDataElement("qtsbsyqk").getString());
            dataForm.setQitahaocai(dataRow.getDataElement("qitahaocai").getString());
            dataForm.setJiexianzi(dataRow.getDataElement("jiexianzi").getString());
            dataForm.setRj11(isNull(dataRow.getDataElement("rj11")));
            dataForm.setRj45(isNull(dataRow.getDataElement("rj45")));
            dataForm.setMokuai(isNull(dataRow.getDataElement("mokuai")));
            dataForm.setMianban(isNull(dataRow.getDataElement("mianban")));
            dataForm.setWangxian(isNull(dataRow.getDataElement("wangxian")));
            dataForm.setShigongren(isNull(dataRow.getDataElement("shigongren")));
            dataForm.setXianchangbeizhu(isNull(dataRow.getDataElement("xianchangbeizhu")));
            dataForm.setBeizhuhuizong(isNull(dataRow.getDataElement("beizhuhuizong")));
            dataForm.setKaipiaoxinxi(isNull(dataRow.getDataElement("kaipiaoxinxi")));
            dataForm.setShebeixiaoshou(dataRow.getDataElement("shebeixiaoshou").getString());
            dataForm.setCailiaofei(dataRow.getDataElement("cailiaofei").getString());
            dataForm.setPipeizhuangtai(dataRow.getDataElement("pipeizhuangtai").getString());
            dataForm.setShoukuanshijian(dataRow.getDataElement("shoukuanshijian").getString());
            dataForm.setFenguangID(dataRow.getDataElement("fenguangID").getString());

            return mapping.findForward(FW_INIT_EDIT);
        }
    }

    /**
     * 用户数据界面退订
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward initTuiding2(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        savedInRequest(request);
        YonghuDataEntityForm dataForm = (YonghuDataEntityForm) form;

        DataRow dataRow = serviceData.getDataByUUID(dataForm.getUUID());
        String yonghuzhuangtai=dataRow.getDataElement("yonghuzhuangtai").getString();
        if (!yonghuzhuangtai.equals("已安装")) {
            saveMessage(ErrorConstant.TUIDING_ERROR1, request);
            return mapping.findForward(FW_SUCCESS);
        } else {
            dataForm.setUUID(dataRow.getDataElement("PK_ID").getString());
            dataForm.setYonghuzhuangtai(dataRow.getDataElement("yonghuzhuangtai").getString());
            dataForm.setXingming(dataRow.getDataElement("xingming").getString());
            dataForm.setShenfensheng(dataRow.getDataElement("shenfensheng").getString());
            dataForm.setShoujuhao(dataRow.getDataElement("shoujuhao").getString());
            dataForm.setFenguangxianhao(dataRow.getDataElement("fenguangxianhao").getString());
            dataForm.setJiexuweizhi(dataRow.getDataElement("jiexuweizhi").getString());
            dataForm.setKaijishijian(dataRow.getDataElement("kaijishijian").getString());
            dataForm.setTingjishijian(dataRow.getDataElement("tingjishijian").getString());
            dataForm.setYouxiaoshijian(dataRow.getDataElement("youxiaoshijian").getString());
            dataForm.setXiaoqu(dataRow.getDataElement("xiaoqu").getString());
            dataForm.setDizhi(dataRow.getDataElement("dizhi").getString());
            dataForm.setLianxidianhua(dataRow.getDataElement("lianxidianhua").getString());
            dataForm.setWangluo(dataRow.getDataElement("wangluo").getString());
            dataForm.setDianshi(dataRow.getDataElement("dianshi").getString());
            dataForm.setDianhua(dataRow.getDataElement("dianhua").getString());
            dataForm.setYewu(dataRow.getDataElement("yewu").getString());
            dataForm.setFenguang(dataRow.getDataElement("fenguang").getString());
            dataForm.setOnumac(dataRow.getDataElement("onumac").getString());
            dataForm.setStbmcid(dataRow.getDataElement("stbmcid").getString());
            dataForm.setDianshiip(dataRow.getDataElement("dianshiip").getString());
            dataForm.setWangluoip(dataRow.getDataElement("wangluoip").getString());
            dataForm.setDianhuaip(dataRow.getDataElement("dianhuaip").getString());
            dataForm.setDianhuavlan(dataRow.getDataElement("dianhuavlan").getString());
            dataForm.setWangluovlan(dataRow.getDataElement("wangluovlan").getString());
            dataForm.setShangmenshijian(dataRow.getDataElement("shangmenshijian").getString());
            dataForm.setDanzheng(dataRow.getDataElement("danzheng").getString());
            dataForm.setSxdhhm(dataRow.getDataElement("sxdhhm").getString());
            dataForm.setOnuyj(dataRow.getDataElement("onuyj").getString());
            dataForm.setJidingheyj(dataRow.getDataElement("jidingheyj").getString());
            dataForm.setShoushifei(dataRow.getDataElement("shoushifei").getString());
            dataForm.setKuandaifei(dataRow.getDataElement("kuandaifei").getString());
            dataForm.setChuzhuangfei(dataRow.getDataElement("chuzhuangfei").getString());
            dataForm.setYunyingshang(dataRow.getDataElement("yunyingshang").getString());
            dataForm.setBzygf(dataRow.getDataElement("bzygf").getString());
            dataForm.setNianfei(dataRow.getDataElement("nianfei").getString());
            dataForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
            dataForm.setZongshoufei(dataRow.getDataElement("zongshoufei").getString());
            dataForm.setShoujubenhao(dataRow.getDataElement("shoujubenhao").getString());
            dataForm.setQtsbsyqk(dataRow.getDataElement("qtsbsyqk").getString());
            dataForm.setQitahaocai(dataRow.getDataElement("qitahaocai").getString());
            dataForm.setJiexianzi(dataRow.getDataElement("jiexianzi").getString());
            dataForm.setRj11(isNull(dataRow.getDataElement("rj11")));
            dataForm.setRj45(isNull(dataRow.getDataElement("rj45")));
            dataForm.setMokuai(isNull(dataRow.getDataElement("mokuai")));
            dataForm.setMianban(isNull(dataRow.getDataElement("mianban")));
            dataForm.setWangxian(isNull(dataRow.getDataElement("wangxian")));
            dataForm.setShigongren(isNull(dataRow.getDataElement("shigongren")));
            dataForm.setXianchangbeizhu(isNull(dataRow.getDataElement("xianchangbeizhu")));
            dataForm.setBeizhuhuizong(isNull(dataRow.getDataElement("beizhuhuizong")));
            dataForm.setKaipiaoxinxi(isNull(dataRow.getDataElement("kaipiaoxinxi")));
            dataForm.setShebeixiaoshou(dataRow.getDataElement("shebeixiaoshou").getString());
            dataForm.setCailiaofei(dataRow.getDataElement("cailiaofei").getString());
            dataForm.setPipeizhuangtai(dataRow.getDataElement("pipeizhuangtai").getString());
            dataForm.setShoukuanshijian(dataRow.getDataElement("shoukuanshijian").getString());
            dataForm.setFenguangID(dataRow.getDataElement("fenguangID").getString());
            return mapping.findForward(FW_INIT_TUIDING2);
        }
    }

    /**
     * 处理退订
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward insertTuiding(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        savedInRequest(request);
        YonghuDataEntityForm dataForm = (YonghuDataEntityForm) form;
        DataRow dataRow = serviceData.getDataByUUID(dataForm.getUUID());
        String result = tuidingService.autoTuiding(dataForm, dataRow);


        CommonMessage message = new CommonMessage(result);
        if (saveMessage(message, request)) {
            return mapping.findForward( FW_INIT_TUIDING2);
        } else {
            return mapping.findForward(FW_SUCCESS);
        }
    }

    /**
     * 跳转到更新待缴费页面
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward initEditDaijiaofei(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        savedInRequest(request);
        JiaofeiDataFrom dataForm = (JiaofeiDataFrom) form;
        DataRow dataRow = serviceData.getDaijiaofeiDataByUUID(dataForm.getUUID());
        CommonMessage message = new CommonMessage("SUCCESS");
        if (saveMessage(message, request)) {
            return mapping.findForward(FW_SUCCESS);
        } else {
            String wangluo = dataRow.getDataElement("wangluo").getString();
            String dianshi = dataRow.getDataElement("dianshi").getString();
            String dianhua = dataRow.getDataElement("dianhua").getString();
            dataForm.setKaijishijian(dataRow.getDataElement("kaijishijian").getString());
            dataForm.setTingjishijian(dataRow.getDataElement("tingjishijian").getString());
            dataForm.setXiaoqu(dataRow.getDataElement("xiaoqu").getString());
            dataForm.setDizhi(dataRow.getDataElement("dizhi").getString());
            if (!wangluo.equals("0")) {
                dataForm.setZhongkuandai("网络");
            } else if (!dianshi.equals("0")) {
                dataForm.setZhongkuandai("电视");
            } else {
                dataForm.setZhongkuandai("电话");
            }
            dataForm.setWangluo(wangluo);
            dataForm.setDianshi(dianshi);
            dataForm.setDianhua(dianhua);
            dataForm.setYewu(dataRow.getDataElement("yewu").getString());
            dataForm.setOnuyj(dataRow.getDataElement("onuyj").getString());
            dataForm.setJidingheyj(dataRow.getDataElement("jidingheyj").getString());
            dataForm.setShoushifei(dataRow.getDataElement("shoushifei").getString());
            dataForm.setKuandaifei(dataRow.getDataElement("kuandaifei").getString());
            dataForm.setZongshoufei(dataRow.getDataElement("zongshoufei").getString());
            dataForm.setNianfei(dataRow.getDataElement("nianfei").getString());
            dataForm.setShoujubenhao(dataRow.getDataElement("shoujubenhao").getString());
            dataForm.setShigongren(isNull(dataRow.getDataElement("shigongren")));
            dataForm.setBeizhuhuizong(isNull(dataRow.getDataElement("beizhuhuizong")));
            dataForm.setShoukuanshijian(isNull(dataRow.getDataElement("shoukuanshijian")));
            dataForm.setKaipiaoxinxi(isNull(dataRow.getDataElement("kaipiaoxinxi")));
            dataForm.setNowdata(Common.getDate("yyyy-MM-dd HH:mm:ss"));
            dataForm.setUUID(dataForm.getUUID());
            dataForm.setYunyingshang(dataRow.getDataElement("yunyingshang").getString());// 20140923billy新增
            dataForm.setWeixiuleixing(isNull(dataRow.getDataElement("weixiuleixing")));// 20140923billy新增
            return mapping.findForward(FW_INIT_EDIT);
        }
    }

    public ActionForward initEditDaiweixiu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        savedInRequest(request);
        JiaofeiDataFrom dataForm = (JiaofeiDataFrom) form;
        List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
        dataForm.setXiaoquList(xiaoquList);
        DataRow dataRow = serviceData.getDaiweixiuDataByUUID(dataForm.getUUID());
        DataElement CPID = dataRow.getDataElement("CommunityPile_ID");
        DataElement CPID2 = dataRow.getDataElement("CommunityPile_ID2");
        DataRow cpboxdataRow = null;
        if (CPID.getString() != null && !"0".equals(CPID.getString())) {
            cpboxdataRow = serviceData.GetEBNBOXIDByUSERuuid(CPID.getString());
        }
        DataRow ebboxdataRow = null;
        if (CPID2.getString() != null && !"0".equals(CPID2.getString())) {
            ebboxdataRow = serviceData.GetEBNBOXIDByUSERuuid(CPID2.getString());
        }
        CommonMessage message = new CommonMessage("SUCCESS");
        if (saveMessage(message, request)) {
            return mapping.findForward(FW_SUCCESS);
        } else {
            dataForm.setWeixiushijian(dataRow.getDataElement("shoukuanshijian").getString());
            dataForm.setXiaoqu(dataRow.getDataElement("xiaoqu").getString());
            dataForm.setDizhi(dataRow.getDataElement("dizhi").getString());
            dataForm.setKuandaifei(dataRow.getDataElement("kuandaifei").getString());
            dataForm.setShoushifei(dataRow.getDataElement("shoushifei").getString());
            dataForm.setChuzhuangfei(dataRow.getDataElement("chuzhuangfei").getString());
            dataForm.setShebeixiaoshou(dataRow.getDataElement("shebeixiaoshou").getString());
            dataForm.setCailiaofei(dataRow.getDataElement("cailiaofei").getString());
            dataForm.setNianfei(dataRow.getDataElement("nianfei").getString());
            dataForm.setOnuyj(dataRow.getDataElement("onuyj").getString());
            dataForm.setJidingheyj(dataRow.getDataElement("jidingheyj").getString());
            dataForm.setZongshoufei(dataRow.getDataElement("zongshoufei").getString());
            dataForm.setWeixiuneirong(dataRow.getDataElement("yewu").getString());
            dataForm.setJiexianzi(dataRow.getDataElement("jiexianzi").getString());
            dataForm.setRj11(dataRow.getDataElement("rj11").getString());
            dataForm.setRj45(dataRow.getDataElement("rj45").getString());
            dataForm.setMokuai(dataRow.getDataElement("mokuai").getString());
            dataForm.setMianban(dataRow.getDataElement("mianban").getString());
            dataForm.setWangxian(dataRow.getDataElement("wangxian").getString());
            dataForm.setQitahaocai(dataRow.getDataElement("qitahaocai").getString());
            dataForm.setShoujubenhao(dataRow.getDataElement("shoujubenhao").getString());
            dataForm.setKaipiaoxinxi(dataRow.getDataElement("kaipiaoxinxi").getString());
            dataForm.setShigongren(isNull(dataRow.getDataElement("shigongren")));
            dataForm.setBeizhuhuizong(isNull(dataRow.getDataElement("beizhuhuizong")));
            dataForm.setFenguang(isNull(dataRow.getDataElement("fenguang")));
            dataForm.setOnumac(isNull(dataRow.getDataElement("onumac")));
            dataForm.setStbmcid(isNull(dataRow.getDataElement("stbmcid")));
            dataForm.setDianshiip(isNull(dataRow.getDataElement("dianshiip")));
            dataForm.setSelectCommunityPileID(dataRow.getDataElement("CommunityPile_ID").getString());
            dataForm.setSelectCommunityPileID2(dataRow.getDataElement("CommunityPile_ID2").getString());
            if (CPID.getString() != null && !"0".equals(CPID.getString())) {
                dataForm.setSelectCommunityPileID(CPID.getString());
                dataForm.setEqboxnum(isNull(cpboxdataRow.getDataElement("EqBoxNum")));
            }
            if (CPID2.getString() != null && !"0".equals(CPID2.getString())) {
                dataForm.setSelectCommunityPileID2(CPID2.getString());
                dataForm.setEqboxnum2(isNull(ebboxdataRow.getDataElement("EqBoxNum")));
            }
            dataForm.setNowdata(Common.getDate("yyyy-MM-dd HH:mm:ss"));
            dataForm.setUUID(dataForm.getUUID());
            dataForm.setWeixiuleixing(dataRow.getDataElement("weixiuleixing").getString());// 20140923billy新增
            dataForm.setYunyingshang(dataRow.getDataElement("yunyingshang").getString());// 20140923billy新增
            dataForm.setFenguangID(dataRow.getDataElement("fenguangID").getString());
            return mapping.findForward("init.editweixiu");
        }
    }

    /**
     * not use
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward initShebeiEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        savedInRequest(request);
        YonghuDataEntityForm dataForm = (YonghuDataEntityForm) form;
        DataRow dataRow = serviceData.getDataByUUID(dataForm.getUUID());
        CommonMessage message = xiugaicheck(dataRow.getDataElement("yonghuzhuangtai").getString());
        if (saveMessage(message, request)) {
            return mapping.findForward(FW_SUCCESS);
        } else {
            dataForm.setUUID(dataRow.getDataElement("PK_ID").getString());
            dataForm.setYonghuzhuangtai(dataRow.getDataElement("yonghuzhuangtai").getString());
            dataForm.setXingming(dataRow.getDataElement("xingming").getString());
            dataForm.setShenfensheng(dataRow.getDataElement("shenfensheng").getString());
            dataForm.setShoujuhao(dataRow.getDataElement("shoujuhao").getString());
            dataForm.setFenguangxianhao(dataRow.getDataElement("fenguangxianhao").getString());
            dataForm.setJiexuweizhi(dataRow.getDataElement("jiexuweizhi").getString());
            dataForm.setKaijishijian(dataRow.getDataElement("kaijishijian").getString());
            dataForm.setTingjishijian(dataRow.getDataElement("tingjishijian").getString());
            dataForm.setXiaoqu(dataRow.getDataElement("xiaoqu").getString());
            dataForm.setDizhi(dataRow.getDataElement("dizhi").getString());
            dataForm.setLianxidianhua(dataRow.getDataElement("lianxidianhua").getString());
            dataForm.setWangluo(dataRow.getDataElement("wangluo").getString());
            dataForm.setDianshi(dataRow.getDataElement("dianshi").getString());
            dataForm.setDianhua(dataRow.getDataElement("dianhua").getString());
            dataForm.setYewu(dataRow.getDataElement("yewu").getString());
            dataForm.setFenguang(dataRow.getDataElement("fenguang").getString());
            dataForm.setOnumac(dataRow.getDataElement("onumac").getString());
            dataForm.setStbmcid(dataRow.getDataElement("stbmcid").getString());
            dataForm.setDianshiip(dataRow.getDataElement("dianshiip").getString());
            dataForm.setWangluoip(dataRow.getDataElement("wangluoip").getString());
            dataForm.setDianhuaip(dataRow.getDataElement("dianhuaip").getString());
            dataForm.setDianhuavlan(dataRow.getDataElement("dianhuavlan").getString());
            dataForm.setWangluovlan(dataRow.getDataElement("wangluovlan").getString());
            dataForm.setShangmenshijian(dataRow.getDataElement("shangmenshijian").getString());
            dataForm.setDanzheng(dataRow.getDataElement("danzheng").getString());
            dataForm.setSxdhhm(dataRow.getDataElement("sxdhhm").getString());
            dataForm.setOnuyj(dataRow.getDataElement("onuyj").getString());
            dataForm.setJidingheyj(dataRow.getDataElement("jidingheyj").getString());
            dataForm.setShoushifei(dataRow.getDataElement("shoushifei").getString());
            dataForm.setKuandaifei(dataRow.getDataElement("kuandaifei").getString());
            dataForm.setChuzhuangfei(dataRow.getDataElement("chuzhuangfei").getString());
            dataForm.setYunyingshang(dataRow.getDataElement("yunyingshang").getString());
            dataForm.setBzygf(dataRow.getDataElement("bzygf").getString());
            dataForm.setNianfei(dataRow.getDataElement("nianfei").getString());
            dataForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
            dataForm.setZongshoufei(dataRow.getDataElement("zongshoufei").getString());
            dataForm.setShoujubenhao(dataRow.getDataElement("shoujubenhao").getString());
            dataForm.setQtsbsyqk(dataRow.getDataElement("qtsbsyqk").getString());
            dataForm.setQitahaocai(dataRow.getDataElement("qitahaocai").getString());
            dataForm.setJiexianzi(dataRow.getDataElement("jiexianzi").getString());
            dataForm.setRj11(isNull(dataRow.getDataElement("rj11")));
            dataForm.setRj45(isNull(dataRow.getDataElement("rj45")));
            dataForm.setMokuai(isNull(dataRow.getDataElement("mokuai")));
            dataForm.setMianban(isNull(dataRow.getDataElement("mianban")));
            dataForm.setWangxian(isNull(dataRow.getDataElement("wangxian")));
            dataForm.setShigongren(isNull(dataRow.getDataElement("shigongren")));
            dataForm.setXianchangbeizhu(isNull(dataRow.getDataElement("xianchangbeizhu")));
            dataForm.setBeizhuhuizong(isNull(dataRow.getDataElement("beizhuhuizong")));

            return mapping.findForward("shebei");
        }
    }

    /**
     * Display checked user info.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward showInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        savedInRequest(request);
        savedInRequest(request);
        YonghuDataEntityForm dataForm = (YonghuDataEntityForm) form;
        DataRow dataRow = serviceData.getDataByUUID(dataForm.getUUID());

        dataForm.setUUID(dataRow.getDataElement("PK_ID").getString());
        dataForm.setYonghuzhuangtai(dataRow.getDataElement("yonghuzhuangtai").getString());
        dataForm.setXingming(dataRow.getDataElement("xingming").getString());
        dataForm.setShenfensheng(dataRow.getDataElement("shenfensheng").getString());
        dataForm.setShoujuhao(dataRow.getDataElement("shoujuhao").getString());
        dataForm.setFenguangxianhao(dataRow.getDataElement("fenguangxianhao").getString());
        dataForm.setJiexuweizhi(dataRow.getDataElement("jiexuweizhi").getString());
        dataForm.setKaijishijian(dataRow.getDataElement("kaijishijian").getString());
        dataForm.setTingjishijian(dataRow.getDataElement("tingjishijian").getString());
        dataForm.setXiaoqu(dataRow.getDataElement("xiaoqu").getString());
        dataForm.setDizhi(dataRow.getDataElement("dizhi").getString());
        dataForm.setLianxidianhua(dataRow.getDataElement("lianxidianhua").getString());
        dataForm.setWangluo(dataRow.getDataElement("wangluo").getString());
        dataForm.setDianshi(dataRow.getDataElement("dianshi").getString());
        dataForm.setDianhua(dataRow.getDataElement("dianhua").getString());
        dataForm.setYewu(dataRow.getDataElement("yewu").getString());
        dataForm.setFenguang(dataRow.getDataElement("fenguang").getString());
        dataForm.setOnumac(dataRow.getDataElement("onumac").getString());
        dataForm.setStbmcid(dataRow.getDataElement("stbmcid").getString());
        dataForm.setDianshiip(dataRow.getDataElement("dianshiip").getString());
        dataForm.setWangluoip(dataRow.getDataElement("wangluoip").getString());
        dataForm.setDianhuaip(dataRow.getDataElement("dianhuaip").getString());
        dataForm.setDianhuavlan(dataRow.getDataElement("dianhuavlan").getString());
        dataForm.setWangluovlan(dataRow.getDataElement("wangluovlan").getString());
        dataForm.setShangmenshijian(dataRow.getDataElement("shangmenshijian").getString());
        dataForm.setDanzheng(dataRow.getDataElement("danzheng").getString());
        dataForm.setSxdhhm(dataRow.getDataElement("sxdhhm").getString());
        dataForm.setOnuyj(dataRow.getDataElement("onuyj").getString());
        dataForm.setJidingheyj(dataRow.getDataElement("jidingheyj").getString());
        dataForm.setShoushifei(dataRow.getDataElement("shoushifei").getString());
        dataForm.setKuandaifei(dataRow.getDataElement("kuandaifei").getString());
        dataForm.setChuzhuangfei(dataRow.getDataElement("chuzhuangfei").getString());
        dataForm.setYunyingshang(dataRow.getDataElement("yunyingshang").getString());
        dataForm.setBzygf(dataRow.getDataElement("bzygf").getString());
        dataForm.setNianfei(dataRow.getDataElement("nianfei").getString());
        dataForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
        dataForm.setZongshoufei(dataRow.getDataElement("zongshoufei").getString());
        dataForm.setShoujubenhao(dataRow.getDataElement("shoujubenhao").getString());
        dataForm.setQtsbsyqk(dataRow.getDataElement("qtsbsyqk").getString());
        dataForm.setQitahaocai(dataRow.getDataElement("qitahaocai").getString());
        dataForm.setJiexianzi(dataRow.getDataElement("jiexianzi").getString());
        dataForm.setRj11(isNull(dataRow.getDataElement("rj11")));
        dataForm.setRj45(isNull(dataRow.getDataElement("rj45")));
        dataForm.setMokuai(isNull(dataRow.getDataElement("mokuai")));
        dataForm.setMianban(isNull(dataRow.getDataElement("mianban")));
        dataForm.setWangxian(isNull(dataRow.getDataElement("wangxian")));
        dataForm.setShigongren(isNull(dataRow.getDataElement("shigongren")));
        dataForm.setXianchangbeizhu(isNull(dataRow.getDataElement("xianchangbeizhu")));
        dataForm.setBeizhuhuizong(isNull(dataRow.getDataElement("beizhuhuizong")));
        dataForm.setKaipiaoxinxi(isNull(dataRow.getDataElement("kaipiaoxinxi")));
        dataForm.setShebeixiaoshou(dataRow.getDataElement("shebeixiaoshou").getString());
        dataForm.setCailiaofei(dataRow.getDataElement("cailiaofei").getString());
        dataForm.setPipeizhuangtai(dataRow.getDataElement("pipeizhuangtai").getString());
        dataForm.setShoukuanshijian(dataRow.getDataElement("shoukuanshijian").getString());

        return mapping.findForward("showinfo");
    }

    /**
     * 跳转到添加申请页面 续费维修管理----申请续费----申请续费按钮之后页面
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward initInsert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
        List<CommonModule> shichangList = service2.getShichangAll();
        List<CommonModule> shichangtvList = service2.getShichangtvAll();
        // List<CommonModule> wangluoList = service2.getRadiusWangluo();
        JiaofeiDataFrom f = (JiaofeiDataFrom) form;
        if (f.getNowdata() == null || f.getNowdata().equals("")) {
            f.setNowdata(Common.getDate("yyyy-MM-dd HH:mm:ss"));
        }
        if (f.getShoukuanshijian() == null || f.getShoukuanshijian().equals("")) {
            f.setShoukuanshijian(Common.getDate("yyyy-MM-dd"));
        }
        f.setXiaoquList(xiaoquList);
        f.setShichangList(shichangList);
        f.setShichangtvList(shichangtvList);
        return mapping.findForward(FW_INIT_INSERT);
    }

    /**
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward initChangePwd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
        List<CommonModule> shichangList = service2.getShichangAll();
        List<CommonModule> shichangtvList = service2.getShichangtvAll();
        // List<CommonModule> wangluoList = service2.getRadiusWangluo();
        JiaofeiDataFrom f = (JiaofeiDataFrom) form;
        if (f.getNowdata() == null || f.getNowdata().equals("")) {
            f.setNowdata(Common.getDate("yyyy-MM-dd HH:mm:ss"));
        }
        if (f.getShoukuanshijian() == null || f.getShoukuanshijian().equals("")) {
            f.setShoukuanshijian(Common.getDate("yyyy-MM-dd"));
        }
        f.setXiaoquList(xiaoquList);
        f.setShichangList(shichangList);
        f.setShichangtvList(shichangtvList);
        return mapping.findForward(FW_INIT_CHANGEPWD);
    }

    /**
     * create by 赵兴华 2015-01-21
     * 退订业务
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward initTuiDing(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
        List<CommonModule> shichangList = service2.getShichangAll();
        List<CommonModule> shichangtvList = service2.getShichangtvAll();
        // List<CommonModule> wangluoList = service2.getRadiusWangluo();
        JiaofeiDataFrom f = (JiaofeiDataFrom) form;
        if (f.getNowdata() == null || f.getNowdata().equals("")) {
            f.setNowdata(Common.getDate("yyyy-MM-dd HH:mm:ss"));
        }
        if (f.getShoukuanshijian() == null || f.getShoukuanshijian().equals("")) {
            f.setShoukuanshijian(Common.getDate("yyyy-MM-dd"));
        }
        f.setXiaoquList(xiaoquList);
        f.setShichangList(shichangList);
        f.setShichangtvList(shichangtvList);
        return mapping.findForward(FW_INIT_TUIDING);
    }

    public ActionForward changekdf(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer value = new StringBuffer();
        String string = "";
        String shichang = request.getParameter("shichang");
        shichang = java.net.URLDecoder.decode(shichang, "utf-8");
        DataSet<DataRow> executeQuery = service2.changekdf(shichang);
        for (int i = 0; i < executeQuery.size(); i++) {
            string += executeQuery.get(i).getDataElement("jine").getString() + "|";
        }
        if (string.length() > 1) {
            string = string.substring(0, string.length() - 1);
        }
        value.append(string);
        String valueStr0 = value.toString();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().print(valueStr0);
        return mapping.findForward("null");
    }

    public ActionForward changetvf(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer value = new StringBuffer();
        String string = "";
        String shichangtv = request.getParameter("shichangtv");
        shichangtv = java.net.URLDecoder.decode(shichangtv, "utf-8");
        DataSet<DataRow> executeQuery = service2.changetvf(shichangtv);
        for (int i = 0; i < executeQuery.size(); i++) {
            string += executeQuery.get(i).getDataElement("jine").getString() + "|";
        }
        if (string.length() > 1) {
            string = string.substring(0, string.length() - 1);
        }
        value.append(string);
        String valueStr0 = value.toString();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().print(valueStr0);
        return mapping.findForward("null");
    }

    public ActionForward changekdlx(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer value = new StringBuffer();
        String string = "";
        String shichang = request.getParameter("shichang");
        shichang = java.net.URLDecoder.decode(shichang, "utf-8");
        DataSet<DataRow> executeQuery = service2.changekdlx(shichang);
        for (int i = 0; i < executeQuery.size(); i++) {
            string += executeQuery.get(i).getDataElement("daikuan").getString() + "|";
        }
        if (string.length() > 1) {
            string = string.substring(0, string.length() - 1);
        }
        value.append(string);
        String valueStr0 = value.toString();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().print(valueStr0);
        return mapping.findForward("null");
    }

    public ActionForward changetvlx(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer value = new StringBuffer();
        String string = "";
        String shichangtv = request.getParameter("shichangtv");
        shichangtv = java.net.URLDecoder.decode(shichangtv, "utf-8");
        DataSet<DataRow> executeQuery = service2.changetvlx(shichangtv);
        for (int i = 0; i < executeQuery.size(); i++) {
            string += executeQuery.get(i).getDataElement("shichanglx").getString() + "|";
        }
        if (string.length() > 1) {
            string = string.substring(0, string.length() - 1);
        }
        value.append(string);
        String valueStr0 = value.toString();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().print(valueStr0);
        return mapping.findForward("null");
    }

    public ActionForward changekdsj(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer value = new StringBuffer();
        String string = "";
        String shichangkd = request.getParameter("shichang");
        shichangkd = java.net.URLDecoder.decode(shichangkd, "utf-8");
        DataSet<DataRow> executeQuery = service2.changekdsj(shichangkd);
        for (int i = 0; i < executeQuery.size(); i++) {
            string += executeQuery.get(i).getDataElement("shichangsj").getString() + "|";
        }
        if (string.length() > 1) {
            string = string.substring(0, string.length() - 1);
        }
        value.append(string);
        String valueStr0 = value.toString();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().print(valueStr0);
        return mapping.findForward("null");
    }

    public ActionForward changetvsj(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer value = new StringBuffer();
        String string = "";
        String shichangtv = request.getParameter("shichangtv");
        shichangtv = java.net.URLDecoder.decode(shichangtv, "utf-8");
        DataSet<DataRow> executeQuery = service2.changetvsj(shichangtv);
        for (int i = 0; i < executeQuery.size(); i++) {
            string += executeQuery.get(i).getDataElement("shichangsj").getString() + "|";
        }
        if (string.length() > 1) {
            string = string.substring(0, string.length() - 1);
        }
        value.append(string);
        String valueStr0 = value.toString();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().print(valueStr0);
        return mapping.findForward("null");
    }

    public ActionForward changetjsj(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer value = new StringBuffer();
        String string = "";
        if (request.getParameter("yewushijian") != null && !request.getParameter("yewushijian").equals("")) {
            Integer yewushijian = Integer.parseInt(request.getParameter("yewushijian"));
            Integer beisuu = Integer.parseInt(request.getParameter("beishu"));
            yewushijian = yewushijian * beisuu;
            String kaijishijian = request.getParameter("kaijishijian");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = sdf.parse(kaijishijian);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.MONTH, yewushijian);
            rightNow.add(Calendar.DAY_OF_YEAR, -1);
            Date dt1 = rightNow.getTime();
            string = sdf.format(dt1);
        }
        value.append(string);
        String valueStr0 = value.toString();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().print(valueStr0);
        return mapping.findForward("null");
    }

    public ActionForward initInsertWeixiu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();

        JiaofeiDataFrom f = (JiaofeiDataFrom) form;
        if (f.getNowdata() == null || f.getNowdata().equals("")) {
            f.setNowdata(Common.getDate("yyyy-MM-dd HH:mm:ss"));
        }
        f.setXiaoquList(xiaoquList);
        return mapping.findForward("init.insertweixiu");
    }

    public ActionForward insertDaiJiaofei(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImportDataService serviceData = new ImportDataService();
        String countNum = request.getParameter("countNum");
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

        DataSet<DataRow> executeQuery = dao.executeQuery("findCounNum", set);
        String stringyouxiao = "";
        for (int i = 0; i < executeQuery.size(); i++) {
            DataRow obj = executeQuery.get(i);
            String wangluoip = obj.getDataElement("wangluoip").getString();
            String dianshiip = obj.getDataElement("dianhuaip").getString();
            String wangluo = obj.getDataElement("wangluo").getString();
            String dianshi = obj.getDataElement("dianshi").getString();
            String youxiaoshijian = obj.getDataElement("youxiaoshijian").getString();
            Date youxiaodate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(youxiaoshijian);
            stringyouxiao = new SimpleDateFormat("yyyy-MM-dd").format(youxiaodate);
            if (countNum.equals(wangluoip) && (!"".equals(jfForm.getWangluo()) && !"0".equals(jfForm.getWangluo()) && null != jfForm.getWangluo())) {
                stringyouxiao = wangluo + "," + stringyouxiao + "/";
            } else if (countNum.equals(dianshiip) && (!"".equals(jfForm.getDianshi()) && !"0".equals(jfForm.getDianshi()) && null != jfForm.getDianshi())) {
                stringyouxiao = dianshi + "," + stringyouxiao + "/";
            }
        }

        jfForm.setYewu(stringyouxiao + jfForm.getYewu());
        if (!"".equals(jfForm.getDianshi()) && !"0".equals(jfForm.getDianshi()) && null != jfForm.getDianshi()) {
            jfForm.setDianhuaip(countNum);
        } else if (!"".equals(jfForm.getWangluo()) && !"0".equals(jfForm.getWangluo()) && null != jfForm.getWangluo()) {
            jfForm.setWangluoip(countNum);
        }

        String result = serviceData.insertDaijiaofei((JiaofeiDataFrom) form);
        if (saveMessage(result, request)) {
            List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
            JiaofeiDataFrom f = (JiaofeiDataFrom) form;
            f.setXiaoquList(xiaoquList);
            return mapping.findForward(FW_ERROR_INSERT);
        }
        return mapping.findForward(FW_SUCCESS);
    }

    /**
     * 插入待修改密码的数据
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward insertChangePwd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImportDataService serviceData = new ImportDataService();
        String countNum = request.getParameter("countNum");
        countNum = java.net.URLDecoder.decode(countNum, "utf-8");
        JiaofeiDataFrom jfForm = (JiaofeiDataFrom) form;
        if (!"".equals(jfForm.getDianshi()) && !"0".equals(jfForm.getDianshi()) && null != jfForm.getDianshi()) {
            jfForm.setDianhuaip(countNum);
        } else if (!"".equals(jfForm.getWangluo()) && !"0".equals(jfForm.getWangluo()) && null != jfForm.getWangluo()) {
            jfForm.setWangluoip(countNum);
        }

        String caozuo = "待修改";
        String result = serviceData.insertOperate((JiaofeiDataFrom) form, caozuo);
        if (saveMessage(result, request)) {
            List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
            JiaofeiDataFrom f = (JiaofeiDataFrom) form;
            f.setXiaoquList(xiaoquList);
            return mapping.findForward(FW_ERROR_INSERT);
        }
        return mapping.findForward("operateSuccess");
    }


    /**
     * create by 赵兴华 2015-01-21
     * 退订业务
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward insertTuiDing(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImportDataService serviceData = new ImportDataService();
        String countNum = request.getParameter("countNum");
        countNum = java.net.URLDecoder.decode(countNum, "utf-8");
        JiaofeiDataFrom jfForm = (JiaofeiDataFrom) form;
        if (!"".equals(jfForm.getDianshi()) && !"0".equals(jfForm.getDianshi()) && null != jfForm.getDianshi()) {
            jfForm.setDianhuaip(countNum);
        } else if (!"".equals(jfForm.getWangluo()) && !"0".equals(jfForm.getWangluo()) && null != jfForm.getWangluo()) {
            jfForm.setWangluoip(countNum);
        }

        String caozuo = "待退订";
        String result = serviceData.insertOperate((JiaofeiDataFrom) form, caozuo);
        if (saveMessage(result, request)) {
            List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
            JiaofeiDataFrom f = (JiaofeiDataFrom) form;
            f.setXiaoquList(xiaoquList);
            return mapping.findForward(FW_ERROR_INSERT);
        }
        return mapping.findForward("operateSuccess");
    }

    public ActionForward insertDaiweixiu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImportDataService serviceDatai = new ImportDataService();
        JiaofeiDataFrom dataForm = (JiaofeiDataFrom) form;
        if (!"".equals(dataForm.getSelectCommunityPileID()) && !"0".equals(dataForm.getSelectCommunityPileID())) {
            DataRow cpjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID());
            String cpjti = cpjtidataRow.getDataElement("EqSta_ID").getString();
            if (!"2".equals(cpjti)) {
                CommonMessage commonMessage = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "设备挑选失败，请确认设备状态！");
                if (saveMessage(commonMessage, request)) {
                    savedInRequest(request);
                    return mapping.findForward(FW_ERROR_INSERT);
                }
            } else {
                kucunService.zhuangTaiChange(dataForm.getSelectCommunityPileID(), "4", dataForm.getXiaoqu(), "维修用", dataForm.getDizhi(), dataForm.getWeixiushijian());
            }
        }
        if (!"".equals(dataForm.getSelectCommunityPileID2()) && !"0".equals(dataForm.getSelectCommunityPileID2())) {
            DataRow cpboxjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID2());
            String cpboxjti = cpboxjtidataRow.getDataElement("EqSta_ID").getString();
            if (!"2".equals(cpboxjti)) {
                CommonMessage commonMessage = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "设备挑选失败，请确认设备状态！");
                if (saveMessage(commonMessage, request)) {
                    savedInRequest(request);
                    return mapping.findForward(FW_ERROR_INSERT);
                }
            } else {
                kucunService.zhuangTaiChange(dataForm.getSelectCommunityPileID2(), "4", dataForm.getXiaoqu(), "维修用", dataForm.getDizhi(), dataForm.getWeixiushijian());
            }
        }
        String result = serviceDatai.insertDaiweixiu((JiaofeiDataFrom) form);
        if (saveMessage(result, request)) {
            List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
            JiaofeiDataFrom f = (JiaofeiDataFrom) form;
            f.setXiaoquList(xiaoquList);
            return mapping.findForward(FW_ERROR_INSERT);
        }
        return mapping.findForward("success3");
    }

    public ActionForward updateDaiJiaofei(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImportDataService serviceData = new ImportDataService();
        String result = serviceData.updateDaijiaofei((JiaofeiDataFrom) form);
        if (saveMessage(result, request)) {
            List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
            JiaofeiDataFrom f = (JiaofeiDataFrom) form;
            f.setXiaoquList(xiaoquList);
            return mapping.findForward(FW_ERROR_INSERT);
        }
        return mapping.findForward("success1");
    }

    public ActionForward updateDaiWeixiu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ImportDataService serviceData2 = new ImportDataService();
        JiaofeiDataFrom dataForm = (JiaofeiDataFrom) form;
        if (!"".equals(dataForm.getSelectCommunityPileID()) && !"0".equals(dataForm.getSelectCommunityPileID())) {
            DataRow cpjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID());
            String cpjti = cpjtidataRow.getDataElement("EqSta_ID").getString();
            if (!dataForm.getSelectCommunityPileID().equals(dataForm.getOldCPID())) {
                if (!"2".equals(cpjti)) {
                    CommonMessage commonMessage = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "设备挑选失败，请确认设备状态！");
                    if (saveMessage(commonMessage, request)) {
                        savedInRequest(request);
                        return mapping.findForward(FW_ERROR_INSERT);
                    }
                } else {
                    kucunService.zhuangTaiChange(dataForm.getSelectCommunityPileID(), "4", dataForm.getXiaoqu(), "维修用", dataForm.getDizhi(), dataForm.getWeixiushijian());
                }
            }
        }
        if (!"".equals(dataForm.getSelectCommunityPileID2()) && !"0".equals(dataForm.getSelectCommunityPileID2())) {
            DataRow cpboxjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID2());
            String cpboxjti = cpboxjtidataRow.getDataElement("EqSta_ID").getString();
            if (!dataForm.getSelectCommunityPileID2().equals(dataForm.getOldCPID2())) {
                if (!"2".equals(cpboxjti)) {
                    CommonMessage commonMessage = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "设备挑选失败，请确认设备状态！");
                    if (saveMessage(commonMessage, request)) {
                        savedInRequest(request);
                        return mapping.findForward(FW_ERROR_INSERT);
                    }
                } else {
                    kucunService.zhuangTaiChange(dataForm.getSelectCommunityPileID2(), "4", dataForm.getXiaoqu(), "维修用", dataForm.getDizhi(), dataForm.getWeixiushijian());
                }
            }
        }
        String result = serviceData2.updateDaiweixiu((JiaofeiDataFrom) form);
        if (saveMessage(result, request)) {
            List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
            JiaofeiDataFrom f = (JiaofeiDataFrom) form;
            f.setXiaoquList(xiaoquList);
            return mapping.findForward("success2");
        }
        return mapping.findForward("success2");
    }

    /**
     * Update checked user information.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward updateData(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = serviceData.updateData((YonghuDataEntityForm) form);

        if (saveMessage(result, request)) {
            savedInRequest(request);
            return mapping.findForward(FW_ERROR_EDIT);
        }

        return mapping.findForward(FW_SUCCESS);
    }

    /**
     * not user.
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward updateShebeiData(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = serviceData.updateShebeiData((YonghuDataEntityForm) form);

        if (saveMessage(result, request)) {
            savedInRequest(request);
            return mapping.findForward(FW_ERROR_EDIT);
        }

        return mapping.findForward(FW_SUCCESS);
    }

    /**
     * 校验
     *
     * @param
     * @return
     * @throws Exception
     */
    public CommonMessage xiugaicheck(String state) throws Exception {
        if (state.equals("已维修")) {
            return new CommonMessage(ErrorConstant.EDIT_STATE_ERROR);
        } else {
            return new CommonMessage("SUCCESS");
        }

    }

    private String isNull(DataElement obj) {
        String returnVal = "";
        if (obj == null || obj.getString() == null || obj.getString().trim() == "" || obj.getString().trim().equals("")) {
            returnVal = "";
        } else {
            returnVal = obj.getString();
        }

        return returnVal;
    }

    /*****
     * 一览界面点击分光回收使用按钮执行action
     *****/
    public ActionForward pipeipgd(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JiaofeiDataFrom fenguangform = (JiaofeiDataFrom) form;
        String[] uuids = fenguangform.getUUIDS();
        StringBuffer wrongdata = new StringBuffer();
        for (int i = 0; i < uuids.length; i++) {
            DataRow dataRow = serviceData.getDataByUUID(uuids[i]);
            // 取得所选派工单的当前分光信息
            String currentFenguang = dataRow.getDataElement("fenguang").getString();
            //取得所选派工单的小区
            String xiaoqu = dataRow.getDataElement("xiaoqu").getString();
            //取得所选派工单的地址
            String dizhi = dataRow.getDataElement("dizhi").getString();
            //只对当前分光是非空非0的进行操作
            if (currentFenguang == null || "".equals(currentFenguang) || "　".equals(currentFenguang) || "0".equals(currentFenguang)) {
                String fenguangID = fgservice.pipeipgd(xiaoqu, dizhi, request);
                if (fenguangID.contains("@")) {
                    //更新当前派工单信息
                    fgservice.updatewxfenguang(uuids[i], fenguangID.split("@")[0], fenguangID.split("@")[1]);
                } else {
                    //没有获取到派工单信息吗，记录小区和地址
                    if ("NOGUIZE".equals(fenguangID)) {
                        wrongdata.append(xiaoqu + dizhi + "没有分光分配规则</br>");
                    } else {
                        wrongdata.append(xiaoqu + dizhi + "没有可用的分光</br>");
                    }
                }
            } else {
                wrongdata.append(xiaoqu + dizhi + "已存在分光，请回收后重新分配。</br>");
            }

            //service.updateMask(uuids[i],request, "0");
        }
        CommonMessage message = null;
        if (wrongdata.length() == 0) {
            message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "分光分配成功！");
        } else {
            message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, wrongdata.toString());
        }
        saveMessage(message, request);
        return mapping.findForward("success2");
    }

    /*****
     * 一览界面点击分光回收使用按钮执行action
     *****/
    public ActionForward recyclepgd(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JiaofeiDataFrom fenguangform = (JiaofeiDataFrom) form;
        String[] uuids = fenguangform.getUUIDS();
        for (int i = 0; i < uuids.length; i++) {
            DataRow dataRow = serviceData.getDataByUUID(uuids[i]);
            // 取得所选派工单的当前分光信息
            String currentFenguang = dataRow.getDataElement("fenguangID").getString();
            if (currentFenguang != null) {
                fgservice.recyclefenguang(currentFenguang, request);
            }
            fgservice.updatewxfenguang(uuids[i], "", "");
        }
        CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "分光回收成功！");
        saveMessage(message, request);
        return mapping.findForward("success2");
    }

    public ActionForward getKuandai(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String xiaoqu = request.getParameter("xiaoqu");
        String idkbn = request.getParameter("idkbn");
        String allkbn = request.getParameter("allkbn");
        xiaoqu = URLDecoder.decode(xiaoqu, "utf-8");
        List<DataRow> dataRow = null;
        if ("true".equals(allkbn)) {
            dataRow = serviceData.getAllKuandaiByXiaoqu(xiaoqu);
        } else {
            dataRow = serviceData.getKuandaiByXiaoqu(xiaoqu);
        }
        StringBuffer value = new StringBuffer();
        for (int i = 0; i < dataRow.size(); i++) {
            if ("true".equals(idkbn)) {
                value.append(dataRow.get(i).getDataElement("id").getString());
                value.append(":");
            }
            value.append(dataRow.get(i).getDataElement("shichangName").getString());
            value.append("|");
        }
        String valueStr0 = value.toString();
        if (value.length() > 1) {
            valueStr0 = value.substring(0, value.length() - 1);
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().print(valueStr0);
        return mapping.findForward("null");
    }

    public ActionForward getDianshi(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String xiaoqu = request.getParameter("xiaoqu");
        String idkbn = request.getParameter("idkbn");
        String allkbn = request.getParameter("allkbn");
        xiaoqu = URLDecoder.decode(xiaoqu, "utf-8");
        List<DataRow> dataRow = null;
        if ("true".equals(allkbn)) {
            dataRow = serviceData.getAllDianshiByXiaoqu(xiaoqu);
        } else {
            dataRow = serviceData.getDianshiByXiaoqu(xiaoqu);
        }
        StringBuffer value = new StringBuffer();
        for (int i = 0; i < dataRow.size(); i++) {
            if ("true".equals(idkbn)) {
                value.append(dataRow.get(i).getDataElement("id").getString());
                value.append(":");
            }
            value.append(dataRow.get(i).getDataElement("shichangName").getString());
            value.append("|");
        }
        String valueStr0 = value.toString();
        if (value.length() > 1) {
            valueStr0 = value.substring(0, value.length() - 1);
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().print(valueStr0);
        return mapping.findForward("null");
    }
}
