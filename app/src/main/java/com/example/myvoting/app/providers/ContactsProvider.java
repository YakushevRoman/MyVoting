package com.example.myvoting.app.providers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.data.Daos.UsersDao;
import com.example.myvoting.data.Entities.UserEntity;
import com.example.myvoting.di.AppVoting;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
public class ContactsProvider {

    private List <UserModel> userModels;
    private ContentResolver contentResolver;
    private List <UserEntity> userEntities;

    public ContactsProvider() {
        userModels = new ArrayList<>();
        userEntities = new ArrayList<>();
        contentResolver = AppVoting
                .getInstance()
                .getAppComponent()
                .getContextModule()
                .getContentResolver();
    }

    public List<UserModel> getAllContact (){
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                        null,
                        null,
                        null,
                        null);
        if (cursor != null){
            while (cursor.moveToNext()){
                UserModel userModel = new UserModel();
                UserEntity user = new UserEntity();
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                userModel.setNameUser(name);
                user.setNameUser(name);
                userModels.add(userModel);
                userEntities.add(user);
            }
            cursor.close();

            UsersDao usersDao = AppVoting.getInstance().getAppDataBase().getUsersDao();
            usersDao.insertListUsers(userEntities);


            //Log.d("TAG", "size" + userEntities.size());
            Disposable disposable = usersDao
                    .getAllUsers()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(userEntities -> {
                        Log.d("TAG", "disposable size" + userEntities.size());
                    });
        }
        return userModels;
    }
}
