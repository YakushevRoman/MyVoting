package com.example.myvoting.data.room.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myvoting.data.room.Entities.VotingEntity;

import java.util.List;
import io.reactivex.Single;

@Dao
public interface IVotingDao {

    @Query("Select * from VotingEntity")
    Single<List<VotingEntity>> getAllResultVoting ();

    @Query("Select * From VotingEntity Where idUser = :idUser")
    Single<List<VotingEntity>> getUserResultVoting (int idUser);

    @Insert
    void insertVoting (VotingEntity votingEntity);
}
