package com.example.myvoting.di.modules;

import com.example.myvoting.app.providers.TimeProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TimeModule {

    @Singleton
    @Provides
    TimeProvider getTimeProvider() {
        return new TimeProvider();
    }
}
