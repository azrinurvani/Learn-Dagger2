package com.mobile.azrinurvani.learndagger2.ui.main.post;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.mobile.azrinurvani.learndagger2.SessionManager;
import com.mobile.azrinurvani.learndagger2.di.network.main.MainApi;

import javax.inject.Inject;

public class PostViewModel extends ViewModel {

    private SessionManager sessionManager;
    private MainApi mainApi;

    private static final String TAG = "PostViewModel";

    @Inject
    public PostViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
        Log.d(TAG, "PostViewModel: viewModel is working...");
    }

}
