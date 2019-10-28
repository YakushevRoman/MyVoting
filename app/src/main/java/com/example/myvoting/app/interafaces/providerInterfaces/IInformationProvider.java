package com.example.myvoting.app.interafaces.providerInterfaces;

import io.reactivex.Single;

public interface IInformationProvider {
    Single<String> getInformation();
}
