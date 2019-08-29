package com.learnmore.mvvm.network;

import com.learnmore.mvvm.models.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {

    @GET("posts")
    Observable<List<Post>> getPosts();
}
