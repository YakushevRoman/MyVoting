package com.example.myvoting.app.providers;
/*
 *
 */
import android.util.Log;
import com.example.myvoting.app.enums.TagsEnum;
import com.example.myvoting.app.interafaces.providerInterfaces.IUserVotingProvider;
import com.example.myvoting.data.room.Daos.IVotingDao;
import com.example.myvoting.data.room.Entities.VotingEntity;
import com.example.myvoting.di.AppVoting;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/**
 *
 */
public class UserVotingProvider
        implements IUserVotingProvider {

    private final IVotingDao IVotingDao;
    private final TimeProviderProvider timeProvider;

    public UserVotingProvider() {

        IVotingDao = AppVoting
                .getInstance()
                .getAppComponent()
                .getAppDataBase()
                .getVotingDao();

        timeProvider = AppVoting
                .getInstance()
                .getAppComponent()
                .getTimeProvider();
    }

    @Override
    public void setValueUserVoting(int value, int id) {
        VotingEntity votingEntity = new VotingEntity();
        votingEntity.idUser = id;
        votingEntity.answer = value;
        votingEntity.currentDate = timeProvider.getCurrentDate();
        votingEntity.currentTime = timeProvider.getCurrentTime();
        IVotingDao.insertVoting(votingEntity);
        showResultQuery();
    }

    @Override
    public Single<String> setToastTextUserVoting(String text) {
        return Single.just(text);
    }


    private void showResultQuery (){
        Disposable disposable = IVotingDao
                .getAllResultVoting()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(votingEntities -> {
                    for (VotingEntity entity: votingEntities) {
                        Log.d(TagsEnum.TAG.getVotingTag(), String.format(
                                "Id : %s , " + "Id user : %s , " + "Answer user : %s, " + "Current time %s, " + "Current date : %s",
                                entity.uid, entity.idUser, entity.answer, entity.currentTime, entity.currentDate));
                    }
                });
        disposable.isDisposed();
    }
}
