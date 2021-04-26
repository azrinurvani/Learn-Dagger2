package com.mobile.azrinurvani.learndagger2.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mobile.azrinurvani.learndagger2.R;
import com.mobile.azrinurvani.learndagger2.models.User;
import com.mobile.azrinurvani.learndagger2.ui.auth.AuthResource;
import com.mobile.azrinurvani.learndagger2.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private static final String TAG = "ProfileFragment";

    private ProfileViewModel viewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    private TextView name,email,website;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(),"ProfileFragment",Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ProfileFragment was created...");

        name = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        website = view.findViewById(R.id.website);
        viewModel = ViewModelProviders.of(this,viewModelProviderFactory).get(ProfileViewModel.class);

        subscribeObservers();
    }

    private void subscribeObservers(){
        //Pada fragment mesti removeObservers terlebih dahulu dengan parameter getViewLifecycleOwner
        //karena pada Fragment memiliki lifecycle yang berbeda dengan activity baik berupa onDestroy, reCreated dan semacamnya pada android system
        // sehingga untuk memastikan apakah observer sebelumnya di hapus maka harus melakukan tahap ini atau menggunakan method
        // removeObservers(getViewLifecycleOwner) di Fragment sebelum di assign ke data lain
        viewModel.getAuthenticateUser().removeObservers(getViewLifecycleOwner());
        viewModel.getAuthenticateUser().observe(getViewLifecycleOwner(), new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource!=null){
                    switch (userAuthResource.status){
                        case AUTHENTICATED:{
                            setUserDeatails(userAuthResource.data);
                            break;
                        }
                        case ERROR:{
                            setErrorDetails(userAuthResource.message);
                            break;
                        }
                    }
                }
            }
        });
    }

    private void setErrorDetails(String message) {
        name.setText(message);
        email.setText("Error");
        website.setText("Error");
    }

    private void setUserDeatails(User data) {
        name.setText(data.getName());
        email.setText(data.getEmail());
        website.setText(data.getWebsite());
    }
}
