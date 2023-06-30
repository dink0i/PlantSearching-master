package com.example.plantsearching.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.plantsearching.ArticleDetailActivity;
import com.example.plantsearching.Model.Article;
import com.example.plantsearching.Model.Species;
import com.example.plantsearching.PlantDetailActivity;
import com.example.plantsearching.R;

import java.util.ArrayList;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Species> data;
    LayoutInflater layoutInflater;


    public PlantAdapter(Context context, ArrayList<Species> data) {
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public PlantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.listview_plant_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Species species = data.get(position);
        Glide.with(context)
                .load(data.get(position).getImage())
                .into(holder.image);

        holder.title.setText(data.get(position).getTitle());
        holder.description.setText(data.get(position).getDescription());
        holder.kingdom.setText(data.get(position).getKingdom());
        holder.family.setText(data.get(position).getFamily());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlantDetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("plant", species);
                intent.putExtra("value", bundle);

                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView kingdom;
        TextView family;
        TextView description;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            kingdom = itemView.findViewById(R.id.kingdom);
            family = itemView.findViewById(R.id.family);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);
        }


        }

    }
