package com.mobile.azrinurvani.learndagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

//    Syarat agar bisa inject dari suatu object mesti ada provides atau bind di module dan module tersebut di daftar di AppComponent
//    @Inject
//    String testString;

    //Contoh Inject Tipe Application
    // Application bisa di inject pada AuthActivity dikarenakan sudah memiliki BindInstance di AppComponent dan disediakan
    // annotation @Provide pada AppModule
    // Yang diinject harus sesuai dengan tipe data atau jenis dari object tersebut
//    @Inject
//    boolean isAppNull;

    @Inject
    RequestManager requestManager;

    @Inject
    Drawable logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
//        Log.d(TAG, "onCreate: String ->"+testString);
//        Log.d(TAG, "onCreate: IsAppNull ? "+isAppNull);

        setLogo();
    }

    private void setLogo(){
        requestManager.load(logo)
                .into((ImageView)findViewById(R.id.login_logo));
    }
}