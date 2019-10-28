package com.example.myvoting.di.Components;

import android.content.Context;

import com.example.myvoting.app.providers.InformationProvider;
import com.example.myvoting.app.providers.TimeProvider;
import com.example.myvoting.di.modules.ContextModule;
import com.example.myvoting.di.modules.InformationModule;
import com.example.myvoting.di.modules.TimeModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {
        ContextModule.class,
        TimeModule.class,
        InformationModule.class})

public interface AppComponent {
    Context getContextModule();
    TimeProvider getTimeProvider();
    InformationProvider getInformationProvider();
}