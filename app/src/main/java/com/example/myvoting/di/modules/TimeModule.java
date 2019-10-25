package com.example.myvoting.di.modules;

import com.example.myvoting.app.providers.TimeProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TimeModule {

    private TimeProvider timeProvider;

    public TimeModule(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    @Singleton
    @Provides
    TimeProvider getTimeProvider() {
        return timeProvider;
    }
}
