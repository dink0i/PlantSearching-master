package com.example.plantsearching.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.plantsearching.R;

import java.util.ArrayList;

public class PhotographyAdapter extends RecyclerView.Adapter<PhotographyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> data;
    LayoutInflater layoutInflater;

    public PhotographyAdapter(Context context, ArrayList<String>data){
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.listview_photography_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.image)
                .load(data.get(position))
                .into(holder.image);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

        }
    }
}
