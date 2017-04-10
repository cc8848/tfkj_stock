package com.stock.yonghushuju.action;

import com.hrbank.business.frame.BusinessAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.util.StringUtils;
import com.stock.yonghushuju.ImportDataService;
import com.stock.yonghushuju.JiaofeiDataFrom;
import com.stock.yonghushuju.YonghuDataService;
import com.stock.yonghushuju.service.JiaoFeiService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wangqingxiang on 2017/4/10.
 */
public class JiaoFeiAction extends BusinessAction {

    PaiGongDanService service2 = new PaiGongDanService();
    JiaoFeiService jiaoFeiService=new JiaoFeiService();

    /**
     * 跳转到添加申请页面 续费维修管理----申请续费----申请续费按钮之后页面
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward form(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        initForm(form);
        String sourceType=((JiaofeiDataFrom) form).getSourceType();
        if(StringUtils.isNotBlank(sourceType)&&sourceType.equals("2")){
            return mapping.findForward(FW_INIT_INSERT);
        }else{
            return mapping.findForward(FW_INIT_INSERT2);
        }

    }



    private void initForm(ActionForm form) throws Exception {
        List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
        List<CommonModule> shichangList = service2.getShichangAll();
        List<CommonModule> shichangtvList = service2.getShichangtvAll();
        JiaofeiDataFrom f = (JiaofeiDataFrom) form;
        if (f.getNowdata() == null || f.getNowdata().equals("")) {
            f.setNowdata(Common.getDate("yyyy-MM-dd HH:mm:ss"));
        }
        if (f.getShoukuanshijian() == null || f.getShoukuanshijian().equals("")) {
            f.setShoukuanshijian(Common.getDate("yyyy-MM-dd"));
        }
        f.setXiaoquList(xiaoquList);
        f.setShichangList(shichangList);
        f.setShichangtvList(shichangtvList);
    }


    /**
     * 保存申请
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String countNum = request.getParameter("countNum");
        String result = jiaoFeiService.saveApply(countNum,form);
        if (saveMessage(result, request)) {
            List<CommonModule> xiaoquList = service2.getXiaoQuCodeAll();
            JiaofeiDataFrom f = (JiaofeiDataFrom) form;
            f.setXiaoquList(xiaoquList);
            return mapping.findForward(FW_ERROR_INSERT);
        }
        return mapping.findForward(FW_SUCCESS);
    }


}
