package com.mobile.azrinurvani.learndagger2.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.mobile.azrinurvani.learndagger2.di.network.auth.AuthApi;
import com.mobile.azrinurvani.learndagger2.models.User;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private AuthApi authApi;
    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: viewModel is Working....");

        authApi.getUser(1)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull User user) {
                        Log.d(TAG, "onNext: "+user.getEmail());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError: ",e );
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
