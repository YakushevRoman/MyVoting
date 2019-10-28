package com.example.myvoting.di.Components;
/*
 *
 */
import android.content.Context;
import com.example.myvoting.app.providers.InformationProvider;
import com.example.myvoting.app.providers.TimeProviderProvider;
import com.example.myvoting.app.providers.UserVotingProvider;
import com.example.myvoting.data.AppDataBase;
import com.example.myvoting.di.modules.ContextModule;
import com.example.myvoting.di.modules.InformationModule;
import com.example.myvoting.di.modules.RoomModule;
import com.example.myvoting.di.modules.TimeModule;
import com.example.myvoting.di.modules.UserVotingModule;
import javax.inject.Singleton;
import dagger.Component;
/**
 *
 */
@Singleton
@Component(modules = {
        ContextModule.class,
        TimeModule.class,
        InformationModule.class,
        UserVotingModule.class,
        RoomModule.class})

public interface AppComponent {
    Context getContextModule();
    TimeProviderProvider getTimeProvider();
    InformationProvider getInformationProvider();
    UserVotingProvider getUserVotingProvider();
    AppDataBase getAppDataBase();
}