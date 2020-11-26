package com.bytedance.toutiao.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.bytedance.toutiao.bean.User;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao{

    @Query("SELECT * FROM user WHERE id = :id")
    Single<User> findById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(User... students);
}
