package com.mobile.azrinurvani.learndagger2.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

//    Pada setiap depedency mesti dibikin static karena itu rekomendasi dari Dokumentasi dari Dagger2
    @Provides
    static String someString(){
        return "this is test string from inject";
    }

    @Provides
    static boolean getApp(Application application){
        return application == null;
    }
}
