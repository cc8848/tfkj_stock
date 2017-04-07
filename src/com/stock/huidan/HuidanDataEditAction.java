package com.stock.huidan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.frame.sql.DataRow;

public class HuidanDataEditAction extends BusinessAction{
	HuidanDataService serviceData = new HuidanDataService();
	
	
	public ActionForward showInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanEntityForm dataForm = (HuidanEntityForm)form;
		dataForm.setZhuangtaiHidden(dataForm.getZhuangtai());
		DataRow dataRow = serviceData.getDataByUUID(dataForm.getUUID());

		dataForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		dataForm.setYonghuzhuangtai(isNull(dataRow.getDataElement("yonghuzhuangtai").getString()));
		dataForm.setXingming(isNull(dataRow.getDataElement("xingming").getString()));
		dataForm.setShenfenzheng(isNull(dataRow.getDataElement("shenfenzheng").getString()));
		dataForm.setShoujuhao(isNull(dataRow.getDataElement("shoujuhao").getString()));
		dataForm.setFenguanxianhao(isNull(dataRow.getDataElement("fenguangxianhao").getString()));
		dataForm.setJiexuweizhi(isNull(dataRow.getDataElement("jiexuweizhi").getString()));
		dataForm.setKaijishijian(isNull(dataRow.getDataElement("kaijishijian").getString()));
		dataForm.setTingjishijian(isNull(dataRow.getDataElement("tingjishijian").getString()));
		dataForm.setXiaoqu(isNull(dataRow.getDataElement("xiaoqu").getString()));
		dataForm.setDizhi(isNull(dataRow.getDataElement("dizhi").getString()));
		dataForm.setLianxidianhua(isNull(dataRow.getDataElement("lianxidianhua").getString()));
		dataForm.setWangluo(isNull(dataRow.getDataElement("wangluo").getString()));
		dataForm.setDianshi(isNull(dataRow.getDataElement("dianshi").getString()));
		dataForm.setDianhua(isNull(dataRow.getDataElement("dianhua").getString()));
		dataForm.setYewu(isNull(dataRow.getDataElement("yewu").getString()));
		dataForm.setFenguang(isNull(dataRow.getDataElement("fenguang").getString()));
		dataForm.setOnuMAC(isNull(dataRow.getDataElement("onumac").getString()));
		dataForm.setSTB_MCID(isNull(dataRow.getDataElement("stbmcid").getString()));
		dataForm.setDianshiIP(isNull(dataRow.getDataElement("dianshiip").getString()));
		dataForm.setWangluoIP(isNull(dataRow.getDataElement("wangluoip").getString()));
		dataForm.setDianhuaIP(isNull(dataRow.getDataElement("dianhuaip").getString()));
		dataForm.setDianhuaVLAN(isNull(dataRow.getDataElement("dianhuavlan").getString()));
		dataForm.setWangluoVLAN(isNull(dataRow.getDataElement("wangluovlan").getString()));
		dataForm.setShangmenshijian(isNull(dataRow.getDataElement("shangmenshijian").getString()));
		dataForm.setDanzheng(isNull(dataRow.getDataElement("danzheng").getString()));
		dataForm.setSxdhhm(isNull(dataRow.getDataElement("sxdhhm").getString()));
		dataForm.setOnuyj(isNull(dataRow.getDataElement("onuyj").getString()));
		dataForm.setJidingheyj(isNull(dataRow.getDataElement("jidingheyj").getString()));
		dataForm.setShoushifei(isNull(dataRow.getDataElement("shoushifei").getString()));
		dataForm.setKuandaifei(isNull(dataRow.getDataElement("kuandaifei").getString()));
		dataForm.setChuzhuangfei(isNull(dataRow.getDataElement("chuzhuangfei").getString()));
		dataForm.setYunyingshang(isNull(dataRow.getDataElement("yunyingshang").getString()));
		dataForm.setBzygf(isNull(dataRow.getDataElement("bzygf").getString()));
		dataForm.setNianfei(isNull(dataRow.getDataElement("nianfei").getString()));
		dataForm.setBeizhu(isNull(dataRow.getDataElement("beizhu").getString()));
		dataForm.setZongshoufei(isNull(dataRow.getDataElement("zongshoufei").getString()));
		dataForm.setShoujubenhao(isNull(dataRow.getDataElement("shoujubenhao").getString()));
		dataForm.setQtsbsyqk(isNull(dataRow.getDataElement("qtsbsyqk").getString()));
		dataForm.setQitahaocai(isNull(dataRow.getDataElement("qitahaocai").getString()));
		dataForm.setJiexianzi(isNull(dataRow.getDataElement("jiexianzi").getString()));
		dataForm.setRj11(isNull(dataRow.getDataElement("rj11").getString()));
		dataForm.setRj45(isNull(dataRow.getDataElement("rj45").getString()));
		dataForm.setMokuai(isNull(dataRow.getDataElement("mokuai").getString()));
		dataForm.setMianban(isNull(dataRow.getDataElement("mianban").getString()));
		dataForm.setWangxian(isNull(dataRow.getDataElement("wangxian").getString()));
		dataForm.setShigongren(isNull(dataRow.getDataElement("shigongren").getString()));
		dataForm.setXianchangbeizhu(isNull(dataRow.getDataElement("xianchangbeizhu").getString()));
		dataForm.setBeizhuhuizong(isNull(dataRow.getDataElement("beizhuhuizong").getString()));
		dataForm.setKaipiaoxinxi(isNull(dataRow.getDataElement("kaipiaoxinxi").getString()));
		dataForm.setShebeixiaoshoufei(isNull(dataRow.getDataElement("shebeixiaoshou").getString()));
		dataForm.setCailiaofei(isNull(dataRow.getDataElement("cailiaofei").getString()));
		dataForm.setPipeizhuangtai(isNull(dataRow.getDataElement("pipeizhuangtai").getString()));
		dataForm.setShoukuanshijian(isNull(dataRow.getDataElement("shoukuanshijian").getString()));
		
		return mapping.findForward("init.edit");
		
	}


	private String isNull(String string) {
		if (string == null) {
			return "";
		} else {
			return string;
		}
	}

}
