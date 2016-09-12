package com.accumulate.base;

import com.accumulate.utils.ObjectMapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.Serializable;

public class BaseDTO implements Serializable {

	@Override
	public String toString() {
		try {
			return ObjectMapperUtil.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return super.toString();
		}
	}
}
