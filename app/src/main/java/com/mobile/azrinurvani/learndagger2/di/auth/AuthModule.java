package com.mobile.azrinurvani.learndagger2.di.auth;

import com.mobile.azrinurvani.learndagger2.di.network.auth.AuthApi;
import com.mobile.azrinurvani.learndagger2.models.User;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }


    //Scoping berfungsi sebagai membatasi penggunaan resource dari setiap depedency
    // depedency akan dijalankan atau akan selalu aktif sesuai dengan scope nya masing-masing
    // pada kali ini untuk sebagai contoh akan menggunakan depedency User yang ada di AuthScope dan Singleton Scope
    // untuk membuktikannya bisa menggunakan log debug, untuk melihat address memory nya ketika di inject pada class lain
    @AuthScope
    @Provides
    @Named("auth-user")
    static User someUser(){
        return new User();
    }

}
