package com.example.myvoting.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.myvoting.database.Daos.VotingDao;
import com.example.myvoting.database.Entities.VotingEntity;

@Database(  entities = VotingEntity.class,
            exportSchema = false,
            version = 2)
public abstract class AppVotingDataBase extends RoomDatabase {
    abstract VotingDao getVotingDao ();
}
