package com.mobile.azrinurvani.learndagger2.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    @Inject
    public ProfileViewModel() {
        Log.d(TAG, "ProfileViewModel: viewModel is working...");
    }
}