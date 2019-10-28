package com.example.myvoting.di.modules;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.myvoting.data.AppDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private Context context;
    private String nameDataBase;

    public RoomModule(Context context, String nameDataBase) {
        this.context = context;
        this.nameDataBase = nameDataBase;
    }

    @Provides
    @Singleton
    AppDataBase getAppDataBase (){
        return Room
                .databaseBuilder(context, AppDataBase.class, nameDataBase)
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
                }).build();
    }
}
