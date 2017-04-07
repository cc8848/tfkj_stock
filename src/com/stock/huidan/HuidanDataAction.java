/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data init and query.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2013-03-18   Li.Hai-Han            Create
 */
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

/**
 * user data init and query..
 * 
 * @author Zhu.Xiao-Lei
 *
 */
public class HuidanDataAction extends BusinessPaginationAction{
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
		
		return service1.getResult(f, first, rows, "0");
	}

	/**
	 * get init or query result count.
	 * 
	 * @param request
	 * @throws Exception
	 */
	public int getResultCount(ActionForm form) throws Exception {
		return service1.getResultCount((HuidanForm) form, "0");
	}
	/**
	 * 编辑回单
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward huidanEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HuidanForm f =  (HuidanForm) form;
		String UUID = f.getUUID();
		f.setUUIDHidden(UUID);
		f = service1.getHuidanForm_ByID(UUID, f);
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		service1.shebeiEdit(f);
		return mapping.findForward(FW_INIT_EDIT);
	}
	/**
	 * 回单查看详情
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward huidanLook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f =  (HuidanForm) form;
		String UUID = f.getUUID();
		f = service1.getHuidanForm_ByID(UUID, f);
		service1.shebeiEdit(f);
		return mapping.findForward(FW_DEL_DETAIL);
	}
	/**
	 * 用于编辑 更新回单
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update_Huidan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		service1.updateHuidan((HuidanForm) form, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
        /**
         * 删除回单条目
         * @param mapping
         * @param form
         * @param request
         * @param response
         * @return
         * @throws Exception
         */
	public ActionForward huidanDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		service1.deleteHuidan((HuidanForm)form, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/**
	 * 回单提交界面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward huidanSub(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f =  (HuidanForm) form;
		service1.updateHuidan(f, request, "2");
		return mapping.findForward(FW_SUCCESS);
	}
}
