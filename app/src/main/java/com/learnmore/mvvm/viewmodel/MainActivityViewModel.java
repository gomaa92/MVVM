package com.learnmore.mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.learnmore.mvvm.models.NicePlace;
import com.learnmore.mvvm.models.Post;
import com.learnmore.mvvm.repositories.NicePlaceRepo;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

import static android.support.constraint.Constraints.TAG;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<List<NicePlace>> mNicePlaces;
    private NicePlaceRepo repo;
    MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();
    public PublishSubject<List<Post>> posts = PublishSubject.create();


    public void init() {
        if (mNicePlaces != null) {
            return;
        }
        repo = new NicePlaceRepo();
        mNicePlaces = repo.getNicePlaces();
    }


    /*
    public Observable<List<Post>> getPosts() {
        return repo.getPosts();
    }*/

    public void getPosts() {

        repo.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                   // Log.e(TAG, "getPosts: "+it.get(0).getTitle() );
                    posts.onNext(it);
                }, Throwable::printStackTrace);

    }






   /* public void addNewValue(final NicePlace nicePlace) {
        mIsUpdating.setValue(true);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlaces = mNicePlaces.getValue();
                currentPlaces.add(nicePlace);
                mNicePlaces.postValue(currentPlaces);
                mIsUpdating.postValue(false);

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
        }.execute();

    }*/

    public LiveData<List<NicePlace>> getNicePlaces() {
        return mNicePlaces;
    }

    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }
}
