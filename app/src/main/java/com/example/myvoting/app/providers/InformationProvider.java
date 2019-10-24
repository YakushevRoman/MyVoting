package com.example.myvoting.app.providers;


import android.content.Context;

import com.example.myvoting.R;
import com.example.myvoting.di.AppVoting;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 *
 */
public class InformationProvider {

    public Single<String> getInformation (){
        String information = AppVoting.instance
                .getContext()
                .getResources()
                .getString(R.string.information);
        return Single.create(emitter -> emitter.onSuccess(information));
    }
}



