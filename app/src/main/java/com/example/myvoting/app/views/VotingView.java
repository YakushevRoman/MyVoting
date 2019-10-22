package com.example.myvoting.app.views;

import com.arellomobile.mvp.MvpView;
import com.example.myvoting.app.models.UserModel;

public interface VotingView extends MvpView {
    void showResultVoting (String resultVoting);

}
