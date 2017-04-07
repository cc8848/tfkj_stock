package com.stock.tongji;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.huidan.PhotoUploadForm;
import com.stock.paigongdan.PaiGongDanEntiyForm;
import com.sun.net.httpserver.Authenticator.Success;
import com.takucin.aceeci.frame.sql.DataRow;

public class ChugongdanEditAction extends BusinessAction{
	TongjiService service = new TongjiService();
	
	/**
	 * ��ת���ᵥҳ��
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
		ChugongdanEditForm f = (ChugongdanEditForm) form;
		DataRow dataPGD = service.getPGDByUUID(f.getUUID());
		
		CommonMessage message = xiugaicheck(dataPGD.getDataElement("state").getString());
		if(saveMessage(message, request)){
			return mapping.findForward(FW_SUCCESS);
		}else{
			
		f.setUUID(dataPGD.getDataElement("PK_ID").getString());
		
		f.setXiaoquname(dataPGD.getDataElement("xiaoquname").getString());
		f.setXingming(dataPGD.getDataElement("username").getString());
		f.setZhengjianhao("");
		f.setShoujuhao("");
		f.setFenguangqihao(dataPGD.getDataElement("fenguang").getString());
		f.setOnuzhuce("");
		f.setFanghao(dataPGD.getDataElement("userplace").getString());
		f.setKaijishijian("");
		f.setTingjishijian("");
		f.setKandai(dataPGD.getDataElement("tfkuandaidaikuan").getString());
		f.setDianshi(dataPGD.getDataElement("tfiptv").getString());
		f.setDianhua("");
		f.setYonghuming("");
		f.setMima("");
		f.setGuhua(dataPGD.getDataElement("telhaoma1").getString());
		f.setLainxidianhua(dataPGD.getDataElement("usertel").getString());
		f.setJiguiweizhi("");
		f.setOnumac(dataPGD.getDataElement("OUMMAC").getString());
		f.setJidinghemac(dataPGD.getDataElement("STBMAC").getString());
		f.setDianshiip("");
		f.setDianshiip2("");
		f.setDianshiip3("");
		f.setDianshiip4("");
		
		f.setDianhuaip(dataPGD.getDataElement("telip").getString());
		f.setKuandaiip(dataPGD.getDataElement("netip").getString());
		f.setDianhuavlan(dataPGD.getDataElement("telvaln").getString());
		f.setWangluovlan(dataPGD.getDataElement("netvaln").getString());
		f.setDianshivlan("");
		f.setQitivlan("");
		f.setBeizhu(dataPGD.getDataElement("beizhu").getString());
		}
		return mapping.findForward(FW_INIT_EDIT);
	}
	
	/**
	 * �ɹ�������
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
		
		String result = service.insert((ChugongdanEditForm)form);
		if(saveMessage(result,request)){
			return mapping.findForward(FW_ERROR_INSERT);
		}
		return mapping.findForward(FW_SUCCESS);
		
	}
	
	/**
	 * �޸�У��
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public CommonMessage xiugaicheck(String state)throws Exception{
		if(!state.equals("5")){
			return new CommonMessage(ErrorConstant.HUIDAN_PGD_STATE);
		}else{
			return new CommonMessage("SUCCESS");
		}
	}
	
	/**
	 * ���ݲ���У��
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public Boolean checkShuju(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(state.equals("1")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ʩ������У��
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public Boolean checkshigong(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(state.equals("5")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ���ϲ���У��
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public Boolean checkgongbi(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(state.equals("6")){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * �ᵥ����У��
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public Boolean checkjiedan(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		/*DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();*/
		/*
		 *2013-3-21�û���������Ϊ����������Ϣ�ġ�״̬����ʲô������ֱ�ӽᵥ����ʽ�� �����ˣ�lhh
		 */
	/*	if(state.equals("7")){
			return true;
		}else{
			return false;
		}*/
		return true;
	}
	/**
	 * �˵�У��
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public Boolean checkTuidan(String UUID) throws Exception{
		
		DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(!state.equals("7")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ��ת���˵��༭ҳ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward tuiDanEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ChugongdanEditForm f = (ChugongdanEditForm) form;
		String[] UUIDS = f.getUUIDS();
		if(UUIDS.length>1){
			if(saveMessage(ErrorConstant.TUIDANETIAOZHUAN_RRORY,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		if(!checkTuidan(UUIDS[0])){
			if(saveMessage(ErrorConstant.TUIDANSTATE, request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		f.setUUID(UUIDS[0]);
		return mapping.findForward("tdedit");
	}
	
	/**
	 * ִ���˵�����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward tuidan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ChugongdanEditForm f = (ChugongdanEditForm) form;
		String result = service.operatetuidan(f);
		if(saveMessage(result,request)){
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * ��ת���쳣�ᵥ�༭ҳ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward jieDanEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ChugongdanEditForm f = (ChugongdanEditForm) form;
		String[] UUIDS = f.getUUIDS();
		if(UUIDS.length>1){
			if(saveMessage(ErrorConstant.TUIDANETIAOZHUAN_RRORY,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		if(!checkjiedan(UUIDS[0])){
			if(saveMessage(ErrorConstant.JIEDANSTATE, request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		f.setUUID(UUIDS[0]);
		return mapping.findForward("jdedit");
	}
	
	/**
	 * ִ���˵�����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward jiedan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ChugongdanEditForm f = (ChugongdanEditForm) form;
		String result = service.jiedan(f);
		if(saveMessage(result,request)){
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * ״̬����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward operate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		String type = request.getParameter("type");
		ChugongdanEditForm f = (ChugongdanEditForm) form;
		String[] uuids =  f.getUUIDS();
		if(type.equals("1")){
			for (String uuid : uuids) {
				if(!checkShuju(uuid)){
					if(saveMessage(ErrorConstant.SHUJUWANGONGSTATE_ERRORY,request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
			}
			
			String result = service.operateShuJu(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		else if(type.equals("2")){
			for (String uuid : uuids) {
				if(!checkshigong(uuid)){
					if(saveMessage(ErrorConstant.SHIGONGSTATE,request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
				
			}
			
			String result = service.operateshigong(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		else if(type.equals("3")){
			for (String uuid : uuids) {
				if(!checkgongbi(uuid)){
					if(saveMessage(ErrorConstant.GONGBISTATE,request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
			}
			
			String result = service.operategongbi(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		else if(type.equals("4")){
			for (String uuid : uuids) {
				if(!checkjiedan(uuid)){
					if(saveMessage(ErrorConstant.JIEDANSTATE,request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
			}
			
			String result = service.operatejiedan(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
	/*	else if(type.equals("5")){
			for (String uuid : uuids) {
				if(!checkTuidan(uuid)){
					if(saveMessage(ErrorConstant.TUIDANSTATE, request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
			}
			String result = service.operatetuidan(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}*/
		
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * �ص�Ԥ����
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public ActionForward huidanImport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		ChugongdanEditForm fenguangform = (ChugongdanEditForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPGDByUUID(uuids[i]);
			//ȡ����ѡ�ɹ�����С��
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//ȡ����ѡ�ɹ����ĵ�ַ
			String dizhi = dataRow.getDataElement("userplace").getString();
			// ȡ����ѡ�ɹ�����״̬
			String state = dataRow.getDataElement("state").getString();
			// ȡ����ѡ�ɹ������ύ״̬
			String importstate = dataRow.getDataElement("importstate").getString();
			//ֻ�Ե�ǰ�ɹ������лص�Ԥ�������
			if("0".equals(importstate)&&"5".equals(state)) {
				service.preImport(uuids[i],dataRow);
			}else{
				wrongdata.append(xiaoqu+dizhi+"״̬���ύ״̬�������޷����лص�Ԥ���롣</br>");
			}
			
			//service.updateMask(uuids[i],request, "0");
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ص�Ԥ����ɹ���");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/**
	 * �ظ�Ԥ����
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public ActionForward huidanImportTwice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		ChugongdanEditForm fenguangform = (ChugongdanEditForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPGDByUUID(uuids[i]);
			//ȡ����ѡ�ɹ�����С��
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//ȡ����ѡ�ɹ����ĵ�ַ
			String dizhi = dataRow.getDataElement("userplace").getString();
			// ȡ����ѡ�ɹ�����״̬
			String state = dataRow.getDataElement("state").getString();
			// ȡ����ѡ�ɹ������ύ״̬
			String importstate = dataRow.getDataElement("importstate").getString();
			//ֻ�Ե�ǰ�ɹ������лص�Ԥ�������
			if("1".equals(importstate)&&"5".equals(state)) {
				service.preImport(uuids[i],dataRow);
			}else{
				wrongdata.append(xiaoqu+dizhi+"״̬���ύ״̬�������޷������ظ�Ԥ���롣</br>");
			}
			
			//service.updateMask(uuids[i],request, "0");
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ص�Ԥ����ɹ���");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
}
