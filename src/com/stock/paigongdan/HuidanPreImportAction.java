package com.stock.paigongdan;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.fenPeiIp.FenguangKeService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.common.Constant;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.Common;
/** 
 * @author daizhen 
 * @version ����ʱ�䣺2016-3-2 
 * �ص�Ԥ�����ѯ
 */
public class HuidanPreImportAction extends BusinessPaginationAction{

	PaiGongDanService  pgdservice = new PaiGongDanService();
	HuidanPreImportService  service = new HuidanPreImportService();
	FenguangKeService fgservice = new FenguangKeService();
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	
	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		PaiGongDanPreImportForm f =  (PaiGongDanPreImportForm) form;
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResult((PaiGongDanPreImportForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		PaiGongDanPreImportForm f =  (PaiGongDanPreImportForm) form;
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultCount((PaiGongDanPreImportForm) form);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	/**
	 * ����С���б�
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
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		fenguangform.setKaijishijian("");
		fenguangform.setTingjishijian("");
		return firstPage(mapping, form, request, response);
	}
	
	/**
	 * ɾ��
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
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		service.delete((PaiGongDanPreImportForm) form,em.getEmployeeName(),Common.formatDate(new Date(),Common.DATE_FORMAT_FULL));
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * һ���������������ֹⰴťִ��action
	 *****/
	public ActionForward disanfangfenguang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String fenguang = dataRow.getDataElement("fenguangD").getString();
			//ȡ����ѡ�ɹ�����С��
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//ȡ����ѡ�ɹ����ĵ�ַ
			String dizhi = dataRow.getDataElement("userplace").getString();
			if(fenguang==null||"".equals(fenguang)||" ".equals(fenguang)||"��".equals(fenguang)) {
				service.sanfangfenguang(uuids[i]);
			}else{
				wrongdata.append(xiaoqu+dizhi+"�ֹ����Ϊ�գ�</br>");
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�������ֹ�ɹ���");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}	
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * һ��������FTTBС����ťִ��action
	 *****/
	public ActionForward fttbxiaoqu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String fenguang = dataRow.getDataElement("fenguangD").getString();
			String onumac = dataRow.getDataElement("onumacD").getString();
			//ȡ����ѡ�ɹ�����С��
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//ȡ����ѡ�ɹ����ĵ�ַ
			String dizhi = dataRow.getDataElement("userplace").getString();
			if((fenguang==null||"".equals(fenguang)||" ".equals(fenguang)||"��".equals(fenguang))&&(onumac==null||"".equals(onumac)||" ".equals(onumac)||"��".equals(onumac))) {
				service.fttbxiaoqu(uuids[i]);
			}else{
				wrongdata.append(xiaoqu+dizhi+"�ֹ��onumac����ȫΪ�գ�</br>");
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "FTTBС���ɹ���");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}	
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * һ��������������ONU��ťִ��action
	 *****/
	public ActionForward daifenpeionu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String onumac = dataRow.getDataElement("onumacD").getString();
			//ȡ����ѡ�ɹ�����С��
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//ȡ����ѡ�ɹ����ĵ�ַ
			String dizhi = dataRow.getDataElement("userplace").getString();
			if(onumac==null||"".equals(onumac)||" ".equals(onumac)||"��".equals(onumac)) {
				service.daifenpeionu(uuids[i]);
			}else{
				wrongdata.append(xiaoqu+dizhi+"onumac����Ϊ�գ�</br>");
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "��ƥ��ONU�ɹ���");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * һ������������������а�ťִ��action
	 *****/
	public ActionForward daifenpeijidinghe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String bdstbmcid = dataRow.getDataElement("stbmcidD").getString();
			//ȡ����ѡ�ɹ�����С��
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//ȡ����ѡ�ɹ����ĵ�ַ
			String dizhi = dataRow.getDataElement("userplace").getString();
			if(bdstbmcid==null||"".equals(bdstbmcid)||" ".equals(bdstbmcid)||"��".equals(bdstbmcid)) {
				service.daifenpeijidinghe(uuids[i]);
			}else{
				wrongdata.append(xiaoqu+dizhi+"stbmcid����Ϊ�գ�</br>");
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "��ƥ������гɹ���");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * һ���������ֹ����ʹ�ð�ťִ��action
	 *****/
	public ActionForward pipeipgd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			//ȡ����ѡ�ɹ�����С��
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//ȡ����ѡ�ɹ����ĵ�ַ
			String dizhi = dataRow.getDataElement("userplace").getString();
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String currentFenguang = dataRow.getDataElement("fenguangD").getString();
			//ֻ�Ե�ǰ�ֹ��Ƿǿշ�0�Ľ��в���
			if(currentFenguang==null||"".equals(currentFenguang)||"��".equals(currentFenguang)||"0".equals(currentFenguang)) {
				String fenguangID = fgservice.pipeipgd(xiaoqu, dizhi,request);
				if(fenguangID.contains("@")) {
					//���µ�ǰ�ɹ�����Ϣ
					fgservice.updatePreImportfenguang(uuids[i],fenguangID.split("@")[0],fenguangID.split("@")[1]);
				}else{
					//û�л�ȡ���ɹ�����Ϣ�𣬼�¼С���͵�ַ
					if("NOGUIZE".equals(fenguangID)) {
						wrongdata.append(xiaoqu+dizhi+"û�зֹ�������</br>");
					}else{
						wrongdata.append(xiaoqu+dizhi+"û�п��õķֹ�</br>");
					}
				}
			}else{
				wrongdata.append(xiaoqu+dizhi+"�Ѵ��ڷֹ⣬����պ����·��䡣</br>");
			}
			
			//service.updateMask(uuids[i],request, "0");
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ֹ����ɹ���");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * һ���������ֹ����ʹ�ð�ťִ��action
	 *****/
	public ActionForward recyclepgd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String currentFenguang = dataRow.getDataElement("fenguangID").getString();
			if(currentFenguang!=null) {
				fgservice.recyclefenguang(currentFenguang,request);
			}
			fgservice.updatePreImportfenguang(uuids[i],"", "");
		}
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ֹ���ճɹ���");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * һ��������������ص�����ťִ��action
	 *****/
	public ActionForward transportHuidan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			//����ʱ��
			String kaijishijian = dataRow.getDataElement("newkaijishijian").getString();
			//ͣ��ʱ��
			String tingjishijian = dataRow.getDataElement("newtingjishijian").getString();
			//ȡ����ѡ�ɹ�����С��
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//ȡ����ѡ�ɹ����ĵ�ַ
			String dizhi = dataRow.getDataElement("userplace").getString();
			//��ϵ�绰
			String lianxidianhua = dataRow.getDataElement("usertel").getString();
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String currentFenguang = dataRow.getDataElement("fenguangD").getString();
			//onumac
			String onumac = dataRow.getDataElement("onumacD").getString();
			//����ʱ��
			String shangmenshijian = dataRow.getDataElement("anzhuangshijian").getString();
			//��Ӫ��
			String yunyingshang = dataRow.getDataElement("yuyingshang").getString();
			//ҵ������
			String yewutype = dataRow.getDataElement("yewutype").getString();
			//����
			String wangluo = dataRow.getDataElement("tfkuandaidaikuan").getString();
			//����
			String dianshi = dataRow.getDataElement("tfiptv").getString();
			//�绰
			String dianhua = dataRow.getDataElement("tfsfyewu").getString();
			//����ip
			String wangluoip = dataRow.getDataElement("netip").getString();;
			//STB MCID
			String stbmcid = dataRow.getDataElement("stbmcidD").getString();;
			//�绰ip
			String dianhuaip = dataRow.getDataElement("telip").getString();;
			if(checkdizhi(dizhi)) {
				wrongdata.append(xiaoqu+dizhi+"��ַ����</br>");
			}else if(checkEmpty(kaijishijian)||checkEmpty(tingjishijian)) {
				wrongdata.append(xiaoqu+dizhi+"����ʱ�䡢ͣ��ʱ�䲻��Ϊ��</br>");
			}else if(checkEmpty(currentFenguang)||checkEmpty(onumac)) {		
				wrongdata.append(xiaoqu+dizhi+"�ֹ⡢onumac����Ϊ��</br>");
			}else if(checkEmpty(xiaoqu)||checkEmpty(dizhi)||
						checkEmptydx(lianxidianhua)||checkEmpty(shangmenshijian)||checkEmpty(yunyingshang)||checkEmpty(yewutype)) {
					wrongdata.append(xiaoqu+dizhi+"С������ַ����ϵ�绰������ʱ�䡢��Ӫ�̡�ҵ�����Ͳ���Ϊ��</br>");
			}else if(checkEmpty(wangluo)&&checkEmpty(dianshi)&&checkEmpty(dianhua)) {
				wrongdata.append(xiaoqu+dizhi+"���硢���ӡ��绰����ͬʱΪ��</br>");
			}else if(!checkEmpty(wangluo)&&checkEmpty(wangluoip)) {
				wrongdata.append(xiaoqu+dizhi+"���粻Ϊ��ʱ����ip����Ϊ��</br>");
			}else if(!checkEmpty(dianshi)&&(checkEmpty(stbmcid)||checkEmpty(dianhuaip))) {
				wrongdata.append(xiaoqu+dizhi+"���Ӳ�Ϊ��ʱSTB MCID�͵绰ip����Ϊ��</br>");
			}else if(wangluoip!=null&&(wangluoip.indexOf("����")!=-1||wangluoip.indexOf("����")!=-1)) {
					wrongdata.append(xiaoqu+dizhi+"�����˺�����</br>");
			}else if(dianhuaip!=null&&(dianhuaip.indexOf("����")!=-1||dianhuaip.indexOf("����")!=-1)) {
				wrongdata.append(xiaoqu+dizhi+"�����˺�����</br>");
			}else{
				service.insert(dataRow,em.getEmployeeName(),Common.formatDate(new Date(),Common.DATE_FORMAT_FULL));
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "����ص��ɹ���");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	private boolean checkdizhi(String dizhi) {
		if(dizhi.indexOf("����")!=-1) {
			if("00".equals(dizhi.split("-")[0])) {
				return true;
			}
		}else{
			String[] dizhiarr = dizhi.split("-");
			if(dizhiarr.length==3) {
				if("00".equals(dizhiarr[0])) {
					return true;
				}else if("0".equals(dizhiarr[1])){
					return true;
				}else if("0000".equals(dizhiarr[2])){
					return true;
				}else if(dizhiarr[2].startsWith("00")||dizhiarr[2].endsWith("00")){
					return true;
				}
			}else if(dizhiarr.length==2) {
				if("00".equals(dizhiarr[0])) {
					return true;
				}else if("00".equals(dizhiarr[1])){
					return true;
				}
			}
		}
		return false;
	}
	
	/*****
	 * һ���������ɵڶ�̨IPTV��ťִ��action
	 *****/
	public ActionForward diertaiiptv(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		service.diertaiiptv(fenguangform.getUUID(),fenguangform.getTingjishijian(),em.getEmployeeName(),Common.formatDate(new Date(),Common.DATE_FORMAT_FULL));
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ڶ�̨IPTV���ɳɹ���");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/**
	 * ����Ϊ��ʱ����true
	 */
	private boolean checkEmpty(String content) {
		if(content==null||"".equals(content)||" ".equals(content)||"��".equals(content)||"0".equals(content)) {
			return true;
		}
		return false;
	}
	private boolean checkEmptydx(String content) {
		if(content==null||"".equals(content)||" ".equals(content)||"��".equals(content)) {
			return true;
		}
		return false;
	}
}
