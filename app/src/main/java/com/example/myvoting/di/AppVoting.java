package com.example.myvoting.di;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.myvoting.app.providers.ContactsProvider;
import com.example.myvoting.app.providers.TimeProvider;
import com.example.myvoting.data.AppDataBase;
import com.example.myvoting.di.Components.AppComponent;
import com.example.myvoting.di.Components.DaggerAppComponent;
import com.example.myvoting.di.modules.ContextModule;
import com.example.myvoting.di.modules.TimeModule;

public class AppVoting extends Application {
    private static final String TAG = "TAG";
    @SuppressLint("StaticFieldLeak")
    private static AppVoting instance;
    private Context context ;
    private AppDataBase appDataBase;

    private static AppComponent appComponent;

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

        appComponent = DaggerAppComponent
                .builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .timeModule(new TimeModule(new TimeProvider()))
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

    public AppComponent getAppComponent(){
        return appComponent;
    }

}
