package com.learnmore.mvvm.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.learnmore.mvvm.models.Comment;
import com.learnmore.mvvm.models.NicePlace;
import com.learnmore.mvvm.models.Post;
import com.learnmore.mvvm.network.ServicesClass;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class NicePlaceRepo {

    private static NicePlaceRepo instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();
    ServicesClass servicesClass = new ServicesClass();

    public static NicePlaceRepo getInstance() {
        if (instance == null) {
            instance = new NicePlaceRepo();
        }
        return instance;
    }

    // pretend to get data from webservices
    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        setNicePlaces();


        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;

    }

    // for call service
    public Observable<List<Post>> getPosts() {
        return servicesClass.getPosts();

    }

    public Observable<List<Comment>> getComments(int id) {
        return servicesClass.getSpecificComments(id);

    }

    private void setNicePlaces() {
        dataSet.add(
                new NicePlace("title 1", "https://thumbs-prod.si-cdn.com/N-_fU5xNOvR2T25teuPAdtGkBhY=/800x600/filters:no_upscale()/https://public-media.si-cdn.com/filer/90/b2/90b2dfe5-a9ab-4821-9ccc-45ae1d52fa8a/blackholewithclouds_c-1-941x519.jpg"));
        dataSet.add(new NicePlace("title 2", "https://www.w3schools.com/howto/img_nature_wide.jpg"));
        dataSet.add(new NicePlace("title 3", "https://ichef.bbci.co.uk/news/660/cpsprodpb/10D88/production/_103600096_mediaitem103600095.jpg"));
        dataSet.add(new NicePlace("title 4", "https://www.w3schools.com/howto/img_nature_wide.jpg"));
        dataSet.add(new NicePlace("title 5", "https://ichef.bbci.co.uk/news/660/cpsprodpb/10D88/production/_103600096_mediaitem103600095.jpg"));
        dataSet.add(new NicePlace("title 6", "https://www.w3schools.com/howto/img_nature_wide.jpg"));
        dataSet.add(new NicePlace("title 7", "https://ichef.bbci.co.uk/news/660/cpsprodpb/10D88/production/_103600096_mediaitem103600095.jpg"));
        dataSet.add(new NicePlace("title 8", "https://www.w3schools.com/howto/img_nature_wide.jpg"));

    }

}
