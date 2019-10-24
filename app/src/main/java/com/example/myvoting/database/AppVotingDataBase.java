package com.example.myvoting.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.myvoting.database.Daos.ResultUserVotingDao;
import com.example.myvoting.database.Entities.ResultUserVotingEntity;

@Database(  entities = ResultUserVotingEntity.class,
            exportSchema = false,
            version = 1)
public abstract class AppVotingDataBase extends RoomDatabase {
    abstract ResultUserVotingDao getResultUserVotingDao();
}
