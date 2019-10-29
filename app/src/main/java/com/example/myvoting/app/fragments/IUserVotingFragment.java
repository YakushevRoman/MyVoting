package com.example.myvoting.app.fragments;
/*
 *
 */
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myvoting.R;
import com.example.myvoting.app.enums.AppVotingEnum;
import com.example.myvoting.app.enums.TagsEnum;
import com.example.myvoting.app.presenters.UserVotingPresenter;
import com.example.myvoting.app.views.IUserVotingView;
import com.example.myvoting.di.AppVoting;

/**
 *
 */
public class IUserVotingFragment
        extends MvpAppCompatFragment
        implements IUserVotingView{

    @InjectPresenter
    UserVotingPresenter mVotingPresenter;
    private Context context;
    private int id = 4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        context = AppVoting
                .getInstance()
                .getAppComponent()
                .getContextModule();

        /*Bundle bundle = getArguments();
        assert bundle != null;
        Log.d(TagsEnum.TAG.getVotingTag(), "IUserVotingFragment" + bundle.getString(TagsEnum.BUNDLE.getVotingTag(),""));
    */
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater
                .inflate(R.layout.fragment_for_voting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnTheWorstVoting = view.findViewById(R.id.btn_the_worst_voting);
        Button btnGoodVoting = view.findViewById(R.id.btn_good_voting);
        Button btnTheBestVoting = view.findViewById(R.id.btn_the_best_voting);

        btnTheWorstVoting.setOnClickListener(v -> {
            mVotingPresenter.setValueVoting(AppVotingEnum.KEY_THE_WORST.getValue(), id);
            FragmentManager fragmentManager = getFragmentManager();
            assert fragmentManager != null;
            fragmentManager.popBackStackImmediate();
        });

        btnGoodVoting.setOnClickListener(v -> {
            mVotingPresenter.setValueVoting(AppVotingEnum.KEY_GOOD.getValue(), id);
            FragmentManager fragmentManager = getFragmentManager();
            assert fragmentManager != null;
            fragmentManager.popBackStackImmediate();
        });

        btnTheBestVoting.setOnClickListener(v -> {
            mVotingPresenter.setValueVoting(AppVotingEnum.KEY_THE_BEST.getValue(), id);
            FragmentManager fragmentManager = getFragmentManager();
            assert fragmentManager != null;
            fragmentManager.popBackStackImmediate();
        });
    }

    @Override
    public void showResultVoting(String resultVoting) {
        Toast.makeText(getContext(), resultVoting, Toast.LENGTH_SHORT).show();
    }
}


