package com.example.myvoting.app.fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myvoting.R;
import com.example.myvoting.app.models.UserModel;
import com.example.myvoting.app.presenters.AddNewUserPresenter;
import com.example.myvoting.app.views.AddNewUserView;
import java.util.concurrent.TimeUnit;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class AddNewUserFragment extends MvpAppCompatFragment implements AddNewUserView {

    @InjectPresenter
    AddNewUserPresenter addNewUserPresenter;

    EditText etAddNewUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataSource(10)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("Tag", "Observer " + integer);
                        etAddNewUser.setText(String.valueOf(integer));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        dataSingle(12345)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        Log.d("Tag", "Single " + integer );
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        dataFlowable(2)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer){
                        Log.d("Tag", "Single " + integer );
                    }

                });

    }
    public Observable<Integer> dataSource (final int count){
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) {
                for (int i = 0; i < count; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    emitter.onNext(i);
                }
            }
        });
    }

    public Flowable <Integer> dataFlowable (final int count){
        return Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) {
                for (int i = 0; i < count; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    emitter.onNext(i);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    public Single <Integer> dataSingle (final int count){
        return Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(SingleEmitter<Integer> emitter) {
                emitter.onSuccess(count);
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_new_user, container, false);
        // testing RxJava


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etAddNewUser = view.findViewById (R.id.et_add_new_user);
        Button  btnAddNewUser = view.findViewById(R.id.btn_add_new_user);

        btnAddNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etAddNewUser.getText().toString();
                UserModel userModel = new UserModel();
                userModel.setNameUser(userName);
                userModel.setId(1);
                addNewUserPresenter.showNewUser(userModel);
            }
        });

    }

    @Override
    public void showNewUser(String nameNewUser) {
        Toast.makeText(getContext(), nameNewUser, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUser() {

    }

    @Override
    public void setEtIsEmpty() {
        etAddNewUser.setText("");
    }
}
