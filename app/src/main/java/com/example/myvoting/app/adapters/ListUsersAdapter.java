package com.example.myvoting.app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myvoting.R;
import com.example.myvoting.app.models.User;

import java.util.List;

public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersAdapter.ListUsersHolder>{
    private List <User> listUsers;


    public ListUsersAdapter(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    @NonNull
    @Override
    public ListUsersHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_list_users, viewGroup, false);
        return new ListUsersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUsersHolder listUsersHolder, int i) {
        listUsersHolder.bindListUsersHolder(listUsers.get(i));
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    class ListUsersHolder extends RecyclerView.ViewHolder{
        private Button buttonUser;
        public ListUsersHolder(@NonNull View itemView) {
            super(itemView);

            buttonUser = itemView.findViewById(R.id.button_list_users_recycler);
        }

        public void bindListUsersHolder (User user){
            buttonUser.setText(user.getNameUser());
        }

    }
}
