package com.accumulate.bo.password.check;


import com.accumulate.bo.password.ConstraintCheck;
import com.accumulate.bo.password.PolicyTip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

/**
 * 黑名单检查
 * <pre>
 *     目前解决方案是直接在 bannedUrl 中保存单词内容
 * </pre>
 * Created by tjwang on 2017/1/4.
 */
public class BannedConstraintCheck implements ConstraintCheck {

    private String bannedUrl;

    private static final Logger logger = LoggerFactory.getLogger(BannedConstraintCheck.class);

    public BannedConstraintCheck(String bannedUrl) {
        this.bannedUrl = bannedUrl;
    }

    public PolicyTip check(String password) {
        if (null == bannedUrl) {
            return PolicyTip.pass();
        }
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bannedUrl.trim().getBytes("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bis));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 不区分大小写
                if (line.toLowerCase().contains(password.toLowerCase())) {
                    return new PolicyTip("密码已列入黑名单", false);
                }
            }
//            long num = bufferedReader.lines().filter(p -> p.contains(password)).count();
//            if (num > 0) {
//                return new PolicyTip("密码已列入黑名单", false);
//            }

            String[] words = bannedUrl.trim().split("\\s+");
            for (String word : words) {
                if (password.toLowerCase().contains(word.toLowerCase())) {
                    return new PolicyTip(String.format("密码中【%s】已列入黑名单", word),
                            false);
                }
            }

        } catch (Exception ex) {
            logger.error("", ex);
            logger.warn("黑名单资源 {} 不存在", bannedUrl);
        }

        return PolicyTip.pass();
    }
}
