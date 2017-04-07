package com.takucin.aceeci.transfer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class TransferEvent {

	private ActionMapping mapping;
	private ActionForm form;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public TransferEvent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		this.mapping = mapping;
		this.form = form;
		this.request = request;
		this.response = response;
	}
	
	public ActionMapping getMapping() {
		return mapping;
	}
	public ActionForm getForm() {
		return form;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
}
