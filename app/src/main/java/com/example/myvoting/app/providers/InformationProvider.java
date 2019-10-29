package com.example.myvoting.app.providers;
/*
 *
 */
import com.example.myvoting.R;
import com.example.myvoting.app.interafaces.providerInterfaces.IInformationProvider;
import com.example.myvoting.di.AppVoting;
import io.reactivex.Single;
/**
 *
 */
public class InformationProvider
        implements IInformationProvider {

    @Override
    public Single<String> getInformation() {
        String information = AppVoting
                .getInstance()
                .getAppComponent()
                .getContextModule()
                .getResources()
                .getString(R.string.information);
        return Single.create(emitter -> emitter.onSuccess(information));
    }

}



