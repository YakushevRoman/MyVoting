package com.example.myvoting.app.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.app.views.ListUsersView;

@InjectViewState
public class ListViewPresenter extends MvpPresenter<ListUsersView> {

    public ListViewPresenter() {
        startMessage();
    }

     private void startMessage() {
        getViewState().showStartMessage("Start Message");
    }

    public void changeTest (){
        getViewState().showMessageString("Hello");
    }
}
