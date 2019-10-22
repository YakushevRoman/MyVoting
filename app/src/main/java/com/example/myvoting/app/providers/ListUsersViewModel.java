package com.example.myvoting.app.providers;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.myvoting.app.models.User;

public class ListUsersViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<User> mUser;

    public ListUsersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}