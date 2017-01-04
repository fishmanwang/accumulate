package com.accumulate.bo.password.check;


import com.accumulate.bo.password.ConstraintCheck;
import com.accumulate.bo.password.PolicyTip;

import java.util.HashMap;
import java.util.Map;

/**
 * 重复次数检查
 * Created by tjwang on 2017/1/4.
 */
public class RepeatConstraintCheck implements ConstraintCheck {

    private int maxRepeatCharacter;

    public RepeatConstraintCheck(int maxRepeatCharacter) {
        this.maxRepeatCharacter = maxRepeatCharacter;
    }

    public PolicyTip check(String password) {
        char[] chars = password.toCharArray();
        Map<Character, Integer> distinctChars = new HashMap<Character, Integer>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int num = 0;
            if (distinctChars.containsKey(c)) {
                num = distinctChars.get(c);
                distinctChars.remove(c);
            }
            num++;
            distinctChars.put(c, num);
        }

        for (Character c : distinctChars.keySet()) {
            int num = distinctChars.get(c);
            if (num > maxRepeatCharacter) {
                return new PolicyTip(String.format("字符 %c 重复出现%d次，超过%d次",
                        c, num, maxRepeatCharacter), false);
            }
        }
//        IntStream stream = password.chars();
//        IntStream distinctStream = stream.distinct();
//        Stream<Tuple2> numStream = distinctStream.mapToObj(f -> {
//            char c = (char) f;
//            return new Tuple2(c, password.chars().filter(a -> a == f).count());
//        });
//        StringBuilder sb = new StringBuilder();
//        Optional<Tuple2>  tuple2 = numStream.filter(n -> n.num > maxRepeatCharacter).findFirst();
//        if (tuple2.isPresent()) {
//            return new PolicyTip(String.format("字符 %c 重复出现%d次，超过%d次.",
//                    tuple2.get().c, tuple2.get().num, maxRepeatCharacter), false);
//        }

        return PolicyTip.pass();
    }

    class Tuple2 {
        char c;
        long num;

        Tuple2(char c, long num) {
            this.c = c;
            this.num = num;
        }
    }
}
