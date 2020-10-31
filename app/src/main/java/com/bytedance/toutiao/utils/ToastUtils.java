package com.bytedance.toutiao.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Data : 2020/10/28
 * Time : 11:02
 * Author : 刘朝阳
 */
public class ToastUtils {
    private static Context context = AppUtils.getApplication();
    /**
     * Toast对象
     */
    private static Toast toast = null;

    /**
     * 显示Toast
     *
     * @param message
     */
    public static void showToast(String message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.cancel();
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
