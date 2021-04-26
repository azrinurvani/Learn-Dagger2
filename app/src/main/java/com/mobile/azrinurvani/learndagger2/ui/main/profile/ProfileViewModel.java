package com.mobile.azrinurvani.learndagger2.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mobile.azrinurvani.learndagger2.SessionManager;
import com.mobile.azrinurvani.learndagger2.models.User;
import com.mobile.azrinurvani.learndagger2.ui.auth.AuthResource;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        Log.d(TAG, "ProfileViewModel: viewModel is working...");
    }

    public LiveData<AuthResource<User>> getAuthenticateUser(){
        return sessionManager.getAuthUser();
    }
}
