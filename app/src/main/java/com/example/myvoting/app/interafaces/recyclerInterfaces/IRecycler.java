package com.example.myvoting.app.interafaces.recyclerInterfaces;

import com.example.myvoting.app.interafaces.fragmentInterfaces.IRecyclerView;
import com.example.myvoting.app.models.UserModel;

import java.util.List;

public interface IRecycler {
     void addIRecyclerView (IRecyclerView iRecyclerView);
     void setListUsersAdapter (List<UserModel> newListUsers);
}
