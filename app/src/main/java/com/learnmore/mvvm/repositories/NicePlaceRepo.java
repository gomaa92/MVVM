package com.learnmore.mvvm.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.learnmore.mvvm.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepo {

    private static NicePlaceRepo instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

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

    private void setNicePlaces() {
        dataSet.add(new NicePlace());
        dataSet.add(new NicePlace());
        dataSet.add(new NicePlace());
        dataSet.add(new NicePlace());
        dataSet.add(new NicePlace());
        dataSet.add(new NicePlace());
        dataSet.add(new NicePlace());
        dataSet.add(new NicePlace());

    }

}
