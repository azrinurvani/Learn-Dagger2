package com.mobile.azrinurvani.learndagger2.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.mobile.azrinurvani.learndagger2.R;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    //    Pada setiap depedency mesti dibikin static karena itu rekomendasi dari Dokumentasi dari Dagger2
    @Provides
    static RequestOptions provideRequestOptions(){
        return RequestOptions.placeholderOf(R.drawable.white_background)
                .error(R.drawable.white_background);
    }

    // Untuk parameter application dan requestOptions bisa diakses dikarenakan sudah di @Provides atau di BindsInstance sebelumnya
    @Provides
    static RequestManager provideGlideInstance(Application application,RequestOptions requestOptions){
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Provides
    static Drawable provideAppDrawable(Application application){
        return ContextCompat.getDrawable(application,R.drawable.logo);
    }


//    @Provides
//    static String someString(){
//        return "this is test string from inject";
//    }
//
//    @Provides
//    static boolean getApp(Application application){
//        return application == null;
//    }
}
