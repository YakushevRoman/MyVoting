package com.example.myvoting.data.room.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myvoting.data.room.Entities.UserEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UsersDao {

    @Query("Select * From UserEntity")
    Single <List<UserEntity>> getAllUsers ();

    @Insert
    void insertListUsers (List <UserEntity> userEntities);
}
