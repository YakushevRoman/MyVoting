package com.example.myvoting.data.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myvoting.data.Entities.VotingEntity;

import java.util.List;
import io.reactivex.Single;

@Dao
public interface VotingDao {

    @Query("Select * from VotingEntity")
    Single<List<VotingEntity>> getAllResultVoting ();

    @Insert
    void insertVoting (VotingEntity votingEntity);
}
