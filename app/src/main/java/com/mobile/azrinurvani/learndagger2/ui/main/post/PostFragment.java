package com.mobile.azrinurvani.learndagger2.ui.main.post;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.azrinurvani.learndagger2.R;
import com.mobile.azrinurvani.learndagger2.models.Post;
import com.mobile.azrinurvani.learndagger2.ui.Resource;
import com.mobile.azrinurvani.learndagger2.ui.main.post.adapter.PostRecyclerAdapter;
import com.mobile.azrinurvani.learndagger2.util.VerticalSpaceItemDecoration;
import com.mobile.azrinurvani.learndagger2.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostFragment extends DaggerFragment {

    private static final String TAG = "PostFragment";

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    private PostViewModel viewModel;
    private RecyclerView recyclerView;

    @Inject
    PostRecyclerAdapter adapter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    @Inject
    VerticalSpaceItemDecoration decoration;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        viewModel = ViewModelProviders.of(this,viewModelProviderFactory).get(PostViewModel.class);
        subscribeObservers();
        initRecycler();
    }


    private void subscribeObservers(){
        viewModel.observePosts().removeObservers(getViewLifecycleOwner());
        viewModel.observePosts().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                switch (listResource.status){
                    case LOADING:{
                        Log.d(TAG, "onChanged: Loading...");
                        break;
                    }
                    case SUCCESS:{
                        Log.d(TAG, "onChanged: Success got POST DATA");
                        adapter.setPosts(listResource.data);
                        break;
                    }
                    case ERROR:{
                        Log.e(TAG, "onChanged: Error : "+listResource.message);
                        break;
                    }
                }
            }
        });
    }

    private void initRecycler(){
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);
    }
}
