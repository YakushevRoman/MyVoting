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
import com.example.myvoting.app.models.UserModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 */
public class ListUsersAdapter
        extends RecyclerView.Adapter<ListUsersAdapter.ListUsersHolder>{

    private List <UserModel> listUsers;

    public ListUsersAdapter() {
        listUsers = new ArrayList<>();
    }

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
        listUsersHolder.bindListUsersHolder(listUsers.get(i));
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    class ListUsersHolder
            extends RecyclerView.ViewHolder{

        private Button buttonUser;
        ListUsersHolder(@NonNull View itemView) {
            super(itemView);

            buttonUser = itemView.findViewById(R.id.button_list_users_recycler);
        }

        void bindListUsersHolder(UserModel user){
            buttonUser.setText(user.getNameUser());
        }

    }
}
