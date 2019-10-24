package com.example.myvoting.app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.example.myvoting.R;
import com.example.myvoting.app.presenters.InformationPresenter;
import com.example.myvoting.app.views.InformationView;

public class InformationFragment extends MvpAppCompatFragment implements InformationView {

    @InjectPresenter (type = PresenterType.LOCAL)
    InformationPresenter informationPresenter;
    private TextView mInformationTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.information_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInformationTextView = view.findViewById(R.id.txt_information);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setInformationAboutApp(String information) {
        mInformationTextView.setText(information);
    }
}
