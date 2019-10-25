package com.example.myvoting.app.providers;
import android.content.Context;
import com.example.myvoting.R;
import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.di.AppVoting;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.Single;

/***
 *  data for list users view fragment
 */
public class ListUsersProvider {

    public Single <String> getStringForListUsers (){
        String information = AppVoting
                .getInstance()
                .getContext()
                .getResources()
                .getString(R.string.text_list_users_fragment);
        return Single.create(emitter -> emitter.onSuccess(information));
    }

    public Single <List<UserModel>> getUserModel(){
        ContactsProvider contactsProvider = new ContactsProvider();
        contactsProvider.getAllContact();
        return Single.create(emitter -> emitter.onSuccess(contactsProvider.getAllContact()));
    }
}