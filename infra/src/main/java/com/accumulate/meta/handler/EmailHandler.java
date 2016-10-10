package com.accumulate.meta.handler;

import java.util.regex.Pattern;

public class EmailHandler implements DataTypeHandler {
	private static Pattern p = Pattern
			.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");

	@Override
	public boolean validate(String v) {
		// NI-846
		if (null != v) {
			if (v.length() > 320) {
				return false;
			}
		}
		return p.matcher(v).matches();
	}

	@Override
	public Object transform(String v) {
		return v;
	}

}
