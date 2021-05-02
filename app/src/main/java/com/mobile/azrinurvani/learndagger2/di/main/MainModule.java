package com.mobile.azrinurvani.learndagger2.di.main;

import android.app.Application;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.mobile.azrinurvani.learndagger2.di.network.main.MainApi;
import com.mobile.azrinurvani.learndagger2.ui.main.post.adapter.PostRecyclerAdapter;
import com.mobile.azrinurvani.learndagger2.util.VerticalSpaceItemDecoration;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @MainScope
    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }

    @MainScope
    @Provides
    static PostRecyclerAdapter providePostRecyclerAdapter(){
        return new PostRecyclerAdapter();
    }

    @MainScope
    @Provides
    static LinearLayoutManager provideLinearLayoutManager(Application application){
        return new LinearLayoutManager(application);
    }

    @MainScope
    @Provides
    static VerticalSpaceItemDecoration provideVerticalItemDecoration(){
        return new VerticalSpaceItemDecoration(15);
    }
}
