package com.stock.paigongdan;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessAction;
import com.stock.fenPeiIp.FenguangKeService;
import com.stock.kucun.KucunService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.common.Constant;
import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.Common;

/**
 * @author wangdl
 * @version 创建时间：2012-6-13 下午04:38:43 类说明
 */
public class PaiGongDanEditAction extends BusinessAction {

	PaiGongDanService service = new PaiGongDanService();
	
	YonghuDataService serviceData = new YonghuDataService();
	
	KucunService kucunService = new KucunService();

	FenguangKeService fgservice = new FenguangKeService();
	/**
	 * 放入小区列表
	 * 
	 * @param request
	 * @throws Exception
	 */
	private void savedInRequest(HttpServletRequest request) throws Exception {
		List<CommonModule> xiaoquList = service.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);

		List<CommonModule> dianxintaocan = service.getDianxintaocan();
		request.setAttribute("dianxintaocan", dianxintaocan);
		
		List<CommonModule> shichangList = service.getShichangAll();
		request.setAttribute("shichangList", shichangList);
		
		List<CommonModule> shichangtvList = service.getShichangtvAll();
		request.setAttribute("shichangtvList", shichangtvList);
	}

	public ActionForward changetv(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuffer value = new StringBuffer();
		String string = "";
		String shichangtv = request.getParameter("tfiptvnianxian"); 
		shichangtv = java.net.URLDecoder.decode(shichangtv, "utf-8"); 
		DataSet<DataRow> executeQuery = service.changetv(shichangtv);
		for(int i = 0 ; i < executeQuery.size(); i++)
		{
			string += executeQuery.get(i).getDataElement("jine").getString()+"|";
		}
        if(string.length() > 1)
        {
        	string = string.substring(0, string.length() - 1);
        }
		value.append(string);
		String valueStr0 = value.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().print(valueStr0);
		return mapping.findForward("null");
	}
	public ActionForward changekd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuffer value = new StringBuffer();
		String string = "";
		String tfkdnianxian = request.getParameter("tfkdnianxian"); 
		tfkdnianxian = java.net.URLDecoder.decode(tfkdnianxian, "utf-8"); 
		DataSet<DataRow> executeQuery = service.changekd(tfkdnianxian);
		for(int i = 0 ; i < executeQuery.size(); i++)
		{
			string += executeQuery.get(i).getDataElement("jine").getString()+"|";
		}
        if(string.length() > 1)
        {
        	string = string.substring(0, string.length() - 1);
        }
		value.append(string);
		String valueStr0 = value.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().print(valueStr0);
		return mapping.findForward("null");
	}
	public ActionForward changekdsc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuffer value = new StringBuffer();
		String string = "";
		String tfkdnianxian = request.getParameter("tfkdnianxian"); 
		tfkdnianxian = java.net.URLDecoder.decode(tfkdnianxian, "utf-8"); 
		DataSet<DataRow> executeQuery = service.changekdsc(tfkdnianxian);
		for(int i = 0 ; i < executeQuery.size(); i++)
		{
			string += executeQuery.get(i).getDataElement("shichanglx").getString()+"|";
		}
        if(string.length() > 1)
        {
        	string = string.substring(0, string.length() - 1);
        }
		value.append(string);
		String valueStr0 = value.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().print(valueStr0);
		return mapping.findForward("null");
	}
	public ActionForward changekddk(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuffer value = new StringBuffer();
		String string = "";
		String tfkdnianxian = request.getParameter("tfkdnianxian"); 
		tfkdnianxian = java.net.URLDecoder.decode(tfkdnianxian, "utf-8"); 
		DataSet<DataRow> executeQuery = service.changekddk(tfkdnianxian);
		for(int i = 0 ; i < executeQuery.size(); i++)
		{
			string += executeQuery.get(i).getDataElement("daikuan").getString()+"|";
		}
        if(string.length() > 1)
        {
        	string = string.substring(0, string.length() - 1);
        }
		value.append(string);
		String valueStr0 = value.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().print(valueStr0);
		return mapping.findForward("null");
	}
	public ActionForward changekdshichang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuffer value = new StringBuffer();
		String string = "";
		String tfkdnianxian = request.getParameter("tfkdnianxian"); 
		tfkdnianxian = java.net.URLDecoder.decode(tfkdnianxian, "utf-8"); 
		DataSet<DataRow> executeQuery = service.changekdshichang(tfkdnianxian);
		for(int i = 0 ; i < executeQuery.size(); i++)
		{
			string += executeQuery.get(i).getDataElement("shichangsj").getString()+"|";
		}
        if(string.length() > 1)
        {
        	string = string.substring(0, string.length() - 1);
        }
		value.append(string);
		String valueStr0 = value.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().print(valueStr0);
		return mapping.findForward("null");
	}
	public ActionForward changedianxin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuffer value = new StringBuffer();
		String string = "";
		String tfkdnianxian = request.getParameter("tfkdnianxian"); 
		tfkdnianxian = java.net.URLDecoder.decode(tfkdnianxian, "utf-8"); 
		DataRow executeQuery = service.getdianxinJouhou(tfkdnianxian);
		if(executeQuery!=null) {
		String daikuan = executeQuery.getDataElement("daikuan").getString();
		String chuzhuangfei = executeQuery.getDataElement("chuzhuangfei").getString();
		String feiyong = executeQuery.getDataElement("feiyong").getString();
		String buzuyue = executeQuery.getDataElement("buzuyue").getString();
		String onuyajin = executeQuery.getDataElement("onuyajin").getString();
		value.append(daikuan);
		value.append("|");
		value.append(chuzhuangfei);
		value.append("|");
		value.append(feiyong);
		value.append("|");
		value.append(buzuyue);
		value.append("|");
		value.append(onuyajin);
		}else{
			value.append("|0|0|0|0");
		}
		String valueStr0 = value.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().print(valueStr0);
		return mapping.findForward("null");
	}
	/**
	 * 跳转到insert 页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initInsert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		PaiGongDanEntiyForm f = (PaiGongDanEntiyForm) form;
		f.setBeizhu(em.getEmployeeName());
		savedInRequest(request);
		return mapping.findForward(FW_INIT_INSERT);
	}
	
	/**
	 * 当日工单录入
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward dangriGD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		PaiGongDanEntiyForm f = (PaiGongDanEntiyForm) form;
		f.setBeizhu(em.getEmployeeName());
		f.setPaigongriqi(Common.formatDate(new Date(), "yyyy-MM-dd"));
		savedInRequest(request);
		return mapping.findForward("init.insert.dangri");
	}

	/**
	 * 派工单插入
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanEntiyForm dataForm = (PaiGongDanEntiyForm) form;
		dataForm.setOnu(String.valueOf(Integer.valueOf(dataForm.getOnu())+Integer.valueOf(dataForm.getJiaohuanji())));
		if("1".equals(dataForm.getIsYiji())) {
			dataForm.setBeizhu("\\【移出小区】"+dataForm.getYichuxiaoqu()+"【移出地址】"+dataForm.getYichudizhi()+"【移出网络】"+dataForm.getYichuyewu()+"【移出电视】"+dataForm.getYichudianshi()+"【移出三网业务】"+dataForm.getYichuqita()+"\\"+dataForm.getBeizhu());
			dataForm.setYewutype("【移机】");
		}else{
			if("1".equals(dataForm.getIsQiegai())) {
				dataForm.setYewutype("【线路切改】");
			}else{
				dataForm.setYewutype("【安装】");
			}
		}
		if(dataForm.getSelectCommunityPileID()!=null&&!"0".equals(dataForm.getSelectCommunityPileID())&&!"".equals(dataForm.getSelectCommunityPileID())) {
			DataRow cpjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID());
			String cpjti = cpjtidataRow.getDataElement("EqSta_ID").getString();
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
		if(dataForm.getSelectCommunityPileID2()!=null&&!"0".equals(dataForm.getSelectCommunityPileID2())&&!"".equals(dataForm.getSelectCommunityPileID2())) {
			DataRow cpboxjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID2());
			String cpboxjti = cpboxjtidataRow.getDataElement("EqSta_ID").getString();
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
		String result = service.insert((PaiGongDanEntiyForm) form);
		if (saveMessage(result, request)) {
			savedInRequest(request);
			return mapping.findForward(FW_ERROR_INSERT);
		}
		return mapping.findForward(FW_SUCCESS);

	}
	
	/**
	 * 派工单插入
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insertXuanHao(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String result = service.insert((PaiGongDanEntiyForm) form);
		if (saveMessage(result, request)) {
			savedInRequest(request);
			return mapping.findForward(FW_ERROR_INSERT);
		}
		return mapping.findForward(FW_SUCCESS);
	}

	/**
	 * 插入当日派工单。
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insertDangRi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanEntiyForm dataForm = (PaiGongDanEntiyForm) form;	
		dataForm.setOnu(String.valueOf(Integer.valueOf(dataForm.getOnu())+Integer.valueOf(dataForm.getJiaohuanji())));
		if("1".equals(dataForm.getIsYiji())) {
			dataForm.setBeizhu("\\【移出小区】"+dataForm.getYichuxiaoqu()+"【移出地址】"+dataForm.getYichudizhi()+"【移出网络】"+dataForm.getYichuyewu()+"【移出电视】"+dataForm.getYichudianshi()+"【移出三网业务】"+dataForm.getYichuqita()+"\\"+dataForm.getBeizhu());
			dataForm.setYewutype("【移机】");
		}else{
			if("1".equals(dataForm.getIsQiegai())) {
				dataForm.setYewutype("【线路切改】");
			}else{
				dataForm.setYewutype("【安装】");
			}
		}
		if(!"".equals(dataForm.getSelectCommunityPileID())) {
			DataRow cpjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID());
			String cpjti = cpjtidataRow.getDataElement("EqSta_ID").getString();
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
		if(!"".equals(dataForm.getSelectCommunityPileID2())) {
			DataRow cpboxjtidataRow = serviceData.getDeviceJti(dataForm.getSelectCommunityPileID2());
			String cpboxjti = cpboxjtidataRow.getDataElement("EqSta_ID").getString();
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
		String result = service.insertDangRi((PaiGongDanEntiyForm) form);
		if (saveMessage(result, request)) {
			savedInRequest(request);
			return mapping.findForward("error.dangri");
		}
		return mapping.findForward("success.chugongdan");

	}
	/**
	 * 跳转到安装insert
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward azinsertEidt(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanEntiyForm f = (PaiGongDanEntiyForm) form;
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		f.setBeizhu(em.getEmployeeName());

		if (request.getParameter("num").equals("0")) {
			CommonMessage message = new CommonMessage(
					ErrorConstant.ANZHUANGWANBI);
			// String result = message;
			if (saveMessage(message, request)) {
				return mapping.findForward("initError");
			}
		}
		String qujian = request.getParameter("qujian");
		if("1".equals(qujian)) {
			f.setXiangmu("收件");
		}else{
			f.setXiangmu("安装");
		}
		String riqi = request.getParameter("riqi");
		String shijain = request.getParameter("shijian");
		shijain = URLDecoder.decode(shijain, "utf-8");

		String xiaoqu = request.getParameter("xiaoqu");

		xiaoqu = URLDecoder.decode(xiaoqu, "utf-8");
		f.setAnzhuangshijian(shijain);
		f.setPaigongriqi(riqi);
		f.setXiaoquname(xiaoqu);
		// savedInRequest(request);
		List<CommonModule> xiaoquList = service.getXiaoQuByQuyu(xiaoqu);
		request.setAttribute("xiaoquList", xiaoquList);
		List<CommonModule> dianxintaocan = service.getDianxintaocan();
		request.setAttribute("dianxintaocan", dianxintaocan);
		List<CommonModule> shichangList = service.getShichangAll();
		request.setAttribute("shichangList", shichangList);
		List<CommonModule> shichangtvList = service.getShichangtvAll();
		request.setAttribute("shichangtvList", shichangtvList);
		if("1".equals(qujian)) {
			f.setTelhaoma1(f.getTelhaoma1() == null ? "00000000" : f.getTelhaoma1()
					.toString());
			f.setTelhaoma2(f.getTelhaoma2() == null ? "00000000" : f.getTelhaoma2()
					.toString());
			f.setTelhaoma3(f.getTelhaoma3() == null ? "00000000" : f.getTelhaoma3()
					.toString());
			f.setTelhaoma4(f.getTelhaoma4() == null ? "00000000" : f.getTelhaoma4()
					.toString());
			return mapping.findForward(FW_INIT_INSERT2);
		}
		return mapping.findForward(FW_INIT_INSERT);
	}

	/**
	 * 选择号码
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initselect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		savedInRequest(request);
		PaiGongDanEntiyForm pGDForm = (PaiGongDanEntiyForm) form;
		String[] TELUUIDS = pGDForm.getTELUUIDS();
		Map<Object, Object> map = new HashMap<Object, Object>();
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		pGDForm.setBeizhu(em.getEmployeeName());

		for (int i = 0; i < TELUUIDS.length; i++) {
			map.put(i, TELUUIDS[i]);
		}
		pGDForm.setTelhaoma1(map.get(0) == null ? "00000000" : map.get(0)
				.toString());
		pGDForm.setTelhaoma2(map.get(1) == null ? "00000000" : map.get(1)
				.toString());
		pGDForm.setTelhaoma3(map.get(2) == null ? "00000000" : map.get(2)
				.toString());
		pGDForm.setTelhaoma4(map.get(3) == null ? "00000000" : map.get(3)
				.toString());

		pGDForm.setXiangmu("收件");
		pGDForm.setXiaoquname(pGDForm.getXiaoquname());
		return mapping.findForward(FW_INIT_INSERT2);
	}

	/*
	 * public static void main(String[] args) { PaiGongDanEntiyForm pGDForm =
	 * new PaiGongDanEntiyForm(); Map<Object, Object> map = new HashMap<Object,
	 * Object>(); String [] TELUUIDS = {"1","2"}; for (int i = 0; i <
	 * TELUUIDS.length; i++) { map.put(i, TELUUIDS[i]); }
	 * pGDForm.setTelhaoma1(map.get(0)==null?"":map.get(0).toString());
	 * pGDForm.setTelhaoma2(map.get(1)==null?"":map.get(1).toString());
	 * pGDForm.setTelhaoma3(map.get(2)==null?"":map.get(2).toString());
	 * pGDForm.setTelhaoma4(map.get(3)==null?"":map.get(3).toString());
	 * 
	 * System.out.println("1111"+pGDForm.getTelhaoma3()); }
	 */
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
		DataRow dataRow = service.getPGDByUUID(pGDForm.getUUID());
		DataElement CPID = dataRow.getDataElement("CommunityPile_ID");
		DataElement CPID2 = dataRow.getDataElement("CommunityPile_ID2");
		DataRow cpboxdataRow = null;
		if(CPID.getString()!=null&&!"0".equals(CPID.getString())) {
			cpboxdataRow = service.getCPBOXIDByPGDuuid(CPID.getString());
		}
		DataRow ebboxdataRow = null;
		if(CPID2.getString()!=null&&!"0".equals(CPID2.getString())) {
			ebboxdataRow = service.getEBBOXIDByPGDuuid(CPID2.getString());
		}
		CommonMessage message = xiugaicheck(dataRow.getDataElement("state")
				.getString());
		if("1".equals(request.getParameter("devicekbn"))) {
			message = new CommonMessage("SUCCESS");
		}
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} else {

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
		    if(CPID.getString()!=null&&!"0".equals(CPID.getString())) {
		    	pGDForm.setSelectCommunityPileID(CPID.getString());
		    	pGDForm.setEqboxnum(cpboxdataRow.getDataElement("EqBoxNum").getString());
		    }
		    if(CPID2.getString()!=null&&!"0".equals(CPID2.getString())) {
		    	pGDForm.setSelectCommunityPileID2(CPID2.getString());
		    	pGDForm.setEqboxnum2(ebboxdataRow.getDataElement("EqBoxNum").getString());
		    }
		    pGDForm.setKaijishijian(dataRow.getDataElement("newkaijishijian")
					.getString());
		    pGDForm.setTingjishijian(dataRow.getDataElement("newtingjishijian")
					.getString());
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
			// equipForm.setUUID(dataRow.getDataElement("PK_ID").getString());
			return mapping.findForward(FW_INIT_EDIT);
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
		PaiGongDanEntiyForm pGDForm = (PaiGongDanEntiyForm) form;
		DataRow dataRow = service.getPGDByUUID(pGDForm.getUUID());
		/*
		 * CommonMessage message =
		 * xiugaicheck(dataRow.getDataElement("state").getString());
		 * if(saveMessage(message, request)){ return
		 * mapping.findForward(FW_SUCCESS); }else{
		 */

		pGDForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		pGDForm.setXiaoquname(dataRow.getDataElement("xiaoquname").getString());
		pGDForm.setUserplace(dataRow.getDataElement("userplace").getString());
		pGDForm.setUsertel(dataRow.getDataElement("usertel").getString());

		pGDForm.setAnzhuangshijian(dataRow.getDataElement("anzhuangshijian")
				.getString());
		pGDForm.setXiangmu(dataRow.getDataElement("xiangmu").getString());
		pGDForm.setTfkuandaidaikuan(dataRow.getDataElement("tfkuandaidaikuan")
				.getString());
		pGDForm.setTfkdnianxian(dataRow.getDataElement("tfkdnianxian")
				.getString());

		pGDForm.setTfiptv(dataRow.getDataElement("tfiptv").getString());
		pGDForm.setTfiptvnianxian(dataRow.getDataElement("tfiptvnianxian")
				.getString());
		pGDForm.setQtye(dataRow.getDataElement("qtye").getString());
		pGDForm.setFufei(dataRow.getDataElement("fufei").getString());

		pGDForm.setTelhaoma1(dataRow.getDataElement("telhaoma1").getString());
		pGDForm.setTelhaoma2(dataRow.getDataElement("telhaoma2").getString());
		pGDForm.setDxfandan(dataRow.getDataElement("dxfandan").getString());
		pGDForm.setZhengjian(dataRow.getDataElement("zhengjian").getString());

		pGDForm.setShoushifei(dataRow.getDataElement("shoushifei").getString());
		pGDForm.setNianfei(dataRow.getDataElement("nianfei").getString());
		pGDForm.setBuzuyue(dataRow.getDataElement("buzuyue").getString());
		pGDForm.setChuzhuangfei(dataRow.getDataElement("chuzhuangfei")
				.getString());
		pGDForm.setKuaidaifei(dataRow.getDataElement("kuaidaifei").getString());
		pGDForm.setPaigongriqi(dataRow.getDataElement("paigongriqi")
				.getString());

		// pGDForm.setKuadnai(dataRow.getDataElement("kuandai").getString());
		// pGDForm.setTv(dataRow.getDataElement("tv").getString());
		// pGDForm.setTel(dataRow.getDataElement("tel").getString());
		// pGDForm.setUseryaoqiu(dataRow.getDataElement("useryaoqiu").getString());
		// 一下新增
		pGDForm.setTfkdczf(dataRow.getDataElement("tfkdczf").getString());
		pGDForm.setTfkuandaifei(dataRow.getDataElement("tfkuandaifei")
				.getString());
		pGDForm.setTfiptvshoushifei(dataRow.getDataElement("tfiptvshoushifei")
				.getString());
		pGDForm.setTfjidingheyajin(dataRow.getDataElement("tfjidingheyajin")
				.getString());
		pGDForm.setYuyingshang(dataRow.getDataElement("yuyingshang")
				.getString());
		pGDForm.setQtbuzuyue(dataRow.getDataElement("qtbuzuyue").getString());
		pGDForm.setHeji(dataRow.getDataElement("heji").getString());
		pGDForm.setUsername(dataRow.getDataElement("username").getString());

		pGDForm.setJiaohuanji(dataRow.getDataElement("jiaohuanji").getString());
		pGDForm.setDxchuzhuangfei(dataRow.getDataElement("dxchuzhuangfei")
				.getString());

		pGDForm.setTelhaoma3(dataRow.getDataElement("telhaoma3").getString());
		pGDForm.setTelhaoma4(dataRow.getDataElement("telhaoma4").getString());

		pGDForm.setOnu(dataRow.getDataElement("onu").getString());
		pGDForm.setJidinghe(dataRow.getDataElement("jidinghe").getString());

		pGDForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
		pGDForm.setState(dataRow.getDataElement("state").getString());

		pGDForm.setFufeitype(dataRow.getDataElement("fufeitype").getString());
		pGDForm.setShebeixiaoshou(dataRow.getDataElement("shebeixiaoshou").getString());
		pGDForm.setCailiaofei(dataRow.getDataElement("cailiaofei").getString());
		pGDForm.setKaipiaoxinxi(dataRow.getDataElement("kaipiaoxinxi").getString());
		
		pGDForm.setBeishuselect(dataRow.getDataElement("shichangbeishu").getString());
		
		pGDForm.setFenguang(dataRow.getDataElement("fenguangD").getString());
		pGDForm.setOnumac(dataRow.getDataElement("onumacD").getString());
		pGDForm.setStbmcid(dataRow.getDataElement("stbmcidD").getString());
		pGDForm.setDianshiip(dataRow.getDataElement("dianshiipD").getString());		
		
		pGDForm.setKaijishijian(dataRow.getDataElement("newkaijishijian")
				.getString());
	    pGDForm.setTingjishijian(dataRow.getDataElement("newtingjishijian")
				.getString());
		// equipForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		return mapping.findForward("showInfo");

	}

	public ActionForward showInfo1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		savedInRequest(request);
		PaiGongDanEntiyForm pGDForm = (PaiGongDanEntiyForm) form;
		String UUID = request.getParameter("UUID");
		DataRow dataRow = service.getPGDByUUID(UUID);

		pGDForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		pGDForm.setXiaoquname(dataRow.getDataElement("xiaoquname").getString());
		pGDForm.setUserplace(dataRow.getDataElement("userplace").getString());
		pGDForm.setUsertel(dataRow.getDataElement("usertel").getString());

		pGDForm.setAnzhuangshijian(dataRow.getDataElement("anzhuangshijian")
				.getString());
		pGDForm.setXiangmu(dataRow.getDataElement("xiangmu").getString());
		pGDForm.setTfkuandaidaikuan(dataRow.getDataElement("tfkuandaidaikuan")
				.getString());
		pGDForm.setTfkdnianxian(dataRow.getDataElement("tfkdnianxian")
				.getString());

		pGDForm.setTfiptv(dataRow.getDataElement("tfiptv").getString());
		pGDForm.setTfiptvnianxian(dataRow.getDataElement("tfiptvnianxian")
				.getString());
		pGDForm.setQtye(dataRow.getDataElement("qtye").getString());
		pGDForm.setFufei(dataRow.getDataElement("fufei").getString());

		pGDForm.setTelhaoma1(dataRow.getDataElement("telhaoma1").getString());
		pGDForm.setTelhaoma2(dataRow.getDataElement("telhaoma2").getString());
		pGDForm.setDxfandan(dataRow.getDataElement("dxfandan").getString());
		pGDForm.setZhengjian(dataRow.getDataElement("zhengjian").getString());

		pGDForm.setShoushifei(dataRow.getDataElement("shoushifei").getString());
		pGDForm.setNianfei(dataRow.getDataElement("nianfei").getString());
		pGDForm.setBuzuyue(dataRow.getDataElement("buzuyue").getString());
		pGDForm.setChuzhuangfei(dataRow.getDataElement("chuzhuangfei")
				.getString());
		pGDForm.setKuaidaifei(dataRow.getDataElement("kuaidaifei").getString());
		pGDForm.setPaigongriqi(dataRow.getDataElement("paigongriqi")
				.getString());

		// pGDForm.setKuadnai(dataRow.getDataElement("kuandai").getString());
		// pGDForm.setTv(dataRow.getDataElement("tv").getString());
		// pGDForm.setTel(dataRow.getDataElement("tel").getString());
		// pGDForm.setUseryaoqiu(dataRow.getDataElement("useryaoqiu").getString());
		// 一下新增
		pGDForm.setTfkdczf(dataRow.getDataElement("tfkdczf").getString());
		pGDForm.setTfkuandaifei(dataRow.getDataElement("tfkuandaifei")
				.getString());
		pGDForm.setTfiptvshoushifei(dataRow.getDataElement("tfiptvshoushifei")
				.getString());
		pGDForm.setTfjidingheyajin(dataRow.getDataElement("tfjidingheyajin")
				.getString());
		pGDForm.setYuyingshang(dataRow.getDataElement("yuyingshang")
				.getString());
		pGDForm.setQtbuzuyue(dataRow.getDataElement("qtbuzuyue").getString());
		pGDForm.setHeji(dataRow.getDataElement("heji").getString());
		pGDForm.setUsername(dataRow.getDataElement("username").getString());

		pGDForm.setJiaohuanji(dataRow.getDataElement("jiaohuanji").getString());
		pGDForm.setDxchuzhuangfei(dataRow.getDataElement("dxchuzhuangfei")
				.getString());

		pGDForm.setTelhaoma3(dataRow.getDataElement("telhaoma3").getString());
		pGDForm.setTelhaoma4(dataRow.getDataElement("telhaoma4").getString());

		pGDForm.setOnu(dataRow.getDataElement("onu").getString());
		pGDForm.setJidinghe(dataRow.getDataElement("jidinghe").getString());

		pGDForm.setBeizhu(dataRow.getDataElement("beizhu").getString());
		pGDForm.setState(dataRow.getDataElement("state").getString());

		pGDForm.setFufeitype(dataRow.getDataElement("fufeitype").getString());
		pGDForm.setShebeixiaoshou(dataRow.getDataElement("shebeixiaoshou").getString());
		pGDForm.setCailiaofei(dataRow.getDataElement("cailiaofei").getString());
		pGDForm.setKaipiaoxinxi(dataRow.getDataElement("kaipiaoxinxi").getString());
		
		pGDForm.setBeishuselect(dataRow.getDataElement("shichangbeishu").getString());
		
		pGDForm.setFenguang(dataRow.getDataElement("fenguangD").getString());
		pGDForm.setOnumac(dataRow.getDataElement("onumacD").getString());
		pGDForm.setStbmcid(dataRow.getDataElement("stbmcidD").getString());
		pGDForm.setDianshiip(dataRow.getDataElement("dianshiipD").getString());	
		
		pGDForm.setKaijishijian(dataRow.getDataElement("newkaijishijian")
				.getString());
	    pGDForm.setTingjishijian(dataRow.getDataElement("newtingjishijian")
				.getString());
		// equipForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		return mapping.findForward("showInfo1");

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
		dataForm.setOnu(String.valueOf(Integer.valueOf(dataForm.getOnu())+Integer.valueOf(dataForm.getJiaohuanji())));
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

	/**
	 * 删除
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanEntiyForm form1 = (PaiGongDanEntiyForm) form;
		// DataRow data = service.getPGDByUUID(form1.getUUID());
		CommonMessage message = checkDelet(form1.getUUID());
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} else {
			service.delete((PaiGongDanEntiyForm) form);
		}
		return mapping.findForward(FW_SUCCESS);
	}

	/**
	 * 删除校验
	 * 
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public CommonMessage checkDelet(String UUID) throws Exception {
		// DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data = service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		String fenguangID = data.getDataElement("fenguangID").getString();
		if(fenguangID==null||"".equals(fenguangID)||"0".equals(fenguangID)) {
			new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "存在匹配分光的信息不能被删除！");
		}
		if (!state.equals("1")) {
			return new CommonMessage(ErrorConstant.DELETE_PGD_STATE);
		} else {
			return new CommonMessage("SUCCESS");
		}

	}

	/**
	 * 删除校验
	 * 
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public CommonMessage xiugaicheck(String state) throws Exception {
		// DataRow daterow = service.getEquipByUUID(UUID);
		// DataRow data = service.getPGDByUUID(UUID);
		// String state = data.getDataElement("state").getString();
		if (!state.equals("1")) {
			return new CommonMessage(ErrorConstant.UPDATE_PGD_STATE);
		} else {
			return new CommonMessage("SUCCESS");
		}

	}

	/**
	 * 派工单解除绑定
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward jiebang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		service.jiebang((PaiGongDanEntiyForm) form);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * 一览界面点击分光回收使用按钮执行action
	 *****/
	public ActionForward pipeipgd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanEntiyForm fenguangform = (PaiGongDanEntiyForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPGDByUUID(uuids[i]);
			//取得所选派工单的小区
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//取得所选派工单的地址
			String dizhi = dataRow.getDataElement("userplace").getString();
			// 取得所选派工单的当前分光信息
			String currentFenguang = dataRow.getDataElement("fenguangD").getString();
			//只对当前分光是非空非0的进行操作
			if(currentFenguang==null||"".equals(currentFenguang)||"　".equals(currentFenguang)||"0".equals(currentFenguang)) {
				String fenguangID = fgservice.pipeipgd(xiaoqu, dizhi,request);
				if(fenguangID.contains("@")) {
					//更新当前派工单信息
					fgservice.updatepgdfenguang(uuids[i],fenguangID.split("@")[0],fenguangID.split("@")[1]);
				}else{
					//没有获取到派工单信息吗，记录小区和地址
					if("NOGUIZE".equals(fenguangID)) {
						wrongdata.append(xiaoqu+dizhi+"没有分光分配规则</br>");
					}else{
						wrongdata.append(xiaoqu+dizhi+"没有可用的分光</br>");
					}
				}
			}else{
				wrongdata.append(xiaoqu+dizhi+"已存在分光，请回收后重新分配。</br>");
			}
			
			//service.updateMask(uuids[i],request, "0");
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "分光分配成功！");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * 一览界面点击分光回收使用按钮执行action
	 *****/
	public ActionForward recyclepgd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanEntiyForm fenguangform = (PaiGongDanEntiyForm) form;
		String[] uuids = fenguangform.getUUIDS();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPGDByUUID(uuids[i]);
			// 取得所选派工单的当前分光信息
			String currentFenguang = dataRow.getDataElement("fenguangID").getString();
			if(currentFenguang!=null) {
				fgservice.recyclefenguang(currentFenguang,request);
			}
			fgservice.updatepgdfenguang(uuids[i],"", "");
		}
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "分光回收成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
}