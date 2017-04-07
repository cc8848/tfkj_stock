package com.stock.paigongdan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.kucun.KucunService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;

public class HuidanPreImportEditAction extends BusinessAction{
	PaiGongDanService  pgdservice = new PaiGongDanService();
	HuidanPreImportService  service = new HuidanPreImportService();
	YonghuDataService serviceData = new YonghuDataService();
	KucunService kucunService = new KucunService();
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);

		List<CommonModule> dianxintaocan = pgdservice.getDianxintaocan();
		request.setAttribute("dianxintaocan", dianxintaocan);
		
		List<CommonModule> shichangList = pgdservice.getShichangAll();
		request.setAttribute("shichangList", shichangList);
		
		List<CommonModule> shichangtvList = pgdservice.getShichangtvAll();
		request.setAttribute("shichangtvList", shichangtvList);
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
		PaiGongDanEntiyForm pGDForm = (PaiGongDanEntiyForm) form;
		DataRow dataRow = service.getPreImportByUUID(pGDForm.getUUID());
		pGDForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		pGDForm.setXiaoquname(dataRow.getDataElement("xiaoquname")
				.getString());
		pGDForm.setUserplace(dataRow.getDataElement("userplace")
				.getString());
		pGDForm.setUsertel(dataRow.getDataElement("usertel").getString());

		pGDForm.setAnzhuangshijian(dataRow
				.getDataElement("anzhuangshijian").getString());
		pGDForm.setXiangmu(dataRow.getDataElement("xiangmu").getString());
		pGDForm.setTfkuandaidaikuan(dataRow.getDataElement(
				"tfkuandaidaikuan").getString());
		pGDForm.setTfkdnianxian(dataRow.getDataElement("tfkdnianxian")
				.getString());

		pGDForm.setTfiptv(dataRow.getDataElement("tfiptv").getString());
		pGDForm.setTfiptvnianxian(dataRow.getDataElement("tfiptvnianxian")
				.getString());
		pGDForm.setQtye(dataRow.getDataElement("qtye").getString());
		pGDForm.setFufei(dataRow.getDataElement("fufei").getString());

		pGDForm.setTelhaoma1(dataRow.getDataElement("telhaoma1")
				.getString());
		pGDForm.setTelhaoma2(dataRow.getDataElement("telhaoma2")
				.getString());
		pGDForm.setDxfandan(dataRow.getDataElement("dxfandan").getString());
		pGDForm.setZhengjian(dataRow.getDataElement("zhengjian")
				.getString());

		pGDForm.setShoushifei(dataRow.getDataElement("shoushifei")
				.getString());
		pGDForm.setNianfei(dataRow.getDataElement("nianfei").getString());
		pGDForm.setBuzuyue(dataRow.getDataElement("buzuyue").getString());
		pGDForm.setChuzhuangfei(dataRow.getDataElement("chuzhuangfei")
				.getString());
		pGDForm.setKuaidaifei(dataRow.getDataElement("kuaidaifei")
				.getString());
		pGDForm.setPaigongriqi(dataRow.getDataElement("paigongriqi")
				.getString());
		pGDForm.setTfsfyewu(dataRow.getDataElement("tfsfyewu").getString());
		
		// pGDForm.setKuadnai(dataRow.getDataElement("kuandai").getString());
		// pGDForm.setTv(dataRow.getDataElement("tv").getString());
		// pGDForm.setTel(dataRow.getDataElement("tel").getString());
		// pGDForm.setUseryaoqiu(dataRow.getDataElement("useryaoqiu").getString());
		// 一下新增
		pGDForm.setTfkdczf(dataRow.getDataElement("tfkdczf").getString());
		pGDForm.setTfkuandaifei(dataRow.getDataElement("tfkuandaifei")
				.getString());
		pGDForm.setTfiptvshoushifei(dataRow.getDataElement(
				"tfiptvshoushifei").getString());
		pGDForm.setTfjidingheyajin(dataRow
				.getDataElement("tfjidingheyajin").getString());
		pGDForm.setYuyingshang(dataRow.getDataElement("yuyingshang")
				.getString());
		pGDForm.setQtbuzuyue(dataRow.getDataElement("qtbuzuyue")
				.getString());
		pGDForm.setHeji(dataRow.getDataElement("heji").getString());
		pGDForm.setUsername(dataRow.getDataElement("username").getString());
		pGDForm.setShenfenzheng(dataRow.getDataElement("shenfenzheng").getString());
		pGDForm.setJiaohuanji(dataRow.getDataElement("jiaohuanji")
				.getString());
		pGDForm.setDxchuzhuangfei(dataRow.getDataElement("dxchuzhuangfei")
				.getString());

		pGDForm.setTelhaoma3(dataRow.getDataElement("telhaoma3")
				.getString());
		pGDForm.setTelhaoma4(dataRow.getDataElement("telhaoma4")
				.getString());

		pGDForm.setOnu(dataRow.getDataElement("onu").getString());
		pGDForm.setJidinghe(dataRow.getDataElement("jidinghe").getString());

		pGDForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
		pGDForm.setState(dataRow.getDataElement("state").getString());

		pGDForm.setFufeitype(dataRow.getDataElement("fufeitype")
				.getString());
		pGDForm.setShebeixiaoshou(dataRow.getDataElement("shebeixiaoshou").getString());
		pGDForm.setCailiaofei(dataRow.getDataElement("cailiaofei").getString());
		pGDForm.setKaipiaoxinxi(dataRow.getDataElement("kaipiaoxinxi").getString());
		
		pGDForm.setBeishuselect(dataRow.getDataElement("shichangbeishu").getString());
		
		pGDForm.setFenguang(dataRow.getDataElement("fenguangD").getString());
	    pGDForm.setOnumac(dataRow.getDataElement("onumacD").getString());
	    pGDForm.setStbmcid(dataRow.getDataElement("stbmcidD").getString());
	    pGDForm.setDianshiip(dataRow.getDataElement("dianshiipD").getString());
	    
	    pGDForm.setBddianshiip(dataRow.getDataElement("bddianshiip").getString());
	    pGDForm.setBdfenguang(dataRow.getDataElement("bdfenguang").getString());
	    pGDForm.setBdonumac(dataRow.getDataElement("bdonumac").getString());
	    pGDForm.setBdstbmcid(dataRow.getDataElement("bdstbmcid").getString());
	    
	    pGDForm.setBiduikbn(dataRow.getDataElement("biduikbn").getString());
	    pGDForm.setFenguangID(dataRow.getDataElement("fenguangID").getString());
//	    if(CPID.getString()!=null&&!"0".equals(CPID.getString())) {
//	    	pGDForm.setSelectCommunityPileID(CPID.getString());
//	    	pGDForm.setEqboxnum(cpboxdataRow.getDataElement("EqBoxNum").getString());
//	    }
//	    if(CPID2.getString()!=null&&!"0".equals(CPID2.getString())) {
//	    	pGDForm.setSelectCommunityPileID2(CPID2.getString());
//	    	pGDForm.setEqboxnum2(ebboxdataRow.getDataElement("EqBoxNum").getString());
//	    }
	    pGDForm.setKaijishijian(dataRow.getDataElement("newkaijishijian")
				.getString());
	    pGDForm.setTingjishijian(dataRow.getDataElement("newtingjishijian")
				.getString());
	    
	    pGDForm.setWangluoip(dataRow.getDataElement("netip").getString());
	    pGDForm.setDianhuaip(dataRow.getDataElement("telip").getString());
	    pGDForm.setDianhuavlan(dataRow.getDataElement("telvaln").getString());
	    pGDForm.setWangluovlan(dataRow.getDataElement("netvaln").getString());
	    pGDForm.setYewutype(dataRow.getDataElement("yewutype").getString());
	    DataElement CPID = dataRow.getDataElement("CommunityPile_ID");
		DataElement CPID2 = dataRow.getDataElement("CommunityPile_ID2");
	    if(CPID.getString()!=null&&!"0".equals(CPID.getString())) {
	    	pGDForm.setSelectCommunityPileID(CPID.getString());
	    }
	    if(CPID2.getString()!=null&&!"0".equals(CPID2.getString())) {
	    	pGDForm.setSelectCommunityPileID2(CPID2.getString());
	    }
	    if("【线路切改】".equals(dataRow.getDataElement("yewutype").getString())) {
	    	pGDForm.setIsQiegai("1");
	    }else{
	    	pGDForm.setIsQiegai("0");
	    }
	    if("【移机】".equals(dataRow.getDataElement("yewutype").getString())) {
	    	pGDForm.setIsYiji("1");
	    }else{
	    	pGDForm.setIsYiji("0");
	    }
		return mapping.findForward(FW_INIT_EDIT);
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
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanEntiyForm dataForm = (PaiGongDanEntiyForm) form;
		if(!"0".equals(dataForm.getSelectCommunityPileID())&&!"".equals(dataForm.getSelectCommunityPileID())) {
			DataRow cpjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID());
			String cpjti = cpjtidataRow.getDataElement("EqSta_ID").getString();
			if(!dataForm.getSelectCommunityPileID().equals(dataForm.getOldCPID())) {
				if(!"2".equals(cpjti)) {
					CommonMessage commonMessage = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "设备挑选失败，请确认设备状态！");
					if (saveMessage(commonMessage, request)) {
						savedInRequest(request);
						return mapping.findForward(FW_ERROR_INSERT);
					}
				}else{
					kucunService.zhuangTaiChange(dataForm.getSelectCommunityPileID(),"4",dataForm.getXiaoquname(),"安装用",dataForm.getUserplace(),dataForm.getPaigongriqi());
				}
			}
		}
		if(!"0".equals(dataForm.getSelectCommunityPileID2())&&!"".equals(dataForm.getSelectCommunityPileID2())) {
			DataRow cpboxjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID2());
			String cpboxjti = cpboxjtidataRow.getDataElement("EqSta_ID").getString();
			if(!dataForm.getSelectCommunityPileID2().equals(dataForm.getOldCPID2())) {
				if(!"2".equals(cpboxjti)) {
					CommonMessage commonMessage = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "设备挑选失败，请确认设备状态！");
					if (saveMessage(commonMessage, request)) {
						savedInRequest(request);
						return mapping.findForward(FW_ERROR_INSERT);
					}
				}else{
					kucunService.zhuangTaiChange(dataForm.getSelectCommunityPileID2(),"4",dataForm.getXiaoquname(),"安装用",dataForm.getUserplace(),dataForm.getPaigongriqi());
				}
			}
		}
		String result = service.update((PaiGongDanEntiyForm) form);
		if (saveMessage(result, request)) {
			savedInRequest(request);
			return mapping.findForward(FW_ERROR_EDIT);
		}
		return mapping.findForward(FW_SUCCESS);
	}
}
