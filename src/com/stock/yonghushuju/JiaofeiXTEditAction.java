/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: payment action class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 */
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
import com.takucin.aceeci.frame.sql.DataSet;

/**
 * Payment action class.
 * 
 * @author Zhu.Xiao-Lei
 */
public class JiaofeiXTEditAction extends BusinessAction {
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
//		savedInRequest(request);
//		String uuids = request.getParameter("UUID").toString();
//		DataSet<DataRow> ds = new DataSet<DataRow>();
//		
//		ds.add(serviceData.getDataByUUID(uuids));
//		
////		String uuidArr[] = uuids.split(",");
////		
////		for (int i = 0; i < uuidArr.length; i++) {
////			ds.add(serviceData.getDataByUUID(uuidArr[i]));
////		}
//		
//		for (int i = 0; i < ds.size(); i++) {
//			CommonMessage message = xiugaicheck(ds.get(i).getDataElement("yonghuzhuangtai").getString());
//			if (saveMessage(message, request)) {
//				return mapping.findForward(FW_SUCCESS);
//			}
//		}
		
		savedInRequest(request);
		String uuids = request.getParameter("UUID").toString();
		YonghuDataEntityForm dataForm = (YonghuDataEntityForm) form;
		DataRow dataRow = serviceData.getDataByUUID(uuids);
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

	public ActionForward update(ActionMapping mapping, ActionForm form,
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
	 * 
	 * 
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	private CommonMessage xiugaicheck(String state) throws Exception {
		if (!state.equals("已安装")) {
			return new CommonMessage(ErrorConstant.YONGHU_JIAOFEI_STATE);
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
