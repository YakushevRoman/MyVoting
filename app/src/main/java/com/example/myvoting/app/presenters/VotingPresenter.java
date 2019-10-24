package com.example.myvoting.app.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.app.providers.VotingProvider;
import com.example.myvoting.app.views.VotingView;

@InjectViewState
public class VotingPresenter extends MvpPresenter <VotingView> {

    public VotingPresenter() {
    }

    public void setValueVoting (int key){
        String valueVoting = null;
        switch (key){
            case 1:
                valueVoting  = VotingProvider.TEXT_THE_WORST;
                break;
            case 2:
                valueVoting  = VotingProvider.TEXT_GOOD;
                break;
            case 3:
                valueVoting  = VotingProvider.TEXT_THE_BEST;
                break;
        }
        getViewState().showResultVoting(valueVoting);
    }
}
