package com.mobile.azrinurvani.learndagger2.di;

import com.mobile.azrinurvani.learndagger2.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

//Module untuk mendaftarkan activity/fragment
@Module
public abstract class ActivityBuildersModule {

    //Method atau object yang ada pada module yang berisi ContributeAndroidInjector (Bind Activity)
    // harus bersifat abstract atau static

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();


}
