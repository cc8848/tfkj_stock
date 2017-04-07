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
		commonModule.setKey("合计");
		commonModule.setValue("合计");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("天房");
		commonModule.setValue("天房");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("电信");
		commonModule.setValue("电信");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("联通");
		commonModule.setValue("联通");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("铁通");
		commonModule.setValue("铁通");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("广电");
		commonModule.setValue("广电");
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
		commonModule.setKey("开户");
		commonModule.setValue("已安装");
		gzlb.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("收件");
		commonModule.setValue("应收件");
		gzlb.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("维修");
		commonModule.setValue("已维修");
		gzlb.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("续费");
		commonModule.setValue("已续费");
		gzlb.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("退订");
		commonModule.setValue("已退订");
		gzlb.add(commonModule);
		request.setAttribute("gzlblist",gzlb);
		List<CommonModule> yys = new ArrayList<CommonModule>();
		commonModule = new CommonModule();
		commonModule.setKey("天房");
		commonModule.setValue("天房");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("电信");
		commonModule.setValue("电信");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("联通");
		commonModule.setValue("联通");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("铁通");
		commonModule.setValue("铁通");
		yys.add(commonModule);
		commonModule = new CommonModule();
		commonModule.setKey("广电");
		commonModule.setValue("广电");
		yys.add(commonModule);
		request.setAttribute("yysList",yys);
	}
}
