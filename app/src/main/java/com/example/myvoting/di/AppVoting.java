package com.example.myvoting.di;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.myvoting.data.AppDataBase;

public class AppVoting extends Application {
    private static final String TAG = "TAG";
    @SuppressLint("StaticFieldLeak")
    public static AppVoting instance;
    private Context context ;
    private AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "create db");
        instance = this;
        context = getApplicationContext();
        appDataBase = Room
                .databaseBuilder(context, AppDataBase.class, "voting.db")
                .allowMainThreadQueries()
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Log.d("TAG", "onCreate(db)");
                    }

                    @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                        super.onOpen(db);
                        Log.d("TAG", "onOpen(db)");
                    }
                })
                .build();

    }

    public static AppVoting getInstance() {
        return instance;
    }

    public Context getContext() {
        return context;
    }

    public AppDataBase getAppDataBase(){
        return  appDataBase;
    }

}
