package com.example.myvoting.database.Entities;

import android.arch.persistence.room.Entity;

@Entity (tableName = "user_entity")
public class UserEntity {

    private long id;
    private String name;
}
