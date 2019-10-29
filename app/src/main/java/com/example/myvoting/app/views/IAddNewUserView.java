package com.example.myvoting.app.views;

import com.arellomobile.mvp.MvpView;

public interface IAddNewUserView
        extends MvpView {

    void showNewUser (String nameNewUser);
    void setUser ();
    void setEtIsEmpty();

}
