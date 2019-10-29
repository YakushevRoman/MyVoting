package com.example.myvoting.app.interafaces.providerInterfaces;

import io.reactivex.Single;

/**
 *
 */
public interface IUserVotingProvider {

    void setValueUserVoting (int value, int id);
    Single<String> setToastTextUserVoting (String text);

}
