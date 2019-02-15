package com.mksoft.rommstudy.dataType;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    public User() {
        this.userName = "";
        this.userMajor = "";
        this.age = -1;
    }


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_name")
    public String userName;

    @ColumnInfo(name = "user_major")
    public String userMajor;

    @ColumnInfo(name = "user_age")
    public int age;


}
