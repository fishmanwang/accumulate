package com.accumulate.bo;

import com.accumulate.utils.ObjectMapperUtil;

/**
 * Created by tjwang on 2017/1/4.
 */
public class BaseBo {

    @Override
    public String toString() {
        return ObjectMapperUtil.writePretty(this);
    }

}
