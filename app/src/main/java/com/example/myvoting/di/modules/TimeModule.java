package com.example.myvoting.di.modules;

import com.example.myvoting.app.providers.TimeProviderProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TimeModule {

    @Singleton
    @Provides
    TimeProviderProvider getTimeProvider() {
        return new TimeProviderProvider();
    }
}
