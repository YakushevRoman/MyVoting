package com.example.myvoting.app.providers;

import com.example.myvoting.R;
import com.example.myvoting.di.AppVoting;
import io.reactivex.Single;

/**
 *
 */
public class InformationProvider {

    public Single<String> getInformation (){

        String information = AppVoting
                .getInstance()
                .getAppComponent()
                .getContextModule()
                .getResources()
                .getString(R.string.information);

        return Single.create(emitter -> emitter.onSuccess(information));
    }
}



