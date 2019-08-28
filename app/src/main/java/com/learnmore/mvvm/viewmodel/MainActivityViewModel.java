package com.learnmore.mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.learnmore.mvvm.models.NicePlace;
import com.learnmore.mvvm.repositories.NicePlaceRepo;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<List<NicePlace>> mNicePlaces;
    private NicePlaceRepo repo;
    MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();


    public void init() {
        if (mNicePlaces != null) {
            return;
        }
        repo = new NicePlaceRepo();
        mNicePlaces = repo.getNicePlaces();
    }

    public void addNewValue(final NicePlace nicePlace) {
        mIsUpdating.setValue(true);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                List<NicePlace> currentPlaces = mNicePlaces.getValue();
                currentPlaces.add(nicePlace);
                mIsUpdating.postValue(false);
                super.onPostExecute(aVoid);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

    }

    public LiveData<List<NicePlace>> getNicePlaces() {
        return mNicePlaces;
    }

    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }
}
