package com.stock.weihu;

import com.hrbank.business.frame.BusinessPaginationAction;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangqingxiang on 2016/6/20.
 */
public class RediusLogAction  extends BusinessPaginationAction {
    RediusService rediusService=new RediusService();
    @Override
    public DataSet<DataRow> getResult(ActionForm actionForm, int first, int rows) throws Exception {
        return rediusService.getResult((RediusLogForm) actionForm, first, rows);
    }

    @Override
    public int getResultCount(ActionForm actionForm) throws Exception {
        return rediusService.getResultCount((RediusLogForm) actionForm);
    }

    @Override
    public ActionForward getActionForward(ActionMapping actionMapping) {
        return actionMapping.findForward(FW_INIT);
    }

    /**
     * ????????
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

        RediusLogForm f = (RediusLogForm) form;
        return firstPage(mapping, form, request, response);
    }

    /**
     * ???
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward query(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        RediusLogForm f = (RediusLogForm) form;
        return firstPage(mapping, form, request, response);
    }
}
