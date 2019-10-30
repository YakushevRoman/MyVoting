package com.example.myvoting.app.adapters;
/*
 *
 */
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myvoting.R;
import com.example.myvoting.app.interafaces.fragmentInterfaces.IRecyclerView;
import com.example.myvoting.app.interafaces.recyclerInterfaces.IRecycler;
import com.example.myvoting.app.models.UserModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 */
public class ListUsersAdapter
        extends RecyclerView.Adapter<ListUsersAdapter.ListUsersHolder>
        implements IRecycler {

    private List <UserModel> listUsers;
    private IRecyclerView iRecyclerView;

    public ListUsersAdapter() {
        listUsers = new ArrayList<>();
    }

    @Override
    public void addIRecyclerView (IRecyclerView iRecyclerView){
        this.iRecyclerView = iRecyclerView;
    }

    @Override
    public void setListUsersAdapter (List<UserModel> newListUsers){
        listUsers.clear();
        listUsers.addAll(newListUsers);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListUsersHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_list_users, viewGroup, false);
        return new ListUsersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUsersHolder listUsersHolder, int i) {
        listUsersHolder.bindListUsersHolder(listUsers.get(i), iRecyclerView);
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    class ListUsersHolder
            extends RecyclerView.ViewHolder {

        private Button buttonUser;
        ListUsersHolder(@NonNull View itemView) {
            super(itemView);
            buttonUser = itemView.findViewById(R.id.button_list_users_recycler);
        }

        void bindListUsersHolder(UserModel user, IRecyclerView iRecyclerView){
            buttonUser.setText(user.getNameUser());
            buttonUser.setOnClickListener( v -> iRecyclerView.showVotingFragment(user.getNameUser()));
        }
    }
}
