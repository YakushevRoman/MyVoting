package com.example.myvoting.app.presenters;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.app.views.AddNewUserView;

@InjectViewState
public class AddNewUserPresenter  extends MvpPresenter <AddNewUserView> {

    public AddNewUserPresenter() {
    }

    public void showNewUser (UserModel userModel){
        getViewState().showNewUser(userModel.getNameUser());
        getViewState().setEtIsEmpty();
    }

}
