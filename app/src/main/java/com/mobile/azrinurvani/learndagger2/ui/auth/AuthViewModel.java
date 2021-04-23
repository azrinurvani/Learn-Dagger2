package com.mobile.azrinurvani.learndagger2.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.mobile.azrinurvani.learndagger2.di.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private AuthApi authApi;
    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: viewModel is Working....");

        if (this.authApi ==null){
            Log.d(TAG, "AuthViewModel: authApi is NULL");
        }else{
            Log.d(TAG, "AuthViewModel: authApi is NOT NULL");
        }


    }
}
