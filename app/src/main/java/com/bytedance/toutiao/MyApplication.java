package com.bytedance.toutiao;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.room.AppDatabase;
import com.bytedance.toutiao.utils.AppUtils;

/**
 * Data : 2020/10/29
 * Time : 16:19
 * Author : 刘朝阳
 */
public class MyApplication extends Application {
    private static MyApplication context;
    private static AppDatabase db;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        AppUtils.initContext(this);
        initDb();

    }

    private void initDb() {
        // 这里初始化room
        db = Room.databaseBuilder(this,
                AppDatabase.class, "database-name").build();
    }

    public static AppDatabase getDb() {
        return db;
    }

    public static Context getContext() {
        return context;
    }
}
