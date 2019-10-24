package com.example.myvoting.app.providers;
import android.content.Context;
import com.example.myvoting.R;
import com.example.myvoting.app.models.UserModel;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Single;

/***
 *  data for list users view fragment
 */
public class ListUsersProvider {

    public Single <String> getStringForListUsers (){
        //return Single.create(emitter -> emitter.onSuccess(context.getString(R.string.text_list_users_fragment)));  This is home fragment
        return Single.create(emitter -> emitter.onSuccess("This is list fragment"));
    }

    public Single <List<UserModel>> getUserModel(){

        List<UserModel> list = new ArrayList<>();
        UserModel userModelRoman = new UserModel();
        userModelRoman.setId(1);
        userModelRoman.setNameUser("Roman");
        UserModel userModelIvan = new UserModel();
        userModelIvan.setId(2);
        userModelIvan.setNameUser("Ivan");

        list.add(userModelIvan);
        list.add(userModelRoman);

        return Single.create(emitter -> emitter.onSuccess(list));
    }
}