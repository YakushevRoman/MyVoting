package com.example.myvoting.database.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myvoting.database.Entities.VotingEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface VotingDao {
    @Query("Select * From voting_entity")
    Single <List<VotingEntity>> getAllVoList();

    @Insert
    void insert (List<VotingEntity> votingEntities);
}
