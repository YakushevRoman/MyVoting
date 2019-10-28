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
import com.example.myvoting.di.modules.RoomModule;

/**
 *
 */

public class AppVoting extends Application {

    @SuppressLint("StaticFieldLeak")
    private static AppVoting instance;
    private static AppComponent appComponent;
    private static final String NAME_DATABASE = "voting.db";

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        appComponent = DaggerAppComponent
                .builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .roomModule(new RoomModule(getApplicationContext(),NAME_DATABASE))
                .build();
    }

    public static AppVoting getInstance() {
        return instance;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

}
