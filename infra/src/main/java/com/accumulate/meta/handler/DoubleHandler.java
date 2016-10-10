package com.accumulate.meta.handler;


public class DoubleHandler implements DataTypeHandler {

	@Override
	public boolean validate(String v) {
		try{
			Double.parseDouble(v);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Object transform(String v) {
		return Double.parseDouble(v);
	}

}
