package com.mobile.azrinurvani.learndagger2.ui.auth;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;
import com.mobile.azrinurvani.learndagger2.BaseActivity;
import com.mobile.azrinurvani.learndagger2.R;
import com.mobile.azrinurvani.learndagger2.models.User;
import com.mobile.azrinurvani.learndagger2.ui.main.MainActivity;
import com.mobile.azrinurvani.learndagger2.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;
import javax.inject.Named;

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
    private ProgressBar progressBar;

    //untuk pengujian scoping
    @Inject
    @Named("app-user")
    User user1;

    @Inject
    @Named("auth-user")
    User user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
//        Log.d(TAG, "onCreate: String ->"+testString);
//        Log.d(TAG, "onCreate: IsAppNull ? "+isAppNull);
        userId = findViewById(R.id.user_id_input);
        progressBar = findViewById(R.id.progress_bar);

        findViewById(R.id.login_button).setOnClickListener(this);

        viewModel = ViewModelProviders.of(this,providerFactory).get(AuthViewModel.class);

        setLogo();
        subscribeObserver();

        Log.d(TAG, "onCreate: user singleton -> "+user1);
        Log.d(TAG, "onCreate: user auth -> "+user2);
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
        viewModel.observeAuthState().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource!=null){
                    switch (userAuthResource.status){
                        case LOADING: {
                            showProgressBar(true);
                            break;
                        }

                        case ERROR: {
                            showProgressBar(false);
                            Log.e(TAG, "onChanged: error "+userAuthResource.message );
                            Toast.makeText(AuthActivity.this,userAuthResource.message+
                                    "\nDid you enter a number between 1 and 10?",Toast.LENGTH_LONG).show();
                            break;
                        }
                        case AUTHENTICATED: {
                            showProgressBar(false);
                            Log.d(TAG, "onChanged: "+userAuthResource.data.getEmail());
                            onLoginSuccess();
                            break;
                        }

                            case NOT_AUTHENTICATED: {
                            showProgressBar(false);
                            break;
                        }

                    }
                }
            }
        });
    }

    private void onLoginSuccess(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showProgressBar(boolean isVisible){
        if (isVisible){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

}