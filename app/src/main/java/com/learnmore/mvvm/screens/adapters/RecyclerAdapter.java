package com.learnmore.mvvm.screens.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learnmore.mvvm.R;
import com.learnmore.mvvm.models.Post;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Post> mNicePlace = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.userId.setText("User Id: " + mNicePlace.get(i).getUserId().toString());
        viewHolder.id.setText("id: " + mNicePlace.get(i).getUserId().toString());
        viewHolder.title.setText("Title: " + mNicePlace.get(i).getTitle());
        viewHolder.body.setText("Body: " + mNicePlace.get(i).getText());
      /*  RequestOptions defaultOprions = new RequestOptions().error(R.drawable.ic_launcher_background);
        Glide.with(context).setDefaultRequestOptions(defaultOprions)
                .load(mNicePlace.get(i).getImageUrl())
                .into(viewHolder.mImageView);*/


    }

    @Override
    public int getItemCount() {
        return mNicePlace.size();
    }

    public void setItems(List<Post> posts) {
        mNicePlace = posts;
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // public CircleImageView mImageView;
        TextView userId;
        TextView id;
        TextView title;
        TextView body;

        public ViewHolder(View itemView) {
            super(itemView);
            //  mImageView = itemView.findViewById(R.id.circleImageView);
            userId = itemView.findViewById(R.id.textViewUserId);
            id = itemView.findViewById(R.id.textViewId);
            title = itemView.findViewById(R.id.textViewTitle);
            body = itemView.findViewById(R.id.textViewBody);

        }
    }

}
