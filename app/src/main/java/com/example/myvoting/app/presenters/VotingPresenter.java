package com.example.myvoting.app.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.app.providers.VotingProvider;
import com.example.myvoting.app.views.VotingView;

@InjectViewState
public class VotingPresenter extends MvpPresenter <VotingView> {

    private VotingProvider votingProvider;

    public VotingPresenter() {
        votingProvider = new VotingProvider();
    }

    public void setValueVoting (int key){
        votingProvider.setVotingValue(key);
        getViewState().showResultVoting(key);
    }
}
