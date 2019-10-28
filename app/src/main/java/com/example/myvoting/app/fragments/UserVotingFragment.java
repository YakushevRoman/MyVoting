package com.example.myvoting.app.fragments;
/*
 *
 */
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myvoting.R;
import com.example.myvoting.app.enums.TagsEnum;
import com.example.myvoting.app.enums.AppVotingEnum;
import com.example.myvoting.app.presenters.UserVotingPresenter;
import com.example.myvoting.app.views.UserVotingView;
/**
 *
 */
public class UserVotingFragment extends MvpAppCompatFragment implements UserVotingView {

    @InjectPresenter
    UserVotingPresenter mVotingPresenter;

    private Bundle bundle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_for_voting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnTheWorstVoting = view.findViewById(R.id.btn_the_worst_voting);
        Button btnGoodVoting = view.findViewById(R.id.btn_good_voting);
        Button btnTheBestVoting = view.findViewById(R.id.btn_the_best_voting);

        btnTheWorstVoting.setOnClickListener(v -> mVotingPresenter
                .setValueVoting(AppVotingEnum.KEY_THE_WORST.getValue(), 1));

        btnGoodVoting.setOnClickListener(v -> mVotingPresenter
                .setValueVoting(AppVotingEnum.KEY_GOOD.getValue(), 2));

        btnTheBestVoting.setOnClickListener(v -> mVotingPresenter
                .setValueVoting(AppVotingEnum.KEY_THE_BEST.getValue(), 3));


    }

    @Override
    public void showResultVoting(int resultVoting) {
        Toast.makeText(getContext(), TagsEnum.TAG.getVotingTag(), Toast.LENGTH_SHORT).show();
    }
}
