package com.accumulate.meta.handler;

import java.util.regex.Pattern;

public class MobileHandler implements DataTypeHandler {
	private static Pattern p = Pattern
			.compile("^[0-9]{11}$");

	@Override
	public boolean validate(String v) {
		return p.matcher(v).matches();
	}

	@Override
	public Object transform(String v) {
		return v;
	}

}
