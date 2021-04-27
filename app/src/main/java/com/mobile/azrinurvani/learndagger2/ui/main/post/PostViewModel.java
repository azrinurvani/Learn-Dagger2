package com.mobile.azrinurvani.learndagger2.ui.main.post;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.mobile.azrinurvani.learndagger2.SessionManager;
import com.mobile.azrinurvani.learndagger2.di.network.main.MainApi;
import com.mobile.azrinurvani.learndagger2.models.Post;
import com.mobile.azrinurvani.learndagger2.ui.Resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {

    private SessionManager sessionManager;
    private MainApi mainApi;

    private static final String TAG = "PostViewModel";

    private MediatorLiveData<Resource<List<Post>>> postMediatorLiveData;

    @Inject
    public PostViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
        Log.d(TAG, "PostViewModel: viewModel is working...");
    }

    public LiveData<Resource<List<Post>>> observePosts(){
        if (postMediatorLiveData==null){
            postMediatorLiveData = new MediatorLiveData<>();
            postMediatorLiveData.setValue(Resource.loading(null));

            final LiveData<Resource<List<Post>>> source = LiveDataReactiveStreams.fromPublisher(
                mainApi.getPostsFromUser(sessionManager.getAuthUser().getValue().data.getId())
                    .onErrorReturn(new Function<Throwable, List<Post>>() {
                        @NonNull
                        @Override
                        public List<Post> apply(@NonNull Throwable throwable) throws Exception {
                            Log.e(TAG, "apply: ", throwable);
                            Post post = new Post();
                            post.setId(-1);
                            ArrayList<Post> postArrayList =new ArrayList<>();
                            postArrayList.add(post);
                            return postArrayList;
                        }
                    })
                    .map(new Function<List<Post>, Resource<List<Post>>>() {
                        @NonNull
                        @Override
                        public Resource<List<Post>> apply(@NonNull List<Post> posts) throws Exception {
                            if (posts.size()>0){
                                if (posts.get(0).getId()==-1){
                                    return Resource.error("Something went wrong...",null);
                                }
                            }
                            return Resource.success(posts);
                        }
                    })
                    .subscribeOn(Schedulers.io())
            );

            postMediatorLiveData.addSource(source, new Observer<Resource<List<Post>>>() {
                @Override
                public void onChanged(Resource<List<Post>> listResource) {
                    postMediatorLiveData.setValue(listResource);
                    postMediatorLiveData.removeSource(source);
                }
            });
        }
        return postMediatorLiveData;
    }

}
