package com.example.myvoting.app.presenters;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.app.views.IAddNewUserView;

@InjectViewState
public class AddNewUserPresenter
        extends MvpPresenter <IAddNewUserView> {

    public AddNewUserPresenter() {
    }

    public void showNewUser (UserModel userModel){
        getViewState().showNewUser(userModel.getNameUser());
        getViewState().setEtIsEmpty();
    }

}
