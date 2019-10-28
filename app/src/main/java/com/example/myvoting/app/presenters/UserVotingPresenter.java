package com.example.myvoting.app.presenters;
/*
 *
 */
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.app.interafaces.presenterInterfaces.IUserVotingPresenter;
import com.example.myvoting.app.providers.UserVotingProvider;
import com.example.myvoting.app.views.UserVotingView;
import com.example.myvoting.di.AppVoting;
/**
 *
 */
@InjectViewState
public class UserVotingPresenter extends MvpPresenter<UserVotingView> implements IUserVotingPresenter {

    private UserVotingProvider userVotingProvider;

    public UserVotingPresenter() {
        userVotingProvider = AppVoting
                .getInstance()
                .getAppComponent()
                .getUserVotingProvider();
    }


    @Override
    public void setValueVoting(int key, int bundleID) {
        userVotingProvider.setUserVotingValue(key, bundleID);
        getViewState().showResultVoting(key);
    }
}
