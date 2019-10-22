package com.example.myvoting.app.providers;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.myvoting.app.models.UserModel;

public class ListUsersViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<UserModel> mUser;

    public ListUsersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}