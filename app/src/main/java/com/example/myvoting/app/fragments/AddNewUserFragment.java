package com.example.myvoting.app.fragments;
/*
 *
 */
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myvoting.R;
import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.app.presenters.AddNewUserPresenter;
import com.example.myvoting.app.views.AddNewUserView;
/**
 *
 */
public class AddNewUserFragment extends MvpAppCompatFragment implements AddNewUserView {

    @InjectPresenter
    AddNewUserPresenter addNewUserPresenter;

    EditText etAddNewUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_new_user, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etAddNewUser = view.findViewById (R.id.et_add_new_user);
        Button  btnAddNewUser = view.findViewById(R.id.btn_add_new_user);


        btnAddNewUser.setOnClickListener(v -> {
            String userName = etAddNewUser.getText().toString();
            UserModel userModel = new UserModel();
            userModel.setNameUser(userName);
            addNewUserPresenter.showNewUser(userModel);
        });

    }

    @Override
    public void showNewUser(String nameNewUser) {
        Toast.makeText(getContext(), nameNewUser, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUser() {

    }

    @Override
    public void setEtIsEmpty() {
        etAddNewUser.setText("");
    }

}
