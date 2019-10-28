package com.example.myvoting.di.modules;
/*
 *
 */

import com.example.myvoting.app.providers.InformationProvider;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 *
 */

@Module
public class InformationModule {

    @Provides
    @Singleton
    InformationProvider getInformationProvider (){
        return new InformationProvider();
    }

}
