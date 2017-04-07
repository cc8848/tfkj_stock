package com.hrbank.business.common;

import java.util.ArrayList;
import java.util.List;

public class Validator {

	private List<String> errors = new ArrayList<String>();

	public void initErrors() {
		errors.clear();
	}

	public String isNumber(String value, String errorCode) {
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return errorCode;
		}
		return null;
	}

	public String isOutOfBonds(String value, int minValue, int maxValue, String errorCode) {
		try {
			double d = Double.parseDouble(value);
			if (d < minValue || d > maxValue) {
				return errorCode;
			}
		} catch (NumberFormatException e) {
			return errorCode;
		}
		return null;
	}

	public String isDecimalPointOutOfBonds(String value, int size, String errorCode) {
		int index = value.indexOf(".");
		if (index == -1) {
			return null;
		}
		String d = value.substring(index + 1);
		if (d.length() <= size) {
			return null;
		}
		return errorCode;
	}

	public String isEmpty(String value, String errorCode) {
		if (value == null || value.equals("")) {
			return errorCode;
		}
		return null;
	}

	public String isEffectiveRegex(String value, String regex, String errorCode) {
		if (!value.matches(regex)) {
			return errorCode;
		}
		return null;
	}

	public String isOutOfLength(String value, int length, String errorCode) {
		int valueLength = value.getBytes().length;
		if (valueLength > length) {
			return errorCode;
		}
		return null;
	}

	public String isEquals(String value, String equalsValue, String errorCode) {
		if (value.equals(equalsValue)) {
			return errorCode;
		}
		return null;
	}

	public void addError(String error) {
		if (error != null) {
			errors.add(error);
		}
	}

	public boolean hashError() {
		if (errors.size() > 0) {
			return true;
		}
		return false;
	}

	public String getErrorCode() {
		if (errors.size() == 0) {
			return null;
		}
		return errors.get(0);
	}

	public List<String> getErrors() {
		return errors;
	}
}
