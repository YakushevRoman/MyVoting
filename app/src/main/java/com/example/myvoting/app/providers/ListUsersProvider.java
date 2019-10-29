package com.example.myvoting.app.providers;
/*
 *
 */
import com.example.myvoting.R;
import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.data.room.Daos.UsersDao;
import com.example.myvoting.di.AppVoting;
import java.util.List;
import io.reactivex.Single;
/***
 *  data for list users view fragment
 */
public class ListUsersProvider {
    //private UsersDao usersDao;

    public ListUsersProvider() {
        /*usersDao = AppVoting
                .getInstance()
                .getAppComponent()
                .getAppDataBase()
                .getUsersDao();*/
    }

    public Single <String> getStringForListUsers (){

        String information = AppVoting
                .getInstance()
                .getAppComponent()
                .getContextModule()
                .getResources()
                .getString(R.string.text_list_users_fragment);

        return Single.create(emitter -> emitter.onSuccess(information));
    }

    public Single <List<UserModel>> getUserModel(){

        ContactsProvider contactsProvider = new ContactsProvider();

        return Single.create(emitter -> emitter.onSuccess(contactsProvider.getAllContact()));
    }

}