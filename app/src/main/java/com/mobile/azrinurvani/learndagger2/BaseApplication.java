package com.mobile.azrinurvani.learndagger2;

import com.mobile.azrinurvani.learndagger2.di.AppComponent;
import com.mobile.azrinurvani.learndagger2.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
