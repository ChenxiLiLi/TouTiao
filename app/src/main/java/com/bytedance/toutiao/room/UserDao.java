package com.bytedance.toutiao.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.bytedance.toutiao.bean.User;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao{

    @Query("SELECT * FROM user")
    Single<User> getUser();

    @Query("UPDATE user SET nickname = :nickname, sex = :sex, introduction = :introduction WHERE id =:id")
    void updateUser(int id, String nickname, String sex, String introduction);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertAll(User... students);

    @Query("DELETE FROM user WHERE id = :id")
    int deleteUser(int id);
}
