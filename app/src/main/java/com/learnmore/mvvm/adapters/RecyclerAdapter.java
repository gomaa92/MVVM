package com.learnmore.mvvm.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.learnmore.mvvm.R;
import com.learnmore.mvvm.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<NicePlace> mNicePlace = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(Context context, List<NicePlace> mNicePlace) {
        this.mNicePlace = mNicePlace;
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
        viewHolder.mName.setText(mNicePlace.get(i).getTitle());
        RequestOptions defaultOprions = new RequestOptions().error(R.drawable.ic_launcher_background);
        Glide.with(context).setDefaultRequestOptions(defaultOprions)
                .load(mNicePlace.get(i).getImageUrl())
                .into(viewHolder.mImageView);


    }

    @Override
    public int getItemCount() {
        return mNicePlace.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView mImageView;
        public TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.circleImageView);
            mName = itemView.findViewById(R.id.textViewName);

        }
    }

}
