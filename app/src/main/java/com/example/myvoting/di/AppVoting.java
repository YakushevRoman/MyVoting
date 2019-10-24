package com.example.myvoting.di;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.example.myvoting.database.AppVotingDataBase;

public class AppVoting extends Application {
    private static final String TAG = "TAG";
    @SuppressLint("StaticFieldLeak")
    public static AppVoting instance;
    private Context context ;
    private AppVotingDataBase appVotingDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
        appVotingDataBase = Room
                .databaseBuilder(context, AppVotingDataBase.class, "voting.db")
                .build();
    }

    public static AppVoting getInstance() {
        return instance;
    }

    public Context getContext() {
        return context;
    }

    public AppVotingDataBase getAppVotingDataBase(){
        Log.d(TAG, "getAppVotingDataBase: ");
        return  appVotingDataBase;
    }
}
