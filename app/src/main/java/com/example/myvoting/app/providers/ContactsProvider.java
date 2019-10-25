package com.example.myvoting.app.providers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.di.AppVoting;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class ContactsProvider {

    private List <UserModel> userModels;
    private ContentResolver contentResolver;

    public ContactsProvider() {
        userModels = new ArrayList<>();
        contentResolver = AppVoting
                .getInstance()
                .getContext()
                .getContentResolver();
    }

    public List<UserModel> getAllContact (){
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null,null,null,null);
        if (cursor != null){
            while (cursor.moveToNext()){
                UserModel userModel = new UserModel();
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                userModel.setNameUser(name);
                userModels.add(userModel);
            }
            cursor.close();
        }
        return userModels;
    }
}
