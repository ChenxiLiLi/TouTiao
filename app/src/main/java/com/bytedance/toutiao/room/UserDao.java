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

    @Query("SELECT * FROM user WHERE username = :username")
    Single<User> findByUsername(String username);

    @Query("SELECT * FROM user")
    Single<User> getUser();

    @Query("SELECT * FROM user")
    User getUser1();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(User... students);
}
