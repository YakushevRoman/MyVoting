package com.example.myvoting.database.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.myvoting.database.Entities.ResultUserVotingEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ResultUserVotingDao {

        @Query("Select * From result_user_voting")
        Single<List<ResultUserVotingEntity>> getAllResult ();

        @Query("Select _time_result From result_user_voting")
        Single<List<String>> getAllTime ();

}
