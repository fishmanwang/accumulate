package com.accumulate.meta.handler;

public interface DataTypeHandler {
	
	boolean validate(String v);
	
	Object transform(String v);
}
