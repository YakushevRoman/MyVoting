package com.example.myvoting.di.modules;

import com.example.myvoting.app.providers.UserVotingProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class UserVotingModule {

    @Provides
    UserVotingProvider getUser(){
        return new UserVotingProvider();
    }
}
