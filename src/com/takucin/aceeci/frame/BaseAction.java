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
 * 控制器层的基类，此类负责和前台交互，JSP页面数据封装，错误信息封装和跳转的工作.
 * 提供对动作方法执行前后的通用封装，并对数据库连接做统一的关闭操作.
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
	 * 在Action的动作方法执行前，执行此方法.
	 */
	public abstract ActionForward before(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * 在Action的动作方法执行后，执行此方法.
	 */
	public abstract ActionForward after(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * 重写父类的方法，实现对before和after方法的封装.
	 * 自定义Action方法和before以及after方法都拥有ActionForward返回值，
	 * 如果子类重写了after方法，并且after方法的返回值不为null，那么将根据after方法的返回值跳转，
	 * 否则，依次按照自定义Action方法和before方法的顺序跳转.
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
	 * 关闭当前线程的数据库连接.
	 * 
	 * @throws Exception 如果发生任何错误抛出此异常.
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
