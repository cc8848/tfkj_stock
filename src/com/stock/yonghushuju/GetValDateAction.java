package com.stock.yonghushuju;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;

public class GetValDateAction extends BusinessAction {
    private CommonDao dao = new CommonDao();

    public ActionForward test(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	try {
	    String string = "";
	    String xiaoqu = request.getParameter("xiaoqu");
	    xiaoqu = java.net.URLDecoder.decode(xiaoqu, "utf-8");

	    String dizhi = request.getParameter("dizhi");
	    dizhi = java.net.URLDecoder.decode(dizhi, "utf-8");

	    ParameterSet set = new ParameterSet();
	    set.add("xiaoqu", "@xiaoqu", xiaoqu);
	    set.add("dizhi", "@dizhi", "%" + dizhi + "%");
	    DataSet<DataRow> executeQuery = dao.executeQuery("RLIKExiaoqudizhi", set);
	    for (int i = 0; i < executeQuery.size(); i++) {
		string += executeQuery.get(i).getDataElement("dz").getString() + "|";
	    }
	    if (string.length() > 1) {
		string = string.substring(0, string.length() - 1);
	    }
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(string);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return mapping.findForward("null");

    }

    /**
     * 异步获取出所有的账户信息
     */
    public ActionForward countNum(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	try {
	    String string = "";
	    String stringyouxiao = "";
	    String xiaoqu = request.getParameter("xiaoqu");
	    xiaoqu = java.net.URLDecoder.decode(xiaoqu, "utf-8");

	    String dizhi = request.getParameter("dizhi");
	    dizhi = java.net.URLDecoder.decode(dizhi, "utf-8");
	    
	    String zhanghao = request.getParameter("zhanghao");
	    zhanghao = java.net.URLDecoder.decode(zhanghao, "utf-8");
	    
	    String wangluopara = request.getParameter("wangluo");
	    wangluopara = java.net.URLDecoder.decode(wangluopara, "utf-8");

	    ParameterSet set = new ParameterSet();
	    set.add("xiaoqu", "@xiaoqu", xiaoqu);
	    set.add("dizhi", "@dizhi", "%" + dizhi + "%");
	    DataSet<DataRow> executeQuery = dao.executeQuery("findCounNum", set);
	    JiaofeiDataFrom jfForm = (JiaofeiDataFrom) form;
	    for (int i = 0; i < executeQuery.size(); i++) {
				DataRow obj = executeQuery.get(i);
				String wangluo = obj.getDataElement("wangluo").getString();
				String wangluoip = obj.getDataElement("wangluoip").getString();
				String dianshiip = obj.getDataElement("dianhuaip").getString();
				 if (wangluopara.equals(wangluo)||!"0".equals(wangluo)) {
					 
				 
				if (zhanghao.equals(wangluoip) || zhanghao.equals(dianshiip)) {
					String youxiaoshijian = obj.getDataElement("youxiaoshijian").getString();
					Date youxiaodate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(youxiaoshijian);
					Date nowdate = new Date();
					String youxiaodateString = new SimpleDateFormat("yyyy-MM-dd").format(youxiaodate);
					String nowdateString = new SimpleDateFormat("yyyy-MM-dd").format(nowdate);
					stringyouxiao = new SimpleDateFormat("yyyy-MM-dd").format(youxiaodate);
					if(youxiaodate.before(nowdate)&&(!youxiaodateString.equals(nowdateString))) {
						string =  new SimpleDateFormat("yyyy-MM-dd").format(nowdate);
					}else{
						Calendar cal = Calendar.getInstance();
						cal.setTime(youxiaodate);
						cal.add(Calendar.DATE, 1);
						String monthString = String.valueOf(cal.get(Calendar.MONTH)+1);
						if(monthString.length()==1) {
							monthString = "0" + monthString;
						}
						String dateString = String.valueOf(cal.get(Calendar.DATE));
						if(dateString.length()==1) {
							dateString = "0" + dateString;
						}
						string = cal.get(Calendar.YEAR) + "-" + monthString + "-" + dateString;
					}
				}
				 }
			}
	    string = string + "###" + stringyouxiao;
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html");
	    response.getWriter().print(string);
	    // response.setCharacterEncoding("UTF-8");
	    // response.getWriter().write(string);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return mapping.findForward("null");

    }

    public ActionForward getDaikuan(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	try {
	    String string = "";
	    String shichangleixing = request.getParameter("shichangleixing");
	    shichangleixing = java.net.URLDecoder.decode(shichangleixing, "utf-8");
	    if (shichangleixing.equals("0")) {
		shichangleixing = "";
	    }
	    String tfkuandaidaikuan = request.getParameter("tfkuandaidaikuan");
	    tfkuandaidaikuan = java.net.URLDecoder.decode(tfkuandaidaikuan, "utf-8");
	    if (tfkuandaidaikuan.equals("0")) {
		tfkuandaidaikuan = "";
	    }
	    ParameterSet set = new ParameterSet();
	    set.add("leixing", "@leixing", shichangleixing);
	    set.add("daikuan", "@daikuan", tfkuandaidaikuan);
	    DataSet<DataRow> executeQuery = dao.executeQuery("getShichangleixingAndDaikuan", set);
	    for (int i = 0; i < executeQuery.size(); i++) {
		String shichangName = executeQuery.get(i).getDataElement("shichangName").getString();
		string += "," + shichangName;
	    }
	    string = string.replaceFirst(",", "");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(string);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return mapping.findForward("null");

    }
}
