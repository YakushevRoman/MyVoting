package com.example.myvoting.app.views;

import com.arellomobile.mvp.MvpView;
import com.example.myvoting.app.adapters.ListUsersAdapter;
import com.example.myvoting.app.models.UserModel;

import java.util.List;

public interface ListUsersView
        extends MvpView {

    void setItemsForRecyclerView (List<UserModel> list, ListUsersAdapter listUsersAdapter);
    void setStartText (String startText);

}
