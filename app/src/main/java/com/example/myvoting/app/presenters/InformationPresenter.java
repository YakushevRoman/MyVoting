package com.example.myvoting.app.presenters;
/*
 *
 */
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myvoting.app.interafaces.presenterInterfaces.IInformationPresenter;
import com.example.myvoting.app.providers.InformationProvider;
import com.example.myvoting.app.views.InformationView;
import com.example.myvoting.di.AppVoting;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/**
 *
 */
@InjectViewState
public class InformationPresenter
        extends MvpPresenter<InformationView>
        implements IInformationPresenter {

    private InformationProvider informationProvider;

    public InformationPresenter() {
        informationProvider = AppVoting
                .getInstance()
                .getAppComponent()
                .getInformationProvider();
        setInformation();
    }

    @Override
    public void setInformation (){
        Disposable disposable = informationProvider
                .getInformation()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> getViewState().setInformationAboutApp(s));
   }

}
