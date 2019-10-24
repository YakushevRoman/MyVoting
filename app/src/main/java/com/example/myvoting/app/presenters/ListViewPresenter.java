package com.example.myvoting.app.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.app.adapters.ListUsersAdapter;
import com.example.myvoting.app.providers.ListUsersProvider;
import com.example.myvoting.app.views.ListUsersView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ListViewPresenter extends MvpPresenter<ListUsersView> {

    private ListUsersProvider listUsersViewModel;
    public ListViewPresenter() {
        listUsersViewModel = getListUsersViewModel();
        startMessage();
        //setItemsForRecyclerView();
    }

    private ListUsersProvider getListUsersViewModel (){
        return new ListUsersProvider();
    }

     private void startMessage() {

        Disposable disposable = listUsersViewModel
                .getStringForListUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> getViewState().setStartText(s));

    }

    public  void setItemsForRecyclerView (){
        ListUsersAdapter listUsersAdapter = new ListUsersAdapter();
        Disposable disposable = listUsersViewModel
                .getUserModel()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userModels -> getViewState().setItemsForRecyclerView(userModels, listUsersAdapter));
    }



    private ListUsersAdapter setAdapterForRecyclerView (){
        return new ListUsersAdapter();
    }
}
