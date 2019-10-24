package com.example.myvoting.app.providers;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.myvoting.database.AppVotingDataBase;
import com.example.myvoting.database.Daos.VotingDao;
import com.example.myvoting.di.AppVoting;

import java.util.List;

public class VotingProvider {
    public static final int  KEY_THE_BEST = 3;
    public static final int  KEY_GOOD = 2;
    public static final int  KEY_THE_WORST = 1;
    //
    public static final String TEXT_THE_BEST = "The_best";
    public static final String TEXT_GOOD = "Good";
    public static final String TEXT_THE_WORST = "The_worst";

    AppVotingDataBase appVotingDataBase = AppVoting.getInstance().getAppVotingDataBase();
    //appVotingDataBase.get

}
