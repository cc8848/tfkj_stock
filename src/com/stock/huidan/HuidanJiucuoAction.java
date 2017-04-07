package com.stock.huidan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.fenPeiIp.FenguangKeService;
import com.stock.kucun.KucunService;
import com.stock.paigongdan.PaiGongDanPreImportForm;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.Common;

public class HuidanJiucuoAction extends BusinessPaginationAction {
	
	private PaiGongDanService  srv = new PaiGongDanService();
	private HuidanDataService  service = new HuidanDataService();
	private HuidanService service1 = new HuidanService();
	FenguangKeService fgservice = new FenguangKeService();
	KucunService kucunService = new KucunService();
	/**
	 * ����С���б�
	 * 
	 * @param request
	 * @throws Exception
	 */
	private void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);

		List<CommonModule> dianxintaocan = srv.getDianxintaocan();
		request.setAttribute("dianxintaocan", dianxintaocan);
		
		List<CommonModule> shichangList = srv.getShichangAll();
		request.setAttribute("shichangList", shichangList);
		
		List<CommonModule> shichangtvList = srv.getShichangtvAll();
		request.setAttribute("shichangtvList", shichangtvList);
	}
	/**
	 * user data init method.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	/**
	 * get user data list by query.
	 * contain all combox data for init page data.
	 * 
	 * @param form
	 * @param first
	 * @param request
	 * @return DataSet<DataRow>
	 */
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=500;
		savedInRequest(request);
		HuidanForm f = (HuidanForm)form;
		f.setHidden();
		return firstPage(mapping, f, request, response);
	}
	/**
	 * framework package method.
	 * 
	 * @param mapping
	 * @return ActionForward
	 */
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}
	/**
	 * get user data list.
	 * contain all combox data for init page data.
	 * 
	 * @param form
	 * @param first
	 * @param request
	 * @return DataSet<DataRow>
	 */
	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		HuidanForm f =  (HuidanForm) form;
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		
		return service1.getResult(f, first, rows, "3");
	}
	/**
	 * get init or query result count.
	 * 
	 * @param request
	 * @throws Exception
	 */
	public int getResultCount(ActionForm form) throws Exception {
		return service1.getResultCount((HuidanForm) form, "3");
	}
	/**
	 * �ص��������༭
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		f.setUUIDHidden(f.getUUID());
		f.setXiaoquList(srv.getXiaoQuCodeAll());
		service1.getHuidanForm_ByID(f.getUUID(), f);
		savedInRequest(request);
		return mapping.findForward(FW_INIT_EDIT);

	}
	/**
	 * �ص�����༭�ύ����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward edit_save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		service1.updateHuidan(f, request);
		return mapping.findForward(FW_SUCCESS);

	}
	/**
	 * �ص�����������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward cuowudahui(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		service1.tuihui(f, request, "������", "2");
		return mapping.findForward(FW_SUCCESS);

	}
	/**
	 * �ص�����-����ȷ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward jiuzhengqueren(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		if(service1.get_yonghuzhuangtai(f).equals("������")){
			service1.tuihui(f, request, "�Ѱ�װ", "4");
			return mapping.findForward(FW_SUCCESS);
		}
		else{
			saveMessage( new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"ֻ���ύ'������'�ļ�¼��"), request);
			return mapping.findForward(FW_SUCCESS);
		}
		

	}
	/**
	 * �ص�����-��Ʊ���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward kaipiaochaifen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm) form;
		f.setUUIDHidden(f.getUUID());
		if (service1.get_yonghuzhuangtai(f).equals("��Ʊ���")) {
			service1.getHuidanForm_ByID(f.getUUID(), f);
			return mapping.findForward("chaifen");
		} else {
			saveMessage(new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ֻ���ύ'��Ʊ���'�ļ�¼��"), request);
			return mapping.findForward(FW_SUCCESS);
		}
	}
	/**
	 * �ص�����-��Ʊ��� ȷ�ϲ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 
	 */
	public ActionForward querenchaifen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm) form;
		String uuid = f.getUUIDHidden();
		f.setUUID(uuid);
		service1.getHuidanForm_ByID(uuid, f);
		
		HuidanForm huidan = new HuidanForm();
		huidan.setFeikaipiaoshouju(f.getFeikaipiaoshouju());
		huidan.setKaipiaoshouju(f.getKaipiaoshouju());
		huidan.setUUID(uuid);
		huidan.setChecks(f.getChecks());//checks��ǰ�洫������checkbox��ѡ������
		service1.getHuidanForm_ByID(uuid, huidan);

		service1.get_1(f);
		service1.get_2(huidan);
		service1.get_into(huidan, request, "4", "��ά��");
		service1.update_into(f, request, "�Ѱ�װ", "4");
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * һ���������ֹ����ʹ�ð�ťִ��action
	 *****/
	public ActionForward pipeipgd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm fenguangform = (HuidanForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getDataByUUID(uuids[i]);
			//ȡ����ѡ�ɹ�����С��
			String xiaoqu = dataRow.getDataElement("xiaoqu").getString();
			//ȡ����ѡ�ɹ����ĵ�ַ
			String dizhi = dataRow.getDataElement("dizhi").getString();
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String currentFenguang = dataRow.getDataElement("fenguang").getString();
			//ֻ�Ե�ǰ�ֹ��Ƿǿշ�0�Ľ��в���
			if(currentFenguang==null||"".equals(currentFenguang)||"��".equals(currentFenguang)||"0".equals(currentFenguang)) {
				String fenguangID = fgservice.pipeipgd(xiaoqu, dizhi,request);
				if(fenguangID.contains("@")) {
					//���µ�ǰ�ɹ�����Ϣ
					fgservice.updateJiucuofenguang(uuids[i],fenguangID.split("@")[0],fenguangID.split("@")[1]);
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
		HuidanForm fenguangform = (HuidanForm) form;
		String[] uuids = fenguangform.getUUIDS();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getDataByUUID(uuids[i]);
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String currentFenguang = dataRow.getDataElement("fenguangID").getString();
			if(currentFenguang!=null) {
				fgservice.recyclefenguang(currentFenguang,request);
			}
			fgservice.updateJiucuofenguang(uuids[i],"", "");
		}
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "�ֹ���ճɹ���");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * һ��������ά�޽�������豸������ťִ��action
	 *****/
	public ActionForward weijiugenghuan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm huidanform = (HuidanForm) form;
		String devicekbn = request.getParameter("device");
		String[] uuids = huidanform.getUUIDS();
		String xiaoqu = "";
		String dizhi = "";
		String onumac = "";
		String stbmcid = "";
		String cp1 = "";
		String cp2 = "";
		CommonMessage message = null;
		
		/**
		 	�����ѡС������ַ��onumac��STB MCIDһ���Լ��
		*/
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getDataByUUID(uuids[i]);
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String xiaoqu1 = dataRow.getDataElement("xiaoqu").getString();
			String dizhi1 = dataRow.getDataElement("dizhi").getString();
			String onumac1 = dataRow.getDataElement("onumac").getString();
			String stbmcid1 = dataRow.getDataElement("stbmcid").getString();
			String cp11 = dataRow.getDataElement("CommunityPile_ID").getString();
			String cp21 = dataRow.getDataElement("CommunityPile_ID2").getString();
			if(i!=0) {
//				if("0".equals(devicekbn)) {
					if(!(xiaoqu1.equals(xiaoqu)&&dizhi1.equals(dizhi)&&onumac1.equals(onumac))) {
						message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"С������ַ��onumac��һ�£�����ʧ�ܣ�");
						saveMessage(message, request);
						return mapping.findForward(FW_SUCCESS);
					}
//				}else{
//					if(!(xiaoqu1.equals(xiaoqu)&&dizhi1.equals(dizhi)&&stbmcid1.equals(stbmcid))) {
//						message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"С������ַ��STB MCID��һ�£�����ʧ�ܣ�");
//						saveMessage(message, request);
//						return mapping.findForward(FW_SUCCESS);
//					}
//				}
			}else{
				xiaoqu = xiaoqu1;
				dizhi = dizhi1;
				onumac = onumac1;
				stbmcid = stbmcid1;
				cp1 = cp11;
				cp2 = cp21;
			}
		}
		
		/**
		 * ����Ƿ����С����ַonumac��STBMCID��ͬ��δ��ѡѡ�����Ŀ
		 */
		List<DataRow> allhuidan = new ArrayList<DataRow>();
//		if("0".equals(devicekbn)) {
			allhuidan =service.getDataByUUIDOnu(xiaoqu, dizhi, onumac);
//		}else{
//			allhuidan =service.getDataByUUIDStb(xiaoqu, dizhi, stbmcid);
//		}
		if(allhuidan.size()!=uuids.length) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"����δ��ѡ�����Ŀ������ʧ�ܣ�");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}
		
		/**
		 * ����ڲ�ѯά�޽����Ƿ������ӦС����ַonumac��STBMCIDΪ�ǿշ�0״̬�ǡ�ά�޴���������Ŀ
		 */
		List<DataRow> allweixiu = new ArrayList<DataRow>();
//		if("0".equals(devicekbn)) {
			allweixiu =service.getWXDataByUUIDOnu(xiaoqu, dizhi);
//		}else{
//			allweixiu =service.getWXDataByUUIDStb(xiaoqu, dizhi);
//		}
		if(allweixiu==null||allweixiu.size()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"ά�޴��������ݲ����ڣ�����ʧ�ܣ�");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}else if(allweixiu.size()>1){
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"���ڶ���ά�޴��������ݣ�����ʧ�ܣ����ȹر�һ��ά�޴�����");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}
		
		/**
		 * ִ�и�������
		 * 1�����°�װ��Ϣ����ѡ��״̬
		 * 2������Ӧά����Ϣ��Ϊ����ά�ޡ����豸״̬��Ϊ���Ѱ�װ��
		 * 3������Ӧά���豸��Ϣ���µ���װ��Ϣ����	
		 */
//		if("0".equals(devicekbn)) {
			kucunService.zhuangTaiChange(cp1,huidanform.getEqsta(),xiaoqu,"��װ��",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
			service.updateWXByUUID(allweixiu.get(0).getDataElement("PK_ID").getString(), "��ά��");
			kucunService.zhuangTaiChange(allweixiu.get(0).getDataElement("CommunityPile_ID").getString(),"4",xiaoqu,"��װ��",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
			for(int i=0;i<uuids.length;i++) {
				service.updateHuidanEQByUUID(uuids[i], "0", allweixiu.get(0).getDataElement("CommunityPile_ID").getString(), allweixiu.get(0).getDataElement("onumac").getString());
			}
//		}else{
//			kucunService.zhuangTaiChange(cp2,huidanform.getEqsta(),xiaoqu,"��װ��",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
//			service.updateWXByUUID(allweixiu.get(0).getDataElement("PK_ID").getString(), "��ά��");
//			kucunService.zhuangTaiChange(allweixiu.get(0).getDataElement("CommunityPile_ID2").getString(),"5",xiaoqu,"��װ��",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
//			for(int i=0;i<uuids.length;i++) {
//				service.updateHuidanEQByUUID(uuids[i], "1", allweixiu.get(0).getDataElement("CommunityPile_ID2").getString(), allweixiu.get(0).getDataElement("stbmcid").getString());
//			}
//		}
		
		
		message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ά�޽�������豸�����ɹ���");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * һ��������ά�޽�������豸������ťִ��action
	 *****/
	public ActionForward weijiugenghuanSTB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm huidanform = (HuidanForm) form;
		String uuid = huidanform.getUUID();
		CommonMessage message = null;
		
		/**
		 	�����ѡС������ַ��onumac��STB MCIDһ���Լ��
		*/
			DataRow dataRow = service.getDataByUUID(uuid);
			// ȡ����ѡ�ɹ����ĵ�ǰ�ֹ���Ϣ
			String xiaoqu = dataRow.getDataElement("xiaoqu").getString();
			String dizhi = dataRow.getDataElement("dizhi").getString();
			String stbmcid = dataRow.getDataElement("stbmcid").getString();
			String cp1 = dataRow.getDataElement("CommunityPile_ID").getString();
			String cp2 = dataRow.getDataElement("CommunityPile_ID2").getString();
		
		/**
		 * ����Ƿ����С����ַonumac��STBMCID��ͬ��δ��ѡѡ�����Ŀ
		 */
//		List<DataRow> allhuidan = new ArrayList<DataRow>();
//		if("0".equals(devicekbn)) {
//			allhuidan =service.getDataByUUIDOnu(xiaoqu, dizhi, onumac);
//		}else{
//			allhuidan =service.getDataByUUIDStb(xiaoqu, dizhi, stbmcid);
//		}
//		if(allhuidan.size()!=uuids.length) {
//			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"����δ��ѡ�����Ŀ������ʧ�ܣ�");
//			saveMessage(message, request);
//			return mapping.findForward(FW_SUCCESS);
//		}
		
		/**
		 * ����ڲ�ѯά�޽����Ƿ������ӦС����ַonumac��STBMCIDΪ�ǿշ�0״̬�ǡ�ά�޴���������Ŀ
		 */
		List<DataRow> allweixiu = new ArrayList<DataRow>();
		allweixiu =service.getWXDataByUUIDStb(xiaoqu, dizhi);
		if(allweixiu==null||allweixiu.size()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"ά�޴��������ݲ����ڣ�����ʧ�ܣ�");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}else if(allweixiu.size()>1){
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"���ڶ���ά�޴��������ݣ�����ʧ�ܣ����ȹر�һ��ά�޴�����");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}
		
		/**
		 * ִ�и�������
		 * 1�����°�װ��Ϣ����ѡ��״̬
		 * 2������Ӧά����Ϣ��Ϊ����ά�ޡ����豸״̬��Ϊ���Ѱ�װ��
		 * 3������Ӧά���豸��Ϣ���µ���װ��Ϣ����	
		 */
			kucunService.zhuangTaiChange(cp2,huidanform.getEqsta(),xiaoqu,"��װ��",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
			service.updateWXByUUID(allweixiu.get(0).getDataElement("PK_ID").getString(), "��ά��");
			kucunService.zhuangTaiChange(allweixiu.get(0).getDataElement("CommunityPile_ID2").getString(),"4",xiaoqu,"��װ��",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
			service.updateHuidanEQByUUID(uuid, "1", allweixiu.get(0).getDataElement("CommunityPile_ID2").getString(), allweixiu.get(0).getDataElement("stbmcid").getString());
		
		
		message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "ά�޽�������豸�����ɹ���");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
}
