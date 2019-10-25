package com.example.myvoting.app.fragments;

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
import com.example.myvoting.app.providers.VotingProvider;
import com.example.myvoting.app.presenters.VotingPresenter;
import com.example.myvoting.app.views.VotingView;

public class VotingFragment extends MvpAppCompatFragment implements VotingView {

    @InjectPresenter
    VotingPresenter mVotingPresenter;

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

        btnTheWorstVoting.setOnClickListener(v -> mVotingPresenter.setValueVoting(VotingProvider.KEY_THE_WORST));

        btnGoodVoting.setOnClickListener(v -> mVotingPresenter.setValueVoting(VotingProvider.KEY_GOOD));

        btnTheBestVoting.setOnClickListener(v -> mVotingPresenter.setValueVoting(VotingProvider.KEY_THE_BEST));


    }

    @Override
    public void showResultVoting(int resultVoting) {
        Toast.makeText(getContext(), String.valueOf(resultVoting), Toast.LENGTH_SHORT).show();
    }
}
