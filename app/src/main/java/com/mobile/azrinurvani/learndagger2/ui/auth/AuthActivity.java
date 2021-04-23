package com.mobile.azrinurvani.learndagger2.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.mobile.azrinurvani.learndagger2.R;
import com.mobile.azrinurvani.learndagger2.models.User;
import com.mobile.azrinurvani.learndagger2.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

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

    @Inject
    ViewModelProviderFactory providerFactory;

    private AuthViewModel viewModel;

    private EditText userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
//        Log.d(TAG, "onCreate: String ->"+testString);
//        Log.d(TAG, "onCreate: IsAppNull ? "+isAppNull);
        userId = findViewById(R.id.user_id_input);

        findViewById(R.id.login_button).setOnClickListener(this);

        viewModel = ViewModelProviders.of(this,providerFactory).get(AuthViewModel.class);

        setLogo();
        subscribeObserver();
    }

    private void setLogo(){
        requestManager.load(logo)
                .into((ImageView)findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.login_button : {
                attemptingLogin();
                break;
            }
        }
    }

    private void attemptingLogin() {
        if (TextUtils.isEmpty(userId.getText().toString())){
            return;
        }
        viewModel.authenticateWithId(Integer.parseInt(userId.getText().toString()));
    }

    private void subscribeObserver(){
        viewModel.observeUser().observe(this, new Observer<User>() {

            @Override
            public void onChanged(User user) {
                if (user !=null){
                    Log.d(TAG, "onChanged: "+user.getEmail());
                }
            }
        });
    }

}