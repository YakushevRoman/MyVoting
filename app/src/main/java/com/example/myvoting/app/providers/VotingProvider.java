package com.example.myvoting.app.providers;

import android.util.Log;
import com.example.myvoting.data.Daos.VotingDao;
import com.example.myvoting.data.Entities.VotingEntity;
import com.example.myvoting.di.AppVoting;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VotingProvider {
    public static final int  KEY_THE_WORST = 1;
    public static final int  KEY_GOOD = 2;
    public static final int  KEY_THE_BEST = 3;
    //
    //public static final String TEXT_THE_WORST = "The_worst";
    //public static final String TEXT_GOOD = "Good";
    //public static final String TEXT_THE_BEST = "The_best";
    private static final String TAG =  "TAG";
    private final VotingDao votingDao;

    public VotingProvider() {
        votingDao = AppVoting
                .getInstance()
                .getAppDataBase()
                .getVotingDao();
    }

    public void setVotingValue (int value) {
        VotingEntity votingEntity = new VotingEntity();
        votingEntity.idUser = 1;
        votingEntity.answer = value;
        votingEntity.time = " 11:11:11";
        votingDao.insertVoting(votingEntity);

        Disposable disposable = votingDao.getAllResultVoting()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(votingEntities -> {
                    Log.d(TAG, "setVotingValue: " +votingEntities.size());
                });
    }

}
