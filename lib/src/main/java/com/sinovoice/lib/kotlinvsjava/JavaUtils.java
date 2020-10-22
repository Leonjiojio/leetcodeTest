package com.sinovoice.lib.kotlinvsjava;

import java.util.Optional;

/**
 * Created by liqiang on 2020/9/27.
 **/
public class JavaUtils {
        static String format(String text) {
            return text.isEmpty() ? null : text;
        }
    public int parseAndInc(String number) {
        return Optional.ofNullable(number)
                .map(Integer::parseInt)
                .map(it -> it + 1)
                .orElse(0);
    }
}
