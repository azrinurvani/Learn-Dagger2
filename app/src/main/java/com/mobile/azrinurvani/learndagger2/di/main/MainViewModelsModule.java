package com.mobile.azrinurvani.learndagger2.di.main;

import androidx.lifecycle.ViewModel;

import com.mobile.azrinurvani.learndagger2.di.ViewModelKey;
import com.mobile.azrinurvani.learndagger2.ui.main.post.PostViewModel;
import com.mobile.azrinurvani.learndagger2.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel profileViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    public abstract ViewModel bindPostViewModel(PostViewModel postViewModel);
}
