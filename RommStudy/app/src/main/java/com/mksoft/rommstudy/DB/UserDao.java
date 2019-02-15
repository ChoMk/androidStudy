package com.mksoft.rommstudy.DB;


import com.mksoft.rommstudy.dataType.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface UserDao {

    @Query("SELECT * FROM user_table")
    List<User> getAll();

    @Query("SELECT * FROM user_table WHERE user_major IN (:major)")
    List<User> getAllByMajor(String major);

    @Query("SELECT * FROM user_table WHERE user_name IN(:name)")
    List<User> getAllByName(String name);

    @Query("SELECT * FROM user_table WHERE user_age IN(:age)")
    List<User> getAllByAge(int age);

    @Insert(onConflict = REPLACE)
    void insertUser(User user);

    @Query("DELETE from user_table")
    void deleteAll();


}
