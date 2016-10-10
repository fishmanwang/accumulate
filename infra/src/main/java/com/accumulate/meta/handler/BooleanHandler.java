package com.accumulate.meta.handler;

public class BooleanHandler implements DataTypeHandler {

    @Override
    public boolean validate(String v) {
        return Boolean.parseBoolean(v);

    }

    @Override
    public Object transform(String v) {
        return Boolean.parseBoolean(v);
    }

}
