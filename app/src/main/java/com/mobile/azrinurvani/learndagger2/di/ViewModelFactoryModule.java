package com.mobile.azrinurvani.learndagger2.di;

import androidx.lifecycle.ViewModelProvider;

import com.mobile.azrinurvani.learndagger2.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);

    //bentuk lain bind ViewModelProviderFactory
//    @Provides
//    public static ViewModelProvider.Factory bindViewModelFactory2(ViewModelProviderFactory modelProviderFactory){
//        return modelProviderFactory;
//    }
}
