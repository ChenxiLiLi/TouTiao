package com.bytedance.toutiao.utils;

import android.content.Context;
import android.util.Log;

/**
 * Data : 2020/10/28
 * Time : 11:04
 * Author : 刘朝阳
 */
public class AppUtils {
    public static Context mContext;

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void initContext(Context context){
        mContext = context;
    }

    public static Context getApplication() {
        if (mContext!=null){
            return mContext;
        }else {
            throw new UnsupportedOperationException("context 未初始化");
        }
    }
}
