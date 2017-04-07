package com.stock.huidan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class HuidanSubAction extends BusinessPaginationAction{
	private PaiGongDanService  srv = new PaiGongDanService();
	private HuidanDataService  service = new HuidanDataService();
	private HuidanService service1 = new HuidanService();
	
	/**
	 * 放入小区列表
	 * 
	 * @param request
	 * @throws Exception
	 */
	private void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);
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
		DataSet<DataRow> q = service1.getResult(f, first, rows, "2");
		return service1.getResult(f, first, rows, "2");
	}
	/**
	 * get init or query result count.
	 * 
	 * @param request
	 * @throws Exception
	 */
	public int getResultCount(ActionForm form) throws Exception {
		return service1.getResultCount((HuidanForm) form, "2");
	}
        /**
         * 回单错误退回
         * @param mapping
         * @param form
         * @param request
         * @param response
         * @return
         * @throws Exception
         */
	public ActionForward errorBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		if(f.getUUID() !=  null){
			service1.updateHuidan(f, request, "0");
		}
		return mapping.findForward(FW_SUCCESS);

	}
	/**
	 * 回单退回
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward huidanBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		f.setUUIDHidden(f.getUUID());
		//String yewu = service1.getYewuByUUID(f.getUUID());
		//f.setYewuHidden(yewu);
		return mapping.findForward("del.detail");

	}
	/**
	 * 回单退回提交
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward huidanBack_update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		f.setUUID(f.getUUIDHidden());
		service1.updateHuidan(f, request, "4");
		return mapping.findForward(FW_SUCCESS);

	}
	/**
	 * 回单提交确认信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward huidanImport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		f.setUUIDHidden(f.getUUID());
		service1.getHuidanForm_ByID(f.getUUID(), f);
		return mapping.findForward(FW_INIT_EDIT);

	}
	/**
	 * 处理正常提交
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update_zhengchang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		f.setUUID(f.getUUIDHidden());
		service1.update_tijiao(f, request, "已安装", "4");
		return mapping.findForward(FW_SUCCESS);

	}
	/**
	 * 处理开票拆分提交
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update_chaifen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		f.setUUID(f.getUUIDHidden());
		service1.update_tijiao(f, request, "开票拆分", "3");
		return mapping.findForward(FW_SUCCESS);

	}
	/**
	 * 处理纠错修改提交
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update_jiucuo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		f.setUUID(f.getUUIDHidden());
		service1.update_tijiao(f, request, "纠错中", "3");
		return mapping.findForward(FW_SUCCESS);

	}
	

}
