package com.example.myvoting.app.fragments;
/*
 *
 */
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
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myvoting.R;
import com.example.myvoting.app.adapters.ListUsersAdapter;
import com.example.myvoting.app.enums.TagsEnum;
import com.example.myvoting.app.interafaces.IRecyclerView;
import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.app.presenters.ListViewPresenter;
import com.example.myvoting.app.views.IListUsersView;
import java.util.List;
/**
 *
 */
public class IListUsersFragment
        extends MvpAppCompatFragment
        implements IListUsersView{

    private TextView textView;
    private RecyclerView recyclerViewListUsersFragment;

    @InjectPresenter
    ListViewPresenter listViewPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_users_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewListUsersFragment = (RecyclerView) view.findViewById(R.id.recycler_list_users);
        textView = view.findViewById(R.id.text_home);
    }


    @Override
    public void setItemsForRecyclerView(List<UserModel> list, ListUsersAdapter listUsersAdapter) {
        recyclerViewListUsersFragment.setLayoutManager(new LinearLayoutManager(this.getContext()));
        listUsersAdapter.setListUsersAdapter(list);
        listUsersAdapter.addIRecyclerView(userName -> {
            Log.d(TagsEnum.TAG.getVotingTag(), userName);
        });
        recyclerViewListUsersFragment.setAdapter(listUsersAdapter);
    }

    @Override
    public void setStartText(String startText) {
        textView.setText(startText);
    }

}