package com.example.myvoting.app.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.app.providers.InformationProvider;
import com.example.myvoting.app.views.InformationView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class InformationPresenter extends MvpPresenter<InformationView>{

    private InformationProvider informationProvider;

    public InformationPresenter() {
        informationProvider = getInformationProvider();
        setInformation();
    }

    private InformationProvider getInformationProvider (){
        return new InformationProvider();
    }

    private void setInformation (){
        Disposable disposable = informationProvider
               .getInformation()
               .subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(s -> getViewState().setInformationAboutApp(s));
   }
}
