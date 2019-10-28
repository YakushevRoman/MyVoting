package com.example.myvoting.di;
/*
 *
 */
import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
import android.util.Log;
import com.example.myvoting.data.AppDataBase;
import com.example.myvoting.di.Components.AppComponent;
import com.example.myvoting.di.Components.DaggerAppComponent;
import com.example.myvoting.di.modules.ContextModule;
/**
 *
 */

public class AppVoting extends Application {

    @SuppressLint("StaticFieldLeak")
    private static AppVoting instance;
    private AppDataBase appDataBase;
    private static AppComponent appComponent;
    private static final String NAME_DATABASE = "voting.db";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "create db");

        instance = this;

        appComponent = DaggerAppComponent
                .builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();

        appDataBase = Room
                .databaseBuilder(getApplicationContext(), AppDataBase.class, NAME_DATABASE)
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

    public AppDataBase getAppDataBase(){
        return  appDataBase;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

}
