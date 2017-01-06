package com.accumulate.domain.check;

import com.accumulate.domain.PolicyTip;

/**
 * Created by tjwang on 2017/1/4.
 */
public interface ConstraintCheck {

    PolicyTip check(String password);
}
