package com.example.myvoting.app.views;

import com.arellomobile.mvp.MvpView;
import com.example.myvoting.app.models.UserModel;

public interface AddNewUserView extends MvpView {
    void showNewUser (String nameNewUser);
    void setUser ();
    void setEtIsEmpty();
}
