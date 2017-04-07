package com.hrbank.business.common;

public class CommonMessage {

	private String messageCode;
	private String[] params;

	public CommonMessage() {

	}

	public CommonMessage(String messageCode) {
		this();
		this.messageCode = messageCode;
	}

	public CommonMessage(String messageCode, String... params) {
		this(messageCode);
		this.params = params;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public void clearParams() {
		this.params = null;
	}
}
