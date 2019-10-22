package com.example.myvoting.app.views;

import com.arellomobile.mvp.MvpView;

public interface ListUsersView extends MvpView {
    void showMessageString (String message);
    void showStartMessage (String startMessage);
}
