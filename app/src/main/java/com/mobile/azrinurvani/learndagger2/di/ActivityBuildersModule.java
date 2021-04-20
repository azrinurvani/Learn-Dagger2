package com.mobile.azrinurvani.learndagger2.di;

import com.mobile.azrinurvani.learndagger2.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

//Module untuk mendaftarkan activity/fragment
@Module
public abstract class ActivityBuildersModule {

    //Method atau obje yang ada pada module harus bersifat abstract atau static

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

    @Provides
    static String someString(){
        return "this is test string from inject";
    }
}
