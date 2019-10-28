package com.example.myvoting.app.providers;
/*
 *
 */
import android.util.Log;
import com.example.myvoting.app.enums.TagsEnum;
import com.example.myvoting.app.interafaces.providerInterfaces.IUserVotingProvider;
import com.example.myvoting.data.room.Daos.VotingDao;
import com.example.myvoting.data.room.Entities.VotingEntity;
import com.example.myvoting.di.AppVoting;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/**
 *
 */
public class UserVotingProvider implements IUserVotingProvider {

    private final VotingDao votingDao;
    private TimeProviderProvider timeProvider;

    public UserVotingProvider() {
        votingDao = AppVoting
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
    public void setUserVotingValue(int value) {
        VotingEntity votingEntity = new VotingEntity();
        votingEntity.idUser = 2;
        votingEntity.answer = value;
        votingEntity.currentDate = timeProvider.getCurrentDate();
        votingEntity.currentTime = timeProvider.getCurrentTime();
        votingDao.insertVoting(votingEntity);
        showResultQuery();
    }

    private void showResultQuery (){
        Disposable disposable = votingDao
                .getAllResultVoting()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(votingEntities -> {
                    for (VotingEntity entity:
                            votingEntities) {
                        Log.d(TagsEnum.TAG.getVotingTag(), String.format(
                                "Id : %s , " + "Id user : %s , " + "Answer user : %s, " + "Current time %s, " + "Current date : %s",
                                entity.uid, entity.idUser, entity.answer, entity.currentTime, entity.currentDate));
                    }
                });
    }

}
