package com.takucin.aceeci.frame;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.MessageResources;

import com.hrbank.business.employee.Employee;
import com.takucin.aceeci.common.Constant;

/**
 * ��������Ļ��࣬���ฺ���ǰ̨������JSPҳ�����ݷ�װ��������Ϣ��װ����ת�Ĺ���.
 * �ṩ�Զ�������ִ��ǰ���ͨ�÷�װ���������ݿ�������ͳһ�Ĺرղ���.
 */
public abstract class BaseAction extends DispatchAction {

	private Log log = LogFactory.getLog(this.getClass());

	public static String FW_SUCCESS = "success";
	public static String FW_ERROR = "error";
	public static String FW_INIT = "init";
	public static String FW_SELF = "self";
	public static String FW_BACK = "back";
	public static String FW_DETAIL = "detail";
	public static String FW_INIT_EDIT = "init.edit";
	public static String FW_INIT_INSERT = "init.insert";
	public static String FW_INIT_CHANGEPWD = "init.changePwd";
	public static String FW_INIT_TUIDING = "init.tuiding";
	public static String FW_INIT_INSERT2 = "init.insert2";
	public static String FW_LOGIN_TIMEOUT = "login.timeout";
	public static String FW_ERROR_QUERY = "error.query";
	public static String FW_ERROR_EDIT = "error.edit";
	public static String FW_ERROR_INSERT = "error.insert";
	public static String FW_ERROR_LOGIN = "error.login";
	public static String FW_INIT_DETAIL = "init.detail";
	public static String FW_DEL_DETAIL = "del.detail";
	public static String FW_INIT_BACK = "init.back";
	public static String FW_MEMBER = "init.member";
	public static String FW_INIT_DETAILALL = "init.detailall";
	public static String FW_DETAIL_ALL = "detailall";
	public static final String FW_INIT_UPLOAD = "init.upload";

	/**
	 * ��Action�Ķ�������ִ��ǰ��ִ�д˷���.
	 */
	public abstract ActionForward before(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * ��Action�Ķ�������ִ�к�ִ�д˷���.
	 */
	public abstract ActionForward after(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * ��д����ķ�����ʵ�ֶ�before��after�����ķ�װ.
	 * �Զ���Action������before�Լ�after������ӵ��ActionForward����ֵ��
	 * ���������д��after����������after�����ķ���ֵ��Ϊnull����ô������after�����ķ���ֵ��ת��
	 * �������ΰ����Զ���Action������before������˳����ת.
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if(!mapping.getPath().equals("/login") && !mapping.getPath().equals("/logout")){
			Employee emp = (Employee)request.getSession().getAttribute(Constant.LOGIN_USER);
			if(emp == null){
				return mapping.findForward(FW_LOGIN_TIMEOUT);
			}
		}
		
		getUserInfo(request);
		
		try {
			ActionForward beforeForward = before(mapping, form, request,
					response);
			ActionForward forward = super.execute(mapping, form, request,
					response);
			ActionForward afterForward = after(mapping, form, request, response);
			if (afterForward != null) {
				return afterForward;
			}
			if (forward != null) {
				return forward;
			}
			if (beforeForward != null) {
				return beforeForward;
			}
		} catch (Exception e) {
			log.error(e);
			throw e;
		} finally {
			closeConnection();
			destroyUser();
		}
		return null;
	}

	/**
	 * �رյ�ǰ�̵߳����ݿ�����.
	 * 
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	protected void closeConnection() throws Exception {
		try {
			ContainerManager.closeConnection();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	protected Employee getUserInfo(){
		return ContainerManager.currentUser(null);
	}
	
	protected Employee getUserInfo(HttpServletRequest request){
		return ContainerManager.currentUser(request);
	}
	
	protected void destroyUser() throws Exception{
		try {
			ContainerManager.destroyUser();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	protected void println(HttpServletResponse response,String text) throws Exception{
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		out.println(text);
		out.close();
	}
	
	protected void printXml(HttpServletResponse response, String xml) throws Exception{
		response.setContentType("text/xml;charset=gbk");
		response.setHeader("Cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		out.write(xml);
		out.flush();
	}
	
	protected String getMessage(HttpServletRequest request,String key){
		MessageResources ms = getResources(request, "SalesMessagesResources");
		return ms.getMessage(key);
	}
	
	protected String getPath(HttpServletRequest request,String key){
		MessageResources ms = getResources(request, "BusinessResources");
		return ms.getMessage(key);
	}
	
	protected ActionForward forward(String path,Map<String,String> params){
		String name = path;
		if(params != null){
			int count = 0;
			Iterator<String> it = params.keySet().iterator();
			while(it.hasNext()){
				if(count == 0){
					name += "?";
				}else{
					name += "&";
				}
				String key = it.next();
				String value = params.get(key);
				name += key + "=" + value;
				count++;
			}
		}
		
		return new ActionForward(name);
	}
}
