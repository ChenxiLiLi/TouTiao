package com.bytedance.toutiao.utils;

import android.util.Log;

/**
 * author: Mr.Chen
 */
public class NumberUtil {

    public static String conver(Long num) {
        StringBuffer sb = new StringBuffer();
        if (num < 0) {
            sb.append(0);
            Log.w("warning: {}", "the num is illegal");
        }
        if (num < 1000) {
            sb.append(num);
        } else {
            if (num < 100000) {
                sb.append(num/1000).append("k");
            } else {
                sb.append("100k+");
            }
        }
        return sb.toString();
    }

}
