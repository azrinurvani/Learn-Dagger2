package com.mobile.azrinurvani.learndagger2.di.main;


import com.mobile.azrinurvani.learndagger2.ui.main.post.PostFragment;
import com.mobile.azrinurvani.learndagger2.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector(
            //modules = {MainViewModelsModule.class}
    )
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector(
    )
    abstract PostFragment contributePostFragment();



}
