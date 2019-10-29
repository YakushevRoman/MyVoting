package com.example.myvoting.app.presenters;
/*
 *
 */
import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.R;
import com.example.myvoting.app.interafaces.presenterInterfaces.IUserVotingPresenter;
import com.example.myvoting.app.providers.UserVotingProvider;
import com.example.myvoting.app.views.UserVotingView;
import com.example.myvoting.di.AppVoting;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
@InjectViewState
public class UserVotingPresenter
        extends MvpPresenter<UserVotingView>
        implements IUserVotingPresenter {

    private UserVotingProvider userVotingProvider;
    private Context context;

    public UserVotingPresenter() {
        userVotingProvider = AppVoting
                .getInstance()
                .getAppComponent()
                .getUserVotingProvider();
        context =AppVoting
                .getInstance()
                .getAppComponent()
                .getContextModule();
    }


    @Override
    public void setValueVoting(int key, int bundleID) {
        userVotingProvider.setValueUserVoting(key, bundleID);
        setTextUserVoting();
    }

    @Override
    public void setTextUserVoting() {
        Disposable disposable = userVotingProvider
                .setToastTextUserVoting(context.getString(R.string.text_for_user_voting))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( s -> getViewState().showResultVoting(s));
        disposable.isDisposed();
    }
}
