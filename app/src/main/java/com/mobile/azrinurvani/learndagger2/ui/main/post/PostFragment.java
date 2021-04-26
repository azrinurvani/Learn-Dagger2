package com.mobile.azrinurvani.learndagger2.ui.main.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.azrinurvani.learndagger2.R;
import com.mobile.azrinurvani.learndagger2.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostFragment extends DaggerFragment {

    private static final String TAG = "PostFragment";

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    private PostViewModel viewModel;
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(),"PostFragment",Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_posts,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        viewModel = ViewModelProviders.of(this,viewModelProviderFactory).get(PostViewModel.class);
    }
}
