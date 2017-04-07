package com.hrbank.business.frame;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.takucin.aceeci.frame.PaginationAction;

public abstract class BusinessPaginationAction extends PaginationAction {

	/**
	 * 在Action的动作方法执行前，执行此方法.
	 */
	public ActionForward before(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

	/**
	 * 在Action的动作方法执行后，执行此方法.
	 */
	public ActionForward after(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

	public void saveMessageNoCheck(String result, HttpServletRequest request) {
		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(result));
		saveMessages(request, messages);
	}

	public void saveMessageNoCheck(CommonMessage message, HttpServletRequest request) {
		ActionMessages messages = new ActionMessages();
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(message.getMessageCode(), message.getParams()));
		saveMessages(request, messages);
	}

	public boolean saveMessage(String result, HttpServletRequest request) {
		if (result != Constant.SUCCESS) {
			saveMessageNoCheck(result, request);
			return true;
		}
		return false;
	}

	public boolean saveMessage(CommonMessage message, HttpServletRequest request) {
		if (message.getMessageCode() != Constant.SUCCESS) {
			saveMessageNoCheck(message, request);
			return true;
		}
		return false;
	}
}
