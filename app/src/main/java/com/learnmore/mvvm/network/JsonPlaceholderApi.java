package com.learnmore.mvvm.network;

import com.learnmore.mvvm.models.Post;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {

    @GET("posts")
    Observable<ArrayList<Post>> getPosts();
}
