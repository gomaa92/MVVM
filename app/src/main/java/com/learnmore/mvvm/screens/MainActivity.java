package com.learnmore.mvvm.screens;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.learnmore.mvvm.R;
import com.learnmore.mvvm.adapters.RecyclerAdapter;
import com.learnmore.mvvm.models.Post;
import com.learnmore.mvvm.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ProgressBar progressBar;
    private MainActivityViewModel mainActivityViewModel;
    List<Post> myPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        myPosts = new ArrayList<>();

      /*  mainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(@Nullable List<NicePlace> nicePlaces) {
                adapter.notifyDataSetChanged();
            }
        });*/

        mainActivityViewModel.posts.subscribe(posts -> {
            for (Post post : posts) {
                myPosts.add(post);
                adapter.notifyDataSetChanged();
            }
        });



     /*   mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    showProgressBar();
                } else {
                    hideProgressBar();
                    recyclerView.smoothScrollToPosition(mainActivityViewModel.getNicePlaces().getValue().size() - 1);
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mainActivityViewModel.addNewValue(new NicePlace("title ", "https://www.w3schools.com/howto/img_nature_wide.jpg"));
            }
        });*/

        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new RecyclerAdapter(this, myPosts);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
