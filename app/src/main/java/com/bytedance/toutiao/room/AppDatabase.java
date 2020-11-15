package com.bytedance.toutiao.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bytedance.toutiao.bean.User;

@Database(entities = {User.class}, version = 1) // 数据库注解，必须。entities指定实体类，version指定数据库版本
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}