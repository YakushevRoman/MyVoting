package com.example.myvoting.app.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myvoting.R;
import com.example.myvoting.app.adapters.ListUsersAdapter;
import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.app.presenters.ListViewPresenter;
import com.example.myvoting.app.providers.ListUsersViewModel;
import com.example.myvoting.app.views.ListUsersView;

import java.util.ArrayList;
import java.util.List;

public class ListUsersFragment extends MvpAppCompatFragment implements ListUsersView {

    private String LOG = "Tag";

    @InjectPresenter
    ListViewPresenter listViewPresenter;

    private ListUsersViewModel homeViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.list_users_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeViewModel =
                ViewModelProviders.of(this).get(ListUsersViewModel.class);
        final TextView textView = view.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final RecyclerView recyclerViewListUsersFragment = (RecyclerView) view.findViewById(R.id.recycler_list_users);

        recyclerViewListUsersFragment.setLayoutManager(new LinearLayoutManager(this.getContext()));
        List<UserModel> listUsers = new ArrayList<>();
        UserModel user = new UserModel();
        user.setId(1);
        user.setNameUser("Roman");
        listUsers.add(user);
        ListUsersAdapter listUsersAdapter = new ListUsersAdapter(listUsers);
        recyclerViewListUsersFragment.setAdapter(listUsersAdapter);

        textView.setOnClickListener(v -> listViewPresenter.changeTest());

    }

    @Override
    public void showMessageString(String message) {
        Log.d(LOG, message);
    }

    @Override
    public void showStartMessage(String startMessage) {
        Toast.makeText(getContext(), startMessage, Toast.LENGTH_SHORT).show();
    }
}