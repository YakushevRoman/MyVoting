package com.example.myvoting.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.myvoting.data.Daos.VotingDao;
import com.example.myvoting.data.Entities.VotingEntity;

@Database( entities = VotingEntity.class, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract VotingDao getVotingDao ();
}
