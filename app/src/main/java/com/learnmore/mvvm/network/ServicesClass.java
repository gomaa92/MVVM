package com.learnmore.mvvm.network;

import com.learnmore.mvvm.models.Post;

import java.util.List;

import io.reactivex.Observable;

public class ServicesClass {
    private JsonPlaceholderApi jsonPlaceholderApi;

    public ServicesClass() {
        jsonPlaceholderApi = RetrofitClient.getRetrofitInstance().create(JsonPlaceholderApi.class);
    }

    public Observable<List<Post>> getPosts() {
        return jsonPlaceholderApi.getPosts();


    }

    /*
    * final MutableLiveData<List<Post>> postMutableLiveData = new MutableLiveData<>();

        Observable<List<Post>> postObservable = jsonPlaceholderApi.getPosts();
        postObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        postMutableLiveData.postValue(posts);

                    }

                    @Override
                    public void onError(Throwable e) {
                        // handel error here

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return postMutableLiveData;*/
}
