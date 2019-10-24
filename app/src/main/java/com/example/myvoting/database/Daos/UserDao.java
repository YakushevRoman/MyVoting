package com.example.myvoting.database.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.myvoting.database.Entities.UserEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("Select * From user_entity")
    Single<List<UserEntity>> getAllUsers ();
}
