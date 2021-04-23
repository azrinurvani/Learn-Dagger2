package com.mobile.azrinurvani.learndagger2.di;

import com.mobile.azrinurvani.learndagger2.di.auth.AuthModule;
import com.mobile.azrinurvani.learndagger2.di.auth.AuthViewModelsModule;
import com.mobile.azrinurvani.learndagger2.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

//Module untuk mendaftarkan activity/fragment
@Module
public abstract class ActivityBuildersModule {

    //Method atau object yang ada pada module yang berisi ContributeAndroidInjector (Bind Activity)
    // harus bersifat abstract atau static

    @ContributesAndroidInjector(
            //sub component Auth
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();


}
