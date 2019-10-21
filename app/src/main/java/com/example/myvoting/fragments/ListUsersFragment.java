package com.example.myvoting.fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.example.myvoting.R;
import com.example.myvoting.providers.ListUsersViewModel;

public class ListUsersFragment extends Fragment {

    private ListUsersViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(ListUsersViewModel.class);

        return inflater.inflate(R.layout.list_users_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView textView = view.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final RecyclerView recyclerViewListUsersFragment = (RecyclerView) view.findViewById(R.id.recycler_list_users);

        /*recyclerViewListUsersFragment.setLayoutManager(new LinearLayoutManager(this.getContext()));
        List <User> listUsers = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setNameUser("Roman");
        listUsers.add(user);
        ListUsersAdapter listUsersAdapter = new ListUsersAdapter(listUsers);
        recyclerViewListUsersFragment.setAdapter(listUsersAdapter);*/

    }
}