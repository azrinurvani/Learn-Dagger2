package com.mobile.azrinurvani.learndagger2.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mobile.azrinurvani.learndagger2.BaseActivity;
import com.mobile.azrinurvani.learndagger2.R;
import com.mobile.azrinurvani.learndagger2.ui.main.post.PostFragment;
import com.mobile.azrinurvani.learndagger2.ui.main.profile.ProfileFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testFragment();
    }

    private void testFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container,new PostFragment())
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout :{
                sessionManager.logout();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
