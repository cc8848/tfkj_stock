package com.stock.total;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.paigongdan.PaiGongDanService;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class TotalRibaoShouruAction extends BusinessPaginationAction{
	TotalService  service = new TotalService();
	PaiGongDanService  service2 = new PaiGongDanService();
	YonghuDataService serviceData = new YonghuDataService();
	@Override
	public ActionForward getActionForward(ActionMapping mapping) {
		// TODO Auto-generated method stub
		return mapping.findForward(FW_INIT);
	}

	@Override
	public DataSet<DataRow> getResult(ActionForm form, int arg1, int arg2)
			throws Exception {
		TotalForm f = (TotalForm) form;
		f.setHidden();
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		List<CommonModule> yys = new ArrayList<CommonModule>();
		CommonModule commonModule = new CommonModule();
		commonModule.setKey("�ϼ�");
		commonModule.setValue("�ϼ�");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("�췿");
		commonModule.setValue("�췿");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("����");
		commonModule.setValue("����");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("��ͨ");
		commonModule.setValue("��ͨ");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("��ͨ");
		commonModule.setValue("��ͨ");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("���");
		commonModule.setValue("���");
		yys.add(commonModule);
		f.setYunyingshangList(yys);
		DataSet<DataRow> dataSet = service.getShouruDataSet(f);
//		return service.getMingxiDataSet(f, arg1, arg2);
		return dataSet;
	}

	@Override
	public int getResultCount(ActionForm form) throws Exception {
		// TODO Auto-generated method stub
//		TotalForm f = (TotalForm) form;
//		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
//		f.setXiaoquList(xiaoquList);
//		int i= service.getMingxiDataCount(f);
//		return i;
		return 0;
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows = 100;
		savedInRequest(request);
		TotalForm f = (TotalForm) form;
		f.setHidden();
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return firstPage(mapping, form, request, response);
//		return getActionForward(mapping);
	}
	public ActionForward query(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		savedInRequest(request);
		TotalForm f = (TotalForm) form;
		f.setHidden();
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return firstPage(mapping, form, request, response);
	}
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
		List<CommonModule> statusList = serviceData.getStatusCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);
		request.setAttribute("statusList", statusList);
		List<CommonModule> gzlb = new ArrayList<CommonModule>();
		CommonModule commonModule = new CommonModule();
		commonModule.setKey("����");
		commonModule.setValue("�Ѱ�װ");
		gzlb.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("�ռ�");
		commonModule.setValue("Ӧ�ռ�");
		gzlb.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("ά��");
		commonModule.setValue("��ά��");
		gzlb.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("����");
		commonModule.setValue("������");
		gzlb.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("�˶�");
		commonModule.setValue("���˶�");
		gzlb.add(commonModule);
		request.setAttribute("gzlblist",gzlb);
		List<CommonModule> yys = new ArrayList<CommonModule>();
		commonModule = new CommonModule();
		commonModule.setKey("�췿");
		commonModule.setValue("�췿");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("����");
		commonModule.setValue("����");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("��ͨ");
		commonModule.setValue("��ͨ");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("��ͨ");
		commonModule.setValue("��ͨ");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("���");
		commonModule.setValue("���");
		yys.add(commonModule);
		request.setAttribute("yysList",yys);
	}
}
