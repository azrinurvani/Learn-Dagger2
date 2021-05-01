package com.mobile.azrinurvani.learndagger2.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.mobile.azrinurvani.learndagger2.BaseActivity;
import com.mobile.azrinurvani.learndagger2.R;
import com.mobile.azrinurvani.learndagger2.ui.main.post.PostFragment;
import com.mobile.azrinurvani.learndagger2.ui.main.profile.ProfileFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        init();
    }

    private void init(){
        //setup hamburger icon (nav icon) in side
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);
        navigationView.setNavigationItemSelectedListener(this);
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
            //untuk handle apabila navigation drawer tampil atau dibuka tidak bisa kembali menutup ketika di clik
            case android.R.id.home : {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }else{
                    return false;
                }
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_profile : {

                //berfungsi untuk clear backstack agar setiap clik button back di android tidak kembali ke halaman yang sama, atau halaman dia sendiri
                NavOptions navOptions = new NavOptions.Builder()
                        .setPopUpTo(R.id.nav_graph,true)
                        .build();

                Navigation.findNavController(this,R.id.nav_host_fragment).navigate(
                        R.id.profileFragment,
                        null,
                        navOptions
                );
                break;
            }
            case R.id.nav_post : {

                if (isValidDestination(R.id.postFragment)){
                    Navigation.findNavController(this,R.id.nav_host_fragment).navigate(R.id.postFragment);
                }
                break;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        item.setChecked(true);
        return true;
    }

    //Untuk handle apabila icon hamburger (navigation drawer) dan icon back tidak berfungsi apabila di clik
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.nav_host_fragment),drawerLayout);
    }

    //method untuk memastikan apakah NavigationController yang dituju adalah PostFragment (id berdasarkan nav_graph)
    private boolean isValidDestination(int destination){
        return destination != Navigation.findNavController(this,R.id.nav_host_fragment).getCurrentDestination().getId();
    }
}
