package com.stock.yonghushuju;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;

/**
 * @author 
 * @version 创建时间：2012-6-13 下午04:38:43 类说明
 */
public class WeixiuDataEditAction extends BusinessAction {
	PaiGongDanService  service = new PaiGongDanService();
	YonghuDataService serviceData = new YonghuDataService();

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
	public ActionForward initEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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

			return mapping.findForward(FW_INIT_EDIT);
		}
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
	public ActionForward initShebeiEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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
	 * 查看详情
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		savedInRequest(request);
		savedInRequest(request);
		YonghuDataEntityForm dataForm = (YonghuDataEntityForm) form;
		DataRow dataRow = serviceData.getDataByUUID(dataForm.getUUID());

		dataForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		dataForm.setYonghuzhuangtai(dataRow.getDataElement("yonghuzhuangtai").getString());
		dataForm.setPipeizhuangtai(dataRow.getDataElement("pipeizhuangtai").getString());
		dataForm.setShoukuanshijian(dataRow.getDataElement("shoukuanshijian").getString());
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
		dataForm.setShebeixiaoshou(dataRow.getDataElement("shebeixiaoshou").getString());
		dataForm.setCailiaofei(dataRow.getDataElement("cailiaofei").getString());
		dataForm.setYunyingshang(dataRow.getDataElement("yunyingshang").getString());
		dataForm.setBzygf(dataRow.getDataElement("bzygf").getString());
		dataForm.setNianfei(dataRow.getDataElement("nianfei").getString());
		dataForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
		dataForm.setZongshoufei(dataRow.getDataElement("zongshoufei").getString());
		dataForm.setShoujubenhao(dataRow.getDataElement("shoujubenhao").getString());
		dataForm.setKaipiaoxinxi(dataRow.getDataElement("kaipiaoxinxi").getString());
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

		return mapping.findForward("showinfo");
	}

	/**
	 * 更新
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result = serviceData.updateData((YonghuDataEntityForm) form);
		
		if (saveMessage(result, request)) {
			savedInRequest(request);
			return mapping.findForward(FW_ERROR_EDIT);
		}
		
		return mapping.findForward(FW_SUCCESS);
	}

	/**
	 * 更新
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateShebeiData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result = serviceData.updateData((YonghuDataEntityForm) form);
		
		if (saveMessage(result, request)) {
			savedInRequest(request);
			return mapping.findForward(FW_ERROR_EDIT);
		}
		
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 校验
	 * 
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public CommonMessage xiugaicheck(String state) throws Exception {
		if (!state.equals("已维修")) {
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
}
