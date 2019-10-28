package com.example.myvoting.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.myvoting.data.room.Daos.UsersDao;
import com.example.myvoting.data.room.Daos.VotingDao;
import com.example.myvoting.data.room.Entities.UserEntity;
import com.example.myvoting.data.room.Entities.VotingEntity;

@Database(  entities = {VotingEntity.class, UserEntity.class},
            version = 1,
            exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract VotingDao getVotingDao ();
    public abstract UsersDao getUsersDao();
}
