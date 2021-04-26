package com.mobile.azrinurvani.learndagger2.di;

import com.mobile.azrinurvani.learndagger2.di.auth.AuthModule;
import com.mobile.azrinurvani.learndagger2.di.auth.AuthViewModelsModule;
import com.mobile.azrinurvani.learndagger2.di.main.MainFragmentBuildersModule;
import com.mobile.azrinurvani.learndagger2.di.main.MainModule;
import com.mobile.azrinurvani.learndagger2.di.main.MainViewModelsModule;
import com.mobile.azrinurvani.learndagger2.ui.auth.AuthActivity;
import com.mobile.azrinurvani.learndagger2.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

//Module untuk mendaftarkan activity/fragment
@Module
public abstract class ActivityBuildersModule {

    //Method atau object yang ada pada module yang berisi ContributeAndroidInjector (Bind Activity)
    // harus bersifat abstract atau static

    @ContributesAndroidInjector(
            //sub component Auth
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();


    @ContributesAndroidInjector(
        modules = {
                MainFragmentBuildersModule.class,
                MainViewModelsModule.class,
                MainModule.class
        }
    )
    abstract MainActivity contributeMainActivity();
}
